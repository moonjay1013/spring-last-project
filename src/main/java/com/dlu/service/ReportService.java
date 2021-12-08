package com.dlu.service;

import com.dlu.pojo.UserReport;

import java.util.List;

public interface ReportService {
    List<UserReport> findAll();

    void addReport(UserReport userReport);

    void deleteReport(Integer id);

    void updateReport(String content,String title,Integer id);

    UserReport getById(Integer id);
}
