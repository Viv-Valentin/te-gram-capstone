BEGIN TRANSACTION;

DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS posts;
DROP TABLE IF EXISTS likes;
DROP TABLE IF EXISTS comments;
DROP TABLE IF EXISTS follow;

CREATE TABLE users (
	user_id SERIAL,
	username varchar(50) NOT NULL UNIQUE,
	password_hash varchar(200) NOT NULL,
	role varchar(50) NOT NULL,
	CONSTRAINT PK_user PRIMARY KEY (user_id)
);

CREATE TABLE posts (
post_id SERIAL PRIMARY KEY,
user_id INT FOREIGN KEY,
caption VARCHAR (255),
image_url VARCHAR(100),
created_at TIMESTAMP
);

CREATE TABLE likes (
like_id SERIAL PRIMARY KEY,
user_id INT,
post_id INT
);

CREATE TABLE comments (
comment_id SERIAL PRIMARY KEY,
user_id INT,
post_id INT,
comment VARCHAR (255),
comment_created TIMESTAMP
);

CREATE TABLE follow(
follow_id SERIAL PRIMARY KEY,
follower_id INT,
following_id INT
);


COMMIT TRANSACTION;
