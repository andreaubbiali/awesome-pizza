package com.aubbiali.awesomepizza.service;

import com.aubbiali.awesomepizza.model.entity.Pizza;
import com.aubbiali.awesomepizza.repository.PizzaRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.*;

@SpringBootTest
public class PizzaServiceTest {

    @MockBean
    PizzaRepository pizzaRepository;

    @Autowired PizzaService pizzaService;

    @Test
    public void getPizzaByIdTest(){
        Long pizzaId = 5L;
        Pizza expectedPizza = new Pizza();
        expectedPizza.setId(pizzaId);
        expectedPizza.setCost(5F);
        expectedPizza.setName("name");

        when(pizzaRepository.findById(pizzaId)).thenReturn(Optional.of(expectedPizza));

        Pizza pizza = pizzaService.getPizzaById(pizzaId);

        assertEquals(expectedPizza, pizza);
        verify(pizzaRepository, times(1)).findById(5L);
    }

    @Test
    public void getPizzaByIdNullTest(){
        Long pizzaId = 5L;

        when(pizzaRepository.findById(pizzaId)).thenReturn(Optional.empty());

        Pizza pizza = pizzaService.getPizzaById(pizzaId);

        assertNull(pizza);
        verify(pizzaRepository, times(1)).findById(5L);
    }
}
