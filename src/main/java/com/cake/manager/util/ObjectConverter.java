package com.cake.manager.util;

import com.cake.manager.entity.Employee;
import com.cake.manager.model.EmployeeModel;

public class ObjectConverter {

    public static EmployeeModel convertToEmployeeDto (Employee employee){
        EmployeeModel employeeModel = new EmployeeModel();
        employeeModel.setId(employee.getId());
        employeeModel.setFirstName(employee.getFirstName());
        employeeModel.setLastName(employee.getLastName());
        employeeModel.setEmail(employee.getEmail());
        return employeeModel;
    }

    public static Employee convertToEmployee(EmployeeModel employeeModel){
        Employee employee = new Employee();
        employee.setId(employeeModel.getId());
        employee.setFirstName(employeeModel.getFirstName());
        employee.setLastName(employeeModel.getLastName());
        employee.setEmail(employeeModel.getEmail());
        return employee;
    }


}
