package com.techelevator.controller;

import com.techelevator.dao.PostDao;
import com.techelevator.model.Post;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@CrossOrigin
@PreAuthorize("isAuthenticated()")
public class LikeController {

    private final PostDao postDao;

    public LikeController(PostDao postDao) {
        this.postDao = postDao;
    }

    // add favorite photo
    @RequestMapping(path = "/{username}/{postId}", method = RequestMethod.POST)
    public boolean addFavorite(@PathVariable("username") String username, @PathVariable("postId") int postId, Principal principal) {
        username = principal.getName();
        postDao.addFavorite(username, postId);
        return true;
        //TODO do a try block here
    }

    // delete favorite photo
    @RequestMapping(path = "/{username}/{postId}", method = RequestMethod.DELETE)
    public boolean deleteFavorite(@PathVariable("username") String username, @PathVariable("postId") int postId, Principal principal) {
        username = principal.getName();
        postDao.deleteFavorite(username, postId);
        return true; // this should be just true,
        //TODO do a try block here
    }

    // display favorite photos
    @RequestMapping(path = "/{username}/favorite", method = RequestMethod.GET)
    public List<Post> getFavorite(@PathVariable("username") String username) {
        return postDao.findFavoriteByUsername(username);
    }

}
