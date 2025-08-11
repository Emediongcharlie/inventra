package com.inventra.inventra.dtos.requests;

import com.inventra.inventra.data.models.ItemStatus;
import com.inventra.inventra.data.models.Items;

public class TrackItemStatusRequest {

    public ItemStatus getItemStatus() {
        return itemStatus;
    }

    public void setItemStatus(ItemStatus itemStatus) {
        this.itemStatus = itemStatus;
    }

    public Items getItems() {
        return items;
    }

    public void setItems(Items items) {
        this.items = items;
    }

    private ItemStatus itemStatus;
    private Items items;


}
