package com.example.webstoretask1.service;


import com.example.webstoretask1.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;
    public void getOrders(List<Integer> list) {
        orderRepository.getAllOrders(list);
    }

}
