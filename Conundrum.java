package com.example.jquintero.riddle;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.support.v7.app.AppCompatActivity;

import android.util.Log;
import java.util.ArrayList;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by jquintero on 8/30/16.
 */

public class Conundrum extends AppCompatActivity {
    private ArrayList<Player> playerList;
    private ArrayList<Riddle> conRiddles;
    private ArrayList<Riddle> riddles;
    private Riddle currentRiddle;
    private Player currentPlayer;
    private int currPlayIndex = 0;

    //the inde of the current player;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);

        //get the list of players that was passed in
        Bundle extras = this.getIntent().getExtras();
        //this is the player list
        playerList = extras.getParcelableArrayList("PlayerList");

        //this is the riddle list, REMOVE any riddles passed over by player, those that are skipped are NOT REMOVED unless passed over by all players
        riddles = new RiddleList().getList();
        conRiddles = new ArrayList<Riddle>();
        for(int i = 0; i < riddles.size(); i ++)
            {
            if(riddles.get(i).getCategory()==1)
                {
                conRiddles.add(riddles.remove(i));
                }
            }
            //now when player presses button, randomly pick a riddle from new filtered list

        //go through list of players, playing the game on current level with each player
        this.nextPlayer();

    }

    public void nextPlayer()
        {
        Log.i("Current Player Index","" + currPlayIndex);

        if(currPlayIndex<playerList.size())
            {
            this.newRiddle();
            currentPlayer = playerList.get(currPlayIndex);
            this.play(currentPlayer);
            return;
            }
        this.nextCategory();
        }

    public void play(Player player){
        TextView name = (TextView)findViewById(R.id.playerX);
        TextView answerView = (TextView)findViewById(R.id.answerX);
        Button correct = (Button)findViewById(R.id.correct);
        Button incorrect = (Button)findViewById(R.id.incorrect);

        name.setText(player.getName() + "'s Turn");

        if (!answerView.getText().equals("Click to see the Answer")){
            answerView.setText("Click to see the Answer");
        }
        correct.setVisibility(View.INVISIBLE);
        incorrect.setVisibility(View.INVISIBLE);

    }

    //skip current riddle for current user, but DO NOT remove so that other players may try out the riddle
    public void skip(View view){
        //check players skip count
        if(!currentPlayer.isLimitless() || !currentPlayer.hasSkip()){
            Toast.makeText(this, "You are out of skips",Toast.LENGTH_LONG).show();
            return;
        }

        //decrease players skip count
        if(!currentPlayer.isLimitless()){
            currentPlayer.useSkip();
        }

        Button correct = (Button)findViewById(R.id.correct);
        Button incorrect = (Button)findViewById(R.id.incorrect);
        TextView answerView = (TextView)findViewById(R.id.answerX);
        correct.setVisibility(View.INVISIBLE);
        incorrect.setVisibility(View.INVISIBLE);
        answerView.setText("Click to see the Answer");
        conRiddles.add(currentRiddle);
        this.newRiddle();
    }

    //display hint for the user
    public void hint(View view){
        //check player's hint count
        if(!currentPlayer.isLimitless() || !currentPlayer.hasHint()){
            Toast.makeText(this, "You are out of hints",Toast.LENGTH_LONG).show();
            return;
        }

        //decrease players hints count
        if(!currentPlayer.isLimitless()){
            currentPlayer.useHint();
        }

        Toast.makeText(this, currentRiddle.getHint(),Toast.LENGTH_LONG).show();
    }

    //onClick method that picks the riddle
    public void newRiddle(){
        TextView riddleView = (TextView)findViewById(R.id.riddleX);


        //select random riddle
        int tempCount = (int )(Math.random() * conRiddles.size());
        currentRiddle = conRiddles.remove(tempCount);

        riddleView.setText(currentRiddle.getRiddle());
        riddleView.setVisibility(View.VISIBLE);
    }

    //onClick method that shows the answer to the riddle
    public void showAnswer(View view){
        TextView answerView = (TextView)findViewById(R.id.answerX);
        Button correct = (Button)findViewById(R.id.correct);
        Button incorrect = (Button)findViewById(R.id.incorrect);
        if (!answerView.getText().equals("Click to see the Answer")){return;}



        answerView.setText(currentRiddle.getAnswer());
        answerView.setVisibility(View.VISIBLE);
        correct.setVisibility(View.VISIBLE);
        incorrect.setVisibility(View.VISIBLE);
    }


    public void correct(View view){
        currentPlayer.answerCorrect();
        currPlayIndex++;
        this.nextPlayer();
    }

    public void incorrect(View view){
        currentPlayer.answerIncorrect();
        currPlayIndex++;
        this.nextPlayer();
    }

    //create intent and use to move to enigma/next riddle category
    public void nextCategory(){
        Intent enigmaIntent = new Intent(Conundrum.this,Enigma.class);
        Bundle b = new Bundle();
        b.putParcelableArrayList("PlayerList", playerList);
        b.putParcelableArrayList("RiddleList", riddles);
        enigmaIntent.putExtras(b);
        startActivity(enigmaIntent);

    }
}
