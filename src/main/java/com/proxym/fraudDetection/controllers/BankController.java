package com.proxym.fraudDetection.controllers;

import com.proxym.fraudDetection.entities.Account;
import com.proxym.fraudDetection.entities.ServiceRequest;
import com.proxym.fraudDetection.entities.User;
import com.proxym.fraudDetection.services.BankService;
import com.proxym.fraudDetection.services.ServiceRequestService;
import com.proxym.fraudDetection.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class BankController {
    @Autowired
    private BankService bankService;
    @Autowired
    private UserService userService;
    @Autowired
    private ServiceRequestService serviceRequestService;

    public ResponseEntity<String> home(){
        return ResponseEntity.ok("home");
    }

    //Only Admin
    @PostMapping("/user")
    public ResponseEntity<User> createUser(@RequestBody User user){
        User user1 = userService.createUser(user);
        ServiceRequest serviceRequest = new ServiceRequest();
        serviceRequest.setUser(user1);
        serviceRequest.setApproval(false);
        serviceRequestService.createRequest(serviceRequest);
        return ResponseEntity.ok(user1);
    }

    @GetMapping("/user")
    public ResponseEntity<List<User>> displayUser()
    {

        return ResponseEntity.ok( userService.getUsers());
    }

    @PostMapping("/account")
    public ResponseEntity<Account> createAccount(@RequestBody Account account) {
        Account newAccount = bankService.createAccount(account);
        return ResponseEntity.ok(newAccount);
    }

    @GetMapping(value="/account/{accountId}")
    public ResponseEntity<Account> getAccount(@PathVariable("accountId") int accountId) {
        Account account = bankService.getAccount(accountId);
        return ResponseEntity.ok(account);
    }
}
