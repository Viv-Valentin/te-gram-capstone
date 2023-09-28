package com.techelevator.dao;

import java.util.List;

public interface PhotoDao {

List<String> listPhotos(int postId);


void addPhotos(List<String> urls, int postId);
}

