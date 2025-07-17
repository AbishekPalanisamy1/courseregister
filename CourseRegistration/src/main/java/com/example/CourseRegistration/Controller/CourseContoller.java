package com.example.CourseRegistration.Controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.CourseRegistration.Model.CourseDetails;
import com.example.CourseRegistration.Service.CourseService;
@RestController
@RequestMapping("/public")
public class CourseContoller {
    @Autowired
   private CourseService courseService;
    @PostMapping("/addcourse")
    public CourseDetails addcourse(@RequestBody CourseDetails courseDetails){
        return courseService.addcourse(courseDetails);
    }
    @GetMapping("/showcourse")
    public List<CourseDetails> showwall(){
        return courseService.showall();
    }
}
