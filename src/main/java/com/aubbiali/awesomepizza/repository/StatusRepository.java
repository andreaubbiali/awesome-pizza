package com.aubbiali.awesomepizza.repository;

import com.aubbiali.awesomepizza.model.StatusEnum;
import com.aubbiali.awesomepizza.model.entity.Order;
import com.aubbiali.awesomepizza.model.entity.Status;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface StatusRepository extends CrudRepository<Status, Long> {

    @Query("SELECT s FROM Status s WHERE s.status = :status")
    public Status findByStatus(@Param("status") StatusEnum status);
}