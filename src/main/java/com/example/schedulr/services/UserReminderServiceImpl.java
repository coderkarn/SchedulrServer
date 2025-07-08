package com.example.schedulr.services;

import com.example.schedulr.db.entity.UserReminder;
import com.example.schedulr.repository.UserReminderRepository;
import com.example.schedulr.request.models.UserReminderRequest;
import com.example.schedulr.response.models.UserReminderResponse;
import com.example.schedulr.service.UserReminderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserReminderServiceImpl implements UserReminderService {

    @Autowired
    public UserReminderRepository reminderRepo;

    public String createReminder(UserReminderRequest userReminderRequest) throws Exception{
        UserReminder userReminder =new UserReminder();

        userReminder.setCreatedTs(LocalDateTime.now());
        userReminder.setLastUpdatedTs(LocalDateTime.now());
        userReminder.setUserId(userReminderRequest.getUserId());
        userReminder.setTitle(userReminderRequest.getTitle());
        userReminder.setReminderTime(userReminderRequest.getReminderTime());
        userReminder.setRepeatDaily(userReminderRequest.isRepeatDaily());
        userReminder.setActive(userReminderRequest.isActive());

        reminderRepo.save(userReminder);
        return "SUCCESS";

    }

    public List<UserReminderResponse> getUserReminders(Long userId) throws Exception{
        List <UserReminder> reminders = reminderRepo.findByUserId(userId);

        List<UserReminderResponse> responseList = new ArrayList<>();
        for (UserReminder reminder : reminders) {
            UserReminderResponse response = new UserReminderResponse();
            response.setReminderId(reminder.getReminderId());
            response.setUserId(reminder.getUserId());
            response.setTitle(reminder.getTitle());
            response.setReminderTime(reminder.getReminderTime());
            response.setRepeatDaily(reminder.getRepeatDaily());
            response.setActive(reminder.getActive());
            response.setCreatedTs(reminder.getCreatedTs());
            response.setLastUpdatedTs(reminder.getLastUpdatedTs());

            responseList.add(response);
        }
        return responseList;

    }

}
