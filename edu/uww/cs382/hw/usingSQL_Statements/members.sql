-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Oct 26, 2022 at 10:02 PM
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
-- Table structure for table `members`
--

CREATE TABLE `members` (
  `memberID` int(11) NOT NULL,
  `firstName` varchar(15) NOT NULL,
  `lastName` varchar(15) NOT NULL,
  `phone` varchar(30) NOT NULL,
  `memberType` varchar(15) NOT NULL,
  `username` varchar(30) NOT NULL,
  `password` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `members`
--

INSERT INTO `members` (`memberID`, `firstName`, `lastName`, `phone`, `memberType`, `username`, `password`) VALUES
(1, 'Christian', 'Schmidt', '(262) 555-8353', 'Preferred', 'user1', '7c6a180b36896a0a8c02787eeafb0e4c'),
(2, 'Jill', 'Finelli', '(262) 555-1122', 'Preferred', 'user2', '6cb75f652a9b52798eb6cf2201057c73'),
(3, 'Jackie', 'Hollander', '(262) 555-7352', 'Preferred', 'user3', '819b0643d6b89dc9b579fdfc9094f28e'),
(4, 'Jean', 'Montgolfier', '(262) 555-9264', 'Regular', 'user4', '34cc93ece0ba9e3f6f235d4af979b16c'),
(5, 'Juan', 'Santiago', '(262) 555-9865', 'Student', 'user5', 'db0edd04aaac4506f7edab03ac855d56'),
(6, 'Julie', 'Smith', '(262) 555-9785', 'Preferred', 'user6', '218dd27aebeccecae69ad8408d9a36bf'),
(7, 'Louis', 'Pascal', '(262) 555-6439', 'Regular', 'user7', '00cdb7bb942cf6b290ceb97d6aca64a3'),
(8, 'Nadia', 'Likorsky', '(262) 555-8352', 'Student', 'user8', 'b25ef06be3b6948c0bc431da46c2c738'),
(9, 'Rudolph', 'Geiger', '(262) 555-6286', 'Preferred', 'user9', '5d69dd95ac183c9643780ed7027d128a'),
(10, 'Ryan', 'Greene', '(262) 555-8370', 'Preferred', 'user10', '87e897e3b54a405da144968b2ca19b45'),
(11, 'Sony', 'Nathan', '(262) 555-1234', 'Preferred', 'user11', '1e5c2776cf544e213c3d279c40719643'),
(12, 'Chris', ' Schultz', ' 262 555-8999', 'Preferred\n', 'user12', 'c24a542f884e144451f9063b79e7994e'),
(13, ' James', ' Fox', ' 262 555-1155', 'Preferred', 'user13', 'ee684912c7e588d03ccb40f17ed080c9'),
(14, ' Jake', ' Holdon', ' 262 555-7777', 'Preferred', 'user14', '8ee736784ce419bd16554ed5677ff35b'),
(15, ' Jean', ' Montegomery', ' 262 555-9666', ' Regular\r', 'user15', '9141fea0574f83e190ab7479d516630d'),
(16, ' Jual', ' Santana', ' 262 555-9888', 'Student', 'user16', '2b40aaa979727c43411c305540bbed50'),
(17, ' Julie', ' Brown', ' 262 555-9777', 'Student', 'user17', 'a63f9709abc75bf8bd8f6e1ba9992573'),
(18, ' Louis', ' Armstrong', ' 262 555-6445', 'Student', 'user18', '80b8bdceb474b5127b6aca386bb8ce14'),
(19, ' Nate', ' Lancaster', ' 262 555-8333', 'Student', 'user19', 'e532ae6f28f4c2be70b500d3d34724eb'),
(20, ' Derek', ' Randall', ' 262 555-6226', 'Preferred', 'user20', 'aee67d9bb569ad1562f7b67cfccbd2ef');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `members`
--
ALTER TABLE `members`
  ADD PRIMARY KEY (`memberID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `members`
--
ALTER TABLE `members`
  MODIFY `memberID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
