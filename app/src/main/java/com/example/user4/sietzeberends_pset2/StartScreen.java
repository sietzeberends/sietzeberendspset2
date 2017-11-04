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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.start_screen);
    }

    // method that is called when the get started button is clicked
    public void getStarted(View v){
        Intent intent = new Intent(this, ChooseStory.class);
        startActivity(intent);
    }
}