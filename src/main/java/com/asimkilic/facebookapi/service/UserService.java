package com.asimkilic.facebookapi.service;

import com.asimkilic.facebookapi.entity.User;
import com.asimkilic.facebookapi.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User submitMetaDataOfUser(User user) {
        Date date = new Date();
        long time = date.getTime();
        Timestamp joiningDate = new Timestamp(time);
        user.setUserId(UUID.randomUUID());
        user.setActive(true);
        user.setJoiningDate(joiningDate);
        User result = userRepository.save(user);
        return result;
    }

    public ArrayList<User> retrieveAllUserDetails() {
        ArrayList<User> result = userRepository.findAll();
        return result;
    }

    public User getUserData(UUID userID) {
        User result = userRepository.findAllByUserId(userID);
        return result;
    }
}
