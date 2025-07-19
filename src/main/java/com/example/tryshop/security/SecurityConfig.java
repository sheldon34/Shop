//package com.example.tryshop.security;
//
//
//import com.example.tryshop.CorsConfig;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.config.Customizer;
//import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.http.SessionCreationPolicy;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
////import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.web.SecurityFilterChain;
//import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
//
//@Configuration
//@EnableWebSecurity
//
//
//public class SecurityConfig {
//
//
//    private JwtAuthEntryPoint authEntryPoint;
//
//private userDetailService userDetailService;
//private PasswordEncoder passwordEncoder;
//private CorsConfig corsConfig;
//
//    public SecurityConfig(JwtAuthEntryPoint authEntryPoint) {
//        this.authEntryPoint = authEntryPoint;
//    }
//
//    @Bean
//    public SecurityFilterChain filterChain(HttpSecurity http) throws  Exception{
//
//        http
//                .csrf(
//                        csrf->csrf.disable())
//                .exceptionHandling(exeption->
//                        exeption.authenticationEntryPoint(authEntryPoint))
//
//
//                .authorizeHttpRequests(request->
//                        request
//                                .requestMatchers("/api/auth/**").permitAll()
//                                .anyRequest().permitAll())
//
//                .httpBasic(Customizer.withDefaults())
//
//                .sessionManagement(session->
//                        session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
//                .cors(customizer ->customizer.configurationSource(corsConfig))
//                .addFilterBefore(jwtAuthentificationFilter(), UsernamePasswordAuthenticationFilter.class);
//
//        return http.build();
//    }
//
//
//
//    @Bean
//    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
//        return authenticationConfiguration.getAuthenticationManager();
//    }
//    @Bean
//    PasswordEncoder passwordEncoder(){
//        return new BCryptPasswordEncoder();
//
//    }
//
//
//    @Bean
//    public JwtAuthFilter jwtAuthentificationFilter() {
//        return new JwtAuthFilter();
//    }
//
//}
package com.example.tryshop.security;

import com.example.tryshop.CorsConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    private  JwtAuthEntryPoint authEntryPoint;
    private  userDetailService userDetailService;
    private  CorsConfig corsConfig;



    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable())
                .exceptionHandling(ex -> ex.authenticationEntryPoint(authEntryPoint))
                .authorizeHttpRequests(req -> req
                        .requestMatchers("/api/auth/**").permitAll()
                        .anyRequest().authenticated()
                )
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .cors(cors -> cors.configurationSource(corsConfig))
                .addFilterBefore(jwtAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class)
                .httpBasic(Customizer.withDefaults());

        return http.build();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {
        return configuration.getAuthenticationManager();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public JwtAuthFilter jwtAuthenticationFilter() {
        return new JwtAuthFilter();
    }
}
