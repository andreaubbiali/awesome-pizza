package com.aubbiali.awesomepizza.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
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

    @ManyToOne
    @JoinColumn(name = "id_order")
    @Id
    private Order order;

    @NotNull
    private int quantity;

    @NotEmpty
    private String changes;
}
