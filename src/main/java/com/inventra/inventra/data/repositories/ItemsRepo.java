package com.inventra.inventra.data.repositories;

import com.inventra.inventra.data.models.Items;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ItemsRepo extends JpaRepository<Items, Long> {

    Optional<Items> findByName(String name);
    Optional<Items> findByItemId(Long id);
}
