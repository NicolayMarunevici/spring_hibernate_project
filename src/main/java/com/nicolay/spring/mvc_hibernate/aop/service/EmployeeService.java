package com.nicolay.spring.mvc_hibernate.aop.service;

import com.nicolay.spring.mvc_hibernate.aop.entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> getAllEmployees();

    void saveEmployee(Employee employee);

    Employee updateEmployee(int id);

    void deleteEmployee(int id);
}
