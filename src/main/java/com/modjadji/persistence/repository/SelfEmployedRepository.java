package com.modjadji.persistence.repository;

import com.modjadji.domain.SelfEmployed;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface SelfEmployedRepository extends CrudRepository <SelfEmployed, String> {

    @Query("SELECT CONCAT(u.name, ' ', u.surname) FROM SelfEmployed u WHERE u.id = :id")
    String getFullName(@Param("id") String id);
}
