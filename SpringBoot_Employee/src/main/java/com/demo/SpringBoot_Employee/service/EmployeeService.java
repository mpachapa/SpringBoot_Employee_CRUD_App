package com.demo.SpringBoot_Employee.service;

import com.demo.SpringBoot_Employee.model.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> getAllEmployees();
    void saveEmployee(Employee employee);
    Employee getById(long id);
    void deleteEmployeeById(long id);

}
