package com.example.tryshop.security;

import com.example.tryshop.entity.RolesEntity;
import com.example.tryshop.entity.UseEntity;
import com.example.tryshop.repo.UserRepo;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;


@Service
@AllArgsConstructor
public class userDetailService  implements UserDetailsService {
    @Autowired
    private UserRepo userRepo;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        UseEntity use =userRepo.findByUsername(username).orElseThrow(()->
                new UsernameNotFoundException("User not found with username: " + username));




        return new User(use.getUsername(),use.getPassword(),mapRolesToAuthorities(use.getRoles()));


    }
//    private Collection<GrantedAuthority> mapRolesToAuthorities(List<RolesEntity> roles){
//        return roles.stream().map(roles.stream().map(role-> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList()));
//    }
    private Collection<GrantedAuthority> mapRolesToAuthorities(List<RolesEntity> roles){
        return
                roles.stream().map(
                        role->new SimpleGrantedAuthority(role.getName())
                ).collect(Collectors.toSet());
    }
}
