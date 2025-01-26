package com.example.bsm.exceptionhandler;

import com.example.bsm.exception.UserNotFoundByIdException;
import com.example.bsm.utility.ErrorStructure;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@AllArgsConstructor
public class UserExceptionHandler {

//    private final RestController responseBuilder;
//
//    public ResponseEntity<ErrorStructure<String>> handlerUserNotFoundById(UserNotFoundByIdException ex){
//        return responseBuilder.er(HttpStatus.NOT_FOUND,ex.getMessage(),"User Not Found By Ud");
//    }

}
