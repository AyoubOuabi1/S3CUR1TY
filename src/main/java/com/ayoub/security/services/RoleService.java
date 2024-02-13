package com.ayoub.security.services;

import com.ayoub.security.Entity.RoleEntity;
import com.ayoub.security.repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class RoleService {

    @Autowired
    private RoleRepository roleRepository;

    public RoleEntity getRoleByName(String name) {
        return roleRepository.findByName(name);
    }

    public RoleEntity saveRole(RoleEntity role) {
        return roleRepository.save(role);
    }

    public void deleteRole(String name) {
        roleRepository.deleteByName(name);
    }


}
