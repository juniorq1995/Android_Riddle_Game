package com.example.jquintero.riddle;

import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import android.util.Log;

/**
 * Created by jquintero on 8/23/16.
 */

public class RiddleList {
    private ArrayList<Riddle> riddles;
    private String riddle = "";
    private String answer = "";
    private int category = 0;
    Scanner sc;
    Scanner slash;

    public RiddleList() {
        riddles = new ArrayList<Riddle>();
        riddles.add(new Riddle("A big black dog stood in the middle of a black road. There were no street lights above the road. An old car with broken headlights drove towards the dog but turned in time before he hit it. How did the driver see the dog in time?","It was daytime",2 ));
        riddles.add(new Riddle("How to put ten identical balls on a surface so that you can have 5 lines of balls with four balls on each line?","Make a 5 pointed star",3));
        riddles.add(new Riddle("What lies on the ground? A hundred feet in the air?","A dead centipede",1));
        riddles.add(new Riddle("To you, rude I would never be. Though I flag my tongue for all to see. What am I?","A dog",2));
        riddles.add(new Riddle("Imagine that you’re on a television game show and the host presents you with three closed doors. Behind one of them, sits a sparkling, brand-new Lincoln Continental; behind the other two, are smelly old goats. The host implores you to pick a door, and you select door #1. Then, the host, who is well-aware of what’s going on behind the scenes, opens door #3, revealing one of the goats. “Now,” he says, turning toward you, “do you want to keep door #1, or do you want to switch to door #2?”","You should always switch doors because in the beginning there is a 1/3 chance door #1 is correct and a 2/3 chance that doors #2 & #3 are correct. Once one of those doors is opened the 2/3 probability transfers to the other door, making it have a 2/3 chance and yours a 1/3 chance",3));
        riddles.add(new Riddle("There is a plane that is flying close to the border between Canada and the U.S.A. There is an engine failure and the plane crashes right on the border of Canada and U.S.A. Where do they bury the survivors?","Nowhere, there are no survivors",2));
        riddles.add(new Riddle("What tastes better than it smells?","A tongue",1));
        riddles.add(new Riddle("A man is on a trip with a fox, a goose, and a sack of corn. He comes upon a stream which he has to cross, and finds a tiny boat which he can use for the same. The problem though, is that he can only take himself and either the fox, the goose, or the corn across at a time. It is not possible for him to leave the fox alone with the goose or the goose alone with the corn. How can he get all safely over the stream?","Take the goose over first and come back. Then take the fox over and bring the goose back. Now take the corn over and come back alone to get the goose. Take the goose over and the job is done!",3));
        riddles.add(new Riddle("A boy was at a carnival and went to a booth where a man said to the boy, \"If I write your exact weight on this piece of paper then you have to give me $50, but if I cannot, I will pay you $50.\" The boy looked around and saw no scale so he agrees, thinking no matter what the carny writes he'll just say he weighs more or less. In the end the boy ended up paying the man $50. How did the man win the bet?","The man did exactly as he said he would and wrote 'your exact weight' on the paper",1));
        riddles.add(new Riddle("What falls, but does not break, and what breaks but does not fall?","Night falls and day breaks",2));
        riddles.add(new Riddle("A bus driver runs a red light while on the wrong side of the street, yet he has not broken any laws. How is this possible?","He is walking",2));
        riddles.add(new Riddle("What has a head and tail, but no body?","A coin",1));
        riddles.add(new Riddle("I am not your brother, but you are mine. Who am I?","Your sister",3));
        riddles.add(new Riddle("What loses its head in the morning but gets it back at night?","A pillow",2));
        riddles.add(new Riddle("You have two coins that add up to 30 cents. One of them is not a nickel. What kinds of coins do you have?","A quarter and a nickel, one of them isn’t a nickel the other is!",1));
        riddles.add(new Riddle("What eleven letter word does everyone spell incorrectly?","Incorrectly",1));
        riddles.add(new Riddle("What occurs once in a minute, twice in a moment, but never in a thousand years?","The letter M",2));
        riddles.add(new Riddle("When is a door not a door?","When it is ajar",1));
        riddles.add(new Riddle("What has four wheels and flies?","A garbage truck",1));
        riddles.add(new Riddle("We are very little creatures; all of us have different features. One of us is set; one of us you’ll find in a jet. Another you may see in tin. And a fourth is boxed within. If the fifth you should pursue, it can never fly from you. What are we?","The vowels a, e, i, o, and u",2));
        riddles.add(new Riddle("Where may you find roads without cars, forests, without trees, rivers without water, and cities without houses?","A map",2));
        riddles.add(new Riddle("I have a hundred legs but cannot stand, a long neck but no head; I eat the maid’s life. What am I?","A broom",2));
        riddles.add(new Riddle("Cannot be seen, cannot be felt, cannot be heard, cannot be smelt, it lies behind the stars and beneath the hills, ends life and kills laughter. What is it?","The dark",2));
        riddles.add(new Riddle("This thing runs but cannot walk, sometimes sings but never talks, lacks arms but has hands; lacks a head but has a face. What is it?","A clock",2));
        riddles.add(new Riddle("What lives in winter, dies in summer, and grows with its roots upward?","Icicle",2));
        riddles.add(new Riddle("Man walks over; man walks under; in times of war he burns asunder.","A bridge",2));
        riddles.add(new Riddle("In a tunnel of darkness lies a beast of metal. It can only attack when pulled back. What is it?","A bullet",2));
        riddles.add(new Riddle("Walk on the living, they don’t even mumble. Walk on the dead, they mutter and grumble. What are they?","Fallen leaves",2));
        riddles.add(new Riddle("I am emeralds and diamonds. Lost by the moon. I am found by the sun and picked up soon. What am I?","Dew",2));
        riddles.add(new Riddle("What is the difference between a cat and a complex sentence?","A cat has claws at the end of its paws and a complex sentence has a pause at the end of its clause",1));
        riddles.add(new Riddle("With no wings, I fly, with no eyes, I see, with no arms, I climb, more frightening than any beast, stronger than any foe, I am cunning, ruthless and tall; in the end, I rule all. What am I?","Imagination",2));
        riddles.add(new Riddle("A big moron and a little moron were standing on the bridge over the river when the big moron fell off. How come the little moron didn’t fall off too?","Because he was a little more on",1));
        riddles.add(new Riddle("You can spin, wheel, and twist, but it can turn without moving. What is it?","Milk",2));
        riddles.add(new Riddle("Today he is there to trip you up and he will torture you tomorrow. Yet he is also there to ease the pain, when you are lost in grief and sorrow.","Alcohol",2));
        riddles.add(new Riddle("You hear it speak, for it has a hard tongue. But it cannot breathe, for it has not a lung. What is it?","A bell",2));
        riddles.add(new Riddle("Who killed one fourth of mankind?","Cain (killed Abel, leaving himself, Adam and Eve)",3));
        riddles.add(new Riddle("No sooner spoken than broken. What is it?","Silence",2));
        riddles.add(new Riddle("Brothers or sisters have I none, but that man’s father is my father’s son. Who is he?","My son",3));
        riddles.add(new Riddle("What is the difference between a penniless man and a feather bed?","One is hard up and the other is soft down",1));
        riddles.add(new Riddle("What is deaf, dumb, and blind and always tells the truth?","A mirror",2));
        riddles.add(new Riddle("What can you break without hitting or dropping?","A promise",2));
        riddles.add(new Riddle("Who is it that rows quickly with four oars but never comes out from under his own roof?","A turtle",2));




        /*
        final String workingDir = System.getProperty("user.dir");

        try{
        Log.i("HERE",workingDir);

        sc = new Scanner(new File("riddles.txt"));

            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                slash = new Scanner(line).useDelimiter("//");
                while(slash.hasNext()){
                    riddle = slash.next();
                    answer = slash.next();
                    category = slash.nextInt();
                }
                riddles.add(new Riddle(riddle,answer,category));
            }
            sc.close();
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }*/
    }

    public ArrayList<Riddle> getList(){
        return riddles;
    }
}
