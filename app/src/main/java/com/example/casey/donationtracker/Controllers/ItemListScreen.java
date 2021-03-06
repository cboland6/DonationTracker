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

import com.example.casey.donationtracker.Model.Model;
import com.example.casey.donationtracker.R;
import com.example.casey.donationtracker.Database.Item;

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
        recyclerView.setAdapter(new SimpleItemRecyclerViewAdapter(Model.getInstance().getItemsAtCurrentLocation()));
    }

    public class SimpleItemRecyclerViewAdapter
            extends RecyclerView.Adapter<SimpleItemRecyclerViewAdapter.ViewHolder> {

        private final List<Item> mItems;

        private SimpleItemRecyclerViewAdapter(List<Item> items) {
            mItems = items;
        }

        @NonNull
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
                    Intent intent = new Intent(ItemListScreen.this, DetailItem.class);
                    intent.putExtra("shortDesc", mItems.get(position).getShortDescription());
                    intent.putExtra("fullDesc", mItems.get(position).getFullDescription());
                    intent.putExtra("value", Integer.toString(mItems.get(position).getValue()));
                    intent.putExtra("category", mItems.get(position).getCategory().toString());
                    intent.putExtra("time", mItems.get(position).getTimeStamp().toString());
                    ItemListScreen.this.startActivity(intent);
                }
            });
        }

        @Override
        public int getItemCount() {
            return mItems.size();
        }

        public class ViewHolder extends RecyclerView.ViewHolder {
            final View mView;
            Item mItem;
            final TextView mSDescView;
            final TextView mCatView;
            final LinearLayout parentLayout;

            /**
             * Constructor for the ViewHolder class. Initializes a ViewHolder with view
             * @param view The view that will be set in ViewHolder
             */
            private ViewHolder(View view) {
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
}
