package com.aubbiali.awesomepizza.model.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public record AddOrderRequestItem(

    @NotNull(message = "Quantity should not be null.")
    @Min(value = 1L, message = "Quantity should be greater than or equal to 1.")
    Long quantity,

    String changes,

    @NotNull(message = "PizzaId should not be null.")
    @Min(value = 1L, message = "PizzaId should be greater than or equal to 1.")
    Long pizzaId

){}