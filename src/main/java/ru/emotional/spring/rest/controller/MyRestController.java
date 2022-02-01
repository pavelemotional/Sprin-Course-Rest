package ru.emotional.spring.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.emotional.spring.rest.entity.Employee;
import ru.emotional.spring.rest.exeption_handling.NoSuchEmloyeeException;
import ru.emotional.spring.rest.service.EmployeeService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MyRestController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employees")
    public List<Employee> showAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @GetMapping("/employees/{id}")
    public Employee showEmployee(@PathVariable int id) {
        Employee employee = employeeService.getEmployee(id);
        if (employee == null)
            throw new NoSuchEmloyeeException("Employee s id[" + id + "] ne naideno v baze dannih");
        return employee;
    }

    @PostMapping("/employees")
    public Employee addNewEmployee(@RequestBody Employee employee) {
        employeeService.saveEmployee(employee);
        return employee;
    }

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee employee) {
        employeeService.saveEmployee(employee);
        return employee;
    }

    @DeleteMapping("/employees/{id}")
    public String deleteEmployee(@PathVariable int id) {
        if (employeeService.getEmployee(id) == null)
            throw new NoSuchEmloyeeException("Employee s id[" + id + "] ne naideno v baze dannih");
        employeeService.deleteEmployee(id);
        return "employee id [" + id + "] deleted";
    }
}
