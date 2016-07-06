-- phpMyAdmin SQL Dump
-- version 4.2.7.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Sep 05, 2014 at 03:00 AM
-- Server version: 5.6.20
-- PHP Version: 5.5.15

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `ums`
--

-- --------------------------------------------------------

--
-- Table structure for table `account`
--

CREATE TABLE IF NOT EXISTS `account` (
  `studentid` varchar(15) NOT NULL,
  `semester` varchar(20) NOT NULL,
  `debit` double NOT NULL,
  `credit` double NOT NULL,
  `balance` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `account`
--

INSERT INTO `account` (`studentid`, `semester`, `debit`, `credit`, `balance`) VALUES
('14-00002-3', 'Fall 14-15', 60000, 2000, 13000);

-- --------------------------------------------------------

--
-- Table structure for table `accounts`
--

CREATE TABLE IF NOT EXISTS `accounts` (
  `studentid` varchar(20) NOT NULL DEFAULT '',
  `date` varchar(20) NOT NULL,
  `semester` varchar(20) NOT NULL,
  `debit` double NOT NULL,
  `credit` double NOT NULL,
  `balance` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `accounts`
--

INSERT INTO `accounts` (`studentid`, `date`, `semester`, `debit`, `credit`, `balance`) VALUES
('14-00002-3', '', 'Fall 14-15', 48000, 0, 48000),
('14-00001-3', '', 'Fall 14-15', 84000, 0, 84000),
('14-00027-3', '', 'Fall 14-15', 84000, 0, 84000),
('14-00001-3', '', 'Fall 14-15', 84000, 30000, 54000),
('14-00001', '', 'Fall 14-15', 0, 0, 0),
('14-00027-3', '4/9/2014', 'Fall 14-15', 84000, 30000, 54000),
('14-00027-3', '4/9/2014', 'Fall 14-15', 84000, 3000, 81000),
('14-00001-3', '2014/09/04 05:30:57', 'Fall 14-15', 84000, 700, 83300),
('14-00001-3', '2014/09/04 05:30:57', 'Fall 14-15', 84000, 1000, 83000),
('14-00001-3', '2014/09/04 05:32:35', 'Fall 14-15', 84000, 3000, 81000),
('14-00001-3', '2014/09/04 05:32:44', 'Fall 14-15', 84000, 2000, 82000),
('14-00001-3', '2014/09/04 05:32:59', 'Fall 14-15', 84000, 2000, 82000),
('14-00001-3', '2014/09/04 05:33:13', 'Fall 14-15', 84000, 2000, 82000),
('14-00002-3', '2014/09/04 06:10:58', 'Fall 14-15', 60000, 30000, 30000),
('14-00002-3', '2014/09/04 06:12:25', 'Fall 14-15', 60000, 1000, 29000),
('14-00002-3', '2014/09/04 06:15:29', 'Fall 14-15', 60000, 2000, 27000),
('14-00002-3', '2014/09/04 06:16:20', 'Fall 14-15', 60000, 3000, 24000),
('14-00002-3', '2014/09/04 06:20:45', 'Fall 14-15', 60000, 1000, 23000),
('14-00002-3', '2014/09/04 06:23:55', 'Fall 14-15', 60000, 3000, 20000),
('14-00002-3', '2014/09/04 06:24:03', 'Fall 14-15', 60000, 1000, 19000),
('14-00002-3', '2014/09/04 06:24:51', 'Fall 14-15', 60000, 1000, 18000),
('14-00002-3', '2014/09/04 06:36:24', 'Fall 14-15', 60000, 3000, 15000),
('14-00002-3', '2014/09/04 09:14:59', 'Fall 14-15', 60000, 2000, 13000);

-- --------------------------------------------------------

--
-- Table structure for table `course`
--

CREATE TABLE IF NOT EXISTS `course` (
  `coursedescription` varchar(50) NOT NULL,
  `code` varchar(20) NOT NULL,
  `credit` double NOT NULL,
  `dept` varchar(50) NOT NULL,
  `prerequsite` varchar(20) NOT NULL,
  `fdept` varchar(50) NOT NULL,
  `status` varchar(15) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `course`
--

INSERT INTO `course` (`coursedescription`, `code`, `credit`, `dept`, `prerequsite`, `fdept`, `status`) VALUES
('Concrete Mathematics', 'CS1202', 3, 'CSE', 'CS1201', 'CSE', 'unavailable'),
('Algorithm', 'CS1201', 3, 'CSE', 'CS1102', 'CSE', 'unavailable'),
('English Reading And Speaking', 'ENG1001', 3, 'ENGLISH', 'none', 'ENGLISH', 'unavailable'),
('Calculas', 'MAT101', 3, 'MATH', 'none', 'CSE', 'unavailable'),
('Computer Fundamental', 'CS101', 3, 'CSE', 'none', 'CSE', 'unavailable'),
('Discrete Math', 'CS', 3, 'CSE', 'MAT101', 'CSE', 'unavailable'),
('Operating System', 'CS2010', 3, 'CSE', 'CS101', 'CSE', 'unavailable'),
('OOP', 'CS2001', 3, 'CSE', 'CS0123', 'CSE', 'unavailable');

-- --------------------------------------------------------

--
-- Table structure for table `faculty`
--

CREATE TABLE IF NOT EXISTS `faculty` (
  `firstname` varchar(20) NOT NULL,
  `lastname` varchar(20) NOT NULL,
  `fathername` varchar(30) NOT NULL,
  `mothername` varchar(30) NOT NULL,
  `gender` varchar(10) NOT NULL,
  `dob` varchar(11) NOT NULL,
  `homeaddress` varchar(150) NOT NULL,
  `city` varchar(20) NOT NULL,
  `postalcode` int(11) NOT NULL,
  `country` varchar(20) NOT NULL,
  `entrydate` varchar(11) NOT NULL,
  `designation` varchar(20) NOT NULL,
  `id` varchar(11) NOT NULL,
  `department` varchar(30) NOT NULL,
  `status` varchar(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `faculty`
--

INSERT INTO `faculty` (`firstname`, `lastname`, `fathername`, `mothername`, `gender`, `dob`, `homeaddress`, `city`, `postalcode`, `country`, `entrydate`, `designation`, `id`, `department`, `status`) VALUES
('Mostafijur', 'Rahaman', 'Dalil Uddin', 'Mariyam', 'Male', '01/10/1980', '16/2 South Ibrahimpur, Dhaka cant.', 'Dhaka', 1206, 'Bangladesh', '27/08/2014', 'Lacturer', '14-00000-1', 'CSE', 'Active'),
('Mohibur', 'Rahaman', 'Dalil Uddin', 'Mariyam', 'Male', '10/10/1990', '16/2 Omor Ali len', 'Dhaka', 1212, 'Bangladesh', '29/08/2014', 'Associate Professor', '14-00001-2', 'EEE', 'Active'),
('Hamidur', 'Rahaman', 'Rafiq Rahman', 'Renu', 'Male', '01/12/1985', 'Chandpur', 'Chandpur', 10001, 'Bangladesh', '30/8/2014', 'Lacturer', '14-00004', 'BBA', 'Active'),
('Zakir', 'Khan', 'Zohirul Khan', 'Zerin Khan', 'Male', '01/03/1975', 'Badda,Dhaka', 'Dhaka', 1212, 'Bangladesh', '30/8/2014', 'Professor', '14-00003', 'EEE', 'Active');

-- --------------------------------------------------------

--
-- Table structure for table `fall1415`
--

CREATE TABLE IF NOT EXISTS `fall1415` (
  `semester` varchar(15) DEFAULT NULL,
  `courseid` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `fall1415`
--

INSERT INTO `fall1415` (`semester`, `courseid`) VALUES
('Fall 14-15', 'CS1202'),
('Fall 14-15', 'CS1201'),
('Fall 14-15', 'ENG1001'),
('Fall 14-15', 'MAT101'),
('Fall 14-15', 'CS101'),
('Fall 14-15', 'CS'),
('Fall 14-15', 'CS2010'),
('Fall 14-15', 'CS2001');

-- --------------------------------------------------------

--
-- Table structure for table `fall1415cs`
--

CREATE TABLE IF NOT EXISTS `fall1415cs` (
  `studentid` varchar(15) NOT NULL DEFAULT '',
  `semester` varchar(20) DEFAULT NULL,
  `courseid` varchar(15) DEFAULT NULL,
  `credit` double DEFAULT NULL,
  `mid` double DEFAULT NULL,
  `final` double DEFAULT NULL,
  `result` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `fall1415cs`
--

INSERT INTO `fall1415cs` (`studentid`, `semester`, `courseid`, `credit`, `mid`, `final`, `result`) VALUES
('14-00001-3', 'Fall 14-15', 'CS', 3, 0, 0, 0),
('14-00002-3', 'Fall 14-15', 'CS', 3, 0, 0, 0);

-- --------------------------------------------------------

--
-- Table structure for table `fall1415cs101`
--

CREATE TABLE IF NOT EXISTS `fall1415cs101` (
  `studentid` varchar(15) NOT NULL DEFAULT '',
  `semester` varchar(20) DEFAULT NULL,
  `courseid` varchar(15) DEFAULT NULL,
  `credit` double DEFAULT NULL,
  `mid` double DEFAULT NULL,
  `final` double DEFAULT NULL,
  `result` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `fall1415cs101`
--

INSERT INTO `fall1415cs101` (`studentid`, `semester`, `courseid`, `credit`, `mid`, `final`, `result`) VALUES
('14-00001-3', 'Fall 14-15', 'CS101', 3, 0, 0, 0),
('14-00002-3', 'Fall 14-15', 'CS101', 3, 0, 0, 0);

-- --------------------------------------------------------

--
-- Table structure for table `fall1415cs1201`
--

CREATE TABLE IF NOT EXISTS `fall1415cs1201` (
  `studentid` varchar(15) NOT NULL DEFAULT '',
  `semester` varchar(20) DEFAULT NULL,
  `courseid` varchar(15) DEFAULT NULL,
  `credit` double DEFAULT NULL,
  `mid` double DEFAULT NULL,
  `final` double DEFAULT NULL,
  `result` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `fall1415cs1202`
--

CREATE TABLE IF NOT EXISTS `fall1415cs1202` (
  `studentid` varchar(15) NOT NULL DEFAULT '',
  `semester` varchar(20) DEFAULT NULL,
  `courseid` varchar(15) DEFAULT NULL,
  `credit` double DEFAULT NULL,
  `mid` double DEFAULT NULL,
  `final` double DEFAULT NULL,
  `result` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `fall1415cs2001`
--

CREATE TABLE IF NOT EXISTS `fall1415cs2001` (
  `studentid` varchar(15) NOT NULL DEFAULT '',
  `semester` varchar(20) DEFAULT NULL,
  `courseid` varchar(15) DEFAULT NULL,
  `credit` double DEFAULT NULL,
  `mid` double DEFAULT NULL,
  `final` double DEFAULT NULL,
  `result` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `fall1415cs2010`
--

CREATE TABLE IF NOT EXISTS `fall1415cs2010` (
  `studentid` varchar(15) NOT NULL DEFAULT '',
  `semester` varchar(20) DEFAULT NULL,
  `courseid` varchar(15) DEFAULT NULL,
  `credit` double DEFAULT NULL,
  `mid` double DEFAULT NULL,
  `final` double DEFAULT NULL,
  `result` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `fall1415cs2010`
--

INSERT INTO `fall1415cs2010` (`studentid`, `semester`, `courseid`, `credit`, `mid`, `final`, `result`) VALUES
('14-00001-3', 'Fall 14-15', 'CS2010', 3, 0, 0, 0),
('14-00002-3', 'Fall 14-15', 'CS2010', 3, 0, 0, 0);

-- --------------------------------------------------------

--
-- Table structure for table `fall1415eng1001`
--

CREATE TABLE IF NOT EXISTS `fall1415eng1001` (
  `studentid` varchar(15) NOT NULL DEFAULT '',
  `semester` varchar(20) DEFAULT NULL,
  `courseid` varchar(15) DEFAULT NULL,
  `credit` double DEFAULT NULL,
  `mid` double DEFAULT NULL,
  `final` double DEFAULT NULL,
  `result` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `fall1415mat101`
--

CREATE TABLE IF NOT EXISTS `fall1415mat101` (
  `studentid` varchar(15) NOT NULL DEFAULT '',
  `semester` varchar(20) DEFAULT NULL,
  `courseid` varchar(15) DEFAULT NULL,
  `credit` double DEFAULT NULL,
  `mid` double DEFAULT NULL,
  `final` double DEFAULT NULL,
  `result` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `fall1415mat101`
--

INSERT INTO `fall1415mat101` (`studentid`, `semester`, `courseid`, `credit`, `mid`, `final`, `result`) VALUES
('14-00001-3', 'Fall 14-15', 'MAT101', 3, 0, 0, 0),
('14-00002-3', 'Fall 14-15', 'MAT101', 3, 0, 0, 0);

-- --------------------------------------------------------

--
-- Table structure for table `semester`
--

CREATE TABLE IF NOT EXISTS `semester` (
  `name` varchar(20) NOT NULL,
  `status` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `semester`
--

INSERT INTO `semester` (`name`, `status`) VALUES
('Fall 14-15', 'active');

-- --------------------------------------------------------

--
-- Table structure for table `staff`
--

CREATE TABLE IF NOT EXISTS `staff` (
  `firstname` varchar(20) NOT NULL,
  `lastname` varchar(20) NOT NULL,
  `fathername` varchar(30) NOT NULL,
  `mothername` varchar(30) NOT NULL,
  `gender` varchar(10) NOT NULL,
  `dob` varchar(11) NOT NULL,
  `homeaddress` varchar(150) NOT NULL,
  `city` varchar(20) NOT NULL,
  `postalcode` int(11) NOT NULL,
  `country` varchar(20) NOT NULL,
  `entrydate` varchar(11) NOT NULL,
  `designation` varchar(20) NOT NULL,
  `id` varchar(11) NOT NULL,
  `department` varchar(30) NOT NULL,
  `status` varchar(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `staff`
--

INSERT INTO `staff` (`firstname`, `lastname`, `fathername`, `mothername`, `gender`, `dob`, `homeaddress`, `city`, `postalcode`, `country`, `entrydate`, `designation`, `id`, `department`, `status`) VALUES
('Abu', 'Bakkor', 'Baten', 'Nilofer', 'Male', '01/01/1980', 'Badda', 'Dhaka', 1212, 'Bangladesh', '29/08/2014', 'Staff', '14-00001-1', 'Accounts', 'Active'),
('Mostafijur', 'Rahaman', 'Dalil Uddin', 'Mariyam', 'Male', '08/10/1992', '16/2 omor ali len, Rampura', 'Dhaka', 1212, 'Bangladesh', '27/08/2014', 'Executive', '11-00000-1', 'Accounts', 'Active'),
('Rabiul', 'Islam', 'Munshi Gazi', 'Saleha Khaton', 'Male', '01/09/1980', 'Dhaka', 'Dhaka', 1203, 'Bangladesh', '30/8/2014', 'Staff', '14-00004', 'HR', 'Active'),
('Kabir', 'Islam', 'Baker Ali', 'Morzina Begum', 'Male', '01/05/1975', 'Chandpur', 'Chandpur', 1001, 'Bangladesh', '30/8/2014', 'Executive', '14-00003', 'Accounts', 'Active');

-- --------------------------------------------------------

--
-- Table structure for table `student`
--

CREATE TABLE IF NOT EXISTS `student` (
  `firstname` varchar(20) NOT NULL,
  `lastname` varchar(20) NOT NULL,
  `fathername` varchar(30) NOT NULL,
  `mothername` varchar(30) NOT NULL,
  `gender` varchar(10) NOT NULL,
  `dob` varchar(11) NOT NULL,
  `homeaddress` varchar(150) NOT NULL,
  `city` varchar(20) NOT NULL,
  `postalcode` int(11) NOT NULL,
  `country` varchar(20) NOT NULL,
  `regdate` varchar(11) NOT NULL,
  `semester` varchar(20) NOT NULL,
  `id` varchar(20) NOT NULL,
  `department` varchar(30) NOT NULL,
  `status` varchar(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `student`
--

INSERT INTO `student` (`firstname`, `lastname`, `fathername`, `mothername`, `gender`, `dob`, `homeaddress`, `city`, `postalcode`, `country`, `regdate`, `semester`, `id`, `department`, `status`) VALUES
('Mostafijur', 'Rahaman', 'Dalil Uddin', 'Mariyam', 'Male', '01/01/1993', 'omor ali len', 'Dhaka', 1212, 'Bangladesh', '26/08/2014', 'fall 14-15', '14-00001-3', 'CSE', 'Student'),
('Jannatul', 'Ferdous', 'Azgor Sha', 'Zamila Khaton', 'Female', '01/01/1993', '16/2 south ibrahimpur, Dhaka cant, Dhaka 1206', 'Dhaka', 1206, 'Bangladesh', '26/08/2014', 'Fall 14-15', '14-00002-3', 'CSE', 'Student'),
('Miftawor', 'Rahaman', 'Mojibor Rahaman', 'Fancy', 'Male', '25/11/2000', '16/2 omor ali leen , Rampura, Dhaka 1212', 'Dhaka', 1212, 'Bangladesh', '26/08/2014', 'Fall 14-15', '14-00003-1', 'ARCH', 'Student'),
('Maksudur', 'Rahaman', 'Karim Ali', 'Jobeda Khatun', 'Male', '01/09/1994', 'Ibrahimpur, Dhaka cant.', 'Dhaka', 1206, 'Bangladesh', '27/08/2014', 'Fall 14-15', '14-00004-3', 'BBA', 'Student'),
('Mostafijur', 'Pavel', 'Dalil Uddin', 'Mariyam', 'Male', '01/01/1995', '16/2 rampura rampura bazar', 'Dhaka', 1212, 'Banglasesh', '27/08/2014', 'Fall 14-15', '14-00005-3', 'MATH', 'Student'),
('Mohit', 'Islam', 'Rakibul hasan', 'Begum', 'Male', '01/01/1990', 'Danmondi', 'Dhaka', 1203, 'Bangladesh', '28/08/2014', 'Fall 14-15', '14-00006-3', 'STATISTICS', 'Student'),
('Shamim', 'Islam', 'Rafikul Islam', 'Zobeda Khaton', 'Male', '01/01/1991', 'Matlab,Chandpur', 'Chandpur', 1005, 'Bangladesh', '30/8/2014', 'fall 14-15', '14-00013-3', 'STATISTICS', 'Student'),
('Sinthia', 'Akter', 'Alom Patowoari', 'Zomila Khaton', 'Female', '21/09/1994', 'Chandpur', 'Chandpur', 10001, 'Bangladesh', '30/8/2014', 'fall 14-15', '14-00012-3', 'BBA', 'Student'),
('Mito', 'Akter', 'Army', 'Naznin', 'Female', '23/10/1993', 'Chandpur', 'Chandpur', 10001, 'Bangladesh', '30/8/2014', 'fall 14-15', '14-00011-3', 'ENGLISH', 'Student'),
('Nasrin', 'Sultana', 'Krishi Dakter', 'Linufer', 'Female', '01/01/1992', 'Chandpur', 'Chandpur', 1001, 'Bangladesh', '30/8/2014', 'fall 14-15', '14-00010-3', 'STATISTICS', 'Student'),
('Mijanur', 'Rahaman', 'Mojibur Rahaman', 'Akli', 'Male', '23/08/1991', 'Saterkul,Badda', 'Dhaka', 1212, 'Bangladesh', '30/8/2014', 'fall 14-15', '14-00009-3', 'ARCH', 'Student'),
('Jannat', 'Ara', 'Latif', 'Banu', 'Female', '01/01/1990', 'Polasir mor,Dhaka', 'Dhaka', 1203, 'Bangladesh', '30/8/2014', 'fall 14-15', '14-00008-3', 'EEE', 'Student'),
('Malek', 'Rahaman', 'Abdus Salam', 'Jamila Khaton', 'Male', '01/01/1992', 'Ishordi', 'Dhaka', 1201, 'Bangladesh', '29/08/1014', 'Fall 14-15', '14-00007-3', 'ENGLISH', 'Student'),
('Samsil', 'Arefin', 'Mostak Ahamed', 'Lotifa', 'Male', '01/09/1991', 'Chandpur', 'Chandpur', 10001, 'Bangladesh', '30/8/2014', 'fall 14-15', '14-00014-3', 'ENGLISH', 'Student'),
('Dayna', 'Akter', 'Didarul Alam', 'Nargis Akter', 'Female', '01/11/1990', 'Chandpur', 'Chandpur', 1001, 'Bangladesh', '30/8/2014', 'fall 14-15', '14-00015-3', 'Select A department', 'Student'),
('Akhi', 'Akter', 'Nurul Malik', 'Tinu Akter', 'Female', '01/03/1990', 'Chandpur', 'Chandpur', 10001, 'Bangladesh', '30/8/2014', 'fall 14-15', '14-00016-3', 'ENGLISH', 'Student'),
('Nurul', 'Islam', 'Dewoan', 'Maleha', 'Male', '01/01/1985', 'Chandpur', 'Chandpur', 1001, 'Bangladesh', '30/8/2014', 'fall 14-15', '14-00017-3', 'STATISTICS', 'Student'),
('Badsha', 'Islam', 'Dewoan', 'Maleha', 'Male', '01/01/1988', 'Dhaka', 'Dhaka', 1309, 'Bangladesh', '30/8/2014', 'fall 14-15', '14-00018-3', 'MATH', 'Student'),
('Lavli', 'Khanum', 'Gulam Sayed ', 'Nishi Begum', 'Female', '01/01/1993', 'Chandpur', 'Chandpur', 1001, 'Bangladesh', '30/8/2014', 'fall 14-15', '14-00019-3', 'STATISTICS', 'Student'),
('Robiul', 'Islam', 'Dewoan', 'Morjina', 'Male', '01/02/1992', 'Chandpur', 'Chandpur', 1001, 'Bangladesh', '30/8/2014', 'fall 14-15', '14-00020-3', 'STATISTICS', 'Student'),
('hfgjh', 'hjghj', 'ghjgh', 'hgjhgj', 'Female', 'dd/mm/yyyy', 'hjghj', 'hjgh', 23, 'Bangladesh', '30/8/2014', 'fall 14-15', '14-00021-3', 'STATISTICS', 'Student'),
('nvbnvb', 'bvnvbn', 'vbnvb', 'vbnvb', 'Female', 'dd/mm/yyyy', 'bnbvn', 'bnbvn', 12, 'Bangladesh', '30/8/2014', 'fall 14-15', '14-00022-3', 'STATISTICS', 'Student'),
('Nargis', 'Akter', 'Robiul islam', 'Amena', 'Female', '01/02/1992', 'Matlab,Chandpur', 'Chandpur', 1005, 'Bangladesh', '30/8/2014', 'fall 14-15', '14-00023-3', 'Select A department', 'Student'),
('fdgdfg', 'dfgdfg', 'fgdsfg', 'fdgfd', 'Female', 'dd/mm/yyyy', 'dfgdfg', 'fdgfd', 123, 'Bangladesh', '30/8/2014', 'fall 14-15', '14-00024-3', 'Select A department', 'Student'),
('Malek', 'Rahaman', 'Munshi', 'Maleha', 'Male', '01/01/1991', 'Chandpur', 'Chandpur', 1001, 'Bangladesh', '30/8/2014', 'fall 14-15', '14-00025-3', 'STATISTICS', 'Student'),
('vbmn', 'mbnmnb', 'nmbnm', 'nmbnm', 'Male', 'dd/mm/yyyy', 'nbmbnmnb', 'nmnmnbm', 12, 'Bangladesh', '2/9/2014', 'Fall 14-15', '14-00026-3', 'ENGLISH', 'Student'),
('Mostafijur', 'Rahaman', 'Dalil Uddin', 'Mariyam', 'Male', '08/10/1992', 'omor ali len rampura', 'Dhaka', 1212, 'Bangladesh', '3/9/2014', 'Fall 14-15', '14-00027-3', 'CSE', 'Student');

-- --------------------------------------------------------

--
-- Table structure for table `student00001`
--

CREATE TABLE IF NOT EXISTS `student00001` (
  `studentid` varchar(15) DEFAULT NULL,
  `semester` varchar(20) DEFAULT NULL,
  `courseid` varchar(15) NOT NULL DEFAULT '',
  `credit` double DEFAULT NULL,
  `result` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `student00001`
--

INSERT INTO `student00001` (`studentid`, `semester`, `courseid`, `credit`, `result`) VALUES
('14-00001-3', 'Fall 14-15', 'CS', 3, 0),
('14-00001-3', 'Fall 14-15', 'CS101', 3, 0),
('14-00001-3', 'Fall 14-15', 'CS2010', 3, 0),
('14-00001-3', 'Fall 14-15', 'MAT101', 3, 0);

-- --------------------------------------------------------

--
-- Table structure for table `student00002`
--

CREATE TABLE IF NOT EXISTS `student00002` (
  `studentid` varchar(15) DEFAULT NULL,
  `semester` varchar(20) DEFAULT NULL,
  `courseid` varchar(15) NOT NULL DEFAULT '',
  `credit` double DEFAULT NULL,
  `result` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `student00002`
--

INSERT INTO `student00002` (`studentid`, `semester`, `courseid`, `credit`, `result`) VALUES
('14-00002-3', 'Fall 14-15', 'CS', 3, 0),
('14-00002-3', 'Fall 14-15', 'CS101', 3, 0),
('14-00002-3', 'Fall 14-15', 'CS2010', 3, 0),
('14-00002-3', 'Fall 14-15', 'MAT101', 3, 0);

-- --------------------------------------------------------

--
-- Table structure for table `student00003`
--

CREATE TABLE IF NOT EXISTS `student00003` (
  `studentid` varchar(15) DEFAULT NULL,
  `semester` varchar(20) DEFAULT NULL,
  `courseid` varchar(15) DEFAULT NULL,
  `credit` double DEFAULT NULL,
  `result` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `student00004`
--

CREATE TABLE IF NOT EXISTS `student00004` (
  `studentid` varchar(15) DEFAULT NULL,
  `semester` varchar(20) DEFAULT NULL,
  `courseid` varchar(15) DEFAULT NULL,
  `credit` double DEFAULT NULL,
  `result` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `student00005`
--

CREATE TABLE IF NOT EXISTS `student00005` (
  `studentid` varchar(15) DEFAULT NULL,
  `semester` varchar(20) DEFAULT NULL,
  `courseid` varchar(15) DEFAULT NULL,
  `credit` double DEFAULT NULL,
  `result` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `student00006`
--

CREATE TABLE IF NOT EXISTS `student00006` (
  `studentid` varchar(15) DEFAULT NULL,
  `semester` varchar(20) DEFAULT NULL,
  `courseid` varchar(15) DEFAULT NULL,
  `credit` double DEFAULT NULL,
  `result` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `student00007`
--

CREATE TABLE IF NOT EXISTS `student00007` (
  `studentid` varchar(15) DEFAULT NULL,
  `semester` varchar(20) DEFAULT NULL,
  `courseid` varchar(15) DEFAULT NULL,
  `credit` double DEFAULT NULL,
  `result` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `student00008`
--

CREATE TABLE IF NOT EXISTS `student00008` (
  `studentid` varchar(15) DEFAULT NULL,
  `semester` varchar(20) DEFAULT NULL,
  `courseid` varchar(15) DEFAULT NULL,
  `credit` double DEFAULT NULL,
  `result` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `student00010`
--

CREATE TABLE IF NOT EXISTS `student00010` (
  `studentid` varchar(15) DEFAULT NULL,
  `semester` varchar(20) DEFAULT NULL,
  `courseid` varchar(15) DEFAULT NULL,
  `credit` double DEFAULT NULL,
  `result` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `student00011`
--

CREATE TABLE IF NOT EXISTS `student00011` (
  `studentid` varchar(15) DEFAULT NULL,
  `semester` varchar(20) DEFAULT NULL,
  `courseid` varchar(15) DEFAULT NULL,
  `credit` double DEFAULT NULL,
  `result` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `student00012`
--

CREATE TABLE IF NOT EXISTS `student00012` (
  `studentid` varchar(15) DEFAULT NULL,
  `semester` varchar(20) DEFAULT NULL,
  `courseid` varchar(15) DEFAULT NULL,
  `credit` double DEFAULT NULL,
  `result` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `student00013`
--

CREATE TABLE IF NOT EXISTS `student00013` (
  `studentid` varchar(15) DEFAULT NULL,
  `semester` varchar(20) DEFAULT NULL,
  `courseid` varchar(15) DEFAULT NULL,
  `credit` double DEFAULT NULL,
  `result` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `student00014`
--

CREATE TABLE IF NOT EXISTS `student00014` (
  `studentid` varchar(15) DEFAULT NULL,
  `semester` varchar(20) DEFAULT NULL,
  `courseid` varchar(15) DEFAULT NULL,
  `credit` double DEFAULT NULL,
  `result` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `student00015`
--

CREATE TABLE IF NOT EXISTS `student00015` (
  `studentid` varchar(15) DEFAULT NULL,
  `semester` varchar(20) DEFAULT NULL,
  `courseid` varchar(15) DEFAULT NULL,
  `credit` double DEFAULT NULL,
  `result` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `student00016`
--

CREATE TABLE IF NOT EXISTS `student00016` (
  `studentid` varchar(15) DEFAULT NULL,
  `semester` varchar(20) DEFAULT NULL,
  `courseid` varchar(15) DEFAULT NULL,
  `credit` double DEFAULT NULL,
  `result` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `student00017`
--

CREATE TABLE IF NOT EXISTS `student00017` (
  `studentid` varchar(15) DEFAULT NULL,
  `semester` varchar(20) DEFAULT NULL,
  `courseid` varchar(15) DEFAULT NULL,
  `credit` double DEFAULT NULL,
  `result` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `student00018`
--

CREATE TABLE IF NOT EXISTS `student00018` (
  `studentid` varchar(15) DEFAULT NULL,
  `semester` varchar(20) DEFAULT NULL,
  `courseid` varchar(15) DEFAULT NULL,
  `credit` double DEFAULT NULL,
  `result` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `student00019`
--

CREATE TABLE IF NOT EXISTS `student00019` (
  `studentid` varchar(15) DEFAULT NULL,
  `semester` varchar(20) DEFAULT NULL,
  `courseid` varchar(15) DEFAULT NULL,
  `credit` double DEFAULT NULL,
  `result` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `student00020`
--

CREATE TABLE IF NOT EXISTS `student00020` (
  `studentid` varchar(15) DEFAULT NULL,
  `semester` varchar(20) DEFAULT NULL,
  `courseid` varchar(15) DEFAULT NULL,
  `credit` double DEFAULT NULL,
  `result` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `student00021`
--

CREATE TABLE IF NOT EXISTS `student00021` (
  `studentid` varchar(15) DEFAULT NULL,
  `semester` varchar(20) DEFAULT NULL,
  `courseid` varchar(15) DEFAULT NULL,
  `credit` double DEFAULT NULL,
  `result` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `student00022`
--

CREATE TABLE IF NOT EXISTS `student00022` (
  `studentid` varchar(15) DEFAULT NULL,
  `semester` varchar(20) DEFAULT NULL,
  `courseid` varchar(15) DEFAULT NULL,
  `credit` double DEFAULT NULL,
  `result` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `student00023`
--

CREATE TABLE IF NOT EXISTS `student00023` (
  `studentid` varchar(15) DEFAULT NULL,
  `semester` varchar(20) DEFAULT NULL,
  `courseid` varchar(15) DEFAULT NULL,
  `credit` double DEFAULT NULL,
  `result` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `student00024`
--

CREATE TABLE IF NOT EXISTS `student00024` (
  `studentid` varchar(15) DEFAULT NULL,
  `semester` varchar(20) DEFAULT NULL,
  `courseid` varchar(15) DEFAULT NULL,
  `credit` double DEFAULT NULL,
  `result` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `student00025`
--

CREATE TABLE IF NOT EXISTS `student00025` (
  `studentid` varchar(15) DEFAULT NULL,
  `semester` varchar(20) DEFAULT NULL,
  `courseid` varchar(15) DEFAULT NULL,
  `credit` double DEFAULT NULL,
  `result` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `student00026`
--

CREATE TABLE IF NOT EXISTS `student00026` (
  `studentid` varchar(15) DEFAULT NULL,
  `semester` varchar(20) DEFAULT NULL,
  `courseid` varchar(15) DEFAULT NULL,
  `credit` double DEFAULT NULL,
  `result` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `student00027`
--

CREATE TABLE IF NOT EXISTS `student00027` (
  `studentid` varchar(15) DEFAULT NULL,
  `semester` varchar(20) DEFAULT NULL,
  `courseid` varchar(15) NOT NULL DEFAULT '',
  `credit` double DEFAULT NULL,
  `result` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `studentid`
--

CREATE TABLE IF NOT EXISTS `studentid` (
  `studentid` varchar(20) NOT NULL,
  `status` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `studentid`
--

INSERT INTO `studentid` (`studentid`, `status`) VALUES
('14-00001-3', 'active');

-- --------------------------------------------------------

--
-- Table structure for table `teacher`
--

CREATE TABLE IF NOT EXISTS `teacher` (
  `Name` varchar(50) NOT NULL,
  `ID` varchar(20) NOT NULL,
  `Semester` varchar(15) NOT NULL,
  `FatherName` varchar(50) NOT NULL,
  `MotherName` varchar(50) NOT NULL,
  `Courses` varchar(100) DEFAULT NULL,
  `Status` varchar(20) NOT NULL,
  `Department` varchar(30) NOT NULL,
  `Room` varchar(10) NOT NULL,
  `Subject` varchar(100) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `test`
--

CREATE TABLE IF NOT EXISTS `test` (
  `name` varchar(10) NOT NULL,
  `password` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `userlogin`
--

CREATE TABLE IF NOT EXISTS `userlogin` (
  `UserName` varchar(50) NOT NULL,
  `Password` varchar(50) NOT NULL,
  `id` varchar(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `userlogin`
--

INSERT INTO `userlogin` (`UserName`, `Password`, `id`) VALUES
('user', '1234', '14-00001-4'),
('user1', '123456', '14-00002-4');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `account`
--
ALTER TABLE `account`
 ADD PRIMARY KEY (`studentid`);

--
-- Indexes for table `course`
--
ALTER TABLE `course`
 ADD PRIMARY KEY (`code`);

--
-- Indexes for table `faculty`
--
ALTER TABLE `faculty`
 ADD PRIMARY KEY (`id`);

--
-- Indexes for table `fall1415cs`
--
ALTER TABLE `fall1415cs`
 ADD PRIMARY KEY (`studentid`);

--
-- Indexes for table `fall1415cs101`
--
ALTER TABLE `fall1415cs101`
 ADD PRIMARY KEY (`studentid`);

--
-- Indexes for table `fall1415cs1201`
--
ALTER TABLE `fall1415cs1201`
 ADD PRIMARY KEY (`studentid`);

--
-- Indexes for table `fall1415cs1202`
--
ALTER TABLE `fall1415cs1202`
 ADD PRIMARY KEY (`studentid`);

--
-- Indexes for table `fall1415cs2001`
--
ALTER TABLE `fall1415cs2001`
 ADD PRIMARY KEY (`studentid`);

--
-- Indexes for table `fall1415cs2010`
--
ALTER TABLE `fall1415cs2010`
 ADD PRIMARY KEY (`studentid`);

--
-- Indexes for table `fall1415eng1001`
--
ALTER TABLE `fall1415eng1001`
 ADD PRIMARY KEY (`studentid`);

--
-- Indexes for table `fall1415mat101`
--
ALTER TABLE `fall1415mat101`
 ADD PRIMARY KEY (`studentid`);

--
-- Indexes for table `semester`
--
ALTER TABLE `semester`
 ADD PRIMARY KEY (`name`);

--
-- Indexes for table `staff`
--
ALTER TABLE `staff`
 ADD PRIMARY KEY (`id`);

--
-- Indexes for table `student`
--
ALTER TABLE `student`
 ADD PRIMARY KEY (`id`);

--
-- Indexes for table `student00001`
--
ALTER TABLE `student00001`
 ADD PRIMARY KEY (`courseid`);

--
-- Indexes for table `student00002`
--
ALTER TABLE `student00002`
 ADD PRIMARY KEY (`courseid`);

--
-- Indexes for table `student00027`
--
ALTER TABLE `student00027`
 ADD PRIMARY KEY (`courseid`);

--
-- Indexes for table `teacher`
--
ALTER TABLE `teacher`
 ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `userlogin`
--
ALTER TABLE `userlogin`
 ADD PRIMARY KEY (`UserName`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
