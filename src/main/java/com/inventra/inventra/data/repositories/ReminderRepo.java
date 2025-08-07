package com.inventra.inventra.data.repositories;

import com.inventra.inventra.data.models.Reminders;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReminderRepo extends JpaRepository<Reminders, Long> {

}
