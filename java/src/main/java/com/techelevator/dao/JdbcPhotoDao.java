package com.techelevator.dao;

import com.techelevator.model.Photo;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;
import org.springframework.web.client.ResourceAccessException;

import java.util.ArrayList;
import java.util.List;
@Component
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
        List<Photo> myPhoto = new ArrayList<>();
        return myPhoto;
    }

}
