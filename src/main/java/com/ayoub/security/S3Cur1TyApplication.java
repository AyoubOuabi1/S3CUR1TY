package com.ayoub.security;


import com.ayoub.security.Entity.PermissionEntity;
import com.ayoub.security.Entity.RoleEntity;
import com.ayoub.security.services.PermissionService;
import com.ayoub.security.services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.Set;

@SpringBootApplication
public class S3Cur1TyApplication {

    @Autowired
    PermissionService permissionService;

    @Autowired
    RoleService roleService;
    public static void main(String[] args) {
        SpringApplication.run(S3Cur1TyApplication.class, args);
    }

    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();
        config.addAllowedOrigin("*");
        config.addAllowedMethod("*");
        config.addAllowedHeader("*");
        source.registerCorsConfiguration("/**", config);

        return new CorsFilter(source);
    }

    /*@Bean
    CommandLineRunner configRunner(){
        return (args) -> {
            PermissionEntity createUserPermission = permissionService.savePermission(
                    PermissionEntity.builder()
                            .name("CREATE_USER")
                            .build()
            );
            PermissionEntity readUserPermission = permissionService.savePermission(
                    PermissionEntity.builder()
                            .name("READ_USER")
                            .build()
            );
            PermissionEntity updateUserPermission = permissionService.savePermission(
                    PermissionEntity.builder()
                            .name("UPDATE_USER")
                            .build()
            );
            PermissionEntity deleteUserPermission = permissionService.savePermission(
                    PermissionEntity.builder()
                            .name("DELETE_USER")
                            .build()
            );

            RoleEntity adminRole = roleService.saveRole(
                    RoleEntity.builder()
                         .name("ADMIN")
                         .permissions(Set.of(createUserPermission, readUserPermission, updateUserPermission, deleteUserPermission))
                         .build()
            );
            RoleEntity userRole = roleService.saveRole(
                    RoleEntity.builder()
                       .name("USER")
                       .permissions(Set.of(createUserPermission, readUserPermission))
                       .build()
            );
        };
    }*/
}
