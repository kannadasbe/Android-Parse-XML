package com.example.kannadasang.recyclerview;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by KannadasanG on 7/26/2016.
 */
public class EmployeeAdapter extends RecyclerView.Adapter<EmployeeAdapter.EmployeeViewHolder> {
    List<Employee> employees = new ArrayList<>();

    public EmployeeAdapter(List<Employee> employees) {
        this.employees = employees;
    }

    @Override
    public EmployeeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_row, parent, false);
        return new EmployeeViewHolder(view);
    }

    public class EmployeeViewHolder extends RecyclerView.ViewHolder {
        TextView empName, empDesignation, empGender, empYear;

        View divider;

        public EmployeeViewHolder(View ItemView) {
            super(ItemView);
            empName = (TextView) ItemView.findViewById(R.id.tvEmployee);
            empDesignation = (TextView) ItemView.findViewById(R.id.tvDesignation);
            empGender = (TextView) ItemView.findViewById(R.id.tvGender);
            empYear = (TextView) ItemView.findViewById(R.id.tvJoiningYear);

            divider=(View) ItemView.findViewById(R.id.divider);

        }
    }

    @Override
    public void onBindViewHolder(EmployeeViewHolder holder, int position) {
        Employee emp = employees.get(position);
        holder.empName.setText(emp.getName());
        holder.empDesignation.setText(emp.getDesignation());
        holder.empGender.setText(emp.getGender());
        holder.empYear.setText(emp.getYear());

        if(position+1==getItemCount()) //check if this is the last child, if yes then hide the divider
            holder.divider.setVisibility(View.GONE);
    }

    @Override
    public int getItemCount() {
        return employees.size();
    }
}
