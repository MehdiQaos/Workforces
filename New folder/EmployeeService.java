package dev.mehdi.service;

import dev.mehdi.model.Department;
import dev.mehdi.model.Employee;
import dev.mehdi.repository.EmployeeRepository;

import java.util.List;
import java.util.Optional;

public class EmployeeService implements IEmployeeService {
    private final EmployeeRepository employeeRepository;
    private final DepartmentService departmentService;

    public EmployeeService(EmployeeRepository employeeRepository, DepartmentService departmentService) {
        this.employeeRepository = employeeRepository;
        this.departmentService = departmentService;
    }

    @Override
    public List<Employee> findAll() {
        return (List<Employee>) employeeRepository.findAll();
    }

    @Override
    public Employee save(Employee employee) {
        String departmentName = employee.getDepartment().getName();
        Optional<Department> department = departmentService.findByName(departmentName);
        department.ifPresent(employee::setDepartment);
        department.orElseThrow(() -> new IllegalArgumentException("Department not found"));
        return employeeRepository.save(employee);
    }

    @Override
    public Employee update(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public void delete(Employee employee) {
        employeeRepository.delete(employee);
    }
}
