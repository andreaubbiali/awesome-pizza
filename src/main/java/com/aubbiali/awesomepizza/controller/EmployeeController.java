package com.aubbiali.awesomepizza.controller;

import com.aubbiali.awesomepizza.model.dto.OrderDto;
import com.aubbiali.awesomepizza.service.EmployeeService;
import com.aubbiali.awesomepizza.utils.ControllerResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    Logger logger = LoggerFactory.getLogger(EmployeeController.class);

    @Autowired
    private EmployeeService employeeService;

    @GetMapping(value = "/nextPizza")
    public ResponseEntity<OrderDto> getNextOrder(){
        logger.info("Employee request next order");

        OrderDto order = employeeService.getNextOrder();
        return ControllerResponseUtil.getResponse(order);
    }
}