package com.modjadji.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Person implements Serializable {

    @Id
    @Column(nullable = false, updatable = false, unique = true)
    private String idNumber;

    @Column
    private String name;

    @Column
    private String surname;

    @ManyToMany(mappedBy = "propertyOwners", fetch = FetchType.EAGER)
    private Set<Property> properties;

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

    public Set<Property> getProperties() {
        return properties;
    }

    public void addProperty(Property property){
        if (property == null)
            return;
        initializeProperties();
        this.properties.add(property);
    }

    public void removeProperty(Property property){
        this.properties.remove(property);
    }

    private void initializeProperties(){
        if (this.properties == null)
            this.properties = new HashSet<Property>();
    }

    @Override
    public String toString() {
        return "Person{" +
                "idNumber='" + idNumber + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                '}';
    }
}
