package net.java.employee_service.service.impl;

import net.java.employee_service.dto.APIResponseDto;
import net.java.employee_service.dto.EmployeeDto;
import net.java.employee_service.entity.Employee;
import net.java.employee_service.repository.EmployeeRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class EmployeeServiceImplTest {
    @Mock
    EmployeeRepository employeeRepository;

    @InjectMocks
    EmployeeServiceImpl employeeService;

    private EmployeeDto employeeDto;
    private Employee employee;

    @BeforeEach
    void setUp(){
        employeeDto = new EmployeeDto(1L,"Srija", "mini", "Srija123@gmail.com", "123");
        employee = new Employee(1L,"Srija", "mini", "Srija123@gmail.com", "123");
    }

    @Test
    void saveEmployeeSuccessfully() {
        when(employeeRepository.save(Mockito.any(Employee.class))).thenReturn(employee);
        EmployeeDto addedEmployeeDto =employeeService.saveEmployee(employeeDto);
        assertNotNull(addedEmployeeDto);
        assertEquals(addedEmployeeDto.getId(), employeeDto.getId());
    }

    @Test
    void getEmployeeByIdSuccessfully() {
        when(employeeRepository.findById(Mockito.anyLong())).thenReturn(Optional.ofNullable(employee));
        APIResponseDto apiResponseDto = employeeService.getEmployeeById(Long.valueOf(Mockito.anyString()));
        assertNotNull(apiResponseDto);
    }
}