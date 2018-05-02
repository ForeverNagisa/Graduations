package com.james.bean;

import java.util.Date;

public class Article {
    private int art_id,person_id;
    private String art_title,art_content,art_img,art_time;

    public Article(){

    }

    public Article(int art_id, int person_id, String art_title, String art_content) {
        this.art_id = art_id;
        this.person_id = person_id;
        this.art_title = art_title;
        this.art_content = art_content;
    }

    public int getArt_id() {
        return art_id;
    }

    public void setArt_id(int art_id) {
        this.art_id = art_id;
    }

    public int getPerson_id() {
        return person_id;
    }

    public void setPerson_id(int person_id) {
        this.person_id = person_id;
    }

    public String getArt_title() {
        return art_title;
    }

    public void setArt_title(String art_title) {
        this.art_title = art_title;
    }

    public String getArt_content() {
        return art_content;
    }

    public void setArt_content(String art_content) {
        this.art_content = art_content;
    }

    public String getArt_img() {
        return art_img;
    }

    public void setArt_img(String art_img) {
        this.art_img = art_img;
    }


    public String getArt_time() {
        return art_time;
    }

    public void setArt_time(String art_time) {
        this.art_time = art_time;
    }

    @Override
    public String toString() {
        return "Article{" +
                "art_id=" + art_id +
                ", person_id=" + person_id +
                ", art_title='" + art_title + '\'' +
                ", art_content='" + art_content + '\'' +
                ", art_img='" + art_img + '\'' +
                ", art_time=" + art_time +
                '}';
    }
}
