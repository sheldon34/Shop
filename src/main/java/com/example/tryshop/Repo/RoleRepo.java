package com.example.tryshop.Repo;

import com.example.tryshop.Entity.RolesEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepo extends JpaRepository<RolesEntity,Long> {


    Optional<RolesEntity> findByName(String name);

}
