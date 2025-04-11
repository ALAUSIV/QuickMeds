package com.example.quickmeds;

import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class CommunityForumsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_community_forums);

        LinearLayout forumContainer = findViewById(R.id.forumContainer);

        String[] forumTopics = {
                "How do you manage stress during exams?",
                "Best workouts for beginners?",
                "Share your favorite healthy meal ideas!",
                "How do you improve your sleep routine?",
                "Thoughts on the flu vaccine this year?",
                "Best apps for tracking mental health?",
                "What should I pack for a hospital visit?",
                "Tips for starting meditation?",
                "How to stick to a medication routine?",
                "Dealing with health anxiety – advice?"
        };

        for (String topic : forumTopics) {
            TextView topicTextView = new TextView(this);
            topicTextView.setText(topic);
            topicTextView.setTextSize(16f);
            topicTextView.setPadding(16, 12, 16, 12);
            topicTextView.setTextColor(getResources().getColor(android.R.color.black));
            forumContainer.addView(topicTextView);
        }
    }
}
