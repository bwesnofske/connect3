package com.example.android.connect3;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    boolean[] redArray = new boolean[9];
    boolean[] yellowArray = new boolean[9];

    boolean[] spaceUsedArray = new boolean[9];

    int duration = Toast.LENGTH_SHORT;

    // used to track a stalemate
    int staleMate = 0;


    // Turn Tracker - red always goes first
    private String turn = "red";

    // Timer used to give enough time for animations to finish before pop up screen appears
    CountDownTimer delay = new CountDownTimer(2500, 1000) {
        @Override
        public void onTick(long millisUntilFinished) {

        }

        @Override
        public void onFinish() {
            Intent intent = new Intent(MainActivity.this,Pop.class);
            intent.putExtra("turn", turn);        //startActivity(new Intent(MainActivity.this,Pop.class));
            startActivity(intent);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = (Button) findViewById(R.id.playAgainButton2);
        button.setTranslationY(-1000f);

        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent i = getBaseContext().getPackageManager()
                        .getLaunchIntentForPackage(getBaseContext().getPackageName());
                i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(i);
            }

            ;


        });

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
                    staleMate++;
                    redArray[clickedImage] = true;

                    token.setTranslationY(-1000f);
                    token.setImageResource(R.drawable.red);
                    token.animate().translationYBy(1000f).setDuration(2000);
                    checkArray(redArray);


                } else {
                    staleMate++;
                    //set correct index in array to true
                    yellowArray[clickedImage] = true;

                    token.setTranslationY(-1000f);
                    token.setImageResource(R.drawable.yellow);
                    token.animate().translationYBy(1000f).setDuration(2000);
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
        } else if (this.staleMate == 9) {
            staleMate();
        } else {
            nextPlayer();
        }
    }


    public void staleMate() {
        Button playAgain2 = (Button) findViewById(R.id.playAgainButton2);
        playAgain2.animate().translationY(500f);
        Toast next = Toast.makeText(getApplicationContext(), "Stalemate! Play Again! ", Toast.LENGTH_LONG);
    }

    public void winner() {
        delay.start();
    }

    public void nextPlayer() {
        if(turn == "red"){
            turn = "yellow";
        } else {
            turn = "red";
        }
        Toast next = Toast.makeText(getApplicationContext(), "Next Player", Toast.LENGTH_SHORT);
        next.show();

    }

    public void spaceUsed() {
        Toast next = Toast.makeText(getApplicationContext(), "Space Already Chosen, Choose Again", Toast.LENGTH_SHORT);
        next.show();

    }


}



