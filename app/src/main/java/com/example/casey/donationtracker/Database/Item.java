package com.example.casey.donationtracker.Database;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.support.annotation.NonNull;

import com.example.casey.donationtracker.Model.Category;

import java.time.LocalDateTime;

@Entity(primaryKeys = {"location_key", "time", "short_description", "full_description"})
public class Item {

    @NonNull
    @ColumnInfo(name = "time")
    private final LocalDateTime timeStamp;

    @NonNull
    @ColumnInfo(name = "location_key")
    private final String locationKey;

    @NonNull
    @ColumnInfo(name = "short_description")
    private final String shortDescription;

    @NonNull
    @ColumnInfo(name = "full_description")
    private final String fullDescription;

    @NonNull
    @ColumnInfo(name = "value")
    private final int value;

    @NonNull
    @ColumnInfo(name = "category")
    private final Category category;

    @ColumnInfo(name = "comments")
    private String comments;

    /**
     * constructor for and Item object
     *
     * @param timeStamp the time it was donated
     * @param locationKey where it was donated
     * @param shortDescription brief word or two
     * @param fullDescription detailed description
     * @param value its value
     * @param category type of donation
     */
    public Item(LocalDateTime timeStamp, String locationKey, String shortDescription, String fullDescription,
                int value, Category category) {

        this.timeStamp = timeStamp;
        this.locationKey = locationKey;
        this.shortDescription = shortDescription;
        this.fullDescription = fullDescription;
        this.value = value;
        this.category = category;
    }

    /**
     * getter for timestamp
     *
     * @return the item's timestamp
     */
    @NonNull
    public LocalDateTime getTimeStamp() {
        return timeStamp;
    }


    /**
     * getter for location key
     * @return the Item's location key
     */
    @NonNull
    public String getLocationKey() {
        return locationKey;
    }

    /**
     * getter for short description
     * @return the item's short description
     */
    @NonNull
    public String getShortDescription() {
        return shortDescription;
    }


    /**
     * getter for full description
     * @return the item's full description
     */
    @NonNull
    public String getFullDescription() {
        return fullDescription;
    }


    /**
     * getter for value
     * @return the item's value
     */
    @NonNull
    public int getValue() {
        return value;
    }


    /**
     * getter for category
     * @return the item's category
     */
    @NonNull
    public Category getCategory() {
        return category;
    }

    /**
     * getter for comments
     * @return the item's comments
     */
    public String getComments() {
        return comments;
    }

    /**
     * setter for comments
     * @param comments the new comments
     */
    public void setComments(String comments) {
        this.comments = comments;
    }
}
