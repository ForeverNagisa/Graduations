package com.james.service.impl;

import com.james.bean.Article;
import com.james.bean.Likes;
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

    @Override
    public Article seletPersonByid(Integer id) {
        return dao.seletPersonByid(id);
    }

    @Override
    public List<Article> selectAriticle() {
        return dao.selectAriticle();
    }

    @Override
    public boolean selectIsLikes(Integer id, Integer pid) {
        Likes likes = dao.selectIsLikes(id,pid);
        if (likes != null){
            return true;
        }
        return false;
    }

    @Override
    public void addLikes(Integer id, Integer pid) {
        dao.addLikes(id,pid);

    }

    @Override
    public int seletLikes(Integer id) {
        return dao.seletLikes(id);
    }
}
