package com.example.CourseRegistration.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.CourseRegistration.Model.CourseDetails;
import com.example.CourseRegistration.Repostiory.CourseRepo;


@Service
public class CourseService {


    @Autowired
   private CourseRepo courseRepo;

    public CourseDetails addcourse(CourseDetails courseDetails) {

        return courseRepo.save(courseDetails);
        
    }

    public List<CourseDetails> showall() {
    return courseRepo.findAll();
    }
    
}
