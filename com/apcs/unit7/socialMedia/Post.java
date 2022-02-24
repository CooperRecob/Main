package com.apcs.unit7.socialMedia;

public class Post {
    private int likes;
    private String text;

    public Post(int likes, String text) {
        this.likes = likes;
        this.text = text;
    }

    public int getLikes() {
        return likes;
    }

    public String getText() {
        return text;
    }
}

