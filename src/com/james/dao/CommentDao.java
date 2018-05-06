package com.james.dao;

import com.james.bean.Comments;

import java.util.List;

public interface CommentDao {
    void insertComment(Comments comments);

    List<Comments> selectPersonArticle(int i);

    void deleteCommentById(Integer id);

    void deletArtic(Integer id);
}
