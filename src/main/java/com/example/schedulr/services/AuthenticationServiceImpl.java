package com.example.schedulr.services;

import com.example.schedulr.db.entity.UserDetails;
import com.example.schedulr.db.entity.UserReminder;
import com.example.schedulr.repository.UserDetailsRepository;
import com.example.schedulr.repository.UserReminderRepository;
import com.example.schedulr.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {

    @Autowired
    public UserDetailsRepository userRepo;

    public UserDetails findByUserName(String userName) {
        UserDetails user = userRepo.checkCredentials(userName);
        if (user == null) {
            throw new UsernameNotFoundException("User not found with username: " + userName);
        }
        return user;
    }

    public UserDetails findByEmail(String emailId) {
        UserDetails user = userRepo.checkEmail(emailId);
        if (user == null) {
            throw new UsernameNotFoundException("User not found with email: " + emailId);
        }
        return user;
    }

    public UserDetails checkIfEmailExists(String emailId) {
        return userRepo.checkEmail(emailId);
    }

    public UserDetails checkIfNewUserName(String userName) {
        return userRepo.checkCredentials(userName);
    }

    public UserDetails saveUserDetails(UserDetails userDetails) throws Exception{
        return userRepo.save(userDetails);
    }

}
