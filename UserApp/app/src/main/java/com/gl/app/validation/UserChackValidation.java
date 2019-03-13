package com.gl.app.validation;

import com.gl.app.adpter.Employees;

public class UserChackValidation {

    public static boolean checkUser(String userName, String password) {
        Employees userEmloyee = new Employees();
        if (userEmloyee.getUSer().getUserName().equals(userName) && userEmloyee.getUSer().getPassword().equals(password)) {
            return true;
        } else {
            return false;
        }
    }
}
