package com.techelevator.model;

public class Follow {

    private int followId;

    private int followerId;

    private int followeeId;

    public Follow() {}

    public Follow(int followId, int followerId, int followeeId) {
        this.followId = followId;
        this.followerId = followerId;
        this.followeeId = followeeId;
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

    @Override
    public String toString() {
        return "Follow{" +
                "followId=" + followId +
                ", followerId=" + followerId +
                ", followeeId=" + followeeId +
                '}';
    }

}

