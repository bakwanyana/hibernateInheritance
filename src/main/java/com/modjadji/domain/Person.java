package com.modjadji.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;

@MappedSuperclass
public abstract class Person implements Serializable {

    @Id
    @Column(nullable = false, updatable = false, unique = true)
    private String idNumber;

    @Column
    private String name;

    @Column
    private String surname;

    private static int count = 0;

    public Person() {
        this(String.valueOf(count), "John", "Doe");
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
