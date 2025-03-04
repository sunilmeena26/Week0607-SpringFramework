package com.bridgelabz.employeepayrollapp.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
//Create a class EmployeePayrollController to define employee details
@Entity
@Data
@Table(name="Employee")
public class Employee {

    //Create a private variable id,name,salary, role, and password to define details employee details
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String password;
    private String employeeName;
    private String employeeRole;
    private int employeeSalary;

}
