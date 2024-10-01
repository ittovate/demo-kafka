package com.example.kafkademo.controller;

import com.example.kafkademo.config.OrderSwaggerConfig;
import com.example.kafkademo.model.generated.Order;
import com.example.kafkademo.service.OrderAvroService;
import com.example.kafkademo.service.OrderService;
import com.example.kafkademo.util.APIResponse;
import com.example.kafkademo.util.APIResponseUtil;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.example.kafkademo.constant.APIResponseConstant.ORDER_SENT_MESSAGE;
import static com.example.kafkademo.constant.OrderSwaggerConstant.CONTROLLER_DESCRIPTION;
import static com.example.kafkademo.constant.OrderSwaggerConstant.CONTROLLER_NAME;

@RestController
@RequestMapping("api/v1/orders")
@Tag(name = CONTROLLER_NAME, description = CONTROLLER_DESCRIPTION)
public class OrderController implements OrderSwaggerConfig {
    private final OrderService orderService;
    private final OrderAvroService orderAvroService;

    /**
     * Instantiates a new Order controller.
     *
     * @param orderService     the order service
     * @param orderAvroService the order avro service
     */
    public OrderController(OrderService orderService, OrderAvroService orderAvroService) {
        this.orderService = orderService;
        this.orderAvroService = orderAvroService;
    }

        /**
         * synchronously sends order details in AVRO format.
         *
         * @param order the order
         * @return ResponseEntity with APIResponse and status
         * @throws InterruptedException the interrupted exception
         */
        @PostMapping("/sync/avro")
        public APIResponse<String> makeOrderSync(@RequestBody Order order)
                throws InterruptedException {
            orderAvroService.sendKafkaEventSync(order);

            return APIResponseUtil.createUnifiedResponse(HttpStatus.OK.value(),
                    ORDER_SENT_MESSAGE, null);
        }

    /**
     * synchronously sends profile details in String format.
     *
     * @param customerEmail the customer email
     * @return ResponseEntity with APIResponse and status
     * @throws InterruptedException the interrupted exception
     */
    @PostMapping("/sync/{customerEmail}")
    public APIResponse<String> makeOrderSync(@PathVariable String customerEmail)
            throws InterruptedException {
        orderService.makeOrderSync(customerEmail);
        return APIResponseUtil.createUnifiedResponse(HttpStatus.OK.value(),
                ORDER_SENT_MESSAGE, null);
    }

    /**
     * Asynchronously sends profile details in String format.
     *
     * @param customerEmail the customer email
     * @return ResponseEntity with APIResponse and status
     */
    @PostMapping("/async/{customerEmail}")
    public APIResponse<String> makeOrderAsync(@PathVariable String customerEmail) {
        orderService.makeOrderAsync(customerEmail);
        return APIResponseUtil.createUnifiedResponse(HttpStatus.OK.value(),
                ORDER_SENT_MESSAGE, null);
    }

}
