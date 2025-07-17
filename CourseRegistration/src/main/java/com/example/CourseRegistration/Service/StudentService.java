package com.example.CourseRegistration.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.CourseRegistration.Model.StudentDetails;
import com.example.CourseRegistration.Repostiory.StudentRepo;

@Service
public class StudentService {
    @Autowired
    StudentRepo studentRepo;

  
    public List<StudentDetails> getAllStudents() {
        return studentRepo.findAll(); 
    }

    public StudentDetails getbyrollno(int rollno){
        return studentRepo.findById((long)rollno)
        .orElseThrow(()->new RuntimeException("Did not found any values for the rollno:"+rollno));
    }

   
   public StudentDetails addStudent(StudentDetails student) {
    return studentRepo.save(student);
}

   public List<StudentDetails> getbyname(String name) {

      return studentRepo.displaybyname(name);
    
   }
//    public StudentDetails deletestudent(int rollno) {
//     StudentDetails student = studentRepo.findById((long)rollno)
//         .orElseThrow(() -> new RuntimeException("Did not found any values for the rollno:" + rollno));
//     studentRepo.deleteById((long)rollno);
//     return student;
//    }


  public String deletestudent(int rollno) {
    StudentDetails student = studentRepo.findById((long) rollno)
        .orElseThrow(() -> new RuntimeException("No id found to delete: " + rollno));

    studentRepo.delete(student); 
    return "Student with rollno " + rollno + " has been deleted.";
}

    
}
