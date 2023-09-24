package com.proxym.fraudDetection.controllers;

import com.proxym.fraudDetection.entities.Account;
import com.proxym.fraudDetection.entities.ServiceRequest;
import com.proxym.fraudDetection.entities.User;
import com.proxym.fraudDetection.services.AccountService;
import com.proxym.fraudDetection.services.ServiceRequestService;
import com.proxym.fraudDetection.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
@CrossOrigin("*")
public class AdminController {
    @Autowired
    ServiceRequestService requestService;
    @Autowired
    UserService userService;
    @Autowired
    AccountService accountService;

    @GetMapping(value = "/servicerequests", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ServiceRequest>> view(){
        List<ServiceRequest> requests = requestService.getRequests();
        return ResponseEntity.ok(requests);
    }
    @DeleteMapping(value = "/servicerequestq/{id}")
    public ResponseEntity<String> deleteRequest(@PathVariable("id") int id){
        requestService.deleteRequest(id);
        return ResponseEntity.ok("Deleted");
    }
    public ResponseEntity<String> acceptrequest(@PathVariable("id") int id){
        ServiceRequest req = requestService.getRequest(id);
        Account account = new Account();
        Account account1 = accountService.createAccount(account);
        System.out.println(account1.getAccountId());
        User user =req.getUser();
        user.setAccount(account1);
        System.out.println(user.getAccount());
        userService.createUser(user);
        requestService.deleteRequest(id);
        return ResponseEntity.ok("Approved");
    }
}
