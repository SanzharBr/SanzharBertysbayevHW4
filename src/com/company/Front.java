package com.company;

import com.company.controllers.EmployeeController;
import com.company.entities.Employee;
import com.company.repositories.interfaces.IEmployeeRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Vector;

public class Front
{
    private final EmployeeController controller;
    private final Scanner scanner;

    public Front(IEmployeeRepository employeeRepository){
        controller = new EmployeeController(employeeRepository);
        scanner = new Scanner(System.in);
    }


    public void start()
    {
        while (true)
        {
            System.out.println();
            System.out.println("Welcome to My Project");
            System.out.println("Select option:");
            System.out.println("1. Get all Employee");
            System.out.println("2. Get Employee by id");
            System.out.println("3. Add Employee");
            System.out.println("4. Create Team");
            System.out.println("0. Exit");
            System.out.println();

            try {
                System.out.print("Enter option (1-6): ");
                int option = scanner.nextInt();
                if (option == 1) {
                    getAllPreciousMenu();
                }else if(option == 2){
                    getPreciousByIdMenu();
                }else if(option == 3){
                    createPreciousMenu();
                }else if (option == 4){
                    createNecklaceMenu();
                }
                else {
                    break;
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
                scanner.next(); // to ignore incorrect input
            }

            System.out.println("*************************");

        }

    }

    public void getAllPreciousMenu() {
        String response = controller.getAllEmployee();
        System.out.println(response);
    }

    public void getPreciousByIdMenu() {
        System.out.println("Please enter id");

        int id = scanner.nextInt();
        Employee employee = controller.getEmployee(id);
        System.out.println((employee == null ? "Employee was not found!" : employee.toString()));
    }

    public void createPreciousMenu() {
        System.out.println("Please enter name");
        String name = scanner.next();
        System.out.println("Please enter cost");
        int cost = scanner.nextInt();
        System.out.println("Is it experienced? (true/false)");
        boolean precious = scanner.nextBoolean();

        String response = controller.createPrecious(name, cost, precious);
        System.out.println(response);
    }

    public void createNecklaceMenu() {
        List<Employee> stones = new ArrayList<>();
        while (true){
            System.out.println();
            System.out.println("Welcome to Team creation");
            System.out.println("Select option:");
            System.out.println("1. Add Employee to the Team");
            System.out.println("2. Go back");
            System.out.println("3. Start again");
            System.out.println("4. My Teams");
            System.out.println("0. Finish");
            System.out.println();

            try {
                System.out.print("Enter option (1-6): ");
                int option = scanner.nextInt();
                if (option == 1) {
                    addStoneToNecklaceMenu(stones);
                } else if (option == 2) {
                    stones.remove(stones.size()-1);
                    System.out.println("Successfully removed last Employee!");
                } else if(option == 3){
                    stones.clear();
                    System.out.println("Successfully removed Team");
                } else if(option == 4){
                    myNecklace(stones);
                }

                else {
                    System.out.println(controller.calculateNecklace(stones));
                    myNecklace(stones);
                    break;
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
                scanner.next(); // to ignore incorrect input
            }

            System.out.println("*************************");
        }
    }

    public void addStoneToNecklaceMenu(List<Employee> stones){
        getAllPreciousMenu();
        System.out.println("Choose id of Employee from the list: ");

        int choice = scanner.nextInt();
        stones.add(controller.getEmployee(choice));
    }


    public void myNecklace(List<Employee> stones){
        System.out.println("Your Team consist of: ");
        for(int i=0;i<stones.size();i++){
            System.out.println(stones.get(i).getName() + ", ");
        }
    }
}
