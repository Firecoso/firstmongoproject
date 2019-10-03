package org.app.services;

import org.app.models.Employee;
import org.app.models.EmployeeDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.ZoneId;
import java.util.Date;

@Service
public class EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;

    public EmployeeDTO save(EmployeeDTO employeeDTO){
        Employee employee= new Employee();

        employee.setCode(employeeDTO.getCode());
        employee.setFullName(employeeDTO.getFullname());
        employee.setStartDate(Date.from(employeeDTO.getStartDate().atStartOfDay(ZoneId.of("Europe/Rome")).toInstant()));
        /*Date data = Date.from(employeeDTO.getStartDate().atStartOfDay(ZoneId.of("Europe/Rome")).toInstant());
        System.out.println(data);*/
        //employee.setStartDate(new Date());
        employeeRepository.save(employee);
        return new EmployeeDTO(employee);
    }
}
