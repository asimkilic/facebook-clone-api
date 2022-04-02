package com.asimkilic.facebookapi.repository;

import com.asimkilic.facebookapi.entity.User;
import org.springframework.data.cassandra.repository.CassandraRepository;

import java.util.ArrayList;
import java.util.UUID;

public interface UserRepository extends CassandraRepository<User, UUID> {
    User save(User user);

    ArrayList<User> findAll();

    User findAllByUserId(UUID userID);
}
