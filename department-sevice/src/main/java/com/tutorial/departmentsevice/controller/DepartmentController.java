package com.tutorial.departmentsevice.controller;

import com.tutorial.departmentsevice.dto.DepartmentDTO;
import com.tutorial.departmentsevice.service.DepartmentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/department")
public class DepartmentController {

    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    //department REST API create Department - POST
    @PostMapping("create")
    public ResponseEntity<DepartmentDTO> createDepartment (@RequestBody @Validated DepartmentDTO departmentDTO) {
        DepartmentDTO saveDepartment =  this.departmentService.saveDepartment(departmentDTO);
        return new ResponseEntity<>(saveDepartment, HttpStatus.CREATED);
    }

    //Department REST API get by Code
    @GetMapping("{code}")
    public ResponseEntity<DepartmentDTO> getDepartmentByCode(@PathVariable(name = "code") String departmentCode) {
        return new ResponseEntity<>(
                this.departmentService.getDepartmentByCode(departmentCode),
                HttpStatus.OK);
    }

}
