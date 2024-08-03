package com.advancedmappings;

import com.advancedmappings.entity.Instructor;
import com.advancedmappings.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AdvancedmappingsApplication implements CommandLineRunner {
    @Autowired
    private InstrctorService instrctorService;

    public static void main(String[] args) {

        SpringApplication.run(AdvancedmappingsApplication.class, args);


    }

    @Override
    public void run(String... args) throws Exception {
        Instructor instructor = new Instructor("Harry","styles","harry@gmail.com");
        InstructorDetail instructorDetail = new InstructorDetail("https://www.youtube.com/watch?v=YQHsXMglC9A", "swimming");
        instructor.setInstructorDetail(instructorDetail);

        instrctorService.saveInstructor(instructor);
    }
}
