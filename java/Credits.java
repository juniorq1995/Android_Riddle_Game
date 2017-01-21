package com.example.jquintero.riddle;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import java.util.ArrayList;
import android.widget.TextView;

/**
 * Created by jquintero on 9/4/16.
 */

//display each player's scores
public class Credits extends AppCompatActivity{
    private ArrayList<Player> playerList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.credits);

        //get the list of players that was passed in
        Bundle extras = this.getIntent().getExtras();
        //this is the player list
        playerList = extras.getParcelableArrayList("PlayerList");

        for(int i = 0; i < playerList.size(); i ++) {
            if (i == 0) {
                TextView playerOne = (TextView) findViewById(R.id.playerOne);
                Player player1 = playerList.get(i);
                playerOne.setText(player1.getName() + ":\n# Riddles Correct = " + player1.getCorrect() + "\nNumber Incorrect = " + player1.getIncorrect());
            }
            if(i==1){
                TextView playerTwo = (TextView) findViewById(R.id.playerTwo);
                Player player2 = playerList.get(i);
                playerTwo.setText(player2.getName() + ":\n# Riddles Correct = " + player2.getCorrect() + "\nNumber Incorrect = " + player2.getIncorrect());
                playerTwo.setVisibility(View.VISIBLE);

            }


            if(i==2){
                TextView playerThree = (TextView) findViewById(R.id.playerThree);
                Player player3 = playerList.get(i);
                playerThree.setText(player3.getName() + ":\n# Riddles Correct = " +  player3.getCorrect() + "\nNumber Incorrect = " + player3.getIncorrect());
                playerThree.setVisibility(View.VISIBLE);

            }

            if(i==3){
                TextView playerFour = (TextView) findViewById(R.id.playerFour);
                Player player4 = playerList.get(i);
                playerFour.setText(player4.getName() + ":\n# Riddles Correct = " + player4.getCorrect() + "\nNumber Incorrect = " + player4.getIncorrect());
                playerFour.setVisibility(View.VISIBLE);

            }

            if(i==4){
                TextView playerFive = (TextView) findViewById(R.id.playerFive);
                Player player5 = playerList.get(i);
                playerFive.setText(player5.getName() + ":\n# Riddles Correct = " + player5.getCorrect() + "\nNumber Incorrect = " + player5.getIncorrect());
                playerFive.setVisibility(View.VISIBLE);

            }
        }
    }

    public void menu(View view){
        Intent mainIntent = new Intent(Credits.this,MainActivity.class);
        startActivity(mainIntent);
    }
}
