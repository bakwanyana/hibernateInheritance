package com.modjadji.persistence.test;

import com.modjadji.domain.Employee;
import com.modjadji.persistence.repository.EmployeeRepository;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import static org.junit.Assert.*;

public class EmployeeRepositoryTest extends PersistenceTestBase {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Test
    public void testThatEmployeeRepositoryCanPersist(){
        Employee employee = new Employee("100101","Joe","Soap",10.00);

        employeeRepository.save(employee);

        assertEquals(1, employeeRepository.count());
    }
}
