package com.example.jquintero.riddle;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //find the view that shows the Play activity
        TextView play = (TextView)findViewById(R.id.play);
        //numbers
        //set clickListener on that view
        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent numbersIntent = new Intent(MainActivity.this,PlayerSelect.class);
                startActivity(numbersIntent);
            }
        });

        //find the view that shows the browse activity
        TextView browse = (TextView)findViewById(R.id.browse);
        //browse
        //set clickListener on that view
        browse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent numbersIntent = new Intent(MainActivity.this,Browse.class);
                startActivity(numbersIntent);
            }
        });


        //find the view that shows the numbers category
        TextView settings = (TextView)findViewById(R.id.settings);
        //numbers
        //set clickListener on that view
        settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent numbersIntent = new Intent(MainActivity.this,Settings.class);
                startActivity(numbersIntent);
            }
        });


        //find the view that shows the numbers category
        TextView random = (TextView)findViewById(R.id.random);
        //numbers
        //set clickListener on that view
        random.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent numbersIntent = new Intent(MainActivity.this,Random.class);
                startActivity(numbersIntent);
            }
        });
    }
}
