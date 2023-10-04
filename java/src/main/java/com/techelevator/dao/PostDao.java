package com.techelevator.dao;
import com.techelevator.model.Post;

import java.util.List;

public interface PostDao {
    boolean addPost(String username, String caption, String imageUrl);
    List<Post> getFeed(String username);
    Post findPostById(int postId);
    Boolean addFavorite(String username, int postId);
    void deleteFavorite(String username, int postId);
    List<Post> findPhotosByUsername(String username);
    List<Post> findFavoriteByUsername(String username);
    boolean searchFavoriteByPostId(int postId, String username);
}
