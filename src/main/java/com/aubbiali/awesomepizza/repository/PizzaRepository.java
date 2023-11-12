package com.aubbiali.awesomepizza.repository;

import com.aubbiali.awesomepizza.model.Pizza;
import org.springframework.data.repository.CrudRepository;

public interface PizzaRepository extends CrudRepository<Pizza, Long> {
}
