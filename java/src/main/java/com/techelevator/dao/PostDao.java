package com.techelevator.dao;
import com.techelevator.model.Post;
import java.util.List;

public interface PostDao {
    Post create(Post post);
    List<Post> getFeed(String username);
    Post findPostById(int postId);

}
