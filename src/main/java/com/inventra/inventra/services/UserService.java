package com.inventra.inventra.services;

import com.inventra.inventra.data.models.Users;
import com.inventra.inventra.dtos.requests.LoginUserRequest;
import com.inventra.inventra.dtos.requests.RegisterUserRequest;
import com.inventra.inventra.dtos.responses.LoginUserResponse;
import com.inventra.inventra.dtos.responses.RegisterUserResponse;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {

    RegisterUserResponse registerUser(RegisterUserRequest registerUserRequest);
    LoginUserResponse loginUser(LoginUserRequest loginUserRequest);
    List<Users> getAllUsers();
}
