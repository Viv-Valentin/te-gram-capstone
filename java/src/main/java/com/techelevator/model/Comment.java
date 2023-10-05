package com.techelevator.model;

import java.time.LocalDateTime;

public class Comment {
    private int commentId;
    private String username;
    private int postId;
    private String comment;
    private LocalDateTime timestamp;

    public Comment() {
    }

    public Comment(int commentId, String username, int postId, String comment, LocalDateTime timestamp) {
        this.commentId = commentId;
        this.username = username;
        this.postId = postId;
        this.comment = comment;
        this.timestamp = timestamp;
    }

    public int getCommentId() {
        return commentId;
    }

    public void setCommentId(int commentId) {
        this.commentId = commentId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "commentId=" + commentId +
                ", username=" + username +
                ", postId=" + postId +
                ", comment='" + comment + '\'' +
                ", timestamp=" + timestamp +
                '}';
    }
}
