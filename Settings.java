package com.example.jquintero.riddle;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;

//Allows you to play at more difficult levels like insane!!!
//Change how many riddles you have to answer to progess to next level
//Eliminate skip option
//creat an account? so you can upload your own riddles?
public class Settings extends AppCompatActivity {
    //limitless is a 1, not limitless is 0
    private int limitless = 0;
    private int hints = 5;
    private int skips = 5;
//checkboxes for what difficulties will be chosen for play & random
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
    }

    //super easy = unlimited skips & hints
    //easy = 5 skips & 5 hints
    // medium = 2 skips & 2 hints
    //hard = 0 skips & 0 hints
    //later add in difficulty settings for the riddles themselves based on how many people get each one right/wrong

    public void checked(View view){
        CheckBox checkBox = (CheckBox) view;
        int name = checkBox.getId();
        CheckBox superEasy = (CheckBox)findViewById(R.id.checkBox4);
        CheckBox easy = (CheckBox)findViewById(R.id.checkBox1);
        CheckBox medium = (CheckBox)findViewById(R.id.checkBox2);
        CheckBox hard = (CheckBox)findViewById(R.id.checkBox3);

        if(superEasy.isChecked() && superEasy.getId()!=name){
            superEasy.setChecked(false);
        }

        else if(easy.isChecked() && easy.getId()!=name){
            easy.setChecked(false);

        }
        else if(medium.isChecked() && medium.getId()!=name){
            medium.setChecked(false);

        }
        else if(hard.isChecked() && hard.getId()!=name){
            hard.setChecked(false);

        }

    }

    public int isLimitless(){
        return limitless;
    }

    public int numHints(){
        return hints;
    }

    public int numSkips(){
        return skips;
    }

    public void submit(View view){
        CheckBox superEasy = (CheckBox)findViewById(R.id.checkBox4);
        CheckBox easy = (CheckBox)findViewById(R.id.checkBox1);
        CheckBox medium = (CheckBox)findViewById(R.id.checkBox2);
        CheckBox hard = (CheckBox)findViewById(R.id.checkBox3);

        if(superEasy.isChecked()){
            //write to difficulty file 88888 which means limitless
            limitless = 1;
        }
        if(easy.isChecked()){
            //write to difficulty file skips & hints=5
            return;
        }
        if(medium.isChecked()){
            //write to difficulty file skips & hints=2
            skips = 2;
            hints = 2;
        }
        if(hard.isChecked()){
            //write to difficulty file skips & hints=0
            skips = 0;
            hints = 0;
        }
        Intent main = new Intent(Settings.this,MainActivity.class);
        startActivity(main);


    }

}
