package com.techelevator.model;

import java.util.Date;
public class Post {

    private int photoId;
    private int userId;
    private  String caption;
    private String imgURL;
    private Date timestamp;

    public Post() {
    }

    public Post(int photoId, int userId, String caption, String imgURL, Date timestamp) {
        this.photoId = photoId;
        this.userId = userId;
        this.caption = caption;
        this.imgURL = imgURL;
        this.timestamp = timestamp;
    }

    public int getId() {
        return photoId;
    }

    public void setId(int photoId) {
        this.photoId = photoId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
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
                "photoId=" + photoId +
                ", userId=" + userId +
                ", caption='" + caption + '\'' +
                ", imgURL='" + imgURL + '\'' +
                ", timestamp=" + timestamp +
                '}';
    }
}
