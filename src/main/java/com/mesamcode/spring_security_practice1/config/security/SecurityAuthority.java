package com.mesamcode.spring_security_practice1.config.security;

import com.mesamcode.spring_security_practice1.entities.AppAuthority;
import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

@AllArgsConstructor
public class SecurityAuthority implements GrantedAuthority {
    private final AppAuthority authority;
    @Override
    public String getAuthority() {
        return authority.getAuthName();
    }
}
