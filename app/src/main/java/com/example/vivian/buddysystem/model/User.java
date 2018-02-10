package com.example.vivian.buddysystem.model;

import java.util.UUID;

/**
 * Created by Charlotte on 2/10/2018.
 */

public class User {
    private static final String TAG = "USER";

    private UUID id;
    private String username;
    private String name;
    private String photo;
    private String password;

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

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

