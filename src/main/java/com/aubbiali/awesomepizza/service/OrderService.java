package com.aubbiali.awesomepizza.service;

import com.aubbiali.awesomepizza.mappers.AddOrderRequestToOrderMapper;
import com.aubbiali.awesomepizza.mappers.OrderItemMapper;
import com.aubbiali.awesomepizza.mappers.OrderToOrderDto;
import com.aubbiali.awesomepizza.model.StatusEnum;
import com.aubbiali.awesomepizza.model.dto.OrderDto;
import com.aubbiali.awesomepizza.model.entity.HistoricOrderStatus;
import com.aubbiali.awesomepizza.model.entity.Order;
import com.aubbiali.awesomepizza.model.entity.OrderItem;
import com.aubbiali.awesomepizza.model.entity.Status;
import com.aubbiali.awesomepizza.model.request.AddOrderRequest;
import com.aubbiali.awesomepizza.repository.OrderRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired private OrderRepository orderRepository;
    @Autowired private AddOrderRequestToOrderMapper addOrderRequestToOrderMapper;
    @Autowired private OrderToOrderDto orderDtoMapper;
    @Autowired private StatusService statusService;
    @Autowired private OrderItemMapper orderItemMapper;

    /**
     * Get an order by id.
     * @param orderId the order id.
     * @return the order.
     */
    @Cacheable(value = "orderCache", key = "#orderId")
    public OrderDto getOrderByID(Long orderId) {
        Optional<Order> order = orderRepository.findById(orderId);

        /* uncomment to see cache working
        try{
            Thread.sleep(1000);
        } catch(Exception e){}
        */

        return order.map(
                value -> orderDtoMapper.orderToOrderDto(value)
        ).orElse(null);
    }

    /**
     * Add a new order.
     * @param addOrderRequest the add order request.
     * @return the id of the added order.
     */
    @Transactional
    public Long addOrder(AddOrderRequest addOrderRequest) {
        // todo add check on number pizza in the specified day is not exceeded

        Order order = addOrderRequestToOrderMapper.addOrderRequestToOrder(addOrderRequest);

        Status createdStatus = statusService.getStatusOnOrderCreation();
        order.setCurrentStatus(createdStatus);
        order.getOrderHistory().add(new HistoricOrderStatus(order, createdStatus));

        List<OrderItem> orderItemList = addOrderRequest.orderItemList().stream().map(el ->
            orderItemMapper.requestToOrderItem(el, order)
        ).toList();

        order.setOrderItemList(orderItemList);

        return orderRepository.save(order).getId();
    }

    /**
     * Pick the next order to be prepared.
     * @return the next order or null if not present.
     */
    public OrderDto getNextOrderForToday(){
        Date today = new Date();

        Long orderId = orderRepository.getNextOrderIdForToday(today, StatusEnum.CREATED.name()); // should be IN_QUEUE but job missing
        if (orderId == null){
            return null;
        }
        return getOrderByID(orderId);
    }

    @Transactional
    public void setOrderOfTodayInQueue(int slot){
        // query to set current_state=IN_QUEUE for all order of today in the specified slot
    }
}
