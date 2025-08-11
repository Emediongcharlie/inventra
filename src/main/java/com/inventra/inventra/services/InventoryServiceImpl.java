package com.inventra.inventra.services;

import com.inventra.inventra.data.models.Assignment;
import com.inventra.inventra.data.models.ItemStatus;
import com.inventra.inventra.data.models.Items;
import com.inventra.inventra.data.models.Users;
import com.inventra.inventra.data.repositories.AssignmentRepo;
import com.inventra.inventra.data.repositories.InventoryManagerRepo;
import com.inventra.inventra.data.repositories.ItemsRepo;
import com.inventra.inventra.data.repositories.UserRepo;
import com.inventra.inventra.dtos.requests.AssignItemRequest;
import com.inventra.inventra.dtos.requests.TrackItemStatusRequest;
import com.inventra.inventra.dtos.responses.AssignItemsResponse;
import com.inventra.inventra.dtos.responses.TrackItemStatusResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class InventoryServiceImpl implements InventoryServices{

    @Autowired
    AssignmentRepo assignmentRepo;
    @Autowired
    ItemsRepo itemsRepo;
    @Autowired
    private UserRepo userRepo;


    @Override
    public AssignItemsResponse assignItems(AssignItemRequest assignItemRequest) {
        Assignment assignment = new Assignment();
        assignment.setItemId(assignItemRequest.getItemId());
        assignment.setCollectorId(assignItemRequest.getCollectorId());

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd, HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        assignment.setAssignmentDateTime(now);

        // Calculate return date based on duration type
        LocalDateTime returnDate = switch (assignItemRequest.getDurationType()) {
            case DAYS -> now.plusDays(assignItemRequest.getDurationValue());
            case WEEKS -> now.plusWeeks(assignItemRequest.getDurationValue());
            case MONTHS -> now.plusMonths(assignItemRequest.getDurationValue());
            default -> throw new IllegalArgumentException("Unknown duration type");
        };

        assignment.setReturnDateTime(returnDate);
        assignmentRepo.save(assignment);

        AssignItemsResponse assignItemsResponse = new AssignItemsResponse();
        assignItemsResponse.setItemId(assignment.getItemId());
        assignItemsResponse.setCollectorId(assignment.getCollectorId());
        assignItemsResponse.setAssignmentDateTime(assignment.getAssignmentDateTime().format(formatter));
        assignItemsResponse.setReturnDateTime(assignment.getReturnDateTime().format(formatter));
        assignItemsResponse.setItemStatus(ItemStatus.ASSIGNED);
        assignItemsResponse.setMessage("Item assigned");
        return assignItemsResponse;
    }

    @Override
    public TrackItemStatusResponse trackStatus(TrackItemStatusRequest trackItemStatusRequest) {

        Items item = itemsRepo.findById(trackItemStatusRequest.getItems().getItemId())
                .orElseThrow(() -> new RuntimeException("Id not found"));

        TrackItemStatusResponse response = new TrackItemStatusResponse();
        response.setItemId(item.getItemId());
        response.setItemName(item.getName());
        response.setStatus(item.getItemStatus());
        response.setMessage("Item status retrieved successfully");
        return response;
    }
}
