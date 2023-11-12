package com.aubbiali.awesomepizza.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "pizza", schema = "awesomepizza")
@Getter @Setter
public class Pizza {

    @Id
    @GeneratedValue
    private Long id;

    @NotNull
    private String name;

    @NotNull
    private Float cost;

    @ManyToMany
    @JoinTable(
            name = "pizza_composition",
            joinColumns = @JoinColumn(name = "id_pizza"),
            inverseJoinColumns = @JoinColumn(name = "id_ingredient"))
    private List<Ingredient> ingredientList;
}
