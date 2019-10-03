package org.app.services;

import org.app.exceptions.EmployeeServiceCannotBeNull;
import org.app.models.Employee;
import org.app.models.EmployeeDTO;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.time.LocalDate;
import java.util.Date;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class EmployeeServiceTest {

    @Mock
    private EmployeeRepository employeeRepository;

    @InjectMocks
    private EmployeeService employeeService;

    @Test
    public void shouldReturnSameEmployee() throws EmployeeServiceCannotBeNull {
        EmployeeDTO employeeDTO= new EmployeeDTO();
        employeeDTO.setCode("12");
        employeeDTO.setFullname("pippo");
        employeeDTO.setStartDate(LocalDate.now());

        Employee employee= new Employee();
        employee.setCode("12");
        employee.setFullName("pippo");
        employee.setStartDate(new Date());

        when(employeeRepository.insert(employee)).thenReturn(employee);
        employeeService.save(employeeDTO);
        Assert.assertEquals(employee.getCode(),employeeDTO.getCode());
        Assert.assertEquals(employee.getFullName(),employeeDTO.getFullname());
    }


    @Test(expected = EmployeeServiceCannotBeNull.class)
    public void saveShouldAcceptNull() throws EmployeeServiceCannotBeNull{
        employeeService.save(null);
    }

}