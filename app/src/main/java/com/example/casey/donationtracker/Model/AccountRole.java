package com.example.casey.donationtracker.Model;

public enum AccountRole {
    ADMIN("admin"), GENERAL("general"), MANAGER("manager"), LOCATION_EMPLOYEE("location employee");

    private final String _accountRole;

    AccountRole(String accountRole) {
        _accountRole = accountRole;
    }

    public String toString() {
        return _accountRole;
    }
}
