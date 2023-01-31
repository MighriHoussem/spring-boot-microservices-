package com.tutorial.departmentsevice.service;

import com.tutorial.departmentsevice.dto.DepartmentDTO;
import com.tutorial.departmentsevice.entity.Department;
import com.tutorial.departmentsevice.repository.DepartmentRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;


@Service
public class DepartmentService {
    private final DepartmentRepository departmentRepository;
    private final ModelMapper modelMapper;

    public DepartmentService(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
        this.modelMapper = new ModelMapper();
    }

    public DepartmentDTO saveDepartment (DepartmentDTO departmentDTO) {
        Department departmentSaved = this.departmentRepository.save(this.modelMapper.map(departmentDTO, Department.class));
        return this.modelMapper.map(departmentSaved, DepartmentDTO.class);
    }

    public DepartmentDTO getDepartmentByCode(String code) {
        Department department = this.departmentRepository.findDepartmentByDepartmentCode(code);
        System.out.println("Department GET: " + department.getDepartmentName());
        DepartmentDTO departmentDTO = this.modelMapper.map(department, DepartmentDTO.class);
        return departmentDTO;
    }

}
