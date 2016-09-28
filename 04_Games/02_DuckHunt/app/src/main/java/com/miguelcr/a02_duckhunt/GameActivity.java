package com.miguelcr.a02_duckhunt;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class GameActivity extends AppCompatActivity {
    TextView nick;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        nick = (TextView) findViewById(R.id.textViewNickname);

        Intent i = getIntent();
        Bundle params = i.getExtras();

        String nickName = params.getString("username");
        nick.setText(nickName);
    }


}
