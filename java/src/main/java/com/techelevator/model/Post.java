package com.techelevator.model;

import java.util.Date;
public class Post {

    private int postId;
    private String username;
    private  String caption;
    private String imgURL;
    private Date timestamp;

    public Post() {
    }

    public Post(int postId, String username, String caption, String imgURL, Date timestamp) {
        this.postId = postId;
        this.username = username;
        this.caption = caption;
        this.imgURL = imgURL;
        this.timestamp = timestamp;
    }

    public int getId() {
        return postId;
    }

    public void setId(int postId) {
        this.postId = postId;
    }

    public String getUsername() {
        return username;
    }

    public void setUserId(int userId) {
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

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
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
