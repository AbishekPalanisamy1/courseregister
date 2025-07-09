package com.example.CourseRegistration.Service;


import com.example.CourseRegistration.Model.StudentDetails;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class JwtService {

    private final String SECRET_KEY = "secretkey123";

    public String generateToken(StudentDetails user) {
        return Jwts.builder()
                .setSubject(user.getName())
                .claim("role", user.getRole())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60)) // 1 hour
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
                .compact();
    }

    public String extractUsername(String token) {
        return Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody().getSubject();
    }
public boolean validateToken(String token, StudentDetails user) {
    final String username = extractUsername(token);
    return (username.equals(user.getName()) && !isTokenExpired(token));
}

private boolean isTokenExpired(String token) {
    return Jwts.parser().setSigningKey(SECRET_KEY)
            .parseClaimsJws(token)
            .getBody()
            .getExpiration()
            .before(new Date());
}


}
