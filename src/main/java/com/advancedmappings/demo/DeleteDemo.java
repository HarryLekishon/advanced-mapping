package com.advancedmappings.demo;

import com.advancedmappings.entity.Instructor;
import com.advancedmappings.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteDemo {
    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try{
            session.beginTransaction();

            int theId = 2;
            Instructor tempInstructor = session.get(Instructor.class, theId);

            if(tempInstructor != null){
                System.out.println("deleting instructor");
                session.delete(tempInstructor);
            }
            session.getTransaction().commit();

            System.out.println("Done!");

        } finally {
            factory.close();
        }

    }



}
