package com.example.casey.donationtracker.Model;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Location {
    private String name;
    private String latitude;
    private String longitude;
    private String streetAddress;
    private String city;
    private String state;
    private String zip;
    private String type;
    private String phone;
    private String website;
    private String Address;
    private ArrayList<Item> items;

    public Location(String n, String lat, String lo, String sA,
                    String c, String s, String z, String t, String p, String w) {
        name = n;
        latitude = lat;
        longitude = lo;
        streetAddress = sA;
        city = c;
        state = s;
        zip = z;
        type = t;
        phone = p;
        website = w;
        Address = streetAddress + ", " + city + ", " + state + ", " + zip;
        items = new ArrayList<>();
    }


    public String toString() { return name; }

    public String getLocationName() { return name; }
    public String getLatitude() { return latitude; }
    public String getLongitude() { return longitude; }
    public String getAddress() { return Address; }
    public String getLocationType() { return type; }
    public String getLocationPhone() { return phone; }
    public String getWebsite() { return website; }
    public String getCity() { return city; }
    public ArrayList<Item> getItems() { return items; }

    public void addItem(LocalDateTime timeStamp, Location loc, String shortDescription, String fullDescription,
                        int value, Category category) {
        Item i = new Item(timeStamp, loc, shortDescription, fullDescription, value, category);
        //constructor found in the Item class
        items.add(i);
        //adds this item to the location's list of items

    }

}
