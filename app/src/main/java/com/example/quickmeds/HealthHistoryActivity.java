package com.example.quickmeds;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class HealthHistoryActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_health_history);


        ListView listView = findViewById(R.id.historyListView);


        String[] healthCategories = {
                "Symptoms you’ve tracked",
                "Exercise patterns",
                "Diet patterns",
                "Sleep patterns",
                "Mental health journals",
                "Allergies",
                "Family medical background"
        };


        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                healthCategories
        );


        listView.setAdapter(adapter);
    }
}
