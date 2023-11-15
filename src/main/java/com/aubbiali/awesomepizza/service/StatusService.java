package com.aubbiali.awesomepizza.service;

import com.aubbiali.awesomepizza.model.StatusEnum;
import com.aubbiali.awesomepizza.model.entity.Status;
import com.aubbiali.awesomepizza.repository.StatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StatusService {

    @Autowired  private StatusRepository statusRepository;

    /**
     * @return the status on order creation
     */
    public Status getStatusOnOrderCreation(){
        return statusRepository.findByStatus(StatusEnum.CREATED);
    }
}
