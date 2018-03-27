package com.bignerdranch.android.higherlowergame;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    // variable created in main activity so we can use it anywhere
    int randomNumber;

    // new method so we only need to write this random number generator code once
    public void generateRandomNumber() {
        Random rand = new Random();
        randomNumber = rand.nextInt(20) + 1;
    }

    public void guessNumber(View view) {
        //pulls value as an intiger
        EditText userGuess = (EditText) findViewById(R.id.userGuess);
        //convert integer to string
        int guessValue = Integer.parseInt(userGuess.getText().toString());

        //String variable called message
        String message;

        if (guessValue > randomNumber) {
            message = "Lower";
        } else if (guessValue < randomNumber) {
                message = "Higher";
        } else {
            message = "Nice one, guess again!";
            generateRandomNumber();

        }

        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();

        Log.i("Entered Value", userGuess.getText().toString());
        //converts integer to string a logs it
        Log.i("Random Number", Integer.toString(randomNumber));



    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //create random number onCreate method so it runs when app is loaded
        generateRandomNumber();
    }

}
