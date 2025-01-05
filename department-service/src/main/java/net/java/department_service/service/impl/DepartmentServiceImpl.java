package net.java.department_service.service.impl;

import net.java.department_service.dto.DepartmentDto;
import net.java.department_service.entity.Department;
import net.java.department_service.mapper.DepartmentMapper;
import net.java.department_service.repository.DepartmentRepository;
import net.java.department_service.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    @Autowired
    private DepartmentRepository departmentRepository;

    public DepartmentDto saveDepartment(DepartmentDto departmentDto){
        Department department = DepartmentMapper.mapToDepartment(departmentDto);
        Department savedDepartment = departmentRepository.save(department);
        DepartmentDto savedDepartmentDto = DepartmentMapper.mapToDepartmentDto(savedDepartment);
        return savedDepartmentDto;
    }

    public DepartmentDto getDepartmentByCode(String departmentCode){
        Department department = departmentRepository.findByDepartmentCode(departmentCode);
        DepartmentDto departmentDto = DepartmentMapper.mapToDepartmentDto(department);
        return departmentDto;
    }
}
