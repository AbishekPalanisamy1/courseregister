package com.example.CourseRegistration.Service;


import com.example.CourseRegistration.Model.StudentDetails;
import com.example.CourseRegistration.Repostiory.StudentRepo;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private StudentRepo studentRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        StudentDetails student = studentRepo.findByName(username)
            .orElseThrow(() -> new UsernameNotFoundException("User not found: " + username));
return new org.springframework.security.core.userdetails.User(
    student.getName(),
    student.getPassword(),
    List.of(new SimpleGrantedAuthority("ROLE_" + student.getRole()))
);

    }
}