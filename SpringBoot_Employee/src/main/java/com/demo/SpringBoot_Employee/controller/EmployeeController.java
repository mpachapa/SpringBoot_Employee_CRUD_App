package com.demo.SpringBoot_Employee.controller;

import com.demo.SpringBoot_Employee.model.Employee;
import com.demo.SpringBoot_Employee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    //Homepage Displaying List of Employees
    @GetMapping("/")
    public String viewHomePage(Model model){
        return findPaginated(1,model);
    }

    //Adding a New Employee
    @GetMapping("/newEmployee")
    public String newEmployee(Model model){
        Employee employee = new Employee();
        model.addAttribute("employee", employee);
        return "newEmployee";
    }

    @GetMapping("/updateForm/{id}")
    public String updateEmployee(@PathVariable (value = "id") long id, Model model){
        //Get employee form the service
        Employee employee = employeeService.getById(id);
        //Setting employee to the model
        model.addAttribute("employee",employee);
        return "updateEmployee";
    }

    //Saving an Employee to Database
    @PostMapping("/saveEmployee")
    public String saveEmployee(@ModelAttribute("employee") Employee employee){
        employeeService.saveEmployee(employee);
        return "redirect:/";
    }

    //Deleting an Employee from Database
    @GetMapping("/deleteEmployee/{id}")
    public String deleteEmployee(@PathVariable (value = "id") long id){
        this.employeeService.deleteEmployeeById(id);
        return "redirect:/";
    }

    @GetMapping("/page/{pageNo}")
    public String findPaginated(@PathVariable (value = "pageNo") int pageNo, Model model){
        int pageSize = 6;

        Page<Employee> page = employeeService.findPageinated(pageNo,pageSize);
        List<Employee> listOfEmployee = page.getContent();

        model.addAttribute("currentPage", pageNo);
        model.addAttribute("totalPages",page.getTotalPages());
        model.addAttribute("totalItems",page.getTotalElements());
        model.addAttribute("listOfEmployees",listOfEmployee);
        return "index";
    }
}

