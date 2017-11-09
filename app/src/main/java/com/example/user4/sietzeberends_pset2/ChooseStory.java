package com.example.user4.sietzeberends_pset2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.io.IOException;

public class ChooseStory extends AppCompatActivity {

    public ChooseStory() throws IOException {
    };

    // track a ListView containing possible stories to choose from
    ListView storyList;

    // ArrayAdapter that is used to fill the ListView
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.choose_story);

        // all possible stories to choose, including the option to pick a random one
        String stories[] = new String[6];
        stories[0] = "Simple";
        stories[1] = "Tarzan";
        stories[2] = "University";
        stories[3] = "Clothes";
        stories[4] = "Dance";
        stories[5] = "Random";

        // initialize the ArrayAdapter and the ListView
        adapter = new ArrayAdapter<String>(this, R.layout.adapter, stories);
        storyList = findViewById(R.id.storyList);
        storyList.setAdapter(adapter);

        // when a list item is clicked
        storyList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // store the index of the clicked item
                // corresponds with story index in FillStory activity
                pickStory(position);
            }
        });
    }


    public void pickStory(int index) {
        // start FillStory, include the index of the chosen story
        Intent intent = new Intent(this, FillStory.class);
        intent.putExtra("storyPosition", index);
        startActivity(intent);

    }
}
