package com.bridgelabz.employeepayrollapp.dto;

import lombok.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
public class EmployeePayrollDTO {
    //Create a variable to store id,name,and salary to store
    private Long id;
    private String name;
    private int salary;
}
