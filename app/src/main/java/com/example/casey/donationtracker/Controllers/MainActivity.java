package com.example.casey.donationtracker.Controllers;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.casey.donationtracker.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Write a message to the database
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("message");

        myRef.setValue("Hello, World!");


        //TODO: store the users/accounts from firebase into _accounts for permanence


         //Attach a listener to read the data at our users reference
        //this function makes the app crash so far. so i commented it out
//        myRef.child("users").addListenerForSingleValueEvent(new ValueEventListener() {
//            @Override
//            public void onDataChange(DataSnapshot dataSnapshot) {
//                Account acc = dataSnapshot.getValue(Account.class);
//                Model.getInstance().addAccount(acc);
//            }
//
//            @Override
//            public void onCancelled(DatabaseError databaseError) {
//                Log.d("ERROR", "error getting saved accounts");
//            }
//
//        });


        configureLoginButton();
        configureRegButton();

    }

    private void configureLoginButton() {
        Button nextButton = findViewById(R.id.log1);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, LoginScreen.class));
                //change back to LoginScreen when done testing
            }
        });
    }

    private void configureRegButton() {
        Button regButton = findViewById(R.id.regbutton);
        regButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, RegScreen.class));
            }
        });
    }
}
