package com.chromsicle.multiactivitydemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = findViewById(R.id.myList);
        final ArrayList<String> hobbies = new ArrayList<>();

        hobbies.add("LEGO");
        hobbies.add("Origami");
        hobbies.add("Pokemon GO");
        hobbies.add("Geocaching");

        //create an ArrayAdapter
        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, hobbies);

        //connect the ArrayAdapter with the ListView
        listView.setAdapter(arrayAdapter);

        //when the item is clicked, we want to do an intent and move to the next activity
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getApplicationContext(), SecondActivity.class);
                //pass along the info, which hobby was clicked?
                intent.putExtra("type/write what it is here", hobbies.get(i));
                startActivity(intent);
                //now go deal with where this will be received

            }
        });
    }

    public void goToNext(View view) {
        //to go from one activity to the next, use an intent
        //this makes the intent
        Intent intent = new Intent(getApplicationContext(), SecondActivity.class);

        //with intents you can add an "extra" that's an additional piece of information
        intent.putExtra("age", 28);
        //now go to the receiving activity to get this info

        //this makes the intent happen
        startActivity(intent);
    }
}


