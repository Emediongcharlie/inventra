package com.inventra.inventra.data.repositories;

import com.inventra.inventra.data.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoryRepo extends JpaRepository<Category, Long> {

    Optional<Category> findByCategoryId(Long id);
}
