package com.techelevator.dao;

import com.techelevator.model.Photo;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.web.client.ResourceAccessException;

import java.util.ArrayList;
import java.util.List;

public class JdbcPhotoDao {
    private final JdbcTemplate jdbcTemplate;
    public JdbcPhotoDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Photo> getPhoto(int username) {
        List<Photo> photoList = new ArrayList<>();
        String sql = "SELECT image_url FROM posts WHERE username ILIKE ?;";
        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, username);
            while (results.next()) {
                Photo photo = new Photo();
                photoList.add(photo);
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new ResourceAccessException("Unable to connect to server or database");
        }
        return photoList;
    }

}
