package com.mic.java8.bean;

import java.util.List;

public class Company {

    private String name;
    private List<Person> employees;

    public Company(String name) {
        this.name = name;
    }

    public Company(String name, List<Person> employees) {
        this.name = name;
        this.employees = employees;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Person> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Person> employees) {
        this.employees = employees;
    }
}
