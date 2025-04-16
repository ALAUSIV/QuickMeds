package com.example.quickmeds;

import android.os.Bundle;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class ForumTopicActivity extends AppCompatActivity {

    private ArrayList<String> comments = new ArrayList<>();
    private ArrayAdapter<String> commentAdapter;
    private ListView commentListView;
    private EditText commentInput;
    private Button postButton;
    private TextView topicTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forum_topic);

        topicTextView = findViewById(R.id.topicTitleTextView);
        commentInput = findViewById(R.id.commentInput);
        postButton = findViewById(R.id.postCommentButton);
        commentListView = findViewById(R.id.commentListView);


        String topic = getIntent().getStringExtra("topic");
        topicTextView.setText(topic);


        commentAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, comments);
        commentListView.setAdapter(commentAdapter);

        // handles post button click
        postButton.setOnClickListener(v -> {
            String comment = commentInput.getText().toString().trim();
            if (!comment.isEmpty()) {
                comments.add(comment);
                commentAdapter.notifyDataSetChanged();
                commentInput.setText("");
            } else {
                Toast.makeText(this, "Enter a comment", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
