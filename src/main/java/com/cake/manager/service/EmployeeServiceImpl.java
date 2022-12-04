package com.cake.manager.service;

import com.cake.manager.entity.Employee;
import com.cake.manager.exception.EmployeeDataNotFoundException;
import com.cake.manager.exception.EmployeeInsertionFailureException;
import com.cake.manager.model.EmployeeModel;
import com.cake.manager.repository.EmployeeRepository;
import com.cake.manager.util.ObjectConverter;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService{

    EmployeeRepository employeeRepository;

    @Override
    public List<EmployeeModel> getAllEmployees() throws EmployeeDataNotFoundException {
        List<EmployeeModel> employees = new ArrayList<EmployeeModel>();
        List<Employee> emps = employeeRepository.findAll();
        if(!emps.isEmpty()){
           employees= emps.stream().map(x -> ObjectConverter.convertToEmployeeDto(x)).collect(Collectors.toList());
           return employees;
        }else{
            throw new EmployeeDataNotFoundException("No Data Found");
        }
    }

    @Override
    public EmployeeModel createEmployee(EmployeeModel dto) throws EmployeeInsertionFailureException {
        return ObjectConverter.convertToEmployeeDto(employeeRepository.save(ObjectConverter.convertToEmployee(dto)));
    }
}
