package com.advancedmappings;

import com.advancedmappings.entity.Instructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InstrctorService {

    @Autowired
    private InstructorRepository instructorRepository;

    public void saveInstructor(Instructor instructor) {
        instructorRepository.save(instructor);
    }
}
