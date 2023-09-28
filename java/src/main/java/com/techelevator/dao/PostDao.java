package com.techelevator.dao;
import com.techelevator.model.Post;
import org.springframework.stereotype.Component;

import java.util.List;

public interface PostDao {
    List<Post> listPosts();

    Post getPost(int postId);

    int getNextPostId();

    void addPost(Post post);

    void deletePost(int id);

    int countPosts(int userId);

}
