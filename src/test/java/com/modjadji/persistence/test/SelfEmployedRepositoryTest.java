package com.modjadji.persistence.test;

import com.modjadji.domain.Employee;
import com.modjadji.domain.SelfEmployed;
import com.modjadji.persistence.repository.SelfEmployedRepository;
import org.junit.Test;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class SelfEmployedRepositoryTest extends PersistenceTestBase implements ApplicationContextAware {

    @Autowired
    private SelfEmployedRepository selfEmployedRepository;
    private ApplicationContext applicationContext;

    @Test
    public void testThatContextLoads(){
        assertNotNull(applicationContext);
    }

    @Test
    public void testThatEmployeeRepositoryCanPersist(){
        SelfEmployed employee = new SelfEmployed("100101","Joe","Soap",10);

        selfEmployedRepository.save(employee);

        assertEquals(1, selfEmployedRepository.count());
        assertEquals(employee.getName() + " " + employee.getSurname(), selfEmployedRepository.getFullName("100101"));
    }

    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

}
