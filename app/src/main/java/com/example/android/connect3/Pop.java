package com.example.android.connect3;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

/**
 * Created by Brian Wesnofske on 10/15/2017.
 */

class Pop extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.popwindow);

        // Video view to play victory video
        VideoView videoView = (VideoView) findViewById(R.id.videoView);

        videoView.setVideoPath("android.resource://" + getPackageName() + "/" + R.raw.fireworks);

        // Controller to manipulate videoo
        MediaController mediaController = new MediaController(this);

        mediaController.setAnchorView(videoView);

        videoView.setMediaController(mediaController);

        videoView.start();


        Button playAgain = (Button) findViewById(R.id.button);

        TextView textView = (TextView) findViewById(R.id.textViewPop);

        RelativeLayout popLayout2 = (RelativeLayout) findViewById(R.id.popLayout);

        // String used to check whose turn it was on the winning move.
        String winner = getIntent().getStringExtra("turn");


        Toast next = Toast.makeText(getApplicationContext(), winner, Toast.LENGTH_LONG);
        next.show();

        if (winner.equalsIgnoreCase("red")) {
            textView.setText("Congrats " + winner.toUpperCase() + " Player Won!");
            popLayout2.setBackgroundColor(Color.parseColor("#ffcc0000"));
        } else {
            textView.setText("Congrats " + winner.toUpperCase() + " Player Won!");
            popLayout2.setBackgroundColor(Color.parseColor("#ffffbb33"));
        }


        playAgain.setOnClickListener(new View.OnClickListener() {

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
}
