package com.advancedmappings.demo;


import com.advancedmappings.entity.Course;
import com.advancedmappings.entity.Instructor;
import com.advancedmappings.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateCoursesDemo {
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
            Course tempCourse1 = new Course("Thing you cant get in Book");
            Course tempCourse2 = new Course("A guide to air bending");

            //add courses to instructor
            tempInstructor.addCourse(tempCourse1);
            tempInstructor.addCourse(tempCourse2);

            //save course
            session.save(tempCourse1);
            session.save(tempCourse2);
            session.getTransaction().commit();

            System.out.println("Done!");
        }
        finally {

            session.close();

            factory.close();
        }

    }


}
