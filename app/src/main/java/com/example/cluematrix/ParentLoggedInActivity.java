package com.example.cluematrix;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class ParentLoggedInActivity extends AppCompatActivity {
    //declaring views
    CardView tenthCardView, apiCardView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parent_logged_in);

        //initializing views
        tenthCardView = findViewById(R.id.tenthCardView);
        apiCardView = findViewById(R.id.apiCardView);
        //setting up click listeners
        apiCardView.setOnClickListener(view -> startActivity(new Intent(ParentLoggedInActivity.this, ApiFetchingActivity.class)));
        tenthCardView.setOnClickListener(view -> startActivity(new Intent(ParentLoggedInActivity.this, ChildInfoActivity.class)));
    }
}