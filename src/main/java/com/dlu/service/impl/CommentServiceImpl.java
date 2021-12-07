package com.dlu.service.impl;

import com.dlu.dao.CommentDao;
import com.dlu.pojo.Comments;
import com.dlu.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("CommentService")
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentDao commentDao;

    @Override
    public List<Comments> findAll() {
        return commentDao.findAll();
    }
}
