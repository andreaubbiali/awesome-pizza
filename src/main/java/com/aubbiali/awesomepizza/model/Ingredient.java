package com.aubbiali.awesomepizza.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Ingredients", schema = "awesomepizza")
@Setter @Getter
public class Ingredient {

    @Id
    @GeneratedValue
    private Long id;

    @NotNull
    private String name;
}
