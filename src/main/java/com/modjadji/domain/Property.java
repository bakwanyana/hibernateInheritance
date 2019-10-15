package com.modjadji.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Property {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String line1;
    private String line2;
    private String areaCode;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "property_ownership",
    joinColumns = @JoinColumn(name = "property_id", referencedColumnName = "id"),
    inverseJoinColumns = @JoinColumn(name = "person_idNumber", referencedColumnName = "idNumber"))
    private Set<Person> propertyOwners;

    public Property() {
    }

    public Property(String line1, String line2, String areaCode) {
        this.line1 = line1;
        this.line2 = line2;
        this.areaCode = areaCode;
    }

    public String getLine1() {
        return line1;
    }

    public void setLine1(String line1) {
        this.line1 = line1;
    }

    public String getLine2() {
        return line2;
    }

    public void setLine2(String line2) {
        this.line2 = line2;
    }

    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }

    public void addPropertyOwner(Person person){
        if (person == null)
            return;
        initializePropertyOwners();
        propertyOwners.add(person);
    }

    public void removePropertyOwner(Person person){
        propertyOwners.remove(person);
    }

    private void initializePropertyOwners(){
        if (propertyOwners == null){
            propertyOwners = new HashSet<Person>();
        }
    }

    public Set<Person> getPropertyOwners() {
        return propertyOwners;
    }

    public Long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Property{" +
                "id=" + id +
                ", line1='" + line1 + '\'' +
                ", line2='" + line2 + '\'' +
                ", areaCode='" + areaCode + '\'' +
                ", propertyOwners=" + propertyOwners +
                '}';
    }
}
