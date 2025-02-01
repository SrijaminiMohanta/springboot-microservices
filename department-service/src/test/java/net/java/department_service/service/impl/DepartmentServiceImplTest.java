package net.java.department_service.service.impl;

import net.java.department_service.dto.DepartmentDto;
import net.java.department_service.entity.Department;
import net.java.department_service.repository.DepartmentRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class DepartmentServiceImplTest {

    @Mock
    DepartmentRepository departmentRepository;

    @InjectMocks
    DepartmentServiceImpl departmentServiceImpl;

    private Department department;
    private DepartmentDto departmentDto;

    @BeforeEach
    void setUp() {
        departmentDto =new DepartmentDto(1L, "HR","2" ,"Human Resources");
        department = new Department(1L, "HR","2", "Human Resources");
    }

    @Test
    void saveDepartmentShouldAddSuccessfully(){
//        Mockito.when(departmentRepository.save(department)).thenReturn(department);
        when(departmentRepository.save(Mockito.any(Department.class))).thenReturn(department);

        DepartmentDto addedDepartmentDto =departmentServiceImpl.saveDepartment(departmentDto);

        assertNotNull(addedDepartmentDto);
        assertEquals(departmentDto.getId(),addedDepartmentDto.getId());
        assertTrue(addedDepartmentDto.getId()==1);
    }

    @Test
    void getDepartmentByCodeShouldSuccessfully(){
        when(departmentRepository.findByDepartmentCode(Mockito.anyString())).thenReturn(department);

        DepartmentDto addedDepartmentDto =departmentServiceImpl.getDepartmentByCode(Mockito.anyString());

        assertNotNull(addedDepartmentDto);
        assertEquals(departmentDto.getId(),addedDepartmentDto.getId());
        assertTrue(addedDepartmentDto.getId()==1);
    }



}