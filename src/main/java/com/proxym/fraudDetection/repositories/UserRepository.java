package com.proxym.fraudDetection.repositories;

import com.proxym.fraudDetection.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {
    User getByEmail(String email);
}
