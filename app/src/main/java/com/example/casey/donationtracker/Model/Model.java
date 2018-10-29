package com.example.casey.donationtracker.Model;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Model {


    /** Singleton instance */
    private static final Model _instance = new Model();
    public static Model getInstance() { return _instance; }


    /** list of all accounts */
    private List<Account> _accounts;
    private List<Location> _locations;

    // the current account using the app
    private Account _currentAccount;

    //the selected location to view items of
    private Location _currentLocation;

    //the database
    final FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference ref = database.getReference();
    DatabaseReference usersRef = ref.child("users");

    private Model() {
        _accounts = new ArrayList<>();
        _locations = new ArrayList<>();
    }

    public void addLocation(Location loc) { _locations.add(loc); }

    public List<Location> getLocations() { return _locations; }

    public Location getCurrentLocation() { return _currentLocation; }

    public void setCurrentLocation(Location loc) {
        this._currentLocation = loc;
    }

    public void clearLocations() { this._locations = new ArrayList<>(); }

    public boolean addAccount(Account account) {
        for (Account c : _accounts ) {
            if (c.equals(account)) return false;
        }
        _accounts.add(account);
        //add account to database here
        usersRef.setValue(_accounts);
        return true;
    }

    public Account findAccountByUsername(String username) {
        for (Account a : _accounts) {
            if (username.equals(a.getUsername())) {
                return a;
            }
        }
        return null;
    }


    /**
     * Check the passed in login credentials against known account credentials
     * @param username the username of the account to check
     * @param password the password
     * @return true if the credentials are valid
     */
    public boolean login(String username, String password) {
        Account account = findAccountByUsername(username);
        if (account == null || !account.validatePassword(password)) {
            return false;
        } else {
            _currentAccount = account;
            return true;
        }
    }

    
    public Account getCurrentAccount() {
        return _currentAccount;
    }
}
