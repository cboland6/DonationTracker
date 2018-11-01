package com.example.casey.donationtracker.Model;

import android.arch.persistence.room.Room;
import android.content.Context;
import android.database.sqlite.SQLiteConstraintException;
import android.util.Log;

import com.example.casey.donationtracker.Database.Account;
import com.example.casey.donationtracker.Database.AppDatabase;
import com.example.casey.donationtracker.Database.ItemDao;
import com.example.casey.donationtracker.Database.Location;
import com.example.casey.donationtracker.Database.Item;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Model {


    /** Singleton instance */
    private static final Model _instance = new Model();
    public static Model getInstance() { return _instance; }

    // the current user using the app
    private Account _currentAccount;

    //the selected location to view items of
    private Location _currentLocation;

    AppDatabase db;

    public void configureDatabase(Context context) {
        db = Room.databaseBuilder(context,
                AppDatabase.class, "database-name")
                .allowMainThreadQueries()
                .fallbackToDestructiveMigration()
                .build();
    }

    /** Methods involving accounts */
    public boolean addAccount(String username, String password, AccountRole role) {
        Account u = new Account(username, password, role);
        // Check if the username is already taken, will throw constraint exception if
        // the username already exists, will successfully add the account if the username is new
        try {
            db.userDao().insert(u);
        } catch (SQLiteConstraintException e) {
            return false;
        }
        return true;
    }

    public Account getCurrentAccount() {
        return _currentAccount;
    }

    public List<Account> getUsers() {
        return db.userDao().getAll();
    }

    public int getLocationCount() {
        return db.locationDao().countLocations();
    }

    /**
     * Check the passed in login credentials against known account credentials
     * @param username the username of the account to check
     * @param password the password
     * @return true if the credentials are valid
     */
    public boolean login(String username, String password) {
        Account account = db.userDao().findByName(username);
        if (account == null || !validatePassword(account, password)) {
            return false;
        } else {
            _currentAccount = account;
            return true;
        }
    }

    private boolean validatePassword(Account account, String password) {
        if (account != null) {
            return account.getPassword().equals(password);
        } else {
            return false;
        }
    }


    /** Methods involving locations */
    public void addLocation(com.example.casey.donationtracker.Database.Location loc) {
        db.locationDao().insert(loc);
    }

    public List<Location> getLocations() { return db.locationDao().getAll(); }

    public Location getCurrentLocation() {
        return _currentLocation;
    }

    public void setCurrentLocation(Location loc) {
        this._currentLocation = loc;
    }

    


    /** Methods involving items */

    public void addItem(LocalDateTime time, Location itemLoc, String shortD, String fullD,
                        int val, Category cat) {
        Item item = new Item(time, itemLoc.getUniqueKey(), shortD, fullD, val, cat);
    }

    public List<Item> getItems() {
        return db.itemDao().getAll();
    }

    public List<Item> getMatchingItems(Location loc, Category cat, String phrase) {
        // Will return items matching the parameters
        ItemDao itemDao = db.itemDao();
        List<Item> results = new ArrayList<>();
        if (loc != null && cat != null && phrase != null) {
            results = itemDao.getItemsAtLocation(loc.getUniqueKey(), cat, phrase);
        } else if (loc != null && cat != null) {
            results = itemDao.getItemsAtLocation(loc.getUniqueKey(), cat);
        } else if (loc != null && phrase != null) {
            results = itemDao.getItemsAtLocation(loc.getUniqueKey(), phrase);
        } else if (loc != null) {
            results = itemDao.getItemsAtLocation(loc.getUniqueKey());
        } else if (cat != null && phrase != null) {
            results = itemDao.getItemsWithCategory(cat, phrase);
        } else if (cat != null) {
            results = itemDao.getItemsWithCategory(cat);
        } else if (phrase != null) {
            results = itemDao.getItemsWithPhrase(phrase);
        }
        return results;
    }
}
