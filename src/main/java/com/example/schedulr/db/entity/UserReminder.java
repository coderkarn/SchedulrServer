package com.example.schedulr.db.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@Table(name = "user_reminders")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserReminder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reminderId;

    @Column(name = "user_id", nullable = false)
    private Long userId;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "reminder_time", nullable = false)
    private LocalDateTime reminderTime;

    @Column(name = "repeat_daily", nullable = false)
    private Boolean repeatDaily;

    @Column(name = "active")
    private Boolean active;

    @Column(name = "created_ts")
    private LocalDateTime createdTs;

    @Column(name = "last_updated_ts")
    private LocalDateTime lastUpdatedTs;
}