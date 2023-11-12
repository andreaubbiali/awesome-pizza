package com.aubbiali.awesomepizza.controller;

import com.aubbiali.awesomepizza.model.Order;
import com.aubbiali.awesomepizza.repository.OrderRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Optional;

@RestController
@RequestMapping("/order")
public class OrderController {

    Logger logger = LoggerFactory.getLogger(OrderController.class);

    @Autowired
    private OrderRepository orderRepository;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Order> getOrder(@PathVariable("id") Long orderId){
        logger.info("Order with id {} requested", orderId);
        Optional<Order> order = orderRepository.findById(orderId);

        if (order.isPresent()){
            return new ResponseEntity<>(order.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
}
