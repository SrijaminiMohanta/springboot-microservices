package net.java.employee_service.mapper;

import net.java.employee_service.dto.EmployeeDto;
import net.java.employee_service.entity.Employee;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
@Mapper
public interface EmpMapper {
    EmpMapper MAPPER = Mappers.getMapper(EmpMapper.class);

        //    if there are  some field not match user @mapping annotation
//    @Mapping(source = "email" ,target ="emailAddress")
        EmployeeDto mapToEmployeeDto(Employee employee);

        Employee mapToEmployee(EmployeeDto employeeDto);
}
