package com.example.casey.donationtracker.Controllers;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.casey.donationtracker.R;
import com.example.casey.donationtracker.Model.Model;

public class LoginScreen extends AppCompatActivity {

    // Widgets
    EditText usernameField;
    EditText passwordField;
    Button loginButton;
    Button cancelButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_screen);

        // Grab widgets
        usernameField = (EditText)findViewById(R.id.editText);
        passwordField = (EditText)findViewById(R.id.editText2);
        loginButton = (Button)findViewById(R.id.log2);
        cancelButton = (Button)findViewById(R.id.cancelbutton);

    }

    public void login(View view) {
        Model model = Model.getInstance();

        String username = usernameField.getText().toString();
        String password = passwordField.getText().toString();

        boolean isLoggedIn = model.login(username, password);

        if (isLoggedIn) {
            startActivity(new Intent(LoginScreen.this, HomeScreen.class));
        } else {
            // invalid username or password
            startActivity(new Intent(LoginScreen.this, LoginFail.class));
        }

    }

    public void onCancelPressed(View view) {
        startActivity(new Intent(LoginScreen.this, MainActivity.class));
        finish();
    }

}