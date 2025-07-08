package com.example.schedulr.controller;

import com.example.schedulr.db.entity.UserDetails;
import com.example.schedulr.repository.UserDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserDetailsController {

    @Autowired
    private UserDetailsRepository userRepo;

    @PostMapping
    public UserDetails createUser(@RequestBody UserDetails userDetails){
        return userRepo.save(userDetails);
    }

    @GetMapping
    public List<UserDetails> getAllUsers(){
        return userRepo.findAll();
    }

}
