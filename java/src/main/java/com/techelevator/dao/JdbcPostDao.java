package com.techelevator.dao;
import com.techelevator.model.Post;
import java.util.List;


public class JdbcPostDao implements PostDao {

    @Override
    public Post create(Post post) {
//        String sql = "INSERT INTO posts (username, caption, image_url) VALUES ()";
        return null;
    }

    @Override
    public List<Post> getFeed(String username) {
        return null;
    }

    @Override
    public Post findPostById(int postId) {
        return null;
    }



}
