package com.example.CourseRegistration.Model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name="course")
public class CourseDetails {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)

    private int id;

    private String coursename;

    private String Techstack;
    
}
