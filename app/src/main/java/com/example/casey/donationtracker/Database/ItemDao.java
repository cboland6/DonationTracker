package com.example.casey.donationtracker.Database;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.example.casey.donationtracker.Model.Category;

import java.util.List;

@Dao
public interface ItemDao {
    @Query("SELECT * FROM Item")
    List<Item> getAll();

    @Query("SELECT * FROM Item WHERE location_key = :locationKey")
    List<Item> getItemsAtLocation(String locationKey);

    @Query("SELECT * FROM Item WHERE location_key = :locationKey AND category = :category")
    List<Item> getItemsAtLocation(String locationKey, Category category);

    @Query("SELECT * FROM Item WHERE location_key = :locationKey AND (short_description LIKE '%' || :phrase || '%' OR full_description LIKE '%' || :phrase || '%')")
    List<Item> getItemsAtLocation(String locationKey, String phrase);

    @Query("SELECT * FROM Item WHERE location_key = :locationKey AND category = :category AND (short_description LIKE '%' || :phrase || '%' OR full_description LIKE '%' || :phrase || '%')")
    List<Item> getItemsAtLocation(String locationKey, Category category, String phrase);

    @Query("SELECT * FROM Item WHERE category = :category")
    List<Item> getItemsWithCategory(Category category);

    @Query("SELECT * FROM Item WHERE category = :category AND (short_description LIKE '%' || :phrase || '%' OR full_description LIKE '%' || :phrase || '%')")
    List<Item> getItemsWithCategory(Category category, String phrase);

    @Query("SELECT * FROM Item WHERE short_description LIKE '%' || :phrase || '%' OR full_description LIKE '%' || :phrase || '%'")
    List<Item> getItemsWithPhrase(String phrase);

    @Insert
    void insertAll(Item ... items);

    @Insert
    void insert(Item item);

    @Delete
    void delete(Item item);
}