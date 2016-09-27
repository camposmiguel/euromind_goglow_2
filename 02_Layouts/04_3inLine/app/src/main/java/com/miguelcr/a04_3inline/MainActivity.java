package com.miguelcr.a04_3inline;

import android.media.Image;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    ImageView box1, box2, box3, box4, box5, box6, box7, box8, box9;
    boolean playerOneIsPlaying = true;
    TextView player;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        player = (TextView) findViewById(R.id.player);
    }

    public void onBoxClick(View view) {
        ImageView currentBox = (ImageView)view;

        if(playerOneIsPlaying) {
            currentBox.setImageResource(R.drawable.ic_box_player_one);
            playerOneIsPlaying = false;
            player.setText("Player 2");
            player.setBackgroundColor(ContextCompat.getColor(this,R.color.colorPlayer2));
        } else {
            currentBox.setImageResource(R.drawable.ic_box_player_two);
            playerOneIsPlaying = true;
            player.setText("Player 1");
            player.setBackgroundColor(ContextCompat.getColor(this,R.color.colorPlayer1));

        }
    }
}
