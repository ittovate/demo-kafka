package com.example.kafkademo.controller;

import static com.example.kafkademo.constant.APIResponseConstant.ORDER_SENT_MESSAGE;

import com.example.kafkademo.model.generated.Order;
import com.example.kafkademo.service.OrderAvroService;
import com.example.kafkademo.service.OrderService;
import com.example.kafkademo.util.APIResponse;
import com.example.kafkademo.util.ResponseUtil;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("api/v1/orders")
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
    @PostMapping("/sync/avro")
    public APIResponse<String> makeOrderSync(@RequestBody Order order)
            throws InterruptedException {
        orderAvroService.sendKafkaEventSync(order);

        return ResponseUtil.createUnifiedResponse(HttpStatus.OK.value(),
                ORDER_SENT_MESSAGE,null);
    }

    /**
     * synchronously sends profile details in String format.
     *
     * @return ResponseEntity with APIResponse and status
     */
    @PostMapping("/sync/{customerEmail}")
    public APIResponse<String> makeOrderSync(@PathVariable String customerEmail)
            throws InterruptedException {
        orderService.makeOrderSync(customerEmail);
        return ResponseUtil.createUnifiedResponse(HttpStatus.OK.value(),
                ORDER_SENT_MESSAGE,null);
    }

    /**
     * Asynchronously sends profile details in String format.
     *
     * @return ResponseEntity with APIResponse and status
     */
    @PostMapping("/async/{customerEmail}")
    public APIResponse<String> makeOrderAsync(@PathVariable String customerEmail) {
        orderService.makeOrderAsync(customerEmail);
        return ResponseUtil.createUnifiedResponse(HttpStatus.OK.value(),
                ORDER_SENT_MESSAGE,null);
    }

}
