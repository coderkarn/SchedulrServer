package com.example.schedulr.services;

import com.example.schedulr.db.entity.UserReminder;
import com.example.schedulr.repository.UserReminderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ReminderNotificationService {

    @Autowired
    private UserReminderRepository reminderRepo;

    @Autowired
    private JavaMailSender mailSender;

    // Runs every minute
    @Scheduled(fixedRate = 60000)
    public void sendUpcomingReminderEmails() {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime targetTime = now.plusMinutes(15);

        List<UserReminder> upcomingReminders = reminderRepo.findUpcomingReminders(now, targetTime);
        for (UserReminder reminder : upcomingReminders) {
            try {
                sendEmail(reminder);
                System.out.println("Email sent for reminder: " + reminder.getTitle());
            } catch (Exception e) {
                System.err.println("Failed to send email for reminder: " + reminder.getTitle());
                e.printStackTrace();
            }
        }
    }

    private void sendEmail(UserReminder reminder) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo("sauravkarn02@gmail.com"); // TODO: get user's actual email
        message.setSubject("Reminder: " + reminder.getTitle());
        message.setText("You have a reminder scheduled at " + reminder.getReminderTime() + "\nTitle: " + reminder.getTitle());
        mailSender.send(message);
    }
}
