package com.tutorial.employeesevice.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class APIResponseDTO {

    private EmployeeDTO employeeDTO;
    private DepartmentDTO departmentDTO;
}
