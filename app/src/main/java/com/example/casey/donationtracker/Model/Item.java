package com.example.casey.donationtracker.Model;

import java.sql.Timestamp;
import java.util.Date;

public class Item {
    private Timestamp timeStamp;
    private Location itemLocation;
    private String shortDescription;
    private String fullDescription;
    private int value;
    private Category category;

    public Item(Location itemLocation, String shortDescription, String fullDescription,
                int value, Category category) {

        this.timeStamp = new Timestamp(System.currentTimeMillis());
        this.itemLocation = itemLocation;
        this.shortDescription = shortDescription;
        this.fullDescription = fullDescription;
        this.value = value;
        this.category = category;
    }

    public Timestamp getTimeStamp() { return timeStamp; }
    public Location getItemLocation() { return itemLocation; }
    public String getShortDescription() { return shortDescription; }
    public String getFullDescription() { return fullDescription; }
    public int getValue() { return value; }
    public Category getCategory() { return category; }

}
