package com.modjadji.persistence.test;

import com.modjadji.domain.SelfEmployed;
import com.modjadji.persistence.repository.SelfEmployedRepository;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;

public class SelfEmployedRepositoryTest extends PersistenceTestBase {

    @Autowired
    private SelfEmployedRepository selfEmployedRepository;

    @Test
    public void testThatEmployeeRepositoryCanPersist(){
        SelfEmployed employee = new SelfEmployed("100101","Joe","Soap",10);

        SelfEmployed persistedSelfEmployee = selfEmployedRepository.save(employee);

        assertEquals(1, selfEmployedRepository.count());
        assertTrue((employee.getName() + " " + employee.getSurname()).equalsIgnoreCase(selfEmployedRepository.getFullName("100101")));
    }
}
