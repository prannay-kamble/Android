package com.gl.app;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.gl.app.adpter.CustomAdapter;
import com.gl.app.adpter.Employees;
import com.gl.app.adpter.ListEmployee;

import java.util.Collection;
import java.util.Collections;
import java.util.List;


public class EmployeeListFragment extends Fragment {
    int[] img;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        Employees employee = new Employees();
        //invoke method
        List<ListEmployee> listEmployee = employee.setAllEmployee();
        // Inflate the layout for this fragment
        inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        CustomAdapter adapter = new CustomAdapter(getContext(), listEmployee);

        View view = inflater.inflate(R.layout.fragment_employee_list, container, false);
        ListView list = view.findViewById(R.id.list1);
        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Employees employee1 = new Employees();
                List<ListEmployee> listEmployee1 = employee1.setAllEmployee();

                EmployeeDetalisFragment employeeDetalisFragment = new EmployeeDetalisFragment();
                Bundle bundle = new Bundle();
                String employeeName = listEmployee1.get(position).getName();
                String employeeDesgnation = listEmployee1.get(position).getDepartment();
                int[] image = {R.drawable.emp1, R.drawable.emp2, R.drawable.emp3};
                bundle.putString("name", employeeName);
                bundle.putString("desgnation", employeeDesgnation);
                bundle.putInt("image", image[position]);
                employeeDetalisFragment.setArguments(bundle);
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.employeeList, employeeDetalisFragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });
        return view;
    }


}
