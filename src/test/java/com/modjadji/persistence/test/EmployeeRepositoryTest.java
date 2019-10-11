package com.modjadji.persistence.test;

import com.modjadji.domain.Employee;
import com.modjadji.persistence.repository.EmployeeRepository;
import org.junit.Test;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import static org.junit.Assert.*;
public class EmployeeRepositoryTest extends PersistenceTestBase implements ApplicationContextAware {

    @Autowired
    private EmployeeRepository employeeRepository;
    private ApplicationContext applicationContext;

    @Test
    public void testThatContextLoads(){
        assertNotNull(applicationContext);
    }

    @Test
    public void testThatEmployeeRepositoryCanPersist(){
        Employee employee = new Employee("100101","Joe","Soap",10.00);

        employeeRepository.save(employee);

        assertEquals(1, employeeRepository.count());
    }

    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
