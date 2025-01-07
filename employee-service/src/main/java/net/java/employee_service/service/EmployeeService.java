package net.java.employee_service.service;

import net.java.employee_service.dto.APIResponseDto;
import net.java.employee_service.dto.EmployeeDto;

public interface EmployeeService {
    EmployeeDto saveEmployee(EmployeeDto employeeDto);

    APIResponseDto getEmployeeById(Long employeeId);
}
