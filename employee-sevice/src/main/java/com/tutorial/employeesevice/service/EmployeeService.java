package com.tutorial.employeesevice.service;

import com.tutorial.employeesevice.dto.APIResponseDTO;
import com.tutorial.employeesevice.dto.DepartmentDTO;
import com.tutorial.employeesevice.dto.EmployeeDTO;
import com.tutorial.employeesevice.entity.Employee;
import com.tutorial.employeesevice.repository.EmployeeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final ModelMapper modelMapper;

    private final RestTemplate restTemplate;

    private final WebClient webClient;

    private APIClient apiClient;

    public EmployeeService(EmployeeRepository employeeRepository,
                           RestTemplate restTemplate,
                           WebClient webClient,
                           APIClient apiClient) {
        this.employeeRepository = employeeRepository;
        this.modelMapper = new ModelMapper();
        this.restTemplate = restTemplate;
        this.webClient = webClient;
        this.apiClient = apiClient;
    }

    public EmployeeDTO createEmployee(EmployeeDTO employeeDTO) {
        Employee employee = this.employeeRepository.save(modelMapper.map(employeeDTO, Employee.class));
        return this.modelMapper.map(employee, EmployeeDTO.class);
    }

    public APIResponseDTO getEmployeeById(Long id) {

        Employee employee = this.employeeRepository.findById(id).get();

//        ResponseEntity<DepartmentDTO> responseEntity =  this.restTemplate.getForEntity("http://localhost:8080/api/department/" + employee.getDepartmentCode()
//                , DepartmentDTO.class);
//        DepartmentDTO departmentDTO = responseEntity.getBody();


//        DepartmentDTO departmentDTO = this.webClient.get()
//                .uri("http://localhost:8080/api/department/" + employee.getDepartmentCode())
//                .retrieve()
//                .bodyToMono(DepartmentDTO.class)
//                .block();

        DepartmentDTO departmentDTO = this.apiClient.getDepartmentByCode(employee.getDepartmentCode());

        EmployeeDTO employeeDTO = this.modelMapper.map(employee, EmployeeDTO.class);

        APIResponseDTO apiResponseDTO = new APIResponseDTO(employeeDTO, departmentDTO);

        return apiResponseDTO;
    }


}
