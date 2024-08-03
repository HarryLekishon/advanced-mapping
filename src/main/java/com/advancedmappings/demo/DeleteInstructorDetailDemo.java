package com.advancedmappings.demo;

import com.advancedmappings.entity.Instructor;
import com.advancedmappings.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteInstructorDetailDemo {
    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try{
            session.beginTransaction();

            int theId = 4;
            InstructorDetail tempInstructorDetail = session.get(InstructorDetail.class, theId);

            System.out.println("tempinstructorDetail" + tempInstructorDetail);

            System.out.println("the associated instructor" + tempInstructorDetail.getInstructor());

            System.out.println("Deleting temp InstructorDetail" + tempInstructorDetail);

            //REMOVE ASSOCIATED OBJECT REFERENCE
            tempInstructorDetail.getInstructor().setInstructorDetail(null);

            session.delete(tempInstructorDetail);
            session.getTransaction().commit();

            System.out.println("Done!");
        } finally {
            if (session != null) {
                session.close();
            }
            factory.close();
        }


    }



}
