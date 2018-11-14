package com.example.casey.donationtracker.Controllers;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.casey.donationtracker.R;

public class DetailLocation extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_location);
        Button itemButton = findViewById(R.id.viewItemsButton);
        configureAddItemButton();
        Button addItemButton = findViewById(R.id.ItemEntry);
        getIncomingIntent();
    }

    private void getIncomingIntent () {
        if(getIntent().hasExtra("LocationName") && getIntent().hasExtra("LocationType") && getIntent().hasExtra("Longitude")
                && getIntent().hasExtra("Latitude") && getIntent().hasExtra("Address") && getIntent().hasExtra("PhoneNumber")) {
            String locationName = getIntent().getStringExtra("LocationName");
            String locationType = getIntent().getStringExtra("LocationType");
            String longitude = getIntent().getStringExtra("Longitude");
            String latitude = getIntent().getStringExtra("Latitude");
            String address = getIntent().getStringExtra("Address");
            String phoneNumber = getIntent().getStringExtra("PhoneNumber");

            setWidgets(locationName, locationType, longitude, latitude, address, phoneNumber);
        }
    }

    private void setWidgets(String loNa, String loTy, String longi, String lati, String adrs, String pho) {
        TextView locNam = findViewById(R.id.nameLoc);
        locNam.setText(loNa);

        TextView locTyp = findViewById(R.id.typeLoc);
        locTyp.setText(loTy);

        TextView longit = findViewById(R.id.longitude);
        longit.setText(longi);

        TextView latit = findViewById(R.id.latitude);
        latit.setText(lati);

        TextView addrs = findViewById(R.id.address);
        addrs.setText(adrs);

        TextView phone = findViewById(R.id.phoneNum);
        phone.setText(pho);
    }

    /**
     * Changes the view from the current view to the ItemListScreen view
     * @param view The view that will have the locations displayed on
     */
    public void viewItems(View view) {
        startActivity(new Intent(DetailLocation.this, ItemListScreen.class));
        finish();
    }

    private void configureAddItemButton() {
        Button ItemEntry = findViewById(R.id.ItemEntry);
        ItemEntry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DetailLocation.this, ItemEntryScreen.class));
            }
        });
    }
}
