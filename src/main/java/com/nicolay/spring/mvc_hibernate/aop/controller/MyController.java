package com.nicolay.spring.mvc_hibernate.aop.controller;


import com.nicolay.spring.mvc_hibernate.aop.dao.EmployeeDAO;
import com.nicolay.spring.mvc_hibernate.aop.entity.Employee;
import com.nicolay.spring.mvc_hibernate.aop.service.EmployeeService;
import com.nicolay.spring.mvc_hibernate.aop.service.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class MyController {

    @Autowired
    EmployeeService employeeService;

    @RequestMapping("/")
    public String showAllEmployees(Model model){

        List<Employee> allEmployees = employeeService.getAllEmployees();
        model.addAttribute("allEmps", allEmployees);

        return "all-employees";
    }


    @RequestMapping("/addNewEmployee")
    public String addNewEmployee(Model model){

        Employee employee = new Employee();
        model.addAttribute("empl", employee);

        return "employee-info";
    }


    @RequestMapping("/saveEmployee")
    public String saveEmployee(@ModelAttribute("empl") Employee employee){

        employeeService.saveEmployee(employee);

        return "redirect:/";
    }


    @RequestMapping("/updateInfo")
    public String updateEmployee(@RequestParam("empId") int id, Model model){
        Employee employee = employeeService.updateEmployee(id);
        model.addAttribute("empl", employee);

        return "employee-info";
    }

    @RequestMapping("/deleteEmployee")
    public String deleteEmployee(@RequestParam("employeeId") int id){
        employeeService.deleteEmployee(id);

        return "redirect:/";
    }
}
