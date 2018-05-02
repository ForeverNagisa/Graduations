package com.james.dao;

import com.james.bean.Article;

import java.util.List;

public interface AriticleDao {
    int publishingArtice(Article article);

    List<Article> selectAllAriticle(int id);
}
