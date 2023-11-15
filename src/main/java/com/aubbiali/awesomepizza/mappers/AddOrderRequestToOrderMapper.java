package com.aubbiali.awesomepizza.mappers;

import com.aubbiali.awesomepizza.model.entity.Order;
import com.aubbiali.awesomepizza.model.request.AddOrderRequest;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AddOrderRequestToOrderMapper {

    Order addOrderRequestToOrder(AddOrderRequest addOrderRequest);
}
