package com.aubbiali.awesomepizza.model.dto;


import java.util.Date;
import java.util.List;

public record OrderDto(
    Long id,
    Date insertDate,
    Date orderDate,
    int slot,
    String currentStatus,
    List<OrderItemDto> orderItemList
){ }
