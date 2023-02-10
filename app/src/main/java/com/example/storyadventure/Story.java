package com.example.storyadventure;

import android.view.View;

public class Story {

    GameScreen gs;
    String nextPosition1, nextPosition2, nextPosition3, nextPosition4;

    //boolean variable for the special ability of the absorbing shield
    boolean swordsman = false;
    //boolean variable to check if the power of the strike is absorbed
    boolean strikePower = false;

    public Story(GameScreen gs){
        this.gs = gs;
    }

    public void selectPosition(String position){
        switch(position){
            case "startPoint": startPoint();
                break;
            case "sign": sign();
                break;
            case "portal": portal();
                break;
            case "strike": deadlyStrike();
                break;
            case "monster": monster();
                break;
            case "attack": attack();
                break;
            case "dead": dead();
                break;
            case "goTitleScreen": gs.goTitleScreen();
                break;
            case "swordsman": swordsman();
                break;
        }
    }
    //this method will show all buttons when needed
    public void showAllButtons(){

        gs.button1.setVisibility(View.VISIBLE);
        gs.button2.setVisibility(View.VISIBLE);
        gs.button3.setVisibility(View.VISIBLE);
        gs.button4.setVisibility(View.VISIBLE);

    }

    public void startPoint(){
        gs.imageGameScreen.setImageResource(R.drawable.trail);
        gs.textGameScreen.setText("You are on the road.\n\nWhat will you do?");
        gs.button1.setText("Go North!");
        gs.button2.setText("Go East!");
        gs.button3.setText("Go West!");
        gs.button4.setText("Read the Sign!");

        /*
        this is how to make all the buttons visible again, but you have to do it on every single method if there are more screens.
        So what is the solution? ---> We can make other method to do this!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!

        gs.button2.setVisibility(View.VISIBLE);
        gs.button3.setVisibility(View.VISIBLE);
        gs.button4.setVisibility(View.VISIBLE);
        */

        //method for showing all buttons to reduce the number code lines and typing time
        showAllButtons();

        //what happens after clicking a button
        nextPosition1 = "monster";
        nextPosition2 = "swordsman";
        nextPosition3 = "portal";
        nextPosition4 = "sign";

    }
    //by clicking on read the sign
    public void sign(){

        gs.imageGameScreen.setImageResource(R.drawable.sign);
        gs.textGameScreen.setText("Monster Ahead!");
        gs.button1.setText("Go Back");
        gs.button2.setVisibility(View.INVISIBLE);
        gs.button3.setVisibility(View.INVISIBLE);
        gs.button4.setVisibility(View.INVISIBLE);

        //what happens after clicking a button
        nextPosition1 = "startPoint";
        nextPosition2 = "";
        nextPosition3 = "";
        nextPosition4 = "";
    }
    //by clicking on go west
    public void portal(){

        gs.imageGameScreen.setImageResource(R.drawable.portal);
        gs.textGameScreen.setText("You found a magic portal!");
        gs.button1.setText("Teleport");
        gs.button2.setText("Go Back");
        gs.button3.setVisibility(View.INVISIBLE);
        gs.button4.setVisibility(View.INVISIBLE);

        //what happens after clicking a button
        nextPosition1 = "strike";
        nextPosition2 = "startPoint";
        nextPosition3 = "";
        nextPosition4 = "";
    }
    //by click on go east
    public void swordsman(){
        gs.imageGameScreen.setImageResource(R.drawable.swordsman);
        gs.textGameScreen.setText("WOW! WOW! WOW!\n\nYou found an absorbing shield and a sword!");

        swordsman = true;

        gs.button1.setText("Continue");
        gs.button2.setVisibility(View.INVISIBLE);
        gs.button3.setVisibility(View.INVISIBLE);
        gs.button4.setVisibility(View.INVISIBLE);

        //what happens after clicking a button
        nextPosition1 = "startPoint";
        nextPosition2 = "";
        nextPosition3 = "";
        nextPosition4 = "";
    }

    public void deadlyStrike(){

        if(swordsman == false) {
            gs.imageGameScreen.setImageResource(R.drawable.strike);
            gs.textGameScreen.setText("You were hit by a deadly strike!");
            gs.button1.setText("Game Over");
            gs.button2.setVisibility(View.INVISIBLE);
            gs.button3.setVisibility(View.INVISIBLE);
            gs.button4.setVisibility(View.INVISIBLE);

            //what happens after clicking a button
            nextPosition1 = "dead";
            nextPosition2 = "";
            nextPosition3 = "";
            nextPosition4 = "";
        }
        if (swordsman == true){
            gs.imageGameScreen.setImageResource(R.drawable.strike);
            gs.textGameScreen.setText("You have absorbed the deadly strike\nwith your special shield and can use it as a weapon!");
            gs.button1.setText("Continue");
            gs.button2.setVisibility(View.INVISIBLE);
            gs.button3.setVisibility(View.INVISIBLE);
            gs.button4.setVisibility(View.INVISIBLE);

            //show that we absorbed the power
            strikePower = true;

            //what happens after clicking a button
            nextPosition1 = "startPoint";
            nextPosition2 = "";
            nextPosition3 = "";
            nextPosition4 = "";
        }
    }
    public void monster(){
        gs.imageGameScreen.setImageResource(R.drawable.monster);
        gs.textGameScreen.setText("You encounter a monster");
        gs.button1.setText("Attack");
        gs.button2.setText("Run");
        gs.button3.setVisibility(View.INVISIBLE);
        gs.button4.setVisibility(View.INVISIBLE);

        //what happens after clicking a button
        nextPosition1 = "attack";
        nextPosition2 = "startPoint";
        nextPosition3 = "";
        nextPosition4 = "";
    }
    public void attack(){
        if(swordsman == true && strikePower == true){
            gs.imageGameScreen.setImageResource(R.drawable.treasure);
            gs.textGameScreen.setText("You killed the monster with the power of your shield and sword!\n\nThe monster's treasure is now yours!");
            gs.button1.setText("Finish");
            gs.button2.setVisibility(View.INVISIBLE);
            gs.button3.setVisibility(View.INVISIBLE);
            gs.button4.setVisibility(View.INVISIBLE);

            //what happens after clicking a button
            nextPosition1 = "goTitleScreen";

        }else{
            gs.imageGameScreen.setImageResource(R.drawable.dead);
            gs.textGameScreen.setText("The monster is too strong for you!\nYou were killed!");
            gs.button1.setText("Game Oven");
            gs.button2.setVisibility(View.INVISIBLE);
            gs.button3.setVisibility(View.INVISIBLE);
            gs.button4.setVisibility(View.INVISIBLE);

            //what happens after clicking a button
            nextPosition1 = "dead";
        }
        nextPosition2 = "";
        nextPosition3 = "";
        nextPosition4 = "";


    }

    public void dead(){
        gs.imageGameScreen.setImageResource(R.drawable.dead);
        gs.textGameScreen.setText("     Your adventure ends here!");
        gs.button1.setText("Try again");
        gs.button2.setVisibility(View.INVISIBLE);
        gs.button3.setVisibility(View.INVISIBLE);
        gs.button4.setVisibility(View.INVISIBLE);

        //what happens after clicking a button
        nextPosition1 = "goTitleScreen";
        nextPosition2 = "";
        nextPosition3 = "";
        nextPosition4 = "";
    }

}
