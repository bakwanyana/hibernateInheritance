package com.modjadji.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

public class Person implements Serializable {
    private String idNumber;
    private String name;
    private String surname;

    public Person() {
    }

    public Person(String idNumber, String name, String surname) {
        this.idNumber = idNumber;
        this.name = name;
        this.surname = surname;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
}
