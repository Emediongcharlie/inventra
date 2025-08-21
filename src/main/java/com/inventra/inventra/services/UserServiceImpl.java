package com.inventra.inventra.services;

import com.inventra.inventra.data.models.Users;
import com.inventra.inventra.data.repositories.UserRepo;
import com.inventra.inventra.dtos.requests.LoginUserRequest;
import com.inventra.inventra.dtos.requests.RegisterUserRequest;
import com.inventra.inventra.dtos.responses.LoginUserResponse;
import com.inventra.inventra.dtos.responses.RegisterUserResponse;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    private final UserRepo userRepo;
    private final BCryptPasswordEncoder passwordEncoder;
    public UserServiceImpl(UserRepo userRepo, BCryptPasswordEncoder passwordEncoder) {
        this.userRepo = userRepo;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public RegisterUserResponse registerUser(RegisterUserRequest registerUserRequest) {
        Users users = new Users();
        users.setName(registerUserRequest.getName());
        users.setEmail(registerUserRequest.getEmail());
        users.setPassword(passwordEncoder.encode(registerUserRequest.getPassword()));
        users.setPhoneNumber(registerUserRequest.getPhoneNumber());
        users.setRole(registerUserRequest.getRole());
        userRepo.save(users);

        RegisterUserResponse registerUserResponse = new RegisterUserResponse();
        registerUserResponse.setId(users.getId());
        registerUserResponse.setName(users.getName());
        registerUserResponse.setRole(users.getRole());
        registerUserResponse.setMessage("Successfully registered " + users.getName() +" with id " + users.getId());

        return registerUserResponse;
    }

    @Override
    public LoginUserResponse loginUser(LoginUserRequest loginUserRequest) {
        Users users = userRepo.findByEmail(loginUserRequest.getEmail())
                .orElseThrow(() -> new UsernameNotFoundException(loginUserRequest.getEmail() + " not found"));

        if (!passwordEncoder.matches(loginUserRequest.getPassword(), users.getPassword())) {
            throw new BadCredentialsException("Bad credentials");
        }

        LoginUserResponse response = new LoginUserResponse();
        response.setUserId(users.getId());
        response.setMessage("Successfully Logged in user with id " + users.getId() + " role " + users.getRole());
        return response;
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

    public List<Users> getAllUsers() {
        return userRepo.findAll();
    }

}
