package com.gl.app.adpter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.gl.app.EmployeeDetalisFragment;
import com.gl.app.EmployeeListFragment;
import com.gl.app.R;

import java.util.List;


public class CustomAdapter extends BaseAdapter {
    Context context;
    List<ListEmployee> employeeLists;


    public CustomAdapter(Context context, List<ListEmployee> employeeList) {
        this.context = context;
        this.employeeLists = employeeList;

    }

    @Override
    public int getCount() {
        return employeeLists.size();
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        if (position == 0) {
            fragment = new EmployeeListFragment();
        } else if (position == 1) {
            fragment = new EmployeeDetalisFragment();
        }
        return fragment;

    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.employee, parent, false);
        }
        ImageView images1 = (ImageView) convertView.findViewById(R.id.empImg1);
        TextView myTitle = (TextView) convertView.findViewById(R.id.textName);
        TextView description = (TextView) convertView.findViewById(R.id.textdeignation);
        int img[] = {R.drawable.emp1, R.drawable.emp2, R.drawable.emp3};
        images1.setImageResource(img[position]);

        myTitle.setText(employeeLists.get(position).getName());
        description.setText(employeeLists.get(position).getDepartment());
        return convertView;
    }
}
