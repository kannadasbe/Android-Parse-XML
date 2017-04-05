package com.example.kannadasang.recyclerview;

/**
 * Created by KannadasanG on 7/26/2016.
 */
public class Employee {
    String Name,Designation,Gender,Year;

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getDesignation() {
        return Designation;
    }

    public void setDesignation(String designation) {
        Designation = designation;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String gender) {
        Gender = gender;
    }

    public String getYear() {
        return Year;
    }

    public void setYear(String year) {
        Year = year;
    }
    public Employee(){}
    public Employee(String name, String designation, String gender, String year) {
        Name = name;
        Designation = designation;
        Gender = gender;
        Year = year;
    }
}
