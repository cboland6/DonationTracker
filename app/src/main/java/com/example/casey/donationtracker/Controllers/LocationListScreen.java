package com.example.casey.donationtracker.Controllers;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.casey.donationtracker.R;

public class LocationListScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_locations_screen);

        configureLogOutButton();
    }

    private void configureLogOutButton() {
        Button logOutButton = (Button) findViewById(R.id.Back);
        logOutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LocationListScreen.this, HomeScreen.class));
            }
        });
    }
}
