package com.aymericbocquet.rss.data.dto;

import com.aymericbocquet.rss.data.entity.User;

public class SuccessfulLoginDTO {
    private String token;

    public SuccessfulLoginDTO(String token) {
        this.token = token;
    }

    public SuccessfulLoginDTO(User user) {
        this.token = user.getToken();
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}