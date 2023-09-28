package com.techelevator.controller;

import com.techelevator.dao.*;
import com.techelevator.model.Comment;
import com.techelevator.model.Post;
import com.techelevator.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@CrossOrigin
@PreAuthorize("isAuthenticated()")
public class PhotoController {

    // this will be for uploading a photo/post
    //@RequestMapping(path = "/new-post", method = RequestMethod.POST)
    @Autowired
    private UserDao userDao;
    @Autowired
    private PostDao postDao;
    @Autowired
    private LikeDao likeDao;
    @Autowired
    private PhotoDao photoDao;
    @Autowired
    private CommentDao commentDao;


    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(path = "/posts", method = RequestMethod.GET)
    public List<Post> listPosts(Principal principal) {
        int userId = userDao.findIdByUsername(principal.getName());
        List<Post> postList = postDao.listPosts();
        for (Post post: postList) {
            post.setPhotos(photoDao.listPhotos(post.getPostId())); ;
            post.setComments(commentDao.listComments(post.getPostId()));
            post.setLiked(likeDao.isLiked(post.getPostId(), userId));
            post.setLikeNumber(likeDao.getLikeNumber(post.getPostId()));
        }

        return postList;
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(path = "/posts/{id}", method = RequestMethod.GET)
    public Post getPost(@PathVariable int id, Principal principal) {
        int userId = userDao.findIdByUsername(principal.getName());

        Post post = postDao.getPost(id);
        post.setPhotos(photoDao.listPhotos(post.getPostId()));
        post.setComments(commentDao.listComments(id));
        post.setLiked(likeDao.isLiked(id, userId));
        post.setLikeNumber(likeDao.getLikeNumber(post.getPostId()));
        return post;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(path = "/posts", method = RequestMethod.POST)
    public void addPost(@RequestBody Post post, Principal principal) {
        int userId = userDao.findIdByUsername(principal.getName());
        post.setUserId(userId);

        int postId = postDao.getNextPostId();
       post.setPostId(postId);

        LocalDateTime now = LocalDateTime.now().withNano(0);
       post.setDatePosted(now);

        postDao.addPost(post);

        photoDao.addPhotos(post.getPhotos(), post.getPostId());
    }

    @ResponseStatus(HttpStatus.ACCEPTED)
    @RequestMapping(path = "/posts/{id}", method = RequestMethod.DELETE)
    public void deletePost(@PathVariable int id, Principal principal) {
        long userId = userDao.findIdByUsername(principal.getName());
        User user = userDao.getUserById((int) userId);
        Post post = postDao.getPost(id);

        if (user.getId() == post.getUserId() || user.getAuthorities().contains("admin")) {
            postDao.deletePost(id);
        }

    }



    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(path = "/liked/{postId}", method = RequestMethod.POST)
    public void like(@PathVariable int postId, Principal principal) {
        int userId = userDao.findIdByUsername(principal.getName());
        likeDao.like(postId, userId);
    }

    @RequestMapping(path = "/liked/{postId}", method = RequestMethod.DELETE)
    public void unlike(@PathVariable int postId, Principal principal) {
        int userId = userDao.findIdByUsername(principal.getName());
        likeDao.unlike(postId, userId);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(path = "/comments", method = RequestMethod.POST)
    public void submitComment(@RequestBody Comment comment, Principal principal) {
        int userId = userDao.findIdByUsername(principal.getName());
        commentDao.submitComment(userId, comment);

    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @RequestMapping(path = "/comments/{commentId}", method = RequestMethod.DELETE)
    public void deleteComment(@PathVariable int commentId, Principal principal) {
        int userId = userDao.findIdByUsername(principal.getName());

        commentDao.deleteComment(userId, commentId);

    }
}

