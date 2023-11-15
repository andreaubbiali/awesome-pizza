package com.aubbiali.awesomepizza.controller;

import com.aubbiali.awesomepizza.model.entity.Pizza;
import com.aubbiali.awesomepizza.service.PizzaService;
import com.aubbiali.awesomepizza.utils.ControllerResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pizza")
public class PizzaController {

    Logger logger = LoggerFactory.getLogger(PizzaController.class);

    @Autowired
    private PizzaService pizzaService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Pizza> getPizzaById(@PathVariable("id") Long pizzaId){
        logger.info("Pizza with id {} requested", pizzaId);

        Pizza pizza = pizzaService.getPizzaById(pizzaId);
        return ControllerResponseUtil.getResponse(pizza);
    }
}
