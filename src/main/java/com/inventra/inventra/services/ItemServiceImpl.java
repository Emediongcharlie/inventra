package com.inventra.inventra.services;

import com.inventra.inventra.data.models.Category;
import com.inventra.inventra.data.models.Items;
import com.inventra.inventra.data.repositories.CategoryRepo;
import com.inventra.inventra.data.repositories.ItemsRepo;
import com.inventra.inventra.dtos.requests.AddItemRequest;
import com.inventra.inventra.dtos.requests.DeleteItemRequest;
import com.inventra.inventra.dtos.requests.FindByItemNameRequest;
import com.inventra.inventra.dtos.requests.UpdateItemsRequest;
import com.inventra.inventra.dtos.responses.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemServiceImpl implements ItemsServices{
    @Autowired
    ItemsRepo itemsRepo;

    @Autowired
    CategoryRepo categoryRepo;


    @Override
    public AddItemsResponse addNewItem(AddItemRequest addItemRequest) {
        Category category = categoryRepo.findByCategoryId(addItemRequest.getCategory().getCategoryId())
                .orElseThrow(() -> new RuntimeException("Category not found"));

        Items item = new Items();
        item.setName(addItemRequest.getName());
        item.setDescription(addItemRequest.getDescription());
        item.setCategory(category);
        itemsRepo.save(item);
        AddItemsResponse addItemsResponse = new AddItemsResponse();
        addItemsResponse.setId(item.getItemId());
        addItemsResponse.setName(item.getName());
        addItemsResponse.setDescription(addItemRequest.getDescription());
        addItemsResponse.setCategory(item.getCategory());
        addItemsResponse.setMessage("Item added successfully");
        return addItemsResponse;
    }

    @Override
    public FindByItemNameResponse findAnItem(FindByItemNameRequest findByItemNameRequest) {
        Items item = itemsRepo.findByName(findByItemNameRequest.getItemName())
                .orElseThrow(() -> new RuntimeException("Item not found"));

        FindByItemNameResponse response = new FindByItemNameResponse();
        response.setItemId(item.getItemId());
        response.setItemName(item.getName());
        response.setDescription(item.getDescription());
        response.setCategory(item.getCategory().getCategoryName());

        return response;
    }

    @Override
    public UpdateItemResponse updateItem(UpdateItemsRequest updateItemRequest) {
        Items item = itemsRepo.findByName(updateItemRequest.getName())
                .orElseThrow(() -> new RuntimeException("Item not found"));

        Category category = categoryRepo.findByCategoryId(updateItemRequest.getCategory().getCategoryId())
                .orElseThrow(() -> new RuntimeException("Category not found"));

        item.setName(updateItemRequest.getName());
        item.setDescription(updateItemRequest.getDescription());
        item.setCategory(category);
        itemsRepo.save(item);

        UpdateItemResponse updateItemResponse = new UpdateItemResponse();
        updateItemResponse.setId(item.getItemId());
        updateItemResponse.setName(item.getName());
        updateItemResponse.setDescription(updateItemRequest.getDescription());
        updateItemResponse.setCategory(item.getCategory());

        return updateItemResponse;
    }

    @Override
    public DeleteItemResponse deleteItem(DeleteItemRequest deleteItemRequest) {
        Items item = itemsRepo.findByItemId(deleteItemRequest.getItemId())
                .orElseThrow(() -> new RuntimeException("Item not found"));

        itemsRepo.delete(item);
        DeleteItemResponse deleteItemResponse = new DeleteItemResponse();
        deleteItemResponse.setId(item.getItemId());
        deleteItemResponse.setMessage("Item " + item.getItemId() + " deleted successfully");
        return deleteItemResponse;
    }

    @Override
    public DeleteAllItemsResponse deleteAllItems() {
        itemsRepo.deleteAll();

        DeleteAllItemsResponse response = new DeleteAllItemsResponse();
        response.setMessage("Successfully Deleted All Items");
        return response;
    }

    @Override
    public ItemsReportResponse reportItem() {
        itemsRepo.findAll();

        ItemsReportResponse response = new ItemsReportResponse();
        response.setMessage("Successfully Reported Items");
        return response;
    }
}
