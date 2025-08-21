package com.inventra.inventra.controllers;

import com.inventra.inventra.data.models.Collectors;
import com.inventra.inventra.data.models.Items;
import com.inventra.inventra.dtos.requests.AssignItemRequest;
import com.inventra.inventra.dtos.requests.InventoryLevelReportRequest;
import com.inventra.inventra.dtos.requests.TrackItemStatusRequest;
import com.inventra.inventra.dtos.responses.AssignItemsResponse;
import com.inventra.inventra.dtos.responses.TrackItemStatusResponse;
import com.inventra.inventra.services.InventoryServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/inventory/")
public class InventoryController {

    @Autowired
    InventoryServices inventoryServices;

    @PostMapping("assign-items")
    public ResponseEntity<?> assignNewItem(@RequestBody AssignItemRequest request){
        try{
            AssignItemsResponse response = inventoryServices.assignItems((request));
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("track-status")
    public ResponseEntity<?> trackItemStatus(@RequestBody TrackItemStatusRequest request){
        try{
            TrackItemStatusResponse response = inventoryServices.trackStatus((request));
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("generate-report")
    public ResponseEntity<?> generateReports(@RequestBody InventoryLevelReportRequest request){
        try{
            List<Items> response = inventoryServices.generateReport((request));
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("generate-inventory-report")
    public ResponseEntity<?> generateInventoryReports(@RequestBody InventoryLevelReportRequest request){
        try{
            List<Collectors> response = inventoryServices.generateCollectorsReport((request));
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.NOT_FOUND);
        }
    }
}
