package com.ems.ems_backend.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Entity
@Table(name="employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email_id")
    private String email;

    public Employee(Object id, Object firstName, Object lastName, Object email) {
        if (id != null) {
            this.id = Long.parseLong(String.valueOf(id));
        }
        this.firstName = (firstName != null) ? String.valueOf(firstName) : null;
        this.lastName = (lastName != null) ? String.valueOf(lastName) : null;
        this.email = (email != null) ? String.valueOf(email) : null;
    }

    public Employee() {

    }

    public Long getId() {
        return this.id;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public String getEmail() {
        return this.email;
    }

    public void setFirstName(String firstName) { // Corrected
        this.firstName = firstName;
    }

    public void setLastName(String lastName) { // Corrected
        this.lastName = lastName;
    }

    public void setEmail(String email) { // Corrected
        this.email = email;
    }
}