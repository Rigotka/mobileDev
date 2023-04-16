package com.example.list_employees.model;

public class Employee {
    private String _name;
    private String _surname;
    private String _position;

    public Employee(String name, String surname,String position) {
        setName(name);
        setSurname(surname);
        setPosition(position);
    }

    public void setName(String name){
        _name = name;
    }
    public void setSurname(String surname){
        _surname = surname;
    }
    public void setPosition(String position){
        _position = position;
    }

    public String getName(){
        return _name;
    }
    public String getSurname() {
        return _surname;
    }
    public String getPosition(){
        return _position;
    }

    public String toString(){
        return getName() + " " + getSurname();
    }
}
