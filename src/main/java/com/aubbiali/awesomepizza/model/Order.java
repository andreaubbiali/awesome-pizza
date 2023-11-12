package com.aubbiali.awesomepizza.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Order", schema = "awesomepizza")
public class Order {

    @Id
    @GeneratedValue
    private Long id;
}
