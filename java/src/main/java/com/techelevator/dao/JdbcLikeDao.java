package com.techelevator.dao;

import org.springframework.jdbc.core.JdbcTemplate;

public class JdbcLikeDao implements LikeDao {
    private JdbcTemplate jdbcTemplate;

    public JdbcLikeDao (JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public boolean isLiked(int postId, int userId) {
        String sqlIsLiked = "SELECT COUNT(*) FROM likes WHERE username= ? AND post_id = ?";
        Integer rows = jdbcTemplate.queryForObject(sqlIsLiked, Integer.class, userId, postId);
        return rows >= 1;
    }

    @Override
    public void like(int postId, int userId) {
        // maybe use if statement to see if it was liked already or iterate through photos not sure what would be best
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
}

