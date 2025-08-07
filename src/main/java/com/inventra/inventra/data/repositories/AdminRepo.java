package com.inventra.inventra.data.repositories;

import com.inventra.inventra.data.models.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AdminRepo extends JpaRepository<Admin, Long> {


}
