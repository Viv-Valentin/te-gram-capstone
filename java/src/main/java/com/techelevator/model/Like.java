package com.techelevator.model;

public class Like {
    private int likeId;
    private String username;
    private int postId;

    public Like() {}

    public Like(int likeId, String username, int postId) {
        this.likeId = likeId;
        this.username = username;
        this.postId = postId;
    }

    public int getLikeId() {
        return likeId;
    }

    public void setLikeId(int likeId) {
        this.likeId = likeId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(int userId) {
        this.username = username;
    }

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    @Override
    public String toString() {
        return "Like{" +
                "likeId=" + likeId +
                ", username=" + username +
                ", postId=" + postId +
                '}';
    }
}
