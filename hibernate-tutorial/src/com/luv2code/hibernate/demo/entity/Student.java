package com.luv2code.hibernate.demo.entity;

import javax.persistence.*;
import javax.persistence.GeneratedValue;
import java.io.Serializable;

@Entity
@Table(name="student")
public class Student implements Serializable {

    @Id
    @Column(name="id")
    private Integer id;

    @Id
    @Column(name="first_name")
    private String firstName;

    @Id
    @Column(name="last_name")
    private String lastName;

    @Id
    @Column(name="email")
    private String email;

    public Student() {
    }

    public Student(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
