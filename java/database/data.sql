BEGIN TRANSACTION;

INSERT INTO users (email,username,password_hash,role) VALUES ('user@mail.com','user','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER');
INSERT INTO users (email,username,password_hash,role) VALUES ('admin@mail.com','admin','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_ADMIN');
INSERT INTO users (email,username,password_hash,role) VALUES ('viv@mail.com','viv','$2a$10$SkpetsQ1NPbAwC/YQQ3jb..PGCfafOvMMMtqIp3d0DSHoYJ1tMQkG','ROLE_USER');
INSERT INTO users (email,username,password_hash,role) VALUES ('maryam@mail.com','maryam','$2a$10$dIKOD/Bgxwt5rVa7gsymCeXoAPwG/q/PNLQ5oq4Jf0iS.B2.QRPIy','ROLE_USER');
INSERT INTO users (email,username,password_hash,role) VALUES ('kay@mail.com','kay','$2a$10$ZeOorYllgNirm2vIx8KBveEWA3/MGO89eH8KP0cKsCBd/gnokrjy2','ROLE_USER');
INSERT INTO users (email,username,password_hash,role) VALUES ('nix@mail.com','nix','$2a$10$GlsSjcOvqTajVWg3vCRLwelkX9QPkKHajLu1r/LKK/0qmQTQ.PL6m','ROLE_USER');

INSERT INTO posts (username, caption, image_url, created_at) VALUES ('viv', 'Conquering new heights, one step at a time. The journey to the summit was very challenging, but the view from above was worth every effort.', 'https://res.cloudinary.com/dfcehgwjs/image/upload/v1695737800/cld-sample-2.jpg', '09/26/2023');
INSERT INTO posts (username, caption, image_url, created_at) VALUES ('maryam', '🍳 Starting the day right with a hearty breakfast plate. 🍽️ Good morning, world!', 'https://res.cloudinary.com/dfcehgwjs/image/upload/v1695737798/samples/dessert-on-a-plate.jpg', '09/25/2023');
INSERT INTO posts (username, caption, image_url, created_at) VALUES ('kay', 'Here is a pic from when I went to the hot air balloon festival in New Mexico! It was such a fun trip and I had such an amazing time, cannot wait to go back!', 'https://res.cloudinary.com/dfcehgwjs/image/upload/v1695737793/samples/balloons.jpg', '09/24/2023');
INSERT INTO posts (username, caption, image_url, created_at) VALUES ('viv', '🐱 Just another lazy day with my adorable feline friend. There is something so cute about the way those whiskers twitch. 😺 #CatNap #LazySunday', 'https://res.cloudinary.com/dfcehgwjs/image/upload/v1695737766/samples/animals/cat.jpg', '09/26/2023');
INSERT INTO posts (username, caption, image_url, created_at) VALUES ('nix', 'I could not get over the view from my latest hike in Washington State.', 'https://res.cloudinary.com/dfcehgwjs/image/upload/v1695737780/samples/landscapes/nature-mountains.jpg', '09/23/2023');
INSERT INTO posts (username, caption, image_url, created_at) VALUES ('nix', 'Just ordered this dessert and cannot wait to dig right in!', 'https://res.cloudinary.com/dfcehgwjs/image/upload/v1695737767/samples/food/dessert.jpg', '09/29/2023');
INSERT INTO posts (username, caption, image_url, created_at) VALUES ('maryam', 'Pedaling through life with the wind in my hair and the open road ahead. Join me in this two-wheeled adventure!', 'https://res.cloudinary.com/dfcehgwjs/image/upload/v1695737775/samples/people/bicycle.jpg', '09/23/2023');
INSERT INTO posts (username, caption, image_url, created_at) VALUES ('kay', '🚣 "Kayaking through serene waters, where tranquility meets adventure. 🚣‍♂️', 'https://res.cloudinary.com/dfcehgwjs/image/upload/v1695737776/samples/landscapes/beach-boat.jpg', '09/27/2023');
INSERT INTO posts (username, caption, image_url, created_at) VALUES ('viv', 'Beautiful flower field from my local plant nursery', 'https://res.cloudinary.com/dfcehgwjs/image/upload/v1696174528/z3hnoqe2bmn9njtb6hti.jpg', '10/01/2023');
INSERT INTO posts (username, caption, image_url, created_at) VALUES ('maryam', 'Grooving to the sweet sounds of jazz in the streets.', 'https://res.cloudinary.com/dfcehgwjs/image/upload/v1696257363/d19uijsovspxybiydscf.jpg', '09/23/2023');
INSERT INTO posts (username, caption, image_url, created_at) VALUES ('kay', '🐶 Going to be exploring the great outdoors with my furry adventurers. From the forest trails to the mountain peaks, every step is a new discovery.🌲🏞️ #NatureLovers #AdventureBuddies', 'https://res.cloudinary.com/dfcehgwjs/image/upload/v1696111019/xjx1n1rbkrymwh26x99m.jpg', '10/02/2023');


INSERT INTO likes (username, post_id) VALUES ('viv', 2001);
INSERT INTO likes (username, post_id) VALUES ('maryam', 2002);
INSERT INTO likes (username, post_id) VALUES ('kay', 2003);
INSERT INTO likes (username, post_id) VALUES ('viv', 2004);
INSERT INTO likes (username, post_id) VALUES ('nix', 2005);
INSERT INTO likes (username, post_id) VALUES ('kay', 2006);
INSERT INTO likes (username, post_id) VALUES ('maryam', 2007);
INSERT INTO likes (username, post_id) VALUES ('nix', 2008);
INSERT INTO likes (username, post_id) VALUES ('nix', 2009);
INSERT INTO likes (username, post_id) VALUES ('maryam', 2010);

INSERT INTO comments (username, post_id, comment, comment_created) VALUES ('viv', 2002, 'so cute!', '09/25/2023');
INSERT INTO comments (username, post_id, comment, comment_created) VALUES ('maryam', 2001, 'beauty!', '09/26/2023');
INSERT INTO comments (username, post_id, comment, comment_created) VALUES ('kay', 2004, 'pretty!', '09/23/2023');
INSERT INTO comments (username, post_id, comment, comment_created) VALUES ('nix', 2003, 'love it!', '03/24/2023');


COMMIT TRANSACTION;
