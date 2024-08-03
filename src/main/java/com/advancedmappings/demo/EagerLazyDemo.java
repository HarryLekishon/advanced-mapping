package com.advancedmappings.demo;


import com.advancedmappings.entity.Course;
import com.advancedmappings.entity.Instructor;
import com.advancedmappings.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class EagerLazyDemo {
    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .buildSessionFactory();

        // create session
        Session session = factory.getCurrentSession();

        try {


            // start a transaction
            session.beginTransaction();

            //get instructor from db
            int theId = 1;
            //Instructor tempInstructor = session.get(Instructor.class, theId);
            //create some courses

            //System.out.println("luv 2 code Instructor: " + tempInstructor);
            //System.out.println("luv 2 code Courses: " + tempInstructor.getCourses());
            Query<Instructor> query = session.createQuery("select i from Instructor i "
                    + "JOIN FETCH i.courses "
                    + "where i.id=:theInstructotId",
                    Instructor.class);
            query.setParameter("theInstructotId", theId);

            //excute query
            Instructor instructor = query.getSingleResult();
            session.getTransaction().commit();
            //get courses for the instructor
            session.close();
            System.out.println("session is closed");
            //System.out.println("luv 2 code Courses: " + tempInstructor.getCourses());

            System.out.println("luv 2 code Done!");
        }
        finally {

            session.close();

            factory.close();
        }

    }


}
