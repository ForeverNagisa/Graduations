package com.james.bean;

public class Comments {
    private int comm_id,article_id,person_id;
    private String date,comm_name,person_name;

    public Comments(){}

    public Comments(int comm_id, int article_id, int person_id, String date, String comm_name, String person_name) {
        this.comm_id = comm_id;
        this.article_id = article_id;
        this.person_id = person_id;
        this.date = date;
        this.comm_name = comm_name;
        this.person_name = person_name;
    }

    public int getComm_id() {
        return comm_id;
    }

    public void setComm_id(int comm_id) {
        this.comm_id = comm_id;
    }

    public int getArticle_id() {
        return article_id;
    }

    public void setArticle_id(int article_id) {
        this.article_id = article_id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getComm_name() {
        return comm_name;
    }

    public void setComm_name(String comm_name) {
        this.comm_name = comm_name;
    }

    public int getPerson_id() {
        return person_id;
    }

    public void setPerson_id(int person_id) {
        this.person_id = person_id;
    }

    public String getPerson_name() {
        return person_name;
    }

    public void setPerson_name(String person_name) {
        this.person_name = person_name;
    }

    @Override
    public String toString() {
        return "Comments{" +
                "comm_id=" + comm_id +
                ", article_id=" + article_id +
                ", person_id=" + person_id +
                ", date='" + date + '\'' +
                ", comm_name='" + comm_name + '\'' +
                ", person_name='" + person_name + '\'' +
                '}';
    }
}
