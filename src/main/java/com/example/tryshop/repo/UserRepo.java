package com.example.tryshop.repo;

import com.example.tryshop.entity.UseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface UserRepo extends JpaRepository<UseEntity,Long> {
    Optional<UseEntity> findByUsername(String username);
    Boolean existsByUsername(String username);
}
