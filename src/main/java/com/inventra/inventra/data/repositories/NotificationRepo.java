package com.inventra.inventra.data.repositories;

import com.inventra.inventra.data.models.Notification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificationRepo extends JpaRepository<Notification, Long> {
}
