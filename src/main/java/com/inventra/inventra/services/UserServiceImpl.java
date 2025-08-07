package com.inventra.inventra.services;

import com.inventra.inventra.data.models.Admin;
import com.inventra.inventra.data.models.Users;
import com.inventra.inventra.data.repositories.AdminRepo;
import com.inventra.inventra.data.repositories.UserRepo;
import com.inventra.inventra.dtos.requests.LoginUserRequest;
import com.inventra.inventra.dtos.requests.RegisterUserRequest;
import com.inventra.inventra.dtos.responses.LoginUserResponse;
import com.inventra.inventra.dtos.responses.RegisterUserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    private final UserRepo userRepo;

    public UserServiceImpl(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public RegisterUserResponse registerUser(RegisterUserRequest registerUserRequest) {
        return null;
    }

    @Override
    public LoginUserResponse loginUser(LoginUserRequest loginUserRequest) {
        return null;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Users user = userRepo.findByEmail(email).orElse(null);
        if (user != null) {
            return User.builder()
                    .username(user.getEmail())
                    .password(user.getPassword())
                    .roles(user.getRole().name())
                    .build();
        }
        throw new UsernameNotFoundException("User not found with email: " + email);
    }

}
