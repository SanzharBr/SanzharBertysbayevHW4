package com.company;

import com.company.data.PostgresDB;
import com.company.data.interfaces.IDB;
import com.company.entities.Employee;
import com.company.repositories.EmployeeRepository;
import com.company.repositories.interfaces.IEmployeeRepository;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        IDB db = new PostgresDB();
        IEmployeeRepository employeeRepository = new EmployeeRepository(db) {
            @Override
            public boolean createPrecious(Employee employee) {
                return false;
            }

            @Override
            public List<Employee> getAllEmployees() {
                return null;
            }
        };

//        ILocomotiveRepository locomotiveRepository = new LocomotiveRepository(db);

        Front app = new Front(employeeRepository);
        app.start();
    }
}


