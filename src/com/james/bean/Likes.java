package com.james.bean;

public class Likes {
    private int likes_id,li_per_id,li_art_id;

    public Likes(){}

    public Likes(int likes_id, int li_per_id, int li_art_id) {
        this.likes_id = likes_id;
        this.li_per_id = li_per_id;
        this.li_art_id = li_art_id;

    }

    public int getLikes_id() {
        return likes_id;
    }

    public void setLikes_id(int likes_id) {
        this.likes_id = likes_id;
    }

    public int getLi_per_id() {
        return li_per_id;
    }

    public void setLi_per_id(int li_per_id) {
        this.li_per_id = li_per_id;
    }

    public int getLi_art_id() {
        return li_art_id;
    }

    public void setLi_art_id(int li_art_id) {
        this.li_art_id = li_art_id;
    }


    @Override
    public String toString() {
        return "Likes{" +
                "likes_id=" + likes_id +
                ", li_per_id=" + li_per_id +
                ", li_art_id=" + li_art_id +
                '}';
    }
}
