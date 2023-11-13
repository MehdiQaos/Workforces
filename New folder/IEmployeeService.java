package dev.mehdi.service;

import dev.mehdi.model.Employee;

import java.util.List;

public interface IEmployeeService {
    List<Employee> findAll();

    Employee save(Employee employee);

    Employee update(Employee employee);

    void delete(Employee employee);
}
