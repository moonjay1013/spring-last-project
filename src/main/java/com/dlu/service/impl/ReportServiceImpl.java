package com.dlu.service.impl;

import com.dlu.dao.ReportDao;
import com.dlu.pojo.UserReport;
import com.dlu.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("ReportService")
public class ReportServiceImpl implements ReportService {

    @Autowired
    private ReportDao reportDao;

    @Override
    public List<UserReport> findAll() {
        return reportDao.findAll();
    }

    @Override
    public void addReport(UserReport userReport) {
        reportDao.save(userReport);
    }

    @Override
    public void deleteReport(Integer id) {
        UserReport userReport = reportDao.getById(id);
        reportDao.delete(userReport);
    }

    @Override
    public void updateReport(String content, String title, Integer id) {
        reportDao.updateReport(content, title, id);
    }

    @Override
    public UserReport getById(Integer id) {
        return reportDao.getById(id);
    }
}
