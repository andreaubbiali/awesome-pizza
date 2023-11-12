package com.aubbiali.awesomepizza.repository;

import com.aubbiali.awesomepizza.model.Order;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends CrudRepository<Order, Long> {
}
