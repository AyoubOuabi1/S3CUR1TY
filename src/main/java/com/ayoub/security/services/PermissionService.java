package com.ayoub.security.services;

import com.ayoub.security.Entity.PermissionEntity;
import com.ayoub.security.repositories.PermissionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PermissionService {

    @Autowired
    private PermissionRepository permissionRepository;

    public PermissionEntity getPermissionByName(String name) {
        return permissionRepository.findByName(name);
    }

    public PermissionEntity savePermission(PermissionEntity permission) {
        return permissionRepository.save(permission);
    }

    public void deletePermission(String name) {
        permissionRepository.deleteByName(name);
    }

    // ... other methods for permission management
}
