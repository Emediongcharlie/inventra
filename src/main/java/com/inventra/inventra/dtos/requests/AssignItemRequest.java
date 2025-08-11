package com.inventra.inventra.dtos.requests;

import com.inventra.inventra.data.models.Collectors;
import com.inventra.inventra.data.models.DurationType;
import com.inventra.inventra.data.models.ItemStatus;
import com.inventra.inventra.data.models.Items;

import java.time.LocalDateTime;

public class AssignItemRequest {
    private Items itemId;
    private Collectors collectorId;

    // Duration type can be "DAYS", "WEEKS", or "MONTHS"
    private DurationType durationType;

    // The number of days/weeks/months
    private int durationValue;

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
    public DurationType getDurationType() {
        return durationType;
    }
    public void setDurationType(DurationType durationType) {
        this.durationType = durationType;
    }
    public int getDurationValue() {
        return durationValue;
    }
    public void setDurationValue(int durationValue) {
        this.durationValue = durationValue;
    }
}

