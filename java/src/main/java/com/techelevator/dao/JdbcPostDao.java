package com.techelevator.dao;
import com.techelevator.model.Post;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;
import org.springframework.web.client.ResourceAccessException;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
@Component

public class JdbcPostDao implements PostDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcPostDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public boolean addPost(String username, String caption, String imageUrl) {
        String sql = "INSERT INTO posts (username, caption, image_url, created_at) VALUES (?, ?, ?, ?);";
        try {
            jdbcTemplate.queryForObject(sql, Integer.class, username, caption, imageUrl, LocalDateTime.now());
        } catch (DataAccessException e) {
            return false;
        }
        return true;
    }


    @Override
    public List<Post> getFeed(String username) {
        List<Post> posts = new ArrayList<>();
        String sql = "SELECT * FROM posts;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while (results.next()) {
            posts.add(mapRowToPost(results));
        }
        return posts;
    }

    @Override
    public Post findPostById(int postId) {
        Post post = null;
        String sql = "SELECT * FROM posts WHERE post_id = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, postId);
        if (results.next()) {
           post = mapRowToPost(results);
        }
        return post;
    }

    @Override
    public List<Post> findPhotosByUsername(String username) {
        List<Post> posts = new ArrayList<>();
        String sql = "SELECT * FROM posts WHERE username ILIKE ?;";
        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, username);
            while (results.next()) {
                Post post = mapRowToPost(results);
                posts.add(post);
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new ResourceAccessException("Unable to connect to server or database");
        }
        return posts;
    }

    @Override
    public Boolean addFavorite(String username, Post post) {
        String sql = "INSERT INTO likes (username, post_id) " +
                "VALUES (?, ?) RETURNING post_id";
        try {
            Integer postId = jdbcTemplate.queryForObject(sql, Integer.class, username, post.getPostId());
            post.setPostId(postId);

        } catch (CannotGetJdbcConnectionException e) {
            throw new ResourceAccessException("Unable to connect to server or database");
        }
        return true;
    }

    public boolean searchFavoriteByPostId(int postId, String username){
        String sql = "SELECT like_id from likes WHERE post_id = ? AND username ILIKE ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, postId, username);
        return results.next();
    }

    @Override
    public int deleteFavorite(int postId) {
        int numOfRows = 0;
        String sql = "DELETE FROM likes WHERE post_id = ?;";
        numOfRows = jdbcTemplate.update(sql, postId);

        return numOfRows;
    }

    @Override
    public List<Post> findFavoriteByUsername(String username) {
        List<Post> posts = new ArrayList<>();
        String sql = "SELECT posts.post_id, posts.username, posts.caption, posts.image_url, posts.created_at FROM likes " +
                "JOIN posts ON likes.post_id = posts.post_id " +
                "WHERE likes.username ILIKE ?;";
        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, username);
            while (results.next()) {
                Post post = mapRowToPost(results);
                posts.add(post);
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new ResourceAccessException("Unable to connect to server or database");
        }
        return posts;
    }

    private Post mapRowToPost(SqlRowSet row) {
        Post post = new Post();
        post.setPostId(row.getInt("post_id"));
        post.setUsername(row.getString("username"));
        post.setCaption(row.getString("caption"));
        post.setImgURL(row.getString("image_url"));
        post.setTimestamp(row.getTimestamp("created_at").toLocalDateTime());
        return post;
    }
}
