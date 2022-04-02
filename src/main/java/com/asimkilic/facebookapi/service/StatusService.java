package com.asimkilic.facebookapi.service;

import com.asimkilic.facebookapi.entity.Status;
import com.asimkilic.facebookapi.repository.StatusRepository;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

@Service
public class StatusService {
    private final StatusRepository statusRepository;

    public StatusService(StatusRepository statusRepository) {

        this.statusRepository = statusRepository;
    }

    public Status saveStatus(Status status) {
        Date date = new Date();
        long time = date.getTime();
        Timestamp dateTime = new Timestamp(time);
        status.setStatusID(UUID.randomUUID());
        status.setUploadTime(dateTime);
        return statusRepository.save(status);
    }

    public ArrayList<Status> getAllStatus() {
        return statusRepository.findAll();
    }
}
