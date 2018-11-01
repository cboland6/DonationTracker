package com.example.casey.donationtracker.Controllers;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.casey.donationtracker.Database.Location;
import com.example.casey.donationtracker.Model.Category;
import com.example.casey.donationtracker.Model.Model;
import com.example.casey.donationtracker.R;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;

public class ItemEntryScreen extends AppCompatActivity {

    private EditText shortDescriptionField;
    private EditText fullDescriptionField;
    private EditText valueField;
    private Spinner hourSpinner;
    private Spinner minSpinner;
    private Spinner AMPMSpinner;
    private Spinner monthSpinner;
    private Spinner daySpinner;
    private Spinner yearSpinner;
    private Spinner locationSpinner;
    private Spinner categorySpinner;
    public static LocalDateTime itemTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_entry_screen);
        TextView header = findViewById(R.id.textView6);
        header.setText("Please Enter Item Information Below");

        /**
         * Grab the dialog widgets so we can get info for later
         */
        shortDescriptionField = findViewById(R.id.enterBriefDesc);
        fullDescriptionField = findViewById(R.id.enterFullDesc);
        valueField = findViewById(R.id.enterValue);
        hourSpinner = findViewById(R.id.hour);
        minSpinner = findViewById(R.id.min);
        AMPMSpinner = findViewById(R.id.AMPM);
        monthSpinner = findViewById(R.id.month);
        daySpinner = findViewById(R.id.day);
        yearSpinner = findViewById(R.id.year);
        locationSpinner = findViewById(R.id.location);
        categorySpinner = findViewById(R.id.category);

        Integer[] hours = new Integer[] {1,2,3,4,5,6,7,8,9,10,11,12};
        String[] minutes = new String[] {"00", "05", "10", "15", "20", "25", "30", "35","40", "45", "50", "55"};
        String[] ampm = new String[] {"AM", "PM"};
        Integer[] months = new Integer[] {1,2,3,4,5,6,7,8,9,10,11,12};
        Integer[] days = new Integer[] {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31};
        Integer[] years = new Integer[] {2015,2016,2017,2018,2019,2020};

        ArrayList<String> locations = (ArrayList) Model.getInstance().getLocations();

        /**
         * Array Adapters for Spinners
         */
        // use copy of range for Category spinner to exclude the possible ALL category enum value when adding an item
        ArrayAdapter<Category> catAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, Arrays.copyOfRange(Category.values(), 1, Category.values().length));
        catAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        categorySpinner.setAdapter(catAdapter);

        ArrayAdapter<Location> locAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, locations);
        locAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        locationSpinner.setAdapter(locAdapter);

        ArrayAdapter<Integer> hourAdapter = new ArrayAdapter<Integer>(this, android.R.layout.simple_spinner_item, hours);
        hourAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        hourSpinner.setAdapter(hourAdapter);

        ArrayAdapter<String> minAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, minutes);
        minAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        minSpinner.setAdapter(minAdapter);

        ArrayAdapter<String> ampmAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, ampm);
        ampmAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        AMPMSpinner.setAdapter(ampmAdapter);

        ArrayAdapter<Integer> monthAdapter = new ArrayAdapter<Integer>(this, android.R.layout.simple_spinner_item, months);
        monthAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        monthSpinner.setAdapter(monthAdapter);

        ArrayAdapter<Integer> dayAdapter = new ArrayAdapter<Integer>(this, android.R.layout.simple_spinner_item, days);
        dayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        daySpinner.setAdapter(dayAdapter);

        ArrayAdapter<Integer> yearAdapter = new ArrayAdapter<Integer>(this, android.R.layout.simple_spinner_item, years);
        yearAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        yearSpinner.setAdapter(yearAdapter);


    }

    public void onAddButtonPressed(View view) {
        //required: timestamp, location, value, short description, full description, category
        Location loc = (Location) locationSpinner.getSelectedItem();
        Category cat = (Category) categorySpinner.getSelectedItem();
        boolean fieldsPresent = requiredFieldsPresent(cat, shortDescriptionField, fullDescriptionField, valueField);

        if (fieldsPresent) {
            String shortDesc = shortDescriptionField.getText().toString();
            String fullDesc = fullDescriptionField.getText().toString();
            int value = Integer.parseInt(valueField.getText().toString());
            Category category = (Category) categorySpinner.getSelectedItem();
            int day = (Integer) daySpinner.getSelectedItem();
            int month = (Integer) monthSpinner.getSelectedItem();
            int year = (Integer) yearSpinner.getSelectedItem();
            int hour = (Integer) hourSpinner.getSelectedItem();
            if (AMPMSpinner.getSelectedItem().toString().equals("PM")) {
                hour += 12;
            }
            int min = Integer.parseInt(minSpinner.getSelectedItem().toString());


            itemTime = LocalDateTime.of(year,month,day,hour,min);

            Model.getInstance().addItem(itemTime, loc, shortDesc, fullDesc, value, category);
            startActivity(new Intent(ItemEntryScreen.this, LocationListScreen.class));
            finish();
        }
    }

    public void onCancelPressed(View view) {
        finish();
    }

    private boolean requiredFieldsPresent(Category cat, EditText ... editTexts) {
        boolean fieldsPresent = true;
        if ((cat.toString()).equals("Select Category")) {
            fieldsPresent = false;
        }
        for (EditText e: editTexts) {
            if (e.getText().toString().equals("")) {
                e.setError("This field is required");
                fieldsPresent = false;
            }
        }
        return fieldsPresent;
    }
}
