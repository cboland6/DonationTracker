package com.example.casey.donationtracker.Database;

import android.arch.persistence.room.TypeConverter;

import java.time.LocalDateTime;

public class LocalDateTimeTypeConverter {
    @TypeConverter
    public String convertLocalDateTimeToString(LocalDateTime date) {
        return date.toString();
    }

    @TypeConverter
    public LocalDateTime convertStringToLocalDateTime(String date) {
        return LocalDateTime.parse(date);
    }
}