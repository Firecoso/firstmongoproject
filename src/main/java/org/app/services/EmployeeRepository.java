package org.app.services;

import org.app.models.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface EmployeeRepository extends MongoRepository<Employee,String> {

    /*Employee findByCode(String code);
    List<Employee> findByFullName(String fullName);
    List<Employee> findByStartDateGreaterThan (Date date);*/


}
