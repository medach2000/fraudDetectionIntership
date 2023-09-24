package com.proxym.fraudDetection.services;

import com.proxym.fraudDetection.entities.User;
import com.proxym.fraudDetection.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User createUser(User user) {


        return userRepository.save(user);

    }

    public List<User> getUsers()
    {
        return userRepository.findAll();
    }
}
