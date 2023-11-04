package dev.mehdi;

import dev.mehdi.model.Department;
import dev.mehdi.model.User;
import jakarta.persistence.EntityManager;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainApp {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(PersistenceJPAConfig.class);
        EntityManager em = applicationContext.getBean("entityManager", EntityManager.class);
        User user = new User("Mehdi");
        Department department1 = new Department("cs", "computer science");
        user.setDepartment(department1);
        em.persist(user);
    }
}