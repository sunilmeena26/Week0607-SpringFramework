package com.bridgelabz.employeepayrollapp.repository;

import com.bridgelabz.employeepayrollapp.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//Create an interface EmployeePayrollRepository to extends JpaRepository which provides built-in methods for basic database CRUD operations
@Repository
public interface EmployeePayrollRepository extends JpaRepository<Employee,Long> {
}
