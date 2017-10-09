package com.example.android.connect3;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private View space0;
    private View token0;
    boolean[] redArray = new boolean[9] ;
    boolean[] yellowArray = new boolean[9];
    int duration = Toast.LENGTH_SHORT;
    Context context = getApplicationContext();


    // boolean true is red's turn.
    private boolean redTurn = true;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        space0 = findViewById(R.id.spaceView0);
        space0.setAlpha(1f);
        token0 = findViewById(R.id.tokenView0);
        token0.setAlpha(1f);
        token0.setTranslationY(-1000f);


    }




    // When a space is clicked place token
    public void dropToken (View view) {
        if (redTurn = true) {
            // ** Need to set token to correct color
            space0.animate().translationY(3000f);
            token0.animate().
                    translationYBy(1000f).
                    setDuration(2000);

            redTurn = false;
            redArray[0] = true;
            checkArray(redArray);


        } else {
            // ** Need to set token to correct color
            space0.animate().translationY(3000f);
            token0.animate().
                    translationYBy(1000f).
                    setDuration(2000);

            redTurn = true;
            //**Will need to figure out how to adjust array index
            yellowArray[0] = true;
            checkArray(yellowArray);


        }
    }


        // Method to see if a player has won

        public void checkArray (boolean[] array) {
            if (array[0] && array[1] && array[2] == true) {
                winner();
            } else if (array[3] && array[4] && array[5] == true) {
                winner();
            } else if (array[6] && array[7] && array[8] == true) {
                winner();
            } else if (array[0] && array[3] && array[6] == true) {
                winner();
            } else if (array[1] && array[4] && array[7] == true) {
                winner();
            } else if (array[2] && array[5] && array[8] == true) {
                winner();
            } else if (array[0] && array[4] && array[8] == true) {
                winner();
            } else if (array[2] && array[4] && array[6] == true) {
                winner();
            } else {
                nextPlayer();
            }
        }


        public void winner() {
        Toast winner = Toast.makeText(context, "You're the Winner", duration);
        winner.show();
        }

        public void nextPlayer() {
            Toast next = Toast.makeText(context, "Next Player", duration);
            next.show();

    }

    }


    //On click choice

    //We could have both images in place for each spot and have one appear when necc.  We could try to change source of picture on the fly



}
