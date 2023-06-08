package com.mesamcode.spring_security_practice1.services;

import com.mesamcode.spring_security_practice1.entities.AppAuthority;
import com.mesamcode.spring_security_practice1.entities.AppUser;
import com.mesamcode.spring_security_practice1.repositories.AppUserRepository;
import com.mesamcode.spring_security_practice1.repositories.AuthorityRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@Transactional
@AllArgsConstructor
public class SecurityDaoService {
    private final AppUserRepository userRepository;
    private final AuthorityRepository authorityRepository;
    private BCryptPasswordEncoder passwordEncoder;
    public AppUser addUser(AppUser user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    public AppAuthority addAuthority(String authName) {
        if (!authName.isBlank() || authName != null) {
            AppAuthority authority = AppAuthority.builder().authName(authName).build();
            return authorityRepository.save(authority);
        }else {
            return null;
        }

    }

    public void addAuthorityToUser(String username, String authName){
        AppUser user=userRepository.findByUsername(username).
                orElseThrow(() -> new UsernameNotFoundException("No user with this name exists!"));
        AppAuthority authority=authorityRepository.findByAuthName( authName)
                .orElseThrow(() -> new RuntimeException("This authority doesn't exists!"));
        user.getAuthorities().add(authority);
    }
}
