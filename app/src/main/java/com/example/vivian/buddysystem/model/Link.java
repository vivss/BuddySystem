package com.example.vivian.buddysystem.model;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by Charlotte on 2/10/2018.
 */

public class Link {
    private User buddyA;
    private User buddyB;
    private Date start;
    private Date end;

    public Link(User buddyA, User buddyB, int hours) {
        this.buddyA = buddyA;
        this.buddyB = buddyB;
        this.start = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        cal.add(Calendar.HOUR_OF_DAY, hours); // adds hours
        this.end = cal.getTime();
    }


}
