package com.example.bsm.service;

import com.example.bsm.entity.User;
import com.example.bsm.request.UserRequest;
import com.example.bsm.response.AdminResponse;
import com.example.bsm.response.UserResponse;

public interface UserService {

    UserResponse registerUser(UserRequest userRequest);

    UserResponse findUserById(int userId);

    UserResponse updateUser(UserRequest userRequest,int userId);

    UserResponse promoteToAdmin(int userId);

    AdminResponse registerAdmin(UserRequest userRequest);
}
