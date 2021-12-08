package com.dlu.dao;

import com.dlu.pojo.UserReport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;

@Transactional
public interface ReportDao extends JpaRepository<UserReport,Integer> {
    @Modifying
    @Query("update users_report r set r.content = ?1,r.title = ?2 where r.id=?3")
    void updateReport(String content,String title,Integer id);
}
