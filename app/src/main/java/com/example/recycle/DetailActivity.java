package com.example.recycle;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        TextView countryName = findViewById(R.id.countryName);
        TextView countryDescription = findViewById(R.id.countryDescription);

        Intent intent = getIntent();
        String name = intent.getStringExtra("countryName");
        String description = intent.getStringExtra("countryDescription");

        countryName.setText(name);
        countryDescription.setText(description);
    }
}

