package com.inventra.inventra.data.models;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Assignment {

    public Long getAssignmentId() {
        return AssignmentId;
    }

    public void setAssignmentId(Long assignmentId) {
        AssignmentId = assignmentId;
    }

    public LocalDateTime getAssignmentDateTime() {
        return assignmentDateTime;
    }

    public void setAssignmentDateTime(LocalDateTime assignmentDateTime) {
        this.assignmentDateTime = assignmentDateTime;
    }

    public LocalDateTime getReturnDateTime() {
        return returnDateTime;
    }

    public void setReturnDateTime(LocalDateTime returnDateTime) {
        this.returnDateTime = returnDateTime;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long AssignmentId;

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

    @OneToOne
    private Items itemId;
    @OneToOne
    private Collectors collectorId;
    private LocalDateTime assignmentDateTime;
    private LocalDateTime returnDateTime;

    public Collectors getCollectorName() {
        return collectorName;
    }

    public void setCollectorName(Collectors collectorName) {
        this.collectorName = collectorName;
    }

    @OneToOne
    private Collectors collectorName;

    public ItemStatus getItemStatus() {
        return itemStatus;
    }

    public void setItemStatus(ItemStatus itemStatus) {
        this.itemStatus = itemStatus;
    }

    private ItemStatus itemStatus;

    public boolean isReturned() {
        return returned;
    }

    public void setReturned(boolean returned) {
        this.returned = returned;
    }

    private boolean returned = false;
}
