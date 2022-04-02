package com.asimkilic.facebookapi.repository;

import com.asimkilic.facebookapi.entity.Status;
import org.springframework.data.cassandra.repository.CassandraRepository;

import java.util.ArrayList;
import java.util.UUID;

public interface StatusRepository extends CassandraRepository<Status, UUID> {

    Status save(Status status);

    ArrayList<Status> findAll();
}
