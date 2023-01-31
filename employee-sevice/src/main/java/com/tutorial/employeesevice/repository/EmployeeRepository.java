package com.tutorial.employeesevice.repository;

import com.tutorial.employeesevice.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
