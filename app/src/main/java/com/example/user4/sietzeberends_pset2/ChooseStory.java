package com.example.user4.sietzeberends_pset2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.io.IOException;

public class ChooseStory extends AppCompatActivity {

    public ChooseStory() throws IOException {
    };

    ListView storyList;
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.choose_story);

        String stories[] = new String[5];
        stories[0] = "Simple";
        stories[1] = "Tarzan";
        stories[2] = "University";
        stories[3] = "Clothes";
        stories[4] = "Dance";

        adapter = new ArrayAdapter<String>(this, R.layout.adapter, stories);
        storyList = findViewById(R.id.storyList);
        storyList.setAdapter(adapter);
    }
}
