package com.example.tryshop.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.util.Date;
@Component
public class TokenGenerator {
    public String generateToken(Authentication authentication) {

        String username= authentication.getName();
        Date currentDate = new Date();
        Date expiryDate = new Date(currentDate.getTime() + SecurityConstants.JWTexpiration);


        String token = Jwts.builder()
                .setSubject(username)
                .setIssuedAt(currentDate)
                .setExpiration(expiryDate)
                .signWith(SignatureAlgorithm.HS512,SecurityConstants.JWTsecret)
                .compact();
        return token;
    }
/// geting the username from the token
    public String getUsernameFromToken(String token){
        Claims claims = Jwts.parser()
                .setSigningKey(SecurityConstants.JWTsecret)
                .build()
                .parseClaimsJws(token)
                .getBody();
        return claims.getSubject();



    }

    ///  validate the token
    public boolean validateToken(String token) {
        try {
            Jwts.parser().setSigningKey(SecurityConstants.JWTsecret);
            return true;
        } catch (Exception e) {

            throw new AuthenticationCredentialsNotFoundException("Invalid JWT token" + e.getMessage());
        }
    }

}
