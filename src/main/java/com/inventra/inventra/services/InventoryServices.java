package com.inventra.inventra.services;

import com.inventra.inventra.data.models.Collectors;
import com.inventra.inventra.data.models.Items;
import com.inventra.inventra.dtos.requests.AssignItemRequest;
import com.inventra.inventra.dtos.requests.InventoryLevelReportRequest;
import com.inventra.inventra.dtos.requests.TrackItemStatusRequest;
import com.inventra.inventra.dtos.responses.AssignItemsResponse;
import com.inventra.inventra.dtos.responses.InventoryLevelReportResponse;
import com.inventra.inventra.dtos.responses.TrackItemStatusResponse;

import java.util.List;

public interface InventoryServices {

    AssignItemsResponse assignItems(AssignItemRequest assignItemRequest);
    TrackItemStatusResponse trackStatus(TrackItemStatusRequest trackItemStatusRequest);
    List<Items> generateReport(InventoryLevelReportRequest generateReportRequest);
    List<Collectors> generateCollectorsReport(InventoryLevelReportRequest generateReportRequest);
    InventoryLevelReportResponse getInventoryLevelReport(InventoryLevelReportRequest getInventoryLevelReportRequest);
}
