package com.inventra.inventra.dtos.requests;

import com.inventra.inventra.data.models.Category;
import jakarta.persistence.ManyToOne;

public class AddItemRequest {

    private String name;
    private String description;

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private Category category;
}
