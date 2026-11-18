package com.example.employeemanagement.model;

/** Immutable employee entity (Java record). */
public record Employee(Long id, String name, String email, String department, double salary) {

    public Employee withId(Long newId) {
        return new Employee(newId, name, email, department, salary);
    }
}
