package com.inventra.inventra.controllers;

import com.inventra.inventra.data.models.Users;
import com.inventra.inventra.dtos.requests.LoginUserRequest;
import com.inventra.inventra.dtos.requests.RegisterUserRequest;
import com.inventra.inventra.dtos.responses.LoginUserResponse;
import com.inventra.inventra.dtos.responses.RegisterUserResponse;
import com.inventra.inventra.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user/")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("register-user")
    public ResponseEntity<?> registerUsers(@RequestBody RegisterUserRequest request){
        try{
            RegisterUserResponse response = userService.registerUser(request);
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        }catch(Exception e){
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("login-user")
    public ResponseEntity<?> loginUsers(@RequestBody LoginUserRequest request){
        try{
            LoginUserResponse response = userService.loginUser(request);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("all-users")
    public ResponseEntity<?> returnAllUsers(){
        try{
            List<Users> response = userService.getAllUsers();
            return new ResponseEntity<>(response, HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
