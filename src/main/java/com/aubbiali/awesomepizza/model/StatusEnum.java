package com.aubbiali.awesomepizza.model;

public enum StatusEnum {
    CREATED,
    IN_QUEUE, // todo add daily job to update status in queue for all orders of the day.
    IN_PROGRESS,
    READY_FOR_PICKUP,
    COMPLETED
}
