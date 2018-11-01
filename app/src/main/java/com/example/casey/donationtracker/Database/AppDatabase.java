package com.example.casey.donationtracker.Database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.TypeConverters;

@Database(entities = {Account.class, Location.class, Item.class}, version = 6)
@TypeConverters({AccountRoleTypeConverter.class, CategoryTypeConverter.class, LocalDateTimeTypeConverter.class})
public abstract class AppDatabase extends RoomDatabase {
    public abstract AccountDao userDao();
    public abstract LocationDao locationDao();
    public abstract ItemDao itemDao();
}
