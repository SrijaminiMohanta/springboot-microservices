package net.java.department_service.service;

import net.java.department_service.dto.DepartmentDto;


public interface DepartmentService {
    DepartmentDto saveDepartment(DepartmentDto departmentDto);

    DepartmentDto getDepartmentByCode(String departmentCode);
}
