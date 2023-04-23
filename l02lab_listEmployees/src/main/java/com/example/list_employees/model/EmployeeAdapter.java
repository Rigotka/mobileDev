package com.example.list_employees.model;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import com.example.list_employees.R;

import java.util.ArrayList;
import java.util.List;

public class EmployeeAdapter extends RecyclerView.Adapter<EmployeeAdapter.ViewHolder> implements View.OnClickListener{

    private List<Employee> _employees = new ArrayList<>() ;

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.employee_card, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Employee employee = _employees.get(position);
        holder.name.setText(employee.toString());
        holder.position.setText(employee.getPosition());

        holder.itemView.setTag(employee);
        holder.deleteButton.setTag(employee);

        holder.itemView.setOnClickListener(this);
        holder.deleteButton.setOnClickListener(this);
    }

    @Override
    public int getItemCount() {
        return _employees.size();
    }

    public void addEmployee(Employee employee){
        _employees.add(employee);
        notifyDataSetChanged();
    }

    @Override
    public void onClick(View view) {
        Employee employee = (Employee) view.getTag();
        int position = view.getId();
        if(position == R.id.deleteButton){
            _employees.remove(employee);
            notifyDataSetChanged();
        }
        else{
            Toast.makeText(view.getContext(), employee.toString(), Toast.LENGTH_SHORT).show();
        }
    }

    public List<Employee> getEmployees(){
        return _employees;
    }

    public void setEmployees(List<Employee> employees){
        _employees = employees;
        notifyDataSetChanged();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        public TextView name;
        public TextView position;
        public ImageView deleteButton;
        ViewHolder(View view){
            super(view);
            name = view.findViewById(R.id.employeeNameTextView);
            position = view.findViewById(R.id.employeePositionTextView);
            deleteButton = view.findViewById(R.id.deleteButton);
        }
    }
}
