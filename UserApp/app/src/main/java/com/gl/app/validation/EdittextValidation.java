package com.gl.app.validation;

import android.content.Context;
import android.text.TextUtils;
import android.widget.EditText;
import android.widget.Toast;

public class EdittextValidation {


    public static boolean isEmpty(EditText username, EditText password) {
        if (TextUtils.isEmpty(username.getText().toString().trim())) {
            username.setError("user name is requried");
            return false;
        }
        if (TextUtils.isEmpty(password.getText().toString().trim())) {
            username.setError("\n password is requried");
            return false;
        }
        return true;
    }
}
