package com.inventra.inventra.dtos.responses;

import com.inventra.inventra.data.models.Collectors;
import com.inventra.inventra.data.models.ItemStatus;
import com.inventra.inventra.data.models.Items;

import java.time.LocalDateTime;

public class AssignItemsResponse {
    private Items itemId;
    private Collectors collectorId;
    private String assignmentDateTime;
    private String returnDateTime;
    private ItemStatus itemStatus;
    private String message;

    public Items getItemId() {
        return itemId;
    }
    public void setItemId(Items itemId) {
        this.itemId = itemId;
    }
    public Collectors getCollectorId() {
        return collectorId;
    }
    public void setCollectorId(Collectors collectorId) {
        this.collectorId = collectorId;
    }
    public String getAssignmentDateTime() {
        return assignmentDateTime;
    }
    public void setAssignmentDateTime(String assignmentDateTime) {
        this.assignmentDateTime = assignmentDateTime;
    }
    public String getReturnDateTime() {
        return returnDateTime;
    }
    public void setReturnDateTime(String returnDateTime) {
        this.returnDateTime = returnDateTime;
    }
    public ItemStatus getItemStatus() {
        return itemStatus;
    }
    public void setItemStatus(ItemStatus itemStatus) {
        this.itemStatus = itemStatus;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
}

