package com.demo.SpringBoot_Employee.service;

import com.demo.SpringBoot_Employee.model.Employee;
import org.springframework.data.domain.Page;

import java.util.List;

public interface EmployeeService {
    List<Employee> getAllEmployees();
    void saveEmployee(Employee employee);
    Employee getById(long id);
    void deleteEmployeeById(long id);
    Page<Employee> findPageinated(int pageNo, int pageSize, String sortField, String sortDirection);

}
