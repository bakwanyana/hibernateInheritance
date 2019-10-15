package com.modjadji.persistence.repository;

import com.modjadji.domain.Property;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface PropertyRepository extends CrudRepository <Property, Long> {
    @Query("SELECT CONCAT(u.line1, ',', u.line2,',',u.areaCode) FROM Property u WHERE u.id = :id")
    String getFullAddress(@Param("id") Long propertyId);
}
