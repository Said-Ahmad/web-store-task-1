package com.example.webstoretask1.controller;


import com.example.webstoretask1.service.OrderService;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/orders")
public class Controller {
    private final OrderService orderService;

    @GetMapping()
    @PostConstruct()
    public ResponseEntity<Void> getProducts() {
        List<Integer> list = Arrays.asList(10,11,14,15);
        orderService.getOrders(list);
        return ResponseEntity.ok().build();
    }


}
