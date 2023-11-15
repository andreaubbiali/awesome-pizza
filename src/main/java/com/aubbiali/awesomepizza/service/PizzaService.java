package com.aubbiali.awesomepizza.service;

import com.aubbiali.awesomepizza.model.entity.Pizza;
import com.aubbiali.awesomepizza.repository.PizzaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PizzaService {

    @Autowired private PizzaRepository pizzaRepository;

    /**
     * Get pizza by id.
     * @param id the id of the pizza.
     * @return the pizza.
     */
    public Pizza getPizzaById(Long id){
        return pizzaRepository.findById(id).orElse(null);
    }
}
