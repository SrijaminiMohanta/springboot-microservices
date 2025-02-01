package net.java.department_service.service;

import net.java.department_service.dto.DepartmentDto;
import net.java.department_service.entity.Department;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

@ExtendWith(MockitoExtension.class)
public class DepartmentServiceTest {
    @Mock
    DepartmentService departmentService;

    @Test
    void saveDepartmentShouldAddSuccessfully(){
        System.out.println("My first Test");
        DepartmentDto departmentDto = new DepartmentDto();
        departmentService.saveDepartment(departmentDto);
    }
}
