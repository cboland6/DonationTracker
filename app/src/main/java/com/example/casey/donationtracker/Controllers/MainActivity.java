package com.example.casey.donationtracker.Controllers;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.util.Log;
import com.example.casey.donationtracker.Model.LocationList;
import com.example.casey.donationtracker.Model.Location;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

import com.example.casey.donationtracker.R;

public class MainActivity extends AppCompatActivity {
    public static String TAG = "MY_APP";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        configureLoginButton();
        configureRegButton();
    }

    private void configureLoginButton() {
        Button nextButton = (Button) findViewById(R.id.log1);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, LoginScreen.class));
            }
        });
    }

    private void configureRegButton() {
        Button regButton = (Button) findViewById(R.id.regbutton);
        regButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, RegScreen.class));
            }
        });
    }

    public static final int NAME_POSITION = 1;
    /**
     * Open the LocationData.csv file from /res/raw directory
     *
     */
    private void readSDFile() {
        LocationList locations = LocationList.INSTANCE;
        try {
            InputStream IS = getResources().openRawResource(R.raw.LocationData);
            if (IS == null) {
                throw new IOException();
            }
            BufferedReader BR = new BufferedReader(new InputStreamReader(IS, StandardCharsets.UTF_8));
            String line;
            BR.readLine();
            while ((line = BR.readLine()) != null) {
                Log.d(MainActivity.TAG, line);
                String[] tokens = line.split(",");
                int lat = Integer.parseInt(tokens[2]);
                int lo = Integer.parseInt(tokens[3]);
                int zip = Integer.parseInt(tokens[7]);
                locations.addLocation(new Location(tokens[NAME_POSITION], lat, lo, tokens[4], tokens[5], tokens[6], zip, tokens[8], tokens[9], tokens[10]));
            }
            BR.close();
        } catch (IOException e) {
            Log.e(MainActivity.TAG, "error reading assets", e);
        }
    }
}
