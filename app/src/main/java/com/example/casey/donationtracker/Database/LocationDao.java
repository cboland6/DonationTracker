package com.example.casey.donationtracker.Database;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface LocationDao {
    @Query("SELECT * FROM Location")
    List<Location> getAll();

    @Query("SELECT * FROM Location WHERE name LIKE :name")
    Location findByName(String name);

    @Query("SELECT COUNT(*) FROM Location")
    int countLocations();

    @Insert(onConflict = OnConflictStrategy.FAIL)
    void insertAll(Location ... locations);

    @Insert(onConflict = OnConflictStrategy.FAIL)
    void insert(Location location);

    @Delete
    void delete(Location location);
}