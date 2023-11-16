package com.aubbiali.awesomepizza.tasks;

import com.aubbiali.awesomepizza.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class SetOrderInQueueFirstSlot {

    @Autowired
    OrderService orderService;

    @Scheduled(cron = "0 * * ? * *") // every minute
    public void setOrderInQueue(){
        orderService.setOrderOfTodayInQueue();
    }

}
