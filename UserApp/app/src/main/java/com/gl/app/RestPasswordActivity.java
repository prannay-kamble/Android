package com.gl.app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.gl.app.model.User;

public class RestPasswordActivity extends AppCompatActivity {

    private EditText old_password;
    private EditText new_password;

    private String old_paa, new_pass;
    private Button change, main;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rest_password);

        setupVariable();
        onChangeClick(change);
    }

    private void setupVariable() {
        old_password = (EditText) findViewById(R.id.old_password);
        new_password = (EditText) findViewById(R.id.new_password);
        change = (Button) findViewById(R.id.bChange2);
        main = (Button) findViewById(R.id.main_page);
    }


    public void onChangeClick(Button onChange) {
        old_paa = old_password.getText().toString();
        new_pass = new_password.getText().toString();
        onChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (old_paa.equals(new_pass)) {
                    User user = new User();
                    user.setPassword(new_pass);
                    Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                    startActivity(intent);
                    Toast.makeText(getApplicationContext(), " rest password succssfully", Toast.LENGTH_SHORT).show();
                } else {
                    change.setError("password are not accept");
                    return;

                }
            }
        });

    }

}
