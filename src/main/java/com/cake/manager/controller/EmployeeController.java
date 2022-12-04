package com.cake.manager.controller;

import com.cake.manager.exception.EmployeeDataNotFoundException;
import com.cake.manager.exception.EmployeeInsertionFailureException;
import com.cake.manager.model.EmployeeModel;
import com.cake.manager.service.EmployeeService;
import com.cake.manager.util.ApiResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("employee")
@AllArgsConstructor
public class EmployeeController {

    EmployeeService service;

    @GetMapping("getAll")
    public ResponseEntity<ApiResponse<List<EmployeeModel>>> getAllEmployees() throws EmployeeDataNotFoundException {
      List<EmployeeModel> employees = service.getAllEmployees();
      ApiResponse<List<EmployeeModel>> response = ApiResponse.<List<EmployeeModel>>builder().resultDesc("Success").results(employees).build();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("create")
    public ResponseEntity<ApiResponse<EmployeeModel>> createEmployee(@RequestBody EmployeeModel dto) throws EmployeeInsertionFailureException{

                EmployeeModel employee = service.createEmployee(dto);
                ApiResponse<EmployeeModel> response = ApiResponse.<EmployeeModel>builder().resultDesc("Success").results(employee).build();
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }


}
