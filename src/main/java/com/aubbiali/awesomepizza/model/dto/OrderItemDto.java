package com.aubbiali.awesomepizza.model.dto;

public record OrderItemDto(
        String pizza,
        Float cost,
        int quantity,
        String changes
) {
}
