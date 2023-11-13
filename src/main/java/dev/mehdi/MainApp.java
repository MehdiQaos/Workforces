package dev.mehdi;

import dev.mehdi.model.Department;
import dev.mehdi.model.Employee;
import dev.mehdi.service.DepartmentService;
import dev.mehdi.service.EmployeeService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;
import java.util.Random;

public class MainApp {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        EmployeeService employeeService = applicationContext.getBean("employeeService", EmployeeService.class);
        DepartmentService departmentService = applicationContext.getBean("departmentService", DepartmentService.class);

        List<Employee> employees = List.of(
                new Employee("Mehdi"),
                new Employee("Ali"),
                new Employee("Hassan"),
                new Employee("Mohammed")
        );

        List<Department> departments = List.of(
                new Department("cs", "computer science"),
                new Department("it", "information technology"),
                new Department("is", "information system")
        );

        Random random = new Random();
        departments.forEach(departmentService::save);
        employees.forEach((employee) -> {
            employee.setDepartment(departments.get(random.nextInt(departments.size())));
            employeeService.save(employee);
        });

        employeeService.findAll().forEach(System.out::println);
    }
}