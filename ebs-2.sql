-- phpMyAdmin SQL Dump
-- version 4.5.2
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Jan 20, 2018 at 10:36 AM
-- Server version: 10.1.19-MariaDB
-- PHP Version: 5.6.28

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `ebs`
--

-- --------------------------------------------------------

--
-- Table structure for table `authorities`
--

CREATE TABLE `authorities` (
  `username` varchar(80) NOT NULL,
  `authority` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `authorities`
--

INSERT INTO `authorities` (`username`, `authority`) VALUES
('emma@gmail.com', 'employee'),
('geoff@gmail.com', 'employee'),
('imtiyaz00hirani@gmail.com', 'employee'),
('jack@gmail.com', 'employee'),
('sau@gmail.com', 'employee'),
('simon@gmail.com', 'employee');

-- --------------------------------------------------------

--
-- Table structure for table `employee`
--

CREATE TABLE `employee` (
  `emp_id` int(11) NOT NULL,
  `emp_name` text,
  `emp_email` text NOT NULL,
  `emp_address` text,
  `emp_joindate` text,
  `emp_leavedate` text,
  `emp_salary` text,
  `emp_job_title` text NOT NULL,
  `username` varchar(80) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `employee`
--

INSERT INTO `employee` (`emp_id`, `emp_name`, `emp_email`, `emp_address`, `emp_joindate`, `emp_leavedate`, `emp_salary`, `emp_job_title`, `username`) VALUES
(1, 'Vinay Pathak ', 'testebs_vinay@gmail.com', '102, gurukrupa CHS, borivali west mumbai - 92.', '23/10/2015', NULL, '450000', 'java developer', 'testebs_vinay@gmail.com'),
(8, 'imtiyaz hirani', 'imtiyaz00hirani@gmail.com', 'jhjh h hjhj jh', '1/20/18', NULL, '1900000', 'Java Development Lead', 'imtiyaz00hirani@gmail.com'),
(9, 'Simon benett', 'simon@gmail.com', '102 kingley load florida', '1/20/18', NULL, '', '', 'simon@gmail.com'),
(10, 'Geoff Squire', 'geoff@gmail.com', '345, Isleworth', '1/20/18', NULL, '1500000', 'Senior Java Developer', 'geoff@gmail.com'),
(11, 'Emma Stone', 'emma@gmail.com', '88 Kinston Lane Highland park', '1/20/18', NULL, '35000', 'Web Designer', 'emma@gmail.com'),
(12, 'Saurabh Gandhi', 'sau@gmail.com', '34, delta cresent, borivali west ', '1/20/18', NULL, '600000', 'Senior Web Designer', 'sau@gmail.com'),
(13, 'Jack Sparrow', 'jack@gmail.com', 'this is jacks address ', '1/20/18', NULL, '2300000', 'Java Development Lead', 'jack@gmail.com');

-- --------------------------------------------------------

--
-- Table structure for table `employee_has_project`
--

CREATE TABLE `employee_has_project` (
  `emp_id` int(11) NOT NULL,
  `proj_id` int(11) NOT NULL,
  `date_from` text,
  `date_to` text
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `messages`
--

CREATE TABLE `messages` (
  `mid` int(11) NOT NULL,
  `from_emp` int(11) DEFAULT NULL,
  `to_emp` int(11) DEFAULT NULL,
  `date` text
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `project`
--

CREATE TABLE `project` (
  `proj_id` int(11) NOT NULL,
  `proj_name` text,
  `proj_start_date` text,
  `proj_estimated_end_date` text,
  `proj_end_date` text,
  `proj_client_name` text,
  `budget` text NOT NULL,
  `status` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `project`
--

INSERT INTO `project` (`proj_id`, `proj_name`, `proj_start_date`, `proj_estimated_end_date`, `proj_end_date`, `proj_client_name`, `budget`, `status`) VALUES
(1, 'E Shopper Web Portal', '23/12/2017', '15/03/2018', NULL, 'E Shopper Pvt Ltd', '1600000', 'open');

-- --------------------------------------------------------

--
-- Table structure for table `salary_record`
--

CREATE TABLE `salary_record` (
  `record_id` int(11) NOT NULL,
  `emp_id` int(11) DEFAULT NULL,
  `salary` text,
  `date` text
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `username` text NOT NULL,
  `password` text,
  `enabled` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`username`, `password`, `enabled`) VALUES
('imtiyaz00hirani@gmail.com', '000', 'true'),
('simon@gmail.com', '000', 'true'),
('geoff@gmail.com', '000', 'true'),
('emma@gmail.com', '000', 'true'),
('sau@gmail.com', '000', 'true'),
('jack@gmail.com', '000', 'true');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `authorities`
--
ALTER TABLE `authorities`
  ADD PRIMARY KEY (`username`);

--
-- Indexes for table `employee`
--
ALTER TABLE `employee`
  ADD PRIMARY KEY (`emp_id`);

--
-- Indexes for table `messages`
--
ALTER TABLE `messages`
  ADD PRIMARY KEY (`mid`);

--
-- Indexes for table `project`
--
ALTER TABLE `project`
  ADD PRIMARY KEY (`proj_id`);

--
-- Indexes for table `salary_record`
--
ALTER TABLE `salary_record`
  ADD PRIMARY KEY (`record_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `employee`
--
ALTER TABLE `employee`
  MODIFY `emp_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;
--
-- AUTO_INCREMENT for table `project`
--
ALTER TABLE `project`
  MODIFY `proj_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
