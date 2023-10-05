package com.techelevator.controller;

import com.techelevator.dao.PostDao;
import com.techelevator.model.Comment;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@CrossOrigin
@PreAuthorize("isAuthenticated()")
public class CommentController {

    //this will for uploading and deleting a comment
    //@RequestMapping(path = "/new-comment", method = RequestMethod.POST)
    //method = RequestMethod.DELETE)

    private final PostDao postDao;

    public CommentController(PostDao postDao) {this.postDao = postDao;}

    //add a comment
    @RequestMapping(path = "/{username}/comment", method = RequestMethod.POST)
    public boolean addComment (@PathVariable("username") String username,
                            @RequestBody Comment comment,
                            Principal principal) {
        username = principal.getName();
        postDao.addComment(username, comment.getPostId(), comment.getComment());
        return true;
        // TODO: try catch once again
    }

    //delete a comment
    @RequestMapping(path = "/{username}/comment", method = RequestMethod.DELETE)
    public boolean deleteComment (@PathVariable("username") String username,
                               @RequestBody Comment comment,
                               Principal principal) {
        username = principal.getName();
        postDao.deleteComment(username, comment.getPostId(), comment.getCommentId());
        return true;
        // TODO: try catch once again
    }

    // display comments
    @RequestMapping(path = "/{username}/comment", method = RequestMethod.GET)
    public List<Comment> getComments(@PathVariable("username") String username) {
        return postDao.findCommentByUsername(username);
    }
}
