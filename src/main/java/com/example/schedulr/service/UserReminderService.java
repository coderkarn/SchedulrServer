package com.example.schedulr.service;

import com.example.schedulr.request.models.UserReminderRequest;
import com.example.schedulr.response.models.UserReminderResponse;

import java.util.List;

public interface UserReminderService {

    public String createReminder(UserReminderRequest userReminderRequest) throws Exception;

    public List<UserReminderResponse> getUserReminders(Long UserId) throws Exception;
}
