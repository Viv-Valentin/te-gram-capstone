package com.techelevator.dao;
import com.techelevator.model.Post;

import java.util.List;

public interface PostDao {
    boolean addPost(String username, String caption, String imageUrl);
    List<Post> getFeed(String username);
    Post findPostById(int postId);
    Boolean addFavorite(String username, Post post);
    Boolean deleteFavorite(String username, Post post);
    List<Post> findPhotosByUsername(String username);
    List<Post> findFavoriteByUsername(String username);
}
