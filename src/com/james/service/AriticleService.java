package com.james.service;

import com.james.bean.Article;

import java.util.List;

public interface AriticleService {

    boolean publishingArtice(Article article);


    List<Article> selectAllAriticle(int id);

    Article seletPersonByid(Integer id);

    List<Article> selectAriticle();

    boolean selectIsLikes(Integer id, Integer pid);

    void addLikes(Integer id, Integer pid);

    int seletLikes(Integer id);
}
