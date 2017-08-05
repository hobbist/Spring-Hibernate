package com.tutorial;

import com.tutorial.config.ApplicationConfig;
import com.tutorial.model.*;
import com.tutorial.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.Date;

public class App
{
    public static void main( String[] args ) {
        ApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);
        UserService service=context.getBean("userService", UserService.class);

        User user=new User("kapil","kapil@email.com",new Date(System.currentTimeMillis()),new java.util.Date());
        Credentials cred1=new Credentials();
        cred1.setUserName("user1");
        cred1.setPassword("pass1");
        cred1.setUser_id(1);
        //cred1.setUser(user);
        Credentials cred2=new Credentials();
        cred2.setUserName("user2");
        cred2.setPassword("pass2");
        cred2.setUser_id(1);
        //cred2.setUser(user);
        user.getCreds().add(cred1);
        user.getCreds().add(cred2);

        Address addr1=new Address();
        addr1.setAddressLine1("dsfsdf");
        addr1.setAddressLine2("dsfsdf");
        addr1.getUsers().add(user);

        Address addr2=new Address();
        addr2.setAddressLine1("dsfsdf");
        addr2.setAddressLine2("dsfsdf");
        addr2.getUsers().add(user);

        user.getAddress().add(addr1);
        user.getAddress().add(addr2);
        User user2=new User("kapil2","kapil@email.com",new Date(System.currentTimeMillis()),new java.util.Date());
        user2.getAddress().add(addr1);user2.getAddress().add(addr2);
        addr1.getUsers().add(user2);addr2.getUsers().add(user);

        service.addUser(user);
        service.addUser(user2);


        System.out.println(service.getUserByCriteria("Amit"));
        System.out.println(service.getUsers().get(0).getCreds());


    }
}
