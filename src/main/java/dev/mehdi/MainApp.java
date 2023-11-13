package dev.mehdi;

import dev.mehdi.model.Department;
import dev.mehdi.model.Employee;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

public class MainApp {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(PersistenceJPAConfig.class);
//        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        LocalContainerEntityManagerFactoryBean emf = applicationContext.getBean("entityManagerFactory", LocalContainerEntityManagerFactoryBean.class);
        var em = emf.getObject().createEntityManager();
//        EntityManager em = applicationContext.getBean("entityManager", EntityManager.class);
        Employee employee = new Employee("Mehdi");
        Department department1 = new Department("cs", "computer science");
        employee.setDepartment(department1);
        em.persist(employee);
    }
}