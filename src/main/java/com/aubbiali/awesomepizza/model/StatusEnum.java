package com.aubbiali.awesomepizza.model;

import com.aubbiali.awesomepizza.model.exceptions.EndStatusException;

public enum StatusEnum {
    CREATED,
    IN_QUEUE, // todo add daily job to update status in queue for all orders of the day.
    IN_PROGRESS,
    READY_FOR_PICKUP,
    COMPLETED;

    public StatusEnum getNextStatus(StatusEnum previous) throws EndStatusException{
        return switch (previous){
            case CREATED -> IN_QUEUE;
            case IN_QUEUE -> IN_PROGRESS;
            case IN_PROGRESS -> READY_FOR_PICKUP;
            case READY_FOR_PICKUP -> COMPLETED;
            case COMPLETED -> throw new EndStatusException();
        };
    }

    public StatusEnum getEndStatus(){
        return COMPLETED;
    }
}
