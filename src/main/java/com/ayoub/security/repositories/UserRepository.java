package com.ayoub.security.repositories;

import com.ayoub.security.dto.CustomUserDetails;
import com.ayoub.security.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public
interface UserRepository extends JpaRepository<User,Long> {
    public Optional<User> findByUsername(String email);

}
