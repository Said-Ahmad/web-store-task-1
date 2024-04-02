package com.example.webstoretask1.repository;

import com.example.webstoretask1.utils.Util;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@RequiredArgsConstructor
@Repository
public class OrderRepository {
    public final Util util;


    public void getAllOrders(List<Integer> list) {


        String query = "SELECT " +
                "    o.id AS order_id, " +
                "    p.id AS product_id, " +
                "    p.name AS product_name, " +
                "    array_agg(ar.name) AS additional_racks, " +
                "    r.name AS rack_name, " +
                "    o.number_of_order AS order_number, " +
                "    COUNT(DISTINCT pio.id) AS order_count " +
                "FROM " +
                "    test.products_in_order pio " +
                "        INNER JOIN " +
                "    test.orders o ON pio.order_id = o.id " +
                "        INNER JOIN " +
                "    test.products p ON pio.product_id = p.id " +
                "        LEFT JOIN " +
                "    test.products_and_Additional_racks pa ON p.id = pa.product_id " +
                "        LEFT JOIN " +
                "    test.additional_racks ar ON pa.additional_racks_id = ar.id " +
                "        LEFT JOIN " +
                "    test.racks r ON p.rack_id = r.id " +
                "WHERE o.number_of_order = ? " +
                "GROUP BY " +
                "    p.id, p.name, r.name, o.id, o.number_of_order " +
                "ORDER BY " +
                "    o.number_of_order;";


        try (Connection connection = util.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)

        ) {
            System.out.println("Order assembly page: " + list.toString().replaceAll("\\[", "").replaceAll("]",""));
//            for (Integer value: list
//                 ) {
//                System.out.print(value+" ");
//            }
            for (Integer index : list) {

                System.out.println("Request param (order_id): " + index);
                preparedStatement.setInt(1, index);
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    int order_id = resultSet.getInt("order_id");
                    int product_id = resultSet.getInt("product_id");
                    String product_name = resultSet.getString("product_name");
                    String additional_racks = resultSet.getString("additional_racks");
                    String rack_name = resultSet.getString("rack_name");
                    int order_number = resultSet.getInt("order_number");
                    int order_count = resultSet.getInt("order_count");

                    System.out.println("===Rack Name: " + rack_name);
                    System.out.println("Product Name: " + product_name);
                    System.out.println("Product ID: (" + product_id + ")");
                    System.out.println("Order Number: " + order_number);
                    System.out.println("Product Count: " + order_count + " (item)");
                    System.out.println("Additional Racks: " + additional_racks);
                    //System.out.println("Order ID: " + order_id);
                    System.out.println();
                }
                System.out.println("---------------------------------------");
            }


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


    }


}
