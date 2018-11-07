package com.example.casey.donationtracker.Model;

public enum Category { ALL("Any"),
    CLOTHING("Clothing"), HAT("Hat"), KITCHEN("Kitchen"), ELECTRONICS("Electronics"),
    HOUSEHOLD("Household"), OTHER("Other");

    private final String CategoryView;

    Category(String standard) { CategoryView = standard;}

    public String toString() { return CategoryView; }
}
//this is for the item class to use as the category