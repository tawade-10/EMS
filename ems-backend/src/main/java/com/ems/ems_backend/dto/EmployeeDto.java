package com.ems.ems_backend.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDto {

    private Long id;
    private String firstName;
    private String lastName;
    private String email;

    public EmployeeDto(Object id, Object firstName, Object lastName, Object email) {
        if (id != null) {
            this.id = Long.parseLong(String.valueOf(id));
        }
        this.firstName = (firstName != null) ? String.valueOf(firstName) : null;
        this.lastName = (lastName != null) ? String.valueOf(lastName) : null;
        this.email = (email != null) ? String.valueOf(email) : null;
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
}