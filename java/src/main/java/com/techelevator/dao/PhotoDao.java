package com.techelevator.dao;

import com.techelevator.model.Photo;

import java.util.List;

public interface PhotoDao {

    List<Photo> findPhotosById(int userId);
    List<Photo> findFavoriteById(int userId);

}
