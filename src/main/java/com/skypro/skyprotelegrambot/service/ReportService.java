package com.skypro.skyprotelegrambot.service;

import com.skypro.skyprotelegrambot.entity.Report;
import com.skypro.skyprotelegrambot.entity.Shelter;
import com.skypro.skyprotelegrambot.entity.User;

import java.util.List;

public interface ReportService {
    Report CreateReport(User user, String text, byte[] photo);

    Report getById(Long id);

    List<Report> getAllByUserAndShelter(User user, Shelter shelter);

    void updatePhoto(byte[] photo, Long id);

    void updateText(String text, Long id);

    void deleteReport(Report report);
}