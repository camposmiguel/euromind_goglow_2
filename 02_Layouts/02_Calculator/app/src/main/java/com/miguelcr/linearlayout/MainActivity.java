package com.miguelcr.linearlayout;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView screen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        screen = (TextView)findViewById(R.id.textViewScreen);
        screen.setText("0");

        Typeface type = Typeface.createFromAsset(getAssets(),"digital.ttf");
        screen.setTypeface(type);

    }
    public void numberButtonClicked(View view) {
        int idButton = view.getId();
        Button btnSelected = (Button)view;

        writeNumber(btnSelected.getText().toString());
    }
    public void writeNumber(String number) {
        if(screen.getText().toString().equals("0")){
            screen.setText(number);
        } else {
            screen.setText(screen.getText() + number);
        }
    }

    public void eraseClicked(View view) {
        String screenText = screen.getText().toString();
        String newScreenText = screenText.substring(0,screenText.length()-1);
        screen.setText(newScreenText);
    }
}
