package com.ayoub.security.controllers;

import com.ayoub.security.dto.MessageDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/admin")
@RequiredArgsConstructor
public class AdminController {

    @GetMapping("")
    public ResponseEntity<MessageDto> printhHello(){
        return ResponseEntity.ok(new MessageDto("hello admin"));
    }
}
