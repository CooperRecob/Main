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
-- Table structure for table `rentals`
--

CREATE TABLE `rentals` (
  `id` int(11) NOT NULL,
  `dateOut` date NOT NULL,
  `returned` date NOT NULL,
  `movieID` int(11) NOT NULL,
  `memberID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `rentals`
--

INSERT INTO `rentals` (`id`, `dateOut`, `returned`, `movieID`, `memberID`) VALUES
(1, '2015-02-15', '2015-02-25', 92, 1),
(2, '2015-02-10', '2015-02-21', 79, 2),
(3, '2015-02-12', '2015-02-15', 57, 3),
(4, '2015-10-25', '2015-10-27', 85, 3),
(5, '2015-10-22', '2015-10-26', 3, 4),
(6, '2015-02-14', '2015-02-18', 65, 5),
(7, '2015-02-27', '2015-02-28', 31, 6),
(8, '2015-12-01', '2015-12-03', 17, 7),
(9, '2015-04-12', '2015-04-14', 63, 7),
(10, '2015-12-13', '2015-12-17', 65, 8),
(11, '2015-12-15', '2015-12-25', 32, 9),
(12, '2016-02-10', '2016-02-21', 26, 10),
(13, '2016-12-12', '2016-12-15', 57, 11),
(14, '2017-10-25', '2017-10-27', 48, 10),
(15, '2017-10-22', '2017-10-23', 60, 9),
(16, '2017-12-14', '2017-12-18', 65, 11),
(17, '2017-12-27', '2017-12-28', 75, 7),
(18, '2018-02-01', '2018-02-03', 73, 5),
(19, '2018-11-12', '2018-11-14', 63, 2),
(20, '2019-02-13', '2019-02-16', 65, 1),
(21, '2019-10-31', '2019-11-02', 59, 9),
(22, '2019-10-22', '2019-10-25', 63, 4),
(23, '2019-12-14', '2019-12-18', 58, 7),
(24, '2019-12-27', '2019-12-28', 18, 1),
(25, '2019-12-01', '2019-12-03', 45, 8),
(26, '2020-05-09', '2020-05-23', 81, 5),
(27, '2020-03-07', '2020-04-04', 26, 10),
(28, '2020-09-12', '2020-09-19', 77, 9),
(29, '2020-10-15', '2020-10-18', 87, 3),
(30, '2020-10-01', '2020-10-08', 96, 5),
(31, '2020-11-01', '2020-11-08', 95, 1),
(32, '2021-04-10', '2021-04-17', 99, 5),
(33, '2021-05-08', '2021-05-15', 102, 5),
(34, '2021-07-01', '2021-07-15', 117, 6),
(35, '2020-12-01', '2020-12-08', 107, 5),
(36, '2020-11-15', '2020-11-29', 109, 5),
(37, '2020-12-11', '2020-12-18', 115, 11),
(38, '2020-11-25', '2020-11-29', 117, 20),
(39, '2021-07-05', '2021-07-25', 101, 1),
(40, '2021-07-15', '2021-10-25', 93, 1);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `rentals`
--
ALTER TABLE `rentals`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `rentals`
--
ALTER TABLE `rentals`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=41;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
