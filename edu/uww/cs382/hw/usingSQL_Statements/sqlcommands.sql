USE `moviestore`;

SELECT firstName, lastName, phone FROM members;

SELECT title, year, movieId FROM movies WHERE type = 'Action';

SELECT title, type, dateOut FROM movies, rentals WHERE movies.movieId = rentals.movieID AND dateOut < '2018-12-31';

SELECT title, type, dateOut FROM movies, rentals WHERE movies.movieId = rentals.movieID AND dateOut > '2018-12-31' AND type = 'Action';

SELECT title, type, year FROM movies WHERE type = 'Drama' AND year BETWEEN 2010 AND 2021;

SELECT title, type, year, memberID FROM movies, rentals WHERE movies.movieId = rentals.movieID AND type = 'Drama' AND year BETWEEN 2010 AND 2021;

SELECT firstName, lastName, title, type, year FROM members, movies, rentals WHERE members.memberId = rentals.memberID AND movies.movieId = rentals.movieID;

SELECT firstName, lastName, title, type, year FROM members, movies, rentals WHERE members.memberId = rentals.memberID AND movies.movieId = rentals.movieID AND (type = 'Drama' OR type = 'Action');

SELECT firstName, lastName, title, type, year FROM members, movies, rentals WHERE members.memberId = rentals.memberID AND movies.movieId = rentals.movieID AND members.memberId = 5;

SELECT title, type, year, description FROM disney_movies WHERE type = 'Drama';

SELECT title, type, year, description FROM disney_movies WHERE type = 'Drama' OR type = 'Comedy';

SELECT title, type, year, description FROM disney_movies WHERE (type = 'Drama' OR type = 'Comedy') AND year > 2020;