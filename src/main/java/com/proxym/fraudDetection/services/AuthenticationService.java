package com.proxym.fraudDetection.services;

import com.proxym.fraudDetection.entities.ApplicationUser;
import com.proxym.fraudDetection.entities.LoginResponseDTO;
import com.proxym.fraudDetection.entities.Role;
import com.proxym.fraudDetection.repositories.AuthUserRepository;
import com.proxym.fraudDetection.repositories.RoleRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

@Service
@Transactional
public class AuthenticationService {
    @Autowired
    private AuthUserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private TokenService tokenService;

    public ApplicationUser registerUser(String firstName, String middleName, String lastName, long mobileNo, String email, Date dateOfBirth, String username, String password){
        String encodedPassword = passwordEncoder.encode(password);
        Role userRole = roleRepository.findByAuthority("USER").get();
        Set<Role> authorities = new HashSet<>();

        authorities.add(userRole);
        return userRepository.save(new ApplicationUser(0,username,encodedPassword,firstName,middleName,lastName,mobileNo,email,dateOfBirth,authorities));
    }

    public LoginResponseDTO loginUser(String username, String password){
        try{
            Authentication auth = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(username,password));
                    String token = tokenService.generateJwt(auth);
                    return new LoginResponseDTO(userRepository.findByUsername(username).get(),token);
        }catch (AuthenticationException e){
            return new LoginResponseDTO(null,"");
        }
    }
}
