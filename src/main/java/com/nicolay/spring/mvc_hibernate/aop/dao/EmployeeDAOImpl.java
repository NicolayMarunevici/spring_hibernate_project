package com.nicolay.spring.mvc_hibernate.aop.dao;

import com.nicolay.spring.mvc_hibernate.aop.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO{

    @Autowired
    private SessionFactory sessionFactory;


    @Override
    public List<Employee> getAllEmployees(){

        Session session = sessionFactory.getCurrentSession();

        Query<Employee> query = session.createQuery("from Employee", Employee.class);
        List<Employee> employeeList = query.getResultList();

        return employeeList;
    }


    @Override
    public void saveEmployee(Employee employee){
        Session session = sessionFactory.getCurrentSession();

        session.saveOrUpdate(employee);
    }

    @Override
    public Employee getEmployee(int id){
        Session session = sessionFactory.getCurrentSession();

        Employee employee = session.get(Employee.class, id);

        return employee;
    }


    @Override
    public void deleteEmployee(int id){
        Session session = sessionFactory.getCurrentSession();

        Query<Employee> query = session.createQuery("delete from Employee where id = :emplId");
        query.setParameter("emplId", id);

        query.executeUpdate();
    }
}
