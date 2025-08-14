package com.inventra.inventra.services;

import com.inventra.inventra.dtos.requests.SendReminderNotificationRequest;
import com.inventra.inventra.dtos.responses.SendReminderNotificationResponse;

public interface NotificationService {

    SendReminderNotificationResponse sendEmailReminder(String email, String message);
}
