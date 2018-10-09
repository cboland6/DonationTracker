package com.example.casey.donationtracker.Controllers;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.casey.donationtracker.Model.Location;
import com.example.casey.donationtracker.Model.LocationList;
import com.example.casey.donationtracker.R;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class HomeScreen extends AppCompatActivity {
    public static String TAG = "MY_APP";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);

        configureLogOutButton();
        configureLocationsButton();
    }

    private void configureLogOutButton() {
        Button logOutButton = (Button) findViewById(R.id.Back);
        logOutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeScreen.this, MainActivity.class));
            }
        });
    }

    private void configureLocationsButton() {
        Button locationsButton = (Button) findViewById(R.id.Locations);
        locationsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                readSDFile();
                startActivity(new Intent(HomeScreen.this, LocationListScreen.class));
            }
        });
    }

    /**
     * Open the locationdata.csv file from /res/raw directory
     *
     */
    private void readSDFile() {
        LocationList locations = LocationList.INSTANCE;
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
                    locations.addLocation(new Location(tokens[1], tokens[2], tokens[3], tokens[4], tokens[5], tokens[6], tokens[7], tokens[8], tokens[9], tokens[10]));
                }
                BR.close();
            }
        } catch (IOException e) {
            Log.e(HomeScreen.TAG, "error reading assets", e);
        }
    }


}
