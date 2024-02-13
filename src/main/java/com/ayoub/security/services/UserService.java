package com.ayoub.security.services;

import com.ayoub.security.Entity.RoleEntity;
import com.ayoub.security.Entity.User;
import com.ayoub.security.config.JwtService;

import com.ayoub.security.repositories.UserRepository;
import com.ayoub.security.dto.*;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.ValidationException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    private final RoleService roleService;

    public User findUserByUsername(String username) throws EntityNotFoundException {
        User user = this.userRepository.findByEmail(username).get();
        if(user==null) throw new EntityNotFoundException("user not found !");
        return user;
    }
    public MessageDto register(RegisterDto registerDto) throws ValidationException {
        Optional<User> existingUser = this.userRepository.findByEmail(registerDto.getEmail());
        if(existingUser.isPresent()) throw new ValidationException("This email already exists !");
        RoleEntity userRole = roleService.getRoleByName("USER");

        User user = User.builder()
                .username(registerDto.getUsername())
                .email(registerDto.getEmail())
                .roles(Collections.singleton(userRole))
                .password(passwordEncoder.encode(registerDto.getPassword()))
                .build();
        this.userRepository.save(user);
        return new MessageDto(jwtService.generateToken(user));
    }
    public MessageDto authenticate(AuthenticateDto authenticateDto){
        this.authenticationManager.authenticate(
           new UsernamePasswordAuthenticationToken(authenticateDto.getEmail(), authenticateDto.getPassword())
        );
        User user = this.findUserByUsername(authenticateDto.getEmail());
        return new MessageDto(jwtService.generateToken(user));
    }


}
