package com.example.schedulr.response.models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserDetailsResponse {

    private Long userId;
    private String emailId;

}
