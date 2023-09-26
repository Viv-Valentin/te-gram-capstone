package com.techelevator.model;

import java.util.Date;

public class Follow {

    private int followId;

    private int followerId;

    private int followeeId;

    private Date timestamp;

    public Follow() {}

    public Follow(int followId, int followerId, int followeeId, Date timestamp) {
        this.followId = followId;
        this.followerId = followerId;
        this.followeeId = followeeId;
        this.timestamp = timestamp;
    }


    public int getFollowId() {
        return followId;
    }

    public void setFollowId(int followId) {
        this.followId = followId;
    }

    public int getFollowerId() {
        return followerId;
    }

    public void setFollowerId(int followerId) {
        this.followerId = followerId;
    }

    public int getFolloweeId() {
        return followeeId;
    }

    public void setFolloweeId(int followeeId) {
        this.followeeId = followeeId;
    }

    public Date getTimestamp() {return timestamp;}

    public void setTimestamp(Date timestamp) {this.timestamp = timestamp;}

    @Override
    public String toString() {
        return "Follow{" +
                "followId=" + followId +
                ", followerId=" + followerId +
                ", followeeId=" + followeeId +
                '}';
    }

}

