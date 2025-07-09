package com.example.CourseRegistration.Repostiory;


import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.CourseRegistration.Model.StudentDetails;

public interface StudentRepo extends JpaRepository<StudentDetails,Long>{


    @Query(nativeQuery = true,
   value="SELECT * FROM student_details  WHERE name = :name")
   List< StudentDetails> displaybyname(@Param("name") String name);

    
    Optional<StudentDetails> findByName(String name);
}
