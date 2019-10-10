package com.modjadji.domain;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private String idNumber;
    private List<String> names;
    private String surname;

    public Person(String idNumber, List<String> names, String surname) {
        this.idNumber = idNumber;
        this.names = names;
        this.surname = surname;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public List<String> getNames() {
        return names;
    }

    public void addName(String name) {
        try {
            this.names.add(name);
        } catch (NullPointerException e){
            this.names = new ArrayList<String>();
            this.names.add(name);
        }
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
}
