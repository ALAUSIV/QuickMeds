package com.example.quickmeds;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class FindPharmacyActivity extends AppCompatActivity {

    private Spinner pharmacySpinner, insuranceSpinner, paymentSpinner;
    private RadioButton pickupRadio, deliveryRadio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_pharmacy);

        pharmacySpinner = findViewById(R.id.pharmacySpinner);
        insuranceSpinner = findViewById(R.id.insuranceSpinner);
        paymentSpinner = findViewById(R.id.paymentSpinner);
        pickupRadio = findViewById(R.id.pickupRadio);
        deliveryRadio = findViewById(R.id.deliveryRadio);

        String[] pharmacies = {"Select Pharmacy", "HealthPlus Pharmacy", "CityMed Pharmacy", "Neighborhood Rx"};
        String[] insuranceOptions = {"Select Insurance", "Aetna", "Blue Cross", "Cigna", "United Healthcare"};
        String[] paymentMethods = {"Select Payment Method", "Credit Card", "Debit Card", "Cash", "Insurance Billing"};

        pharmacySpinner.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, pharmacies));
        insuranceSpinner.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, insuranceOptions));
        paymentSpinner.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, paymentMethods));

        // optional: Toast feedback
        pharmacySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
                if (pos != 0)
                    Toast.makeText(getApplicationContext(), "Selected: " + pharmacies[pos], Toast.LENGTH_SHORT).show();
            }

            public void onNothingSelected(AdapterView<?> parent) {}
        });
    }

    public void onDeliveryOptionSelected(View view) {
        boolean checked = ((RadioButton) view).isChecked();
        if (checked) {
            if (view.getId() == R.id.pickupRadio) {
                Toast.makeText(this, "Pickup selected", Toast.LENGTH_SHORT).show();
            } else if (view.getId() == R.id.deliveryRadio) {
                Toast.makeText(this, "Delivery selected", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
