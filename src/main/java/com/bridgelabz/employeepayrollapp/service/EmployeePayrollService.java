package com.bridgelabz.employeepayrollapp.service;

import com.bridgelabz.employeepayrollapp.dto.EmployeePayrollDTO;
import com.bridgelabz.employeepayrollapp.entity.Employee;
import com.bridgelabz.employeepayrollapp.repository.EmployeePayrollRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
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
    public ResponseEntity<EmployeePayrollDTO> getEmployeeById(Long id){
        //find employee data using id number and store in optional
        Optional<Employee> employee=employeePayrollRepository.findById(id);
        //check employee is present or not
        if(employee.isPresent()){
            Employee emp=employee.get();
            EmployeePayrollDTO employeePayrollDTO= new EmployeePayrollDTO(emp.getId(),emp.getEmployeeName(),emp.getEmployeeSalary());
            System.out.println("Hello Employee");
            return ResponseEntity.of(Optional.of(employeePayrollDTO));
            //return new ResponseEntity<>(employeePayrollDTO, HttpStatus.OK);
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    //Create a method getAllEmployee to print all employee details
    public List<EmployeePayrollDTO> getAllEmployee(){
        List<Employee>employees= employeePayrollRepository.findAll();
        List<EmployeePayrollDTO>employeePayrollDTOS=new ArrayList<>();
        for(Employee employee:employees){
            employeePayrollDTOS.add(new EmployeePayrollDTO(employee.getId(),employee.getEmployeeName(),employee.getEmployeeSalary()));
        }
        return employeePayrollDTOS;
    }

    //Create a method to update the employee details by their id number
    public String updateEmployeeDetails(Long id,Employee employee){
        //find employee data using id number and store in optional
        Optional<Employee> employee1=employeePayrollRepository.findById(id);
        //check employee is present or not
        if(employee1.isPresent()){
            //get employee details
            Employee existingEmployee=employee1.get();
            //update employee details as salary and name
            existingEmployee.setEmployeeSalary(employee.getEmployeeSalary());
            existingEmployee.setEmployeeName(employee.getEmployeeName());
            employeePayrollRepository.save(existingEmployee);
            return "Employee Record Successfully Updated";
        }else{
            return "Employee Is Not Found";
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
