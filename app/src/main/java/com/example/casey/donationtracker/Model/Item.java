package com.example.casey.donationtracker.Model;

import java.time.LocalDateTime;

public class Item {
    private LocalDateTime timeStamp;
    private Location itemLocation;
    private String shortDescription;
    private String fullDescription;
    private int value;
    private Category category;
    private String comments;

    public Item(LocalDateTime timeStamp, Location itemLocation, String shortDescription, String fullDescription,
                int value, Category category) {

        this.timeStamp = timeStamp;
        this.itemLocation = itemLocation;
        this.shortDescription = shortDescription;
        this.fullDescription = fullDescription;
        this.value = value;
        this.category = category;
    }

    public void setComments(String com) { this.comments = com; }
    public LocalDateTime getTimeStamp() { return timeStamp; }
    public Location getItemLocation() { return itemLocation; }
    public String getShortDescription() { return shortDescription; }
    public String getFullDescription() { return fullDescription; }
    public int getValue() { return value; }
    public Category getCategory() { return category; }
    public String getComments() { return comments; }

}
