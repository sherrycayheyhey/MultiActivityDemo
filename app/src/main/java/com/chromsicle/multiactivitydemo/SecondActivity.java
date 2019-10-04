package com.chromsicle.multiactivitydemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        //this is how you access the info in the extra from the other intent
        Intent intent = getIntent();
        //default value is given in case the info doesn't make it over
        int age = intent.getIntExtra("age", 0);

        Toast.makeText(this, Integer.toString(age), Toast.LENGTH_SHORT).show();

        //this is where we're dealing with the ListView hobby info
        String whatToDo = intent.getStringExtra("type/write what it is here");
        Toast.makeText(this, whatToDo, Toast.LENGTH_SHORT).show();


    }

    public void goBack(View view){
        /*using this code makes it so the intents all stack up, you have to press the back button
                a bunch to actually go back to the home screen that way
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intent);*/

        //using this code just sends you back to the other intent
        finish();
    }
}
