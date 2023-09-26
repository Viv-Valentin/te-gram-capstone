package com.techelevator.model;

import java.util.Date;

public class Photo {

    private int photoId;
    private int userId;
    private String caption;
    private Date timestamp;

    public Photo() {}

    public int getPhotoId() {
        return photoId;
    }

    public void setPhotoId(int photoId) {
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

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public Photo (int photoId, int userId, String caption, Date timestamp) {

        this.photoId= photoId;
        this.userId = userId;
        this.caption = caption;
        this.timestamp = timestamp;
    }




    @Override
    public String toString() {
        return "Photo{" +
                "photoId=" + photoId +
                ", userId=" + userId +
                ", caption='" + caption + '\'' +
                ", timestamp=" + timestamp +
                '}';
    }

}
