package com.gl.app.adpter;

import com.gl.app.model.User;

import java.util.ArrayList;
import java.util.List;

public class Employees {

    public List<ListEmployee> setAllEmployee() {
        ListEmployee employeeList = new ListEmployee();
        ListEmployee employeeList2 = new ListEmployee();
        ListEmployee employeeList3 = new ListEmployee();
        List<ListEmployee> employees = new ArrayList<>();
        employeeList.setName("Employee1");
        employeeList.setDepartment("Java Developer");
        employeeList2.setName("Employee2");
        employeeList2.setDepartment("Java Developer");
        employeeList3.setName("Employee3");
        employeeList3.setDepartment("Java Developer");
        employees.add(employeeList);
        employees.add(employeeList2);
        employees.add(employeeList3);
        return employees;
    }


    public User getUSer() {
        User user = new User();
        user.setPassword("admin");
        user.setUserName("admin");
        return user;
    }
}
