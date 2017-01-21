package com.example.jquintero.riddle;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.content.Intent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;

/**
 * Created by jquintero on 8/27/16.
 */

public class PlayerSelect extends AppCompatActivity {
    ArrayList<Player> players;
    private int playerCount = 1;
    TextView player;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.player_select);
    }

    public void addPlayer(View view){

        //make another text field and button visible
        if(playerCount==1){
            player = (TextView)findViewById(R.id.player2);
            player.setVisibility(View.VISIBLE);
        }

        if(playerCount==2){
            player = (TextView)findViewById(R.id.player3);
            player.setVisibility(View.VISIBLE);
        }

        if(playerCount==3){
            player = (TextView)findViewById(R.id.player4);
            player.setVisibility(View.VISIBLE);
        }

        if(playerCount==4){
            player = (TextView)findViewById(R.id.player5);
            player.setVisibility(View.VISIBLE);

        }
        if(playerCount==5){
            Toast.makeText(this, "Cannot add any more players!",Toast.LENGTH_SHORT).show();
            return;
        }
        playerCount ++;
    }

    public void removePlayer(View view){
        if(playerCount==2){
            player = (TextView)findViewById(R.id.player2);
            player.setVisibility(View.INVISIBLE);
        }

        if(playerCount==3){
            player = (TextView)findViewById(R.id.player3);
            player.setVisibility(View.INVISIBLE);
        }

        if(playerCount==4){
            player = (TextView)findViewById(R.id.player4);
            player.setVisibility(View.INVISIBLE);
        }

        if(playerCount==5){
            player = (TextView)findViewById(R.id.player5);
            player.setVisibility(View.INVISIBLE);

        }
        if(playerCount==1){
            Toast.makeText(this, "Cannot remove any more players!",Toast.LENGTH_SHORT).show();
            return;
        }
        playerCount --;
    }

    public String getPlayer1(){
        EditText player1 = (EditText) findViewById(R.id.player1);

        return player1.getText().toString();
    }

    public String getPlayer2(){
        EditText player2 = (EditText) findViewById(R.id.player2);

        return player2.getText().toString();
    }

    public String getPlayer3(){
        EditText player3 = (EditText) findViewById(R.id.player3);

        return player3.getText().toString();
    }

    public String getPlayer4(){
        EditText player4 = (EditText) findViewById(R.id.player4);

        return player4.getText().toString();
    }

    public String getPlayer5(){
        EditText player5 = (EditText) findViewById(R.id.player5);

        return player5.getText().toString();
    }

    public ArrayList<Player> playerList() {
        players = new ArrayList<Player>();

        players.add(new Player(getPlayer1()));

        if (playerCount >= 2) {
            players.add(new Player(getPlayer2()));
        }
        if (playerCount >= 3) {
            players.add(new Player(getPlayer3()));
        }
        if (playerCount >= 4) {
            players.add(new Player(getPlayer4()));
        }
        if (playerCount == 5) {
            players.add(new Player(getPlayer5()));
        }
        return players;
    }


    public void startGame(View view){
            Intent gameIntent = new Intent(PlayerSelect.this, Conundrum.class);
            Bundle b = new Bundle();
            ArrayList<Player> playerList = playerList();
            for (int i = 0; i < playerList.size(); i++){
                if(playerList.get(i).getName().equals("")){
                    Toast.makeText(this, "Please choose a name for Player " + (i+1) + "!",Toast.LENGTH_SHORT).show();
                    return;
                }
            }
            b.putParcelableArrayList("PlayerList", playerList());
            gameIntent.putExtras(b);
            startActivity(gameIntent);

        }
}
