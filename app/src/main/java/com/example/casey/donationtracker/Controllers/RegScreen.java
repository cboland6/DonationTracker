package com.example.casey.donationtracker.Controllers;

import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.casey.donationtracker.Model.Account;
import com.example.casey.donationtracker.Model.AccountRole;
import com.example.casey.donationtracker.Model.Model;
import com.example.casey.donationtracker.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class RegScreen extends AppCompatActivity {

    // Widgets
    private EditText usernameField;
    private EditText passwordField;
    private Spinner roleSpinner;
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference("message");



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg_screen);

        // grab dialog widgets for later
        usernameField = findViewById(R.id.regUserName);
        passwordField = findViewById(R.id.regPassword);
        roleSpinner = findViewById(R.id.chooseUserType);



        // setup adapter to show possible Account Roles
        ArrayAdapter<AccountRole> roleAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, AccountRole.values());
        roleAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        roleSpinner.setAdapter(roleAdapter);
    }


    // Error message for username
    public void usernameDialog() {
        AlertDialog.Builder userBuilder = new AlertDialog.Builder(RegScreen.this);
        View userView = getLayoutInflater().inflate(R.layout.dialog_user, null);
        TextView mUserText = userView.findViewById(R.id.userText);

        userBuilder.setView(userView);
        userBuilder.create().show();
    }

    // Error message for password
    public void passwordDialog() {
        AlertDialog.Builder passBuilder = new AlertDialog.Builder(RegScreen.this);
        View passView = getLayoutInflater().inflate(R.layout.dialog_pass, null);
        TextView mPassText = passView.findViewById(R.id.passText);

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
        if (usernameField.getText().length() <= 0)
            usernameDialog();

        else if (passwordField.getText().length() <= 0)
            passwordDialog();

        else {
            Account newAccount = new Account(username, password, accountRole);
            model.addAccount(newAccount);
            //add account to database here
            myRef.child("accounts").setValue(newAccount);
            finish();
        }
    }
}