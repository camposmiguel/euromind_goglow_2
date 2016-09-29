package com.miguelcr.a02_duckhunt;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class GameActivity extends AppCompatActivity {
    TextView nick, textCounter, textCountdown;
    Random random;
    ImageView duck;
    int counter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        nick = (TextView) findViewById(R.id.textViewNickname);
        duck = (ImageView)findViewById(R.id.imageViewDuck);
        textCounter = (TextView) findViewById(R.id.textViewCounter);
        textCountdown = (TextView) findViewById(R.id.textViewCountdown);

        Intent i = getIntent();
        Bundle params = i.getExtras();

        String nickName = params.getString("username");
        nick.setText(nickName);
        nick.setTypeface(Typeface.createFromAsset(getAssets(),"pixel.ttf"));

        random = new Random();

        // Countdown timer 60s >>> 60000ms
        new CountDownTimer(60000, 1000) {

            public void onTick(long millisUntilFinished) {
                textCountdown.setText(millisUntilFinished / 1000+"s");
            }

            public void onFinish() {
                textCountdown.setText("Game over!");
            }
        }.start();

    }

    public void generateRandomDuckPosition(View v) {
        // Increase the counter
        counter++;
        textCounter.setText(String.valueOf(counter));

        DisplayMetrics displaymetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);
        int height = displaymetrics.heightPixels;
        int width = displaymetrics.widthPixels;

        // Get imagesView properties
        int duckWidth = duck.getWidth();
        int duckHeight = duck.getHeight();

        int xPosition = random.nextInt(width - duckWidth - 0 + 1) + 0;
        int yPosition = random.nextInt(height - duckHeight - 0 + 1) + 0;

        // Move the ImageViewDuck to the new position (xPosition,yPosition)
        duck.setX(xPosition);
        duck.setY(yPosition);
    }

}
