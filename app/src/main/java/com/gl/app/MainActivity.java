package com.gl.app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Button clear,save;

    private EditText name;
    private  Spinner age;
    private  EditText qulification;
      private TextView text1;
     private String name1,age1,qulification1;
    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name=(EditText)findViewById(R.id.editText1);
        age=(Spinner)findViewById(R.id.planets_spinner);
        qulification=(EditText)findViewById(R.id.editText3);
       save=(Button)findViewById(R.id.button1);
       text1=(TextView) findViewById(R.id.textView4);

        clear=(Button)findViewById(R.id.button2);
        save.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                      name1=name.getText().toString();
                      age1=age.getSelectedItem().toString();
                      qulification1=qulification.getText().toString();

                      String result=name1+" " + age1 +" "+qulification1;

                      text1.setText(result);


                    }
                }
        );



        clear.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        name.getText().clear();
                        age1=age.getSelectedItem().toString();

                        qulification.getText().clear();
                    }
                }
        );



    }


}

