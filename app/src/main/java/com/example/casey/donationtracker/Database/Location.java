package com.example.casey.donationtracker.Database;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity
public class Location {
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "unique_key")
    private String uniqueKey;

    @ColumnInfo(name = "name")
    private String name;

    @ColumnInfo(name = "latitude")
    private String latitude;

    @ColumnInfo(name = "longitude")
    private String longitude;

    @ColumnInfo(name = "street_address")
    private String streetAddress;

    @ColumnInfo(name = "city")
    private String city;

    @ColumnInfo(name = "state")
    private String state;

    @ColumnInfo(name = "zip")
    private String zip;

    @ColumnInfo(name = "type")
    private String type;

    @ColumnInfo(name = "phone")
    private String phone;

    @ColumnInfo(name = "website")
    private String website;

    @ColumnInfo(name = "address")
    private String address;

    public Location(String uniqueKey, String name, String latitude, String longitude, String streetAddress,
                    String city, String state, String zip, String type, String phone, String website) {
        this.uniqueKey = uniqueKey;
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
        this.streetAddress = streetAddress;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.type = type;
        this.phone = phone;
        this.website = website;
        this.address = streetAddress + ", " + city + ", " + state + ", " + zip;
    }

    @NonNull
    public String getUniqueKey() {
        return uniqueKey;
    }

    public void setUniqueKey(@NonNull String uniqueKey) {
        this.uniqueKey = uniqueKey;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}