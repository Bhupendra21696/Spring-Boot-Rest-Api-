package com.example.employeemanagement.service;

import java.util.List;
import java.util.Optional;

import com.example.employeemanagement.dto.EmployeeRequest;
import com.example.employeemanagement.model.Employee;
import com.example.employeemanagement.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    private final EmployeeRepository repository;

    @Autowired
    public EmployeeService(EmployeeRepository repository) {
        this.repository = repository;
    }

    public Employee create(EmployeeRequest request) {
        return repository.save(toEmployee(request));
    }

    public List<Employee> findAll() {
        return repository.findAll();
    }

    public Optional<Employee> findById(Long id) {
        return repository.findById(id);
    }

    public Optional<Employee> update(Long id, EmployeeRequest request) {
        return repository.update(id, toEmployee(request));
    }

    public boolean delete(Long id) {
        return repository.deleteById(id);
    }

    private Employee toEmployee(EmployeeRequest r) {
        return new Employee(null, r.name(), r.email(), r.department(), r.salary());
    }
}
