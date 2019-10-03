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

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class EmployeeServiceTest {

    @Mock
    private EmployeeRepository employeeRepository;

    @InjectMocks
    private EmployeeService employeeService;


    @Test(expected = EmployeeServiceCannotBeNull.class)
    public void saveShouldAcceptNull() throws EmployeeServiceCannotBeNull{
        employeeService.save(null);
    }

}