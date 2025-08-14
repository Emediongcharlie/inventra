package com.inventra.inventra.data.models;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Reminders {

    public Long getReminderId() {
        return reminderId;
    }

    public void setReminderId(Long reminderId) {
        this.reminderId = reminderId;
    }

    public Assignment getAssignmentId() {
        return assignmentId;
    }

    public void setAssignmentId(Assignment assignmentId) {
        this.assignmentId = assignmentId;
    }

    public boolean isStatus() {
        return isStatus;
    }

    public void setStatus(boolean status) {
        isStatus = status;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reminderId;
    @ManyToOne
    private Assignment assignmentId;
    private boolean isStatus;

    public LocalDateTime getReminderTime() {
        return reminderTime;
    }

    public void setReminderTime(LocalDateTime reminderTime) {
        this.reminderTime = reminderTime;
    }

    private LocalDateTime reminderTime;

    public Long getOverDueDays() {
        return overDueDays;
    }

    public void setOverDueDays(Long overDueDays) {
        this.overDueDays = overDueDays;
    }

    private Long overDueDays;
}
