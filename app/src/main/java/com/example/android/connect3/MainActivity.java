package com.example.android.connect3;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    boolean[] redArray = new boolean[9];
    boolean[] yellowArray = new boolean[9];

    boolean[] spaceUsedArray = new boolean[9];

    int duration = Toast.LENGTH_SHORT;


    // Turn Tracker - red always goes first
    private String turn = "red";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        }


    // When a space is clicked place token
    public void setToken(View view) {

        ImageView token = (ImageView) view;

        // Identifies which imageview was clicked for token placement
        int clickedImage = Integer.parseInt(token.getTag().toString());


        if (spaceUsedArray[clickedImage]) {
           spaceUsed();

        } else {

                if (turn == "red") {

                    //set correct index in array to true
                    redArray[clickedImage] = true;

                    token.setTranslationY(-1000f);
                    token.setImageResource(R.drawable.red);
                    token.animate().translationYBy(1000f).setDuration(2000);
                    turn = "yellow";
                    checkArray(redArray);

                } else {

                    //set correct index in array to true
                    yellowArray[clickedImage] = true;

                    token.setTranslationY(-1000f);
                    token.setImageResource(R.drawable.yellow);
                    token.animate().translationYBy(1000f).setDuration(2000);
                    turn = "red";
                    checkArray(yellowArray);

                }

                spaceUsedArray[clickedImage] = true;

            }

    }


    //Method to see if a player has won

    public void checkArray(boolean[] array) {
        if ((array[0] && array[1] && array[2]) == true) {
            winner();
        } else if ((array[3] && array[4] && array[5]) == true) {
            winner();
        } else if ((array[6] && array[7] && array[8]) == true) {
            winner();
        } else if ((array[0] && array[3] && array[6]) == true) {
            winner();
        } else if ((array[1] && array[4] && array[7]) == true) {
            winner();
        } else if ((array[2] && array[5] && array[8]) == true) {
            winner();
        } else if ((array[0] && array[4] && array[8]) == true) {
            winner();
        } else if ((array[2] && array[4] && array[6]) == true) {
            winner();
        } else {
            nextPlayer();
        }
    }

    public void winner() {
        Toast winner = Toast.makeText(getApplicationContext(), "You're the Winner", Toast.LENGTH_LONG);
        winner.show();
        startActivity(new Intent(MainActivity.this,Pop.class));


    }

    public void nextPlayer() {
        Toast next = Toast.makeText(getApplicationContext(), "Next Player", Toast.LENGTH_LONG);
        next.show();

    }

    public void spaceUsed() {
        Toast next = Toast.makeText(getApplicationContext(), "Space Already Chosen, Choose Again", Toast.LENGTH_LONG);
        next.show();

    }

}



    //On click choice

    //We could have both images in place for each spot and have one appear when necc.  We could try to change source of picture on the fly

