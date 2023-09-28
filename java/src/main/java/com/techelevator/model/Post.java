package com.techelevator.model;

import java.time.LocalDateTime;
import java.util.Date;
public class Post {

    private int postId;
    private String username;
    private  String caption;
    private String imgURL;
    private LocalDateTime timestamp;

    public Post() {
    }

    public Post(int postId, String username, String caption, String imgURL, LocalDateTime timestamp) {
        this.postId = postId;
        this.username = username;
        this.caption = caption;
        this.imgURL = imgURL;
        this.timestamp = timestamp;
    }

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public String getImgURL() {
        return imgURL;
    }

    public void setImgURL(String imgURL) {
        this.imgURL = imgURL;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "Post{" +
                "postId=" + postId +
                ", username=" + username +
                ", caption='" + caption + '\'' +
                ", imgURL='" + imgURL + '\'' +
                ", timestamp=" + timestamp +
                '}';
    }
}
