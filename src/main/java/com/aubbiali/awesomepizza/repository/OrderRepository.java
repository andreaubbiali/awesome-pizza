package com.aubbiali.awesomepizza.repository;

import com.aubbiali.awesomepizza.model.entity.Order;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface OrderRepository extends CrudRepository<Order, Long> {

    // native becase not supported by jpa
    @Query(value = "SELECT o.id FROM orders o WHERE o.order_date = :today AND o.current_status = (SELECT s.id FROM status s WHERE s.status = :status) LIMIT 1", nativeQuery = true)
    public Long getNextOrderIdForToday(@Param("today") Date today, @Param("status") String status);
}
