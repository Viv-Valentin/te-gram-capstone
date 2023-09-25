package com.techelevator.dao;

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
            throw new DaoException("Unable to connect to server or database", e);
        }
        return photoList;
    }

}
