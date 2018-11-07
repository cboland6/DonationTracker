package com.example.casey.donationtracker.Controllers;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.example.casey.donationtracker.R;

public class DetailItem extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_item);

        getIncomingIntent();
    }

    private void getIncomingIntent () {
        if(getIntent().hasExtra("shortDesc") && getIntent().hasExtra("fullDesc")
                && getIntent().hasExtra("value") && getIntent().hasExtra("category") && getIntent().hasExtra("time")) {
            String shortDesc = getIntent().getStringExtra("shortDesc");
            String fullDesc = getIntent().getStringExtra("fullDesc");
            String value = getIntent().getStringExtra("value");
            String category = getIntent().getStringExtra("category");
            String time = getIntent().getStringExtra("time");

            setWidgets(shortDesc, fullDesc, value, category, time);
        }
    }

    private void setWidgets(String sD, String fD, String val, String cat, String time) {
        TextView sDesc = findViewById(R.id.shortDescItem);
        sDesc.setText(sD);

        TextView fDesc = findViewById(R.id.fullDescItem);
        fDesc.setText(fD);

        TextView value = findViewById(R.id.value);
        value.setText(val);

        TextView itemCat = findViewById(R.id.category);
        itemCat.setText(cat);

        TextView timeView = findViewById(R.id.timeView);
        timeView.setText(time);
    }

    /**
     * Changes the view from the current view to the ItemListScreen
     * @param view The view that the items will be listed on
     */
    public void viewItems(View view) {
        startActivity(new Intent(DetailItem.this, ItemListScreen.class));
        finish();
    }
}