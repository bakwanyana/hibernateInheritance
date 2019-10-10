package com.modjadji.domain;

import java.util.List;

public class Employee extends Person{

    private double salary;

    public Employee(String idNumber, List<String> names, String surname, double salary) {
        super(idNumber, names, surname);
        setSalary(salary);
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
