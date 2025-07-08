package com.example.schedulr.repository;

import com.example.schedulr.db.entity.UserReminder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface UserReminderRepository extends JpaRepository<UserReminder, Long> {

    List<UserReminder> findByUserId(Long userId);

    @Query("SELECT r FROM UserReminder r WHERE r.active = true AND r.reminderTime BETWEEN :now AND :targetTime")
    List<UserReminder> findUpcomingReminders(LocalDateTime now, LocalDateTime targetTime);

}
