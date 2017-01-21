package com.example.jquintero.riddle;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import java.util.ArrayList;
import android.view.View;
import android.widget.TextView;

//simply generates a random riddle
//click button at bottom of screen to show riddle
//click button at right to get another riddle
public class Random extends AppCompatActivity {
    private ArrayList<Riddle> riddles = new RiddleList().getList();
    private int count = 0;
    private Riddle currentRiddle;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_random);

    }

    public void displayRandomRiddle(View view){
        TextView randomAnswer = (TextView) findViewById(R.id.randomAnswer);
        TextView randomRiddle = (TextView) findViewById(R.id.randomRiddle);
        TextView randomClick = (TextView)findViewById(R.id.randomClick);
        //send user back to main menu
        if(randomClick.getText().equals("Congratulations!\nIf you want to return to the Main Menu click this box")){
            Intent menuIntent = new Intent(Random.this,MainActivity.class);
            startActivity(menuIntent);
        }

        if(riddles.size()==0){
            randomClick.setText("Congratulations!\nIf you want to return to the Main Menu click this box");
            randomRiddle.setVisibility(View.INVISIBLE);
            randomAnswer.setText("Otherwise, click here to roll through some more Randomly picked Riddles!");
            randomAnswer.setVisibility(View.VISIBLE);
        }

        if(!(randomAnswer.getText().equals("Click to see Answer") || randomAnswer.getText().equals("Otherwise, click here to roll through some more Randomly picked Riddles!"))){
            randomAnswer.setText("Click to see Answer");
            randomAnswer.setVisibility(View.INVISIBLE);
        }

        if(0<riddles.size()) {
            count = (int )(Math.random() * riddles.size());

            currentRiddle = riddles.remove(count);
            randomRiddle.setText(currentRiddle.getRiddle());
            randomRiddle.setVisibility(View.VISIBLE);

            randomAnswer.setVisibility(View.VISIBLE);
        }

    }
    public void displayRandomAnswer(View view){
        TextView randomAnswer = (TextView) findViewById(R.id.randomAnswer);

        if(randomAnswer.getText().equals("Otherwise, click here to roll through some more Randomly picked Riddles!")){
            //reset activity
            super.recreate();
        }
        else {
            randomAnswer.setText(currentRiddle.getAnswer());
        }
    }
}
