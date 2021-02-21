package com.company.entities;

public class Employee
{
    private int id;
    private String name;
    private int cost;
    private boolean experienced;

    public Employee() {
    }

    public Employee(String name, int cost, boolean experienced) {
        this.name = name;
        this.cost = cost;
        this.experienced = experienced;
    }

    public Employee(int id, String name,  int cost, boolean experienced) {
        this.id = id;
        this.name = name;
        this.cost = cost;
        this.experienced = experienced;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public boolean isExperienced() {
        return experienced;
    }

    public void setExperienced(boolean experienced) {
        this.experienced = experienced;
    }

    @Override
    public String toString() {
        return "Experienced{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", cost=" + cost +
                ", Experienced=" + experienced +
                '}';
    }
}
