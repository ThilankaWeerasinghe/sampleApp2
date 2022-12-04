package com.cake.manager.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EmployeeModel {
    private Integer id;
    private String email;
    private String firstName;
    private String lastName;
}
