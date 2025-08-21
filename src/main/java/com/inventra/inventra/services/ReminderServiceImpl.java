package com.inventra.inventra.services;

import com.inventra.inventra.data.models.Assignment;
import com.inventra.inventra.data.models.Reminders;
import com.inventra.inventra.data.repositories.AssignmentRepo;
import com.inventra.inventra.data.repositories.ReminderRepo;
import com.inventra.inventra.dtos.requests.SendReminderRequest;
import com.inventra.inventra.dtos.responses.SendReminderResponse;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Service
public class ReminderServiceImpl implements ReminderService {

        private final AssignmentRepo assignmentRepo;
        private final ReminderRepo reminderRepo;
        private final NotificationService notificationService;

        public ReminderServiceImpl(AssignmentRepo assignmentRepo,
                               ReminderRepo reminderRepo, NotificationService notificationService) {
            this.assignmentRepo = assignmentRepo;
            this.reminderRepo = reminderRepo;
            this.notificationService = notificationService;
        }

        @Scheduled(cron = "0 0 8 * * *")
        public SendReminderResponse checkOverdueAssignments() {
            LocalDateTime now = LocalDateTime.now();

            List<Assignment> overdueAssignments =
                    assignmentRepo.findByReturnDateTimeBeforeAndReturnedFalse(now);

            for (Assignment assignment : overdueAssignments) {
                long daysOverdue = ChronoUnit.DAYS.between(assignment.getReturnDateTime(), now);

                if (daysOverdue % 2 == 0) {
                    sendAndLogReminder(assignment, daysOverdue);
                }
            }
            SendReminderResponse response = new SendReminderResponse();
            response.setReminderId(null);
            response.setMessage("Reminder sent successfully");

            return response;
        }

        public SendReminderResponse sendManualReminder(SendReminderRequest request) {
            Assignment assignment = assignmentRepo.findById(request.getAssignment().getAssignmentId())
                    .orElseThrow(() -> new RuntimeException("Assignment not found"));

            LocalDateTime now = LocalDateTime.now();
            long daysOverdue = ChronoUnit.DAYS.between(assignment.getReturnDateTime(), now);

            if (daysOverdue < 0) {
                throw new RuntimeException("Item is not yet overdue");
            }

            sendAndLogReminder(assignment, daysOverdue);

            SendReminderResponse response = new SendReminderResponse();
            response.setReminderId(null); // Will be set after DB save
            response.setItemsId(assignment.getItemId());
            response.setCollectorsName(assignment.getCollectorName());
            response.setDaysOverdue(daysOverdue);
            response.setMessage("Reminder sent successfully");

            return response;
        }

        private void sendAndLogReminder(Assignment assignment, long daysOverdue) {
            String message = String.format(
                    "Reminder: Item ID %d assigned to you is %d days overdue. Please return it.",
                    assignment.getItemId().getItemId(),
                    daysOverdue
            );

            notificationService.sendEmailReminder(assignment.getCollectorId().getEmail(), message);

            Reminders reminder = new Reminders();
            reminder.setAssignmentId(assignment);
            reminder.setReminderTime(LocalDateTime.now());
            reminder.setOverDueDays(daysOverdue);

            reminderRepo.save(reminder);
        }
    }


