package com.example.recycle;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private CountryAdapter adapter;
    private List<Country> countryList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        countryList = new ArrayList<>();
        countryList.add(new Country("Россия", "Большая страна"));
        countryList.add(new Country("Германия", "Страна поменьше"));
        countryList.add(new Country("Франция", "Страна чуть больше, чем Германия"));

        adapter = new CountryAdapter(countryList, country -> {

            Intent intent = new Intent(MainActivity.this, DetailActivity.class);
            intent.putExtra("countryName", country.getName());
            intent.putExtra("countryDescription", country.getDescription());
            startActivity(intent);
        });

        recyclerView.setAdapter(adapter);
    }
}
