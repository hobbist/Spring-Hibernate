package com.tutorial;

import com.tutorial.config.ApplicationConfig;
import com.tutorial.model.FourWheeler;
import com.tutorial.model.TwoWheeler;
import com.tutorial.model.Vehicle;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class VehicleApp {
    public static void main(String[] args){
        ApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);
        SessionFactory factory=context.getBean("sessionFactory",SessionFactory.class);

        Vehicle vehicle=new Vehicle();
        vehicle.setNumber("sdf1223");

        TwoWheeler twoWheeler=new TwoWheeler();
        twoWheeler.setNumber("xdfdg");
        twoWheeler.setHandle("2");

        FourWheeler fourWheeler=new FourWheeler();
        fourWheeler.setNumber("sdfsdf");
        fourWheeler.setSteeringWheel("whhw");

        Session session=factory.openSession();
        session.beginTransaction();
        session.save(vehicle);session.save(twoWheeler);session.save(fourWheeler);
        session.getTransaction().commit();
    }
}
