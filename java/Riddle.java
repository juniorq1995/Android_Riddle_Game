package com.example.jquintero.riddle;

import android.os.Parcelable;
import android.os.Parcel;

/**
 * Created by jquintero on 8/16/16.
 */

public class Riddle implements Parcelable{
    private String riddle;
    private String answer;
    //category ranked from 1-3
    private int category;
    private String hint;

    public Riddle(String riddle, String answer, int category){
        this.riddle = riddle;
        this.answer = answer;
        this.category = category;
    }

    private Riddle(Parcel in){
        this.riddle = in.readString();
        this.answer = in.readString();
        this.category = in.readInt();
        this.hint = in.readString();
    }


    public String getAnswer(){
        return this.answer;
    }

    public String getRiddle(){
        return this.riddle;
    }

    public int getCategory(){
        return this.category;
    }

    public void setHint(String set){
        this.hint = set;
    }

    public String getHint(){
        return this.hint;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(riddle);
        dest.writeString(answer);
        dest.writeInt(category);
        dest.writeString(hint);
    }

    public static final Parcelable.Creator<Riddle> CREATOR = new Parcelable.Creator<Riddle>() {
        public Riddle createFromParcel(Parcel in) {
            return new Riddle(in);
        }

        public Riddle[] newArray(int size) {
            return new Riddle[size];

        }
    };

}
