package com.modjadji.persistence.test;

import com.modjadji.domain.Employee;
import com.modjadji.domain.Property;
import com.modjadji.persistence.repository.PropertyRepository;
import com.modjadji.persistence.repository.EmployeeRepository;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import static org.junit.Assert.*;

public class PropertyOwnershipTest extends PersistenceTestBase {

    @Autowired
    private PropertyRepository propertyRepository;
    @Autowired
    private EmployeeRepository employeeRepository;

    @Test
    public void test(){
        Employee chenLi = new Employee("10/10/2001/98981", "Li", "Chen", 10.00);
        Property property = new Property("line1", "line2", "90210");
        chenLi.addProperty(property);
        property.addPropertyOwner(chenLi);

        Employee persistedEmployee = employeeRepository.save(chenLi);
        Property persistedProperty = propertyRepository.save(property);


        assertNotNull(persistedEmployee);
        assertNotNull(persistedProperty);
        assertEquals(1, employeeRepository.count());
        assertEquals(1, propertyRepository.count());

        Employee retrievedEmployee = employeeRepository.findOne(persistedEmployee.getIdNumber());
        Property retrievedProperty = propertyRepository.findOne(persistedProperty.getId());

        assertEquals(1, retrievedProperty.getPropertyOwners().size());
        assertEquals(1, retrievedEmployee.getProperties().size());
    }
}
