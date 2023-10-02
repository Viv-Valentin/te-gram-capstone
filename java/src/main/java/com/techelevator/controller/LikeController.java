package com.techelevator.controller;

import com.techelevator.dao.PostDao;
import com.techelevator.model.Post;
import org.springframework.http.HttpStatus;
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

    //this will be for liking/unliking a post
    //@RequestMapping(path = "/like", method = RequestMethod.POST)

//    most likely not needed, combining this one into our existing addFavorite method.
//    @RequestMapping(path = "", method = RequestMethod.POST)
//    public PostWithLikes addLike(@PathVariable("postId") int id){ // We may need to double check  what I passed into the @PathVariable("postId")
//        //get the post
//        //look up whether it is favorited
//        //loadPostWithLikes object
//        //return it
//        PostWithLikes postWithLikes = null; // this is just a placeholder while we figure out the actual body of the method
//        return postWithLikes;
//
//    }

    // add favorite photo
    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(path = "/{username}/favorite", method = RequestMethod.POST)
    public boolean addFavorite(@PathVariable("username") String username, @RequestBody Post post) {
    //    String username = principal.getName();
        postDao.addFavorite(username, post);
        return true;
        //TODO do a try block here
    }

    // delete favorite photo
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @RequestMapping(path = "/{username}/favorite", method = RequestMethod.DELETE)
    public boolean deleteFavorite(@PathVariable("username") String username, @RequestBody Post post) {
//        String username = principal.getName();
        postDao.deleteFavorite(post.getPostId());
        return true;
        //TODO do a try block here
    }

    // display favorite photos
    @RequestMapping(path = "/{username}/favorite", method = RequestMethod.GET)
    public List<Post> getFavorite(@PathVariable("username") String username) {
        return postDao.findFavoriteByUsername(username);
    }








    //(method = RequestMethod.DELETE)
}
