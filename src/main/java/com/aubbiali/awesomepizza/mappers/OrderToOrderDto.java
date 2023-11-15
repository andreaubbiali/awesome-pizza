package com.aubbiali.awesomepizza.mappers;

import com.aubbiali.awesomepizza.model.dto.OrderDto;
import com.aubbiali.awesomepizza.model.dto.OrderItemDto;
import com.aubbiali.awesomepizza.model.entity.Order;
import com.aubbiali.awesomepizza.model.entity.OrderItem;
import com.aubbiali.awesomepizza.model.entity.Status;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface OrderToOrderDto {

    @Mapping(target = "currentStatus", expression = "java(mapStatusToString(order.getCurrentStatus()))")
    @Mapping(target = "orderItemList", expression = "java(mapOrderItemList(order.getOrderItemList()))")
    OrderDto orderToOrderDto(Order order);

    default String mapStatusToString(Status status) {
        return status != null ? status.getStatus().name() : null;
    }

    // TODO use mapping orderItem to OrderItemDto
    default List<OrderItemDto> mapOrderItemList(List<OrderItem> orderItemList){
        return orderItemList.stream().map( el ->
                new OrderItemDto(el.getPizza().getName(), el.getPizza().getCost(), el.getQuantity(), el.getChanges())
        ).toList();
    }
}
