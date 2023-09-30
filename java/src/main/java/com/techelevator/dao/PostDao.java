package com.techelevator.dao;
import com.techelevator.model.Post;

import java.util.List;

public interface PostDao {
    boolean addPost(String username, String caption, String imageUrl);
    List<Post> getFeed(String username);
    Post findPostById(int postId);
    List<Post> findPhotosByUsername(String username);
    List<Post> findFavoriteById(int userId);
}
