/* movies table details */

INSERT INTO `movie_cruiser`.`movies` (`mov_id`, `mov_title`, `mov_box_office`, `mov_active`, `mov_date_of_launch`, `mov_genre`, `mov_has_teaser`) VALUES ('1', 'Avatar', '2787965087', '1', '2019/12/25', 'Science Fiction', '1');
INSERT INTO `movie_cruiser`.`movies` (`mov_id`, `mov_title`, `mov_box_office`, `mov_active`, `mov_date_of_launch`, `mov_genre`, `mov_has_teaser`) VALUES ('2', 'The Avengers', '1518812988', '1', '2019/10/03', 'Superhero', '0');
INSERT INTO `movie_cruiser`.`movies` (`mov_id`, `mov_title`, `mov_box_office`, `mov_active`, `mov_date_of_launch`, `mov_genre`, `mov_has_teaser`) VALUES ('3', 'Titanic', '2187463944', '1', '2019/11/21', 'Romance', '0');
INSERT INTO `movie_cruiser`.`movies` (`mov_id`, `mov_title`, `mov_box_office`, `mov_active`, `mov_date_of_launch`, `mov_genre`, `mov_has_teaser`) VALUES ('4', 'Jurassic World', '1671713208', '0', '2019/11/30', 'Science Friction', '1');
INSERT INTO `movie_cruiser`.`movies` (`mov_id`, `mov_title`, `mov_box_office`, `mov_active`, `mov_date_of_launch`, `mov_genre`, `mov_has_teaser`) VALUES ('5', 'Avengers: End Game', '2750760348', '1', '2020/01/01', 'Superhero', '1');

/* User table Details */

insert into user(us_id,us_name) values (1,'Shreya');
insert into user(us_id,us_name) values (2,'Avani');

/* favorites table Details */

insert into favorites(fav_us_id,fav_mov_id) values (1,1);
insert into favorites(fav_us_id,fav_mov_id) values (1,3);
insert into favorites(fav_us_id,fav_mov_id) values (1,5);

-- View Movies List Admin
select mov_id, mov_title, mov_box_office, mov_active, mov_date_of_launch, mov_genre, mov_has_teaser from movie_cruiser.movies;

-- View Movies List Customer 
select mov_id, mov_title, mov_box_office, mov_active, mov_date_of_launch, mov_genre, mov_has_teaser from movie_cruiser.movies where mov_active= '1' and mov_date_of_launch > (select CURDATE());

-- Edit Movies
select mov_id, mov_title, mov_box_office, mov_active, mov_date_of_launch, mov_genre, mov_has_teaser from movie_cruiser.movies where mov_id=1;
update movie_cruiser.movies
set 
mov_title= 'Harry Potter', 
mov_box_office= '21260893247', 
mov_active= '1', 
mov_date_of_launch= '2020-01-05', 
mov_genre= 'Thriller', 
mov_has_teaser = '0'
where mov_id=5; 

-- Add to Favorites
insert into favorites(fav_us_id,fav_mov_id) values (1,1);
insert into favorites(fav_us_id,fav_mov_id) values (1,3);
insert into favorites(fav_us_id,fav_mov_id) values (1,5);

-- View Favorites
select fav_us_id,fav_mov_id from movie_cruiser.favorites;
select mov_name,mov_box_office,mov_active,mov_date_of_launch,mov_genre,mov_has_teaser from
movie_cruiser.movies
inner join
movie_cruiser.favorites on fav_mov_id=mov_id
inner join
movie_cruiser.user on mov_id=us_id
where fav_us_id=1;


-- count no of favorites
select count(favorites.fav_id) as no_of_favorite
from movie_cruiser.favorites;


-- Remove Item from Favorites
delete from movie_cruiser.favorites
where fav_us_id=1 and fav_mov_id=1;

select fav_us_id,fav_mov_id from movie_cruiser.favorites;

DELETE FROM movie_cruiser.favorites
WHERE fav_id = '8';


-- Alter table
ALTER TABLE `movie_cruiser`.`movies` 
CHANGE COLUMN `mov_name` `mov_title` VARCHAR(100) NULL DEFAULT NULL ;
