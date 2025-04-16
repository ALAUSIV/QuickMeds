package com.example.quickmeds;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.Gravity;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

public class CommunityForumsActivity extends AppCompatActivity {

    LinearLayout forumContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_community_forums);

        forumContainer = findViewById(R.id.forumContainer);
        ImageView addTopicButton = findViewById(R.id.addTopicButton);

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
            addTopicBubble(topic);
        }

        addTopicButton.setOnClickListener(v -> showAddTopicDialog());
    }

    private void showAddTopicDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("New Topic or Question");

        final EditText input = new EditText(this);
        input.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_FLAG_CAP_SENTENCES);
        input.setHint("Write your topic here...");
        builder.setView(input);

        builder.setPositiveButton("Post", (dialog, which) -> {
            String newTopic = input.getText().toString().trim();
            if (!newTopic.isEmpty()) {
                addTopicBubble(newTopic);
            }
        });

        builder.setNegativeButton("Cancel", (dialog, which) -> dialog.cancel());

        builder.show();
    }

    private void addTopicBubble(String text) {
        TextView topicTextView = new TextView(this);
        topicTextView.setText(text);
        topicTextView.setTextSize(16f);
        topicTextView.setPadding(24, 24, 24, 24);
        topicTextView.setTextColor(ContextCompat.getColor(this, android.R.color.black));
        topicTextView.setBackgroundResource(R.drawable.bg_card_rounded2);
        topicTextView.setGravity(Gravity.START);
        topicTextView.setClickable(true);
        topicTextView.setFocusable(true);

        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        );
        layoutParams.setMargins(0, 12, 0, 0);
        topicTextView.setLayoutParams(layoutParams);

        // Click to view & comment on the topic
        topicTextView.setOnClickListener(view -> {
            Intent intent = new Intent(CommunityForumsActivity.this, ForumTopicActivity.class);
            intent.putExtra("topic", text);
            startActivity(intent);
        });

        forumContainer.addView(topicTextView);
    }
}
