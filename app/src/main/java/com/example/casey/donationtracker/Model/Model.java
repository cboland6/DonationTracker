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

    /**
     * Get the single instance
     * @return an instance of Model
     */
    public static Model getInstance() { return _instance; }

    // the current user using the app
    private Account _currentAccount;

    //the selected location to view items of
    private Location _currentLocation;

    // Used for searching so "Any Location" is an option
    public static final Location dummyLocation = new Location("0", "Any", "", "", "", "", "", "", "", "", "");

    AppDatabase db;

    /**
     * Configure the local database (should be called in the main Activity's onCreate() method)
     * @param context the context of the app
     */
    public void configureDatabase(Context context) {
        db = Room.databaseBuilder(context,
                AppDatabase.class, "database-name")
                .allowMainThreadQueries()
                .fallbackToDestructiveMigration()
                .build();
    }

    // Methods involving accounts

    /**
     * Add an account with the input parameters to the local database.
     * @param username the username for the new account (must be unique when compared to an existing
     *                 username)
     * @param password the password for the new account
     * @param role the new account's role
     * @return true if the account was successfully added to the database. false if the username
     *      field is not unique
     */
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

    /**
     * Getter for the current account logged in to the app
     * @return the current account
     */
    public Account getCurrentAccount() {
        return _currentAccount;
    }

    public List<Account> getUsers() {
        return db.userDao().getAll();
    }

    /**
     * Returns a count of the existing locations
     * @return the number of locations in the database
     */
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


    // Methods involving locations
    /**
     * Adds a location to the database
     * @param loc the new location to add to the database
     */
    public void addLocation(Location loc) {
        db.locationDao().insert(loc);
    }

    /**
     * Gets the list of locations from the database
     * @return the list of existing locations
     */
    public List<Location> getLocations() { return db.locationDao().getAll(); }

    public Location getCurrentLocation() {
        return _currentLocation;
    }

    /**
     * Sets the current location field to the input location
     * @param loc the new current location
     */
    public void setCurrentLocation(Location loc) {
        this._currentLocation = loc;
    }

    // Methods involving items

    /**
     * Adds a new item to the database
     * @param time time the item was received at the location
     * @param itemLoc the location where the item was received
     * @param shortD short description of the item
     * @param fullD full description of the item
     * @param val value of the item (in dollars)
     * @param cat category of the item
     */
    public void addItem(LocalDateTime time, Location itemLoc, String shortD, String fullD,
                        int val, Category cat) {
        Item item = new Item(time, itemLoc.getUniqueKey(), shortD, fullD, val, cat);
        db.itemDao().insert(item);
    }

    public List<Item> getItems() {
        return db.itemDao().getAll();
    }

    /**
     * Gets all items at the current location
     * @return the list of existing items at the current location
     */
    public List<Item> getItemsAtCurrentLocation() {
        return db.itemDao().getItemsAtLocation(_currentLocation.getUniqueKey());
    }

    /**
     * Gets a list of items matching the search criteria.  If all three parameters are null,
     *      simply returns a list of all existing items. For any parameter that is null, ignore
     *      that field when searching.
     * @param loc the location to search for (can be null)
     * @param cat the category to search for (can be null)
     * @param phrase the phrase to search for (can be null)
     * @return the list of items that match the search parameters.
     */
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
