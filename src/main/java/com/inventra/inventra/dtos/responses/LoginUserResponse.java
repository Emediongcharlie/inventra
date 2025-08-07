package com.inventra.inventra.dtos.responses;

public class LoginUserResponse {

    private Long userId;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    private String message;
}
