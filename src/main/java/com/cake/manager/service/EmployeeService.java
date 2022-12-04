package com.cake.manager.service;


import com.cake.manager.exception.EmployeeDataNotFoundException;
import com.cake.manager.exception.EmployeeInsertionFailureException;
import com.cake.manager.model.EmployeeModel;

import java.util.List;

public interface EmployeeService {

    public List<EmployeeModel> getAllEmployees() throws EmployeeDataNotFoundException;

    public EmployeeModel createEmployee(EmployeeModel dto) throws EmployeeInsertionFailureException;
}
