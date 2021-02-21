package com.company.repositories;

import com.company.data.interfaces.IDB;
import com.company.entities.Employee;
import com.company.repositories.interfaces.IEmployeeRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

 public abstract class EmployeeRepository implements IEmployeeRepository {
     private final IDB db;

     public EmployeeRepository(IDB db) {
         this.db = db;
     }

     @Override
     public boolean createEmployee(Employee employee) {
         Connection con = null;
         try {
             con = db.getConnection();
             String sql = "INSERT INTO stones(name,cost,experienced) VALUES (?,?,?)";
             PreparedStatement st = con.prepareStatement(sql);

             st.setString(1, employee.getName());
             st.setInt(2, employee.getCost());
             st.setBoolean(3, employee.isExperienced());

             boolean executed = st.execute();
             return executed;
         } catch (SQLException throwables) {
             throwables.printStackTrace();
         } catch (ClassNotFoundException e) {
             e.printStackTrace();
         } finally {
             try {
                 con.close();
             } catch (SQLException throwables) {
                 throwables.printStackTrace();
             }
         }
         return false;
     }

     @Override
     public Employee getEmployee(int id) {
         Connection con = null;
         try {
             con = db.getConnection();
             String sql = "SELECT id,name, cost, experienced FROM stones WHERE id=?";
             PreparedStatement st = con.prepareStatement(sql);

             st.setInt(1, id);

             ResultSet rs = st.executeQuery();
             if (rs.next()) {
                 Employee employee = new Employee(rs.getInt("id"),
                         rs.getString("name"),
                         rs.getInt("cost"),
                         rs.getBoolean("experienced"));

                 return employee;
             }
         } catch (SQLException throwables) {
             throwables.printStackTrace();
         } catch (ClassNotFoundException e) {
             e.printStackTrace();
         } finally {
             try {
                 con.close();
             } catch (SQLException throwables) {
                 throwables.printStackTrace();
             }
         }
         return null;
     }

     @Override
     public List<Employee> getAllEmployee() {
         Connection con = null;
         try {
             con = db.getConnection();
             String sql = "SELECT id, name, cost, experienced FROM stones";
             Statement st = con.createStatement();

             ResultSet rs = st.executeQuery(sql);
             List<Employee> employees = new ArrayList<>();
             while (rs.next()) {
                 Employee employee = new Employee(rs.getInt("id"),
                         rs.getString("name"),
                         rs.getInt("cost"),
                         rs.getBoolean("experienced"));

                 employees.add(employee);
             }

             return employees;
         } catch (SQLException throwables) {
             throwables.printStackTrace();
         } catch (ClassNotFoundException e) {
             e.printStackTrace();
         } finally {
             try {
                 con.close();
             } catch (SQLException throwables) {
                 throwables.printStackTrace();
             }
         }
         return null;
     }
 }
