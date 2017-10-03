package com.webapp.main.java;

public class Post {
    private String txt;
    private int id;

    public Post(String txt, int id) {
        this.txt = txt;
        this.id = id;
    }

    public String getTxt() {
        return txt;
    }

    public void setTxt(String txt) {
        this.txt = txt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Post{" +
                "txt='" + txt + '\'' +
                ", id=" + id +
                '}';
    }
}
