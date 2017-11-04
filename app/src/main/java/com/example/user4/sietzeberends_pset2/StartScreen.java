package com.example.user4.sietzeberends_pset2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.io.IOException;
import java.io.InputStream;

public class StartScreen extends AppCompatActivity {

    public StartScreen() throws IOException {
    }

    Button getStarted;
    InputStream input[] = new InputStream[5];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.start_screen);

        getStarted = findViewById(R.id.introButton);

        input[0] = getResources().openRawResource(R.raw.madlib0_simple);
        input[1] = getResources().openRawResource(R.raw.madlib1_tarzan);
        input[2] = getResources().openRawResource(R.raw.madlib2_university);
        input[3] = getResources().openRawResource(R.raw.madlib3_clothes);
        input[4] = getResources().openRawResource(R.raw.madlib4_dance);

    }

    public void getStarted(View v){
        Intent intent = new Intent(this, ChooseStory.class);
        startActivity(intent);
    }



}
