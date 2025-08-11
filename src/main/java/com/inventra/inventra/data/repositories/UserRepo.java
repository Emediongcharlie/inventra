package com.inventra.inventra.data.repositories;

import com.inventra.inventra.data.models.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepo extends JpaRepository<Users, Long> {

    Optional<Users> findByEmail(String email);


}
