package com.advancedmappings;

import com.advancedmappings.entity.Instructor;
import org.springframework.data.jpa.repository.JpaRepository;


public interface InstructorRepository extends JpaRepository<Instructor, Long> {
}
