package com.example.casey.donationtracker.Controllers;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.casey.donationtracker.R;
import com.example.casey.donationtracker.Model.Account;
import com.example.casey.donationtracker.Model.AccountRole;
import com.example.casey.donationtracker.Model.Model;

public class RegScreen extends AppCompatActivity {

    // Widgets
    private EditText usernameField;
    private EditText passwordField;
    private Spinner roleSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg_screen);

        // grab dialog widgets for later
        usernameField = (EditText) findViewById(R.id.regUserName);
        passwordField = (EditText) findViewById(R.id.regPassword);
        roleSpinner = (Spinner) findViewById(R.id.chooseUserType);

        // setup adapter to show possible Account Roles
        ArrayAdapter<AccountRole> roleAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, AccountRole.values());
        roleAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        roleSpinner.setAdapter(roleAdapter);
    }


    // Error message for username
    public void usernameDialog() {
        AlertDialog.Builder userBuilder = new AlertDialog.Builder(RegScreen.this);
        View userView = getLayoutInflater().inflate(R.layout.dialog_user, null);
        TextView mUserText = (TextView) userView.findViewById(R.id.userText);

        userBuilder.setView(userView);
        userBuilder.create().show();
    }

    // Error message for password
    public void passwordDialog() {
        AlertDialog.Builder passBuilder = new AlertDialog.Builder(RegScreen.this);
        View passView = getLayoutInflater().inflate(R.layout.dialog_pass, null);
        TextView mPassText = (TextView) passView.findViewById(R.id.passText);

        passBuilder.setView(passView);
        passBuilder.create().show();
    }

    //need register method here
    public void onRegisterPressed(View view) {
        Model model = Model.getInstance();
        String username = usernameField.getText().toString();
        String password = passwordField.getText().toString();
        AccountRole accountRole = (AccountRole) roleSpinner.getSelectedItem();

        // if statements make sure that a username and password is input
        if(usernameField.getText().length() <= 0)
            usernameDialog();

        else if(passwordField.getText().length() <= 0)
            passwordDialog();

        else {
            Account newAccount = new Account(username, password, accountRole);
            model.addAccount(newAccount);
        }

        finish();
    }

}