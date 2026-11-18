package com.example.employeemanagement;

import com.example.employeemanagement.dto.EmployeeRequest;
import com.example.employeemanagement.service.EmployeeService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class EmployeeManagementApplication {

    public static void main(String[] args) {
        SpringApplication.run(EmployeeManagementApplication.class, args);
    }

    /** Seeds a few in-memory employees on startup. */
    @Bean
    CommandLineRunner seedData(EmployeeService service) {
        return _ -> {   // unnamed variable (final since Java 22)
            service.create(new EmployeeRequest("Asha Sharma", "asha@example.com", "Engineering", 95000));
            service.create(new EmployeeRequest("Rahul Verma", "rahul@example.com", "HR", 60000));
            service.create(new EmployeeRequest("Priya Singh", "priya@example.com", "Engineering", 105000));
            service.create(new EmployeeRequest("Neha Gupta", "neha@example.com", "Finance", 70000));
            

            String banner = """
                    ------------------------------------------
                     Employee Management API is running
                     http://localhost:8080/employees
                    ------------------------------------------
                    """;
            System.out.println(banner);
        };
    }
}
