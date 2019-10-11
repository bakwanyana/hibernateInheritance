package com.modjadji.persistence.repository;

import com.modjadji.domain.Employee;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository extends CrudRepository <Employee, String> {
}
