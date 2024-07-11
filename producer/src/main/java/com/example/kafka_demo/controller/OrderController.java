package com.example.kafka_demo.controller;

import com.example.kafka_demo.service.OrderService;
import com.example.kafka_demo.util.APIResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutionException;

@RestController
public class OrderController {
    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/sync/{customerEmail}")
    public ResponseEntity<APIResponse<String>> makeOrderSync(@PathVariable String customerEmail) {
        orderService.makeOrderSync(customerEmail);
        APIResponse<String> apiResponse = APIResponse.success(null,
                "Order to " + customerEmail + " sent successfully!");
        return new ResponseEntity<>(apiResponse,HttpStatus.OK);
    }
    @GetMapping("/async/{customerEmail}")
    public APIResponse<String> makeOrderAsync(@PathVariable String customerEmail) {
        orderService.makeOrderAsync(customerEmail);
        return APIResponse
                .success(null,
                        "Order to " + customerEmail + " sent successfully!");
    }
}
