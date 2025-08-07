package com.inventra.inventra.services;

import com.inventra.inventra.dtos.requests.AddItemRequest;
import com.inventra.inventra.dtos.requests.DeleteItemRequest;
import com.inventra.inventra.dtos.requests.FindByItemNameRequest;
import com.inventra.inventra.dtos.requests.UpdateItemsRequest;
import com.inventra.inventra.dtos.responses.AddItemsResponse;
import com.inventra.inventra.dtos.responses.DeleteItemResponse;
import com.inventra.inventra.dtos.responses.FindByItemNameResponse;
import com.inventra.inventra.dtos.responses.UpdateItemResponse;

public interface ItemsServices {

    AddItemsResponse addNewItem(AddItemRequest addItemRequest);;
    FindByItemNameResponse findAnItem(FindByItemNameRequest findByItemNameRequest);;
    UpdateItemResponse updateItem(UpdateItemsRequest updateItemRequest);;
    DeleteItemResponse deleteItem(DeleteItemRequest deleteItemRequest);
}
