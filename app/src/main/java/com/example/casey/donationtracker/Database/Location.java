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

    /**
     * 11 arg constructor to create a new Location
     * @param uniqueKey the unique key associated with the location. Cannot be null
     * @param name the location's name
     * @param latitude the location's latitude
     * @param longitude the location's longitude
     * @param streetAddress the location's street address
     * @param city the location's city
     * @param state the location's state
     * @param zip the location's zip code
     * @param type the location's type
     * @param phone the location's phone number
     * @param website the location's website
     */
    public Location(@NonNull String uniqueKey, String name, String latitude, String longitude, String streetAddress,
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

    /**
     * Getter for the location's unique key
     * @return the location's unique key field
     */
    @NonNull
    public String getUniqueKey() {
        return uniqueKey;
    }

    /**
     * Setter for the location's unique key
     * @param uniqueKey the unique key associated with the location. Cannot be null
     */
    public void setUniqueKey(@NonNull String uniqueKey) {
        this.uniqueKey = uniqueKey;
    }

    /**
     * Getter for the location's name
     * @return the location's name
     */
    public String getName() {
        return name;
    }

    /**
     * Setter for the location's name
     * @param name the new location name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Getter for the location's latitude
     * @return the location's latitude
     */
    public String getLatitude() {
        return latitude;
    }

    /**
     * Setter for the location's latitude
     * @param latitude the new latitude
     */
    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    /**
     * Getter for the location's longitude
     * @return the location's longitude
     */
    public String getLongitude() {
        return longitude;
    }

    /**
     * Setter for the location's longitude
     * @param longitude the new longitude
     */
    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    /**
     * Getter for the location's street address
     * @return the location's street address
     */
    public String getStreetAddress() {
        return streetAddress;
    }

    /**
     * Setter for the location's street address
     * @param streetAddress the new street address
     */
    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    /**
     * Getter for the location's city
     * @return the location's city
     */
    public String getCity() {
        return city;
    }

    /**
     * Setter for the location's city
     * @param city the new city
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * Getter for the location's state
     * @return the location's state
     */
    public String getState() {
        return state;
    }

    /**
     * Setter for the location's state
     * @param state the new state
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     * Getter for the location's zip code
     * @return the location's zip code
     */
    public String getZip() {
        return zip;
    }

    /**
     * Setter for the location's zip code
     * @param zip the new zip code
     */
    public void setZip(String zip) {
        this.zip = zip;
    }

    /**
     * Getter for the location's type
     * @return the location's type
     */
    public String getType() {
        return type;
    }

    /**
     * Setter for the location's type
     * @param type the new type
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * Getter for the location's phone number
     * @return the location's phone number
     */
    public String getPhone() {
        return phone;
    }

    /**
     * Setter for the location's phone number
     * @param phone the new phone number
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * Getter for the location's website
     * @return the location's website
     */
    public String getWebsite() {
        return website;
    }

    /**
     * Setter for the location's website
     * @param website the new website
     */
    public void setWebsite(String website) {
        this.website = website;
    }

    /**
     * Getter for the location's address
     * @return the location's address
     */
    public String getAddress() {
        return address;
    }

    /**
     * Setter for the location's address
     * @param address the new address
     */
    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return this.name;
    }
}