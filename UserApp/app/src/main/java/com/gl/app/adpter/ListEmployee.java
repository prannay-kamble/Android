package com.gl.app.adpter;

import android.media.Image;

public class ListEmployee {
    private String name;
    private String department;
    private Image image;

    public ListEmployee(){}

    public String getName() {
        return name;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public Image getImage() {
        return image;
    }

    public String getDepartment() {
        return department;
    }

    public void setName(String name) {
        this.name = name;
    }


    public void setDepartment(String department) {
        this.department = department;
    }

    public ListEmployee(String name, String department, Image image) {
        this.name = name;
        this.department = department;
        this.image = image;
    }
}
