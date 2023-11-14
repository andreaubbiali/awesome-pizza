package com.aubbiali.awesomepizza.model.entity;

import com.aubbiali.awesomepizza.model.StatusEnum;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Status", schema = "awesomepizza")
@Getter @Setter
public class Status {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    @Enumerated(EnumType.STRING)
    private StatusEnum status;
}
