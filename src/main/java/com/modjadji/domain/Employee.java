package com.modjadji.domain;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("employee")
public class Employee extends Person{

    private double salary;

    public Employee() {
        super();
    }

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
