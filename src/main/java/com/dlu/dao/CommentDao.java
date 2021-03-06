package com.dlu.dao;

import com.dlu.pojo.Comments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;

@Transactional
public interface CommentDao extends JpaRepository<Comments,Integer> {
    @Modifying
    @Query("update comments c set c.comment = ?1 where c.id = ?2")
    void updateComment(String comment,Integer id);
}
