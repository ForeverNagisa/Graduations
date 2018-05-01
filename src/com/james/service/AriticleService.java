package com.james.service;

import com.james.bean.Article;

import java.util.List;

public interface AriticleService {

    boolean publishingArtice(Article article);


    List<Article> selectAllAriticle();
}
