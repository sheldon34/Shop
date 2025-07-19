//package com.example.tryshop.controller;
//
//import com.example.tryshop.dto.AuthResponseDto;
//import com.example.tryshop.dto.registerDto;
//import com.example.tryshop.entity.RolesEntity;
//import com.example.tryshop.entity.UseEntity;
//import com.example.tryshop.repo.RoleRepo;
//import com.example.tryshop.repo.UserRepo;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.Collections;
//
//@RestController
//@RequestMapping("/api/auth")
//public class AuthController {
//    @Autowired
//    private AuthenticationManager authenticationManager;
//    @Autowired
//    private PasswordEncoder passwordEncoder;
//    @Autowired
//    private UserRepo userRepo;
//    @Autowired
//    private RoleRepo roleRepo;
//
//    public AuthController(AuthenticationManager authenticationManager, PasswordEncoder passwordEncoder, UserRepo userRepo, RoleRepo roleRepo) {
//        this.authenticationManager = authenticationManager;
//        this.passwordEncoder = passwordEncoder;
//        this.userRepo = userRepo;
//        this.roleRepo = roleRepo;
//    }
//
////    private TokenGenerator tokenGenerator;
//
//
//    /// register controller
//    @PostMapping("/register")
//
//    public ResponseEntity<String> register(@RequestBody registerDto registerdto) {
//
//        try {
//            if (userRepo.existsByUsername(registerdto.getUsername())) {
//                return
//                        new
//                                ResponseEntity<>("Username already exists", HttpStatus.BAD_REQUEST);
//            }
//            UseEntity user = new UseEntity();
//            user.setUsername(registerdto.getUsername());
//            user.setPassword(passwordEncoder.encode(registerdto.getPassword()));
//
//            RolesEntity roles = roleRepo.findByName("USER").get();
//            user.setRoles(Collections.singletonList(roles));
//            userRepo.save(user);
//
//            return
//                    new
//                            ResponseEntity<>("User registered successfully", HttpStatus.OK);
//        } catch (Exception e) {
//            throw new RuntimeException(e.getMessage());
//        }
//    }
//
//    @PatchMapping("/login")
//    public ResponseEntity<AuthResponseDto> login(@RequestBody registerDto registerdto) {
//        try {
//            Authentication authentication = authenticationManager.authenticate(
//                    new UsernamePasswordAuthenticationToken(registerdto.getUsername(),
//                            registerdto.getPassword()));
//            SecurityContextHolder.getContext().setAuthentication(authentication);
//            String token = "";//tokenGenerator.generateToken(authentication);
//            return new ResponseEntity<>(new AuthResponseDto(token), HttpStatus.OK);
//        } catch (Exception e) {
//            throw new RuntimeException(e.getMessage());
//        }
//    }
//}
//
//
//
package com.example.tryshop.controller;

import com.example.tryshop.dto.AuthResponseDto;
import com.example.tryshop.dto.registerDto;
import com.example.tryshop.entity.RolesEntity;
import com.example.tryshop.entity.UseEntity;
import com.example.tryshop.repo.RoleRepo;
import com.example.tryshop.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;

@RestController
@RequestMapping("/api/auth")
public class AuthController {


    private AuthenticationManager authenticationManager;


    private PasswordEncoder passwordEncoder;


    private UserRepo userRepo;


    private RoleRepo roleRepo;

    /// register controller
    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody registerDto registerdto) {
        try {
            if (userRepo.existsByUsername(registerdto.getUsername())) {
                return new ResponseEntity<>("Username already exists", HttpStatus.BAD_REQUEST);
            }
            UseEntity user = new UseEntity();
            user.setUsername(registerdto.getUsername());
            user.setPassword(passwordEncoder.encode(registerdto.getPassword()));

            RolesEntity roles = roleRepo.findByName("USER").get();
            user.setRoles(Collections.singletonList(roles));
            userRepo.save(user);

            return new ResponseEntity<>("User registered successfully", HttpStatus.OK);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @PatchMapping("/login")
    public ResponseEntity<AuthResponseDto> login(@RequestBody registerDto registerdto) {
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(registerdto.getUsername(),
                            registerdto.getPassword()));
            SecurityContextHolder.getContext().setAuthentication(authentication);
            String token = ""; // tokenGenerator.generateToken(authentication);
            return new ResponseEntity<>(new AuthResponseDto(token), HttpStatus.OK);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
