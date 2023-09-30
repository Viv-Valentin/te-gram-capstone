package com.techelevator.dao;
import com.techelevator.model.Photo;
import com.techelevator.model.Post;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

public interface PostDao {
    boolean addPost(String username, String caption, String imageUrl);
    List<Post> getFeed(String username);
    Post findPostById(int postId);

    List<Post> findPhotosByUsername(String username);
    List<Post> findFavoriteById(int userId);


}
