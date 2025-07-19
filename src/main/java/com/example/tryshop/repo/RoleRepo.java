package com.example.tryshop.repo;

import com.example.tryshop.entity.RolesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface RoleRepo extends JpaRepository<RolesEntity,Long> {


    Optional<RolesEntity> findByName(String name);

}
