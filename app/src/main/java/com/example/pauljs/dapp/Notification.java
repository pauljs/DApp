package com.example.pauljs.dapp;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;
import com.activeandroid.query.Select;

import java.util.Date;
import java.util.List;

/**
 * Created by pauljs on 10/19/2015.
 */

@Table(name = "Notifications")
public class Notification extends Model {
    @Column(name = "Message")
    public String message;

    @Column(name = "Date")
    public Date date;

    public Notification() {
        super();
    }

    public Notification(String message, Date date) {
        super();
        this.message = message;
        this.date = date;
    }

    public String getFormattedString() {
        return "Date: " + date.toString() + "\nNotification Message: " + message;
    }

    public static List<Notification> getSortedNotifications() {
        return new Select()
                .from(Notification.class)
                .orderBy("Date DESC")
                .execute();
    }
}
