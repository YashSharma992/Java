package com.example.employeeapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.employeeapi.Employee;
import com.example.employeeapi.EmployeeRepository;
import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository repository;

    public Employee addEmployee(Employee employee) {
        return repository.save(employee);
    }

    public List<Employee> getAllEmployees() {
        return repository.findAll();
    }

    public Employee getEmployeeById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Employee updateEmployee(Long id, Employee empDetails) {
        Employee emp = repository.findById(id).orElse(null);

        if (emp != null) {
            //emp.setName(empDetails.getName());
           // emp.setEmail(empDetails.getEmail());
           // emp.setSalary(empDetails.getSalary());
            return repository.save(emp);
        }

        return null;
    }

    public String deleteEmployee(Long id) {
        repository.deleteById(id);
        return "Employee removed with ID: " + id;
    }
}