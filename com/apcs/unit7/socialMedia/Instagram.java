package com.apcs.unit7.socialMedia;

import java.util.ArrayList;

public class Instagram {
    public static void main(String[] args) {
        ArrayList<Post> post1 = new ArrayList<>();
        post1.add(new Post(121, "hehhehah cool king laugh"));
        post1.add(new Post(135, "hehhehah cool queen laugh"));

        ArrayList<String> friends1 = new ArrayList<>();
        friends1.add("Evan");
        friends1.add("Qadry");
        friends1.add("Rodgi");

        Profile cooperrecob = new Profile("Cooper Recob", post1, friends1);

        System.out.println(mostPopularPost(cooperrecob));
    }

    public static Post mostPopularPost(Profile profile) {
        Post popularPost = profile.getPosts().get(0);

        for(int i = 0; i < profile.getPosts().size(); i++) {
            if(profile.getPosts().get(i).getLikes() > popularPost.getLikes()) {
                popularPost = profile.getPosts().get(i);
            }
        }
        
        return popularPost;
    }

    public static int totalLikes(Profile profile) {
        int total = 0;

        for(int i = 0; i < profile.getPosts().size(); i++) {
            total += profile.getPosts().get(i).getLikes();
        }

        return total;
    }

    public static void popularPosts(Profile profile) {
        for(int i = profile.getPosts().size(); i > 0; i--) {
            if(profile.getPosts().get(i).getLikes() == 0) {
                profile.getPosts().remove(profile.getPosts().get(i));
            }
        }
    }
}
