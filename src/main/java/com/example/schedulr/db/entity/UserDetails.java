package com.example.schedulr.db.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@Entity
@Table(name="user_details")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @Column(name = "user_name", nullable = false, unique = true)
    private String userName;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "email_id", nullable = false, unique = true)
    private String emailId;

    @Column(name = "full_name", nullable = false)
    private String fullName;

    @Column(name = "is_enabled")
    private Boolean isEnabled;

    @Column(name = "created_ts")
    private LocalDateTime createdTs;

    //lastlogin
    @Column(name = "last_login")
    private LocalDateTime lastLogin;

    @Column(name = "modified_ts")
    private LocalDateTime modifiedTs;
}