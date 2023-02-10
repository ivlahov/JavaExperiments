package com.example.storyadventure;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


public class GameScreen extends AppCompatActivity {

    //Instances
    ImageView imageGameScreen;
    TextView textGameScreen;
    Button button1, button2, button3, button4;

    Story story = new Story(this);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_screen); //"R" stays for resources folder; "layout" stays for layout folder; the function of this part of code is to connect the java file with the appropriate xml file

        imageGameScreen = findViewById(R.id.gameImageView);
        textGameScreen = findViewById(R.id.gameTextView);
        button1 = findViewById(R.id.choiceButton1);
        button2 = findViewById(R.id.choiceButton2);
        button3 = findViewById(R.id.choiceButton3);
        button4 = findViewById(R.id.choiceButton4);
        /*
        button1.setTransformationMethod(null);   //this allows you to change the default uppercase letter text on the bottom to lowercase
        */
        story.startPoint();

    }
    public void button1(View view){
        story.selectPosition(story.nextPosition1);
    }
    public void button2(View view){
        story.selectPosition(story.nextPosition2);
    }
    public void button3(View view){
        story.selectPosition(story.nextPosition3);
    }
    public void button4(View view){
        story.selectPosition(story.nextPosition4);
    }

    //move to title screen when you are dead or finish the story
    //by giving parameter to the method we activate the function "onClick" in the xml file
    public void goTitleScreen(){

        Intent titleScreen = new Intent(this,TitleScreen.class);
        startActivity(titleScreen);
    }
}