package com.example.vivian.buddysystem.model;

import android.location.Location;

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
    private Location location;

    public User(UUID id) {
        this.id = id;
    }
    public User(String username, String password) {
        this.id = UUID.randomUUID();
        this.username = username;
        this.password = password;
        phone = "123123123";
        name = "Sample Person";
        Location loc = new Location(username);
        loc.setLatitude(26.016045);
        loc.setLongitude(24.40302);
        location = loc;
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

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public void setLocation(double lat, double lon){
        Location loc = new Location(username);
        loc.setLatitude(lat);
        loc.setLongitude(lon);
        location = loc;
    }

    public double getSpace(Location loc){
        double distance = location.distanceTo(loc);
        //if to convert to miles  * 0.000621371192237334;
        return distance;
    }

    public String getSpace(User b){
        Location loc = b.getLocation();
        double distance = location.distanceTo(loc);
        //if to convert to miles  * 0.000621371192237334;
        return String.valueOf(distance);
    }

    @Override
    public String toString(){
        return username;
    }
}

