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
    private LocalDateTime timeStamp;

    @NonNull
    @ColumnInfo(name = "location_key")
    private String locationKey;

    @NonNull
    @ColumnInfo(name = "short_description")
    private String shortDescription;

    @NonNull
    @ColumnInfo(name = "full_description")
    private String fullDescription;

    @NonNull
    @ColumnInfo(name = "value")
    private int value;

    @NonNull
    @ColumnInfo(name = "category")
    private Category category;

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
     * setter fot timeStamp
     * @param timeStamp the new timeStamp
     */
    public void setTimeStamp(@NonNull LocalDateTime timeStamp) {
        this.timeStamp = timeStamp;
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
     * setter for location key
     * @param locationKey the new location key
     */
    public void setLocationKey(@NonNull String locationKey) {
        this.locationKey = locationKey;
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
     * setter for short description
     * @param shortDescription the new short description
     */
    public void setShortDescription(@NonNull String shortDescription) {
        this.shortDescription = shortDescription;
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
     * setter for full description
     * @param fullDescription the new full description
     */
    public void setFullDescription(@NonNull String fullDescription) {
        this.fullDescription = fullDescription;
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
     * setter for value
     * @param value the new value
     */
    public void setValue(int value) {
        this.value = value;
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
     * setter for category
     * @param category the new category
     */
    public void setCategory(@NonNull Category category) {
        this.category = category;
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
