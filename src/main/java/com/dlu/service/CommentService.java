package com.dlu.service;

import com.dlu.pojo.Comments;

import java.util.List;

public interface CommentService {
    List<Comments> findAll();

    void addComment(Comments comments);

    void deleteComment(Integer id);

    void updateComment(String comment,Integer id);

    Comments getById(Integer id);
}
