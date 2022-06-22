package com.demo.SpringBoot_Employee.repository;

import com.demo.SpringBoot_Employee.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository <Employee,Long>{

}
