package com.aubbiali.awesomepizza.controller;

import com.aubbiali.awesomepizza.model.dto.OrderDto;
import com.aubbiali.awesomepizza.model.request.AddOrderRequest;
import com.aubbiali.awesomepizza.service.OrderService;
import com.aubbiali.awesomepizza.utils.ControllerResponseUtil;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
public class OrderController {

    Logger logger = LoggerFactory.getLogger(OrderController.class);

    @Autowired
    private OrderService orderService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<OrderDto> getOrderByID(@PathVariable("id") Long orderId){
        logger.info("Order with id {} requested", orderId);

        OrderDto order = orderService.getOrderByID(orderId);
        return ControllerResponseUtil.getResponse(order);
    }

    @PostMapping(value = "/add")
    public ResponseEntity<Long> addOrder(@Valid @RequestBody AddOrderRequest addOrderRequest){

        Long orderId = orderService.addOrder(addOrderRequest);

        return new ResponseEntity<>(orderId, HttpStatus.CREATED);
    }
}