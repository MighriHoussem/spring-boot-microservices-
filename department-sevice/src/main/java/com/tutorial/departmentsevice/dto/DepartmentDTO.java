package com.tutorial.departmentsevice.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentDTO {
    private Long id;

    @NotEmpty(message = "Department name should not be empty!")
    private String departmentName;
    private String departmentDescription;

    @NotEmpty(message = "Department code should not be empty")
    @NotNull
    private String departmentCode;
}
