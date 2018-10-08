package com.example.casey.donationtracker.Model;

public class Location {
    private String name;
    private int latitude;
    private int longitude;
    private String streetAddress;
    private String city;
    private String state;
    private int zip;
    private String type;
    private String phone;
    private String website;
    private String Address;

    public Location(String n, int lat, int lo, String sA,
                    String c, String s, int z, String t, String p, String w) {
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
    }


    public String toString() { return name; }

    public String getLocationName() { return name; }
    public int getLatitude() { return latitude; }
    public int getLongitude() { return longitude; }
    public String getAddress() { return Address; }
    public String getLocationType() { return type; }
    public String getLocationPhone() { return phone; }
    public String getWebsite() { return website; }



}
