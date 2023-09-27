package com.techelevator.dao;

import com.techelevator.model.Photo;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.web.client.ResourceAccessException;

import java.util.ArrayList;
import java.util.List;

public class JdbcPhotoDao implements PhotoDao {
    private final JdbcTemplate jdbcTemplate;
    public JdbcPhotoDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Photo> findPhotosById(int userId) {
        List<Photo> photos = new ArrayList<>();
        String sql = "SELECT image_url FROM posts WHERE user_id = ?;"; // don't fill in the blank for any serial things, Rockey will send screenshot
        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, userId);
            while (results.next()) {
                Photo photo = new Photo();
                photos.add(photo);
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new ResourceAccessException("Unable to connect to server or database");
        }
        return photos;
    }

    @Override
    public List<Photo> findFavoriteById(int userId) {
        return null;
    }
    @Override
    public boolean isLiked(int postId, int userId) {
        String sqlIsLiked = "SELECT COUNT(*) FROM likes WHERE username = ? AND post_id = ?";
        Integer rows = jdbcTemplate.queryForObject(sqlIsLiked, Integer.class, userId, postId);
        return rows >= 1;
    }

    @Override
    public void like(int postId, int userId) {
        // might have to set an if statement to check if photo is already liked
        String sqlLike = "INSERT INTO likes (username, post_id) VALUES (?,?)";
        jdbcTemplate.update(sqlLike, userId, postId);
    }

    @Override
    public void unlike(int postId, int userId) {
        String sqlLike = "DELETE FROM likes WHERE username = ? AND post_id = ?";
        jdbcTemplate.update(sqlLike, userId, postId);
    }

    @Override
    public int getLikeNumber(int postId) {
        String sqlGetLikeNumber = "SELECT COUNT(*) FROM likes WHERE post_id = ?";
        Integer likes = jdbcTemplate.queryForObject(sqlGetLikeNumber, Integer.class, postId);
        return likes;
    }


    public void addPhotos(List<String> urls, int postId) {
        String sqlAddPhotos = "INSERT INTO posts (image_url, post_id)" +
                " VALUES (?, ?)";
        for (String url: urls) {
            jdbcTemplate.update(sqlAddPhotos, url, postId);
        }

    }
}



