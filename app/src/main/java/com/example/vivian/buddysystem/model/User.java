package com.example.vivian.buddysystem.model;

import java.util.UUID;

/**
 * Created by Charlotte on 2/10/2018.
 */

public class User {
    private static final String TAG = "USER";

    public UUID getId() {
        return id;
    }

    private UUID id;
    private String username;
    private String name;
    private String phone;
    private String password;

    public User(UUID id) {
        this.id = id;
    }
    public User(String username, String password) {
        this.id = UUID.randomUUID();
        this.username = username;
        this.password = password;
        phone = "123123123";
        name = "Sample Person";
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String photo) {
        this.phone = photo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

