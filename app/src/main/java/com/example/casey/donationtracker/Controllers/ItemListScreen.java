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

import com.example.casey.donationtracker.Model.Item;
import com.example.casey.donationtracker.Model.Location;
import com.example.casey.donationtracker.Model.Model;
import com.example.casey.donationtracker.R;

import java.util.List;

public class ItemListScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_list);
        LinearLayoutManager llm = new LinearLayoutManager(this);

        RecyclerView recyclerView = findViewById(R.id.recycler_view2);
        assert recyclerView != null;
        recyclerView.setLayoutManager(llm);
        setupRecyclerView(recyclerView);
    }

    private void setupRecyclerView(@NonNull RecyclerView recyclerView) {
        recyclerView.setAdapter(new ItemListScreen.SimpleItemRecyclerViewAdapter(loc.getItems()));
    }
    public class SimpleItemRecyclerViewAdapter
            extends RecyclerView.Adapter<LocationListScreen.SimpleItemRecyclerViewAdapter.ViewHolder> {

        private final List<Item> mItems;

        public SimpleItemRecyclerViewAdapter(List<Item> items) {
            mItems = items;
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_list_content, parent, false);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(final LocationListScreen.SimpleItemRecyclerViewAdapter.ViewHolder holder, final int position) {
            holder.mItem = mItems.get(position);
            holder.mIdView.setText(mItems.get(position).getShortDescription());
            holder.mAddress.setText(mValues.get(position).getAddress());

            holder.parentLayout.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Intent intent = new Intent(ItemListScreen.this, DetailItem.class);
                    intent.putExtra("LocationName", mValues.get(position).getLocationName());
                    intent.putExtra("LocationType", mValues.get(position).getLocationType());
                    intent.putExtra("Longitude", mValues.get(position).getLongitude());
                    intent.putExtra("Latitude", mValues.get(position).getLatitude());
                    intent.putExtra("Address", mValues.get(position).getAddress());
                    intent.putExtra("PhoneNumber", mValues.get(position).getLocationPhone());
                    ItemListScreen.this.startActivity(intent);
                }
            });
        }

        @Override
        public int getItemCount() {
            return mItems.size();
        }

        public class ViewHolder extends RecyclerView.ViewHolder {
            View mView;
            TextView mIdView;
            TextView mAddress;
            Location mItem;
            LinearLayout parentLayout;

            public ViewHolder(View view) {
                super(view);
                mView = view;
                mIdView = view.findViewById(R.id.item_shortDesc);
                mAddress = view.findViewById(R.id.item_category);
                parentLayout = view.findViewById(R.id.item_list_content);
            }

            @Override
            public String toString() {
                return super.toString() + " '";
            }
        }
    }
}
