package com.aubbiali.awesomepizza.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Orders", schema = "awesomepizza")
@Setter @Getter
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Temporal(TemporalType.DATE)
    private Date insertDate = new Date();

    @NotNull
    @Temporal(TemporalType.DATE)
    private Date orderDate;

    @NotNull
    private int slot; // 1 is lunch, 2 is dinner

    @NotNull
    @ManyToOne
    private Status currentStatus;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<OrderItem> orderItemList;
}
