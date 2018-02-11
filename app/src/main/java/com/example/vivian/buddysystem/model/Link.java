package com.example.vivian.buddysystem.model;

import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

/**
 * Created by Charlotte on 2/10/2018.
 */

public class Link {
    private UUID id;
    private String buddyA;
    private String buddyB;
    private Date start;
    private Date end;
    private int distance;

    public Link(String buddyA, String buddyB, int hours, int distance) {
        this.id = UUID.randomUUID();
        this.buddyA = buddyA;
        this.buddyB = buddyB;
        this.start = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        cal.add(Calendar.HOUR_OF_DAY, hours); // adds hours
        this.end = cal.getTime();
        this.distance = distance;
    }

    public Link(UUID id){
        this.id = id;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getBuddyA() {
        return buddyA;
    }

    public void setBuddyA(String buddyA) {
        this.buddyA = buddyA;
    }

    public String getBuddyB() {
        return buddyB;
    }

    public void setBuddyB(String buddyB) {
        this.buddyB = buddyB;
    }

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public int getSpace(){
        return 20;
    }
}
