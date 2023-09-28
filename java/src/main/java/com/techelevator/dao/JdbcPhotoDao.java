package com.techelevator.dao;

import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;
import org.springframework.web.client.ResourceAccessException;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcPhotoDao implements PhotoDao{

    private JdbcTemplate jdbcTemplate;

    public JdbcPhotoDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<String> listPhotos(int postId) {
        List<String> Photos = new ArrayList<>();
        String sql = "SELECT image_url FROM posts WHERE post_id = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, postId);

        while (results.next()) {
            String imageUrl = results.getString("image_url");
           Photos.add(imageUrl);
        }
        return Photos;
    }

    @Override
    public void addPhotos(List<String> urls, int postId) {
        String sql = "INSERT INTO posts (image_url, post_id)" +
                " VALUES (?, ?)";
        for (String url: urls) {
            jdbcTemplate.update(sql, url, postId);
        }

    }
}
