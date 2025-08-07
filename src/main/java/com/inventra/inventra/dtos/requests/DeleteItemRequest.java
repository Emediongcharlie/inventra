package com.inventra.inventra.dtos.requests;

import com.inventra.inventra.data.models.Category;
import jakarta.persistence.ManyToOne;

public class DeleteItemRequest {

    private String name;

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private Category category;

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    private Long itemId;
}
