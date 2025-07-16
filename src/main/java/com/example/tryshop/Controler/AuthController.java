package com.example.tryshop.Controler;

import com.example.tryshop.Dto.AuthResponseDto;
import com.example.tryshop.Dto.registerDto;
import com.example.tryshop.Entity.RolesEntity;
import com.example.tryshop.Entity.UseEntity;
import com.example.tryshop.Repo.ProductRepo;
import com.example.tryshop.Repo.RoleRepo;
import com.example.tryshop.Repo.UserRepo;
import com.example.tryshop.Security.TokenGenerator;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;

@AllArgsConstructor
@RestController
@RequestMapping("/api/auth")
public class AuthController {
    private AuthenticationManager authenticationManager;
    private PasswordEncoder passwordEncoder;
    private UserRepo userRepo;
    private RoleRepo roleRepo;

    private TokenGenerator tokenGenerator;


    ///register controller
@PostMapping("/register")

    public ResponseEntity<String> register(@RequestBody registerDto registerdto)
    {

        try{
     if (userRepo.existsByUsername(registerdto.getUsername())){
         return
                 new
                         ResponseEntity<>("Username already exists", HttpStatus.BAD_REQUEST);
     }
        UseEntity user= new UseEntity();
     user.setUsername(registerdto.getUsername());
     user.setPassword(passwordEncoder.encode(registerdto.getPassword()));

        RolesEntity roles=roleRepo.findByName("USER").get();
        user.setRoles(Collections.singletonList(roles));
        userRepo.save(user);

        return
                new
                        ResponseEntity<>("User registered successfully", HttpStatus.OK);
    }
        catch (Exception e){
            throw  new RuntimeException(e.getMessage());
        }
    }

    @PatchMapping("/login")
    public ResponseEntity<AuthResponseDto> login(@RequestBody registerDto registerdto) {
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(registerdto.getUsername(),
                            registerdto.getPassword()));
            SecurityContextHolder.getContext().setAuthentication(authentication);
            String token= tokenGenerator.generateToken(authentication);
            return new ResponseEntity<>(new AuthResponseDto(token), HttpStatus.OK);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
    }



