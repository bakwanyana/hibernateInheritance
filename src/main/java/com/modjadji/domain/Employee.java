package com.modjadji.domain;

import java.util.List;
import java.util.Set;

public class Employee extends Person{

    private double salary;

    public Employee(String idNumber, String name, String surname, double salary) {
        super(idNumber, name, surname);
        setSalary(salary);
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
