package com.bridgelabz.employeepayrollapp.controller;

import com.bridgelabz.employeepayrollapp.entity.Employee;
import com.bridgelabz.employeepayrollapp.service.EmployeePayrollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

//Create a Controller class to handle HTTP requests related to employee
@RestController
@RequestMapping("/employee")
public class EmployeePayrollController {

    //Create an instance of EmployeePayrollService It is automatically injects
    @Autowired
    private EmployeePayrollService employeePayrollService;

    //Create a method to handle get request
    @GetMapping({"","/"})
    public String getGreeting(){
        return "Hello Employees";
    }

    //Create a method createEmployeePayroll to saves a Employee details in the repository
    @PostMapping("/add")
    public Employee createEmployeePayroll(@RequestBody Employee employee){
        return employeePayrollService.createGreetingPayroll(employee);
    }

    //Create a getEmployeeById method to print employee details by their id number and call the method of EmployeeService class
    @GetMapping("/get/{id}")
    public Optional<Employee> getEmployeeById(@PathVariable Long id){
        return employeePayrollService.getEmployeeById(id);
    }

    //Create a method printAllEmployee to print the details of all employee details
    @GetMapping("/all")
    public List<Employee> printAllEmployee(){
        return employeePayrollService.getAllEmployee();
    }

    //Create a method to update the employee details by employee id number
    @PutMapping("/update/{id}")
    public Employee updateEmployeeDetails(@PathVariable Long id,@RequestBody Employee employee){
        return employeePayrollService.updateEmployeeDetails(id,employee);
    }

    //Create a method deleteEmployeeDetails to delete employee detail by id number
    @DeleteMapping("/delete/{id}")
    public String deleteEmployeeDetails(@PathVariable Long id) {
        return employeePayrollService.deleteEmployeeDetails(id) ? "Employee Detail is deleted!" : id + " Id Number Employee is not exist!";
    }


}
