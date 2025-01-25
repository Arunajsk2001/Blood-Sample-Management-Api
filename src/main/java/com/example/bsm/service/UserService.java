package com.example.bsm.service;

import com.example.bsm.entity.User;

public interface UserService {

    User registerUser(User user);

    User findUserById(int userId);

    User updateUser(User user);
}
