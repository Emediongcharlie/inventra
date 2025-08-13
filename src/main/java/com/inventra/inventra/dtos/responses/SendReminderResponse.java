package com.inventra.inventra.dtos.responses;

import com.inventra.inventra.data.models.Assignment;
import com.inventra.inventra.data.models.Collectors;
import com.inventra.inventra.data.models.Items;
import jakarta.persistence.ManyToOne;

import java.time.LocalDateTime;

public class SendReminderResponse {

    private String message;
    private Collectors collectorsName;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Collectors getCollectorsName() {
        return collectorsName;
    }

    public void setCollectorsName(Collectors collectorsName) {
        this.collectorsName = collectorsName;
    }

    public Items getItemsId() {
        return itemsId;
    }

    public void setItemsId(Items itemsId) {
        this.itemsId = itemsId;
    }

    public Items getItemsName() {
        return itemsName;
    }

    public void setItemsName(Items itemsName) {
        this.itemsName = itemsName;
    }

    public LocalDateTime getOverdue() {
        return overdue;
    }

    public void setOverdue(LocalDateTime overdue) {
        this.overdue = overdue;
    }

    private Items itemsId;
    private Items itemsName;
    private LocalDateTime overdue;

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

    private Long reminderId;
    private Assignment assignmentId;
    private boolean isStatus;

}
