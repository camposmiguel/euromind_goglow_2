package com.miguelcr.linearlayout;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView screen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        screen = (TextView)findViewById(R.id.textViewScreen);
        screen.setText("0.0");

        Typeface type = Typeface.createFromAsset(getAssets(),"digital.ttf");
        screen.setTypeface(type);

    }
}
