package com.example.casey.donationtracker.Controllers;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.casey.donationtracker.Model.Category;
import com.example.casey.donationtracker.Model.Location;
import com.example.casey.donationtracker.Model.Model;
import com.example.casey.donationtracker.Model.Item;
import com.example.casey.donationtracker.R;

import java.util.List;
import java.util.ArrayList;

public class ItemSearchScreen extends AppCompatActivity {

    private Spinner LocationSpinner;
    private Spinner CategorySpinner;
    private EditText nameField;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_search_screen);
        LocationSpinner = findViewById(R.id.LocationForSearch);
        CategorySpinner = findViewById(R.id.CategoryForSearch);
        nameField = findViewById(R.id.editText3);
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
//        LinearLayoutManager llm = new LinearLayoutManager(this);
//        RecyclerView recyclerView = findViewById(R.id.recycler_view);
//        assert recyclerView != null;
////        recyclerView.setLayoutManager(llm);
////        setupRecyclerView(recyclerView);
    }


    public ArrayList<Item> searchByCategory(ArrayList<Item> items) {
        Category cat = (Category) CategorySpinner.getSelectedItem();
        String locString = (String) LocationSpinner.getSelectedItem();
        List<Location> locations = Model.getInstance().getLocations();

        if (locString.equals("All Locations")) {
            for (Location temp: locations) {
                items.addAll(Model.getInstance().getMatchingItemsByCategory(temp, cat));
            }
        } else {
            for (Location temp : locations) {
                if (locString.equals(temp.getLocationName())) {
                    items.addAll(Model.getInstance().getMatchingItemsByCategory(temp, cat));
                }
            }
        }
        if (items.size() == 0) {
            Context con = getApplicationContext();
            CharSequence msg = "No items to show";
            int duration = Toast.LENGTH_LONG;
            Toast toast = Toast.makeText(con, msg, duration);
            toast.show();
        }
        return items;
    }

    public ArrayList<Item> searchByName(ArrayList<Item> items) {
        String name = (String) nameField.getText().toString();
        String locString = (String) LocationSpinner.getSelectedItem();
        List<Location> locations = Model.getInstance().getLocations();

        if (locString.equals("All Locations")) {
            for (Location temp: locations) {
                items.addAll(Model.getInstance().getMatchingItemsByName(temp, name));
            }
        } else {
            for (Location temp : locations) {
                if (locString.equals(temp.getLocationName())) {
                    items.addAll(Model.getInstance().getMatchingItemsByName(temp, name));
                }
            }
        }
        if (items.size() == 0) {
            Context con = getApplicationContext();
            CharSequence msg = "No items to show";
            int duration = Toast.LENGTH_LONG;
            Toast toast = Toast.makeText(con, msg, duration);
            toast.show();
        }
        return items;
    }

    // Begin Printing Items Relevant to Search
    private void setupRecyclerView(@NonNull RecyclerView recyclerView) {
        ArrayList<Item> items;
        if (!(CategorySpinner.getSelectedItem().equals(""))) {
            items = searchByCategory(new ArrayList<Item>());
        } else {
            items = searchByName(new ArrayList<Item>());
        }
        recyclerView.setAdapter(new SimpleItemRecyclerViewAdapter(items));

    }
    public class SimpleItemRecyclerViewAdapter
            extends RecyclerView.Adapter<SimpleItemRecyclerViewAdapter.ViewHolder> {

        private final List<Item> mItems;

        public SimpleItemRecyclerViewAdapter(ArrayList<Item> items) {
            mItems = items;
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_list_content, parent, false);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(final ViewHolder holder, final int position) {
            holder.mItem = mItems.get(position);
            holder.mSDescView.setText(mItems.get(position).getShortDescription());
            holder.mCatView.setText(mItems.get(position).getCategory().toString());

            holder.parentLayout.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Intent intent = new Intent(ItemSearchScreen.this, DetailItem.class);
                    intent.putExtra("shortDesc", mItems.get(position).getShortDescription());
                    intent.putExtra("fullDesc", mItems.get(position).getFullDescription());
                    intent.putExtra("value", Integer.toString(mItems.get(position).getValue()));
                    intent.putExtra("category", mItems.get(position).getCategory().toString());
                    intent.putExtra("time", mItems.get(position).getTimeStamp().toString());
                    ItemSearchScreen.this.startActivity(intent);
                }
            });
        }

        @Override
        public int getItemCount() {
            return mItems.size();
        }

        public class ViewHolder extends RecyclerView.ViewHolder {
            View mView;
            Item mItem;
            TextView mSDescView;
            TextView mCatView;
            LinearLayout parentLayout;

            public ViewHolder(View view) {
                super(view);
                mView = view;
                mSDescView = view.findViewById(R.id.item_shortDesc);
                mCatView = view.findViewById(R.id.item_category);
                parentLayout = view.findViewById(R.id.item_list_content);
            }

            @Override
            public String toString() {
                return super.toString() + " '";
            }
        }
    }


    // End Printing Items Here

    private void configureSearchButton() {
        Button SearchButton = findViewById(R.id.EnterSearch);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        final RecyclerView recyclerView = findViewById(R.id.recycler_view);
        assert recyclerView != null;
        recyclerView.setLayoutManager(llm);
        setupRecyclerView(recyclerView);
        SearchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setupRecyclerView(recyclerView);
                //This should use the entered information to search items and display them
                //startActivity(new Intent(ItemSearchScreen.this, MainActivity.class));
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