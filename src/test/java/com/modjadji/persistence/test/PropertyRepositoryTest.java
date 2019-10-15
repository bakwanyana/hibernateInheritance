package com.modjadji.persistence.test;

import com.modjadji.domain.Property;
import com.modjadji.persistence.repository.PropertyRepository;
import org.junit.Test;
import static org.junit.Assert.*;
import org.springframework.beans.factory.annotation.Autowired;

public class PropertyRepositoryTest extends PersistenceTestBase {

    @Autowired
    private PropertyRepository propertyRepository;

    @Test
    public void testThatAddressRepositoryCanPersist(){
        Property property = new Property("line1A", "line2A", "90210A");

        Property persistedProperty = propertyRepository.save(property);

        assertTrue(property.getFullAddress().equals(propertyRepository.getFullAddress(persistedProperty.getId())));
    }
}
