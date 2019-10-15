package com.modjadji.persistence.test;

import com.modjadji.domain.Property;
import com.modjadji.persistence.repository.PropertyRepository;
import org.junit.Test;
import static org.junit.Assert.*;
import org.springframework.beans.factory.annotation.Autowired;

public class PropertyRepositoryTest extends PersistenceTestBase {

    @Autowired
    private PropertyRepository addressRepository;

    @Test
    public void testThatAddressRepositoryCanPersist(){
        Property address = new Property("line1", "line2", "90210");
        addressRepository.save(address);

        assertEquals(1, addressRepository.count());
    }
}
