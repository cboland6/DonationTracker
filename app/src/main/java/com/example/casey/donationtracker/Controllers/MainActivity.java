package com.example.casey.donationtracker.Controllers;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.casey.donationtracker.Model.Model;
import com.example.casey.donationtracker.R;


public class MainActivity extends AppCompatActivity {
    private final Model model = Model.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        model.configureDatabase(getApplicationContext());

        configureLoginButton();
        configureRegButton();

    }

    private void configureLoginButton() {
        Button nextButton = findViewById(R.id.log1);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // change back to LoginScreen when done testing
                startActivity(new Intent(MainActivity.this, LoginScreen.class));
            }
        });
    }

    private void configureRegButton() {
        Button regButton = findViewById(R.id.regButton);
        regButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, RegScreen.class));
            }
        });
    }
}
