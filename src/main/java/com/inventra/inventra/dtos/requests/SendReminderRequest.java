package com.inventra.inventra.dtos.requests;

import com.inventra.inventra.data.models.Assignment;
import com.inventra.inventra.data.models.Collectors;
import jakarta.persistence.ManyToOne;

public class SendReminderRequest {

    public Collectors getCollectorEmail() {
        return collectorEmail;
    }

    public void setCollectorEmail(Collectors collectorEmail) {
        this.collectorEmail = collectorEmail;
    }

    private Collectors collectorEmail;

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

    private Assignment assignmentId;
    private boolean isStatus;

}
