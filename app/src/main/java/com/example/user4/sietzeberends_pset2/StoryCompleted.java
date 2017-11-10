package com.example.user4.sietzeberends_pset2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class StoryCompleted extends AppCompatActivity {

    // the final story
    TextView story;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.story_completed);

        // initialize the final story and display it
        story = findViewById(R.id.story);
        Intent intent = getIntent();
        String text = intent.getStringExtra("story");
        story.setText(text);
    }

    public void onBackPressed() {
        Intent intent = new Intent(this, StartScreen.class);
        startActivity(intent);
    }
}
