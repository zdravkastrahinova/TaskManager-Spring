-- phpMyAdmin SQL Dump
-- version 4.5.4.1deb2ubuntu1
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Jun 21, 2016 at 03:43 PM
-- Server version: 5.7.12-0ubuntu1
-- PHP Version: 7.0.4-7ubuntu2.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

CREATE DATABASE IF NOT EXISTS TaskManager;
USE TaskManager;

--
-- Database: `TaskManager`
--

-- --------------------------------------------------------

--
-- Table structure for table `Tasks`
--

CREATE TABLE `Tasks` (
  `id` int(11) NOT NULL,
  `userId` int(11) NOT NULL,
  `title` varchar(50) NOT NULL,
  `content` varchar(255) NOT NULL,
  `status` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `Tasks`
--

INSERT INTO `Tasks` (`id`, `userId`, `title`, `content`, `status`) VALUES
(1, 1, 'Task 1', 'Create database connection', 2),
(3, 2, 'Task 001', 'Implement repository pattern', 2),
(6, 1, 'Task 2', 'Add data into tables', 2),
(10, 2, 'Task 002', 'Optimize repositories', 2),
(13, 1, 'Task 4', 'Upload app', 1),
(15, 1, 'Final task', 'Test app', 1);

-- --------------------------------------------------------

--
-- Table structure for table `Users`
--

CREATE TABLE `Users` (
  `id` int(11) NOT NULL,
  `username` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `Users`
--

INSERT INTO `Users` (`id`, `username`, `password`) VALUES
(1, 'admin', 'adminpass'),
(2, 'user', 'userpass'),
(3, 'nemo', 'nemopass'),
(20, 'test', 'testpass');

-- --------------------------------------------------------

--
-- Table structure for table `Users_Tasks`
--

CREATE TABLE `Users_Tasks` (
  `Users_id` int(11) NOT NULL,
  `tasks_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `Tasks`
--
ALTER TABLE `Tasks`
  ADD PRIMARY KEY (`id`),
  ADD KEY `userId` (`userId`);

--
-- Indexes for table `Users`
--
ALTER TABLE `Users`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `Unique` (`username`);

--
-- Indexes for table `Users_Tasks`
--
ALTER TABLE `Users_Tasks`
  ADD PRIMARY KEY (`Users_id`,`tasks_id`),
  ADD UNIQUE KEY `UK_7o8q466vplkggigabh8wjbwvg` (`tasks_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `Tasks`
--
ALTER TABLE `Tasks`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;
--
-- AUTO_INCREMENT for table `Users`
--
ALTER TABLE `Users`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=22;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `Tasks`
--
ALTER TABLE `Tasks`
  ADD CONSTRAINT `FK_2e9skfq88wyw8bi2dm3e8eivr` FOREIGN KEY (`userId`) REFERENCES `Users` (`id`);

--
-- Constraints for table `Users_Tasks`
--
ALTER TABLE `Users_Tasks`
  ADD CONSTRAINT `FK_6gsolk1skw2ey4g4kcga55adb` FOREIGN KEY (`Users_id`) REFERENCES `Users` (`id`),
  ADD CONSTRAINT `FK_7o8q466vplkggigabh8wjbwvg` FOREIGN KEY (`tasks_id`) REFERENCES `Tasks` (`id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
