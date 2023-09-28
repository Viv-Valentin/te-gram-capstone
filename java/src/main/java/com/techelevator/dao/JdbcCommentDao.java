package com.techelevator.dao;

import com.techelevator.model.Comment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class JdbcCommentDao implements CommentDao {
    private JdbcTemplate jdbcTemplate;

    public JdbcCommentDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Comment> listComments(int postId) {
        List<Comment> commentList = new ArrayList<>();
        String sqlListComments = "SELECT comment_id, comments.user_id, post_id, comment, comment_created, users.username FROM comments " +
                "JOIN users ON users.user_id = comments.user_id WHERE post_id = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sqlListComments, postId);

        while (results.next()) {
            Comment comment = mapRowToComment(results);
            commentList.add(comment);
        }

        return commentList;
    }

    @Override
    public void submitComment(int userId, Comment comment) {
        String sqlSubmitComment = "INSERT INTO comments (username, post_id, comment,created_at) " +
                "VALUES (?,?,?,?)";
        jdbcTemplate.update(sqlSubmitComment, userId, comment.getPostId(), LocalDateTime.now().withNano(0), comment.getComment());
    }
    @Override
    public void deleteComment(int userId, int commentId) {
        String sqlDeleteComment = "DELETE FROM comments WHERE user_id = ? AND comment_id = ?";
        jdbcTemplate.update(sqlDeleteComment, userId, commentId);
    }

    private Comment mapRowToComment(SqlRowSet results) {
        Comment theComment = new Comment();
        theComment.setCommentId(results.getInt("comment_id"));
        theComment.setUsername(results.getString("username"));
        theComment.setPostId(results.getInt("post_id"));
        theComment.setComment(results.getString("comment"));
        String datetimeStr = results.getString("comment_created");
        theComment.setDateTime(LocalDateTime.parse(datetimeStr));

        LocalDateTime currentDT = LocalDateTime.now().withNano(0);
        Duration duration = Duration.between(theComment.getDateTime(), currentDT);
        theComment.setSecondsAgo(duration.toSeconds());

        return theComment;
    }
}

