package com.techelevator.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RestController;
import com.techelevator.dao.PostDao;
import com.techelevator.model.Post;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.security.Principal;
import java.util.List;



@RestController
@CrossOrigin
@PreAuthorize("isAuthenticated()")
public class AccountController {

    private final PostDao postDao;

    public AccountController(PostDao postDao) {
        this.postDao = postDao;
    }

    // upload a picture
    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(path = "/post", method = RequestMethod.POST)
    public boolean addPost(@Valid @RequestBody Post post, Principal principal) {
        postDao.addPost(principal.getName(), post.getCaption(), post.getImgURL());
        System.out.println(post);
        return true;
        //TODO do a try block here
    }

    // show public photo feed
    @RequestMapping(path = "/", method = RequestMethod.GET)
    public List<Post> getFeed(Principal principal) {
        String username = principal.getName();
        return postDao.getFeed(username);
    }

    // view photos by user
    @RequestMapping(path = "/{username}", method = RequestMethod.GET)
    public List<Post> getPosts(@PathVariable("username") String username) {
        return postDao.findPhotosByUsername(username);
    }

    @RequestMapping(path = "/{username}/{postId}", method = RequestMethod.GET)
    public Post getPost(@Valid @PathVariable("username") String username, @PathVariable("postId") int postId) {
        Post post = postDao.findPostById(postId);
        if (post != null) {
            new ResponseEntity<>(post, HttpStatus.OK);
        }
        else {
            new ResponseEntity<>(post, HttpStatus.NOT_FOUND);
        }
        return post;
    }
}
