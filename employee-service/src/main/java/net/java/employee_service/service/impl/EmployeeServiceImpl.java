package net.java.employee_service.service.impl;

import net.java.employee_service.EmployeeDto;
import net.java.employee_service.entity.Employee;
import net.java.employee_service.mapper.EmpMapper;
import net.java.employee_service.mapper.EmployeeMapper;
import net.java.employee_service.repository.EmployeeRepository;
import net.java.employee_service.service.EmployeeService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public EmployeeDto saveEmployee(EmployeeDto employeeDto) {
//        Employee employee = EmployeeMapper.mapToEmployee(employeeDto);
//        Employee employee = modelMapper.map(employeeDto, Employee.class);
        Employee employee = EmpMapper.MAPPER.mapToEmployee(employeeDto);
        Employee savedEmployee = employeeRepository.save(employee);
//        EmployeeDto savedEmployeeDto = EmployeeMapper.mapToEmployeeDto(savedEmployee);
//        EmployeeDto savedEmployeeDto = modelMapper.map(savedEmployee, EmployeeDto.class);
        EmployeeDto savedEmployeeDto = EmpMapper.MAPPER.mapToEmployeeDto(savedEmployee);
        return savedEmployeeDto;
    }

    @Override
    public EmployeeDto getEmployeeById(Long employeeId) {
//        EmployeeDto employeeDto = EmployeeMapper.mapToEmployeeDto(employeeRepository.findById(employeeId).orElseThrow(() -> new RuntimeException("employee not there")));
//        EmployeeDto employeeDto = modelMapper.map(employeeRepository.findById(employeeId).orElseThrow(() -> new RuntimeException("employee not there")), EmployeeDto.class);
        EmployeeDto employeeDto = EmpMapper.MAPPER.mapToEmployeeDto(employeeRepository.findById(employeeId).orElseThrow(() -> new RuntimeException("employee not there")));
        return employeeDto;
    }
}
