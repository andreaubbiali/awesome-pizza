package com.aubbiali.awesomepizza.utils;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ControllerResponseUtil {

    /**
     * Get a response depending on [value]
     * @param value the value.
     * @return a response with the value and 404 if value is null, 200 otherwise
     * @param <T> the type of the value.
     */
    public static <T> ResponseEntity<T> getResponse(T value){

        HttpStatus status = null;
        if(value == null) {
            status = HttpStatus.NOT_FOUND;
        } else {
            status = HttpStatus.OK;
        }

        return new ResponseEntity<T>(value, status);
    }
}
