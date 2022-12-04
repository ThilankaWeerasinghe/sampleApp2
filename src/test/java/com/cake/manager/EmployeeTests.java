package com.cake.manager;

import com.cake.manager.controller.EmployeeController;
import com.cake.manager.entity.Employee;
import com.cake.manager.exception.EmployeeDataNotFoundException;
import com.cake.manager.model.EmployeeModel;
import com.cake.manager.repository.EmployeeRepository;
import com.cake.manager.service.EmployeeService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class EmployeeTests {

    private MockMvc mockMvc;
    @Mock
    private EmployeeService service;

    @InjectMocks
    private EmployeeController employeeController;
//    @Mock
//    private EmployeeRepository repository;

    @BeforeEach
    public void setUp()  {
        MockitoAnnotations.openMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(service).build();
    }

    @Test
    void getUserTests() throws EmployeeDataNotFoundException {
        List<EmployeeModel> employees = new ArrayList<>(Arrays.asList(new EmployeeModel(1,"dfd","dfd","dfdfd")));
        Mockito.when(service.getAllEmployees()).thenReturn(employees);
      //Assertions.assertEquals(1,service.getAllEmployees().size());
    }

}
