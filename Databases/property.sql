-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jul 20, 2022 at 03:25 AM
-- Server version: 10.4.24-MariaDB
-- PHP Version: 8.1.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `easypg`
--

-- --------------------------------------------------------

--
-- Table structure for table `property`
--

CREATE TABLE `property` (
  `propertyId` bigint(11) NOT NULL,
  `title` varchar(45) NOT NULL,
  `type` varchar(45) NOT NULL,
  `rooms` int(11) NOT NULL,
  `rent` int(11) NOT NULL,
  `propertyDesc` varchar(1000) NOT NULL,
  `address` varchar(100) NOT NULL,
  `documentPicture` varchar(45) DEFAULT NULL,
  `status` varchar(45) NOT NULL,
  `modifiedDate` date NOT NULL,
  `createdDate` date NOT NULL,
  `onlyfor` varchar(45) NOT NULL,
  `furnished` varchar(45) NOT NULL,
  `propertyPicture` varchar(500) DEFAULT NULL,
  `pincode` bigint(10) DEFAULT NULL,
  `isActive` tinyint(1) DEFAULT 1,
  `isDeleted` tinyint(1) DEFAULT 0,
  `areaId` int(11) NOT NULL,
  `userId` int(11) NOT NULL,
  `beds` int(10) NOT NULL,
  `baths` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `property`
--
ALTER TABLE `property`
  ADD PRIMARY KEY (`propertyId`),
  ADD KEY `areaId` (`areaId`),
  ADD KEY `userId` (`userId`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `property`
--
ALTER TABLE `property`
  MODIFY `propertyId` bigint(11) NOT NULL AUTO_INCREMENT;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `property`
--
ALTER TABLE `property`
  ADD CONSTRAINT `property_ibfk_1` FOREIGN KEY (`areaId`) REFERENCES `area_info` (`areaId`),
  ADD CONSTRAINT `property_ibfk_2` FOREIGN KEY (`userId`) REFERENCES `user_master` (`userId`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
