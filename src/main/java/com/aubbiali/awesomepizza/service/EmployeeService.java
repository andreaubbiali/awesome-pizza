package com.aubbiali.awesomepizza.service;

import com.aubbiali.awesomepizza.model.dto.OrderDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    @Autowired
    private OrderService orderService;

    /**
     * Get next order to be prepared.
     * @return the next order or null if no order present.
     */
    public OrderDto getNextOrder(){
        return orderService.getNextOrderForToday();
    }
}