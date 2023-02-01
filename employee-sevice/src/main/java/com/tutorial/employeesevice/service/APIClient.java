package com.tutorial.employeesevice.service;


import com.tutorial.employeesevice.dto.DepartmentDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(url = "http://localhost:8080", name = "DEPARTMENT-SERVICE")
public interface APIClient {

    //Department REST API get call
    @GetMapping("/api/department/{code}")
    public DepartmentDTO getDepartmentByCode(@PathVariable(name = "code") String departmentCode);
}
