package com.example.quickmeds;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

public class HomeFragment extends Fragment {

    public HomeFragment() {

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Animation anim = AnimationUtils.loadAnimation(getContext(), R.anim.fade_scale_in);

        CardView cardAppointment = view.findViewById(R.id.cardAppointment);
        CardView cardPrescriptions = view.findViewById(R.id.cardPrescriptions);
        CardView cardRecords = view.findViewById(R.id.cardRecords);
        CardView cardPharmacy = view.findViewById(R.id.cardPharmacy);
        CardView cardHealthHistory = view.findViewById(R.id.cardHealthHistory);
        CardView cardForum = view.findViewById(R.id.cardForum);

        CardView[] cards = {cardAppointment, cardPrescriptions, cardRecords, cardPharmacy, cardHealthHistory, cardForum};

        for (int i = 0; i < cards.length; i++) {
            CardView card = cards[i];
            card.setVisibility(View.INVISIBLE);
            new Handler().postDelayed(() -> {
                card.setVisibility(View.VISIBLE);
                card.startAnimation(anim);
            }, i * 150);
        }

        cardAppointment.setOnClickListener(v ->
                startActivity(new Intent(getActivity(), BookAppointmentActivity.class)));

        cardPrescriptions.setOnClickListener(v ->
                startActivity(new Intent(getActivity(), PrescriptionsActivity.class)));

        cardRecords.setOnClickListener(v ->
                startActivity(new Intent(getActivity(), MedicalRecordsActivity.class)));

        cardPharmacy.setOnClickListener(v ->
                startActivity(new Intent(getActivity(), FindPharmacyActivity.class)));

        cardHealthHistory.setOnClickListener(v ->
                startActivity(new Intent(getActivity(), HealthHistoryActivity.class)));

        cardForum.setOnClickListener(v ->
                startActivity(new Intent(getActivity(), CommunityForumsActivity.class)));
    }
}
