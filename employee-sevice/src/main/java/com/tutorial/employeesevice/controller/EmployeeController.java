package com.tutorial.employeesevice.controller;


import com.tutorial.employeesevice.dto.APIResponseDTO;
import com.tutorial.employeesevice.dto.EmployeeDTO;
import com.tutorial.employeesevice.entity.Employee;
import com.tutorial.employeesevice.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService){
        this.employeeService = employeeService;
    }

    //Employee REST API POST Employee
    @PostMapping("create")
    public ResponseEntity<EmployeeDTO> createEmployee (@RequestBody EmployeeDTO employeeDTO) {
        EmployeeDTO employeeDTO1 = this.employeeService.createEmployee(employeeDTO);

        return new ResponseEntity<>(employeeDTO1, HttpStatus.CREATED);
    }

    //Employee REST API Get Employee By ID
    @GetMapping("{employee-id}")
    public ResponseEntity<APIResponseDTO> getEmployeeById(@PathVariable(name = "employee-id") Long employeeID) {
        APIResponseDTO apiResponseDTO = this.employeeService.getEmployeeById(employeeID);
        return new ResponseEntity<>(apiResponseDTO, HttpStatus.OK);
    }
}
