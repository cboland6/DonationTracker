package com.example.casey.donationtracker.Controllers;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.casey.donationtracker.R;

public class LoginScreen extends AppCompatActivity {

    // Widgets
    EditText username;
    EditText password;
    Button login;
    Button cancel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_screen);

        // Grab widgets
        username = (EditText)findViewById(R.id.editText);
        password = (EditText)findViewById(R.id.editText2);
        login = (Button)findViewById(R.id.log2);
        cancel = (Button)findViewById(R.id.cancelbutton);

    }

    public void login(View view) {
        if (username.getText().toString().equals("user") && password.getText().toString().equals("pass")) {
            startActivity(new Intent(LoginScreen.this, HomeScreen.class));
        }
        else {
            startActivity(new Intent(LoginScreen.this, LoginFail.class));
        }
    }

    public void onCancelPressed(View view) {
        startActivity(new Intent(LoginScreen.this, MainActivity.class));
        finish();
    }

}
