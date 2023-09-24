package com.proxym.fraudDetection.controllers;

import com.proxym.fraudDetection.entities.ApplicationUser;
import com.proxym.fraudDetection.entities.LoginResponseDTO;
import com.proxym.fraudDetection.entities.RegistrationDTO;
import com.proxym.fraudDetection.services.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@CrossOrigin("*")
public class AuthenticationController {
    @Autowired
    private AuthenticationService authenticationService;
    @PostMapping("/register")
    public ApplicationUser registerUser(@RequestBody RegistrationDTO body){
        return authenticationService.registerUser(body.getFirstName(),body.getMiddleName(), body.getLastName(), body.getMobileNumber(), body.getEmail(), body.getDateOfBirth(), body.getUsername(), body.getPassword());
    }

    public LoginResponseDTO loginUser(@RequestBody RegistrationDTO body){
        return authenticationService.loginUser(body.getUsername(), body.getPassword());
    }
}
