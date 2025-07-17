package com.example.CourseRegistration.Repostiory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.CourseRegistration.Model.CourseDetails;

@Repository
public interface CourseRepo extends JpaRepository<CourseDetails,Integer>{

    
}
