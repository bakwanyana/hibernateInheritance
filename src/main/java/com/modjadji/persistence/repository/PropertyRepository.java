package com.modjadji.persistence.repository;

import com.modjadji.domain.Property;
import org.springframework.data.repository.CrudRepository;

public interface PropertyRepository extends CrudRepository <Property, Long> {
}
