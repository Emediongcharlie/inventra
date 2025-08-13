package com.inventra.inventra.services;

import com.inventra.inventra.dtos.requests.SendReminderRequest;
import com.inventra.inventra.dtos.responses.SendReminderResponse;

public interface ReminderService {

    SendReminderResponse sentReminder(SendReminderRequest sendReminderRequest);
}
