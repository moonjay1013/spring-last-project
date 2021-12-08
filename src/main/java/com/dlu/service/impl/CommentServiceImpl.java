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

    @Override
    public void addComment(Comments comments) {
        commentDao.save(comments);
    }

    @Override
    public void deleteComment(Integer id) {
        Comments comments = commentDao.getById(id);
        commentDao.delete(comments);
    }

    @Override
    public void updateComment(String comment, Integer id) {
        commentDao.updateComment(comment, id);
    }

    @Override
    public Comments getById(Integer id) {
        return commentDao.getById(id);
    }
}
