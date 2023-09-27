package com.techelevator.dao;

import com.techelevator.model.Photo;

import java.util.List;

public interface PhotoDao {

    List<Photo> findPhotosById(int userId);
    List<Photo> findFavoriteById(int userId);
    public boolean isLiked(int postId, int userId);
    public void like(int postId, int userId);
    public void unlike(int postId, int userId);
    public int getLikeNumber(int postId);




}
