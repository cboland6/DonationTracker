package com.example.casey.donationtracker.Model;

public class Account {

    private String _username;
    private String _password;
    private AccountRole _role;

    // No setters for now. Can see the account information, but currently there is no need to
    // modify an account (maybe later can update to allow changing passwords)
    public String getUsername() {
        return _username;
    }

    public AccountRole getRole() {
        return _role;
    }

    /**
     * Check if the passed in password matches the Account's password
     * @param password the input password to test
     * @return true if the passwords match (else false)
     */

    public boolean validatePassword(String password) {
        return _password.equals(password);
    }


    /**
     * Make a new account
     * @param username the account's username
     * @param password the account's password
     * @param role the account's role
     */
    public Account(String username, String password, AccountRole role) {
        _username = username;
        _password = password;
        _role = role;
    }

}
