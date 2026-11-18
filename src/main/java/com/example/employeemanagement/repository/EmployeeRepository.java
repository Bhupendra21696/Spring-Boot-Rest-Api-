package com.example.employeemanagement.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.example.employeemanagement.model.Employee;
import org.springframework.stereotype.Repository;

/** In-memory storage backed by an ArrayList (no database). */
@Repository
public class EmployeeRepository {

    private final List<Employee> employees = new ArrayList<>();
    private long nextId = 1;

    public synchronized Employee save(Employee employee) {
        Employee saved = employee.withId(nextId++);
        employees.add(saved);
        return saved;
    }

    public synchronized List<Employee> findAll() {
        return List.copyOf(employees);
    }

    public synchronized Optional<Employee> findById(Long id) {
        return employees.stream().filter(e -> e.id().equals(id)).findFirst();
    }

    public synchronized Optional<Employee> update(Long id, Employee updated) {
        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i).id().equals(id)) {
                Employee replacement = updated.withId(id);
                employees.set(i, replacement);
                return Optional.of(replacement);
            }
        }
        return Optional.empty();
    }

    public synchronized boolean deleteById(Long id) {
        return employees.removeIf(e -> e.id().equals(id));
    }
}
