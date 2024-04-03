-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Oct 26, 2022 at 10:00 PM
-- Server version: 10.4.21-MariaDB
-- PHP Version: 7.4.23

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `moviestore`
--

-- --------------------------------------------------------

--
-- Table structure for table `movies`
--

CREATE TABLE `movies` (
  `movieID` int(11) NOT NULL,
  `title` varchar(100) NOT NULL,
  `year` year(4) NOT NULL,
  `type` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `movies`
--

INSERT INTO `movies` (`movieID`, `title`, `year`, `type`) VALUES
(1, 'All Quiet on the Western Front', 1930, 'Adventure'),
(2, 'Gone with the Wind', 1939, 'Romance'),
(3, 'Casablanca', 1940, 'Romance'),
(4, 'The Lost Weekend', 1945, 'Drama'),
(5, 'Hamlet', 1948, 'Drama'),
(6, 'All About Eve', 1950, 'Suspense'),
(7, 'From Here to Eternity', 1953, 'Comedy'),
(8, 'On the Waterfront', 1954, 'Drama'),
(9, 'Around the World in 80 Days', 1955, 'Adventure'),
(10, 'Gigi', 1958, 'Musical'),
(11, 'Ben Hur', 1959, 'Drama'),
(12, 'West Side Story', 1961, 'Romance'),
(13, 'Lawrence of Arabia', 1962, 'Drama'),
(14, 'My Fair Lady', 1964, 'Musical'),
(15, 'The Sound of Music', 1965, 'Drama'),
(16, 'A Man for All Seasons', 1966, 'Adventure'),
(17, 'Oliver!', 1968, 'Musical'),
(18, 'Airport', 1970, 'Drama'),
(19, 'The French Connection', 1971, 'Drama'),
(20, 'The Godfather', 1972, 'Drama'),
(21, 'The Sting', 1973, 'Drama'),
(22, 'The Godfather, Part 2', 1974, 'Drama'),
(23, 'One Flew Over the Cuckoo\'s Nest', 1975, 'Drama'),
(24, 'Rocky', 1976, 'Action'),
(25, 'Annie Hall', 1977, 'Musical'),
(26, 'Star Wars', 1977, 'Sci-Fi'),
(27, 'The Deer Hunter', 1978, 'Drama'),
(28, 'Kramer vs. Kramer', 1979, 'Drama'),
(29, 'Ordinary People', 1980, 'Comedy'),
(30, 'Chariots of Fire', 1981, 'Drama'),
(31, 'Raiders of the Lost Ark', 1981, 'Adventure'),
(32, 'ET', 1982, 'Sci-Fi'),
(33, 'Tootsie', 1982, 'Comedy'),
(34, 'Gandhi', 1982, 'Drama'),
(35, 'Terms of Endearment', 1983, 'Drama'),
(36, 'Amadeus', 1984, 'Drama'),
(37, 'Out of Africa', 1985, 'Drama'),
(38, 'Howard the Duck', 1986, 'Comedy'),
(39, 'Platoon', 1986, 'Drama'),
(40, 'Overboard', 1987, 'Comedy'),
(41, 'The Last Emperor', 1987, 'Drama'),
(42, 'The Princess Bride', 1987, 'Drama'),
(43, 'Big', 1988, 'Comedy'),
(44, 'Rain Man', 1988, 'Drama'),
(45, 'Who Framed Roger Rabbit', 1998, 'Animation'),
(46, 'Driving Miss Daisy', 1989, 'Comedy'),
(47, 'Dances With Wolves', 1990, 'Drama'),
(48, 'Rescuers Down Under', 1990, 'Animation'),
(49, 'Beauty and the Beast', 1991, 'Animation'),
(50, 'Silence of the Lambs', 1991, 'Mystery'),
(51, 'Unforgiven', 1992, 'Western'),
(52, 'Schindler\'s List', 1993, 'Drama'),
(53, 'Forrest Gump', 1994, 'Comedy'),
(55, 'Maverick', 1994, 'Western'),
(56, 'The Lion King', 1994, 'Animation'),
(57, 'Braveheart', 1995, 'Drama'),
(58, 'Seven', 1995, 'Drama'),
(59, 'Fargo', 1996, 'Drama'),
(60, 'The English Patient', 1996, 'Drama'),
(61, 'Titanic', 1997, 'Drama'),
(62, 'Shakespeare in Love', 1998, 'Drama'),
(63, 'Matrix', 1999, 'Adventure'),
(64, 'Tarzan', 1999, 'Animation'),
(65, 'Star Wars: Episode I', 1999, 'Sci-Fi'),
(66, 'The Lord of the Rings: the Fellowship of the Ring', 2002, 'Action'),
(67, 'The Pianist', 2002, 'Drama'),
(68, 'Finding Nemo', 2003, 'Animation'),
(69, 'Million Dollar Baby', 2004, 'Drama'),
(70, 'Sin City', 2005, 'Action'),
(71, 'Batman Begins', 2005, 'Action'),
(72, 'V for Vandetta', 2005, 'Action'),
(73, 'The Departed', 2006, 'Mystery'),
(74, 'The Prestige', 2006, 'Drama'),
(75, 'No Country for Old Men', 2007, 'Mystery'),
(76, 'The Bourne Ultimatum', 2007, 'Action'),
(77, 'Into the Wild', 2007, 'Adventure'),
(78, 'Ratatouille', 2008, 'Animation'),
(79, 'The Dark Knight', 2008, 'Action'),
(80, 'Slumdog Millionaire', 2008, 'Drama'),
(81, 'Crash', 2005, 'Drama'),
(82, 'A Beautiful Mind', 2001, 'Drama'),
(83, 'The Artist', 2011, 'Drama'),
(84, 'The King\'s Speech', 2010, 'Drama'),
(85, 'Chicago', 2002, 'Musical'),
(86, 'Birdman', 2014, 'Adventure'),
(87, 'Argo', 2012, 'Action'),
(88, 'Gladiator', 2000, 'Sci-Fi'),
(89, 'American Beauty', 1999, 'Drama'),
(90, 'The Hurt Locker', 2009, 'Action'),
(91, '12 Years a Slave', 2013, 'Adventure'),
(92, 'The Lord of the Rings: The Return of the King', 2003, 'Action'),
(93, 'The Jungle Book', 2016, 'Adventure'),
(94, 'Bridge of Spies', 2015, 'Drama'),
(95, 'Inside Out', 2015, 'Animation'),
(96, 'The Imitation Game', 2014, 'Drama'),
(97, 'Gravity', 2013, 'Sci-Fi'),
(98, 'Interstellar', 2014, 'Sci-Fi'),
(99, 'Avatar', 2009, 'Sci-Fi'),
(100, 'Star Wars: The Force Awakens', 2015, 'Sci-Fi'),
(101, 'Star Wars: The Last Jedi', 2017, 'Sci-Fi'),
(102, 'Worth', 2020, 'Drama'),
(103, '365 Days', 2020, 'Romance'),
(104, 'The Courier', 2020, 'Drama'),
(105, 'Tenet', 2020, 'Sci-Fi'),
(106, 'News of the World', 2020, 'Adventure'),
(107, 'The Father', 2020, 'Drama'),
(108, 'The Night House', 2020, 'Mystery'),
(109, 'Hamilton', 2020, 'Drama'),
(110, 'Soul', 2020, 'Animation'),
(111, 'Mulan', 2020, 'Action'),
(112, 'Avengers: Endgame', 2019, 'Action'),
(113, 'Knives Out', 2019, 'Comedy'),
(114, '1917', 2019, 'Action'),
(115, 'Jorker', 2019, 'Drama'),
(116, 'Spider-Man: Far Home', 2019, 'Action'),
(117, 'The Lighthouse', 2019, 'Drama'),
(118, 'After', 2019, 'Romance'),
(119, 'The Gentlemen', 2019, 'Action'),
(120, 'Abominable', 2019, 'Animation');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `movies`
--
ALTER TABLE `movies`
  ADD PRIMARY KEY (`movieID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `movies`
--
ALTER TABLE `movies`
  MODIFY `movieID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=121;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
