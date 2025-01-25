package com.example.bsm.controller;

import com.example.bsm.entity.User;
import com.example.bsm.request.UserRequest;
import com.example.bsm.response.AdminResponse;
import com.example.bsm.response.UserResponse;
import com.example.bsm.service.UserService;
import com.example.bsm.utility.ResponseStructure;
import com.example.bsm.utility.RestResponseBuilder;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class UserController {

    private final UserService userService;
    private final RestResponseBuilder responseBuilder;

    @PostMapping("/register")
    public ResponseEntity<ResponseStructure<UserResponse>> registerUser(@RequestBody  UserRequest userRequest){
         UserResponse userResponse=userService.registerUser(userRequest);
        return responseBuilder.success(HttpStatus.CREATED,"User created",userResponse);
    }

    @GetMapping("users/{userId}")
    public ResponseEntity<ResponseStructure<UserResponse>> findUserById(@PathVariable int userId){
        UserResponse response=userService.findUserById(userId);
        return responseBuilder.success(HttpStatus.FOUND,"User Found",response);
    }

    @PutMapping("users/{userId}")
    public ResponseEntity<ResponseStructure<UserResponse>> updateUser(@RequestBody UserRequest userRequest,
                                                                      @PathVariable int userId){
        UserResponse userResponse=userService.updateUser(userRequest,userId);
        return responseBuilder.success(HttpStatus.OK,"Upadted user",userResponse);
    }

    @GetMapping("/admins/{userId}")
    public ResponseEntity<ResponseStructure<UserResponse>> promoteToAdmin(@PathVariable int userId){
        UserResponse userResponse=userService.promoteToAdmin(userId);
        return responseBuilder.success(HttpStatus.FOUND,"User found",userResponse);
    }

    @PostMapping("/adminsregister")
    public ResponseEntity<ResponseStructure<AdminResponse>> registerAdmin(@RequestBody  UserRequest userRequest){
        AdminResponse adminResponse=userService.registerAdmin(userRequest);
        return responseBuilder.success(HttpStatus.CREATED,"User created",adminResponse);
    }


}
