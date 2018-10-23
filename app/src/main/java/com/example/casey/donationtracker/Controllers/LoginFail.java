package com.example.casey.donationtracker.Controllers;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.casey.donationtracker.R;

public class LoginFail extends AppCompatActivity {

    private Button tryAgain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_fail);

        tryAgain = findViewById(R.id.tryAgainBtn);

        tryAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginFail.this, LoginScreen.class));
            }
        });
    }
}
