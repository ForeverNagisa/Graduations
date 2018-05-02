package com.james.service.impl;

import com.james.bean.Article;
import com.james.dao.AriticleDao;
import com.james.service.AriticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AriticleServiceImpl implements AriticleService {
    @Autowired
    private AriticleDao dao;

    // 发表文章
    @Override
    public boolean publishingArtice(Article article) {
        int i = dao.publishingArtice(article);
        if (i > 0){
            return true;
        }
        return false;
    }

    // 查询当前用户所有文章
    @Override
    public List<Article> selectAllAriticle(int id) {

        List<Article> list = dao.selectAllAriticle(id);
        return list;
    }
}
