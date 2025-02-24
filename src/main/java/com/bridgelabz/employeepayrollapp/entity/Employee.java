package com.bridgelabz.employeepayrollapp.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

//Create a class EmployeePayrollController to define employee details
@Entity
public class Employee {

    //Create a private variable id,name,salary, and salary to define details employee details
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long employeeId;
    private String employeeName;
    private String employeeRole;
    private int employeeSalary;

    //Create a getter method to return id of employee
    public Long getEmployeeId() {
        return employeeId;
    }

    //Create a setter method to initialize id of employee
    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    //Create a getter method to return name of employee
    public String getEmployeeName() {
        return employeeName;
    }

    //Create a setter method to initialize name of employee
    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    //Create a getter method to return role of employee
    public String getEmployeeRole() {
        return employeeRole;
    }

    //Create a setter method to initialize role of employee
    public void setEmployeeRole(String employeeRole) {
        this.employeeRole = employeeRole;
    }

    //Create a getter method to return salary of employee
    public int getEmployeeSalary() {
        return employeeSalary;
    }

    //Create a setter method to initialize salary of employee
    public void setEmployeeSalary(int employeeSalary) {
        this.employeeSalary = employeeSalary;
    }
}
