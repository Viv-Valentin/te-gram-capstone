BEGIN TRANSACTION;

INSERT INTO users (email,username,password_hash,role) VALUES ('user@mail.com','user','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER');
INSERT INTO users (email,username,password_hash,role) VALUES ('admin@mail.com','admin','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_ADMIN');
INSERT INTO users (email,username,password_hash,role) VALUES ('viv@mail.com','viv','$2a$10$SkpetsQ1NPbAwC/YQQ3jb..PGCfafOvMMMtqIp3d0DSHoYJ1tMQkG','ROLE_USER');
INSERT INTO users (email,username,password_hash,role) VALUES ('maryam@mail.com','maryam','$2a$10$dIKOD/Bgxwt5rVa7gsymCeXoAPwG/q/PNLQ5oq4Jf0iS.B2.QRPIy','ROLE_USER');
INSERT INTO users (email,username,password_hash,role) VALUES ('kay@mail.com','kay','$2a$10$ZeOorYllgNirm2vIx8KBveEWA3/MGO89eH8KP0cKsCBd/gnokrjy2','ROLE_USER');
INSERT INTO users (email,username,password_hash,role) VALUES ('nix@mail.com','nix','$2a$10$GlsSjcOvqTajVWg3vCRLwelkX9QPkKHajLu1r/LKK/0qmQTQ.PL6m','ROLE_USER');

INSERT INTO posts (username, caption, image_url, created_at) VALUES ('viv', 'The view from Mt. Everest', 'https://res.cloudinary.com/dfcehgwjs/image/upload/v1695737800/cld-sample-2.jpg', '09/26/2023');
INSERT INTO posts (username, caption, image_url, created_at) VALUES ('maryam', 'Here is my breakfast! Yum! :)', 'https://res.cloudinary.com/dfcehgwjs/image/upload/v1695737798/samples/dessert-on-a-plate.jpg', '09/25/2023');
INSERT INTO posts (username, caption, image_url, created_at) VALUES ('kay', 'This is when I went to he hot ari balloon festival in the west! It was such a fun trip and I had such an amazing time, cannot wait to go back!', 'https://res.cloudinary.com/dfcehgwjs/image/upload/v1695737793/samples/balloons.jpg', '09/24/2023');
INSERT INTO posts (username, caption, image_url, created_at) VALUES ('nix', 'Here is a cat! they are so cute and I love them so so much, Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industrys standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has', 'https://res.cloudinary.com/dfcehgwjs/image/upload/v1695737766/samples/animals/cat.jpg', '09/23/2023');

INSERT INTO likes (username, post_id) VALUES ('viv', 2001);
INSERT INTO likes (username, post_id) VALUES ('maryam', 2002);
INSERT INTO likes (username, post_id) VALUES ('kay', 2003);
INSERT INTO likes (username, post_id) VALUES ('nix', 2004);

INSERT INTO comments (username, post_id, comment, comment_created) VALUES ('viv', 2002, 'so cute!', '09/25/2023');
INSERT INTO comments (username, post_id, comment, comment_created) VALUES ('maryam', 2001, 'beauty!', '09/26/2023');
INSERT INTO comments (username, post_id, comment, comment_created) VALUES ('kay', 2004, 'pretty!', '09/23/2023');
INSERT INTO comments (username, post_id, comment, comment_created) VALUES ('nix', 2003, 'love it!', '03/24/2023');


COMMIT TRANSACTION;
