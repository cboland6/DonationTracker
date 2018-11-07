package com.example.casey.donationtracker.Database;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import com.example.casey.donationtracker.Model.AccountRole;

@Entity
public class Account {
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "username")
    private String username;

    @ColumnInfo(name = "password")
    private String password;

    @ColumnInfo(name = "role")
    private AccountRole role;

    /**
     * A constructor for an Account
     */
    public Account() {
        this("_", null, AccountRole.GENERAL);
    }

    /**
     * Three arg constructor for Account
     * @param username the username for the new account
     * @param password the password for the new account
     * @param role the new account's role
     */
    public Account(@NonNull String username, String password, AccountRole role) {
        this.username = username;
        this.password = password;
        this.role = role;
    }

    /**
     * getter for Account's username
     * @return the username
     */
    @NonNull
    public String getUsername() {
        return username;
    }

    /**
     * getter for password
     * @return the Account's password
     */
    public String getPassword() {
        return password;
    }

    /**
     * getter for Role
     * @return the Account's role
     */
    public AccountRole getRole() {
        return role;
    }

    /** setter for username
     *
     * @param username the new username
     */
    public void setUsername(@NonNull String username) {
        this.username = username;
    }

    /**
     * setter for password
     * @param password the new password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /** setter for Role
     *
     * @param role the new Role
     */
    public void setRole(AccountRole role) {
        this.role = role;
    }
}