package com.bridgelabz.employeepayrollapp.service;

import com.bridgelabz.employeepayrollapp.entity.Employee;
import com.bridgelabz.employeepayrollapp.repository.EmployeePayrollRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

//Create a Service class to handle greeting-related operations
@Service
public class EmployeePayrollService {

    //Create an instance of GreetingRepository It is automatically injects
    @Autowired
    private EmployeePayrollRepository employeePayrollRepository;

    //Create a method createEmployeePayroll to saves an Employee details in the repository
    public Employee createGreetingPayroll(Employee employee){
        return employeePayrollRepository.save(employee);
    }

    //Create a getEmployeePayrollById method to print employee details by their id number and call the method of EmployeeService class
    public Optional<Employee> getEmployeeById(Long id){
        return employeePayrollRepository.findById(id);
    }

    //Create a method getAllEmployee to print all employee details
    public List<Employee> getAllEmployee(){
        return employeePayrollRepository.findAll();
    }

    //Create a method to update the employee details by their id number
    public Employee updateEmployeeDetails(Long id,Employee employee){
        Optional<Employee> employee1=employeePayrollRepository.findById(id);
        if(employee1.isPresent()){
            Employee existingEmployee=employee1.get();
            existingEmployee.setEmployeeSalary(employee.getEmployeeSalary());
            existingEmployee.setEmployeeName(employee.getEmployeeName());
            existingEmployee.setEmployeeRole(employee.getEmployeeRole());
            existingEmployee.setId(employee.getId());
            return employeePayrollRepository.save(existingEmployee);
        }else{
            throw new RuntimeException("Employee is not present by id: "+id);
        }
    }

    //Create a method deleteEmployeeDetails to delete employee details by id number
    public boolean deleteEmployeeDetails(Long id){
        Optional<Employee> employee=employeePayrollRepository.findById(id);
        //check id is present or not
        if(employee.isPresent()){
           employeePayrollRepository.deleteById(id);
           return true;
        }
        return false;
    }
}
