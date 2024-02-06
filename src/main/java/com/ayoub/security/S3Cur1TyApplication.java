package com.ayoub.security;

import com.ayoub.security.dto.RegisterRequest;
import com.ayoub.security.service.AuthenticationService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import static com.ayoub.security.domain.enums.Role.*;

@SpringBootApplication
@EnableJpaAuditing(auditorAwareRef = "auditorAware")
public class S3Cur1TyApplication {

    public static void main(String[] args) {
        SpringApplication.run(S3Cur1TyApplication.class, args);
    }
    @Bean
    public CommandLineRunner commandLineRunner(AuthenticationService service) {
        return args -> {
            var admin = RegisterRequest.builder()
                    .firstname("Admin")
                    .lastname("Admin")
                    .email("admin@mail.com")
                    .password("123456789")
                    .role(ADMIN)
                    .build();
            System.out.println("Admin token: " + service.register(admin).getAccessToken());

            var manager = RegisterRequest.builder()
                    .firstname("manager")
                    .lastname("manager")
                    .email("manager@mail.com")
                    .password("123456789")
                    .role(MANAGER)
                    .build();
            System.out.println("Manager token: " + service.register(manager).getAccessToken());


            var user = RegisterRequest.builder()
                    .firstname("user")
                    .lastname("user")
                    .email("user@mail.com")
                    .password("123456789")
                    .role(USER)
                    .build();
            System.out.println("User token: " + service.register(user).getAccessToken());

        };
    }
}
