package com.example.list_employees;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;

import com.example.list_employees.model.Employee;
import com.example.list_employees.model.EmployeeAdapter;

public class MainActivity extends AppCompatActivity {

    private final EmployeeAdapter _adapter = new EmployeeAdapter();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(_adapter);
    }

    public void onMyButtonClick(View view)
    {
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
}