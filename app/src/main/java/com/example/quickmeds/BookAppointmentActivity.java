package com.example.quickmeds;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class BookAppointmentActivity extends AppCompatActivity {

    Spinner specialtySpinner, locationSpinner, timeSlotSpinner;
    Button bookAppointmentButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_appointment);


        specialtySpinner = findViewById(R.id.specialtySpinner);
        locationSpinner = findViewById(R.id.locationSpinner);
        timeSlotSpinner = findViewById(R.id.timeSlotSpinner);
        bookAppointmentButton = findViewById(R.id.bookAppointmentButton);

        // test data
        String[] specialties = {"Cardiology", "Dermatology", "General Practice", "Pediatrics"};
        String[] locations = {"Downtown Clinic", "Uptown Health Center", "Suburban Medical"};
        String[] timeSlots = {"10:00 AM", "12:30 PM", "3:00 PM", "5:15 PM"};


        specialtySpinner.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, specialties));
        locationSpinner.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, locations));
        timeSlotSpinner.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, timeSlots));

        // book button click
        bookAppointmentButton.setOnClickListener(view -> {
            String specialty = specialtySpinner.getSelectedItem().toString();
            String location = locationSpinner.getSelectedItem().toString();
            String timeSlot = timeSlotSpinner.getSelectedItem().toString();

            String message = "Appointment booked for " + specialty + " at " + location + " on " + timeSlot;
            Toast.makeText(BookAppointmentActivity.this, message, Toast.LENGTH_LONG).show();
        });
    }
}
