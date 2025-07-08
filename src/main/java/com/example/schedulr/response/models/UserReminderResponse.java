package com.example.schedulr.response.models;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class UserReminderResponse {
    private Long reminderId;
    private Long userId;
    private String title;
    private LocalDateTime reminderTime;
    private boolean repeatDaily;
    private boolean active;
    private LocalDateTime createdTs;
    private LocalDateTime lastUpdatedTs;
}