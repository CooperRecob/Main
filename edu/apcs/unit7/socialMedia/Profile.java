package edu.apcs.unit7.socialMedia;

import java.util.ArrayList;

public class Profile {
    private String username;
    private ArrayList<Post> posts;
    private ArrayList<String> friends;

    public Profile(String username, ArrayList<Post> posts, ArrayList<String> friends) {
        posts = new ArrayList<>();
        friends = new ArrayList<>();

        this.username = username;
        this.posts = posts;
        this.friends = friends;
    }

    public ArrayList<Post> getPosts() {
        return posts;
    }

    public ArrayList<String> getFriends() {
        return friends;
    }

    public String getUsername() {
        return username;
    }
}
