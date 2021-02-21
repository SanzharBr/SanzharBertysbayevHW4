package com.company.controllers;

import com.company.entities.Employee;
import com.company.repositories.EmployeeRepository;
import com.company.repositories.interfaces.IEmployeeRepository;

import java.util.ArrayList;
import java.util.List;

public class EmployeeController
{
    private final IEmployeeRepository employeeRepository;

    public EmployeeController(IEmployeeRepository employeeRepository){
        this.employeeRepository = employeeRepository;
    }

    public String createPrecious(String name, int cost, boolean experienced)
    {
       Employee stone = new Employee(name, cost, experienced);

        boolean created = employeeRepository.createEmployee(stone);

        return (created ? "Employee was created!" : "Employee creation was failed!");
    }

    public Employee getEmployee(int id) {
        Employee employee = employeeRepository.getEmployee(id);

        return employee;
    }

    public String getAllEmployee() {
        List<Employee> employees = employeeRepository.getAllEmployee();

        return employees.toString();
    }

    public String calculateNecklace(List<Employee> stones){

        Integer cost = 0;
        for(int i=0;i<stones.size();i++){

            cost = cost + stones.get(i).getCost();
        }

        return " total cost: " + cost.toString();
    }
}