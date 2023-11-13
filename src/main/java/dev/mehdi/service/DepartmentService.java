package dev.mehdi.service;

import dev.mehdi.model.Department;
import dev.mehdi.repository.DepartmentRepository;

import java.util.List;
import java.util.Optional;

public class DepartmentService implements IDepartmentService {

    private final DepartmentRepository departmentRepository;

    public DepartmentService(DepartmentRepository employeeRepository) {
        this.departmentRepository = employeeRepository;
    }

    public Optional<Department> findByName(String name) {
        return departmentRepository.findByName(name);
    }

    @Override
    public List<Department> findAll() {
        return departmentRepository.findAll();
    }

    @Override
    public Department save(Department employee) {
        return departmentRepository.save(employee);
    }

    @Override
    public Department update(Department department) {
        return departmentRepository.save(department);
    }

    @Override
    public void delete(Department employee) {
        departmentRepository.delete(employee);
    }
}
