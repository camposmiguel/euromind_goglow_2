package com.miguelcr.a03_loginscreen;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

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
        String emailText = email.getText().toString();
        String passText = pass.getText().toString();

        if(emailText.equals("user@gmail.com") && passText.equals("1234")) {
            Intent i = new Intent(MainActivity.this, HomeActivity.class);
            startActivity(i);
        } else {
            Toast.makeText(MainActivity.this,"Email or password incorrect",
                    Toast.LENGTH_LONG).show();
        }
    }
}
