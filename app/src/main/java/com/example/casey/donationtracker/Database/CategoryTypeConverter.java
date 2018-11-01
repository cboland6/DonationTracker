package com.example.casey.donationtracker.Database;

import android.arch.persistence.room.TypeConverter;

import com.example.casey.donationtracker.Model.Category;

public class CategoryTypeConverter {
    /** Need this class to be able to store Category objects in local database */
    @TypeConverter
    public int convertCategoryToInteger(Category category) {
        return category.ordinal();
    }

    @TypeConverter
    public Category convertIntegerToCategory(int i) {
        return Category.values()[i];
    }
}
