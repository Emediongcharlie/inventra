package com.inventra.inventra.services;

import com.inventra.inventra.data.models.Reminders;
import com.inventra.inventra.data.repositories.ReminderRepo;
import com.inventra.inventra.dtos.requests.SendReminderRequest;
import com.inventra.inventra.dtos.responses.SendReminderResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReminderServiceImpl implements ReminderService {

    @Autowired
    ReminderRepo reminderRepo;

    @Override
    public SendReminderResponse sentReminder(SendReminderRequest sendReminderRequest) {
        Reminders reminders = new Reminders();
        reminders.setAssignmentId(sendReminderRequest.getAssignmentId());

        SendReminderResponse sendReminderResponse = new SendReminderResponse();
        sendReminderResponse.setReminderId(reminders.getReminderId());
        sendReminderResponse.setItemsId(reminders.getAssignmentId().getItemId());
        sendReminderResponse.setCollectorsName(reminders.getAssignmentId().getCollectorName());
        sendReminderResponse.setOverdue();
        return sendReminderResponse;
    }
}
