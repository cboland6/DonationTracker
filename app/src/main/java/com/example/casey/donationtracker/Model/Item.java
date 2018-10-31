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

    public Item(LocalDateTime time, Location itemLoc, String shortD, String fullD,
                int val, Category cat) {

        timeStamp = time;
        itemLocation = itemLoc;
        shortDescription = shortD;
        fullDescription = fullD;
        value = val;
        category = cat;
    }

    public void setComments(String com) { comments = com; }
    public LocalDateTime getTimeStamp() { return timeStamp; }
    public Location getItemLocation() { return itemLocation; }
    public String getShortDescription() { return shortDescription; }
    public String getFullDescription() { return fullDescription; }
    public int getValue() { return value; }
    public Category getCategory() { return category; }
    public String getComments() { return comments; }

}
