package com.postgresexample.postgresample.EmployeeDto;

import java.util.Objects;

public class Employee {
    private String name;
    private String address;
    private int age;
    private int phone;

    public Employee(String name, String address, int age, int phone) {
        this.name = name;
        this.address = address;
        this.age = age;
        this.phone = phone;
    }

    public Employee(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }
}
