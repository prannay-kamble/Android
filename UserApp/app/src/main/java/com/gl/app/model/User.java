package com.gl.app.model;

public class User {
    private String userName;
    private String password;
    private String changePassword;

    public void setChangePassword(String changePassword) {
        this.changePassword = changePassword;
    }

    public String getChangePassword() {
        return changePassword;
    }


    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }
}
