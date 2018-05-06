package com.james.service.impl;

import com.james.bean.Comments;
import com.james.dao.CommentDao;
import com.james.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    private CommentDao dao;

    @Override
    public void insertComment(Comments comments) {
        dao.insertComment(comments);
    }

    @Override
    public List<Comments> selectPersonArticle(int i) {
        return dao.selectPersonArticle(i);
    }


    @Override
    public void deleteCommentById(Integer id) {
        dao.deleteCommentById(id);
    }

    @Override
    public void deletArtic(Integer id) {
        dao.deletArtic(id);

    }
}
