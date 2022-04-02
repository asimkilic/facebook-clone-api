package com.asimkilic.facebookapi.controller;

import com.asimkilic.facebookapi.entity.User;
import com.asimkilic.facebookapi.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.UUID;

@RestController
@RequestMapping("/api/userService")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/save")
    public User saveUserMetaData(@RequestBody User user) {
        return userService.submitMetaDataOfUser(user);
    }

    @GetMapping("/getUserDetails")
    public ArrayList<User> getAllUserDetails() {
        return userService.retrieveAllUserDetails();
    }

    @GetMapping("/getAllUsers/{userID}")
    public User getUserDetail(@PathVariable("userID") UUID userID) {
        return userService.getUserData(userID);
    }
}
