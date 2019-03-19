package com.gl.app.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.gl.app.Iservice.IBasicCalculater;
import com.gl.app.Iservice.service.BasicCalculaterImpl;
import com.gl.app.R;


public class BasicCalculaterFragment extends Fragment {

    public static final String EXTRA_MESSAGE = "Basic Calculater";

    private EditText first_number_text;
    private EditText second_number_text;
    private Button add_button;
    private Button sub_button;
    private Button mul_button;
    private Button div_button;
    private Double first_number;
    private Double second_number;
    private TextView resut_text;

    private IBasicCalculater basicCalculater = null;

    public BasicCalculaterFragment() {
        basicCalculater = new BasicCalculaterImpl();
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_basic_calculater, container, false);
        first_number_text = (EditText) view.findViewById(R.id.id_first_value);
        second_number_text = (EditText) view.findViewById(R.id.id_second_value);
        resut_text = (TextView) view.findViewById(R.id.resut_edit_id);
        add_button = (Button) view.findViewById(R.id.id_button_add);
        addtionOfTwoNumber(add_button);

        sub_button = (Button) view.findViewById(R.id.id_button_sub);
        substationOfTwoNumber(sub_button);

        mul_button = (Button) view.findViewById(R.id.id_button_mlt);
        multipcationOfTwoNumber(mul_button);

        div_button = (Button) view.findViewById(R.id.id_button_div);
        divsionOfTwoNumber(div_button);


        return view;

    }


    public static final BasicCalculaterFragment newInstance(String message) {
        BasicCalculaterFragment f = new BasicCalculaterFragment();
        Bundle args = new Bundle();
        args.putString(EXTRA_MESSAGE, message);
        f.setArguments(args);
        return f;
    }


    //addtion of two nuber
    private void addtionOfTwoNumber(Button addButton) {
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean check = true;
                check = isEmptyCheck(first_number_text, second_number_text);
                if (check) {

                    first_number = Double.parseDouble(first_number_text.getText().toString());
                    second_number = Double.parseDouble(second_number_text.getText().toString());
                    Double addNumber = basicCalculater.add(first_number, second_number);
                    resut_text.setText(String.valueOf(addNumber));
                }
            }
        });
    }


    //for substration
    private void substationOfTwoNumber(Button addButton) {
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean check = true;
                check = isEmptyCheck(first_number_text, second_number_text);
                if (check) {

                    first_number = Double.parseDouble(first_number_text.getText().toString());
                    second_number = Double.parseDouble(second_number_text.getText().toString());
                    Double addNumber = basicCalculater.substraction(first_number, second_number);
                    resut_text.setText(String.valueOf(addNumber));
                }
            }
        });
    }


    //for multipation
    private void multipcationOfTwoNumber(Button addButton) {
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                boolean check = true;
                check = isEmptyCheck(first_number_text, second_number_text);
                if (check) {

                    first_number = Double.parseDouble(first_number_text.getText().toString());
                    second_number = Double.parseDouble(second_number_text.getText().toString());
                    Double addNumber = basicCalculater.multipication(first_number, second_number);
                    resut_text.setText(String.valueOf(addNumber));
                }
            }
        });
    }

    //for divsion
    private void divsionOfTwoNumber(Button addButton) {
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean check = true;
                check = isEmptyCheck(first_number_text, second_number_text);
                if (check) {

                    first_number = Double.parseDouble(first_number_text.getText().toString());
                    second_number = Double.parseDouble(second_number_text.getText().toString());
                    Double addNumber = basicCalculater.divsion(first_number, second_number);
                    resut_text.setText(String.valueOf(addNumber));
                }
            }
        });
    }


    /*
     *   for vlidation on calculatetr
     *   */
    public boolean isEmptyCheck(EditText first_number_text, EditText second_number_text) {

        if (TextUtils.isEmpty(first_number_text.getText().toString().trim())) {
            first_number_text.setError("please  first enter number");
            return false;
        }


        if (TextUtils.isEmpty(second_number_text.getText().toString().trim())) {
            Toast.makeText(getContext(), second_number_text.getText().toString(), Toast.LENGTH_SHORT).show();
            second_number_text.setError("please second enter number");
            return false;
        }

        if (Double.parseDouble(second_number_text.getText().toString()) == 0) {
            first_number_text.setError("  second  number not zero");
            return false;
        }
        return true;
    }
}
