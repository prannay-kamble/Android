package com.gl.app;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.gl.app.adpter.Employees;
import com.gl.app.validation.EdittextValidation;
import com.gl.app.validation.UserChackValidation;

public class LoginActivity extends AppCompatActivity {

    private EditText user_name, password;
    private Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupVariable();
        login = (Button) findViewById(R.id.loginbutton);
        loginClick(login);

    }

    private void setupVariable() {
        user_name = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        login = (Button) findViewById(R.id.loginbutton);
    }

    //login button event
    public void loginClick(Button login) {
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean validation = EdittextValidation.isEmpty(user_name, password);
                Employees userEmployee = new Employees();
                String username = user_name.getText().toString();
                String password1 = password.getText().toString();
                if (validation) {
                    if (true == UserChackValidation.checkUser(username, password1)) {

                        Intent intent = new Intent(LoginActivity.this, EmployeeActivity.class);
                        startActivity(intent);
                        finish();

                    } else {
                        final AlertDialog.Builder alertDialog = new AlertDialog.Builder(LoginActivity.this);

                        //setting dilag title
                        alertDialog.setTitle("alert dialog");

                        //setting dialog message
                        alertDialog.setMessage("you enter wrong password or username");

                        //setting icon to dialog
                        alertDialog.setIcon(R.drawable.ic_launcher_background);


                        //setting ok button
                        alertDialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();

                            }
                        });

                        alertDialog.setNegativeButton("Reset", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Intent intent = new Intent(getApplicationContext(), RestPasswordActivity.class);
                                startActivity(intent);
                                Toast.makeText(getApplicationContext(), "password rest sussfully", Toast.LENGTH_SHORT).show();

                            }
                        });
                        alertDialog.show();

                    }
                }

            }
        });
    }
}





