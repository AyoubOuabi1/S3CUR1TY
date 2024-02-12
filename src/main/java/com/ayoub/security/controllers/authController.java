package com.ayoub.security.controllers;

import com.ayoub.security.dto.*;

import com.ayoub.security.services.UserService;
import jakarta.validation.Valid;
import jakarta.validation.ValidationException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth/")
@RequiredArgsConstructor
public class authController {

    private final UserService userService;

    @PostMapping("register")
    public ResponseEntity<MessageDto> register(@Valid @RequestBody RegisterDto registerDto) throws ValidationException{
        return ResponseEntity.ok(userService.register(registerDto));
    }


    @PostMapping("login")
    public ResponseEntity<MessageDto> authenticate(@Valid @RequestBody AuthenticateDto authenticateDto){
        return ResponseEntity.ok(userService.authenticate(authenticateDto));
    }


}
