package com.company.repositories.interfaces;

import com.company.entities.Employee;

import java.util.List;

public interface IEmployeeRepository
{
    boolean createPrecious(Employee employee);

    boolean createEmployee(Employee employee);

    Employee getEmployee(int id);
    List<Employee> getAllEmployees();

    List<Employee> getAllEmployee();
}
