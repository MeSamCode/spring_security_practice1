package com.mesamcode.spring_security_practice1.repositories;

import com.mesamcode.spring_security_practice1.entities.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AppUserRepository extends JpaRepository<AppUser,Integer> {
    Optional<AppUser> findByUsername(String username);
}
