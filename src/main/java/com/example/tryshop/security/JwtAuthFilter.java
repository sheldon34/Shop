package com.example.tryshop.security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;


public class JwtAuthFilter extends OncePerRequestFilter {

    private TokenGenerator tokenGenerator;
    private userDetailService userDetailService;

    public JwtAuthFilter() {
        this.tokenGenerator = tokenGenerator;
        this.userDetailService = userDetailService;
    }


    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

String token=getJWTFromRequest(request);
if (StringUtils.hasText(token)&& tokenGenerator.validateToken(token)) {
    String username=tokenGenerator.getUsernameFromToken(token);

    UserDetails userDetails = userDetailService.loadUserByUsername(username);
    UsernamePasswordAuthenticationToken authentication= new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
    authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
    SecurityContextHolder.getContext().setAuthentication(authentication);
}

        filterChain.doFilter(request, response);
    }
    private String getJWTFromRequest(HttpServletRequest request){
        String bearerToken=request.getHeader("Authorization");
        if (StringUtils.hasText(bearerToken)&&bearerToken.startsWith("Bearer ")){
            return bearerToken.substring(7,bearerToken.length());

        }
        return  null;
    }
}
