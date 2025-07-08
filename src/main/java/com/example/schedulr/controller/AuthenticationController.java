package com.example.schedulr.controller;

import com.example.schedulr.db.entity.UserDetails;
import com.example.schedulr.request.models.UserDetailsRequest;
import com.example.schedulr.response.models.UserDetailsResponse;
import com.example.schedulr.service.AuthenticationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/auth")
@Slf4j
public class AuthenticationController {

    @Autowired
    public AuthenticationService authenticationService;

    @PostMapping("/login")
    public ResponseEntity<UserDetailsResponse> login(@RequestBody UserDetailsRequest userDetailsRequest) throws Exception {
        log.info("Login request received: {}", userDetailsRequest);

        UserDetails userInfo = null;
        if (userDetailsRequest.getEmailId() != null) {
            userInfo = authenticationService.findByEmail(userDetailsRequest.getEmailId());
        } else if (userDetailsRequest.getUserName() != null) {
            userInfo = authenticationService.findByUserName(userDetailsRequest.getUserName());
        } else {
            throw new Exception("Email or Username must be provided");
        }

        if (userInfo == null) {
            throw new Exception("User not found");
        }

        if (!userInfo.getPassword().equals(userDetailsRequest.getPassword())) {
            throw new Exception("Incorrect password");
        }

        // Optional: update last login etc.
        userInfo.setLastLogin(LocalDateTime.now());
        authenticationService.saveUserDetails(userInfo);

        UserDetailsResponse response = new UserDetailsResponse(userInfo.getUserId(), userInfo.getEmailId());
        return ResponseEntity.ok(response);
    }

    @PostMapping("/create")
    public ResponseEntity<UserDetailsResponse> createUser(@RequestBody UserDetailsRequest userDetailsRequest) throws Exception {
        log.info("Create user request received: {}", userDetailsRequest);

        // Basic validation
        if ((userDetailsRequest.getEmailId() == null || userDetailsRequest.getEmailId().isEmpty()) &&
                (userDetailsRequest.getUserName() == null || userDetailsRequest.getUserName().isEmpty())) {
            throw new Exception("Email or Username must be provided");
        }
        log.info("Create 1 ");

        if (userDetailsRequest.getPassword() == null || userDetailsRequest.getPassword().isEmpty()) {
            throw new Exception("Password must be provided");
        }
        log.info("Create 2");

        // Check if user already exists
        if (userDetailsRequest.getEmailId() != null && authenticationService.checkIfEmailExists(userDetailsRequest.getEmailId()) != null) {
            throw new Exception("User with this email already exists");
        }
        log.info("Create 3");

        if (userDetailsRequest.getUserName() != null && authenticationService.checkIfNewUserName(userDetailsRequest.getUserName()) != null) {
            throw new Exception("User with this username already exists");
        }
        log.info("Create 4");

        // Create new user entity
        UserDetails newUser = new UserDetails();
        newUser.setUserName(userDetailsRequest.getUserName());
        newUser.setEmailId(userDetailsRequest.getEmailId());
        newUser.setPassword(userDetailsRequest.getPassword());
        newUser.setFullName(userDetailsRequest.getFullName());
        newUser.setIsEnabled(true);
        newUser.setCreatedTs(LocalDateTime.now());
        newUser.setLastLogin(LocalDateTime.now());
        newUser.setModifiedTs(LocalDateTime.now());

        // Save to DB
        UserDetails savedUser = authenticationService.saveUserDetails(newUser);

        // Build response
        UserDetailsResponse response = new UserDetailsResponse(savedUser.getUserId(), savedUser.getEmailId());
        return ResponseEntity.ok(response);
    }


}
