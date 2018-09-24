package com.example.casey.donationtracker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class LoginScreen extends AppCompatActivity {

    // Widgets
    EditText username;
    EditText password;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_screen);

        // Grab widgets
        username = (EditText)findViewById(R.id.usernameHere);
        password = (EditText)findViewById(R.id.passwordHere);


    }

    public void login(View view) {
        if (username.getText().toString().equals("user") && password.getText().toString().equals("pass")) {
            startActivity(new Intent(LoginScreen.this, HomeScreen.class));
        } else {
            //TODO: display login failure message here
        }
    }

    public void onCancelPressed(View view) {
        finish();
    }

}
