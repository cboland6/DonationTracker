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

    public Item(LocalDateTime timeStamp, String locationKey, String shortDescription, String fullDescription,
                int value, Category category) {

        this.timeStamp = timeStamp;
        this.locationKey = locationKey;
        this.shortDescription = shortDescription;
        this.fullDescription = fullDescription;
        this.value = value;
        this.category = category;
    }

    @NonNull
    public LocalDateTime getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(@NonNull LocalDateTime timeStamp) {
        this.timeStamp = timeStamp;
    }

    @NonNull
    public String getLocationKey() {
        return locationKey;
    }

    public void setLocationKey(@NonNull String locationKey) {
        this.locationKey = locationKey;
    }

    @NonNull
    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(@NonNull String shortDescription) {
        this.shortDescription = shortDescription;
    }

    @NonNull
    public String getFullDescription() {
        return fullDescription;
    }

    public void setFullDescription(@NonNull String fullDescription) {
        this.fullDescription = fullDescription;
    }

    @NonNull
    public int getValue() {
        return value;
    }

    public void setValue(@NonNull int value) {
        this.value = value;
    }

    @NonNull
    public Category getCategory() {
        return category;
    }

    public void setCategory(@NonNull Category category) {
        this.category = category;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }
}
