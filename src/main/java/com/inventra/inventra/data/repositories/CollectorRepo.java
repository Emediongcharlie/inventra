package com.inventra.inventra.data.repositories;

import com.inventra.inventra.data.models.Collectors;
import org.springframework.data.jpa.repository.JpaRepository;



public interface CollectorRepo extends JpaRepository<Collectors, Long> {
}
