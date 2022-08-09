package com.nicolay.spring.mvc_hibernate.aop.dao;

import com.nicolay.spring.mvc_hibernate.aop.entity.Employee;

import java.util.List;

public interface EmployeeDAO {

    List<Employee> getAllEmployees();

    void saveEmployee(Employee employee);

    Employee getEmployee(int id);

    void deleteEmployee(int id);
}
