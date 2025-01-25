package com.example.bsm.controller;

import com.example.bsm.entity.User;
import com.example.bsm.service.UserService;
import com.example.bsm.utility.ResponseStructure;
import com.example.bsm.utility.RestResponseBuilder;
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
    public ResponseEntity<ResponseStructure<User>> registerUser(@RequestBody User user){
        user=userService.registerUser(user);
        return responseBuilder.success(HttpStatus.CREATED,"User created",user);
    }

    @GetMapping("users/{userId}")
    public ResponseEntity<ResponseStructure<User>> findUserById(@PathVariable int userId){
        User user=userService.findUserById(userId);
        return responseBuilder.success(HttpStatus.FOUND,"User Found",user);
    }

    public ResponseEntity<ResponseStructure<User>> updateUser(@RequestBody User user){
        user=userService.updateUser(user);
        return responseBuilder.success(HttpStatus.OK,"Upadted user",user);
    }

}
