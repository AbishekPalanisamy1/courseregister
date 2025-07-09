package com.example.CourseRegistration.Controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.CourseRegistration.Model.StudentDetails;
import com.example.CourseRegistration.Service.StudentService;

@RestController
@RequestMapping("/api")
public class StudentController {

    @Autowired
    private StudentService studentService;

    // Display all the Student Details
     @GetMapping("/showall")
    public List<StudentDetails> getAllStudents() {
        return studentService.getAllStudents();
    }

    // Display the Detrails of the particular rollno
    @GetMapping("/getbyrollno/{rollno}")
    public StudentDetails getbyrollno(@PathVariable int rollno){
        return studentService.getbyrollno(rollno);
    }

    // Used to add the details of the students
    @PostMapping("/addstudent")
    public StudentDetails addStudent(@RequestBody StudentDetails student) {
         return studentService.addStudent(student);
    }

    // Used to display the particular details by using their name 
    @GetMapping("/getbyname/{name}")
    public List<StudentDetails>getbyname(@PathVariable String name){
        return studentService.getbyname(name);
    }
    @DeleteMapping("/delete/{rollno}")
    public String deletestudent(@PathVariable int rollno) {
      return studentService.deletestudent(rollno);
}


}
