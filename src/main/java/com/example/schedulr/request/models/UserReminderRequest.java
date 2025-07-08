package com.example.schedulr.request.models;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class UserReminderRequest {
    private Long userId;
    private String title;
    private LocalDateTime reminderTime;
    private boolean repeatDaily;
    private boolean active;
}