package org.app.services;

import org.app.exceptions.EmployeeServiceCannotBeNull;
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

    public Employee save(EmployeeDTO employeeDTO) throws EmployeeServiceCannotBeNull{
        if(employeeDTO==null){
            throw new EmployeeServiceCannotBeNull();
        }
        Employee employee= new Employee();

        employee.setCode(employeeDTO.getCode());
        employee.setFullName(employeeDTO.getFullname());
        employee.setStartDate(Date.from(employeeDTO.getStartDate().atStartOfDay(ZoneId.of("Europe/Rome")).toInstant()));
        /*Date data = Date.from(employeeDTO.getStartDate().atStartOfDay(ZoneId.of("Europe/Rome")).toInstant());
        System.out.println(data);*/
        //employee.setStartDate(new Date());
        return employeeRepository.insert(employee);
    }
}
