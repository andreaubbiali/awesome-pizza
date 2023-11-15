package com.aubbiali.awesomepizza.mappers;

import com.aubbiali.awesomepizza.model.entity.Order;
import com.aubbiali.awesomepizza.model.entity.OrderItem;
import com.aubbiali.awesomepizza.model.entity.Pizza;
import com.aubbiali.awesomepizza.model.request.AddOrderRequestItem;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface OrderItemMapper {

    @Mapping(target = "pizza", expression = "java(mapPizza(addOrderRequestItem.pizzaId()))")
    @Mapping(target = "order", source = "order")
    OrderItem requestToOrderItem(AddOrderRequestItem addOrderRequestItem, Order order);

    default Pizza mapPizza(Long pizzaId){
        Pizza pizza = new Pizza();
        pizza.setId(pizzaId);
        return pizza;
    }

}