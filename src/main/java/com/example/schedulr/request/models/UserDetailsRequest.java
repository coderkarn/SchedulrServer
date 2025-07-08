package com.example.schedulr.request.models;

import lombok.Data;

@Data
public class UserDetailsRequest {

    private String userName;
    private String password;
    private String emailId;
    private String fullName;
}
