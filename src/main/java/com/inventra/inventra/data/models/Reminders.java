package com.inventra.inventra.data.models;

import jakarta.persistence.*;

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
}
