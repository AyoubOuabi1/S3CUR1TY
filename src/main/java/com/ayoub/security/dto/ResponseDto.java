package com.ayoub.security.dto;

import com.ayoub.security.Entity.RoleEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ResponseDto {
    private String username;
    private String email;
    private String accessToken;
    private String role;
    private Set<String> permissions;
}
