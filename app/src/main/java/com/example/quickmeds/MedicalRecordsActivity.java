package com.example.quickmeds;

import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MedicalRecordsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medical_records);

        LinearLayout recordsContainer = findViewById(R.id.recordsContainer);

        String[] medicalRecords = {
                " General Checkup – Jan 15, 2024: Blood pressure and heart rate normal.",
                " Blood Test – Feb 10, 2024: Slightly low vitamin B12, advised supplements.",
                " Prescription – Mar 5, 2024: Prescribed Ibuprofen 400mg for muscle pain.",
                " Allergy Report – Apr 12, 2024: Seasonal pollen allergy confirmed.",
                " Vaccination – May 22, 2024: Received second COVID-19 booster.",
                " Cardiologist Visit – Jun 18, 2024: Mild arrhythmia, follow-up in 6 months.",
                " Mental Health Session – Jul 3, 2024: Discussed anxiety coping strategies.",
                " Dentist Visit – Aug 9, 2024: Routine cleaning, no cavities.",
                " X-Ray – Sep 2, 2024: Chest X-ray, lungs clear.",
                " Minor Surgery – Oct 11, 2024: Mole removal under local anesthesia, biopsy benign."
        };

        for (String record : medicalRecords) {
            TextView recordTextView = new TextView(this);
            recordTextView.setText(record);
            recordTextView.setTextSize(16f);
            recordTextView.setPadding(16, 12, 16, 12);
            recordTextView.setTextColor(getResources().getColor(android.R.color.black));
            recordsContainer.addView(recordTextView);
        }
    }
}
