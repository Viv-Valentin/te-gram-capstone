BEGIN TRANSACTION;

INSERT INTO users (username,password_hash,role) VALUES ('user','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER');
INSERT INTO users (username,password_hash,role) VALUES ('admin','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_ADMIN');

INSERT INTO posts (username, caption, image_url, created_at) VALUES ();
INSERT INTO posts (username, caption, image_url, created_at) VALUES ();
INSERT INTO posts (username, caption, image_url, created_at) VALUES ();
INSERT INTO posts (username, caption, image_url, created_at) VALUES ();

INSERT INTO likes (username, post_id) VALUES ();
INSERT INTO likes (username, post_id) VALUES ();
INSERT INTO likes (username, post_id) VALUES ();
INSERT INTO likes (username, post_id) VALUES ();

INSERT INTO comments (username, post_id, comment, comment_created) VALUES ();
INSERT INTO comments (username, post_id, comment, comment_created) VALUES ();
INSERT INTO comments (username, post_id, comment, comment_created) VALUES ();
INSERT INTO comments (username, post_id, comment, comment_created) VALUES ();

INSERT INTO follow (follower_username, following_username) VALUES ();
INSERT INTO follow (follower_username, following_username) VALUES ();
INSERT INTO follow (follower_username, following_username) VALUES ();
INSERT INTO follow (follower_username, following_username) VALUES ();

--will populate with dummy data after meeting with Eric

COMMIT TRANSACTION;
