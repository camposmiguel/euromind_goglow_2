package com.miguelcr.a03_loginscreen;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText email, pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        email = (EditText) findViewById(R.id.editText);
        pass = (EditText) findViewById(R.id.editTextPassword);
    }

    public void doLogin(View view) {
        // email.getText().toString().equals("...") &&

        Intent i = new Intent(MainActivity.this, HomeActivity.class);
        startActivity(i);
    }
}
