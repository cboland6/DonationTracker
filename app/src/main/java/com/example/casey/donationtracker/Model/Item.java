package com.example.casey.donationtracker.Model;

import java.util.Date;

public class Item {
    private Date timeStamp;
    private Location itemLocation;
    private String shortDescription;
    private String fullDescription;
    private int value;
    private Category category;

    public Item(Date timeStamp, Location itemLocation, String shortDescription, String fullDescription,
                int value, Category category) {

        this.timeStamp = timeStamp;
        this.itemLocation = itemLocation;
        this.shortDescription = shortDescription;
        this.fullDescription = fullDescription;
        this.value = value;
        this.category = category;
    }

    public Date getTimeStamp() { return timeStamp; }
    public Location getItemLocation() { return itemLocation; }
    public String getShortDescription() { return shortDescription; }
    public String getFullDescription() { return fullDescription; }
    public int getValue() { return value; }
    public Category getCategory() { return category; }

}
