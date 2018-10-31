package com.example.casey.donationtracker.Controllers;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import com.example.casey.donationtracker.Model.Category;
import com.example.casey.donationtracker.Model.Location;
import com.example.casey.donationtracker.Model.Model;
import com.example.casey.donationtracker.R;

import java.util.List;
import java.util.ArrayList;

public class ItemSearchScreen extends AppCompatActivity {

    private Spinner LocationSpinner;
    private Spinner CategorySpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_search_screen);
        LocationSpinner = findViewById(R.id.LocationForSearch);
        CategorySpinner = findViewById(R.id.CategoryForSearch);
        ArrayList<String> locations = getLocationNameList();

        /**
         * Array Adapters for Spinners
         */
        ArrayAdapter<String> locAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, locations);
        locAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        LocationSpinner.setAdapter(locAdapter);

        ArrayAdapter<String> catAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, Category.values());
        catAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        CategorySpinner.setAdapter(catAdapter);

        configureSearchButton();

    }


    private void configureSearchButton() {
        Button SearchButton = findViewById(R.id.EnterSearch);
        SearchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // This should use the entered information to search items and display them
                //startActivity(new Intent(HomeScreen.this, MainActivity.class));
            }
        });
    }

    public ArrayList<String> getLocationNameList() {
        Model model = Model.getInstance();
        List<Location> locations = model.getLocations();
        ArrayList<String> locNames = new ArrayList<>();
        locNames.add("All Locations");
        for (Location temp : locations) {
            locNames.add(temp.getLocationName());
        }
        return locNames;
    }

}