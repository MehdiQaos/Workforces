package dev.mehdi.service;

import dev.mehdi.model.Department;

import java.util.List;

public interface IDepartmentService {
    List<Department> findAll();
    Department save(Department employee);
    Department update(Department employee);
    void delete(Department employee);
}
