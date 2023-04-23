package com.example.list_employees;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;

import com.example.list_employees.model.Employee;
import com.example.list_employees.model.EmployeeAdapter;
import com.example.list_employees.services.EmployeeSerializer;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private final EmployeeAdapter _adapter = new EmployeeAdapter();

    private final EmployeeSerializer _serializer = new EmployeeSerializer();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(_adapter);
    }

    public void addButtonClick(View view) {
        int indexName = (int) (Math.random() * 5);
        int indexSurname = (int) (Math.random() * 5);
        int indexPosition = (int) (Math.random() * 5);

        Resources res = getResources();
        String name = res.getStringArray(R.array.names)[indexName];
        String surname = res.getStringArray(R.array.surnames)[indexSurname];
        String position = res.getStringArray(R.array.positions)[indexPosition];

        Employee employee = new Employee(name, surname, position);
        _adapter.addEmployee(employee);
    }

    public void saveButtonClick(View view) {
        _serializer.saveToFile(_adapter.getEmployees(), view.getContext());
    }

    public void loadButtonClick(View view) {
       List<Employee> employees = _serializer.LoadFromFile(view.getContext());
       _adapter.setEmployees(employees);
    }
}