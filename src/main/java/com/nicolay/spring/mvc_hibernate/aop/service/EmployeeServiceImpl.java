package com.nicolay.spring.mvc_hibernate.aop.service;

import com.nicolay.spring.mvc_hibernate.aop.dao.EmployeeDAO;
import com.nicolay.spring.mvc_hibernate.aop.dao.EmployeeDAOImpl;
import com.nicolay.spring.mvc_hibernate.aop.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;


@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeDAO employeeDAO;

    @Override
    @Transactional
    public List<Employee> getAllEmployees(){
        List<Employee> employeeList = employeeDAO.getAllEmployees();

        return employeeList;
    }


    @Override
    @Transactional
    public void saveEmployee(Employee employee){
        employeeDAO.saveEmployee(employee);
    }


    @Override
    @Transactional
    public Employee updateEmployee(int id){
        return employeeDAO.getEmployee(id);
    }


    @Override
    @Transactional
    public void deleteEmployee(int id){
        employeeDAO.deleteEmployee(id);
    }
}
