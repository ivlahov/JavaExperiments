package com.example.storyadventure;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.nio.channels.InterruptedByTimeoutException;

public class TitleScreen extends AppCompatActivity {
    //let's instantiate the button "start"
    Button startButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_title_screen); //"R" stays for resources folder; "layout" stays for layout folder; the function of this part of code is to connect the java file with the appropriate xml file

        //let's instantiate the button "start", so we can change it from the java class, we can do thi to all elements of the xml files
        //this is just example, we actually do not need it
        startButton = findViewById(R.id.startButton);
        startButton.setText("Story Adventure");

    }

    //move to game screen by clicking on start button
    //by giving parameter to the method we activate the function "onClick" in the xml file
    public void goGameScreen(View view){

        Intent gameScreen = new Intent(this, GameScreen.class);
        startActivity(gameScreen);
    }
}