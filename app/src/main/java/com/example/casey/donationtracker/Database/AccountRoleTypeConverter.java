package com.example.casey.donationtracker.Database;

import android.arch.persistence.room.TypeConverter;

import com.example.casey.donationtracker.Model.AccountRole;

public class AccountRoleTypeConverter {
    /** Need this class to be able to store AccountRole objects in local database */
    @TypeConverter
    public int convertAccountRoleToInteger(AccountRole role) {
        return role.ordinal();
    }

    @TypeConverter
    public AccountRole convertIntegerToAccountRole(int i) {
        return AccountRole.values()[i];
    }
}
