package com.inventra.inventra.controllers;

import com.inventra.inventra.dtos.requests.AddItemRequest;
import com.inventra.inventra.dtos.requests.DeleteItemRequest;
import com.inventra.inventra.dtos.requests.FindByItemNameRequest;
import com.inventra.inventra.dtos.requests.UpdateItemsRequest;
import com.inventra.inventra.dtos.responses.*;
import com.inventra.inventra.services.ItemsServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/items/")
public class ItemController {

    @Autowired
    ItemsServices itemsServices;

    @PostMapping("add-new-item")
    public ResponseEntity<?> addItem(@RequestBody AddItemRequest request){
        try{
            AddItemsResponse response = itemsServices.addNewItem(request);
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("add-new-item")
    public ResponseEntity<?> findItem(@RequestBody FindByItemNameRequest request){
        try{
            FindByItemNameResponse response = itemsServices.findAnItem(request);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("update-item")
    public ResponseEntity<?> updateItems(@RequestBody UpdateItemsRequest request){
        try{
            UpdateItemResponse response = itemsServices.updateItem(request);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("delete-item")
    public ResponseEntity<?> deleteAnItem(@RequestBody DeleteItemRequest request){
        try{
            DeleteItemResponse response = itemsServices.deleteItem(request);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("delete-all-item")
    public ResponseEntity<?> deleteAllItem(){
        try{
            DeleteAllItemsResponse response = itemsServices.deleteAllItems();
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("report-an-item")
    public ResponseEntity<?> reportAnItem(){
        try{
            ItemsReportResponse response = itemsServices.reportItem();
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.NOT_FOUND);
        }
    }
}
