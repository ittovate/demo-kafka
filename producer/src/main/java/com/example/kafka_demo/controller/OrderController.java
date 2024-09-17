package com.example.kafka_demo.controller;

import com.example.kafka_demo.model.generated.Order;
import com.example.kafka_demo.service.OrderAvroService;
import com.example.kafka_demo.service.OrderService;
import com.example.kafka_demo.util.APIResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;

@RestController
@RequestMapping("/orders")
public class OrderController {
    private final OrderService orderService;
    private final OrderAvroService orderAvroService;

    public OrderController(OrderService orderService,OrderAvroService orderAvroService) {
        this.orderService = orderService;
        this.orderAvroService = orderAvroService;
    }

    /**
     * synchronously sends order details in AVRO format.
     *
     * @return ResponseEntity with APIResponse and status
     */
    @PostMapping("/avro/sync")
    public ResponseEntity<APIResponse<String>> makeOrderSync(@RequestBody Order order)
            throws ExecutionException, InterruptedException, TimeoutException {
        orderAvroService.sendKafkaEventSync(order);

        APIResponse<String> apiResponse = APIResponse.success(null,
                "Order to " + order + " sent successfully!");
        return new ResponseEntity<>(apiResponse,HttpStatus.OK);
    }

    /**
     * synchronously sends profile details in String format.
     *
     * @return ResponseEntity with APIResponse and status
     */
    @GetMapping("/sync/{customerEmail}")
    public ResponseEntity<APIResponse<String>> makeOrderSync(@PathVariable String customerEmail) {
        orderService.makeOrderSync(customerEmail);
        APIResponse<String> apiResponse = APIResponse.success(null,
                "Order to " + customerEmail + " sent successfully!");
        return new ResponseEntity<>(apiResponse,HttpStatus.OK);
    }

    /**
     * Asynchronously sends profile details in String format.
     *
     * @return ResponseEntity with APIResponse and status
     */
    @GetMapping("/async/{customerEmail}")
    public ResponseEntity<APIResponse<String> >  makeOrderAsync(@PathVariable String customerEmail) {
        orderService.makeOrderAsync(customerEmail);
        APIResponse<String> apiResponse = APIResponse.success(null,
                "Order to " + customerEmail + " sent successfully!");
        return new ResponseEntity<>(apiResponse,HttpStatus.OK);
    }

}
