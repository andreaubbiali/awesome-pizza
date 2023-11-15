package com.aubbiali.awesomepizza.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "OrderItem", schema = "awesomepizza")
@Setter @Getter
public class OrderItem {

    @ManyToOne
    @JoinColumn(name = "id_pizza")
    @Id
    private Pizza pizza;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_order")
    @Id
    @JsonIgnoreProperties("orderItemList")
    private Order order;

    @NotNull
    private int quantity;

    private String changes;
}
