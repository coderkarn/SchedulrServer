package com.example.schedulr.controller;

import com.example.schedulr.request.models.UserReminderRequest;
import com.example.schedulr.response.models.UserReminderResponse;
import com.example.schedulr.service.UserReminderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/reminder")
public class UserReminderController {

    @Autowired
    UserReminderService reminderService;

    @PostMapping("/create")
    public ResponseEntity<String> createReminder(@RequestBody UserReminderRequest userReminderRequest) throws Exception {
        try {
            String status = reminderService.createReminder(userReminderRequest);
            return ResponseEntity.ok(status);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/get/{userId}")
    public ResponseEntity<List<UserReminderResponse>> getUserReminders(@PathVariable Long userId) throws Exception {
        try {
            List<UserReminderResponse> events = reminderService.getUserReminders(userId);
            return ResponseEntity.ok(events);
        } catch (Exception e) {
            log.error("Error fetching user events for userId {}: {}", userId, e.getMessage());
            return ResponseEntity.badRequest().build();
        }
    }



}
