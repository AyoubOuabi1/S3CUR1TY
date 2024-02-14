package com.ayoub.security.mappers;

import com.ayoub.security.Entity.PermissionEntity;
import com.ayoub.security.Entity.RoleEntity;
import com.ayoub.security.Entity.User;
import com.ayoub.security.dto.ResponseDto;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UserMapper {
    public ResponseDto mapUserToResponseDTO(User user) {
        Set<String> permissionNames = user.getPermissions().stream()
                .map(PermissionEntity::getName)
                .collect(Collectors.toSet());

        return new ResponseDto(
                user.getUsername(),
                user.getEmail(),
                null,
                user.getRoles().stream().findFirst().map(RoleEntity::getName).orElse(null),
                permissionNames
        );
    }
}
