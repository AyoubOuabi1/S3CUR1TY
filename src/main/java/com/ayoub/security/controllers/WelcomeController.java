package com.ayoub.security.controllers;


import com.ayoub.security.services.UserService;
import com.ayoub.security.dto.MessageDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/welcome")
@RequiredArgsConstructor
public class WelcomeController {
    private final UserService userService;

    @GetMapping("")
    public ResponseEntity<MessageDto> welcome(){
        return ResponseEntity.ok(this.userService.welcome());
    }
}
