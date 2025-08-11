package com.inventra.inventra.services;

import com.inventra.inventra.dtos.requests.AssignItemRequest;
import com.inventra.inventra.dtos.requests.TrackItemStatusRequest;
import com.inventra.inventra.dtos.responses.AssignItemsResponse;
import com.inventra.inventra.dtos.responses.TrackItemStatusResponse;

public interface InventoryServices {

    AssignItemsResponse assignItems(AssignItemRequest assignItemRequest);
    TrackItemStatusResponse trackStatus(TrackItemStatusRequest trackItemStatusRequest);

}
