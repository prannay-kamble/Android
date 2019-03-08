package com.gl.login;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText username, password;
    Button login;

    TextView forgetPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupVariable();

        forgetPassword.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                forgetPassword.setTextColor(Color.BLUE);
            }
        });


    }


    private void setupVariable() {
        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        login = (Button) findViewById(R.id.loginbutton);
        forgetPassword = (TextView) findViewById(R.id.textForgetPassword);
    }

}


