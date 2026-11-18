# Employee Management REST API
Java 25 | Spring Boot 4.0.x | Maven | in-memory ArrayList storage

Run:  mvn spring-boot:run      (or run EmployeeManagementApplication in IntelliJ/Eclipse)
Base URL: http://localhost:8080/employees

curl -X POST localhost:8080/employees -H "Content-Type: application/json" \
  -d '{"name":"Neha","email":"neha@example.com","department":"Finance","salary":70000}'
curl localhost:8080/employees
curl "localhost:8080/employees?department=Engineering"
curl localhost:8080/employees/1
curl -X PUT localhost:8080/employees/1 -H "Content-Type: application/json" \
  -d '{"name":"Asha S","email":"asha@example.com","department":"Engineering","salary":99000}'
curl -X DELETE localhost:8080/employees/1
