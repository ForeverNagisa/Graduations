package com.james.dao;

import com.james.bean.Article;
import com.james.bean.Likes;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AriticleDao {
    int publishingArtice(Article article);

    List<Article> selectAllAriticle(int id);

    Article seletPersonByid(Integer id);

    List<Article> selectAriticle();

    Likes selectIsLikes(@Param("id") Integer id, @Param("pid") Integer pid);

    void addLikes(@Param("id") Integer id, @Param("pid") Integer pid);

    int seletLikes(Integer id);
}
