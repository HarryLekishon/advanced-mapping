package com.advancedmappings.demo;


import com.advancedmappings.entity.Course;
import com.advancedmappings.entity.Instructor;
import com.advancedmappings.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteCoursesDemo {
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

            //get a course
            int theId = 10;
            Course theCourse = session.get(Course.class, theId);

            System.out.println("Deleting course: " + theCourse);
            session.delete(theCourse);
            //commit transaction
            session.getTransaction().commit();

            System.out.println("Done!");
        }
        finally {

            session.close();

            factory.close();
        }

    }


}
