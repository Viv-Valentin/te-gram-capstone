package com.techelevator.dao;
import com.techelevator.model.Post;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
@Component
public class JdbcPostDao implements PostDao {

    private JdbcTemplate jdbcTemplate;

    public JdbcPostDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Post> listPosts() {
        List<Post> postList= new ArrayList<>();
        String sqlListPosts = "SELECT posts_id, users.username, post_id, caption , created_at FROM posts" +
                " JOIN users ON users.user_id = posts.user_id" +
                " ORDER BY created_at DESC";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sqlListPosts);

        while (results.next()) {
            Post post = mapRowToPost(results);
            postList.add(post);
        }

        return postList;
    }

    @Override
    public Post getPost(int postId) {
        String sqlGetPost = "SELECT users.user_id, users.username, post_id, created_at, caption FROM posts" +
                " JOIN users ON users.user_id = posts.user_id  WHERE post_id = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sqlGetPost, postId);

        results.next();
        Post post = mapRowToPost(results);
        return post;
    }

    @Override
    public int getNextPostId() {
        String sqlGetNextPostId = "SELECT nextval('posts_post_id_seq')";
        return jdbcTemplate.queryForObject(sqlGetNextPostId, Integer.class);
    }

    @Override
    public void addPost(Post post) {
        String sqlAddPost = "INSERT INTO posts (user_id, post_id, created_at, caption)" +
                " VALUES (?, ?, ?, ?)";
        jdbcTemplate.update(sqlAddPost, post.getUserId(), post.getPostId(), post.getDatePosted().toString(),
                post.getCaption());
    }

    @Override
    public void deletePost(int postId) {
        String sqlDeletePost = "DELETE FROM posts WHERE post_id = ?";
        jdbcTemplate.update(sqlDeletePost);
    }

    @Override
    public int countPosts(int userId) {
        String sqlCountPosts = "SELECT COUNT(*) FROM posts WHERE user_id = ?";
        Integer numPosts = jdbcTemplate.queryForObject(sqlCountPosts, Integer.class, userId);
        return numPosts;
    }

    private Post mapRowToPost(SqlRowSet results) {
        Post thePost = new Post();
        thePost.setUserId(results.getInt("user_id"));
        thePost.setUsername(results.getString("username"));
        thePost.setPostId(results.getInt("post_id"));
        String datetimeStr = results.getString("created_at");
        thePost.setDatePosted(LocalDateTime.parse(datetimeStr));

        LocalDateTime currentDT = LocalDateTime.now();
        Duration duration = Duration.between(thePost.getDatePosted(), currentDT);
        thePost.setSecondsAgo(duration.toSeconds());

        //thePost.setSecondsAgo(



        thePost.setCaption(results.getString("caption"));

        return thePost;
    }
}