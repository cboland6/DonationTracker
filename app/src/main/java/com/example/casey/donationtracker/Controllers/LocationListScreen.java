package com.example.casey.donationtracker.Controllers;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.casey.donationtracker.Model.Location;

import android.support.v7.widget.RecyclerView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.casey.donationtracker.Model.Model;
import com.example.casey.donationtracker.R;

import java.util.List;


public class LocationListScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dataitem_list);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        assert recyclerView != null;
        recyclerView.setLayoutManager(llm);
        setupRecyclerView(recyclerView);
    }

    private void setupRecyclerView(@NonNull RecyclerView recyclerView) {
        recyclerView.setAdapter(new SimpleItemRecyclerViewAdapter(Model.getInstance().getLocations()));
    }
    public class SimpleItemRecyclerViewAdapter
            extends RecyclerView.Adapter<SimpleItemRecyclerViewAdapter.ViewHolder> {

        private final List<Location> mValues;

        public SimpleItemRecyclerViewAdapter(List<Location> items) {
            mValues = items;
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.data_item_list_content, parent, false);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(final ViewHolder holder, final int position) {
            holder.mItem = mValues.get(position);
            holder.mIdView.setText(mValues.get(position).getLocationName());
            holder.mIdView.append(", ");
            holder.mIdView.append(mValues.get(position).getLocationType());

            holder.parentLayout.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Intent intent = new Intent(LocationListScreen.this, DetailLocation.class);
                    intent.putExtra("LocationName", mValues.get(position).getLocationName());
                    intent.putExtra("LocationType", mValues.get(position).getLocationType());
                    intent.putExtra("Longitude", mValues.get(position).getLongitude());
                    intent.putExtra("Latitude", mValues.get(position).getLatitude());
                    intent.putExtra("Address", mValues.get(position).getAddress());
                    intent.putExtra("PhoneNumber", mValues.get(position).getLocationPhone());
                    LocationListScreen.this.startActivity(intent);
                }
            });
        }

        @Override
        public int getItemCount() {
            return mValues.size();
        }

        public class ViewHolder extends RecyclerView.ViewHolder {
            View mView;
            TextView mIdView;
            Location mItem;
            LinearLayout parentLayout;

            public ViewHolder(View view) {
                super(view);
                mView = view;
                mIdView = (TextView) view.findViewById(R.id.LocName);
                parentLayout = (LinearLayout) view.findViewById(R.id.data_item_list_content);
            }
            @Override
            public String toString() {
                return super.toString() + " '";
            }
        }
    }
}
