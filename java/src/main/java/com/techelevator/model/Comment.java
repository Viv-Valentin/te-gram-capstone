package com.techelevator.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

public class Comment {
    private int commentId;

    private int postId;
    private String comment;
    private LocalDateTime dateTime;
    private Long secondsAgo;
    private String username;

    public Comment() {};

    public Comment(int commentId,  int postId, String comment, LocalDateTime dateTime, Long secondsAgo, String username) {
        this.commentId = commentId;

        this.postId = postId;
        this.comment = comment;
        this.dateTime = dateTime;
        this.secondsAgo = secondsAgo;
        this.username = username;
    }
    public int getCommentId() {
        return commentId;
    }

    public void setCommentId(int commentId) {
        this.commentId = commentId;
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

    public void setComment(String message) {
        this.comment = comment;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Long getSecondsAgo() {
        return secondsAgo;
    }

    public void setSecondsAgo(Long secondsAgo) {
        this.secondsAgo =secondsAgo;
    }


}
