package com.example.casey.donationtracker.Model;

public enum AccountRole {
    ADMIN("admin"), GENERAL("general"), MANAGER("manager"), LOCATION_EMPLOYEE("location employee");

    private final String _accountRole;
    //private final boolean _canEditInventory;

    AccountRole(String accountRole) {

        _accountRole = accountRole;
        //_canEditInventory = canEditInventory;
    }

    public String toString() {
        return _accountRole;
    }
}
