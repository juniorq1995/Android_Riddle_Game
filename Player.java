package com.example.jquintero.riddle;
import android.os.Parcelable;
import android.os.Parcel;

import java.util.ArrayList;

/**
 * Created by jquintero on 8/28/16.
 */

public class Player implements Parcelable{
    private String playerName;
    private int limitless;
    private int numHints;
    private int numSkips;
    private ArrayList<Integer> skipped;
    private int correct;
    private int incorrect;
    private Settings difficulty;

    public Player(String name){
        difficulty = new Settings();
        this.playerName = name.trim();
        skipped = new ArrayList<Integer>();
        limitless = difficulty.isLimitless();
        correct = 0;
        incorrect = 0;

        numHints = difficulty.numHints();
        numSkips = difficulty.numSkips();
        ///
    }

    private Player(Parcel in){
        this.playerName = in.readString();
        this.limitless = in.readInt();
        this.skipped = (ArrayList<Integer>)in.readSerializable();
        this.correct = in.readInt();
        this.incorrect = in.readInt();
        this.numHints = in.readInt();
        this.numSkips = in.readInt();
    }

    public void answerCorrect(){
        this.correct ++;
    }

    public void answerIncorrect(){
        this.incorrect ++;
    }

    //holds a list of index values for riddles skipped by this player
    public void addSkip(int index){skipped.add(index); }

    //return the list of indices for the riddles skipped
    public ArrayList<Integer> getSkipped(){
        return skipped;
    }

    public String getName(){
        return this.playerName;
    }

    public void useHint(){
        this.numHints--;
    }

    public boolean hasHint(){return this.numHints > 0;}

    public void useSkip(){
        this.numSkips--;
    }

    public boolean hasSkip(){return this.numSkips > 0;}

    public boolean isLimitless(){
        return (this.limitless == 1);
    }

    public int getCorrect(){
        return correct;
    }

    public int getIncorrect(){
        return incorrect;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(playerName);
        dest.writeInt(limitless);
        dest.writeSerializable(skipped);
        dest.writeInt(correct);
        dest.writeInt(incorrect);
        dest.writeInt(numHints);
        dest.writeInt(numSkips);
    }

    public static final Parcelable.Creator<Player> CREATOR = new Parcelable.Creator<Player>() {
        public Player createFromParcel(Parcel in) {
            return new Player(in);
        }

        public Player[] newArray(int size) {
            return new Player[size];

        }
    };

}
