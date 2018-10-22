package com.example.casey.donationtracker.Controllers;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.casey.donationtracker.Model.Category;
import com.example.casey.donationtracker.Model.Location;
import com.example.casey.donationtracker.Model.Model;
import com.example.casey.donationtracker.R;

public class AddItemScreen extends AppCompatActivity{

    //widgets for entering item data should be declared here
    private Spinner locationSpinner;
    private EditText shortDescriptionField;
    private EditText fullDescriptionField;
    private EditText valueField;
    private Spinner categorySpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.enter_item_screen);

        locationSpinner = (Spinner) findViewById(R.id.locationSpinner);
        shortDescriptionField = (EditText) findViewById(R.id.addItemShortDesc);
        fullDescriptionField = (EditText) findViewById(R.id.addItemFullDesc);
        valueField = (EditText) findViewById(R.id.addItemValue);
        categorySpinner = (Spinner) findViewById(R.id.categorySpinner);

        ArrayAdapter<Location> locAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, Model.getInstance().getLocations());
        locAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        locationSpinner.setAdapter(locAdapter);

        ArrayAdapter<Location> catAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, Category.values());
        catAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        categorySpinner.setAdapter(catAdapter);
    }

    public void onAddButtonPressed(View view) {
        Location currentLoc = (Location) locationSpinner.getSelectedItem();
        String shortDesc = shortDescriptionField.getText().toString();
        String fullDesc = fullDescriptionField.getText().toString();
        int value = Integer.parseInt(valueField.getText().toString());
        Category category = (Category) categorySpinner.getSelectedItem();

        //TODO:
        //please do the error checks here somebody if not all data has been entered, etc

        currentLoc.addItem(shortDesc, fullDesc, value, category);
    }
}
