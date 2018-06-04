package com.postgresexample.postgresample.EmployeeModel;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.hateoas.core.Relation;

import javax.persistence.*;

@Entity
@Table(name="PROFILE")
public class EmployeeRep {

    @Id
    //@GeneratedValue(generator = "uuid")
    //@GenericGenerator(name="uuid", strategy="uuid2")
    @Column(name="NAME")
    private String name;

    private String address;
    private int age;
    private int phone;

    public EmployeeRep(String name, String address, int age, int phone) {
        this.name = name;
        this.address = address;
        this.age = age;
        this.phone = phone;
    }

    public EmployeeRep(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public EmployeeRep() {
    }

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
