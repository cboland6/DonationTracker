package com.example.casey.donationtracker.Model;

import java.util.List;
import java.util.ArrayList;

public class LocationList {
    public static final LocationList INSTANCE = new LocationList();

    private List<Location> locations;

    private LocationList() { locations = new ArrayList<>(); }

    public void addLocation(Location loc) { locations.add(loc); }

    public List<Location> getLocations() { return locations; }



}
