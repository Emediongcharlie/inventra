package com.inventra.inventra.dtos.responses;

import com.inventra.inventra.data.models.ItemStatus;

public class TrackItemStatusResponse {
    private Long itemId;
    private String itemName;
    private ItemStatus status;
    private String message;

    public Long getItemId() {
        return itemId;
    }
    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }
    public String getItemName() {
        return itemName;
    }
    public void setItemName(String itemName) {
        this.itemName = itemName;
    }
    public ItemStatus getStatus() {
        return status;
    }
    public void setStatus(ItemStatus status) {
        this.status = status;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
}
