package com.gl.app.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.gl.app.Iservice.IScintificCalculater;
import com.gl.app.Iservice.service.ScintificCalculaterImpl;
import com.gl.app.R;

import java.text.DecimalFormat;


public class ScientificCalculaterFragment extends Fragment {

    private TextView result_text;
    private Button log_button;
    private Button logn_button;
    private EditText number_text;
    private Double number;
    private static final String EXTRA_MESSAGE = "Scientific Calculater";

    private IScintificCalculater scintificCalculater = null;

    public ScientificCalculaterFragment() {
        scintificCalculater = new ScintificCalculaterImpl();
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static ScientificCalculaterFragment newInstance(String param1, String param2) {
        ScientificCalculaterFragment fragment = new ScientificCalculaterFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_scientific_calculater, container, false);

        number_text = (EditText) view.findViewById(R.id.id_first_value);
        result_text = (TextView) view.findViewById(R.id.resut_edit_id);
        log_button = (Button) view.findViewById(R.id.id_button_log);
        logn_button = (Button) view.findViewById(R.id.id_button_ln);

        logCalcuation(log_button);
        lognCalcuation(logn_button);
        return view;
    }


    public static final ScientificCalculaterFragment newInstance(String message) {
        ScientificCalculaterFragment f = new ScientificCalculaterFragment();
        Bundle args = new Bundle();
        args.putString(EXTRA_MESSAGE, message);
        f.setArguments(args);
        return f;
    }


    //calcualte log math
    private void logCalcuation(Button logButton) {
        logButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean check = true;
                check = isEmptyCheck(number_text);
                if (check) {
                    number = Double.parseDouble(number_text.getText().toString());
                    Double result_number = scintificCalculater.logn(number);
                    DecimalFormat df = new DecimalFormat("#.###");

                    result_text.setText(df.format(result_number));
                }

            }
        });

    }

    //calculate on logn

    private void lognCalcuation(Button lognButton) {
        lognButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                boolean check = true;
                check = isEmptyCheck(number_text);
                if (check) {
                    number = Double.parseDouble(number_text.getText().toString());
                    Double result_number = scintificCalculater.log(number);
                    DecimalFormat df = new DecimalFormat("#.###");
                    result_text.setText(df.format(result_number));
                }
            }
        });

    }


    /*
     *   for vlidation on calculatetr
     *   */
    public boolean isEmptyCheck(EditText number_text) {

        if (TextUtils.isEmpty(number_text.getText().toString().trim())) {
            number_text.setError("please enter number");
            return false;

        }
        if (Double.parseDouble(number_text.getText().toString()) == 0) {
            number_text.setError("number not be 0");
            return false;
        }


        return true;
    }

}
