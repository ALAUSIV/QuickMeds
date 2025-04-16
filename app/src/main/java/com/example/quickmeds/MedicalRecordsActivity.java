package com.example.quickmeds;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MedicalRecordsActivity extends AppCompatActivity {

    LinearLayout recordsContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medical_records);

        recordsContainer = findViewById(R.id.recordsContainer);

        
        addSection("Allergies", new String[]{
                "Peanut Allergy",
                "Pollen Sensitivity",
                "Lactose Intolerance",
                "Penicillin Allergy"
        });

        addSection("Medications", new String[]{
                "Albuterol HFA 90mcg",
                "Vitamin D 1000 IU",
                "Ibuprofen 400mg",
                "Amoxicillin 250mg"
        });

        addSection("Immunizations", new String[]{
                "Flu Shot - Oct 2023",
                "COVID-19 Booster - Aug 2023",
                "Tetanus - Jul 2022",
                "Hepatitis B - Feb 2021"
        });

        addSection("Lab Results", new String[]{
                "HDL Cholesterol: 53.5 mg/dL",
                "Blood Sugar: Normal - Feb 2023",
                "TSH: 2.1 mIU/L",
                "Vitamin B12: 460 pg/mL"
        });

        addSection("X-Rays", new String[]{
                "Chest X-ray: Normal - Jan 2023",
                "Arm X-ray: No fracture - Dec 2023",
                "Dental X-ray: Routine - Oct 2022",
                "Knee X-ray: Mild inflammation - Aug 2022"
        });

        addSection("Visits", new String[]{
                "Annual Checkup - Jan 2023",
                "Dermatologist Visit - Nov 2023",
                "ENT Visit - Sep 2022",
                "Eye Exam - May 2022"
        });
    }

    private void addSection(String title, String[] records) {
        // Section title
        TextView header = new TextView(this);
        header.setText(title);
        header.setTextSize(16f);
        header.setTypeface(null, Typeface.BOLD);
        header.setTextColor(Color.WHITE);
        header.setPadding(20, 16, 20, 16);
        header.setBackgroundColor(Color.parseColor("#0A2342")); // Navy Blue

        recordsContainer.addView(header);

        for (String record : records) {
            TextView detail = new TextView(this);
            detail.setText(record);
            detail.setTextSize(15f);
            detail.setTextColor(Color.DKGRAY);
            detail.setBackgroundResource(R.drawable.bg_card_rounded);
            detail.setPadding(24, 20, 24, 20);

            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT
            );
            params.setMargins(0, 8, 0, 24);
            detail.setLayoutParams(params);

            recordsContainer.addView(detail);
        }
    }
}
