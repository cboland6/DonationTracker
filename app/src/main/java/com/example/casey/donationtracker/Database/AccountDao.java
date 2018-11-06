package com.example.casey.donationtracker.Database;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface AccountDao {
    @Query("SELECT * FROM Account")
    List<Account> getAll();

    @Query("SELECT * FROM Account WHERE username LIKE :username LIMIT 1")
    Account findByName(String username);

    @Insert
    void insertAll(Account... accounts);

    @Insert(onConflict = OnConflictStrategy.FAIL)
    void insert(Account account);

    @Delete
    void delete(Account account);
}