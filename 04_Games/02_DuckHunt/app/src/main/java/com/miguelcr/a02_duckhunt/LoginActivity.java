package com.miguelcr.a02_duckhunt;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {
    EditText nick;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        nick = (EditText)findViewById(R.id.editTextNickname);
     }

    public void startGame(View view) {
        Intent i = new Intent(LoginActivity.this,
                GameActivity.class);
        i.putExtra("username",nick.getText().toString());
        i.putExtra("level","easy");
        startActivity(i);
    }
}
