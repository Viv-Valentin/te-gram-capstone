BEGIN TRANSACTION;

DROP TABLE IF EXISTS users, posts, likes, comments, follow;

CREATE TABLE users (
	user_id SERIAL,
	username VARCHAR(50) NOT NULL UNIQUE,
	password_hash VARCHAR(200) NOT NULL,
	role VARCHAR(50) NOT NULL,
	CONSTRAINT PK_user PRIMARY KEY (user_id),
	CONSTRAINT UQ_username UNIQUE (username)
);

CREATE TABLE posts (
    post_id SERIAL,
    username VARCHAR(50),
    caption VARCHAR (255),
    image_url VARCHAR(100),
    created_at TIMESTAMP,
    CONSTRAINT PK_post PRIMARY KEY(post_id),
    CONSTRAINT FK_posts_users FOREIGN KEY (username) REFERENCES users (username)
);

CREATE TABLE likes (
    like_id SERIAL,
    username VARCHAR(50),
    post_id INT,
    CONSTRAINT PK_like PRIMARY KEY(like_id),
    CONSTRAINT FK_likes_users FOREIGN KEY (username) REFERENCES users (username),
    CONSTRAINT FK_likes_posts FOREIGN KEY (post_id) REFERENCES posts (post_id)
);

CREATE TABLE comments (
    comment_id SERIAL,
    username VARCHAR(50),
    post_id INT,
    comment VARCHAR (255),
    comment_created TIMESTAMP,
    CONSTRAINT PK_comment PRIMARY KEY(comment_id),
    CONSTRAINT FK_comments_users FOREIGN KEY (username) REFERENCES users (username),
    CONSTRAINT FK_comments_posts FOREIGN KEY (post_id) REFERENCES posts (post_id)
);

CREATE TABLE follow (
    follow_id SERIAL,
    follower_username INT,
    following_username INT,
    CONSTRAINT PK_follow PRIMARY KEY(follow_id)
);


COMMIT TRANSACTION;
