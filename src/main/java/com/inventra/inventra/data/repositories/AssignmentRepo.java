package com.inventra.inventra.data.repositories;

import com.inventra.inventra.data.models.Assignment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface AssignmentRepo extends JpaRepository<Assignment, Long> {

    List<Assignment> findByReturnDateTimeBeforeAndReturnedFalse(LocalDateTime dateTime);

}
