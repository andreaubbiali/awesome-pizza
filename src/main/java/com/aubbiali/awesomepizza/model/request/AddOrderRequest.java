package com.aubbiali.awesomepizza.model.request;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Range;

import java.util.Date;
import java.util.List;

@Valid
public record AddOrderRequest (

        @NotNull(message = "Order date should not be null.") // TODO add validation orderDate must be after or equal to today
        Date orderDate,

        @NotNull(message = "Slot should not be null.")
        @Range(min = 1L, max = 2L, message = "Slot must a number equals to 1 or 2 (1 for lunch 2 for dinner).")
        Long slot,

        @NotNull(message = "Item list should not be null.")
        @NotEmpty(message = "Item list should not be empty.")
        @Valid
        List<AddOrderRequestItem> orderItemList
){}