package com.example.schedulr.service;

import com.example.schedulr.db.entity.UserDetails;

public interface AuthenticationService {

    public UserDetails findByUserName(String userName) throws Exception;
    public UserDetails findByEmail(String email) throws Exception;
    public UserDetails checkIfNewUserName(String userName);
    public UserDetails checkIfEmailExists(String email);
    public UserDetails saveUserDetails(UserDetails userDetails) throws Exception;
}
