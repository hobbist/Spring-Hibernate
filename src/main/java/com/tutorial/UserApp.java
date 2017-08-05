package com.tutorial;

import com.tutorial.config.ApplicationConfig;
import com.tutorial.model.NameEmail;
import com.tutorial.model.User;
import com.tutorial.service.UserService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.persistence.TemporalType;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.sql.Date;
import java.util.List;

public class UserApp {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);
        SessionFactory factory = context.getBean("sessionFactory", SessionFactory.class);
        UserService service = context.getBean("userService", UserService.class);
        java.util.Date date = new java.util.Date();
        User user = new User("kapil", "kapil@email.com", new Date(System.currentTimeMillis()), date);
        User user2 = new User("amit", "amit@email.com", new Date(System.currentTimeMillis()), new java.util.Date());
        User user3 = new User("aai", "aai@gemail.com", new Date(System.currentTimeMillis()), new java.util.Date());
        User user4 = new User("baba", "baba@gemail.com", new Date(System.currentTimeMillis()), new java.util.Date());
        User user5 = new User("anuja", "anuja@gemail.com", new Date(System.currentTimeMillis()), new java.util.Date());

        service.addUser(user);
        service.addUser(user2);
        service.addUser(user3);
        service.addUser(user4);
        service.addUser(user5);

        Session session = factory.openSession();
        session.beginTransaction();
        List<User> users = session.createQuery("from User where email like :emailS and modifiedDate>=:date").
                setParameter("emailS", "%email%").
                setParameter("date", date, TemporalType.DATE).list();
        List<User> users2 = session.getNamedQuery("getUserByName").setParameter("name", "kapil").list();
        session.getTransaction().commit();
        session.close();

        session = factory.openSession();
        session.beginTransaction();
        CriteriaBuilder criteria = session.getCriteriaBuilder();
        CriteriaQuery<User> userCriteriaQuery = criteria.createQuery(User.class);
        Root<User> userRoot = userCriteriaQuery.from(User.class);
        userCriteriaQuery.select(userRoot);
        List<User> usersList = session.createQuery(userCriteriaQuery).getResultList();
        session.getTransaction().commit();
        session.close();

        session = factory.openSession();
        session.beginTransaction();
        List<NameEmail> nameEmail = session.createQuery("select new com.tutorial.model.NameEmail(user.name,user.email) from User as user where name=:name").setParameter("name", "kapil").getResultList();
        System.out.println(nameEmail);

        session = factory.openSession();
        session.beginTransaction();
        List<Object[]> list = session.createQuery("select count(u) from User as u",Object[].class).getResultList();
        System.out.println(list);





    }
}
