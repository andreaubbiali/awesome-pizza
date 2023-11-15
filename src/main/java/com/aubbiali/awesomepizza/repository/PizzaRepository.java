package com.aubbiali.awesomepizza.repository;

import com.aubbiali.awesomepizza.model.entity.Pizza;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PizzaRepository extends CrudRepository<Pizza, Long> {
}
