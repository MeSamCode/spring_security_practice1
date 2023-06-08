package com.mesamcode.spring_security_practice1;

import com.mesamcode.spring_security_practice1.entities.AppAuthority;
import com.mesamcode.spring_security_practice1.entities.AppUser;
import com.mesamcode.spring_security_practice1.services.SecurityDaoService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringSecurityPractice1Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringSecurityPractice1Application.class, args);
    }

    @Bean
    CommandLineRunner runner(SecurityDaoService daoService){
        return args -> {
            AppUser user1=daoService.addUser(AppUser.builder().id(null).username("user1").password("1234").build());
            AppUser user2=daoService.addUser(AppUser.builder().id(null).username("user2").password("2345").build());
            AppAuthority readAuth=daoService.addAuthority("read");
            AppAuthority writeAuth=daoService.addAuthority("write");
            AppAuthority deleteAuth=daoService.addAuthority("delete");
            AppAuthority executeAuth=daoService.addAuthority("execute");

            daoService.addAuthorityToUser(user1.getUsername(),readAuth.getAuthName());
            daoService.addAuthorityToUser(user2.getUsername(),readAuth.getAuthName());
            daoService.addAuthorityToUser(user2.getUsername(),writeAuth.getAuthName());

        };
    }

}
