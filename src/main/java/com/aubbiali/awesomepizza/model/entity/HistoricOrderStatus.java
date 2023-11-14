package com.aubbiali.awesomepizza.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "HistoricOrderStatus", schema = "awesomepizza")
@Setter @Getter
public class HistoricOrderStatus {

    @ManyToOne
    @JoinColumn(name = "id_order")
    @Id
    private Order order;

    @ManyToOne
    @JoinColumn(name = "id_status")
    @Id
    private Status status;

    @NotNull
    @Temporal(TemporalType.DATE)
    private Date changeDate;
}
