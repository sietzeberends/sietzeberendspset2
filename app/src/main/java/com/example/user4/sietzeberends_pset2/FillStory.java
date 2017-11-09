package com.example.user4.sietzeberends_pset2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Random;

public class FillStory extends AppCompatActivity {

    // array of InputStreams to choose from and an InputStream that is used as input for the story
    InputStream input[] = new InputStream[5];
    InputStream choice;
    ArrayList<String> words = new ArrayList<String>();

    // the position of the story in the array and the story itself
    int position;
    Story story;

    // a EditText View to enter words to replace the placeholders
    EditText wordInput;

    // TextView to show how many placeholders are still left to replace
    TextView wordsLeft;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fill_story);

        // initialize the EditText and TextView variables
        wordInput = findViewById(R.id.wordInput);
        wordsLeft = findViewById(R.id.wordsLeft);

        // load all possible stories
        input[0] = getResources().openRawResource(R.raw.madlib0_simple);
        input[1] = getResources().openRawResource(R.raw.madlib1_tarzan);
        input[2] = getResources().openRawResource(R.raw.madlib2_university);
        input[3] = getResources().openRawResource(R.raw.madlib3_clothes);
        input[4] = getResources().openRawResource(R.raw.madlib4_dance);

        // choose a story based on input from the user. If no input is given, choose a random story
        Intent intent = getIntent();
        position= intent.getIntExtra("storyPosition",6);

        // if the user wants a random story
        if (position == 5){
            Random r = new Random();
            int maximum = 5;
            int minimum = 0;
            position = r.nextInt(maximum - minimum) + minimum;
        }
        // choose the story, display the amount of placeholders to replace and the first placeholder
        choice = input[position];
        story = new Story(choice);
        wordInput.setHint(story.getNextPlaceholder());
        wordsLeft.setText("Words left: " + story.getPlaceholderRemainingCount());
    }

    @Override
    public void onSaveInstanceState (Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("storyChoice", position);
        outState.putStringArrayList("words", words);
    }

    @Override
    public void onRestoreInstanceState (Bundle inState) {
        super.onRestoreInstanceState(inState);
        words = inState.getStringArrayList("words");
        choice = input[position];
        story.read(choice);
        for (int i = 0; i < words.size(); i++) {
            story.fillInPlaceholder(words.get(i));
            System.out.println(words.get(i));
            System.out.println(i);
        }
        System.out.println(story.getPlaceholderRemainingCount());
        wordInput.setText("");
        wordInput.setHint(story.getNextPlaceholder());
        wordsLeft.setText("Words left: " + story.getPlaceholderRemainingCount());
    }

    public void fillWord(View v) {
        // replace the placeholder
        String word = wordInput.getText().toString();
        story.fillInPlaceholder(word);
        words.add(word);

        // keep going until all placeholders are replaced
        if (story.getPlaceholderRemainingCount() != 0) {
            wordInput = findViewById(R.id.wordInput);
            wordInput.setText("");
            wordInput.setHint(story.getNextPlaceholder());
            wordsLeft.setText("Words left: " + story.getPlaceholderRemainingCount());
        }

        // if all placeholders are replaced, go to the final activity and display the text
        else{
                Intent intent = new Intent(this, StoryCompleted.class);
                intent.putExtra("story", story.toString());
                startActivity(intent);
            }
        }
    }

