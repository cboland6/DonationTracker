package com.example.casey.donationtracker.Model;

public enum AccountRole {
    ADMIN("admin", true), GENERAL("general", false), MANAGER("manager", true), LOCATION_EMPLOYEE("location employee", true);

    private final String _accountRole;
    private final boolean _canEditInventory;

    AccountRole(String accountRole, boolean canEditInventory) {

        _accountRole = accountRole;
        _canEditInventory = canEditInventory;
    }
    public String toString() {
        return _accountRole;
    }
}
