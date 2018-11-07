package com.example.casey.donationtracker.Controllers;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.casey.donationtracker.Model.Model;
import com.example.casey.donationtracker.R;
import com.example.casey.donationtracker.Database.Location;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class HomeScreen extends AppCompatActivity {
    private static final String TAG = "MY_APP";
    private static final Model model = Model.getInstance();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);
        TextView welcomeMessage = findViewById(R.id.textView2);
        welcomeMessage.setText("Welcome, " + model.getCurrentAccount().getUsername());

        configureLogOutButton();
        configureLocationsButton();
        configureItemSearchButton();

        if (model.getLocationCount() <= 0) {
            readSDFile();
        }

    }

    private void configureLogOutButton() {
        Button logOutButton = findViewById(R.id.Back);
        logOutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeScreen.this, MainActivity.class));
            }
        });
    }

    private void configureLocationsButton() {
        Button locationsButton = findViewById(R.id.Locations);
        locationsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //readSDFile();
                startActivity(new Intent(HomeScreen.this, LocationListScreen.class));
            }
        });
    }

    private void configureItemSearchButton() {
        Button locationsButton = findViewById(R.id.ItemSearch);
        locationsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeScreen.this, ItemSearchScreen.class));
            }
        });
    }

    /**
     * Open the locationdata.csv file from /res/raw directory
     */
    private void readSDFile() {
        //must clear the locations first
        try {
            InputStream IS = getResources().openRawResource(R.raw.locationdata);
            if (IS == null) {
                throw new IOException();
            } else {
                BufferedReader BR = new BufferedReader(new InputStreamReader(IS, StandardCharsets.UTF_8));
                String line;
                BR.readLine();

                while ((line = BR.readLine()) != null) {
                    Log.d(HomeScreen.TAG, line);
                    String[] tokens = line.split(",");
                    Model.getInstance().addLocation(new Location(tokens[0], tokens[1], tokens[2], tokens[3], tokens[4], tokens[5], tokens[6], tokens[7], tokens[8], tokens[9], tokens[10]));
                }
                BR.close();
            }
        } catch (IOException e) {
            Log.e(HomeScreen.TAG, "error reading assets", e);
        }
    }
}
