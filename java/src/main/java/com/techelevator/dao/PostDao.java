package com.techelevator.dao;
import com.techelevator.model.Comment;
import com.techelevator.model.Post;

import java.util.List;

public interface PostDao {
    boolean addPost(String username, String caption, String imageUrl);
    List<Post> getFeed(String username);
    Post findPostById(int postId);
    void addFavorite(String username, int postId);
    void deleteFavorite(String username, int postId);
    List<Post> findPhotosByUsername(String username);
    List<Post> findFavoriteByUsername(String username);
    boolean searchFavoriteByPostId(int postId, String username);

    // for implementing comments
    boolean addComment(String username, int postId, String comment);

    // in the event of implementing comments
    boolean deleteComment(String username, int postId, int commentId);
    List<Comment> findCommentByUsername(String username);
    List<Comment> findCommentByPostId(int postId);
}
