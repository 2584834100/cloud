package com.cloud.entity;

import java.io.Serializable;

public class Authorization implements Serializable {

    private String token;

    public Authorization() {
    }

    public Authorization(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
