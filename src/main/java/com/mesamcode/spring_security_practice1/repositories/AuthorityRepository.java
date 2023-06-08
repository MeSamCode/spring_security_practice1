package com.mesamcode.spring_security_practice1.repositories;

import com.mesamcode.spring_security_practice1.entities.AppAuthority;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AuthorityRepository extends JpaRepository<AppAuthority,Integer> {
    Optional<AppAuthority> findByAuthName(String authName);
}
