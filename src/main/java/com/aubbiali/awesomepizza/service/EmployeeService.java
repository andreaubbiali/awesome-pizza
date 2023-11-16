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

    public void passOrderToNextStatus(Long orderId){
        // get order by id
        // if it's COMPLETED || CREATED  return
        // get next status (will be a util method I think. Passing a status, it will return the next one)
        // set the new status into current_status of the order and save also the historical order status
        // return the new status
    }
}