package com.inventra.inventra.services;

import com.inventra.inventra.data.models.Assignment;
import com.inventra.inventra.data.models.Items;
import com.inventra.inventra.data.models.Notification;
import com.inventra.inventra.data.repositories.NotificationRepo;
import com.inventra.inventra.dtos.requests.SendReminderNotificationRequest;
import com.inventra.inventra.dtos.responses.SendReminderNotificationResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class NotificationServiceImpl implements NotificationService {

    @Autowired
    private NotificationRepo notificationRepo;

    @Autowired
    private MailService mailService;

    Assignment assignment = new Assignment();

    Items item = new Items();

    @Override
    public SendReminderNotificationResponse sendEmailReminder(String email, String message) {
        Notification notification = new Notification();
        notification.setMessage(message);
        notification.setRecipientEmail(email);
        notification.setCreatedAt(LocalDateTime.now());
        notificationRepo.save(notification);

        mailService.sendNotification(email, assignment, item);

        SendReminderNotificationResponse response = new SendReminderNotificationResponse();
        response.setEmail(email);
        response.setMessage("Notification sent to" + email);

        return response;
    }
}
