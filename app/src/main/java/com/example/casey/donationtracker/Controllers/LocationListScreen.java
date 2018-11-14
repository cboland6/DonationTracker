package com.example.casey.donationtracker.Controllers;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.casey.donationtracker.Database.Location;
import com.example.casey.donationtracker.Controllers.MapActivity;
import com.example.casey.donationtracker.Model.Model;
import com.example.casey.donationtracker.R;

import java.util.List;


public class LocationListScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.location_list);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        assert recyclerView != null;
        recyclerView.setLayoutManager(llm);
        setupRecyclerView(recyclerView);
    }

    /**
     * Changes the activity when the map button is pressed on the current view
     * @param view The view that contains the map button
     */
    public void onMapPress(View view) {
        startActivity(new Intent(LocationListScreen.this, MapActivity.class));
        finish();
    }

    private void setupRecyclerView(@NonNull RecyclerView recyclerView) {
        recyclerView.setAdapter(new SimpleItemRecyclerViewAdapter(Model.getInstance().getLocations()));
    }

    public class SimpleItemRecyclerViewAdapter
            extends RecyclerView.Adapter<SimpleItemRecyclerViewAdapter.ViewHolder> {

        private final List<Location> mValues;

        /**
         * Constructor that initializes a SimpleItemRecyclerViewAdapter with items
         * @param items Array list of locations
         */
        public SimpleItemRecyclerViewAdapter(List<Location> items) {
            mValues = items;
        }

        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.location_list_content, parent, false);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(final ViewHolder holder, final int position) {
            holder.mItem = mValues.get(position);
            holder.mIdView.setText(mValues.get(position).getName());
            holder.mAddress.setText(mValues.get(position).getAddress());

            holder.parentLayout.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Model.getInstance().setCurrentLocation(mValues.get(position));
                    Intent intent = new Intent(LocationListScreen.this, DetailLocation.class);
                    intent.putExtra("LocationName", mValues.get(position).getName());
                    intent.putExtra("LocationType", mValues.get(position).getType());
                    intent.putExtra("Longitude", mValues.get(position).getLongitude());
                    intent.putExtra("Latitude", mValues.get(position).getLatitude());
                    intent.putExtra("Address", mValues.get(position).getAddress());
                    intent.putExtra("PhoneNumber", mValues.get(position).getPhone());
                    intent.putExtra("UniqueKey", mValues.get(position).getUniqueKey());
                    LocationListScreen.this.startActivity(intent);
                }
            });
        }

        @Override
        public int getItemCount() {
            return mValues.size();
        }

        public class ViewHolder extends RecyclerView.ViewHolder {
            final View mView;
            final TextView mIdView;
            final TextView mAddress;
            Location mItem;
            final LinearLayout parentLayout;

            /**
             * Constructor that initializes ViewHolder with view
             * @param view The view that will initialize the ViewHolder
             */
            public ViewHolder(View view) {
                super(view);
                mView = view;
                mIdView = view.findViewById(R.id.location_name);
                mAddress = view.findViewById(R.id.location_address);
                parentLayout = view.findViewById(R.id.location_list_content);
            }

            @Override
            public String toString() {
                return super.toString() + " '";
            }
        }
    }
}