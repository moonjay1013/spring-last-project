package com.dlu.dao;

import com.dlu.pojo.Comments;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentDao extends JpaRepository<Comments,Integer> {
}
