package dev.mehdi;

import dev.mehdi.model.Department;
import dev.mehdi.model.User;
import jakarta.persistence.EntityManager;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

public class MainApp {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(PersistenceJPAConfig.class);
        EntityManager em = applicationContext.getBean("entityManager", EntityManager.class);
        User user = new User("Mehdi");
        Department department1 = new Department("cs", "computer science");
        user.setDepartment(department1);
        department1.addUser(user);
        em.getTransaction().begin();
        em.persist(user);
        em.persist(department1);
        em.getTransaction().commit();
    }
}