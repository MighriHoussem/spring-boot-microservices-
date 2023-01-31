package com.tutorial.departmentsevice.repository;

import com.tutorial.departmentsevice.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Long> {

    public Department findDepartmentByDepartmentCode(String departmentCode);
}
