package net.java.employee_service.service.impl;

import net.java.employee_service.dto.APIResponseDto;
import net.java.employee_service.dto.DepartmentDto;
import net.java.employee_service.dto.EmployeeDto;
import net.java.employee_service.entity.Employee;
import net.java.employee_service.mapper.EmpMapper;
import net.java.employee_service.repository.EmployeeRepository;
import net.java.employee_service.service.APIClient;
import net.java.employee_service.service.EmployeeService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;
    @Autowired
    private ModelMapper modelMapper;

//    @Autowired
//    private RestTemplate restTemplate;
//    @Autowired
//    private WebClient webClient;
    @Autowired
    private APIClient apiClient;

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
    public APIResponseDto getEmployeeById(Long employeeId) {
         Employee employee = employeeRepository.findById(employeeId).orElseThrow(() -> new RuntimeException("employee not there"));
        //RESTTemplate
//        ResponseEntity<DepartmentDto> responseEntity = restTemplate.getForEntity("http://localhost:8080/api/departments/" + employee.getDepartmentCode(),
//        DepartmentDto.class);
//
//        DepartmentDto departmentDto = responseEntity.getBody();
        //WebClient
//        DepartmentDto departmentDto = webClient.get()
//                .uri("http://localhost:8080/api/departments/" + employee.getDepartmentCode())
//                .retrieve()
//                .bodyToMono(DepartmentDto.class)
//                .block();
        //OpenFeign
        DepartmentDto departmentDto = apiClient.getDepartment(employee.getDepartmentCode());

//        EmployeeDto employeeDto = EmployeeMapper.mapToEmployeeDto(employeeRepository.findById(employeeId).orElseThrow(() -> new RuntimeException("employee not there")));
//        EmployeeDto employeeDto = modelMapper.map(employeeRepository.findById(employeeId).orElseThrow(() -> new RuntimeException("employee not there")), EmployeeDto.class);
        EmployeeDto employeeDto = EmpMapper.MAPPER.mapToEmployeeDto(employee);
        APIResponseDto apiResponseDto = new APIResponseDto();
        apiResponseDto.setEmployeeDto(employeeDto);
        apiResponseDto.setDepartmentDto(departmentDto);
        return apiResponseDto;
    }
}
