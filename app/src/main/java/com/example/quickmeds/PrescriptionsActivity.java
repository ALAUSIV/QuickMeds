package com.example.quickmeds;

import android.os.Bundle;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;

public class PrescriptionsActivity extends AppCompatActivity {

    private ArrayAdapter<String> adapter;
    private ArrayList<String> prescriptions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prescriptions);

        ListView prescriptionListView = findViewById(R.id.prescriptionListView);
        Button addPrescriptionButton = findViewById(R.id.addPrescriptionButton);

        prescriptions = new ArrayList<>();
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, prescriptions);
        prescriptionListView.setAdapter(adapter);

        addPrescriptionButton.setOnClickListener(v -> showAddPrescriptionDialog());

        prescriptionListView.setOnItemLongClickListener((parent, view, position, id) -> {
            prescriptions.remove(position);
            adapter.notifyDataSetChanged();
            Toast.makeText(this, "Prescription removed", Toast.LENGTH_SHORT).show();
            return true;
        });
    }

    private void showAddPrescriptionDialog() {
        View dialogView = getLayoutInflater().inflate(R.layout.dialog_add_prescription, null);
        EditText nameField = dialogView.findViewById(R.id.prescriptionName);
        EditText doseField = dialogView.findViewById(R.id.prescriptionDose);
        EditText frequencyField = dialogView.findViewById(R.id.prescriptionFrequency);

        new AlertDialog.Builder(this)
                .setTitle("Add Prescription")
                .setView(dialogView)
                .setPositiveButton("Add", (dialog, which) -> {
                    String name = nameField.getText().toString().trim();
                    String dose = doseField.getText().toString().trim();
                    String frequency = frequencyField.getText().toString().trim();

                    if (name.isEmpty() || dose.isEmpty() || frequency.isEmpty()) {
                        Toast.makeText(this, "Please fill in all fields.", Toast.LENGTH_SHORT).show();
                    } else {
                        String entry = "Name: " + name + "\nDose: " + dose + "\nFrequency: " + frequency;
                        prescriptions.add(entry);
                        adapter.notifyDataSetChanged();
                    }
                })
                .setNegativeButton("Cancel", null)
                .show();
    }
}
