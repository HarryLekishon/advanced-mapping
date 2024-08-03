package com.advancedmappings.demo;


import com.advancedmappings.entity.Course;
import com.advancedmappings.entity.Instructor;
import com.advancedmappings.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class GetInstructorCoursesDemo {
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
            Instructor tempInstructor = session.get(Instructor.class, theId);
            //create some courses
            System.out.println("Instructor: " + tempInstructor);

            //get courses for the instructor
            System.out.println("Courses: " + tempInstructor.getCourses());

            session.getTransaction().commit();

            System.out.println("Done!");
        }
        finally {

            session.close();

            factory.close();
        }

    }


}
