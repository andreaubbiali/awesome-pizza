package com.aubbiali.awesomepizza.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "Orders", schema = "awesomepizza")
@Setter @Getter
public class Order {

    @Id
    @GeneratedValue
    private Long id;

    @NotNull
    private Date insertDate;

    @NotNull
    private Date orderDate;
    @NotNull
    private int slot;
}
