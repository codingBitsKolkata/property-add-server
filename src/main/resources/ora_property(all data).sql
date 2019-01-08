-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 28, 2018 at 08:32 AM
-- Server version: 10.1.36-MariaDB
-- PHP Version: 7.2.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `ora_property`
--

-- --------------------------------------------------------

--
-- Table structure for table `master_amenities`
--

CREATE TABLE `master_amenities` (
  `aminities_id` bigint(20) NOT NULL,
  `created_by` bigint(20) DEFAULT NULL,
  `created_date` varchar(255) DEFAULT NULL,
  `modified_by` bigint(20) DEFAULT NULL,
  `modified_date` varchar(255) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `aminities_name` varchar(255) DEFAULT NULL,
  `aminities_type` varchar(255) DEFAULT NULL,
  `express_flag` varchar(255) DEFAULT NULL,
  `filter_flag` varchar(255) DEFAULT NULL,
  `language_id` bigint(20) DEFAULT NULL,
  `parent_id` bigint(20) DEFAULT NULL,
  `premium_flag` varchar(255) DEFAULT NULL,
  `priority` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `master_amenities`
--

INSERT INTO `master_amenities` (`aminities_id`, `created_by`, `created_date`, `modified_by`, `modified_date`, `status`, `aminities_name`, `aminities_type`, `express_flag`, `filter_flag`, `language_id`, `parent_id`, `premium_flag`, `priority`) VALUES
(1, 1, '2018-09-06 01:27:34', NULL, NULL, 1, 'WIFI', 'BASIC', 'Y', 'Y', 1, 0, 'Y', '2'),
(2, 1, '2018-09-06 01:27:34', NULL, NULL, 1, 'Heater', 'BASIC', 'Y', 'N', 1, 0, 'Y', ''),
(3, 1, '2018-09-06 01:27:34', NULL, NULL, 1, 'Table Lamp', 'OTHERS', 'N', 'Y', 1, 0, 'Y', '1');

-- --------------------------------------------------------

--
-- Table structure for table `master_cancellation_slab`
--

CREATE TABLE `master_cancellation_slab` (
  `cancellation_slab_id` bigint(20) NOT NULL,
  `created_by` bigint(20) DEFAULT NULL,
  `created_date` varchar(255) DEFAULT NULL,
  `modified_by` bigint(20) DEFAULT NULL,
  `modified_date` varchar(255) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `end_time` varchar(255) DEFAULT NULL,
  `start_time` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `master_cancellation_slab`
--

INSERT INTO `master_cancellation_slab` (`cancellation_slab_id`, `created_by`, `created_date`, `modified_by`, `modified_date`, `status`, `end_time`, `start_time`) VALUES
(1, 1, '2018-09-06 01:27:34', NULL, NULL, 1, '0', '24'),
(2, 1, '2018-09-06 01:27:34', NULL, NULL, 1, '24', '36');

-- --------------------------------------------------------

--
-- Table structure for table `master_document`
--

CREATE TABLE `master_document` (
  `document_id` bigint(20) NOT NULL,
  `created_by` bigint(20) DEFAULT NULL,
  `created_date` varchar(255) DEFAULT NULL,
  `modified_by` bigint(20) DEFAULT NULL,
  `modified_date` varchar(255) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `document_name` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `master_document`
--

INSERT INTO `master_document` (`document_id`, `created_by`, `created_date`, `modified_by`, `modified_date`, `status`, `document_name`) VALUES
(1, 1, '2018-09-06 01:27:34', NULL, NULL, 1, 'PAN CARD'),
(2, 1, '2018-09-06 01:27:34', NULL, NULL, 1, 'CANCELLED CHEQUE');

-- --------------------------------------------------------

--
-- Table structure for table `master_meal_plan`
--

CREATE TABLE `master_meal_plan` (
  `meal_plan_id` bigint(20) NOT NULL,
  `created_by` bigint(20) DEFAULT NULL,
  `created_date` varchar(255) DEFAULT NULL,
  `modified_by` bigint(20) DEFAULT NULL,
  `modified_date` varchar(255) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `language_id` bigint(20) DEFAULT NULL,
  `meal_plan_name` varchar(255) DEFAULT NULL,
  `parent_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `master_meal_plan`
--

INSERT INTO `master_meal_plan` (`meal_plan_id`, `created_by`, `created_date`, `modified_by`, `modified_date`, `status`, `language_id`, `meal_plan_name`, `parent_id`) VALUES
(1, 1, '2018-09-06 01:27:34', NULL, NULL, 1, 1, 'Breakfast', 0),
(2, 1, '2018-09-06 01:27:34', NULL, NULL, 1, 1, 'Major Meal1', 0),
(3, 1, '2018-09-06 01:27:34', NULL, NULL, 1, 1, 'Major Meal2', 0),
(4, 1, '2018-09-06 01:27:34', NULL, NULL, 1, 1, 'Snacks', 0);

-- --------------------------------------------------------

--
-- Table structure for table `master_meal_plan_category`
--

CREATE TABLE `master_meal_plan_category` (
  `mpc_id` bigint(20) NOT NULL,
  `created_by` bigint(20) DEFAULT NULL,
  `created_date` varchar(255) DEFAULT NULL,
  `modified_by` bigint(20) DEFAULT NULL,
  `modified_date` varchar(255) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `language_id` bigint(20) DEFAULT NULL,
  `mpc_name` varchar(255) DEFAULT NULL,
  `parent_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `master_meal_plan_category`
--

INSERT INTO `master_meal_plan_category` (`mpc_id`, `created_by`, `created_date`, `modified_by`, `modified_date`, `status`, `language_id`, `mpc_name`, `parent_id`) VALUES
(1, 1, '2018-09-06 01:27:34', NULL, NULL, 1, 1, 'AP', 0),
(2, 1, '2018-09-06 01:27:34', NULL, NULL, 1, 1, 'CP', 0);

-- --------------------------------------------------------

--
-- Table structure for table `master_offer`
--

CREATE TABLE `master_offer` (
  `offer_id` bigint(20) NOT NULL,
  `created_by` bigint(20) DEFAULT NULL,
  `created_date` varchar(255) DEFAULT NULL,
  `modified_by` bigint(20) DEFAULT NULL,
  `modified_date` varchar(255) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `amount` varchar(255) DEFAULT NULL,
  `end_date_range` varchar(255) DEFAULT NULL,
  `max_amount` varchar(255) DEFAULT NULL,
  `offer_name` varchar(255) DEFAULT NULL,
  `online` varchar(255) DEFAULT NULL,
  `percentage` varchar(255) DEFAULT NULL,
  `start_date_range` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `master_offer`
--

INSERT INTO `master_offer` (`offer_id`, `created_by`, `created_date`, `modified_by`, `modified_date`, `status`, `amount`, `end_date_range`, `max_amount`, `offer_name`, `online`, `percentage`, `start_date_range`) VALUES
(1, 1, '2018-09-06 01:27:34', NULL, NULL, 1, '500', NULL, '4000', '500 off above 4000 ', NULL, NULL, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `master_price_drop`
--

CREATE TABLE `master_price_drop` (
  `price_drop_id` bigint(20) NOT NULL,
  `created_by` bigint(20) DEFAULT NULL,
  `created_date` varchar(255) DEFAULT NULL,
  `modified_by` bigint(20) DEFAULT NULL,
  `modified_date` varchar(255) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `after_time` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `master_price_drop`
--

INSERT INTO `master_price_drop` (`price_drop_id`, `created_by`, `created_date`, `modified_by`, `modified_date`, `status`, `after_time`) VALUES
(1, 1, '2018-09-06 01:27:34', NULL, NULL, 1, '8'),
(2, 1, '2018-09-06 01:27:34', NULL, NULL, 1, '11');

-- --------------------------------------------------------

--
-- Table structure for table `master_property`
--

CREATE TABLE `master_property` (
  `property_id` bigint(20) NOT NULL,
  `created_by` bigint(20) DEFAULT NULL,
  `created_date` varchar(255) DEFAULT NULL,
  `modified_by` bigint(20) DEFAULT NULL,
  `modified_date` varchar(255) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `address` text,
  `alt_email` varchar(255) DEFAULT NULL,
  `alt_mobile` varchar(255) DEFAULT NULL,
  `apartment_name` varchar(255) DEFAULT NULL,
  `apartment_number` varchar(255) DEFAULT NULL,
  `checkin_time` varchar(255) DEFAULT NULL,
  `checkout_time` varchar(255) DEFAULT NULL,
  `contact_name` varchar(255) DEFAULT NULL,
  `cover_image_url` varchar(255) DEFAULT NULL,
  `end_date` varchar(255) DEFAULT NULL,
  `entire_apartment` varchar(255) DEFAULT NULL,
  `immediate_booking` varchar(255) DEFAULT NULL,
  `landline` varchar(255) DEFAULT NULL,
  `latitude` varchar(255) DEFAULT NULL,
  `longitude` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `oraname` varchar(255) DEFAULT NULL,
  `price_drop` varchar(255) DEFAULT NULL,
  `start_date` varchar(255) DEFAULT NULL,
  `strict_checkin` varchar(255) DEFAULT NULL,
  `sex_category` varchar(255) DEFAULT NULL,
  `property_type_id` bigint(20) NOT NULL,
  `stay_type_id` bigint(20) NOT NULL,
  `host_vs_account_id` bigint(20) NOT NULL,
  `advance_percentage` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `master_property`
--

INSERT INTO `master_property` (`property_id`, `created_by`, `created_date`, `modified_by`, `modified_date`, `status`, `address`, `alt_email`, `alt_mobile`, `apartment_name`, `apartment_number`, `checkin_time`, `checkout_time`, `contact_name`, `cover_image_url`, `end_date`, `entire_apartment`, `immediate_booking`, `landline`, `latitude`, `longitude`, `name`, `oraname`, `price_drop`, `start_date`, `strict_checkin`, `sex_category`, `property_type_id`, `stay_type_id`, `host_vs_account_id`, `advance_percentage`) VALUES
(1, 1, '2018-12-18 14:54:25', NULL, NULL, 1, 'Merlin Infinite, Unit No 501, DN 51, DN Block, Sector 5, Salt Lake, DN Block, Sector V, Salt Lake City, Kolkata, West Bengal 700091', NULL, NULL, '', '', '11:00:00', '10:00:00', NULL, 'https://s-ec.bstatic.com/images/hotel/max1024x768/141/141830278.jpg', '2019-12-31 23:59:59', 'Y', 'Y', NULL, '22.582490', '88.426787', 'HOTELOrastays', 'ORA000001', 'Y', '2019-01-01 00:00:01', 'N', 'BOTH', 1, 2, 1, '100'),
(2, 1, '2018-12-18 15:01:11', NULL, NULL, 1, 'Merlin Infinite, Unit No 501, DN 51, DN Block, Sector 5, Salt Lake, DN Block, Sector V, Salt Lake City, Kolkata, West Bengal 700091', 'sudeep@orastays.com', '9883741610', '', '', '11:00:00', '10:00:00', NULL, 'https://s-ec.bstatic.com/images/hotel/max1024x768/141/141830278.jpg', '2019-12-31 23:59:59', 'Y', 'Y', '033-25478451', '22.582490', '88.426787', 'HOTEL2', 'ORA000002', 'Y', '2019-01-01 00:00:01', 'N', 'BOTH', 1, 2, 2, '100'),
(3, 1, '2018-12-18 15:02:05', NULL, NULL, 1, 'Merlin Infinite, Unit No 501, DN 51, DN Block, Sector 5, Salt Lake, DN Block, Sector V, Salt Lake City, Kolkata, West Bengal 700091', 'sudeep@orastays.com', '9883741610', '', '', '11:00:00', '10:00:00', 'Sudeep Chhetri', 'https://s-ec.bstatic.com/images/hotel/max1024x768/141/141830278.jpg', '2019-12-31 23:59:59', 'Y', 'Y', '033-25478451', '22.582490', '88.426787', 'HOTEL3', 'ORA000003', 'Y', '2019-01-01 00:00:01', 'N', 'BOTH', 1, 2, 3, '100'),
(4, 1, '2018-12-18 15:19:01', NULL, NULL, 1, 'Merlin Infinite, Unit No 501, DN 51, DN Block, Sector 5, Salt Lake, DN Block, Sector V, Salt Lake City, Kolkata, West Bengal 700091', 'sudeep@orastays.com', '9883741610', 'sss', 'sss', '11:00:00', '10:00:00', 'Sudeep Chhetri', 'https://s-ec.bstatic.com/images/hotel/max1024x768/141/141830278.jpg', '2019-12-31 23:59:59', 'Y', 'Y', '033-25478451', '22.582490', '88.426787', 'HOTEL4', 'ORA000004', 'Y', '2019-01-01 00:00:01', 'N', 'BOTH', 1, 2, 4, '100'),
(5, 1, '2018-12-18 16:05:15', NULL, NULL, 1, 'Merlin Infinite, Unit No 501, DN 51, DN Block, Sector 5, Salt Lake, DN Block, Sector V, Salt Lake City, Kolkata, West Bengal 700091', 'sudeep@orastays.com', '9883741610', '', '', '11:00:00', '10:00:00', 'Sudeep Chhetri', 'https://s-ec.bstatic.com/images/hotel/max1024x768/141/141830278.jpg', '2019-12-31 23:59:59', 'Y', 'Y', '033-25478451', '22.582490', '88.426787', 'HOTEL5', 'ORA000005', 'Y', '2019-01-01 00:00:01', 'N', 'BOTH', 1, 2, 5, '100'),
(6, 1, '2018-12-18 16:09:47', NULL, NULL, 1, 'Merlin Infinite, Unit No 501, DN 51, DN Block, Sector 5, Salt Lake, DN Block, Sector V, Salt Lake City, Kolkata, West Bengal 700091', 'sudeep@orastays.com', '9883741610', '', '', '11:00:00', '10:00:00', 'Sudeep Chhetri', 'https://s-ec.bstatic.com/images/hotel/max1024x768/141/141830278.jpg', '2019-12-31 23:59:59', 'Y', 'Y', '033-25478451', '22.582490', '88.426787', 'HOTEL6', 'ORA000006', 'Y', '2019-01-01 00:00:01', 'N', 'BOTH', 1, 2, 6, '100'),
(7, 1, '2018-12-18 16:10:02', NULL, NULL, 1, 'Merlin Infinite, Unit No 501, DN 51, DN Block, Sector 5, Salt Lake, DN Block, Sector V, Salt Lake City, Kolkata, West Bengal 700091', 'sudeep@orastays.com', '9883741610', '', '', '11:00:00', '10:00:00', 'Sudeep Chhetri', 'https://s-ec.bstatic.com/images/hotel/max1024x768/141/141830278.jpg', '2019-12-31 23:59:59', 'Y', 'Y', '033-25478451', '22.582490', '88.426787', 'Homestay1', 'ORA000007', 'Y', '2019-01-01 00:00:01', 'N', 'BOTH', 2, 2, 7, '100'),
(8, 1, '2018-12-18 16:15:08', NULL, NULL, 1, 'Merlin Infinite, Unit No 501, DN 51, DN Block, Sector 5, Salt Lake, DN Block, Sector V, Salt Lake City, Kolkata, West Bengal 700091', 'sudeep@orastays.com', '9883741610', '', '', '11:00:00', '10:00:00', 'Sudeep Chhetri', 'https://s-ec.bstatic.com/images/hotel/max1024x768/141/141830278.jpg', '2019-12-31 23:59:59', 'Y', 'Y', '033-25478451', '22.582490', '88.426787', 'Homestay2', 'ORA000008', 'Y', '2019-01-01 00:00:01', 'N', 'BOTH', 2, 2, 8, '100'),
(9, 1, '2018-12-18 16:24:18', NULL, NULL, 1, 'Merlin Infinite, Unit No 501, DN 51, DN Block, Sector 5, Salt Lake, DN Block, Sector V, Salt Lake City, Kolkata, West Bengal 700091', 'sudeep@orastays.com', '9883741610', '', '', '11:00:00', '10:00:00', 'Sudeep Chhetri', 'https://s-ec.bstatic.com/images/hotel/max1024x768/141/141830278.jpg', '2019-12-31 23:59:59', 'Y', 'Y', '033-25478451', '22.582490', '88.426787', 'Homestay3', 'ORA000009', 'Y', '2019-01-01 00:00:01', 'N', 'BOTH', 2, 2, 9, '100'),
(10, 1, '2018-12-18 16:25:18', NULL, NULL, 1, 'Merlin Infinite, Unit No 501, DN 51, DN Block, Sector 5, Salt Lake, DN Block, Sector V, Salt Lake City, Kolkata, West Bengal 700091', 'sudeep@orastays.com', '9883741610', '', '', '11:00:00', '10:00:00', 'Sudeep Chhetri', 'https://s-ec.bstatic.com/images/hotel/max1024x768/141/141830278.jpg', '2019-12-31 23:59:59', 'Y', 'Y', '033-25478451', '22.582490', '88.426787', 'Homestay4', 'ORA000010', 'Y', '2019-01-01 00:00:01', 'N', 'BOTH', 2, 2, 10, '100'),
(11, 1, '2018-12-18 16:25:18', NULL, NULL, 1, 'Merlin Infinite, Unit No 501, DN 51, DN Block, Sector 5, Salt Lake, DN Block, Sector V, Salt Lake City, Kolkata, West Bengal 700091', 'sudeep@orastays.com', '9883741610', '', '', '11:00:00', '10:00:00', 'Sudeep Chhetri', 'https://s-ec.bstatic.com/images/hotel/max1024x768/141/141830278.jpg', '2019-12-31 23:59:59', 'Y', 'Y', '033-25478451', '22.582490', '88.426787', 'Homestay4', 'ORA000010', 'Y', '2019-01-01 00:00:01', 'N', 'BOTH', 2, 2, 10, '100'),
(12, 1, '2018-12-18 16:36:56', NULL, NULL, 1, 'Merlin Infinite, Unit No 501, DN 51, DN Block, Sector 5, Salt Lake, DN Block, Sector V, Salt Lake City, Kolkata, West Bengal 700091', 'sudeep@orastays.com', '9883741610', '', '', '11:00:00', '10:00:00', 'Sudeep Chhetri', 'https://s-ec.bstatic.com/images/hotel/max1024x768/141/141830278.jpg', '2019-12-31 23:59:59', 'Y', 'Y', '033-25478451', '22.582490', '88.426787', 'Homestay5', 'ORA000011', 'Y', '2019-01-01 00:00:01', 'N', 'BOTH', 2, 2, 11, '100'),
(13, 1, '2018-12-18 16:39:05', NULL, NULL, 1, 'Merlin Infinite, Unit No 501, DN 51, DN Block, Sector 5, Salt Lake, DN Block, Sector V, Salt Lake City, Kolkata, West Bengal 700091', 'sudeep@orastays.com', '9883741610', '', '', '11:00:00', '10:00:00', 'Sudeep Chhetri', 'https://s-ec.bstatic.com/images/hotel/max1024x768/141/141830278.jpg', '2019-12-31 23:59:59', 'Y', 'Y', '033-25478451', '22.582490', '88.426787', 'GuestHouse1', 'ORA000012', 'Y', '2019-01-01 00:00:01', 'N', 'BOTH', 3, 2, 12, '100'),
(14, 1, '2018-12-18 16:43:25', NULL, NULL, 1, 'Merlin Infinite, Unit No 501, DN 51, DN Block, Sector 5, Salt Lake, DN Block, Sector V, Salt Lake City, Kolkata, West Bengal 700091', 'sudeep@orastays.com', '9883741610', '', '', '11:00:00', '10:00:00', 'Sudeep Chhetri', 'https://s-ec.bstatic.com/images/hotel/max1024x768/141/141830278.jpg', '2019-12-31 23:59:59', 'Y', 'Y', '033-25478451', '22.582490', '88.426787', 'GuestHouse2', 'ORA000013', 'Y', '2019-01-01 00:00:01', 'N', 'BOTH', 3, 2, 13, '100'),
(15, 1, '2018-12-18 17:01:24', NULL, NULL, 1, 'Merlin Infinite, Unit No 501, DN 51, DN Block, Sector 5, Salt Lake, DN Block, Sector V, Salt Lake City, Kolkata, West Bengal 700091', 'sudeep@orastays.com', '9883741610', '', '', '11:00:00', '10:00:00', 'Sudeep Chhetri', 'https://s-ec.bstatic.com/images/hotel/max1024x768/141/141830278.jpg', '2019-12-31 23:59:59', 'Y', 'Y', '033-25478451', '22.582490', '88.426787', 'GuestHouse3', 'ORA000014', 'Y', '2019-01-01 00:00:01', 'N', 'BOTH', 3, 2, 14, '100'),
(16, 1, '2018-12-18 17:13:04', NULL, NULL, 1, 'Merlin Infinite, Unit No 501, DN 51, DN Block, Sector 5, Salt Lake, DN Block, Sector V, Salt Lake City, Kolkata, West Bengal 700091', 'sudeep@orastays.com', '9883741610', '', '', '11:00:00', '10:00:00', 'Sudeep Chhetri', 'https://s-ec.bstatic.com/images/hotel/max1024x768/141/141830278.jpg', '2019-12-31 23:59:59', 'Y', 'Y', '033-25478451', '22.582490', '88.426787', 'GuestHouse4', 'ORA000015', 'Y', '2019-01-01 00:00:01', 'Y', 'BOTH', 3, 2, 15, '100'),
(17, 1, '2018-12-18 18:10:07', NULL, NULL, 1, 'Merlin Infinite, Unit No 501, DN 51, DN Block, Sector 5, Salt Lake, DN Block, Sector V, Salt Lake City, Kolkata, West Bengal 700091', 'sudeep@orastays.com', '9883741610', '', '', '11:00:00', '10:00:00', '', 'https://s-ec.bstatic.com/images/hotel/max1024x768/141/141830278.jpg', '2019-12-31 23:59:59', 'Y', 'Y', '033-25478451', '22.582490', '88.426787', 'GuestHouse5', 'ORA000016', 'Y', '2019-01-01 00:00:01', 'N', 'FEMALE', 3, 2, 16, '100'),
(18, 1, '2018-12-18 16:10:02', NULL, NULL, 1, 'Merlin Infinite, Unit No 501, DN 51, DN Block, Sector 5, Salt Lake, DN Block, Sector V, Salt Lake City, Kolkata, West Bengal 700091', 'sudeep@orastays.com', '9883741610', '', '', '11:00:00', '10:00:00', 'Sudeep Chhetri', 'https://s-ec.bstatic.com/images/hotel/max1024x768/141/141830278.jpg', '2019-12-31 23:59:59', 'Y', 'Y', '033-25478451', '22.582490', '88.426787', 'PayingGuest1', 'ORA000017', 'Y', '2019-01-01 00:00:01', 'N', 'MALE', 4, 1, 17, '100'),
(19, 1, '2018-12-18 16:15:08', NULL, NULL, 1, 'Merlin Infinite, Unit No 501, DN 51, DN Block, Sector 5, Salt Lake, DN Block, Sector V, Salt Lake City, Kolkata, West Bengal 700091', 'sudeep@orastays.com', '9883741610', '', '', '11:00:00', '10:00:00', 'Sudeep Chhetri', 'https://s-ec.bstatic.com/images/hotel/max1024x768/141/141830278.jpg', '2019-12-31 23:59:59', 'Y', 'Y', '033-25478451', '22.582490', '88.426787', 'PayingGuest2', 'ORA000018', 'Y', '2019-01-01 00:00:01', 'N', 'MALE', 4, 2, 18, '100'),
(20, 1, '2018-12-18 16:24:18', NULL, NULL, 1, 'Merlin Infinite, Unit No 501, DN 51, DN Block, Sector 5, Salt Lake, DN Block, Sector V, Salt Lake City, Kolkata, West Bengal 700091', 'sudeep@orastays.com', '9883741610', '', '', '11:00:00', '10:00:00', 'Sudeep Chhetri', 'https://s-ec.bstatic.com/images/hotel/max1024x768/141/141830278.jpg', '2019-12-31 23:59:59', 'Y', 'Y', '033-25478451', '22.582490', '88.426787', 'PayingGuest3', 'ORA000019', 'Y', '2019-01-01 00:00:01', 'N', 'FEMALE', 4, 3, 19, '100'),
(21, 1, '2018-12-18 16:25:18', NULL, NULL, 1, 'Merlin Infinite, Unit No 501, DN 51, DN Block, Sector 5, Salt Lake, DN Block, Sector V, Salt Lake City, Kolkata, West Bengal 700091', 'sudeep@orastays.com', '9883741610', '', '', '11:00:00', '10:00:00', 'Sudeep Chhetri', 'https://s-ec.bstatic.com/images/hotel/max1024x768/141/141830278.jpg', '2019-12-31 23:59:59', 'Y', 'Y', '033-25478451', '22.582490', '88.426787', 'PayingGuest4', 'ORA000020', 'Y', '2019-01-01 00:00:01', 'N', 'BOTH', 4, 2, 20, '100'),
(22, 1, '2018-12-18 16:36:56', NULL, NULL, 1, 'Merlin Infinite, Unit No 501, DN 51, DN Block, Sector 5, Salt Lake, DN Block, Sector V, Salt Lake City, Kolkata, West Bengal 700091', 'sudeep@orastays.com', '9883741610', '', '', '11:00:00', '10:00:00', 'Sudeep Chhetri', 'https://s-ec.bstatic.com/images/hotel/max1024x768/141/141830278.jpg', '2019-12-31 23:59:59', 'Y', 'Y', '033-25478451', '22.582490', '88.426787', 'PayingGuest5', 'ORA000021', 'Y', '2019-01-01 00:00:01', 'N', 'BOTH', 4, 2, 21, '100'),
(23, 1, '2018-12-18 16:10:02', NULL, NULL, 1, 'Merlin Infinite, Unit No 501, DN 51, DN Block, Sector 5, Salt Lake, DN Block, Sector V, Salt Lake City, Kolkata, West Bengal 700091', 'sudeep@orastays.com', '9883741610', '', '', '11:00:00', '10:00:00', 'Sudeep Chhetri', 'https://s-ec.bstatic.com/images/hotel/max1024x768/141/141830278.jpg', '2019-12-31 23:59:59', 'Y', 'Y', '033-25478451', '22.582490', '88.426787', 'Dormitory1', 'ORA000022', 'Y', '2019-01-01 00:00:01', 'N', 'MALE', 5, 1, 22, '100'),
(24, 1, '2018-12-18 16:15:08', NULL, NULL, 1, 'Merlin Infinite, Unit No 501, DN 51, DN Block, Sector 5, Salt Lake, DN Block, Sector V, Salt Lake City, Kolkata, West Bengal 700091', 'sudeep@orastays.com', '9883741610', '', '', '11:00:00', '10:00:00', 'Sudeep Chhetri', 'https://s-ec.bstatic.com/images/hotel/max1024x768/141/141830278.jpg', '2019-12-31 23:59:59', 'Y', 'Y', '033-25478451', '22.582490', '88.426787', 'Dormitory2', 'ORA000023', 'Y', '2019-01-01 00:00:01', 'N', 'MALE', 5, 1, 23, '100'),
(25, 1, '2018-12-18 16:24:18', NULL, NULL, 1, 'Merlin Infinite, Unit No 501, DN 51, DN Block, Sector 5, Salt Lake, DN Block, Sector V, Salt Lake City, Kolkata, West Bengal 700091', 'sudeep@orastays.com', '9883741610', '', '', '11:00:00', '10:00:00', 'Sudeep Chhetri', 'https://s-ec.bstatic.com/images/hotel/max1024x768/141/141830278.jpg', '2019-12-31 23:59:59', 'Y', 'Y', '033-25478451', '22.582490', '88.426787', 'Dormitory3', 'ORA000024', 'Y', '2019-01-01 00:00:01', 'N', 'FEMALE', 5, 2, 24, '100'),
(26, 1, '2018-12-18 16:25:18', NULL, NULL, 1, 'Merlin Infinite, Unit No 501, DN 51, DN Block, Sector 5, Salt Lake, DN Block, Sector V, Salt Lake City, Kolkata, West Bengal 700091', 'sudeep@orastays.com', '9883741610', '', '', '11:00:00', '10:00:00', 'Sudeep Chhetri', 'https://s-ec.bstatic.com/images/hotel/max1024x768/141/141830278.jpg', '2019-12-31 23:59:59', 'Y', 'Y', '033-25478451', '22.582490', '88.426787', 'Dormitory4', 'ORA000025', 'Y', '2019-01-01 00:00:01', 'N', 'FEMALE', 5, 3, 25, '100'),
(27, 1, '2018-12-18 16:36:56', NULL, NULL, 1, 'Merlin Infinite, Unit No 501, DN 51, DN Block, Sector 5, Salt Lake, DN Block, Sector V, Salt Lake City, Kolkata, West Bengal 700091', 'sudeep@orastays.com', '9883741610', '', '', '11:00:00', '10:00:00', 'Sudeep Chhetri', 'https://s-ec.bstatic.com/images/hotel/max1024x768/141/141830278.jpg', '2019-12-31 23:59:59', 'Y', 'Y', '033-25478451', '22.582490', '88.426787', 'Dormitory5', 'ORA000026', 'Y', '2019-01-01 00:00:01', 'N', 'BOTH', 5, 3, 26, '100');

-- --------------------------------------------------------

--
-- Table structure for table `master_property_type`
--

CREATE TABLE `master_property_type` (
  `property_type_id` bigint(20) NOT NULL,
  `created_by` bigint(20) DEFAULT NULL,
  `created_date` varchar(255) DEFAULT NULL,
  `modified_by` bigint(20) DEFAULT NULL,
  `modified_date` varchar(255) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `language_id` bigint(20) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `parent_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `master_property_type`
--

INSERT INTO `master_property_type` (`property_type_id`, `created_by`, `created_date`, `modified_by`, `modified_date`, `status`, `language_id`, `name`, `parent_id`) VALUES
(1, 1, '2018-09-06 01:27:34', NULL, NULL, 1, 1, 'Hotel', 0),
(2, 1, '2018-09-06 01:27:34', NULL, NULL, 1, 1, 'Homestay', 0),
(3, 1, '2018-09-06 01:27:34', NULL, NULL, 1, 1, 'Guest House', 0),
(4, 1, '2018-09-06 01:27:34', NULL, NULL, 1, 1, 'Paying Guest', 0),
(5, 1, '2018-09-06 01:27:34', NULL, NULL, 1, 1, 'Dormitory', 0);

-- --------------------------------------------------------

--
-- Table structure for table `master_room`
--

CREATE TABLE `master_room` (
  `room_id` bigint(20) NOT NULL,
  `created_by` bigint(20) DEFAULT NULL,
  `created_date` varchar(255) DEFAULT NULL,
  `modified_by` bigint(20) DEFAULT NULL,
  `modified_date` varchar(255) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `cot_available` varchar(255) DEFAULT NULL,
  `no_of_child` varchar(255) DEFAULT NULL,
  `no_of_guest` varchar(255) DEFAULT NULL,
  `num_of_cot` varchar(255) DEFAULT NULL,
  `room_current_status` varchar(255) DEFAULT NULL,
  `shared_space` varchar(255) DEFAULT NULL,
  `property_id` bigint(20) NOT NULL,
  `room_cat_id` bigint(20) NOT NULL,
  `room_standard` varchar(255) DEFAULT NULL,
  `accomodation_name` varchar(255) DEFAULT NULL,
  `room_price_per_night` varchar(255) DEFAULT NULL,
  `room_price_per_month` varchar(255) DEFAULT NULL,
  `shared_bed_price_per_night` varchar(255) DEFAULT NULL,
  `shared_bed_price_per_month` varchar(255) DEFAULT NULL,
  `cot_price` varchar(255) DEFAULT NULL,
  `shared_bed_price` varchar(255) DEFAULT NULL,
  `commission` varchar(255) DEFAULT NULL,
  `host_discount_weekly` varchar(255) DEFAULT NULL,
  `host_discount_monthly` varchar(255) DEFAULT NULL,
  `ora_percentage` varchar(255) DEFAULT NULL,
  `ora_discount_percentage` varchar(255) DEFAULT NULL,
  `num_of_bed` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `master_room`
--

INSERT INTO `master_room` (`room_id`, `created_by`, `created_date`, `modified_by`, `modified_date`, `status`, `cot_available`, `no_of_child`, `no_of_guest`, `num_of_cot`, `room_current_status`, `shared_space`, `property_id`, `room_cat_id`, `room_standard`, `accomodation_name`, `room_price_per_night`, `room_price_per_month`, `shared_bed_price_per_night`, `shared_bed_price_per_month`, `cot_price`, `shared_bed_price`, `commission`, `host_discount_weekly`, `host_discount_monthly`, `ora_percentage`, `ora_discount_percentage`, `num_of_bed`) VALUES
(1, 1, '2018-12-18 16:39:05', NULL, NULL, 1, 'N', ' ', '1', ' ', NULL, 'N', 1, 1, 'EXPRESS', 'PRIVATE', '2500', '10000', '300', '9000', '500', '150', '10', '7', '5', '15', '10', '8'),
(2, 1, '2018-12-18 16:39:05', NULL, NULL, 1, 'Y', '2', '2', '1', NULL, 'N', 1, 1, 'EXPRESS', 'PRIVATE', '2500', '10000', '300', '9000', '500', '150', '10', '7', '5', '15', '10', '8'),
(3, 1, '2018-12-18 16:43:25', NULL, NULL, 1, 'N', '1', '1', ' ', NULL, 'N', 1, 1, 'PREMIUM', 'PRIVATE', '2500', '10000', '300', '9000', '500', '150', '10', '7', '5', '15', '10', '8'),
(4, 1, '2018-12-18 16:43:25', NULL, NULL, 1, 'Y', '2', '3', '1', NULL, 'N', 1, 1, 'PREMIUM', 'PRIVATE', '2500', '10000', '300', '9000', '500', '150', '10', '7', '5', '15', '10', '8'),
(5, 1, '2018-12-18 17:01:24', NULL, NULL, 1, 'N', '1', '1', ' ', NULL, 'N', 1, 1, 'NORMAL', 'PRIVATE', '2500', '10000', '300', '9000', '500', '150', '10', '7', '5', '15', '10', '8'),
(6, 1, '2018-12-18 16:39:05', NULL, NULL, 1, 'N', '1', '1', ' ', NULL, 'N', 2, 1, 'PREMIUM', 'PRIVATE', '2500', '10000', '300', '9000', '500', '150', '10', '7', '5', '15', '10', '8'),
(7, 1, '2018-12-18 16:39:05', NULL, NULL, 1, 'Y', '2', '2', '1', NULL, 'N', 2, 1, 'PREMIUM', 'PRIVATE', '2500', '10000', '300', '9000', '500', '150', '10', '7', '5', '15', '10', '8'),
(8, 1, '2018-12-18 16:43:25', NULL, NULL, 1, 'N', '1', '3', ' ', NULL, 'N', 2, 1, 'PREMIUM', 'PRIVATE', '2500', '10000', '300', '9000', '500', '150', '10', '7', '5', '15', '10', '8'),
(9, 1, '2018-12-18 16:43:25', NULL, NULL, 1, 'Y', '2', '4', '1', NULL, 'N', 2, 2, 'PREMIUM', 'PRIVATE', '2500', '10000', '300', '9000', '500', '150', '10', '7', '5', '15', '10', '8'),
(10, 1, '2018-12-18 17:01:24', NULL, NULL, 1, 'N', '1', '4', ' ', NULL, 'N', 2, 2, 'PREMIUM', 'PRIVATE', '2500', '10000', '300', '9000', '500', '150', '10', '7', '5', '15', '10', '8'),
(11, 1, '2018-12-18 16:39:05', NULL, NULL, 1, 'N', '1', '2', ' ', NULL, 'N', 3, 2, 'EXPRESS', 'PRIVATE', '2500', '10000', '300', '9000', '500', '150', '10', '7', '5', '15', '10', '8'),
(12, 1, '2018-12-18 16:39:05', NULL, NULL, 1, 'Y', '2', '3', '1', NULL, 'N', 3, 2, 'EXPRESS', 'PRIVATE', '2500', '10000', '300', '9000', '500', '150', '10', '7', '5', '15', '10', '8'),
(13, 1, '2018-12-18 16:43:25', NULL, NULL, 1, 'Y', '2', '1', '1', NULL, 'N', 3, 2, 'EXPRESS', 'PRIVATE', '2500', '10000', '300', '9000', '500', '150', '10', '7', '5', '15', '10', '8'),
(14, 1, '2018-12-18 17:01:24', NULL, NULL, 1, 'N', '1', '2', ' ', NULL, 'N', 3, 1, 'EXPRESS', 'PRIVATE', '2500', '10000', '300', '9000', '500', '150', '10', '7', '5', '15', '10', '8'),
(15, 1, '2018-12-18 16:43:25', NULL, NULL, 1, 'N', '1', '4', ' ', NULL, 'N', 4, 1, 'NORMAL', 'PRIVATE', '2500', '10000', '300', '9000', '500', '150', '10', '7', '5', '15', '10', '8'),
(16, 1, '2018-12-18 16:43:25', NULL, NULL, 1, 'Y', '2', '2', '1', NULL, 'N', 4, 1, 'NORMAL', 'PRIVATE', '2500', '10000', '300', '9000', '500', '150', '10', '7', '5', '15', '10', '8'),
(17, 1, '2018-12-18 17:01:24', NULL, NULL, 1, 'N', '1', '4', ' ', NULL, 'N', 4, 2, 'NORMAL', 'PRIVATE', '2500', '10000', '300', '9000', '500', '150', '10', '7', '5', '15', '10', '8'),
(18, 1, '2018-12-18 16:39:05', NULL, NULL, 1, 'N', '1', '1', ' ', NULL, 'N', 5, 2, 'EXPRESS', 'PRIVATE', '2500', '10000', '300', '9000', '500', '150', '10', '7', '5', '15', '10', '8'),
(19, 1, '2018-12-18 16:39:05', NULL, NULL, 1, 'Y', '2', '2', '1', NULL, 'N', 5, 2, 'EXPRESS', 'PRIVATE', '2500', '10000', '300', '9000', '500', '150', '10', '7', '5', '15', '10', '8'),
(20, 1, '2018-12-18 16:43:25', NULL, NULL, 1, 'N', '1', '3', ' ', NULL, 'N', 5, 2, 'EXPRESS', 'PRIVATE', '2500', '10000', '300', '9000', '500', '150', '10', '7', '5', '15', '10', '8'),
(21, 1, '2018-12-18 16:43:25', NULL, NULL, 1, 'Y', '2', '4', '1', NULL, 'N', 5, 2, 'EXPRESS', 'PRIVATE', '2500', '10000', '300', '9000', '500', '150', '10', '7', '5', '15', '10', '8'),
(22, 1, '2018-12-18 17:01:24', NULL, NULL, 1, 'N', '1', '2', ' ', NULL, 'N', 5, 2, 'EXPRESS', 'PRIVATE', '2500', '10000', '300', '9000', '500', '150', '10', '7', '5', '15', '10', '8'),
(23, 1, '2018-12-18 16:39:05', NULL, NULL, 1, 'N', '1', '4', ' ', NULL, 'N', 5, 1, 'EXPRESS', 'PRIVATE', '2500', '10000', '300', '9000', '500', '150', '10', '7', '5', '15', '10', '8'),
(24, 1, '2018-12-18 16:39:05', NULL, NULL, 1, 'Y', '2', '2', '1', NULL, 'N', 5, 1, 'PREMIUM', 'PRIVATE', '2500', '10000', '300', '9000', '500', '150', '10', '7', '5', '15', '10', '8'),
(25, 1, '2018-12-18 16:43:25', NULL, NULL, 1, 'N', '1', '2', ' ', NULL, 'N', 5, 1, 'PREMIUM', 'PRIVATE', '2500', '10000', '300', '9000', '500', '150', '10', '7', '5', '15', '10', '8'),
(26, 1, '2018-12-18 16:43:25', NULL, NULL, 1, 'Y', '2', '2', '1', NULL, 'N', 5, 1, 'PREMIUM', 'PRIVATE', '2500', '10000', '300', '9000', '500', '150', '10', '7', '5', '15', '10', '8'),
(27, 1, '2018-12-18 17:01:24', NULL, NULL, 1, 'N', '1', '1', ' ', NULL, 'N', 5, 1, 'PREMIUM', 'PRIVATE', '2500', '10000', '300', '9000', '500', '150', '10', '7', '5', '15', '10', '8'),
(28, 1, '2018-12-18 16:39:05', NULL, NULL, 1, 'N', '1', '1', ' ', NULL, 'N', 6, 1, 'EXPRESS', 'PRIVATE', '2500', '10000', '300', '9000', '500', '150', '10', '7', '5', '15', '10', '8'),
(29, 1, '2018-12-18 16:39:05', NULL, NULL, 1, 'Y', '2', '2', '1', NULL, 'N', 6, 1, 'EXPRESS', 'PRIVATE', '2500', '10000', '300', '9000', '500', '150', '10', '7', '5', '15', '10', '8'),
(30, 1, '2018-12-18 16:43:25', NULL, NULL, 1, 'N', '1', '3', ' ', NULL, 'N', 6, 1, 'EXPRESS', 'PRIVATE', '2500', '10000', '300', '9000', '500', '150', '10', '7', '5', '15', '10', '8'),
(31, 1, '2018-12-18 16:43:25', NULL, NULL, 1, 'Y', '2', '4', '1', NULL, 'N', 6, 1, 'EXPRESS', 'PRIVATE', '2500', '10000', '300', '9000', '500', '150', '10', '7', '5', '15', '10', '8'),
(32, 1, '2018-12-18 17:01:24', NULL, NULL, 1, 'N', '1', '2', ' ', NULL, 'N', 6, 1, 'EXPRESS', 'PRIVATE', '2500', '10000', '300', '9000', '500', '150', '10', '7', '5', '15', '10', '8'),
(33, 1, '2018-12-18 16:39:05', NULL, NULL, 1, 'N', ' ', '1', ' ', NULL, 'N', 7, 3, 'EXPRESS', 'PRIVATE', '2500', '10000', '300', '9000', '500', '150', '10', '7', '5', '15', '10', '8'),
(34, 1, '2018-12-18 16:39:05', NULL, NULL, 1, 'Y', '2', '2', '1', NULL, 'N', 7, 3, 'EXPRESS', 'PRIVATE', '2500', '10000', '300', '9000', '500', '150', '10', '7', '5', '15', '10', '8'),
(35, 1, '2018-12-18 16:43:25', NULL, NULL, 1, 'N', '1', '1', ' ', NULL, 'N', 7, 3, 'PREMIUM', 'PRIVATE', '2500', '10000', '300', '9000', '500', '150', '10', '7', '5', '15', '10', '8'),
(36, 1, '2018-12-18 16:43:25', NULL, NULL, 1, 'Y', '2', '3', '1', NULL, 'N', 7, 3, 'PREMIUM', 'PRIVATE', '2500', '10000', '300', '9000', '500', '150', '10', '7', '5', '15', '10', '8'),
(37, 1, '2018-12-18 16:39:05', NULL, NULL, 1, 'Y', '2', '2', '1', NULL, 'N', 7, 3, 'EXPRESS', 'PRIVATE', '2500', '10000', '300', '9000', '500', '150', '10', '7', '5', '15', '10', '8'),
(38, 1, '2018-12-18 16:43:25', NULL, NULL, 1, 'N', '1', '3', ' ', NULL, 'N', 7, 3, 'EXPRESS', 'PRIVATE', '2500', '10000', '300', '9000', '500', '150', '10', '7', '5', '15', '10', '8'),
(39, 1, '2018-12-18 16:43:25', NULL, NULL, 1, 'Y', '2', '4', '1', NULL, 'N', 7, 3, 'EXPRESS', 'PRIVATE', '2500', '10000', '300', '9000', '500', '150', '10', '7', '5', '15', '10', '8'),
(40, 1, '2018-12-18 17:01:24', NULL, NULL, 1, 'N', '1', '2', ' ', NULL, 'N', 8, 3, 'EXPRESS', 'PRIVATE', '2500', '10000', '300', '9000', '500', '150', '10', '7', '5', '15', '10', '8'),
(41, 1, '2018-12-18 16:39:05', NULL, NULL, 1, 'N', '1', '4', ' ', NULL, 'N', 8, 3, 'EXPRESS', 'PRIVATE', '2500', '10000', '300', '9000', '500', '150', '10', '7', '5', '15', '10', '8'),
(42, 1, '2018-12-18 16:39:05', NULL, NULL, 1, 'Y', '2', '2', '1', NULL, 'N', 8, 3, 'PREMIUM', 'PRIVATE', '2500', '10000', '300', '9000', '500', '150', '10', '7', '5', '15', '10', '8'),
(43, 1, '2018-12-18 16:43:25', NULL, NULL, 1, 'N', '1', '2', ' ', NULL, 'N', 8, 3, 'PREMIUM', 'PRIVATE', '2500', '10000', '300', '9000', '500', '150', '10', '7', '5', '15', '10', '8'),
(44, 1, '2018-12-18 16:43:25', NULL, NULL, 1, 'Y', '2', '2', '1', NULL, 'N', 8, 3, 'PREMIUM', 'PRIVATE', '2500', '10000', '300', '9000', '500', '150', '10', '7', '5', '15', '10', '8'),
(45, 1, '2018-12-18 17:01:24', NULL, NULL, 1, 'N', '1', '1', ' ', NULL, 'N', 8, 3, 'PREMIUM', 'PRIVATE', '2500', '10000', '300', '9000', '500', '150', '10', '7', '5', '15', '10', '8'),
(46, 1, '2018-12-18 16:39:05', NULL, NULL, 1, 'N', '1', '1', ' ', NULL, 'N', 8, 3, 'EXPRESS', 'PRIVATE', '2500', '10000', '300', '9000', '500', '150', '10', '7', '5', '15', '10', '8'),
(47, 1, '2018-12-18 17:01:24', NULL, NULL, 1, 'N', '1', '1', ' ', NULL, 'N', 9, 3, 'NORMAL', 'PRIVATE', '2500', '10000', '300', '9000', '500', '150', '10', '7', '5', '15', '10', '8'),
(48, 1, '2018-12-18 16:39:05', NULL, NULL, 1, 'N', '1', '1', ' ', NULL, 'N', 9, 3, 'PREMIUM', 'PRIVATE', '2500', '10000', '300', '9000', '500', '150', '10', '7', '5', '15', '10', '8'),
(49, 1, '2018-12-18 16:39:05', NULL, NULL, 1, 'Y', '2', '2', '1', NULL, 'N', 9, 3, 'PREMIUM', 'PRIVATE', '2500', '10000', '300', '9000', '500', '150', '10', '7', '5', '15', '10', '8'),
(50, 1, '2018-12-18 16:43:25', NULL, NULL, 1, 'N', '1', '3', ' ', NULL, 'N', 9, 3, 'PREMIUM', 'PRIVATE', '2500', '10000', '300', '9000', '500', '150', '10', '7', '5', '15', '10', '8'),
(51, 1, '2018-12-18 16:43:25', NULL, NULL, 1, 'Y', '2', '4', '1', NULL, 'N', 9, 3, 'PREMIUM', 'PRIVATE', '2500', '10000', '300', '9000', '500', '150', '10', '7', '5', '15', '10', '8'),
(52, 1, '2018-12-18 17:01:24', NULL, NULL, 1, 'N', '1', '4', ' ', NULL, 'N', 9, 3, 'PREMIUM', 'PRIVATE', '2500', '10000', '300', '9000', '500', '150', '10', '7', '5', '15', '10', '8'),
(53, 1, '2018-12-18 16:39:05', NULL, NULL, 1, 'N', '1', '2', ' ', NULL, 'N', 9, 3, 'EXPRESS', 'PRIVATE', '2500', '10000', '300', '9000', '500', '150', '10', '7', '5', '15', '10', '8'),
(54, 1, '2018-12-18 16:39:05', NULL, NULL, 1, 'Y', '2', '3', '1', NULL, 'N', 9, 3, 'EXPRESS', 'PRIVATE', '2500', '10000', '300', '9000', '500', '150', '10', '7', '5', '15', '10', '8'),
(55, 1, '2018-12-18 16:43:25', NULL, NULL, 1, 'Y', '2', '1', '1', NULL, 'N', 9, 3, 'EXPRESS', 'PRIVATE', '2500', '10000', '300', '9000', '500', '150', '10', '7', '5', '15', '10', '8'),
(56, 1, '2018-12-18 17:01:24', NULL, NULL, 1, 'N', '1', '4', ' ', NULL, 'N', 10, 3, 'PREMIUM', 'PRIVATE', '2500', '10000', '300', '9000', '500', '150', '10', '7', '5', '15', '10', '8'),
(57, 1, '2018-12-18 16:39:05', NULL, NULL, 1, 'N', '1', '2', ' ', NULL, 'N', 10, 3, 'EXPRESS', 'PRIVATE', '2500', '10000', '300', '9000', '500', '150', '10', '7', '5', '15', '10', '8'),
(58, 1, '2018-12-18 16:39:05', NULL, NULL, 1, 'Y', '2', '3', '1', NULL, 'N', 10, 3, 'EXPRESS', 'PRIVATE', '2500', '10000', '300', '9000', '500', '150', '10', '7', '5', '15', '10', '8'),
(59, 1, '2018-12-18 16:43:25', NULL, NULL, 1, 'Y', '2', '2', '1', NULL, 'N', 10, 3, 'NORMAL', 'PRIVATE', '2500', '10000', '300', '9000', '500', '150', '10', '7', '5', '15', '10', '8'),
(60, 1, '2018-12-18 17:01:24', NULL, NULL, 1, 'N', '1', '4', ' ', NULL, 'N', 10, 3, 'NORMAL', 'PRIVATE', '2500', '10000', '300', '9000', '500', '150', '10', '7', '5', '15', '10', '8'),
(61, 1, '2018-12-18 16:39:05', NULL, NULL, 1, 'N', '1', '1', ' ', NULL, 'N', 10, 3, 'EXPRESS', 'PRIVATE', '2500', '10000', '300', '9000', '500', '150', '10', '7', '5', '15', '10', '8'),
(62, 1, '2018-12-18 16:39:05', NULL, NULL, 1, 'Y', '2', '2', '1', NULL, 'N', 10, 3, 'EXPRESS', 'PRIVATE', '2500', '10000', '300', '9000', '500', '150', '10', '7', '5', '15', '10', '8'),
(63, 1, '2018-12-18 16:43:25', NULL, NULL, 1, 'N', '1', '3', ' ', NULL, 'N', 10, 3, 'EXPRESS', 'PRIVATE', '2500', '10000', '300', '9000', '500', '150', '10', '7', '5', '15', '10', '8'),
(64, 1, '2018-12-18 17:01:24', NULL, NULL, 1, 'N', '1', '2', ' ', NULL, 'N', 10, 3, 'EXPRESS', 'PRIVATE', '2500', '10000', '300', '9000', '500', '150', '10', '7', '5', '15', '10', '8'),
(65, 1, '2018-12-18 16:43:25', NULL, NULL, 1, 'N', '1', '4', ' ', NULL, 'N', 10, 3, 'NORMAL', 'PRIVATE', '2500', '10000', '300', '9000', '500', '150', '10', '7', '5', '15', '10', '8'),
(66, 1, '2018-12-18 17:01:24', NULL, NULL, 1, 'N', '1', '1', ' ', NULL, 'N', 10, 3, 'NORMAL', 'PRIVATE', '2500', '10000', '300', '9000', '500', '150', '10', '7', '5', '15', '10', '8'),
(67, 1, '2018-12-18 16:39:05', NULL, NULL, 1, 'N', '1', '1', ' ', NULL, 'N', 11, 3, 'PREMIUM', 'PRIVATE', '2500', '10000', '300', '9000', '500', '150', '10', '7', '5', '15', '10', '8'),
(68, 1, '2018-12-18 16:39:05', NULL, NULL, 1, 'Y', '2', '2', '1', NULL, 'N', 11, 3, 'PREMIUM', 'PRIVATE', '2500', '10000', '300', '9000', '500', '150', '10', '7', '5', '15', '10', '8'),
(69, 1, '2018-12-18 16:43:25', NULL, NULL, 1, 'N', '1', '3', ' ', NULL, 'N', 11, 3, 'PREMIUM', 'PRIVATE', '2500', '10000', '300', '9000', '500', '150', '10', '7', '5', '15', '10', '8'),
(70, 1, '2018-12-18 16:43:25', NULL, NULL, 1, 'Y', '2', '4', '1', NULL, 'N', 11, 3, 'PREMIUM', 'PRIVATE', '2500', '10000', '300', '9000', '500', '150', '10', '7', '5', '15', '10', '8'),
(71, 1, '2018-12-18 17:01:24', NULL, NULL, 1, 'N', '1', '4', ' ', NULL, 'N', 11, 3, 'PREMIUM', 'PRIVATE', '2500', '10000', '300', '9000', '500', '150', '10', '7', '5', '15', '10', '8'),
(72, 1, '2018-12-18 16:39:05', NULL, NULL, 1, 'N', '1', '2', ' ', NULL, 'N', 11, 3, 'EXPRESS', 'PRIVATE', '2500', '10000', '300', '9000', '500', '150', '10', '7', '5', '15', '10', '8'),
(73, 1, '2018-12-18 16:39:05', NULL, NULL, 1, 'Y', '2', '3', '1', NULL, 'N', 11, 3, 'EXPRESS', 'PRIVATE', '2500', '10000', '300', '9000', '500', '150', '10', '7', '5', '15', '10', '8'),
(74, 1, '2018-12-18 16:43:25', NULL, NULL, 1, 'Y', '2', '2', '1', NULL, 'N', 11, 3, 'NORMAL', 'PRIVATE', '2500', '10000', '300', '9000', '500', '150', '10', '7', '5', '15', '10', '8'),
(75, 1, '2018-12-18 17:01:24', NULL, NULL, 1, 'N', '1', '4', ' ', NULL, 'N', 11, 3, 'NORMAL', 'PRIVATE', '2500', '10000', '300', '9000', '500', '150', '10', '7', '5', '15', '10', '8'),
(76, 1, '2018-12-18 16:39:05', NULL, NULL, 1, 'N', '1', '1', ' ', NULL, 'N', 11, 3, 'EXPRESS', 'PRIVATE', '2500', '10000', '300', '9000', '500', '150', '10', '7', '5', '15', '10', '8'),
(77, 1, '2018-12-18 16:39:05', NULL, NULL, 1, 'Y', '2', '2', '1', NULL, 'N', 11, 3, 'EXPRESS', 'PRIVATE', '2500', '10000', '300', '9000', '500', '150', '10', '7', '5', '15', '10', '8'),
(78, 1, '2018-12-18 16:43:25', NULL, NULL, 1, 'N', '1', '3', ' ', NULL, 'N', 11, 3, 'EXPRESS', 'PRIVATE', '2500', '10000', '300', '9000', '500', '150', '10', '7', '5', '15', '10', '8'),
(79, 1, '2018-12-18 16:43:25', NULL, NULL, 1, 'Y', '2', '4', '1', NULL, 'N', 11, 3, 'EXPRESS', 'PRIVATE', '2500', '10000', '300', '9000', '500', '150', '10', '7', '5', '15', '10', '8'),
(80, 1, '2018-12-18 17:01:24', NULL, NULL, 1, 'N', '1', '2', ' ', NULL, 'N', 11, 3, 'EXPRESS', 'PRIVATE', '2500', '10000', '300', '9000', '500', '150', '10', '7', '5', '15', '10', '8'),
(81, 1, '2018-12-18 16:39:05', NULL, NULL, 1, 'Y', '2', '3', '1', NULL, 'N', 12, 4, 'EXPRESS', 'PRIVATE', '2500', '10000', '300', '9000', '500', '150', '10', '7', '5', '15', '10', '8'),
(82, 1, '2018-12-18 16:43:25', NULL, NULL, 1, 'Y', '2', '1', '1', NULL, 'N', 12, 4, 'EXPRESS', 'PRIVATE', '2500', '10000', '300', '9000', '500', '150', '10', '7', '5', '15', '10', '8'),
(83, 1, '2018-12-18 17:01:24', NULL, NULL, 1, 'N', '1', '4', ' ', NULL, 'N', 12, 4, 'PREMIUM', 'PRIVATE', '2500', '10000', '300', '9000', '500', '150', '10', '7', '5', '15', '10', '8'),
(84, 1, '2018-12-18 16:39:05', NULL, NULL, 1, 'N', '1', '2', ' ', NULL, 'N', 12, 4, 'EXPRESS', 'PRIVATE', '2500', '10000', '300', '9000', '500', '150', '10', '7', '5', '15', '10', '8'),
(85, 1, '2018-12-18 16:39:05', NULL, NULL, 1, 'Y', '2', '3', '1', NULL, 'N', 12, 4, 'EXPRESS', 'PRIVATE', '2500', '10000', '300', '9000', '500', '150', '10', '7', '5', '15', '10', '8'),
(86, 1, '2018-12-18 16:43:25', NULL, NULL, 1, 'Y', '2', '2', '1', NULL, 'N', 12, 4, 'NORMAL', 'PRIVATE', '2500', '10000', '300', '9000', '500', '150', '10', '7', '5', '15', '10', '8'),
(87, 1, '2018-12-18 17:01:24', NULL, NULL, 1, 'N', '1', '4', ' ', NULL, 'N', 12, 4, 'NORMAL', 'PRIVATE', '2500', '10000', '300', '9000', '500', '150', '10', '7', '5', '15', '10', '8'),
(88, 1, '2018-12-18 16:39:05', NULL, NULL, 1, 'N', '1', '1', ' ', NULL, 'N', 12, 4, 'EXPRESS', 'PRIVATE', '2500', '10000', '300', '9000', '500', '150', '10', '7', '5', '15', '10', '8'),
(89, 1, '2018-12-18 16:39:05', NULL, NULL, 1, 'Y', '2', '2', '1', NULL, 'N', 12, 4, 'EXPRESS', 'PRIVATE', '2500', '10000', '300', '9000', '500', '150', '10', '7', '5', '15', '10', '8'),
(90, 1, '2018-12-18 16:43:25', NULL, NULL, 1, 'N', '1', '3', ' ', NULL, 'N', 12, 4, 'EXPRESS', 'PRIVATE', '2500', '10000', '300', '9000', '500', '150', '10', '7', '5', '15', '10', '8'),
(91, 1, '2018-12-18 17:01:24', NULL, NULL, 1, 'N', '1', '2', ' ', NULL, 'N', 12, 4, 'EXPRESS', 'PRIVATE', '2500', '10000', '300', '9000', '500', '150', '10', '7', '5', '15', '10', '8'),
(92, 1, '2018-12-18 16:43:25', NULL, NULL, 1, 'N', '1', '4', ' ', NULL, 'N', 12, 4, 'NORMAL', 'PRIVATE', '2500', '10000', '300', '9000', '500', '150', '10', '7', '5', '15', '10', '8'),
(93, 1, '2018-12-18 17:01:24', NULL, NULL, 1, 'N', '1', '1', ' ', NULL, 'N', 12, 4, 'NORMAL', 'PRIVATE', '2500', '10000', '300', '9000', '500', '150', '10', '7', '5', '15', '10', '8'),
(94, 1, '2018-12-18 16:39:05', NULL, NULL, 1, 'N', '1', '1', ' ', NULL, 'N', 12, 4, 'PREMIUM', 'PRIVATE', '2500', '10000', '300', '9000', '500', '150', '10', '7', '5', '15', '10', '8'),
(95, 1, '2018-12-18 16:43:25', NULL, NULL, 1, 'N', '1', '3', ' ', NULL, 'N', 13, 4, 'EXPRESS', 'PRIVATE', '2500', '10000', '300', '9000', '500', '150', '10', '7', '5', '15', '10', '8'),
(96, 1, '2018-12-18 16:43:25', NULL, NULL, 1, 'Y', '2', '4', '1', NULL, 'N', 13, 4, 'EXPRESS', 'PRIVATE', '2500', '10000', '300', '9000', '500', '150', '10', '7', '5', '15', '10', '8'),
(97, 1, '2018-12-18 16:39:05', NULL, NULL, 1, 'N', ' ', '1', ' ', NULL, 'N', 13, 4, 'EXPRESS', 'PRIVATE', '2500', '10000', '300', '9000', '500', '150', '10', '7', '5', '15', '10', '8'),
(98, 1, '2018-12-18 16:39:05', NULL, NULL, 1, 'Y', '2', '2', '1', NULL, 'N', 13, 4, 'EXPRESS', 'PRIVATE', '2500', '10000', '300', '9000', '500', '150', '10', '7', '5', '15', '10', '8'),
(99, 1, '2018-12-18 16:43:25', NULL, NULL, 1, 'N', '1', '1', ' ', NULL, 'N', 13, 4, 'PREMIUM', 'PRIVATE', '2500', '10000', '300', '9000', '500', '150', '10', '7', '5', '15', '10', '8'),
(100, 1, '2018-12-18 16:43:25', NULL, NULL, 1, 'Y', '2', '3', '1', NULL, 'N', 13, 4, 'PREMIUM', 'PRIVATE', '2500', '10000', '300', '9000', '500', '150', '10', '7', '5', '15', '10', '8'),
(101, 1, '2018-12-18 16:39:05', NULL, NULL, 1, 'Y', '2', '2', '1', NULL, 'N', 13, 4, 'EXPRESS', 'PRIVATE', '2500', '10000', '300', '9000', '500', '150', '10', '7', '5', '15', '10', '8'),
(102, 1, '2018-12-18 16:39:05', NULL, NULL, 1, 'N', '1', '1', ' ', NULL, 'N', 13, 4, 'PREMIUM', 'PRIVATE', '2500', '10000', '300', '9000', '500', '150', '10', '7', '5', '15', '10', '8'),
(103, 1, '2018-12-18 16:39:05', NULL, NULL, 1, 'Y', '2', '2', '1', NULL, 'N', 13, 4, 'PREMIUM', 'PRIVATE', '2500', '10000', '300', '9000', '500', '150', '10', '7', '5', '15', '10', '8'),
(104, 1, '2018-12-18 16:43:25', NULL, NULL, 1, 'N', '1', '3', ' ', NULL, 'N', 13, 4, 'PREMIUM', 'PRIVATE', '2500', '10000', '300', '9000', '500', '150', '10', '7', '5', '15', '10', '8'),
(105, 1, '2018-12-18 16:43:25', NULL, NULL, 1, 'Y', '2', '4', '1', NULL, 'N', 13, 4, 'PREMIUM', 'PRIVATE', '2500', '10000', '300', '9000', '500', '150', '10', '7', '5', '15', '10', '8'),
(106, 1, '2018-12-18 17:01:24', NULL, NULL, 1, 'N', '1', '1', ' ', NULL, 'N', 13, 4, 'PREMIUM', 'PRIVATE', '2500', '10000', '300', '9000', '500', '150', '10', '7', '5', '15', '10', '8'),
(107, 1, '2018-12-18 16:39:05', NULL, NULL, 1, 'N', '1', '1', ' ', NULL, 'N', 13, 4, 'EXPRESS', 'PRIVATE', '2500', '10000', '300', '9000', '500', '150', '10', '7', '5', '15', '10', '8'),
(108, 1, '2018-12-18 17:01:24', NULL, NULL, 1, 'N', '1', '1', ' ', NULL, 'N', 13, 4, 'NORMAL', 'PRIVATE', '2500', '10000', '300', '9000', '500', '150', '10', '7', '5', '15', '10', '8'),
(109, 1, '2018-12-18 16:39:05', NULL, NULL, 1, 'Y', '2', '2', '1', NULL, 'N', 14, 4, 'PREMIUM', 'PRIVATE', '2500', '10000', '300', '9000', '500', '150', '10', '7', '5', '15', '10', '8'),
(110, 1, '2018-12-18 16:43:25', NULL, NULL, 1, 'N', '1', '3', ' ', NULL, 'N', 14, 4, 'PREMIUM', 'PRIVATE', '2500', '10000', '300', '9000', '500', '150', '10', '7', '5', '15', '10', '8'),
(111, 1, '2018-12-18 16:43:25', NULL, NULL, 1, 'Y', '2', '4', '1', NULL, 'N', 14, 4, 'PREMIUM', 'PRIVATE', '2500', '10000', '300', '9000', '500', '150', '10', '7', '5', '15', '10', '8'),
(112, 1, '2018-12-18 17:01:24', NULL, NULL, 1, 'N', '1', '4', ' ', NULL, 'N', 14, 4, 'PREMIUM', 'PRIVATE', '2500', '10000', '300', '9000', '500', '150', '10', '7', '5', '15', '10', '8'),
(113, 1, '2018-12-18 16:39:05', NULL, NULL, 1, 'N', '1', '2', ' ', NULL, 'N', 14, 4, 'EXPRESS', 'PRIVATE', '2500', '10000', '300', '9000', '500', '150', '10', '7', '5', '15', '10', '8'),
(114, 1, '2018-12-18 16:39:05', NULL, NULL, 1, 'Y', '2', '3', '1', NULL, 'N', 15, 4, 'EXPRESS', 'PRIVATE', '2500', '10000', '300', '9000', '500', '150', '10', '7', '5', '15', '10', '8'),
(115, 1, '2018-12-18 16:43:25', NULL, NULL, 1, 'Y', '2', '2', '1', NULL, 'N', 15, 4, 'NORMAL', 'PRIVATE', '2500', '10000', '300', '9000', '500', '150', '10', '7', '5', '15', '10', '8'),
(116, 1, '2018-12-18 17:01:24', NULL, NULL, 1, 'N', '1', '4', ' ', NULL, 'N', 15, 4, 'NORMAL', 'PRIVATE', '2500', '10000', '300', '9000', '500', '150', '10', '7', '5', '15', '10', '8'),
(117, 1, '2018-12-18 16:39:05', NULL, NULL, 1, 'N', '1', '1', ' ', NULL, 'N', 15, 4, 'EXPRESS', 'PRIVATE', '2500', '10000', '300', '9000', '500', '150', '10', '7', '5', '15', '10', '8'),
(118, 1, '2018-12-18 16:39:05', NULL, NULL, 1, 'Y', '2', '2', '1', NULL, 'N', 15, 4, 'EXPRESS', 'PRIVATE', '2500', '10000', '300', '9000', '500', '150', '10', '7', '5', '15', '10', '8'),
(119, 1, '2018-12-18 16:43:25', NULL, NULL, 1, 'N', '1', '3', ' ', NULL, 'N', 15, 4, 'EXPRESS', 'PRIVATE', '2500', '10000', '300', '9000', '500', '150', '10', '7', '5', '15', '10', '8'),
(120, 1, '2018-12-18 16:43:25', NULL, NULL, 1, 'Y', '2', '4', '1', NULL, 'N', 15, 4, 'EXPRESS', 'PRIVATE', '2500', '10000', '300', '9000', '500', '150', '10', '7', '5', '15', '10', '8'),
(121, 1, '2018-12-18 17:01:24', NULL, NULL, 1, 'N', '1', '2', ' ', NULL, 'N', 15, 4, 'EXPRESS', 'PRIVATE', '2500', '10000', '300', '9000', '500', '150', '10', '7', '5', '15', '10', '8'),
(122, 1, '2018-12-18 17:01:24', NULL, NULL, 1, 'N', '1', '4', ' ', NULL, 'N', 15, 4, 'PREMIUM', 'PRIVATE', '2500', '10000', '300', '9000', '500', '150', '10', '7', '5', '15', '10', '8'),
(123, 1, '2018-12-18 16:39:05', NULL, NULL, 1, 'N', '1', '2', ' ', NULL, 'N', 15, 4, 'EXPRESS', 'PRIVATE', '2500', '10000', '300', '9000', '500', '150', '10', '7', '5', '15', '10', '8'),
(124, 1, '2018-12-18 17:01:24', NULL, NULL, 1, 'N', '1', '2', ' ', NULL, 'N', 15, 4, 'EXPRESS', 'PRIVATE', '2500', '10000', '300', '9000', '500', '150', '10', '7', '5', '15', '10', '8'),
(125, 1, '2018-12-18 16:39:05', NULL, NULL, 1, 'N', '1', '4', ' ', NULL, 'N', 15, 4, 'EXPRESS', 'PRIVATE', '2500', '10000', '300', '9000', '500', '150', '10', '7', '5', '15', '10', '8'),
(126, 1, '2018-12-18 16:39:05', NULL, NULL, 1, 'Y', '2', '2', '1', NULL, 'N', 15, 4, 'PREMIUM', 'PRIVATE', '2500', '10000', '300', '9000', '500', '150', '10', '7', '5', '15', '10', '8'),
(127, 1, '2018-12-18 16:43:25', NULL, NULL, 1, 'N', '1', '2', ' ', NULL, 'N', 16, 4, 'PREMIUM', 'PRIVATE', '2500', '10000', '300', '9000', '500', '150', '10', '7', '5', '15', '10', '8'),
(128, 1, '2018-12-18 16:43:25', NULL, NULL, 1, 'Y', '2', '2', '1', NULL, 'N', 16, 4, 'PREMIUM', 'PRIVATE', '2500', '10000', '300', '9000', '500', '150', '10', '7', '5', '15', '10', '8'),
(129, 1, '2018-12-18 16:39:05', NULL, NULL, 1, 'N', ' ', ' ', '2', NULL, 'Y', 17, 5, 'EXPRESS', 'SHARED', '2500', '10000', '300', '9000', '500', '150', '10', '7', '5', '15', '10', '8'),
(130, 1, '2018-12-18 16:43:25', NULL, NULL, 1, 'N', ' ', ' ', '1', NULL, 'Y', 17, 5, 'EXPRESS', 'SHARED', '2500', '10000', '300', '9000', '500', '150', '10', '7', '5', '15', '10', '8'),
(131, 1, '2018-12-18 17:01:24', NULL, NULL, 1, 'N', ' ', ' ', ' ', NULL, 'N', 17, 5, 'PREMIUM', 'SHARED', '2500', '10000', '300', '9000', '500', '150', '10', '7', '5', '15', '10', '8'),
(132, 1, '2018-12-18 16:39:05', NULL, NULL, 1, 'N', ' ', ' ', '1', NULL, 'Y', 18, 5, 'EXPRESS', 'SHARED', '2500', '10000', '300', '9000', '500', '150', '10', '7', '5', '15', '10', '8'),
(133, 1, '2018-12-18 16:39:05', NULL, NULL, 1, 'N', ' ', ' ', '3', NULL, 'Y', 18, 5, 'EXPRESS', 'SHARED', '2500', '10000', '300', '9000', '500', '150', '10', '7', '5', '15', '10', '8'),
(134, 1, '2018-12-18 16:43:25', NULL, NULL, 1, 'N', ' ', ' ', '1', NULL, 'Y', 18, 5, 'NORMAL', 'SHARED', '2500', '10000', '300', '9000', '500', '150', '10', '7', '5', '15', '10', '8'),
(135, 1, '2018-12-18 17:01:24', NULL, NULL, 1, 'N', ' ', ' ', '1', NULL, 'Y', 18, 5, 'NORMAL', 'SHARED', '2500', '10000', '300', '9000', '500', '150', '10', '7', '5', '15', '10', '8'),
(136, 1, '2018-12-18 16:39:05', NULL, NULL, 1, 'N', ' ', ' ', '2', NULL, 'Y', 19, 5, 'EXPRESS', 'SHARED', '2500', '10000', '300', '9000', '500', '150', '10', '7', '5', '15', '10', '8'),
(137, 1, '2018-12-18 16:39:05', NULL, NULL, 1, 'N', ' ', ' ', '1', NULL, 'Y', 19, 5, 'EXPRESS', 'SHARED', '2500', '10000', '300', '9000', '500', '150', '10', '7', '5', '15', '10', '8'),
(138, 1, '2018-12-18 16:43:25', NULL, NULL, 1, 'N', ' ', ' ', '3', NULL, 'Y', 19, 5, 'EXPRESS', 'SHARED', '2500', '10000', '300', '9000', '500', '150', '10', '7', '5', '15', '10', '8'),
(139, 1, '2018-12-18 17:01:24', NULL, NULL, 1, 'N', ' ', ' ', '1', NULL, 'Y', 20, 5, 'EXPRESS', 'SHARED', '2500', '10000', '300', '9000', '500', '150', '10', '7', '5', '15', '10', '8'),
(140, 1, '2018-12-18 16:43:25', NULL, NULL, 1, 'N', ' ', ' ', ' ', NULL, 'N', 20, 5, 'NORMAL', 'SHARED', '2500', '10000', '300', '9000', '500', '150', '10', '7', '5', '15', '10', '8'),
(141, 1, '2018-12-18 17:01:24', NULL, NULL, 1, 'N', ' ', ' ', '1', NULL, 'Y', 20, 5, 'NORMAL', 'SHARED', '2500', '10000', '300', '9000', '500', '150', '10', '7', '5', '15', '10', '8'),
(142, 1, '2018-12-18 16:39:05', NULL, NULL, 1, 'N', ' ', ' ', '2', NULL, 'Y', 21, 5, 'PREMIUM', 'SHARED', '2500', '10000', '300', '9000', '500', '150', '10', '7', '5', '15', '10', '8'),
(143, 1, '2018-12-18 16:39:05', NULL, NULL, 1, 'N', ' ', ' ', '2', NULL, 'Y', 22, 6, 'EXPRESS', 'SHARED', '2500', '10000', '300', '9000', '500', '150', '10', '7', '5', '15', '10', '8'),
(144, 1, '2018-12-18 16:43:25', NULL, NULL, 1, 'N', ' ', ' ', '1', NULL, 'Y', 22, 6, 'EXPRESS', 'SHARED', '2500', '10000', '300', '9000', '500', '150', '10', '7', '5', '15', '10', '8'),
(145, 1, '2018-12-18 16:39:05', NULL, NULL, 1, 'N', ' ', ' ', '3', NULL, 'Y', 22, 6, 'EXPRESS', 'SHARED', '2500', '10000', '300', '9000', '500', '150', '10', '7', '5', '15', '10', '8'),
(146, 1, '2018-12-18 16:43:25', NULL, NULL, 1, 'N', ' ', ' ', '1', NULL, 'Y', 22, 6, 'NORMAL', 'SHARED', '2500', '10000', '300', '9000', '500', '150', '10', '7', '5', '15', '10', '8'),
(147, 1, '2018-12-18 17:01:24', NULL, NULL, 1, 'N', ' ', ' ', '1', NULL, 'Y', 23, 6, 'NORMAL', 'SHARED', '2500', '10000', '300', '9000', '500', '150', '10', '7', '5', '15', '10', '8'),
(148, 1, '2018-12-18 16:39:05', NULL, NULL, 1, 'N', ' ', ' ', '2', NULL, 'Y', 23, 6, 'EXPRESS', 'SHARED', '2500', '10000', '300', '9000', '500', '150', '10', '7', '5', '15', '10', '8'),
(149, 1, '2018-12-18 16:43:25', NULL, NULL, 1, 'N', ' ', ' ', ' ', NULL, 'N', 23, 6, 'NORMAL', 'SHARED', '2500', '10000', '300', '9000', '500', '150', '10', '7', '5', '15', '10', '8'),
(150, 1, '2018-12-18 17:01:24', NULL, NULL, 1, 'N', ' ', ' ', '1', NULL, 'Y', 24, 6, 'NORMAL', 'SHARED', '2500', '10000', '300', '9000', '500', '150', '10', '7', '5', '15', '10', '8'),
(151, 1, '2018-12-18 16:39:05', NULL, NULL, 1, 'N', ' ', ' ', '2', NULL, 'Y', 24, 6, 'PREMIUM', 'SHARED', '2500', '10000', '300', '9000', '500', '150', '10', '7', '5', '15', '10', '8'),
(152, 1, '2018-12-18 16:39:05', NULL, NULL, 1, 'N', ' ', ' ', '1', NULL, 'Y', 25, 6, 'EXPRESS', 'SHARED', '2500', '10000', '300', '9000', '500', '150', '10', '7', '5', '15', '10', '8'),
(153, 1, '2018-12-18 16:39:05', NULL, NULL, 1, 'N', ' ', ' ', '1', NULL, 'Y', 25, 6, 'EXPRESS', 'SHARED', '2500', '10000', '300', '9000', '500', '150', '10', '7', '5', '15', '10', '8'),
(154, 1, '2018-12-18 17:01:24', NULL, NULL, 1, 'N', ' ', ' ', '1', NULL, 'Y', 25, 6, 'EXPRESS', 'SHARED', '2500', '10000', '300', '9000', '500', '150', '10', '7', '5', '15', '10', '8'),
(155, 1, '2018-12-18 16:43:25', NULL, NULL, 1, 'N', ' ', ' ', ' ', NULL, 'N', 25, 6, 'NORMAL', 'SHARED', '2500', '10000', '300', '9000', '500', '150', '10', '7', '5', '15', '10', '8'),
(156, 1, '2018-12-18 17:01:24', NULL, NULL, 1, 'N', ' ', ' ', '1', NULL, 'Y', 25, 6, 'NORMAL', 'SHARED', '2500', '10000', '300', '9000', '500', '150', '10', '7', '5', '15', '10', '8'),
(157, 1, '2018-12-18 16:39:05', NULL, NULL, 1, 'N', ' ', ' ', '2', NULL, 'Y', 25, 6, 'PREMIUM', 'SHARED', '2500', '10000', '300', '9000', '500', '150', '10', '7', '5', '15', '10', '8'),
(158, 1, '2018-12-18 16:43:25', NULL, NULL, 1, 'N', ' ', ' ', '3', NULL, 'Y', 25, 6, 'EXPRESS', 'SHARED', '2500', '10000', '300', '9000', '500', '150', '10', '7', '5', '15', '10', '8'),
(159, 1, '2018-12-18 17:01:24', NULL, NULL, 1, 'N', ' ', ' ', '1', NULL, 'Y', 25, 6, 'EXPRESS', 'SHARED', '2500', '10000', '300', '9000', '500', '150', '10', '7', '5', '15', '10', '8'),
(160, 1, '2018-12-18 16:39:05', NULL, NULL, 1, 'N', ' ', ' ', '1', NULL, 'Y', 25, 6, 'EXPRESS', 'SHARED', '2500', '10000', '300', '9000', '500', '150', '10', '7', '5', '15', '10', '8'),
(161, 1, '2018-12-18 16:43:25', NULL, NULL, 1, 'N', ' ', ' ', ' ', NULL, 'Y', 26, 6, 'EXPRESS', 'SHARED', '2500', '10000', '300', '9000', '500', '150', '10', '7', '5', '15', '10', '8');

-- --------------------------------------------------------

--
-- Table structure for table `master_room_category`
--

CREATE TABLE `master_room_category` (
  `room_cat_id` bigint(20) NOT NULL,
  `created_by` bigint(20) DEFAULT NULL,
  `created_date` varchar(255) DEFAULT NULL,
  `modified_by` bigint(20) DEFAULT NULL,
  `modified_date` varchar(255) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `language_id` bigint(20) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `parent_id` bigint(20) DEFAULT NULL,
  `property_type_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `master_room_category`
--

INSERT INTO `master_room_category` (`room_cat_id`, `created_by`, `created_date`, `modified_by`, `modified_date`, `status`, `language_id`, `name`, `parent_id`, `property_type_id`) VALUES
(1, 1, '2018-09-06 01:27:34', NULL, NULL, 1, 1, 'Delux', 0, 1),
(2, 1, '2018-09-06 01:27:34', NULL, NULL, 1, 1, 'Standard Delux', 0, 1),
(3, 1, '2018-09-06 01:27:34', NULL, NULL, 2, 1, 'Normal', 0, 2),
(4, 1, '2018-09-06 01:27:34', NULL, NULL, 2, 1, 'Normal', 0, 3),
(5, 1, '2018-09-06 01:27:34', NULL, NULL, 2, 1, 'Normal', 0, 4),
(6, 1, '2018-09-06 01:27:34', NULL, NULL, 2, 1, 'Normal', 0, 5);

-- --------------------------------------------------------

--
-- Table structure for table `master_space_rule`
--

CREATE TABLE `master_space_rule` (
  `sprule_id` bigint(20) NOT NULL,
  `created_by` bigint(20) DEFAULT NULL,
  `created_date` varchar(255) DEFAULT NULL,
  `modified_by` bigint(20) DEFAULT NULL,
  `modified_date` varchar(255) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `language_id` bigint(20) DEFAULT NULL,
  `parent_id` bigint(20) DEFAULT NULL,
  `rule_name` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `master_space_rule`
--

INSERT INTO `master_space_rule` (`sprule_id`, `created_by`, `created_date`, `modified_by`, `modified_date`, `status`, `language_id`, `parent_id`, `rule_name`) VALUES
(1, 1, '2018-09-06 01:27:34', NULL, NULL, 1, 1, 0, 'Pet Friendly'),
(2, 1, '2018-09-06 01:27:34', NULL, NULL, 1, 1, 0, 'Couple Friendly'),
(3, 1, '2018-09-06 01:27:34', NULL, NULL, 1, 1, 0, 'Smoking');

-- --------------------------------------------------------

--
-- Table structure for table `master_specialties`
--

CREATE TABLE `master_specialties` (
  `specialties_id` bigint(20) NOT NULL,
  `created_by` bigint(20) DEFAULT NULL,
  `created_date` varchar(255) DEFAULT NULL,
  `modified_by` bigint(20) DEFAULT NULL,
  `modified_date` varchar(255) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `language_id` bigint(20) DEFAULT NULL,
  `parent_id` bigint(20) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `master_specialties`
--

INSERT INTO `master_specialties` (`specialties_id`, `created_by`, `created_date`, `modified_by`, `modified_date`, `status`, `language_id`, `parent_id`, `name`) VALUES
(1, 1, '2018-09-06 01:27:34', NULL, NULL, 1, 1, 0, 'Mountain Facing'),
(2, 1, '2018-09-06 01:27:34', NULL, NULL, 1, 1, 0, 'Sea Facing');

-- --------------------------------------------------------

--
-- Table structure for table `master_special_experience`
--

CREATE TABLE `master_special_experience` (
  `experience_id` bigint(20) NOT NULL,
  `created_by` bigint(20) DEFAULT NULL,
  `created_date` varchar(255) DEFAULT NULL,
  `modified_by` bigint(20) DEFAULT NULL,
  `modified_date` varchar(255) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `experience_name` varchar(255) DEFAULT NULL,
  `language_id` bigint(20) DEFAULT NULL,
  `parent_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `master_special_experience`
--

INSERT INTO `master_special_experience` (`experience_id`, `created_by`, `created_date`, `modified_by`, `modified_date`, `status`, `experience_name`, `language_id`, `parent_id`) VALUES
(1, 1, '2018-09-06 01:27:34', NULL, NULL, 1, 'Musical Instrument', 1, 0),
(2, 1, '2018-09-06 01:27:34', 1, NULL, 1, 'Yoga Centre', 1, 0),
(3, 1, '2018-09-06 01:27:34', 1, NULL, 1, 'Spa', 1, 0);

-- --------------------------------------------------------

--
-- Table structure for table `master_stay_type`
--

CREATE TABLE `master_stay_type` (
  `stay_type_id` bigint(20) NOT NULL,
  `created_by` bigint(20) DEFAULT NULL,
  `created_date` varchar(255) DEFAULT NULL,
  `modified_by` bigint(20) DEFAULT NULL,
  `modified_date` varchar(255) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `language_id` bigint(20) DEFAULT NULL,
  `parent_id` bigint(20) DEFAULT NULL,
  `stay_type_name` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `master_stay_type`
--

INSERT INTO `master_stay_type` (`stay_type_id`, `created_by`, `created_date`, `modified_by`, `modified_date`, `status`, `language_id`, `parent_id`, `stay_type_name`) VALUES
(1, 1, '2018-09-06 01:27:34', NULL, NULL, 1, 1, 0, 'Long Term'),
(2, 1, '2018-09-06 01:27:34', NULL, NULL, 1, 1, 0, 'Short Term'),
(3, 1, '2018-09-06 01:27:34', NULL, NULL, 1, 1, 0, 'Both');

-- --------------------------------------------------------

--
-- Table structure for table `master_wishlist`
--

CREATE TABLE `master_wishlist` (
  `wishlist_id` bigint(20) NOT NULL,
  `created_by` bigint(20) DEFAULT NULL,
  `created_date` varchar(255) DEFAULT NULL,
  `modified_by` bigint(20) DEFAULT NULL,
  `modified_date` varchar(255) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  `property_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `master_wishlist`
--

INSERT INTO `master_wishlist` (`wishlist_id`, `created_by`, `created_date`, `modified_by`, `modified_date`, `status`, `user_id`, `property_id`) VALUES
(1, 1, '2018-09-06 01:27:34', NULL, NULL, 1, 1, 2),
(2, 1, '2018-09-06 01:27:34', NULL, NULL, 1, 1, 15);

-- --------------------------------------------------------

--
-- Table structure for table `meal_plan_cat_vs_meal_plan`
--

CREATE TABLE `meal_plan_cat_vs_meal_plan` (
  `mpcmp_id` bigint(20) NOT NULL,
  `created_by` bigint(20) DEFAULT NULL,
  `created_date` varchar(255) DEFAULT NULL,
  `modified_by` bigint(20) DEFAULT NULL,
  `modified_date` varchar(255) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `mpc_id` bigint(20) NOT NULL,
  `meal_plan_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `meal_plan_cat_vs_meal_plan`
--

INSERT INTO `meal_plan_cat_vs_meal_plan` (`mpcmp_id`, `created_by`, `created_date`, `modified_by`, `modified_date`, `status`, `mpc_id`, `meal_plan_id`) VALUES
(1, 1, '2018-09-06 01:27:34', NULL, NULL, 1, 1, 1),
(2, 1, '2018-09-06 01:27:34', NULL, NULL, 1, 2, 1);

-- --------------------------------------------------------

--
-- Table structure for table `property_vs_description`
--

CREATE TABLE `property_vs_description` (
  `property_desc_id` bigint(20) NOT NULL,
  `created_by` bigint(20) DEFAULT NULL,
  `created_date` varchar(255) DEFAULT NULL,
  `modified_by` bigint(20) DEFAULT NULL,
  `modified_date` varchar(255) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `description` text,
  `language_id` bigint(20) DEFAULT NULL,
  `property_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `property_vs_description`
--

INSERT INTO `property_vs_description` (`property_desc_id`, `created_by`, `created_date`, `modified_by`, `modified_date`, `status`, `description`, `language_id`, `property_id`) VALUES
(1, 0, '2018-12-18 14:54:25', NULL, NULL, 1, 'Where does it come from', 1, 1),
(2, 0, '2018-12-18 15:01:11', NULL, NULL, 1, 'Where does it come from', 1, 2),
(3, 0, '2018-12-18 15:02:05', NULL, NULL, 1, 'Where does it come from', 1, 3),
(4, 0, '2018-12-18 15:19:01', NULL, NULL, 1, 'Where does it come from', 1, 4),
(5, 0, '2018-12-18 16:05:15', NULL, NULL, 1, 'Where does it come from', 1, 5),
(6, 0, '2018-12-18 16:09:47', NULL, NULL, 1, 'Where does it come from', 1, 6),
(7, 0, '2018-12-18 16:10:02', NULL, NULL, 1, 'Where does it come from', 1, 7),
(8, 0, '2018-12-18 16:15:08', NULL, NULL, 1, 'Where does it come from', 1, 8),
(9, 0, '2018-12-18 16:24:18', NULL, NULL, 1, 'Where does it come from', 1, 9),
(10, 0, '2018-12-18 16:25:18', NULL, NULL, 1, 'Where does it come from', 1, 10),
(11, 0, '2018-12-18 16:36:56', NULL, NULL, 1, 'Where does it come from', 1, 11),
(12, 0, '2018-12-18 16:39:05', NULL, NULL, 1, 'Where does it come from', 1, 12),
(13, 0, '2018-12-18 16:43:25', NULL, NULL, 1, 'Where does it come from', 1, 13),
(14, 0, '2018-12-18 17:01:24', NULL, NULL, 1, 'Where does it come from', 1, 14),
(15, 0, '2018-12-18 17:13:04', NULL, NULL, 1, 'Where does it come from', 1, 15),
(16, 0, '2018-12-18 18:10:07', NULL, NULL, 1, 'Where does it come from', 1, 16),
(17, 0, '2018-12-18 16:10:02', NULL, NULL, 1, 'Where does it come from', 1, 17),
(18, 0, '2018-12-18 16:15:08', NULL, NULL, 1, 'Where does it come from', 1, 18),
(19, 0, '2018-12-18 16:24:18', NULL, NULL, 1, 'Where does it come from', 1, 19),
(20, 0, '2018-12-18 16:25:18', NULL, NULL, 1, 'Where does it come from', 1, 20),
(21, 0, '2018-12-18 16:36:56', NULL, NULL, 1, 'Where does it come from', 1, 21),
(22, 0, '2018-12-18 16:39:05', NULL, NULL, 1, 'Where does it come from', 1, 22),
(23, 0, '2018-12-18 16:43:25', NULL, NULL, 1, 'Where does it come from', 1, 23),
(24, 0, '2018-12-18 17:01:24', NULL, NULL, 1, 'Where does it come from', 1, 24),
(25, 0, '2018-12-18 17:13:04', NULL, NULL, 1, 'Where does it come from', 1, 25),
(26, 0, '2018-12-18 18:10:07', NULL, NULL, 1, 'Where does it come from', 1, 26);

-- --------------------------------------------------------

--
-- Table structure for table `property_vs_document`
--

CREATE TABLE `property_vs_document` (
  `property_vs_document_id` bigint(20) NOT NULL,
  `created_by` bigint(20) DEFAULT NULL,
  `created_date` varchar(255) DEFAULT NULL,
  `modified_by` bigint(20) DEFAULT NULL,
  `modified_date` varchar(255) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `document_number` varchar(255) DEFAULT NULL,
  `file_url` varchar(255) DEFAULT NULL,
  `document_id` bigint(20) NOT NULL,
  `property_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `property_vs_document`
--

INSERT INTO `property_vs_document` (`property_vs_document_id`, `created_by`, `created_date`, `modified_by`, `modified_date`, `status`, `document_number`, `file_url`, `document_id`, `property_id`) VALUES
(1, 1, '2018-12-18 14:54:25', NULL, NULL, 1, '', 'https://s-ec.bstatic.com/images/hotel/max1024x768/141/141830278.jpg', 2, 1),
(2, 1, '2018-12-18 15:01:11', NULL, NULL, 1, 'AKBHP6784S', 'https://s-ec.bstatic.com/images/hotel/max1024x768/141/141830278.jpg', 1, 2),
(3, 1, '2018-12-18 14:54:25', NULL, NULL, 1, 'AKBHP6784S', 'https://s-ec.bstatic.com/images/hotel/max1024x768/141/141830278.jpg', 1, 1),
(4, 1, '2018-12-18 15:01:11', NULL, NULL, 1, '', 'https://s-ec.bstatic.com/images/hotel/max1024x768/141/141830278.jpg', 2, 2),
(5, 1, '2018-12-18 15:02:05', NULL, NULL, 1, 'AKBHP6784S', 'https://s-ec.bstatic.com/images/hotel/max1024x768/141/141830278.jpg', 1, 3),
(6, 1, '2018-12-18 15:02:05', NULL, NULL, 1, '', 'https://s-ec.bstatic.com/images/hotel/max1024x768/141/141830278.jpg', 2, 3),
(7, 1, '2018-12-18 15:19:01', NULL, NULL, 1, 'AKBHP6784S', 'https://s-ec.bstatic.com/images/hotel/max1024x768/141/141830278.jpg', 1, 4),
(8, 1, '2018-12-18 15:19:01', NULL, NULL, 1, '', 'https://s-ec.bstatic.com/images/hotel/max1024x768/141/141830278.jpg', 2, 4),
(9, 1, '2018-12-18 16:05:15', NULL, NULL, 1, 'AKBHP6784S', 'https://s-ec.bstatic.com/images/hotel/max1024x768/141/141830278.jpg', 1, 5),
(10, 1, '2018-12-18 16:05:15', NULL, NULL, 1, '', 'https://s-ec.bstatic.com/images/hotel/max1024x768/141/141830278.jpg', 2, 5),
(11, 1, '2018-12-18 16:09:47', NULL, NULL, 1, 'AKBHP6784S', 'https://s-ec.bstatic.com/images/hotel/max1024x768/141/141830278.jpg', 1, 6),
(12, 1, '2018-12-18 16:09:47', NULL, NULL, 1, '', 'https://s-ec.bstatic.com/images/hotel/max1024x768/141/141830278.jpg', 2, 6),
(13, 1, '2018-12-18 16:10:02', NULL, NULL, 1, 'AKBHP6784S', 'https://s-ec.bstatic.com/images/hotel/max1024x768/141/141830278.jpg', 1, 7),
(14, 1, '2018-12-18 16:10:02', NULL, NULL, 1, '', 'https://s-ec.bstatic.com/images/hotel/max1024x768/141/141830278.jpg', 2, 7),
(15, 1, '2018-12-18 16:15:08', NULL, NULL, 1, 'AKBHP6784S', 'https://s-ec.bstatic.com/images/hotel/max1024x768/141/141830278.jpg', 1, 8),
(16, 1, '2018-12-18 16:15:08', NULL, NULL, 1, '', 'https://s-ec.bstatic.com/images/hotel/max1024x768/141/141830278.jpg', 2, 8),
(17, 1, '2018-12-18 16:24:18', NULL, NULL, 1, 'AKBHP6784S', 'https://s-ec.bstatic.com/images/hotel/max1024x768/141/141830278.jpg', 1, 9),
(18, 1, '2018-12-18 16:24:18', NULL, NULL, 1, '', 'https://s-ec.bstatic.com/images/hotel/max1024x768/141/141830278.jpg', 2, 9),
(19, 1, '2018-12-18 16:25:18', NULL, NULL, 1, 'AKBHP6784S', 'https://s-ec.bstatic.com/images/hotel/max1024x768/141/141830278.jpg', 1, 10),
(20, 1, '2018-12-18 16:25:18', NULL, NULL, 1, '', 'https://s-ec.bstatic.com/images/hotel/max1024x768/141/141830278.jpg', 2, 10),
(21, 1, '2018-12-18 16:36:56', NULL, NULL, 1, 'AKBHP6784S', 'https://s-ec.bstatic.com/images/hotel/max1024x768/141/141830278.jpg', 1, 11),
(22, 1, '2018-12-18 16:36:56', NULL, NULL, 1, '', 'https://s-ec.bstatic.com/images/hotel/max1024x768/141/141830278.jpg', 2, 11),
(23, 1, '2018-12-18 16:39:05', NULL, NULL, 1, 'AKBHP6784S', 'https://s-ec.bstatic.com/images/hotel/max1024x768/141/141830278.jpg', 1, 12),
(24, 1, '2018-12-18 16:39:05', NULL, NULL, 1, '', 'https://s-ec.bstatic.com/images/hotel/max1024x768/141/141830278.jpg', 2, 12),
(25, 1, '2018-12-18 16:43:25', NULL, NULL, 1, 'AKBHP6784S', 'https://s-ec.bstatic.com/images/hotel/max1024x768/141/141830278.jpg', 1, 13),
(26, 1, '2018-12-18 16:43:25', NULL, NULL, 1, '', 'https://s-ec.bstatic.com/images/hotel/max1024x768/141/141830278.jpg', 2, 13),
(27, 1, '2018-12-18 17:01:24', NULL, NULL, 1, 'AKBHP6784S', 'https://s-ec.bstatic.com/images/hotel/max1024x768/141/141830278.jpg', 1, 14),
(28, 1, '2018-12-18 17:01:24', NULL, NULL, 1, '', 'https://s-ec.bstatic.com/images/hotel/max1024x768/141/141830278.jpg', 2, 14),
(29, 1, '2018-12-18 17:13:04', NULL, NULL, 1, 'AKBHP6784S', 'https://s-ec.bstatic.com/images/hotel/max1024x768/141/141830278.jpg', 1, 15),
(30, 1, '2018-12-18 17:13:04', NULL, NULL, 1, '', 'https://s-ec.bstatic.com/images/hotel/max1024x768/141/141830278.jpg', 2, 15),
(31, 1, '2018-12-18 18:10:07', NULL, NULL, 1, 'AKBHP6784S', 'https://s-ec.bstatic.com/images/hotel/max1024x768/141/141830278.jpg', 1, 16),
(32, 1, '2018-12-18 18:10:07', NULL, NULL, 1, '', 'https://s-ec.bstatic.com/images/hotel/max1024x768/141/141830278.jpg', 2, 16),
(33, 1, '2018-12-18 16:10:02', NULL, NULL, 1, 'AKBHP6784S', 'https://s-ec.bstatic.com/images/hotel/max1024x768/141/141830278.jpg', 1, 17),
(34, 1, '2018-12-18 16:10:02', NULL, NULL, 1, '', 'https://s-ec.bstatic.com/images/hotel/max1024x768/141/141830278.jpg', 2, 17),
(35, 1, '2018-12-18 16:15:08', NULL, NULL, 1, 'AKBHP6784S', 'https://s-ec.bstatic.com/images/hotel/max1024x768/141/141830278.jpg', 1, 18),
(36, 1, '2018-12-18 16:15:08', NULL, NULL, 1, '', 'https://s-ec.bstatic.com/images/hotel/max1024x768/141/141830278.jpg', 2, 18),
(37, 1, '2018-12-18 16:24:18', NULL, NULL, 1, 'AKBHP6784S', 'https://s-ec.bstatic.com/images/hotel/max1024x768/141/141830278.jpg', 1, 19),
(38, 1, '2018-12-18 16:24:18', NULL, NULL, 1, '', 'https://s-ec.bstatic.com/images/hotel/max1024x768/141/141830278.jpg', 2, 19),
(39, 1, '2018-12-18 16:25:18', NULL, NULL, 1, 'AKBHP6784S', 'https://s-ec.bstatic.com/images/hotel/max1024x768/141/141830278.jpg', 1, 20),
(40, 1, '2018-12-18 16:25:18', NULL, NULL, 1, '', 'https://s-ec.bstatic.com/images/hotel/max1024x768/141/141830278.jpg', 2, 20),
(41, 1, '2018-12-18 16:36:56', NULL, NULL, 1, 'AKBHP6784S', 'https://s-ec.bstatic.com/images/hotel/max1024x768/141/141830278.jpg', 1, 21),
(42, 1, '2018-12-18 16:36:56', NULL, NULL, 1, '', 'https://s-ec.bstatic.com/images/hotel/max1024x768/141/141830278.jpg', 2, 21),
(43, 1, '2018-12-18 16:39:05', NULL, NULL, 1, 'AKBHP6784S', 'https://s-ec.bstatic.com/images/hotel/max1024x768/141/141830278.jpg', 1, 22),
(44, 1, '2018-12-18 16:39:05', NULL, NULL, 1, '', 'https://s-ec.bstatic.com/images/hotel/max1024x768/141/141830278.jpg', 2, 22),
(45, 1, '2018-12-18 16:43:25', NULL, NULL, 1, 'AKBHP6784S', 'https://s-ec.bstatic.com/images/hotel/max1024x768/141/141830278.jpg', 1, 23),
(46, 1, '2018-12-18 16:43:25', NULL, NULL, 1, '', 'https://s-ec.bstatic.com/images/hotel/max1024x768/141/141830278.jpg', 2, 23),
(47, 1, '2018-12-18 17:01:24', NULL, NULL, 1, 'AKBHP6784S', 'https://s-ec.bstatic.com/images/hotel/max1024x768/141/141830278.jpg', 1, 24),
(48, 1, '2018-12-18 17:01:24', NULL, NULL, 1, '', 'https://s-ec.bstatic.com/images/hotel/max1024x768/141/141830278.jpg', 2, 24),
(49, 1, '2018-12-18 17:13:04', NULL, NULL, 1, 'AKBHP6784S', 'https://s-ec.bstatic.com/images/hotel/max1024x768/141/141830278.jpg', 1, 25),
(50, 1, '2018-12-18 17:13:04', NULL, NULL, 1, '', 'https://s-ec.bstatic.com/images/hotel/max1024x768/141/141830278.jpg', 2, 25),
(51, 1, '2018-12-18 18:10:07', NULL, NULL, 1, 'AKBHP6784S', 'https://s-ec.bstatic.com/images/hotel/max1024x768/141/141830278.jpg', 1, 26),
(52, 1, '2018-12-18 18:10:07', NULL, NULL, 1, '', 'https://s-ec.bstatic.com/images/hotel/max1024x768/141/141830278.jpg', 2, 26);

-- --------------------------------------------------------

--
-- Table structure for table `property_vs_experience`
--

CREATE TABLE `property_vs_experience` (
  `property_exp_id` bigint(20) NOT NULL,
  `created_by` bigint(20) DEFAULT NULL,
  `created_date` varchar(255) DEFAULT NULL,
  `modified_by` bigint(20) DEFAULT NULL,
  `modified_date` varchar(255) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `property_id` bigint(20) NOT NULL,
  `experience_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `property_vs_experience`
--

INSERT INTO `property_vs_experience` (`property_exp_id`, `created_by`, `created_date`, `modified_by`, `modified_date`, `status`, `property_id`, `experience_id`) VALUES
(1, 1, '2018-12-18 14:54:25', NULL, NULL, 1, 1, 1),
(2, 1, '2018-12-18 14:54:25', NULL, NULL, 1, 1, 3),
(3, 1, '2018-12-18 15:01:11', NULL, NULL, 1, 2, 1),
(4, 1, '2018-12-18 15:01:11', NULL, NULL, 1, 2, 3),
(5, 1, '2018-12-18 15:02:05', NULL, NULL, 1, 3, 1),
(6, 1, '2018-12-18 15:02:05', NULL, NULL, 1, 3, 3),
(7, 1, '2018-12-18 15:19:01', NULL, NULL, 1, 4, 1),
(8, 1, '2018-12-18 15:19:01', NULL, NULL, 1, 4, 3),
(9, 1, '2018-12-18 16:05:15', NULL, NULL, 1, 5, 1),
(10, 1, '2018-12-18 16:05:15', NULL, NULL, 1, 5, 3),
(11, 1, '2018-12-18 16:09:48', NULL, NULL, 1, 6, 1),
(12, 1, '2018-12-18 16:09:48', NULL, NULL, 1, 6, 3),
(13, 1, '2018-12-18 16:10:02', NULL, NULL, 1, 7, 1),
(14, 1, '2018-12-18 16:10:02', NULL, NULL, 1, 7, 3),
(15, 1, '2018-12-18 16:15:08', NULL, NULL, 1, 8, 1),
(16, 1, '2018-12-18 16:15:08', NULL, NULL, 1, 8, 3),
(17, 1, '2018-12-18 16:24:18', NULL, NULL, 1, 9, 1),
(18, 1, '2018-12-18 16:24:18', NULL, NULL, 1, 9, 3),
(19, 1, '2018-12-18 16:25:18', NULL, NULL, 1, 10, 1),
(20, 1, '2018-12-18 16:25:19', NULL, NULL, 1, 10, 3),
(21, 1, '2018-12-18 16:36:56', NULL, NULL, 1, 11, 1),
(22, 1, '2018-12-18 16:36:56', NULL, NULL, 1, 11, 3),
(23, 1, '2018-12-18 16:39:05', NULL, NULL, 1, 12, 1),
(24, 1, '2018-12-18 16:39:05', NULL, NULL, 1, 12, 3),
(25, 1, '2018-12-18 16:43:25', NULL, NULL, 1, 13, 1),
(26, 1, '2018-12-18 16:43:25', NULL, NULL, 1, 13, 3),
(27, 1, '2018-12-18 17:01:24', NULL, NULL, 1, 14, 1),
(28, 1, '2018-12-18 17:01:24', NULL, NULL, 1, 14, 3),
(29, 1, '2018-12-18 17:13:04', NULL, NULL, 1, 15, 1),
(30, 1, '2018-12-18 17:13:04', NULL, NULL, 1, 15, 3),
(31, 1, '2018-12-18 18:10:07', NULL, NULL, 1, 16, 1),
(32, 1, '2018-12-18 18:10:07', NULL, NULL, 1, 16, 3),
(33, 1, '2018-12-18 16:10:02', NULL, NULL, 1, 17, 1),
(34, 1, '2018-12-18 16:10:02', NULL, NULL, 1, 17, 3),
(35, 1, '2018-12-18 16:15:08', NULL, NULL, 1, 18, 1),
(36, 1, '2018-12-18 16:15:08', NULL, NULL, 1, 18, 3),
(37, 1, '2018-12-18 16:24:18', NULL, NULL, 1, 19, 1),
(38, 1, '2018-12-18 16:24:18', NULL, NULL, 1, 19, 3),
(39, 1, '2018-12-18 16:25:18', NULL, NULL, 1, 20, 1),
(40, 1, '2018-12-18 16:25:19', NULL, NULL, 1, 20, 3),
(41, 1, '2018-12-18 16:36:56', NULL, NULL, 1, 21, 1),
(42, 1, '2018-12-18 16:36:56', NULL, NULL, 1, 21, 3),
(43, 1, '2018-12-18 16:39:05', NULL, NULL, 1, 22, 1),
(44, 1, '2018-12-18 16:39:05', NULL, NULL, 1, 22, 3),
(45, 1, '2018-12-18 16:43:25', NULL, NULL, 1, 23, 1),
(46, 1, '2018-12-18 16:43:25', NULL, NULL, 1, 23, 3),
(47, 1, '2018-12-18 17:01:24', NULL, NULL, 1, 24, 1),
(48, 1, '2018-12-18 17:01:24', NULL, NULL, 1, 24, 3),
(49, 1, '2018-12-18 17:13:04', NULL, NULL, 1, 25, 1),
(50, 1, '2018-12-18 17:13:04', NULL, NULL, 1, 25, 3),
(51, 1, '2018-12-18 18:10:07', NULL, NULL, 1, 26, 1),
(52, 1, '2018-12-18 18:10:07', NULL, NULL, 1, 16, 3);

-- --------------------------------------------------------

--
-- Table structure for table `property_vs_guest_access`
--

CREATE TABLE `property_vs_guest_access` (
  `property_gaccess_id` bigint(20) NOT NULL,
  `created_by` bigint(20) DEFAULT NULL,
  `created_date` varchar(255) DEFAULT NULL,
  `modified_by` bigint(20) DEFAULT NULL,
  `modified_date` varchar(255) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `guest_access` varchar(255) DEFAULT NULL,
  `language_id` bigint(20) DEFAULT NULL,
  `property_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `property_vs_guest_access`
--

INSERT INTO `property_vs_guest_access` (`property_gaccess_id`, `created_by`, `created_date`, `modified_by`, `modified_date`, `status`, `guest_access`, `language_id`, `property_id`) VALUES
(1, 1, '2018-12-18 14:54:25', NULL, NULL, 1, 'Guest Can Access Terrace', 1, 1),
(2, 1, '2018-12-18 15:01:11', NULL, NULL, 1, 'Guest Can Access Terrace', 1, 2),
(3, 1, '2018-12-18 15:02:05', NULL, NULL, 1, 'Guest Can Access Terrace', 1, 3),
(4, 1, '2018-12-18 15:19:01', NULL, NULL, 1, 'Guest Can Access Terrace', 1, 4),
(5, 1, '2018-12-18 16:05:15', NULL, NULL, 1, 'Guest Can Access Terrace', 1, 5),
(6, 1, '2018-12-18 16:09:48', NULL, NULL, 1, 'Guest Can Access Terrace', 1, 6),
(7, 1, '2018-12-18 16:10:02', NULL, NULL, 1, 'Guest Can Access Terrace', 1, 7),
(8, 1, '2018-12-18 16:15:08', NULL, NULL, 1, 'Guest Can Access Terrace', 1, 8),
(9, 1, '2018-12-18 16:24:18', NULL, NULL, 1, 'Guest Can Access Terrace', 1, 9),
(10, 1, '2018-12-18 16:25:19', NULL, NULL, 1, 'Guest Can Access Terrace', 1, 10),
(11, 1, '2018-12-18 16:36:56', NULL, NULL, 1, 'Guest Can Access Terrace', 1, 11),
(12, 1, '2018-12-18 16:39:05', NULL, NULL, 1, 'Guest Can Access Terrace', 1, 12),
(13, 1, '2018-12-18 16:43:25', NULL, NULL, 1, 'Guest Can Access Terrace', 1, 13),
(14, 1, '2018-12-18 17:01:24', NULL, NULL, 1, 'Guest Can Access Terrace', 1, 14),
(15, 1, '2018-12-18 17:13:04', NULL, NULL, 1, 'Guest Can Access Terrace', 1, 15),
(16, 1, '2018-12-18 18:10:07', NULL, NULL, 1, 'Guest Can Access Terrace', 1, 16),
(17, 1, '2018-12-18 16:10:02', NULL, NULL, 1, 'Guest Can Access Terrace', 1, 17),
(18, 1, '2018-12-18 16:15:08', NULL, NULL, 1, 'Guest Can Access Terrace', 1, 18),
(19, 1, '2018-12-18 16:24:18', NULL, NULL, 1, 'Guest Can Access Terrace', 1, 19),
(20, 1, '2018-12-18 16:25:19', NULL, NULL, 1, 'Guest Can Access Terrace', 1, 20),
(21, 1, '2018-12-18 16:36:56', NULL, NULL, 1, 'Guest Can Access Terrace', 1, 21),
(22, 1, '2018-12-18 16:39:05', NULL, NULL, 1, 'Guest Can Access Terrace', 1, 22),
(23, 1, '2018-12-18 16:43:25', NULL, NULL, 1, 'Guest Can Access Terrace', 1, 23),
(24, 1, '2018-12-18 17:01:24', NULL, NULL, 1, 'Guest Can Access Terrace', 1, 24),
(25, 1, '2018-12-18 17:13:04', NULL, NULL, 1, 'Guest Can Access Terrace', 1, 25),
(26, 1, '2018-12-18 18:10:07', NULL, NULL, 1, 'Guest Can Access Terrace', 1, 26);

-- --------------------------------------------------------

--
-- Table structure for table `property_vs_image`
--

CREATE TABLE `property_vs_image` (
  `property_image_id` bigint(20) NOT NULL,
  `created_by` bigint(20) DEFAULT NULL,
  `created_date` varchar(255) DEFAULT NULL,
  `modified_by` bigint(20) DEFAULT NULL,
  `modified_date` varchar(255) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `image_url` varchar(255) DEFAULT NULL,
  `property_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `property_vs_image`
--

INSERT INTO `property_vs_image` (`property_image_id`, `created_by`, `created_date`, `modified_by`, `modified_date`, `status`, `image_url`, `property_id`) VALUES
(1, 1, '2018-12-18 14:54:25', NULL, NULL, 1, 'https://s-ec.bstatic.com/images/hotel/max1024x768/141/141830278.jpg', 1),
(2, 1, '2018-12-18 14:54:25', NULL, NULL, 1, 'https://s-ec.bstatic.com/images/hotel/max1024x768/141/141830278.jpg', 1),
(3, 1, '2018-12-18 14:54:25', NULL, NULL, 1, 'https://s-ec.bstatic.com/images/hotel/max1024x768/141/141830278.jpg', 1),
(4, 1, '2018-12-18 15:01:11', NULL, NULL, 1, 'https://s-ec.bstatic.com/images/hotel/max1024x768/141/141830278.jpg', 2),
(5, 1, '2018-12-18 15:01:12', NULL, NULL, 1, 'https://s-ec.bstatic.com/images/hotel/max1024x768/141/141830278.jpg', 2),
(6, 1, '2018-12-18 15:01:12', NULL, NULL, 1, 'https://s-ec.bstatic.com/images/hotel/max1024x768/141/141830278.jpg', 2),
(7, 1, '2018-12-18 15:02:05', NULL, NULL, 1, 'https://s-ec.bstatic.com/images/hotel/max1024x768/141/141830278.jpg', 3),
(8, 1, '2018-12-18 15:02:05', NULL, NULL, 1, 'https://s-ec.bstatic.com/images/hotel/max1024x768/141/141830278.jpg', 3),
(9, 1, '2018-12-18 15:02:05', NULL, NULL, 1, 'https://s-ec.bstatic.com/images/hotel/max1024x768/141/141830278.jpg', 3),
(10, 1, '2018-12-18 15:19:01', NULL, NULL, 1, 'https://s-ec.bstatic.com/images/hotel/max1024x768/141/141830278.jpg', 4),
(11, 1, '2018-12-18 15:19:01', NULL, NULL, 1, 'https://s-ec.bstatic.com/images/hotel/max1024x768/141/141830278.jpg', 4),
(12, 1, '2018-12-18 15:19:01', NULL, NULL, 1, 'https://s-ec.bstatic.com/images/hotel/max1024x768/141/141830278.jpg', 4),
(13, 1, '2018-12-18 16:05:15', NULL, NULL, 1, 'https://s-ec.bstatic.com/images/hotel/max1024x768/141/141830278.jpg', 5),
(14, 1, '2018-12-18 16:05:15', NULL, NULL, 1, 'https://s-ec.bstatic.com/images/hotel/max1024x768/141/141830278.jpg', 5),
(15, 1, '2018-12-18 16:05:15', NULL, NULL, 1, 'https://s-ec.bstatic.com/images/hotel/max1024x768/141/141830278.jpg', 5),
(16, 1, '2018-12-18 16:09:48', NULL, NULL, 1, 'https://s-ec.bstatic.com/images/hotel/max1024x768/141/141830278.jpg', 6),
(17, 1, '2018-12-18 16:09:48', NULL, NULL, 1, 'https://s-ec.bstatic.com/images/hotel/max1024x768/141/141830278.jpg', 6),
(18, 1, '2018-12-18 16:09:48', NULL, NULL, 1, 'https://s-ec.bstatic.com/images/hotel/max1024x768/141/141830278.jpg', 6),
(19, 1, '2018-12-18 16:10:02', NULL, NULL, 1, 'https://s-ec.bstatic.com/images/hotel/max1024x768/141/141830278.jpg', 7),
(20, 1, '2018-12-18 16:10:02', NULL, NULL, 1, 'https://s-ec.bstatic.com/images/hotel/max1024x768/141/141830278.jpg', 7),
(21, 1, '2018-12-18 16:10:02', NULL, NULL, 1, 'https://s-ec.bstatic.com/images/hotel/max1024x768/141/141830278.jpg', 7),
(22, 1, '2018-12-18 16:15:08', NULL, NULL, 1, 'https://s-ec.bstatic.com/images/hotel/max1024x768/141/141830278.jpg', 8),
(23, 1, '2018-12-18 16:15:08', NULL, NULL, 1, 'https://s-ec.bstatic.com/images/hotel/max1024x768/141/141830278.jpg', 8),
(24, 1, '2018-12-18 16:15:08', NULL, NULL, 1, 'https://s-ec.bstatic.com/images/hotel/max1024x768/141/141830278.jpg', 8),
(25, 1, '2018-12-18 16:24:18', NULL, NULL, 1, 'https://s-ec.bstatic.com/images/hotel/max1024x768/141/141830278.jpg', 9),
(26, 1, '2018-12-18 16:24:18', NULL, NULL, 1, 'https://s-ec.bstatic.com/images/hotel/max1024x768/141/141830278.jpg', 9),
(27, 1, '2018-12-18 16:24:18', NULL, NULL, 1, 'https://s-ec.bstatic.com/images/hotel/max1024x768/141/141830278.jpg', 9),
(28, 1, '2018-12-18 16:25:19', NULL, NULL, 1, 'https://s-ec.bstatic.com/images/hotel/max1024x768/141/141830278.jpg', 10),
(29, 1, '2018-12-18 16:25:19', NULL, NULL, 1, 'https://s-ec.bstatic.com/images/hotel/max1024x768/141/141830278.jpg', 10),
(30, 1, '2018-12-18 16:25:19', NULL, NULL, 1, 'https://s-ec.bstatic.com/images/hotel/max1024x768/141/141830278.jpg', 10),
(31, 1, '2018-12-18 16:36:56', NULL, NULL, 1, 'https://s-ec.bstatic.com/images/hotel/max1024x768/141/141830278.jpg', 11),
(32, 1, '2018-12-18 16:36:56', NULL, NULL, 1, 'https://s-ec.bstatic.com/images/hotel/max1024x768/141/141830278.jpg', 11),
(33, 1, '2018-12-18 16:36:56', NULL, NULL, 1, 'https://s-ec.bstatic.com/images/hotel/max1024x768/141/141830278.jpg', 11),
(34, 1, '2018-12-18 16:39:05', NULL, NULL, 1, 'https://s-ec.bstatic.com/images/hotel/max1024x768/141/141830278.jpg', 12),
(35, 1, '2018-12-18 16:39:05', NULL, NULL, 1, 'https://s-ec.bstatic.com/images/hotel/max1024x768/141/141830278.jpg', 12),
(36, 1, '2018-12-18 16:39:05', NULL, NULL, 1, 'https://s-ec.bstatic.com/images/hotel/max1024x768/141/141830278.jpg', 12),
(37, 1, '2018-12-18 16:43:25', NULL, NULL, 1, 'https://s-ec.bstatic.com/images/hotel/max1024x768/141/141830278.jpg', 13),
(38, 1, '2018-12-18 16:43:25', NULL, NULL, 1, 'https://s-ec.bstatic.com/images/hotel/max1024x768/141/141830278.jpg', 13),
(39, 1, '2018-12-18 16:43:25', NULL, NULL, 1, 'https://s-ec.bstatic.com/images/hotel/max1024x768/141/141830278.jpg', 13),
(40, 1, '2018-12-18 17:01:24', NULL, NULL, 1, 'https://s-ec.bstatic.com/images/hotel/max1024x768/141/141830278.jpg', 14),
(41, 1, '2018-12-18 17:01:24', NULL, NULL, 1, 'https://s-ec.bstatic.com/images/hotel/max1024x768/141/141830278.jpg', 14),
(42, 1, '2018-12-18 17:01:24', NULL, NULL, 1, 'https://s-ec.bstatic.com/images/hotel/max1024x768/141/141830278.jpg', 14),
(43, 1, '2018-12-18 17:13:04', NULL, NULL, 1, 'https://s-ec.bstatic.com/images/hotel/max1024x768/141/141830278.jpg', 15),
(44, 1, '2018-12-18 17:13:04', NULL, NULL, 1, 'https://s-ec.bstatic.com/images/hotel/max1024x768/141/141830278.jpg', 15),
(45, 1, '2018-12-18 17:13:04', NULL, NULL, 1, 'https://s-ec.bstatic.com/images/hotel/max1024x768/141/141830278.jpg', 15),
(46, 1, '2018-12-18 18:10:07', NULL, NULL, 1, 'https://s-ec.bstatic.com/images/hotel/max1024x768/141/141830278.jpg', 16),
(47, 1, '2018-12-18 18:10:07', NULL, NULL, 1, 'https://s-ec.bstatic.com/images/hotel/max1024x768/141/141830278.jpg', 16),
(48, 1, '2018-12-18 18:10:07', NULL, NULL, 1, 'https://s-ec.bstatic.com/images/hotel/max1024x768/141/141830278.jpg', 16),
(49, 1, '2018-12-18 16:10:02', NULL, NULL, 1, 'https://s-ec.bstatic.com/images/hotel/max1024x768/141/141830278.jpg', 17),
(50, 1, '2018-12-18 16:10:02', NULL, NULL, 1, 'https://s-ec.bstatic.com/images/hotel/max1024x768/141/141830278.jpg', 17),
(51, 1, '2018-12-18 16:10:02', NULL, NULL, 1, 'https://s-ec.bstatic.com/images/hotel/max1024x768/141/141830278.jpg', 17),
(52, 1, '2018-12-18 16:15:08', NULL, NULL, 1, 'https://s-ec.bstatic.com/images/hotel/max1024x768/141/141830278.jpg', 18),
(53, 1, '2018-12-18 16:15:08', NULL, NULL, 1, 'https://s-ec.bstatic.com/images/hotel/max1024x768/141/141830278.jpg', 18),
(54, 1, '2018-12-18 16:15:08', NULL, NULL, 1, 'https://s-ec.bstatic.com/images/hotel/max1024x768/141/141830278.jpg', 18),
(55, 1, '2018-12-18 16:24:18', NULL, NULL, 1, 'https://s-ec.bstatic.com/images/hotel/max1024x768/141/141830278.jpg', 19),
(56, 1, '2018-12-18 16:24:18', NULL, NULL, 1, 'https://s-ec.bstatic.com/images/hotel/max1024x768/141/141830278.jpg', 19),
(57, 1, '2018-12-18 16:24:18', NULL, NULL, 1, 'https://s-ec.bstatic.com/images/hotel/max1024x768/141/141830278.jpg', 19),
(58, 1, '2018-12-18 16:25:19', NULL, NULL, 1, 'https://s-ec.bstatic.com/images/hotel/max1024x768/141/141830278.jpg', 20),
(59, 1, '2018-12-18 16:25:19', NULL, NULL, 1, 'https://s-ec.bstatic.com/images/hotel/max1024x768/141/141830278.jpg', 20),
(60, 1, '2018-12-18 16:25:19', NULL, NULL, 1, 'https://s-ec.bstatic.com/images/hotel/max1024x768/141/141830278.jpg', 20),
(61, 1, '2018-12-18 16:36:56', NULL, NULL, 1, 'https://s-ec.bstatic.com/images/hotel/max1024x768/141/141830278.jpg', 21),
(62, 1, '2018-12-18 16:36:56', NULL, NULL, 1, 'https://s-ec.bstatic.com/images/hotel/max1024x768/141/141830278.jpg', 21),
(63, 1, '2018-12-18 16:36:56', NULL, NULL, 1, 'https://s-ec.bstatic.com/images/hotel/max1024x768/141/141830278.jpg', 21),
(64, 1, '2018-12-18 16:39:05', NULL, NULL, 1, 'https://s-ec.bstatic.com/images/hotel/max1024x768/141/141830278.jpg', 22),
(65, 1, '2018-12-18 16:39:05', NULL, NULL, 1, 'https://s-ec.bstatic.com/images/hotel/max1024x768/141/141830278.jpg', 22),
(66, 1, '2018-12-18 16:39:05', NULL, NULL, 1, 'https://s-ec.bstatic.com/images/hotel/max1024x768/141/141830278.jpg', 22),
(67, 1, '2018-12-18 16:43:25', NULL, NULL, 1, 'https://s-ec.bstatic.com/images/hotel/max1024x768/141/141830278.jpg', 23),
(68, 1, '2018-12-18 16:43:25', NULL, NULL, 1, 'https://s-ec.bstatic.com/images/hotel/max1024x768/141/141830278.jpg', 23),
(69, 1, '2018-12-18 16:43:25', NULL, NULL, 1, 'https://s-ec.bstatic.com/images/hotel/max1024x768/141/141830278.jpg', 23),
(70, 1, '2018-12-18 17:01:24', NULL, NULL, 1, 'https://s-ec.bstatic.com/images/hotel/max1024x768/141/141830278.jpg', 24),
(71, 1, '2018-12-18 17:01:24', NULL, NULL, 1, 'https://s-ec.bstatic.com/images/hotel/max1024x768/141/141830278.jpg', 24),
(72, 1, '2018-12-18 17:01:24', NULL, NULL, 1, 'https://s-ec.bstatic.com/images/hotel/max1024x768/141/141830278.jpg', 24),
(73, 1, '2018-12-18 17:13:04', NULL, NULL, 1, 'https://s-ec.bstatic.com/images/hotel/max1024x768/141/141830278.jpg', 25),
(74, 1, '2018-12-18 17:13:04', NULL, NULL, 1, 'https://s-ec.bstatic.com/images/hotel/max1024x768/141/141830278.jpg', 25),
(75, 1, '2018-12-18 17:13:04', NULL, NULL, 1, 'https://s-ec.bstatic.com/images/hotel/max1024x768/141/141830278.jpg', 25),
(76, 1, '2018-12-18 18:10:07', NULL, NULL, 1, 'https://s-ec.bstatic.com/images/hotel/max1024x768/141/141830278.jpg', 26),
(77, 1, '2018-12-18 18:10:07', NULL, NULL, 1, 'https://s-ec.bstatic.com/images/hotel/max1024x768/141/141830278.jpg', 26),
(78, 1, '2018-12-18 18:10:07', NULL, NULL, 1, 'https://s-ec.bstatic.com/images/hotel/max1024x768/141/141830278.jpg', 26);

-- --------------------------------------------------------

--
-- Table structure for table `property_vs_nearby`
--

CREATE TABLE `property_vs_nearby` (
  `property_nearby_id` bigint(20) NOT NULL,
  `created_by` bigint(20) DEFAULT NULL,
  `created_date` varchar(255) DEFAULT NULL,
  `modified_by` bigint(20) DEFAULT NULL,
  `modified_date` varchar(255) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `latitude` varchar(255) DEFAULT NULL,
  `longitude` varchar(255) DEFAULT NULL,
  `places` varchar(255) DEFAULT NULL,
  `property_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `property_vs_nearby`
--

INSERT INTO `property_vs_nearby` (`property_nearby_id`, `created_by`, `created_date`, `modified_by`, `modified_date`, `status`, `address`, `latitude`, `longitude`, `places`, `property_id`) VALUES
(1, 1, '2018-12-18 14:54:25', NULL, NULL, 1, NULL, NULL, NULL, 'RS Software', 1),
(2, 1, '2018-12-18 14:54:25', NULL, NULL, 1, NULL, NULL, NULL, 'SasdasdadDF', 1),
(3, 1, '2018-12-18 14:54:25', NULL, NULL, 1, NULL, NULL, NULL, 'Nicco Parks', 1),
(4, 1, '2018-12-18 15:01:12', NULL, NULL, 1, NULL, NULL, NULL, 'RS Software', 2),
(5, 1, '2018-12-18 15:01:12', NULL, NULL, 1, NULL, NULL, NULL, 'SasdasdadDF', 2),
(6, 1, '2018-12-18 15:01:12', NULL, NULL, 1, NULL, NULL, NULL, 'Nicco Parks', 2),
(7, 1, '2018-12-18 15:02:05', NULL, NULL, 1, NULL, NULL, NULL, 'RS Software', 3),
(8, 1, '2018-12-18 15:02:05', NULL, NULL, 1, NULL, NULL, NULL, 'SasdasdadDF', 3),
(9, 1, '2018-12-18 15:02:05', NULL, NULL, 1, NULL, NULL, NULL, 'Nicco Parks', 3),
(10, 1, '2018-12-18 15:19:01', NULL, NULL, 1, NULL, NULL, NULL, 'RS Software', 4),
(11, 1, '2018-12-18 15:19:01', NULL, NULL, 1, NULL, NULL, NULL, 'SasdasdadDF', 4),
(12, 1, '2018-12-18 15:19:01', NULL, NULL, 1, NULL, NULL, NULL, 'Nicco Parks', 4),
(13, 1, '2018-12-18 16:05:15', NULL, NULL, 1, NULL, NULL, NULL, 'RS Software', 5),
(14, 1, '2018-12-18 16:05:15', NULL, NULL, 1, NULL, NULL, NULL, 'SasdasdadDF', 5),
(15, 1, '2018-12-18 16:05:15', NULL, NULL, 1, NULL, NULL, NULL, 'Nicco Parks', 5),
(16, 1, '2018-12-18 16:09:48', NULL, NULL, 1, NULL, NULL, NULL, 'RS Software', 6),
(17, 1, '2018-12-18 16:09:48', NULL, NULL, 1, NULL, NULL, NULL, 'SasdasdadDF', 6),
(18, 1, '2018-12-18 16:09:48', NULL, NULL, 1, NULL, NULL, NULL, 'Nicco Parks', 6),
(19, 1, '2018-12-18 16:10:02', NULL, NULL, 1, NULL, NULL, NULL, 'RS Software', 7),
(20, 1, '2018-12-18 16:10:02', NULL, NULL, 1, NULL, NULL, NULL, 'SasdasdadDF', 7),
(21, 1, '2018-12-18 16:10:02', NULL, NULL, 1, NULL, NULL, NULL, 'Nicco Parks', 7),
(22, 1, '2018-12-18 16:15:08', NULL, NULL, 1, NULL, NULL, NULL, 'RS Software', 8),
(23, 1, '2018-12-18 16:15:08', NULL, NULL, 1, NULL, NULL, NULL, 'SasdasdadDF', 8),
(24, 1, '2018-12-18 16:15:08', NULL, NULL, 1, NULL, NULL, NULL, 'Nicco Parks', 8),
(25, 1, '2018-12-18 16:24:18', NULL, NULL, 1, NULL, NULL, NULL, 'RS Software', 9),
(26, 1, '2018-12-18 16:24:18', NULL, NULL, 1, NULL, NULL, NULL, 'SasdasdadDF', 9),
(27, 1, '2018-12-18 16:24:18', NULL, NULL, 1, NULL, NULL, NULL, 'Nicco Parks', 9),
(28, 1, '2018-12-18 16:25:19', NULL, NULL, 1, NULL, NULL, NULL, 'RS Software', 10),
(29, 1, '2018-12-18 16:25:19', NULL, NULL, 1, NULL, NULL, NULL, 'SasdasdadDF', 10),
(30, 1, '2018-12-18 16:25:19', NULL, NULL, 1, NULL, NULL, NULL, 'Nicco Parks', 10),
(31, 1, '2018-12-18 16:36:56', NULL, NULL, 1, NULL, NULL, NULL, 'RS Software', 11),
(32, 1, '2018-12-18 16:36:57', NULL, NULL, 1, NULL, NULL, NULL, 'SasdasdadDF', 11),
(33, 1, '2018-12-18 16:36:57', NULL, NULL, 1, NULL, NULL, NULL, 'Nicco Parks', 11),
(34, 1, '2018-12-18 16:39:05', NULL, NULL, 1, NULL, NULL, NULL, 'RS Software', 12),
(35, 1, '2018-12-18 16:39:05', NULL, NULL, 1, NULL, NULL, NULL, 'SasdasdadDF', 12),
(36, 1, '2018-12-18 16:39:05', NULL, NULL, 1, NULL, NULL, NULL, 'Nicco Parks', 12),
(37, 1, '2018-12-18 16:43:25', NULL, NULL, 1, NULL, NULL, NULL, 'RS Software', 13),
(38, 1, '2018-12-18 16:43:25', NULL, NULL, 1, NULL, NULL, NULL, 'SasdasdadDF', 13),
(39, 1, '2018-12-18 16:43:25', NULL, NULL, 1, NULL, NULL, NULL, 'Nicco Parks', 13),
(40, 1, '2018-12-18 17:01:24', NULL, NULL, 1, NULL, NULL, NULL, 'RS Software', 14),
(41, 1, '2018-12-18 17:01:24', NULL, NULL, 1, NULL, NULL, NULL, 'SasdasdadDF', 14),
(42, 1, '2018-12-18 17:01:24', NULL, NULL, 1, NULL, NULL, NULL, 'Nicco Parks', 14),
(43, 1, '2018-12-18 17:13:04', NULL, NULL, 1, NULL, NULL, NULL, 'RS Software', 15),
(44, 1, '2018-12-18 17:13:04', NULL, NULL, 1, NULL, NULL, NULL, 'SasdasdadDF', 15),
(45, 1, '2018-12-18 17:13:04', NULL, NULL, 1, NULL, NULL, NULL, 'Nicco Parks', 15),
(46, 1, '2018-12-18 18:10:07', NULL, NULL, 1, NULL, NULL, NULL, 'RS Software', 16),
(47, 1, '2018-12-18 18:10:07', NULL, NULL, 1, NULL, NULL, NULL, 'SasdasdadDF', 16),
(48, 1, '2018-12-18 18:10:07', NULL, NULL, 1, NULL, NULL, NULL, 'Nicco Parks', 16),
(49, 1, '2018-12-18 16:10:02', NULL, NULL, 1, NULL, NULL, NULL, 'RS Software', 17),
(50, 1, '2018-12-18 16:10:02', NULL, NULL, 1, NULL, NULL, NULL, 'SasdasdadDF', 17),
(51, 1, '2018-12-18 16:10:02', NULL, NULL, 1, NULL, NULL, NULL, 'Nicco Parks', 17),
(52, 1, '2018-12-18 16:15:08', NULL, NULL, 1, NULL, NULL, NULL, 'RS Software', 18),
(53, 1, '2018-12-18 16:15:08', NULL, NULL, 1, NULL, NULL, NULL, 'SasdasdadDF', 18),
(54, 1, '2018-12-18 16:15:08', NULL, NULL, 1, NULL, NULL, NULL, 'Nicco Parks', 18),
(55, 1, '2018-12-18 16:24:18', NULL, NULL, 1, NULL, NULL, NULL, 'RS Software', 19),
(56, 1, '2018-12-18 16:24:18', NULL, NULL, 1, NULL, NULL, NULL, 'SasdasdadDF', 19),
(57, 1, '2018-12-18 16:24:18', NULL, NULL, 1, NULL, NULL, NULL, 'Nicco Parks', 19),
(58, 1, '2018-12-18 16:25:19', NULL, NULL, 1, NULL, NULL, NULL, 'RS Software', 10),
(59, 1, '2018-12-18 16:25:19', NULL, NULL, 1, NULL, NULL, NULL, 'SasdasdadDF', 10),
(60, 1, '2018-12-18 16:25:19', NULL, NULL, 1, NULL, NULL, NULL, 'Nicco Parks', 10),
(61, 1, '2018-12-18 16:36:56', NULL, NULL, 1, NULL, NULL, NULL, 'RS Software', 21),
(62, 1, '2018-12-18 16:36:57', NULL, NULL, 1, NULL, NULL, NULL, 'SasdasdadDF', 21),
(63, 1, '2018-12-18 16:36:57', NULL, NULL, 1, NULL, NULL, NULL, 'Nicco Parks', 21),
(64, 1, '2018-12-18 16:39:05', NULL, NULL, 1, NULL, NULL, NULL, 'RS Software', 22),
(65, 1, '2018-12-18 16:39:05', NULL, NULL, 1, NULL, NULL, NULL, 'SasdasdadDF', 22),
(66, 1, '2018-12-18 16:39:05', NULL, NULL, 1, NULL, NULL, NULL, 'Nicco Parks', 22),
(67, 1, '2018-12-18 16:43:25', NULL, NULL, 1, NULL, NULL, NULL, 'RS Software', 23),
(68, 1, '2018-12-18 16:43:25', NULL, NULL, 1, NULL, NULL, NULL, 'SasdasdadDF', 23),
(69, 1, '2018-12-18 16:43:25', NULL, NULL, 1, NULL, NULL, NULL, 'Nicco Parks', 23),
(70, 1, '2018-12-18 17:01:24', NULL, NULL, 1, NULL, NULL, NULL, 'RS Software', 24),
(71, 1, '2018-12-18 17:01:24', NULL, NULL, 1, NULL, NULL, NULL, 'SasdasdadDF', 24),
(72, 1, '2018-12-18 17:01:24', NULL, NULL, 1, NULL, NULL, NULL, 'Nicco Parks', 24),
(73, 1, '2018-12-18 17:13:04', NULL, NULL, 1, NULL, NULL, NULL, 'RS Software', 25),
(74, 1, '2018-12-18 17:13:04', NULL, NULL, 1, NULL, NULL, NULL, 'SasdasdadDF', 25),
(75, 1, '2018-12-18 17:13:04', NULL, NULL, 1, NULL, NULL, NULL, 'Nicco Parks', 25),
(76, 1, '2018-12-18 18:10:07', NULL, NULL, 1, NULL, NULL, NULL, 'RS Software', 26),
(77, 1, '2018-12-18 18:10:07', NULL, NULL, 1, NULL, NULL, NULL, 'SasdasdadDF', 26),
(78, 1, '2018-12-18 18:10:07', NULL, NULL, 1, NULL, NULL, NULL, 'Nicco Parks', 26);

-- --------------------------------------------------------

--
-- Table structure for table `property_vs_pricedrop`
--

CREATE TABLE `property_vs_pricedrop` (
  `property_pricedrop_id` bigint(20) NOT NULL,
  `created_by` bigint(20) DEFAULT NULL,
  `created_date` varchar(255) DEFAULT NULL,
  `modified_by` bigint(20) DEFAULT NULL,
  `modified_date` varchar(255) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `percentage` varchar(255) DEFAULT NULL,
  `price_drop_id` bigint(20) NOT NULL,
  `property_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `property_vs_pricedrop`
--

INSERT INTO `property_vs_pricedrop` (`property_pricedrop_id`, `created_by`, `created_date`, `modified_by`, `modified_date`, `status`, `percentage`, `price_drop_id`, `property_id`) VALUES
(1, 1, '2018-12-18 14:54:25', NULL, NULL, 1, '0', 1, 1),
(2, 1, '2018-12-18 14:54:25', NULL, NULL, 1, '0', 2, 1),
(3, 1, '2018-12-18 15:01:12', NULL, NULL, 1, '0', 1, 2),
(4, 1, '2018-12-18 15:01:12', NULL, NULL, 1, '0', 2, 2),
(5, 1, '2018-12-18 15:02:05', NULL, NULL, 1, '0', 1, 3),
(6, 1, '2018-12-18 15:02:05', NULL, NULL, 1, '0', 2, 3),
(7, 1, '2018-12-18 15:19:01', NULL, NULL, 1, '0', 1, 4),
(8, 1, '2018-12-18 15:19:02', NULL, NULL, 1, '0', 2, 4),
(9, 1, '2018-12-18 16:05:15', NULL, NULL, 1, '0', 1, 5),
(10, 1, '2018-12-18 16:05:15', NULL, NULL, 1, '0', 2, 5),
(11, 1, '2018-12-18 16:09:48', NULL, NULL, 1, '0', 1, 6),
(12, 1, '2018-12-18 16:09:48', NULL, NULL, 1, '0', 2, 6),
(13, 1, '2018-12-18 16:10:02', NULL, NULL, 1, '0', 1, 7),
(14, 1, '2018-12-18 16:10:02', NULL, NULL, 1, '0', 2, 7),
(15, 1, '2018-12-18 16:15:08', NULL, NULL, 1, '0', 1, 8),
(16, 1, '2018-12-18 16:15:08', NULL, NULL, 1, '0', 2, 8),
(17, 1, '2018-12-18 16:24:18', NULL, NULL, 1, '0', 1, 9),
(18, 1, '2018-12-18 16:24:18', NULL, NULL, 1, '0', 2, 9),
(19, 1, '2018-12-18 16:25:19', NULL, NULL, 1, '0', 1, 10),
(20, 1, '2018-12-18 16:25:19', NULL, NULL, 1, '0', 2, 10),
(21, 1, '2018-12-18 16:36:57', NULL, NULL, 1, '0', 1, 11),
(22, 1, '2018-12-18 16:36:57', NULL, NULL, 1, '0', 2, 11),
(23, 1, '2018-12-18 16:39:05', NULL, NULL, 1, '0', 1, 12),
(24, 1, '2018-12-18 16:39:05', NULL, NULL, 1, '0', 2, 12),
(25, 1, '2018-12-18 16:43:25', NULL, NULL, 1, '0', 1, 13),
(26, 1, '2018-12-18 16:43:25', NULL, NULL, 1, '0', 2, 13),
(27, 1, '2018-12-18 17:01:24', NULL, NULL, 1, '0', 1, 14),
(28, 1, '2018-12-18 17:01:24', NULL, NULL, 1, '0', 2, 14),
(29, 1, '2018-12-18 17:13:04', NULL, NULL, 1, '0', 1, 15),
(30, 1, '2018-12-18 17:13:04', NULL, NULL, 1, '0', 2, 15),
(31, 1, '2018-12-18 18:10:07', NULL, NULL, 1, '0', 1, 16),
(32, 1, '2018-12-18 18:10:07', NULL, NULL, 1, '0', 2, 16),
(33, 1, '2018-12-18 16:10:02', NULL, NULL, 1, '0', 1, 17),
(34, 1, '2018-12-18 16:10:02', NULL, NULL, 1, '0', 2, 17),
(35, 1, '2018-12-18 16:15:08', NULL, NULL, 1, '0', 1, 18),
(36, 1, '2018-12-18 16:15:08', NULL, NULL, 1, '0', 2, 18),
(37, 1, '2018-12-18 16:24:18', NULL, NULL, 1, '0', 1, 19),
(38, 1, '2018-12-18 16:24:18', NULL, NULL, 1, '0', 2, 19),
(39, 1, '2018-12-18 16:25:19', NULL, NULL, 1, '0', 1, 20),
(40, 1, '2018-12-18 16:25:19', NULL, NULL, 1, '0', 2, 20),
(41, 1, '2018-12-18 16:36:57', NULL, NULL, 1, '0', 1, 21),
(42, 1, '2018-12-18 16:36:57', NULL, NULL, 1, '0', 2, 21),
(43, 1, '2018-12-18 16:39:05', NULL, NULL, 1, '0', 1, 22),
(44, 1, '2018-12-18 16:39:05', NULL, NULL, 1, '0', 2, 22),
(45, 1, '2018-12-18 16:43:25', NULL, NULL, 1, '0', 1, 23),
(46, 1, '2018-12-18 16:43:25', NULL, NULL, 1, '0', 2, 23),
(47, 1, '2018-12-18 17:01:24', NULL, NULL, 1, '0', 1, 24),
(48, 1, '2018-12-18 17:01:24', NULL, NULL, 1, '0', 2, 24),
(49, 1, '2018-12-18 17:13:04', NULL, NULL, 1, '0', 1, 25),
(50, 1, '2018-12-18 17:13:04', NULL, NULL, 1, '0', 2, 25),
(51, 1, '2018-12-18 18:10:07', NULL, NULL, 1, '0', 1, 26),
(52, 1, '2018-12-18 18:10:07', NULL, NULL, 1, '0', 2, 26);

-- --------------------------------------------------------

--
-- Table structure for table `property_vs_space`
--

CREATE TABLE `property_vs_space` (
  `property_space_id` bigint(20) NOT NULL,
  `created_by` bigint(20) DEFAULT NULL,
  `created_date` varchar(255) DEFAULT NULL,
  `modified_by` bigint(20) DEFAULT NULL,
  `modified_date` varchar(255) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `answer` varchar(255) DEFAULT NULL,
  `property_id` bigint(20) NOT NULL,
  `sprule_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `property_vs_space`
--

INSERT INTO `property_vs_space` (`property_space_id`, `created_by`, `created_date`, `modified_by`, `modified_date`, `status`, `answer`, `property_id`, `sprule_id`) VALUES
(1, 1, '2018-12-18 14:54:25', NULL, NULL, 1, 'Y', 1, 1),
(2, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 1, 2),
(3, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 1, 3),
(4, 1, '2018-12-18 15:01:12', NULL, NULL, 1, 'Y', 2, 1),
(5, 1, '2018-12-18 15:01:12', NULL, NULL, 1, 'N', 2, 2),
(6, 1, '2018-12-18 15:02:05', NULL, NULL, 1, 'Y', 2, 3),
(7, 1, '2018-12-18 15:02:06', NULL, NULL, 1, 'N', 3, 1),
(8, 1, '2018-12-18 15:19:02', NULL, NULL, 1, 'Y', 3, 2),
(9, 1, '2018-12-18 15:19:02', NULL, NULL, 1, 'N', 3, 3),
(10, 1, '2018-12-18 16:05:15', NULL, NULL, 1, 'Y', 4, 1),
(11, 1, '2018-12-18 16:05:15', NULL, NULL, 1, 'N', 4, 2),
(12, 1, '2018-12-18 16:09:48', NULL, NULL, 1, 'Y', 4, 3),
(13, 1, '2018-12-18 16:09:48', NULL, NULL, 1, 'N', 5, 1),
(14, 1, '2018-12-18 16:10:02', NULL, NULL, 1, 'Y', 5, 2),
(15, 1, '2018-12-18 16:10:02', NULL, NULL, 1, 'N', 5, 3),
(16, 1, '2018-12-18 16:15:08', NULL, NULL, 1, 'Y', 6, 1),
(17, 1, '2018-12-18 16:15:08', NULL, NULL, 1, 'N', 6, 2),
(18, 1, '2018-12-18 16:24:18', NULL, NULL, 1, 'Y', 6, 3),
(19, 1, '2018-12-18 16:24:18', NULL, NULL, 1, 'N', 7, 1),
(20, 1, '2018-12-18 16:25:19', NULL, NULL, 1, 'Y', 7, 2),
(21, 1, '2018-12-18 16:25:19', NULL, NULL, 1, 'N', 7, 3),
(22, 1, '2018-12-18 16:36:57', NULL, NULL, 1, 'Y', 8, 1),
(23, 1, '2018-12-18 16:36:57', NULL, NULL, 1, 'N', 8, 2),
(24, 1, '2018-12-18 16:39:05', NULL, NULL, 1, 'Y', 8, 3),
(25, 1, '2018-12-18 16:39:05', NULL, NULL, 1, 'N', 9, 1),
(26, 1, '2018-12-18 16:43:25', NULL, NULL, 1, 'Y', 9, 2),
(27, 1, '2018-12-18 16:43:25', NULL, NULL, 1, 'N', 9, 3),
(28, 1, '2018-12-18 17:01:24', NULL, NULL, 1, 'Y', 10, 1),
(29, 1, '2018-12-18 17:01:24', NULL, NULL, 1, 'N', 10, 2),
(30, 1, '2018-12-18 17:13:04', NULL, NULL, 1, 'Y', 10, 3),
(31, 1, '2018-12-18 17:13:04', NULL, NULL, 1, 'N', 11, 1),
(32, 1, '2018-12-18 18:10:07', NULL, NULL, 1, 'Y', 11, 2),
(33, 1, '2018-12-18 18:10:07', NULL, NULL, 1, 'N', 11, 3),
(34, 1, '2018-12-18 17:01:24', NULL, NULL, 1, 'Y', 11, 1),
(35, 1, '2018-12-18 17:01:24', NULL, NULL, 1, 'N', 11, 2),
(36, 1, '2018-12-18 17:13:04', NULL, NULL, 1, 'Y', 11, 3),
(37, 1, '2018-12-18 17:13:04', NULL, NULL, 1, 'N', 12, 1),
(38, 1, '2018-12-18 18:10:07', NULL, NULL, 1, 'Y', 12, 2),
(39, 1, '2018-12-18 18:10:07', NULL, NULL, 1, 'N', 12, 3),
(40, 1, '2018-12-18 17:01:24', NULL, NULL, 1, 'N', 13, 1),
(41, 1, '2018-12-18 17:01:24', NULL, NULL, 1, 'N', 13, 2),
(42, 1, '2018-12-18 17:13:04', NULL, NULL, 1, 'Y', 13, 3),
(43, 1, '2018-12-18 17:13:04', NULL, NULL, 1, 'Y', 14, 1),
(44, 1, '2018-12-18 18:10:07', NULL, NULL, 1, 'Y', 14, 2),
(45, 1, '2018-12-18 18:10:07', NULL, NULL, 1, 'Y', 14, 3),
(46, 1, '2018-12-18 17:01:24', NULL, NULL, 1, 'Y', 15, 1),
(47, 1, '2018-12-18 17:01:24', NULL, NULL, 1, 'N', 15, 2),
(48, 1, '2018-12-18 17:13:04', NULL, NULL, 1, 'Y', 15, 3),
(49, 1, '2018-12-18 17:13:04', NULL, NULL, 1, 'Y', 16, 1),
(50, 1, '2018-12-18 18:10:07', NULL, NULL, 1, 'Y', 16, 2),
(51, 1, '2018-12-18 18:10:07', NULL, NULL, 1, 'N', 16, 3),
(52, 1, '2018-12-18 17:01:24', NULL, NULL, 1, 'Y', 17, 1),
(53, 1, '2018-12-18 17:01:24', NULL, NULL, 1, 'N', 17, 2),
(54, 1, '2018-12-18 17:13:04', NULL, NULL, 1, 'Y', 17, 3),
(55, 1, '2018-12-18 17:13:04', NULL, NULL, 1, 'N', 18, 1),
(56, 1, '2018-12-18 18:10:07', NULL, NULL, 1, 'Y', 18, 2),
(57, 1, '2018-12-18 18:10:07', NULL, NULL, 1, 'N', 18, 3),
(58, 1, '2018-12-18 17:01:24', NULL, NULL, 1, 'Y', 19, 1),
(59, 1, '2018-12-18 17:01:24', NULL, NULL, 1, 'N', 19, 2),
(60, 1, '2018-12-18 17:13:04', NULL, NULL, 1, 'Y', 19, 3),
(61, 1, '2018-12-18 17:13:04', NULL, NULL, 1, 'Y', 20, 1),
(62, 1, '2018-12-18 18:10:07', NULL, NULL, 1, 'Y', 20, 2),
(63, 1, '2018-12-18 18:10:07', NULL, NULL, 1, 'Y', 20, 3),
(64, 1, '2018-12-18 17:01:24', NULL, NULL, 1, 'Y', 21, 1),
(65, 1, '2018-12-18 17:01:24', NULL, NULL, 1, 'N', 21, 2),
(66, 1, '2018-12-18 17:13:04', NULL, NULL, 1, 'Y', 21, 3),
(67, 1, '2018-12-18 17:13:04', NULL, NULL, 1, 'N', 22, 1),
(68, 1, '2018-12-18 18:10:07', NULL, NULL, 1, 'Y', 22, 2),
(69, 1, '2018-12-18 18:10:07', NULL, NULL, 1, 'N', 22, 3),
(70, 1, '2018-12-18 17:01:24', NULL, NULL, 1, 'Y', 23, 1),
(71, 1, '2018-12-18 17:01:24', NULL, NULL, 1, 'N', 23, 2),
(72, 1, '2018-12-18 17:13:04', NULL, NULL, 1, 'Y', 23, 3),
(73, 1, '2018-12-18 17:13:04', NULL, NULL, 1, 'N', 24, 1),
(74, 1, '2018-12-18 18:10:07', NULL, NULL, 1, 'Y', 24, 2),
(75, 1, '2018-12-18 18:10:07', NULL, NULL, 1, 'N', 24, 3),
(76, 1, '2018-12-18 17:01:24', NULL, NULL, 1, 'N', 25, 1),
(77, 1, '2018-12-18 17:01:24', NULL, NULL, 1, 'N', 25, 2),
(78, 1, '2018-12-18 17:13:04', NULL, NULL, 1, 'Y', 25, 3),
(79, 1, '2018-12-18 17:01:24', NULL, NULL, 1, 'Y', 26, 1),
(80, 1, '2018-12-18 17:01:24', NULL, NULL, 1, 'Y', 26, 2),
(81, 1, '2018-12-18 17:13:04', NULL, NULL, 1, 'Y', 26, 3);

-- --------------------------------------------------------

--
-- Table structure for table `room_vs_amenities`
--

CREATE TABLE `room_vs_amenities` (
  `room_vs_aminities_id` bigint(20) NOT NULL,
  `created_by` bigint(20) DEFAULT NULL,
  `created_date` varchar(255) DEFAULT NULL,
  `modified_by` bigint(20) DEFAULT NULL,
  `modified_date` varchar(255) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `aminities_id` bigint(20) NOT NULL,
  `room_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `room_vs_amenities`
--

INSERT INTO `room_vs_amenities` (`room_vs_aminities_id`, `created_by`, `created_date`, `modified_by`, `modified_date`, `status`, `aminities_id`, `room_id`) VALUES
(1, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 1, 1),
(2, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 2, 1),
(3, 1, '2018-12-18 15:01:12', NULL, NULL, 1, 3, 1),
(4, 1, '2018-12-18 15:01:14', NULL, NULL, 1, 1, 2),
(5, 1, '2018-12-18 15:02:06', NULL, NULL, 1, 2, 2),
(6, 1, '2018-12-18 15:02:06', NULL, NULL, 1, 1, 3),
(7, 1, '2018-12-18 15:19:02', NULL, NULL, 1, 2, 3),
(8, 1, '2018-12-18 15:19:02', NULL, NULL, 1, 1, 4),
(9, 1, '2018-12-18 16:05:15', NULL, NULL, 1, 2, 4),
(10, 1, '2018-12-18 16:05:16', NULL, NULL, 1, 3, 4),
(11, 1, '2018-12-18 16:09:48', NULL, NULL, 1, 1, 5),
(12, 1, '2018-12-18 16:09:49', NULL, NULL, 1, 3, 5),
(13, 1, '2018-12-18 16:10:02', NULL, NULL, 1, 2, 6),
(14, 1, '2018-12-18 16:10:02', NULL, NULL, 1, 3, 6),
(15, 1, '2018-12-18 16:15:08', NULL, NULL, 1, 1, 7),
(16, 1, '2018-12-18 16:15:08', NULL, NULL, 1, 2, 7),
(17, 1, '2018-12-18 16:24:19', NULL, NULL, 1, 1, 8),
(18, 1, '2018-12-18 16:24:20', NULL, NULL, 1, 2, 8),
(19, 1, '2018-12-18 16:25:19', NULL, NULL, 1, 1, 9),
(20, 1, '2018-12-18 16:25:19', NULL, NULL, 1, 3, 9),
(21, 1, '2018-12-18 16:36:57', NULL, NULL, 1, 1, 10),
(22, 1, '2018-12-18 16:36:57', NULL, NULL, 1, 2, 10),
(23, 1, '2018-12-18 16:39:05', NULL, NULL, 1, 3, 10),
(24, 1, '2018-12-18 16:39:05', NULL, NULL, 1, 2, 11),
(25, 1, '2018-12-18 16:43:25', NULL, NULL, 1, 3, 11),
(26, 1, '2018-12-18 16:43:26', NULL, NULL, 1, 1, 12),
(27, 1, '2018-12-18 17:01:24', NULL, NULL, 1, 2, 12),
(28, 1, '2018-12-18 17:01:24', NULL, NULL, 1, 1, 13),
(29, 1, '2018-12-18 17:13:04', NULL, NULL, 1, 3, 13),
(30, 1, '2018-12-18 17:13:04', NULL, NULL, 1, 1, 14),
(31, 1, '2018-12-18 18:10:07', NULL, NULL, 1, 2, 14),
(32, 1, '2018-12-18 18:10:07', NULL, NULL, 1, 3, 14),
(33, 1, '2018-12-18 16:09:48', NULL, NULL, 1, 1, 15),
(34, 1, '2018-12-18 16:09:49', NULL, NULL, 1, 3, 15),
(35, 1, '2018-12-18 16:10:02', NULL, NULL, 1, 2, 16),
(36, 1, '2018-12-18 16:10:02', NULL, NULL, 1, 3, 16),
(37, 1, '2018-12-18 16:15:08', NULL, NULL, 1, 1, 17),
(38, 1, '2018-12-18 16:15:08', NULL, NULL, 1, 2, 17),
(39, 1, '2018-12-18 16:24:19', NULL, NULL, 1, 1, 18),
(40, 1, '2018-12-18 16:24:20', NULL, NULL, 1, 2, 18),
(41, 1, '2018-12-18 16:25:19', NULL, NULL, 1, 1, 19),
(42, 1, '2018-12-18 16:25:19', NULL, NULL, 1, 3, 19),
(43, 1, '2018-12-18 16:36:57', NULL, NULL, 1, 1, 20),
(44, 1, '2018-12-18 16:36:57', NULL, NULL, 1, 2, 20),
(45, 1, '2018-12-18 16:39:05', NULL, NULL, 1, 3, 20),
(46, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 1, 21),
(47, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 2, 21),
(48, 1, '2018-12-18 15:01:12', NULL, NULL, 1, 3, 21),
(49, 1, '2018-12-18 15:01:14', NULL, NULL, 1, 1, 22),
(50, 1, '2018-12-18 15:02:06', NULL, NULL, 1, 2, 22),
(51, 1, '2018-12-18 15:02:06', NULL, NULL, 1, 1, 23),
(52, 1, '2018-12-18 15:19:02', NULL, NULL, 1, 2, 23),
(53, 1, '2018-12-18 15:19:02', NULL, NULL, 1, 1, 24),
(54, 1, '2018-12-18 16:05:15', NULL, NULL, 1, 2, 24),
(55, 1, '2018-12-18 16:05:16', NULL, NULL, 1, 3, 24),
(56, 1, '2018-12-18 16:09:48', NULL, NULL, 1, 1, 25),
(57, 1, '2018-12-18 16:09:49', NULL, NULL, 1, 3, 25),
(58, 1, '2018-12-18 16:10:02', NULL, NULL, 1, 2, 26),
(59, 1, '2018-12-18 16:10:02', NULL, NULL, 1, 3, 26),
(60, 1, '2018-12-18 16:15:08', NULL, NULL, 1, 1, 27),
(61, 1, '2018-12-18 16:15:08', NULL, NULL, 1, 2, 27),
(62, 1, '2018-12-18 16:24:19', NULL, NULL, 1, 1, 28),
(63, 1, '2018-12-18 16:24:20', NULL, NULL, 1, 2, 28),
(64, 1, '2018-12-18 16:25:19', NULL, NULL, 1, 1, 29),
(65, 1, '2018-12-18 16:25:19', NULL, NULL, 1, 3, 29),
(66, 1, '2018-12-18 16:36:57', NULL, NULL, 1, 1, 30),
(67, 1, '2018-12-18 16:36:57', NULL, NULL, 1, 2, 30),
(68, 1, '2018-12-18 16:39:05', NULL, NULL, 1, 3, 30),
(69, 1, '2018-12-18 16:39:05', NULL, NULL, 1, 2, 31),
(70, 1, '2018-12-18 16:43:25', NULL, NULL, 1, 3, 31),
(71, 1, '2018-12-18 16:43:26', NULL, NULL, 1, 1, 32),
(72, 1, '2018-12-18 17:01:24', NULL, NULL, 1, 2, 32),
(73, 1, '2018-12-18 17:01:24', NULL, NULL, 1, 1, 33),
(74, 1, '2018-12-18 17:13:04', NULL, NULL, 1, 3, 33),
(75, 1, '2018-12-18 17:13:04', NULL, NULL, 1, 1, 34),
(76, 1, '2018-12-18 18:10:07', NULL, NULL, 1, 2, 34),
(77, 1, '2018-12-18 18:10:07', NULL, NULL, 1, 3, 34),
(78, 1, '2018-12-18 16:09:48', NULL, NULL, 1, 1, 35),
(79, 1, '2018-12-18 16:09:49', NULL, NULL, 1, 3, 35),
(80, 1, '2018-12-18 16:10:02', NULL, NULL, 1, 2, 36),
(81, 1, '2018-12-18 16:10:02', NULL, NULL, 1, 3, 36),
(82, 1, '2018-12-18 16:15:08', NULL, NULL, 1, 1, 37),
(83, 1, '2018-12-18 16:15:08', NULL, NULL, 1, 2, 37),
(84, 1, '2018-12-18 16:24:19', NULL, NULL, 1, 1, 38),
(85, 1, '2018-12-18 16:24:20', NULL, NULL, 1, 2, 38),
(86, 1, '2018-12-18 16:25:19', NULL, NULL, 1, 1, 39),
(87, 1, '2018-12-18 16:25:19', NULL, NULL, 1, 3, 39),
(88, 1, '2018-12-18 16:36:57', NULL, NULL, 1, 1, 40),
(89, 1, '2018-12-18 16:36:57', NULL, NULL, 1, 2, 40),
(90, 1, '2018-12-18 16:39:05', NULL, NULL, 1, 3, 40),
(91, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 1, 41),
(92, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 2, 41),
(93, 1, '2018-12-18 15:01:12', NULL, NULL, 1, 3, 41),
(94, 1, '2018-12-18 15:01:14', NULL, NULL, 1, 1, 42),
(95, 1, '2018-12-18 15:02:06', NULL, NULL, 1, 2, 42),
(96, 1, '2018-12-18 15:02:06', NULL, NULL, 1, 1, 43),
(97, 1, '2018-12-18 15:19:02', NULL, NULL, 1, 2, 43),
(98, 1, '2018-12-18 15:19:02', NULL, NULL, 1, 1, 44),
(99, 1, '2018-12-18 16:05:15', NULL, NULL, 1, 2, 44),
(100, 1, '2018-12-18 16:05:16', NULL, NULL, 1, 3, 44),
(101, 1, '2018-12-18 16:09:48', NULL, NULL, 1, 1, 45),
(102, 1, '2018-12-18 16:09:49', NULL, NULL, 1, 3, 45),
(103, 1, '2018-12-18 16:10:02', NULL, NULL, 1, 2, 46),
(104, 1, '2018-12-18 16:10:02', NULL, NULL, 1, 3, 46),
(105, 1, '2018-12-18 16:15:08', NULL, NULL, 1, 1, 47),
(106, 1, '2018-12-18 16:15:08', NULL, NULL, 1, 2, 47),
(107, 1, '2018-12-18 16:24:19', NULL, NULL, 1, 1, 48),
(108, 1, '2018-12-18 16:24:20', NULL, NULL, 1, 2, 48),
(109, 1, '2018-12-18 16:25:19', NULL, NULL, 1, 1, 49),
(110, 1, '2018-12-18 16:25:19', NULL, NULL, 1, 3, 49),
(111, 1, '2018-12-18 16:36:57', NULL, NULL, 1, 1, 50),
(112, 1, '2018-12-18 16:36:57', NULL, NULL, 1, 2, 50),
(113, 1, '2018-12-18 16:39:05', NULL, NULL, 1, 3, 50),
(114, 1, '2018-12-18 16:39:05', NULL, NULL, 1, 2, 51),
(115, 1, '2018-12-18 16:43:25', NULL, NULL, 1, 3, 51),
(116, 1, '2018-12-18 16:43:26', NULL, NULL, 1, 1, 52),
(117, 1, '2018-12-18 17:01:24', NULL, NULL, 1, 2, 52),
(118, 1, '2018-12-18 17:01:24', NULL, NULL, 1, 1, 53),
(119, 1, '2018-12-18 17:13:04', NULL, NULL, 1, 3, 53),
(120, 1, '2018-12-18 17:13:04', NULL, NULL, 1, 1, 54),
(121, 1, '2018-12-18 18:10:07', NULL, NULL, 1, 2, 54),
(122, 1, '2018-12-18 18:10:07', NULL, NULL, 1, 3, 54),
(123, 1, '2018-12-18 16:09:48', NULL, NULL, 1, 1, 55),
(124, 1, '2018-12-18 16:09:49', NULL, NULL, 1, 3, 55),
(125, 1, '2018-12-18 16:10:02', NULL, NULL, 1, 2, 56),
(126, 1, '2018-12-18 16:10:02', NULL, NULL, 1, 3, 56),
(127, 1, '2018-12-18 16:15:08', NULL, NULL, 1, 1, 57),
(128, 1, '2018-12-18 16:15:08', NULL, NULL, 1, 2, 57),
(129, 1, '2018-12-18 16:24:19', NULL, NULL, 1, 1, 58),
(130, 1, '2018-12-18 16:24:20', NULL, NULL, 1, 2, 58),
(131, 1, '2018-12-18 16:25:19', NULL, NULL, 1, 1, 59),
(132, 1, '2018-12-18 16:25:19', NULL, NULL, 1, 3, 59),
(133, 1, '2018-12-18 16:36:57', NULL, NULL, 1, 1, 60),
(134, 1, '2018-12-18 16:36:57', NULL, NULL, 1, 2, 60),
(135, 1, '2018-12-18 16:39:05', NULL, NULL, 1, 3, 60),
(136, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 1, 61),
(137, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 2, 61),
(138, 1, '2018-12-18 15:01:12', NULL, NULL, 1, 3, 61),
(139, 1, '2018-12-18 15:01:14', NULL, NULL, 1, 1, 62),
(140, 1, '2018-12-18 15:02:06', NULL, NULL, 1, 2, 62),
(141, 1, '2018-12-18 15:02:06', NULL, NULL, 1, 1, 63),
(142, 1, '2018-12-18 15:19:02', NULL, NULL, 1, 2, 63),
(143, 1, '2018-12-18 15:19:02', NULL, NULL, 1, 1, 64),
(144, 1, '2018-12-18 16:05:15', NULL, NULL, 1, 2, 64),
(145, 1, '2018-12-18 16:05:16', NULL, NULL, 1, 3, 64),
(146, 1, '2018-12-18 16:09:48', NULL, NULL, 1, 1, 65),
(147, 1, '2018-12-18 16:09:49', NULL, NULL, 1, 3, 65),
(148, 1, '2018-12-18 16:10:02', NULL, NULL, 1, 2, 66),
(149, 1, '2018-12-18 16:10:02', NULL, NULL, 1, 3, 66),
(150, 1, '2018-12-18 16:15:08', NULL, NULL, 1, 1, 67),
(151, 1, '2018-12-18 16:15:08', NULL, NULL, 1, 2, 67),
(152, 1, '2018-12-18 16:24:19', NULL, NULL, 1, 1, 68),
(153, 1, '2018-12-18 16:24:20', NULL, NULL, 1, 2, 68),
(154, 1, '2018-12-18 16:25:19', NULL, NULL, 1, 1, 69),
(155, 1, '2018-12-18 16:25:19', NULL, NULL, 1, 3, 69),
(156, 1, '2018-12-18 16:36:57', NULL, NULL, 1, 1, 60),
(157, 1, '2018-12-18 16:36:57', NULL, NULL, 1, 2, 60),
(158, 1, '2018-12-18 16:39:05', NULL, NULL, 1, 3, 60),
(159, 1, '2018-12-18 16:39:05', NULL, NULL, 1, 2, 61),
(160, 1, '2018-12-18 16:43:25', NULL, NULL, 1, 3, 61),
(161, 1, '2018-12-18 16:43:26', NULL, NULL, 1, 1, 62),
(162, 1, '2018-12-18 17:01:24', NULL, NULL, 1, 2, 62),
(163, 1, '2018-12-18 17:01:24', NULL, NULL, 1, 1, 63),
(164, 1, '2018-12-18 17:13:04', NULL, NULL, 1, 3, 63),
(165, 1, '2018-12-18 17:13:04', NULL, NULL, 1, 1, 64),
(166, 1, '2018-12-18 18:10:07', NULL, NULL, 1, 2, 64),
(167, 1, '2018-12-18 18:10:07', NULL, NULL, 1, 3, 64),
(168, 1, '2018-12-18 16:09:48', NULL, NULL, 1, 1, 65),
(169, 1, '2018-12-18 16:09:49', NULL, NULL, 1, 3, 65),
(170, 1, '2018-12-18 16:10:02', NULL, NULL, 1, 2, 66),
(171, 1, '2018-12-18 16:10:02', NULL, NULL, 1, 3, 66),
(172, 1, '2018-12-18 16:15:08', NULL, NULL, 1, 1, 67),
(173, 1, '2018-12-18 16:15:08', NULL, NULL, 1, 2, 67),
(174, 1, '2018-12-18 16:24:19', NULL, NULL, 1, 1, 68),
(175, 1, '2018-12-18 16:24:20', NULL, NULL, 1, 2, 68),
(176, 1, '2018-12-18 16:25:19', NULL, NULL, 1, 1, 69),
(177, 1, '2018-12-18 16:25:19', NULL, NULL, 1, 3, 69),
(178, 1, '2018-12-18 16:36:57', NULL, NULL, 1, 1, 70),
(179, 1, '2018-12-18 16:36:57', NULL, NULL, 1, 2, 70),
(180, 1, '2018-12-18 16:39:05', NULL, NULL, 1, 3, 70),
(181, 1, '2018-12-18 16:39:05', NULL, NULL, 1, 2, 71),
(182, 1, '2018-12-18 16:43:25', NULL, NULL, 1, 3, 71),
(183, 1, '2018-12-18 16:43:26', NULL, NULL, 1, 1, 72),
(184, 1, '2018-12-18 17:01:24', NULL, NULL, 1, 2, 72),
(185, 1, '2018-12-18 17:01:24', NULL, NULL, 1, 1, 73),
(186, 1, '2018-12-18 17:13:04', NULL, NULL, 1, 3, 73),
(187, 1, '2018-12-18 17:13:04', NULL, NULL, 1, 1, 74),
(188, 1, '2018-12-18 18:10:07', NULL, NULL, 1, 2, 74),
(189, 1, '2018-12-18 18:10:07', NULL, NULL, 1, 3, 74),
(190, 1, '2018-12-18 16:09:48', NULL, NULL, 1, 1, 75),
(191, 1, '2018-12-18 16:09:49', NULL, NULL, 1, 3, 75),
(192, 1, '2018-12-18 16:10:02', NULL, NULL, 1, 2, 76),
(193, 1, '2018-12-18 16:10:02', NULL, NULL, 1, 3, 76),
(194, 1, '2018-12-18 16:15:08', NULL, NULL, 1, 1, 77),
(195, 1, '2018-12-18 16:15:08', NULL, NULL, 1, 2, 77),
(196, 1, '2018-12-18 16:24:19', NULL, NULL, 1, 1, 78),
(197, 1, '2018-12-18 16:24:20', NULL, NULL, 1, 2, 78),
(198, 1, '2018-12-18 16:25:19', NULL, NULL, 1, 1, 79),
(199, 1, '2018-12-18 16:25:19', NULL, NULL, 1, 3, 79),
(200, 1, '2018-12-18 16:36:57', NULL, NULL, 1, 1, 80),
(201, 1, '2018-12-18 16:36:57', NULL, NULL, 1, 2, 80),
(202, 1, '2018-12-18 16:39:05', NULL, NULL, 1, 3, 80),
(203, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 1, 81),
(204, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 2, 81),
(205, 1, '2018-12-18 15:01:12', NULL, NULL, 1, 3, 81),
(206, 1, '2018-12-18 15:01:14', NULL, NULL, 1, 1, 82),
(207, 1, '2018-12-18 15:02:06', NULL, NULL, 1, 2, 82),
(208, 1, '2018-12-18 15:02:06', NULL, NULL, 1, 1, 83),
(209, 1, '2018-12-18 15:19:02', NULL, NULL, 1, 2, 83),
(210, 1, '2018-12-18 15:19:02', NULL, NULL, 1, 1, 84),
(211, 1, '2018-12-18 16:05:15', NULL, NULL, 1, 2, 84),
(212, 1, '2018-12-18 16:05:16', NULL, NULL, 1, 3, 84),
(213, 1, '2018-12-18 16:09:48', NULL, NULL, 1, 1, 85),
(214, 1, '2018-12-18 16:09:49', NULL, NULL, 1, 3, 85),
(215, 1, '2018-12-18 16:10:02', NULL, NULL, 1, 2, 86),
(216, 1, '2018-12-18 16:10:02', NULL, NULL, 1, 3, 86),
(217, 1, '2018-12-18 16:15:08', NULL, NULL, 1, 1, 87),
(218, 1, '2018-12-18 16:15:08', NULL, NULL, 1, 2, 87),
(219, 1, '2018-12-18 16:24:19', NULL, NULL, 1, 1, 88),
(220, 1, '2018-12-18 16:24:20', NULL, NULL, 1, 2, 88),
(221, 1, '2018-12-18 16:25:19', NULL, NULL, 1, 1, 89),
(222, 1, '2018-12-18 16:25:19', NULL, NULL, 1, 3, 89),
(223, 1, '2018-12-18 16:36:57', NULL, NULL, 1, 1, 90),
(224, 1, '2018-12-18 16:36:57', NULL, NULL, 1, 2, 90),
(225, 1, '2018-12-18 16:39:05', NULL, NULL, 1, 3, 90),
(226, 1, '2018-12-18 16:39:05', NULL, NULL, 1, 2, 91),
(227, 1, '2018-12-18 16:43:25', NULL, NULL, 1, 3, 91),
(228, 1, '2018-12-18 16:43:26', NULL, NULL, 1, 1, 92),
(229, 1, '2018-12-18 17:01:24', NULL, NULL, 1, 2, 92),
(230, 1, '2018-12-18 17:01:24', NULL, NULL, 1, 1, 93),
(231, 1, '2018-12-18 17:13:04', NULL, NULL, 1, 3, 93),
(232, 1, '2018-12-18 17:13:04', NULL, NULL, 1, 1, 94),
(233, 1, '2018-12-18 18:10:07', NULL, NULL, 1, 2, 94),
(234, 1, '2018-12-18 18:10:07', NULL, NULL, 1, 3, 94),
(235, 1, '2018-12-18 16:09:48', NULL, NULL, 1, 1, 95),
(236, 1, '2018-12-18 16:09:49', NULL, NULL, 1, 3, 95),
(237, 1, '2018-12-18 16:10:02', NULL, NULL, 1, 2, 96),
(238, 1, '2018-12-18 16:10:02', NULL, NULL, 1, 3, 96),
(239, 1, '2018-12-18 16:15:08', NULL, NULL, 1, 1, 97),
(240, 1, '2018-12-18 16:15:08', NULL, NULL, 1, 2, 97),
(241, 1, '2018-12-18 16:24:19', NULL, NULL, 1, 1, 98),
(242, 1, '2018-12-18 16:24:20', NULL, NULL, 1, 2, 98),
(243, 1, '2018-12-18 16:25:19', NULL, NULL, 1, 1, 99),
(244, 1, '2018-12-18 16:25:19', NULL, NULL, 1, 3, 99),
(245, 1, '2018-12-18 16:36:57', NULL, NULL, 1, 1, 100),
(246, 1, '2018-12-18 16:36:57', NULL, NULL, 1, 2, 100),
(247, 1, '2018-12-18 16:39:05', NULL, NULL, 1, 3, 100),
(248, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 1, 101),
(249, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 2, 101),
(250, 1, '2018-12-18 15:01:12', NULL, NULL, 1, 3, 101),
(251, 1, '2018-12-18 15:01:14', NULL, NULL, 1, 1, 102),
(252, 1, '2018-12-18 15:02:06', NULL, NULL, 1, 2, 102),
(253, 1, '2018-12-18 15:02:06', NULL, NULL, 1, 1, 103),
(254, 1, '2018-12-18 15:19:02', NULL, NULL, 1, 2, 103),
(255, 1, '2018-12-18 15:19:02', NULL, NULL, 1, 1, 104),
(256, 1, '2018-12-18 16:05:15', NULL, NULL, 1, 2, 104),
(257, 1, '2018-12-18 16:05:16', NULL, NULL, 1, 3, 104),
(258, 1, '2018-12-18 16:09:48', NULL, NULL, 1, 1, 105),
(259, 1, '2018-12-18 16:09:49', NULL, NULL, 1, 3, 105),
(260, 1, '2018-12-18 16:10:02', NULL, NULL, 1, 2, 106),
(261, 1, '2018-12-18 16:10:02', NULL, NULL, 1, 3, 106),
(262, 1, '2018-12-18 16:15:08', NULL, NULL, 1, 1, 107),
(263, 1, '2018-12-18 16:15:08', NULL, NULL, 1, 2, 107),
(264, 1, '2018-12-18 16:24:19', NULL, NULL, 1, 1, 108),
(265, 1, '2018-12-18 16:24:20', NULL, NULL, 1, 2, 108),
(266, 1, '2018-12-18 16:25:19', NULL, NULL, 1, 1, 109),
(267, 1, '2018-12-18 16:25:19', NULL, NULL, 1, 3, 109),
(268, 1, '2018-12-18 16:36:57', NULL, NULL, 1, 1, 110),
(269, 1, '2018-12-18 16:36:57', NULL, NULL, 1, 2, 110),
(270, 1, '2018-12-18 16:39:05', NULL, NULL, 1, 3, 110),
(271, 1, '2018-12-18 16:39:05', NULL, NULL, 1, 2, 111),
(272, 1, '2018-12-18 16:43:25', NULL, NULL, 1, 3, 111),
(273, 1, '2018-12-18 16:43:26', NULL, NULL, 1, 1, 112),
(274, 1, '2018-12-18 17:01:24', NULL, NULL, 1, 2, 112),
(275, 1, '2018-12-18 17:01:24', NULL, NULL, 1, 1, 113),
(276, 1, '2018-12-18 17:13:04', NULL, NULL, 1, 3, 113),
(277, 1, '2018-12-18 17:13:04', NULL, NULL, 1, 1, 114),
(278, 1, '2018-12-18 18:10:07', NULL, NULL, 1, 2, 114),
(279, 1, '2018-12-18 18:10:07', NULL, NULL, 1, 3, 114),
(280, 1, '2018-12-18 16:09:48', NULL, NULL, 1, 1, 115),
(281, 1, '2018-12-18 16:09:49', NULL, NULL, 1, 3, 115),
(282, 1, '2018-12-18 16:10:02', NULL, NULL, 1, 2, 116),
(283, 1, '2018-12-18 16:10:02', NULL, NULL, 1, 3, 116),
(284, 1, '2018-12-18 16:15:08', NULL, NULL, 1, 1, 117),
(285, 1, '2018-12-18 16:15:08', NULL, NULL, 1, 2, 117),
(286, 1, '2018-12-18 16:24:19', NULL, NULL, 1, 1, 118),
(287, 1, '2018-12-18 16:24:20', NULL, NULL, 1, 2, 118),
(288, 1, '2018-12-18 16:25:19', NULL, NULL, 1, 1, 119),
(289, 1, '2018-12-18 16:25:19', NULL, NULL, 1, 3, 119),
(290, 1, '2018-12-18 16:36:57', NULL, NULL, 1, 1, 120),
(291, 1, '2018-12-18 16:36:57', NULL, NULL, 1, 2, 120),
(292, 1, '2018-12-18 16:39:05', NULL, NULL, 1, 3, 120),
(293, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 1, 121),
(294, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 2, 121),
(295, 1, '2018-12-18 15:01:12', NULL, NULL, 1, 3, 121),
(296, 1, '2018-12-18 15:01:14', NULL, NULL, 1, 1, 122),
(297, 1, '2018-12-18 15:02:06', NULL, NULL, 1, 2, 122),
(298, 1, '2018-12-18 15:02:06', NULL, NULL, 1, 1, 123),
(299, 1, '2018-12-18 15:19:02', NULL, NULL, 1, 2, 123),
(300, 1, '2018-12-18 15:19:02', NULL, NULL, 1, 1, 124),
(301, 1, '2018-12-18 16:05:15', NULL, NULL, 1, 2, 124),
(302, 1, '2018-12-18 16:05:16', NULL, NULL, 1, 3, 124),
(303, 1, '2018-12-18 16:09:48', NULL, NULL, 1, 1, 125),
(304, 1, '2018-12-18 16:09:49', NULL, NULL, 1, 3, 125),
(305, 1, '2018-12-18 16:10:02', NULL, NULL, 1, 2, 126),
(306, 1, '2018-12-18 16:10:02', NULL, NULL, 1, 3, 126),
(307, 1, '2018-12-18 16:15:08', NULL, NULL, 1, 1, 127),
(308, 1, '2018-12-18 16:15:08', NULL, NULL, 1, 2, 127),
(309, 1, '2018-12-18 16:24:19', NULL, NULL, 1, 1, 128),
(310, 1, '2018-12-18 16:24:20', NULL, NULL, 1, 2, 128),
(311, 1, '2018-12-18 16:25:19', NULL, NULL, 1, 1, 129),
(312, 1, '2018-12-18 16:25:19', NULL, NULL, 1, 3, 129),
(313, 1, '2018-12-18 16:36:57', NULL, NULL, 1, 1, 130),
(314, 1, '2018-12-18 16:36:57', NULL, NULL, 1, 2, 130),
(315, 1, '2018-12-18 16:39:05', NULL, NULL, 1, 3, 130),
(316, 1, '2018-12-18 16:39:05', NULL, NULL, 1, 2, 131),
(317, 1, '2018-12-18 16:43:25', NULL, NULL, 1, 3, 131),
(318, 1, '2018-12-18 16:43:26', NULL, NULL, 1, 1, 132),
(319, 1, '2018-12-18 17:01:24', NULL, NULL, 1, 2, 132),
(320, 1, '2018-12-18 17:01:24', NULL, NULL, 1, 1, 133),
(321, 1, '2018-12-18 17:13:04', NULL, NULL, 1, 3, 133),
(322, 1, '2018-12-18 17:13:04', NULL, NULL, 1, 1, 134),
(323, 1, '2018-12-18 18:10:07', NULL, NULL, 1, 2, 134),
(324, 1, '2018-12-18 18:10:07', NULL, NULL, 1, 3, 134),
(325, 1, '2018-12-18 16:09:48', NULL, NULL, 1, 1, 135),
(326, 1, '2018-12-18 16:09:49', NULL, NULL, 1, 3, 135),
(327, 1, '2018-12-18 16:10:02', NULL, NULL, 1, 2, 136),
(328, 1, '2018-12-18 16:10:02', NULL, NULL, 1, 3, 136),
(329, 1, '2018-12-18 16:15:08', NULL, NULL, 1, 1, 137),
(330, 1, '2018-12-18 16:15:08', NULL, NULL, 1, 2, 137),
(331, 1, '2018-12-18 16:24:19', NULL, NULL, 1, 1, 138),
(332, 1, '2018-12-18 16:24:20', NULL, NULL, 1, 2, 138),
(333, 1, '2018-12-18 16:25:19', NULL, NULL, 1, 1, 139),
(334, 1, '2018-12-18 16:25:19', NULL, NULL, 1, 3, 139),
(335, 1, '2018-12-18 16:36:57', NULL, NULL, 1, 1, 140),
(336, 1, '2018-12-18 16:36:57', NULL, NULL, 1, 2, 140),
(337, 1, '2018-12-18 16:39:05', NULL, NULL, 1, 3, 140),
(338, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 1, 141),
(339, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 2, 141),
(340, 1, '2018-12-18 15:01:12', NULL, NULL, 1, 3, 141),
(341, 1, '2018-12-18 15:01:14', NULL, NULL, 1, 1, 142),
(342, 1, '2018-12-18 15:02:06', NULL, NULL, 1, 2, 142),
(343, 1, '2018-12-18 15:02:06', NULL, NULL, 1, 1, 143),
(344, 1, '2018-12-18 15:19:02', NULL, NULL, 1, 2, 143),
(345, 1, '2018-12-18 15:19:02', NULL, NULL, 1, 1, 144),
(346, 1, '2018-12-18 16:05:15', NULL, NULL, 1, 2, 144),
(347, 1, '2018-12-18 16:05:16', NULL, NULL, 1, 3, 144),
(348, 1, '2018-12-18 16:09:48', NULL, NULL, 1, 1, 145),
(349, 1, '2018-12-18 16:09:49', NULL, NULL, 1, 3, 145),
(350, 1, '2018-12-18 16:10:02', NULL, NULL, 1, 2, 146),
(351, 1, '2018-12-18 16:10:02', NULL, NULL, 1, 3, 146),
(352, 1, '2018-12-18 16:15:08', NULL, NULL, 1, 1, 147),
(353, 1, '2018-12-18 16:15:08', NULL, NULL, 1, 2, 147),
(354, 1, '2018-12-18 16:24:19', NULL, NULL, 1, 1, 148),
(355, 1, '2018-12-18 16:24:20', NULL, NULL, 1, 2, 148),
(356, 1, '2018-12-18 16:25:19', NULL, NULL, 1, 1, 149),
(357, 1, '2018-12-18 16:25:19', NULL, NULL, 1, 3, 149),
(358, 1, '2018-12-18 16:36:57', NULL, NULL, 1, 1, 150),
(359, 1, '2018-12-18 16:36:57', NULL, NULL, 1, 2, 150),
(360, 1, '2018-12-18 16:39:05', NULL, NULL, 1, 3, 150),
(361, 1, '2018-12-18 16:39:05', NULL, NULL, 1, 2, 151),
(362, 1, '2018-12-18 16:43:25', NULL, NULL, 1, 3, 151),
(363, 1, '2018-12-18 16:43:26', NULL, NULL, 1, 1, 152),
(364, 1, '2018-12-18 17:01:24', NULL, NULL, 1, 2, 152),
(365, 1, '2018-12-18 17:01:24', NULL, NULL, 1, 1, 153),
(366, 1, '2018-12-18 17:13:04', NULL, NULL, 1, 3, 153),
(367, 1, '2018-12-18 17:13:04', NULL, NULL, 1, 1, 154),
(368, 1, '2018-12-18 18:10:07', NULL, NULL, 1, 2, 154),
(369, 1, '2018-12-18 18:10:07', NULL, NULL, 1, 3, 154),
(370, 1, '2018-12-18 16:09:48', NULL, NULL, 1, 1, 155),
(371, 1, '2018-12-18 16:09:49', NULL, NULL, 1, 3, 155),
(372, 1, '2018-12-18 16:10:02', NULL, NULL, 1, 2, 156),
(373, 1, '2018-12-18 16:10:02', NULL, NULL, 1, 3, 156),
(374, 1, '2018-12-18 16:15:08', NULL, NULL, 1, 1, 157),
(375, 1, '2018-12-18 16:15:08', NULL, NULL, 1, 2, 157),
(376, 1, '2018-12-18 16:24:19', NULL, NULL, 1, 1, 158),
(377, 1, '2018-12-18 16:24:20', NULL, NULL, 1, 2, 158),
(378, 1, '2018-12-18 16:25:19', NULL, NULL, 1, 1, 159),
(379, 1, '2018-12-18 16:25:19', NULL, NULL, 1, 3, 159),
(380, 1, '2018-12-18 16:36:57', NULL, NULL, 1, 1, 160),
(381, 1, '2018-12-18 16:36:57', NULL, NULL, 1, 2, 160),
(382, 1, '2018-12-18 16:39:05', NULL, NULL, 1, 3, 160),
(383, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 1, 161),
(384, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 2, 161),
(385, 1, '2018-12-18 15:01:12', NULL, NULL, 1, 3, 161);

-- --------------------------------------------------------

--
-- Table structure for table `room_vs_cancellation`
--

CREATE TABLE `room_vs_cancellation` (
  `rc_id` bigint(20) NOT NULL,
  `created_by` bigint(20) DEFAULT NULL,
  `created_date` varchar(255) DEFAULT NULL,
  `modified_by` bigint(20) DEFAULT NULL,
  `modified_date` varchar(255) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `percentage` varchar(255) DEFAULT NULL,
  `cancellation_slab_id` bigint(20) NOT NULL,
  `room_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `room_vs_cancellation`
--

INSERT INTO `room_vs_cancellation` (`rc_id`, `created_by`, `created_date`, `modified_by`, `modified_date`, `status`, `percentage`, `cancellation_slab_id`, `room_id`) VALUES
(1, 1, '2018-12-18 14:54:26', NULL, NULL, 1, '50', 1, 1),
(2, 1, '2018-12-18 14:54:26', NULL, NULL, 1, '40', 2, 1),
(3, 1, '2018-12-18 14:54:27', NULL, NULL, 1, '50', 1, 2),
(4, 1, '2018-12-18 14:54:27', NULL, NULL, 1, '40', 2, 2),
(5, 1, '2018-12-18 15:01:13', NULL, NULL, 1, '50', 1, 3),
(6, 1, '2018-12-18 15:01:13', NULL, NULL, 1, '40', 2, 3),
(7, 1, '2018-12-18 15:01:14', NULL, NULL, 1, '50', 1, 4),
(8, 1, '2018-12-18 15:01:14', NULL, NULL, 1, '40', 2, 4),
(9, 1, '2018-12-18 15:02:06', NULL, NULL, 1, '50', 1, 5),
(10, 1, '2018-12-18 15:02:06', NULL, NULL, 1, '40', 2, 5),
(11, 1, '2018-12-18 15:02:07', NULL, NULL, 1, '50', 1, 6),
(12, 1, '2018-12-18 15:02:07', NULL, NULL, 1, '40', 2, 6),
(13, 1, '2018-12-18 15:19:02', NULL, NULL, 1, '50', 1, 7),
(14, 1, '2018-12-18 15:19:02', NULL, NULL, 1, '40', 2, 7),
(15, 1, '2018-12-18 15:19:03', NULL, NULL, 1, '50', 1, 8),
(16, 1, '2018-12-18 15:19:03', NULL, NULL, 1, '40', 2, 8),
(17, 1, '2018-12-18 16:05:15', NULL, NULL, 1, '50', 1, 9),
(18, 1, '2018-12-18 16:05:15', NULL, NULL, 1, '40', 2, 9),
(19, 1, '2018-12-18 16:05:16', NULL, NULL, 1, '50', 1, 10),
(20, 1, '2018-12-18 16:05:16', NULL, NULL, 1, '40', 2, 10),
(21, 1, '2018-12-18 16:09:49', NULL, NULL, 1, '50', 1, 11),
(22, 1, '2018-12-18 16:09:49', NULL, NULL, 1, '40', 2, 11),
(23, 1, '2018-12-18 16:09:49', NULL, NULL, 1, '50', 1, 12),
(24, 1, '2018-12-18 16:09:49', NULL, NULL, 1, '40', 2, 12),
(25, 1, '2018-12-18 16:10:02', NULL, NULL, 1, '50', 1, 13),
(26, 1, '2018-12-18 16:10:02', NULL, NULL, 1, '40', 2, 13),
(27, 1, '2018-12-18 16:10:03', NULL, NULL, 1, '50', 1, 14),
(28, 1, '2018-12-18 16:10:03', NULL, NULL, 1, '40', 2, 14),
(29, 1, '2018-12-18 16:15:08', NULL, NULL, 1, '50', 1, 15),
(30, 1, '2018-12-18 16:15:08', NULL, NULL, 1, '40', 2, 15),
(31, 1, '2018-12-18 16:15:08', NULL, NULL, 1, '50', 1, 16),
(32, 1, '2018-12-18 16:15:08', NULL, NULL, 1, '40', 2, 16),
(33, 1, '2018-12-18 16:24:20', NULL, NULL, 1, '50', 1, 17),
(34, 1, '2018-12-18 16:24:20', NULL, NULL, 1, '40', 2, 17),
(35, 1, '2018-12-18 16:24:20', NULL, NULL, 1, '50', 1, 18),
(36, 1, '2018-12-18 16:24:20', NULL, NULL, 1, '40', 2, 18),
(37, 1, '2018-12-18 16:25:19', NULL, NULL, 1, '50', 1, 19),
(38, 1, '2018-12-18 16:25:19', NULL, NULL, 1, '40', 2, 19),
(39, 1, '2018-12-18 16:25:19', NULL, NULL, 1, '50', 1, 20),
(40, 1, '2018-12-18 16:25:19', NULL, NULL, 1, '40', 2, 20),
(41, 1, '2018-12-18 16:36:57', NULL, NULL, 1, '50', 1, 21),
(42, 1, '2018-12-18 16:36:57', NULL, NULL, 1, '40', 2, 21),
(43, 1, '2018-12-18 16:36:57', NULL, NULL, 1, '50', 1, 22),
(44, 1, '2018-12-18 16:36:57', NULL, NULL, 1, '40', 2, 22),
(45, 1, '2018-12-18 16:39:05', NULL, NULL, 1, '50', 1, 23),
(46, 1, '2018-12-18 16:39:05', NULL, NULL, 1, '40', 2, 23),
(47, 1, '2018-12-18 16:39:05', NULL, NULL, 1, '50', 1, 24),
(48, 1, '2018-12-18 16:39:05', NULL, NULL, 1, '40', 2, 24),
(49, 1, '2018-12-18 16:43:25', NULL, NULL, 1, '50', 1, 25),
(50, 1, '2018-12-18 16:43:25', NULL, NULL, 1, '40', 2, 25),
(51, 1, '2018-12-18 16:43:26', NULL, NULL, 1, '50', 1, 26),
(52, 1, '2018-12-18 16:43:26', NULL, NULL, 1, '40', 2, 26),
(53, 1, '2018-12-18 17:01:24', NULL, NULL, 1, '50', 1, 27),
(54, 1, '2018-12-18 17:01:24', NULL, NULL, 1, '40', 2, 27),
(55, 1, '2018-12-18 17:01:24', NULL, NULL, 1, '50', 1, 28),
(56, 1, '2018-12-18 17:01:24', NULL, NULL, 1, '40', 2, 28),
(57, 1, '2018-12-18 17:13:04', NULL, NULL, 1, '50', 1, 29),
(58, 1, '2018-12-18 17:13:04', NULL, NULL, 1, '40', 2, 29),
(59, 1, '2018-12-18 17:13:04', NULL, NULL, 1, '50', 1, 30),
(60, 1, '2018-12-18 17:13:04', NULL, NULL, 1, '40', 2, 30),
(61, 1, '2018-12-18 18:10:07', NULL, NULL, 1, '50', 1, 31),
(62, 1, '2018-12-18 18:10:07', NULL, NULL, 1, '40', 2, 31),
(63, 1, '2018-12-18 18:10:07', NULL, NULL, 1, '50', 1, 32),
(64, 1, '2018-12-18 18:10:07', NULL, NULL, 1, '40', 2, 32),
(65, 1, '2018-12-18 16:10:02', NULL, NULL, 1, '50', 1, 33),
(66, 1, '2018-12-18 16:10:02', NULL, NULL, 1, '40', 2, 33),
(67, 1, '2018-12-18 16:10:03', NULL, NULL, 1, '50', 1, 34),
(68, 1, '2018-12-18 16:10:03', NULL, NULL, 1, '40', 2, 34),
(69, 1, '2018-12-18 16:15:08', NULL, NULL, 1, '50', 1, 35),
(70, 1, '2018-12-18 16:15:08', NULL, NULL, 1, '40', 2, 35),
(71, 1, '2018-12-18 16:15:08', NULL, NULL, 1, '50', 1, 36),
(72, 1, '2018-12-18 16:15:08', NULL, NULL, 1, '40', 2, 36),
(73, 1, '2018-12-18 16:24:20', NULL, NULL, 1, '50', 1, 37),
(74, 1, '2018-12-18 16:24:20', NULL, NULL, 1, '40', 2, 37),
(75, 1, '2018-12-18 16:24:20', NULL, NULL, 1, '50', 1, 38),
(76, 1, '2018-12-18 16:24:20', NULL, NULL, 1, '40', 2, 38),
(77, 1, '2018-12-18 16:25:19', NULL, NULL, 1, '50', 1, 39),
(78, 1, '2018-12-18 16:25:19', NULL, NULL, 1, '40', 2, 39),
(79, 1, '2018-12-18 16:25:19', NULL, NULL, 1, '50', 1, 40),
(80, 1, '2018-12-18 16:25:19', NULL, NULL, 1, '40', 2, 40),
(81, 1, '2018-12-18 16:36:57', NULL, NULL, 1, '50', 1, 41),
(82, 1, '2018-12-18 16:36:57', NULL, NULL, 1, '40', 2, 41),
(83, 1, '2018-12-18 16:36:57', NULL, NULL, 1, '50', 1, 42),
(84, 1, '2018-12-18 16:36:57', NULL, NULL, 1, '40', 2, 42),
(85, 1, '2018-12-18 16:39:05', NULL, NULL, 1, '50', 1, 43),
(86, 1, '2018-12-18 16:39:05', NULL, NULL, 1, '40', 2, 43),
(87, 1, '2018-12-18 16:39:05', NULL, NULL, 1, '50', 1, 44),
(88, 1, '2018-12-18 16:39:05', NULL, NULL, 1, '40', 2, 44),
(89, 1, '2018-12-18 16:43:25', NULL, NULL, 1, '50', 1, 45),
(90, 1, '2018-12-18 16:43:25', NULL, NULL, 1, '40', 2, 45),
(91, 1, '2018-12-18 16:43:26', NULL, NULL, 1, '50', 1, 46),
(92, 1, '2018-12-18 16:43:26', NULL, NULL, 1, '40', 2, 46),
(93, 1, '2018-12-18 17:01:24', NULL, NULL, 1, '50', 1, 47),
(94, 1, '2018-12-18 17:01:24', NULL, NULL, 1, '40', 2, 47),
(95, 1, '2018-12-18 17:01:24', NULL, NULL, 1, '50', 1, 48),
(96, 1, '2018-12-18 17:01:24', NULL, NULL, 1, '40', 2, 48),
(97, 1, '2018-12-18 17:13:04', NULL, NULL, 1, '50', 1, 49),
(98, 1, '2018-12-18 17:13:04', NULL, NULL, 1, '40', 2, 49),
(99, 1, '2018-12-18 16:05:16', NULL, NULL, 1, '50', 1, 50),
(100, 1, '2018-12-18 16:05:16', NULL, NULL, 1, '40', 2, 50),
(101, 1, '2018-12-18 16:09:49', NULL, NULL, 1, '50', 1, 51),
(102, 1, '2018-12-18 16:09:49', NULL, NULL, 1, '40', 2, 51),
(103, 1, '2018-12-18 16:09:49', NULL, NULL, 1, '50', 1, 52),
(104, 1, '2018-12-18 16:09:49', NULL, NULL, 1, '40', 2, 52),
(105, 1, '2018-12-18 16:10:02', NULL, NULL, 1, '50', 1, 53),
(106, 1, '2018-12-18 16:10:02', NULL, NULL, 1, '40', 2, 53),
(107, 1, '2018-12-18 16:10:03', NULL, NULL, 1, '50', 1, 54),
(108, 1, '2018-12-18 16:10:03', NULL, NULL, 1, '40', 2, 54),
(109, 1, '2018-12-18 16:15:08', NULL, NULL, 1, '50', 1, 55),
(110, 1, '2018-12-18 16:15:08', NULL, NULL, 1, '40', 2, 55),
(111, 1, '2018-12-18 16:15:08', NULL, NULL, 1, '50', 1, 56),
(112, 1, '2018-12-18 16:15:08', NULL, NULL, 1, '40', 2, 56),
(113, 1, '2018-12-18 16:24:20', NULL, NULL, 1, '50', 1, 57),
(114, 1, '2018-12-18 16:24:20', NULL, NULL, 1, '40', 2, 57),
(115, 1, '2018-12-18 16:24:20', NULL, NULL, 1, '50', 1, 58),
(116, 1, '2018-12-18 16:24:20', NULL, NULL, 1, '40', 2, 58),
(117, 1, '2018-12-18 16:25:19', NULL, NULL, 1, '50', 1, 59),
(118, 1, '2018-12-18 16:25:19', NULL, NULL, 1, '40', 2, 59),
(119, 1, '2018-12-18 16:25:19', NULL, NULL, 1, '50', 1, 60),
(120, 1, '2018-12-18 16:25:19', NULL, NULL, 1, '40', 2, 60),
(121, 1, '2018-12-18 16:36:57', NULL, NULL, 1, '50', 1, 61),
(122, 1, '2018-12-18 16:36:57', NULL, NULL, 1, '40', 2, 61),
(123, 1, '2018-12-18 16:36:57', NULL, NULL, 1, '50', 1, 62),
(124, 1, '2018-12-18 16:36:57', NULL, NULL, 1, '40', 2, 62),
(125, 1, '2018-12-18 16:39:05', NULL, NULL, 1, '50', 1, 63),
(126, 1, '2018-12-18 16:39:05', NULL, NULL, 1, '40', 2, 63),
(127, 1, '2018-12-18 16:39:05', NULL, NULL, 1, '50', 1, 64),
(128, 1, '2018-12-18 16:39:05', NULL, NULL, 1, '40', 2, 64),
(129, 1, '2018-12-18 16:43:25', NULL, NULL, 1, '50', 1, 65),
(130, 1, '2018-12-18 16:43:25', NULL, NULL, 1, '40', 2, 65),
(131, 1, '2018-12-18 16:43:26', NULL, NULL, 1, '50', 1, 66),
(132, 1, '2018-12-18 16:43:26', NULL, NULL, 1, '40', 2, 66),
(133, 1, '2018-12-18 17:01:24', NULL, NULL, 1, '50', 1, 67),
(134, 1, '2018-12-18 17:01:24', NULL, NULL, 1, '40', 2, 67),
(135, 1, '2018-12-18 17:01:24', NULL, NULL, 1, '50', 1, 68),
(136, 1, '2018-12-18 17:01:24', NULL, NULL, 1, '40', 2, 68),
(137, 1, '2018-12-18 17:13:04', NULL, NULL, 1, '50', 1, 69),
(138, 1, '2018-12-18 17:13:04', NULL, NULL, 1, '40', 2, 69),
(139, 1, '2018-12-18 17:13:04', NULL, NULL, 1, '50', 1, 70),
(140, 1, '2018-12-18 17:13:04', NULL, NULL, 1, '40', 2, 70),
(141, 1, '2018-12-18 18:10:07', NULL, NULL, 1, '50', 1, 71),
(142, 1, '2018-12-18 18:10:07', NULL, NULL, 1, '40', 2, 71),
(143, 1, '2018-12-18 18:10:07', NULL, NULL, 1, '50', 1, 72),
(144, 1, '2018-12-18 18:10:07', NULL, NULL, 1, '40', 2, 72),
(145, 1, '2018-12-18 16:10:02', NULL, NULL, 1, '50', 1, 73),
(146, 1, '2018-12-18 16:10:02', NULL, NULL, 1, '40', 2, 73),
(147, 1, '2018-12-18 16:10:03', NULL, NULL, 1, '50', 1, 74),
(148, 1, '2018-12-18 16:10:03', NULL, NULL, 1, '40', 2, 74),
(149, 1, '2018-12-18 16:15:08', NULL, NULL, 1, '50', 1, 75),
(150, 1, '2018-12-18 16:15:08', NULL, NULL, 1, '40', 2, 75),
(151, 1, '2018-12-18 16:15:08', NULL, NULL, 1, '50', 1, 76),
(152, 1, '2018-12-18 16:15:08', NULL, NULL, 1, '40', 2, 76),
(153, 1, '2018-12-18 16:24:20', NULL, NULL, 1, '50', 1, 77),
(154, 1, '2018-12-18 16:24:20', NULL, NULL, 1, '40', 2, 77),
(155, 1, '2018-12-18 16:24:20', NULL, NULL, 1, '50', 1, 78),
(156, 1, '2018-12-18 16:24:20', NULL, NULL, 1, '40', 2, 78),
(157, 1, '2018-12-18 16:25:19', NULL, NULL, 1, '50', 1, 79),
(158, 1, '2018-12-18 16:25:19', NULL, NULL, 1, '40', 2, 79),
(159, 1, '2018-12-18 16:25:19', NULL, NULL, 1, '50', 1, 80),
(160, 1, '2018-12-18 16:25:19', NULL, NULL, 1, '40', 2, 80),
(161, 1, '2018-12-18 16:36:57', NULL, NULL, 1, '50', 1, 81),
(162, 1, '2018-12-18 16:36:57', NULL, NULL, 1, '40', 2, 81),
(163, 1, '2018-12-18 16:36:57', NULL, NULL, 1, '50', 1, 82),
(164, 1, '2018-12-18 16:36:57', NULL, NULL, 1, '40', 2, 82),
(165, 1, '2018-12-18 16:39:05', NULL, NULL, 1, '50', 1, 83),
(166, 1, '2018-12-18 16:39:05', NULL, NULL, 1, '40', 2, 83),
(167, 1, '2018-12-18 16:39:05', NULL, NULL, 1, '50', 1, 84),
(168, 1, '2018-12-18 16:39:05', NULL, NULL, 1, '40', 2, 84),
(169, 1, '2018-12-18 16:43:25', NULL, NULL, 1, '50', 1, 85),
(170, 1, '2018-12-18 16:43:25', NULL, NULL, 1, '40', 2, 85),
(171, 1, '2018-12-18 16:43:26', NULL, NULL, 1, '50', 1, 86),
(172, 1, '2018-12-18 16:43:26', NULL, NULL, 1, '40', 2, 86),
(173, 1, '2018-12-18 17:01:24', NULL, NULL, 1, '50', 1, 87),
(174, 1, '2018-12-18 17:01:24', NULL, NULL, 1, '40', 2, 87),
(175, 1, '2018-12-18 17:01:24', NULL, NULL, 1, '50', 1, 88),
(176, 1, '2018-12-18 17:01:24', NULL, NULL, 1, '40', 2, 88),
(177, 1, '2018-12-18 17:13:04', NULL, NULL, 1, '50', 1, 89),
(178, 1, '2018-12-18 17:13:04', NULL, NULL, 1, '40', 2, 89),
(179, 1, '2018-12-18 16:05:16', NULL, NULL, 1, '50', 1, 90),
(180, 1, '2018-12-18 16:05:16', NULL, NULL, 1, '40', 2, 90),
(181, 1, '2018-12-18 16:09:49', NULL, NULL, 1, '50', 1, 91),
(182, 1, '2018-12-18 16:09:49', NULL, NULL, 1, '40', 2, 91),
(183, 1, '2018-12-18 16:09:49', NULL, NULL, 1, '50', 1, 92),
(184, 1, '2018-12-18 16:09:49', NULL, NULL, 1, '40', 2, 92),
(185, 1, '2018-12-18 16:10:02', NULL, NULL, 1, '50', 1, 93),
(186, 1, '2018-12-18 16:10:02', NULL, NULL, 1, '40', 2, 93),
(187, 1, '2018-12-18 16:10:03', NULL, NULL, 1, '50', 1, 94),
(188, 1, '2018-12-18 16:10:03', NULL, NULL, 1, '40', 2, 94),
(189, 1, '2018-12-18 16:15:08', NULL, NULL, 1, '50', 1, 95),
(190, 1, '2018-12-18 16:15:08', NULL, NULL, 1, '40', 2, 95),
(191, 1, '2018-12-18 16:15:08', NULL, NULL, 1, '50', 1, 96),
(192, 1, '2018-12-18 16:15:08', NULL, NULL, 1, '40', 2, 96),
(193, 1, '2018-12-18 16:24:20', NULL, NULL, 1, '50', 1, 97),
(194, 1, '2018-12-18 16:24:20', NULL, NULL, 1, '40', 2, 97),
(195, 1, '2018-12-18 16:24:20', NULL, NULL, 1, '50', 1, 98),
(196, 1, '2018-12-18 16:24:20', NULL, NULL, 1, '40', 2, 98),
(197, 1, '2018-12-18 16:25:19', NULL, NULL, 1, '50', 1, 99),
(198, 1, '2018-12-18 16:25:19', NULL, NULL, 1, '40', 2, 99),
(199, 1, '2018-12-18 16:25:19', NULL, NULL, 1, '50', 1, 100),
(200, 1, '2018-12-18 16:25:19', NULL, NULL, 1, '40', 2, 100),
(201, 1, '2018-12-18 16:36:57', NULL, NULL, 1, '50', 1, 101),
(202, 1, '2018-12-18 16:36:57', NULL, NULL, 1, '40', 2, 101),
(203, 1, '2018-12-18 16:36:57', NULL, NULL, 1, '50', 1, 102),
(204, 1, '2018-12-18 16:36:57', NULL, NULL, 1, '40', 2, 102),
(205, 1, '2018-12-18 16:39:05', NULL, NULL, 1, '50', 1, 103),
(206, 1, '2018-12-18 16:39:05', NULL, NULL, 1, '40', 2, 103),
(207, 1, '2018-12-18 16:39:05', NULL, NULL, 1, '50', 1, 104),
(208, 1, '2018-12-18 16:39:05', NULL, NULL, 1, '40', 2, 104),
(209, 1, '2018-12-18 16:43:25', NULL, NULL, 1, '50', 1, 105),
(210, 1, '2018-12-18 16:43:25', NULL, NULL, 1, '40', 2, 105),
(211, 1, '2018-12-18 16:43:26', NULL, NULL, 1, '50', 1, 106),
(212, 1, '2018-12-18 16:43:26', NULL, NULL, 1, '40', 2, 106),
(213, 1, '2018-12-18 17:01:24', NULL, NULL, 1, '50', 1, 107),
(214, 1, '2018-12-18 17:01:24', NULL, NULL, 1, '40', 2, 107),
(215, 1, '2018-12-18 17:01:24', NULL, NULL, 1, '50', 1, 108),
(216, 1, '2018-12-18 17:01:24', NULL, NULL, 1, '40', 2, 108),
(217, 1, '2018-12-18 17:13:04', NULL, NULL, 1, '50', 1, 109),
(218, 1, '2018-12-18 17:13:04', NULL, NULL, 1, '40', 2, 109),
(219, 1, '2018-12-18 17:13:04', NULL, NULL, 1, '50', 1, 110),
(220, 1, '2018-12-18 17:13:04', NULL, NULL, 1, '40', 2, 110),
(221, 1, '2018-12-18 18:10:07', NULL, NULL, 1, '50', 1, 111),
(222, 1, '2018-12-18 18:10:07', NULL, NULL, 1, '40', 2, 111),
(223, 1, '2018-12-18 18:10:07', NULL, NULL, 1, '50', 1, 112),
(224, 1, '2018-12-18 18:10:07', NULL, NULL, 1, '40', 2, 112),
(225, 1, '2018-12-18 16:10:02', NULL, NULL, 1, '50', 1, 113),
(226, 1, '2018-12-18 16:10:02', NULL, NULL, 1, '40', 2, 113),
(227, 1, '2018-12-18 16:10:03', NULL, NULL, 1, '50', 1, 114),
(228, 1, '2018-12-18 16:10:03', NULL, NULL, 1, '40', 2, 114),
(229, 1, '2018-12-18 16:15:08', NULL, NULL, 1, '50', 1, 115),
(230, 1, '2018-12-18 16:15:08', NULL, NULL, 1, '40', 2, 115),
(231, 1, '2018-12-18 16:15:08', NULL, NULL, 1, '50', 1, 116),
(232, 1, '2018-12-18 16:15:08', NULL, NULL, 1, '40', 2, 116),
(233, 1, '2018-12-18 16:24:20', NULL, NULL, 1, '50', 1, 117),
(234, 1, '2018-12-18 16:24:20', NULL, NULL, 1, '40', 2, 117),
(235, 1, '2018-12-18 16:24:20', NULL, NULL, 1, '50', 1, 118),
(236, 1, '2018-12-18 16:24:20', NULL, NULL, 1, '40', 2, 118),
(237, 1, '2018-12-18 16:25:19', NULL, NULL, 1, '50', 1, 119),
(238, 1, '2018-12-18 16:25:19', NULL, NULL, 1, '40', 2, 119),
(239, 1, '2018-12-18 16:25:19', NULL, NULL, 1, '50', 1, 120),
(240, 1, '2018-12-18 16:25:19', NULL, NULL, 1, '40', 2, 120),
(241, 1, '2018-12-18 16:36:57', NULL, NULL, 1, '50', 1, 121),
(242, 1, '2018-12-18 16:36:57', NULL, NULL, 1, '40', 2, 121),
(243, 1, '2018-12-18 16:36:57', NULL, NULL, 1, '50', 1, 122),
(244, 1, '2018-12-18 16:36:57', NULL, NULL, 1, '40', 2, 122),
(245, 1, '2018-12-18 16:39:05', NULL, NULL, 1, '50', 1, 123),
(246, 1, '2018-12-18 16:39:05', NULL, NULL, 1, '40', 2, 123),
(247, 1, '2018-12-18 16:39:05', NULL, NULL, 1, '50', 1, 124),
(248, 1, '2018-12-18 16:39:05', NULL, NULL, 1, '40', 2, 124),
(249, 1, '2018-12-18 16:43:25', NULL, NULL, 1, '50', 1, 125),
(250, 1, '2018-12-18 16:43:25', NULL, NULL, 1, '40', 2, 125),
(251, 1, '2018-12-18 16:43:26', NULL, NULL, 1, '50', 1, 126),
(252, 1, '2018-12-18 16:43:26', NULL, NULL, 1, '40', 2, 126),
(253, 1, '2018-12-18 17:01:24', NULL, NULL, 1, '50', 1, 127),
(254, 1, '2018-12-18 17:01:24', NULL, NULL, 1, '40', 2, 127),
(255, 1, '2018-12-18 17:01:24', NULL, NULL, 1, '50', 1, 128),
(256, 1, '2018-12-18 17:01:24', NULL, NULL, 1, '40', 2, 128),
(257, 1, '2018-12-18 17:13:04', NULL, NULL, 1, '50', 1, 129),
(258, 1, '2018-12-18 17:13:04', NULL, NULL, 1, '40', 2, 129),
(259, 1, '2018-12-18 16:25:19', NULL, NULL, 1, '50', 1, 130),
(260, 1, '2018-12-18 16:25:19', NULL, NULL, 1, '40', 2, 130),
(261, 1, '2018-12-18 16:36:57', NULL, NULL, 1, '50', 1, 131),
(262, 1, '2018-12-18 16:36:57', NULL, NULL, 1, '40', 2, 131),
(263, 1, '2018-12-18 16:36:57', NULL, NULL, 1, '50', 1, 132),
(264, 1, '2018-12-18 16:36:57', NULL, NULL, 1, '40', 2, 132),
(265, 1, '2018-12-18 16:39:05', NULL, NULL, 1, '50', 1, 133),
(266, 1, '2018-12-18 16:39:05', NULL, NULL, 1, '40', 2, 133),
(267, 1, '2018-12-18 16:39:05', NULL, NULL, 1, '50', 1, 134),
(268, 1, '2018-12-18 16:39:05', NULL, NULL, 1, '40', 2, 134),
(269, 1, '2018-12-18 16:43:25', NULL, NULL, 1, '50', 1, 135),
(270, 1, '2018-12-18 16:43:25', NULL, NULL, 1, '40', 2, 135),
(271, 1, '2018-12-18 16:43:26', NULL, NULL, 1, '50', 1, 136),
(272, 1, '2018-12-18 16:43:26', NULL, NULL, 1, '40', 2, 136),
(273, 1, '2018-12-18 17:01:24', NULL, NULL, 1, '50', 1, 137),
(274, 1, '2018-12-18 17:01:24', NULL, NULL, 1, '40', 2, 137),
(275, 1, '2018-12-18 17:01:24', NULL, NULL, 1, '50', 1, 138),
(276, 1, '2018-12-18 17:01:24', NULL, NULL, 1, '40', 2, 138),
(277, 1, '2018-12-18 17:13:04', NULL, NULL, 1, '50', 1, 139),
(278, 1, '2018-12-18 17:13:04', NULL, NULL, 1, '40', 2, 139),
(279, 1, '2018-12-18 16:25:19', NULL, NULL, 1, '50', 1, 140),
(280, 1, '2018-12-18 16:25:19', NULL, NULL, 1, '40', 2, 140),
(281, 1, '2018-12-18 16:36:57', NULL, NULL, 1, '50', 1, 141),
(282, 1, '2018-12-18 16:36:57', NULL, NULL, 1, '40', 2, 141),
(283, 1, '2018-12-18 16:36:57', NULL, NULL, 1, '50', 1, 142),
(284, 1, '2018-12-18 16:36:57', NULL, NULL, 1, '40', 2, 142),
(285, 1, '2018-12-18 16:39:05', NULL, NULL, 1, '50', 1, 143),
(286, 1, '2018-12-18 16:39:05', NULL, NULL, 1, '40', 2, 143),
(287, 1, '2018-12-18 16:39:05', NULL, NULL, 1, '50', 1, 144),
(288, 1, '2018-12-18 16:39:05', NULL, NULL, 1, '40', 2, 144),
(289, 1, '2018-12-18 16:43:25', NULL, NULL, 1, '50', 1, 145),
(290, 1, '2018-12-18 16:43:25', NULL, NULL, 1, '40', 2, 145),
(291, 1, '2018-12-18 16:43:26', NULL, NULL, 1, '50', 1, 146),
(292, 1, '2018-12-18 16:43:26', NULL, NULL, 1, '40', 2, 146),
(293, 1, '2018-12-18 17:01:24', NULL, NULL, 1, '50', 1, 147),
(294, 1, '2018-12-18 17:01:24', NULL, NULL, 1, '40', 2, 147),
(295, 1, '2018-12-18 17:01:24', NULL, NULL, 1, '50', 1, 148),
(296, 1, '2018-12-18 17:01:24', NULL, NULL, 1, '40', 2, 148),
(297, 1, '2018-12-18 17:13:04', NULL, NULL, 1, '50', 1, 149),
(298, 1, '2018-12-18 17:13:04', NULL, NULL, 1, '40', 2, 149),
(299, 1, '2018-12-18 16:25:19', NULL, NULL, 1, '50', 1, 150),
(300, 1, '2018-12-18 16:25:19', NULL, NULL, 1, '40', 2, 150),
(301, 1, '2018-12-18 16:36:57', NULL, NULL, 1, '50', 1, 151),
(302, 1, '2018-12-18 16:36:57', NULL, NULL, 1, '40', 2, 151),
(303, 1, '2018-12-18 16:36:57', NULL, NULL, 1, '50', 1, 152),
(304, 1, '2018-12-18 16:36:57', NULL, NULL, 1, '40', 2, 152),
(305, 1, '2018-12-18 16:39:05', NULL, NULL, 1, '50', 1, 153),
(306, 1, '2018-12-18 16:39:05', NULL, NULL, 1, '40', 2, 153),
(307, 1, '2018-12-18 16:39:05', NULL, NULL, 1, '50', 1, 154),
(308, 1, '2018-12-18 16:39:05', NULL, NULL, 1, '40', 2, 154),
(309, 1, '2018-12-18 16:43:25', NULL, NULL, 1, '50', 1, 155),
(310, 1, '2018-12-18 16:43:25', NULL, NULL, 1, '40', 2, 155),
(311, 1, '2018-12-18 16:43:26', NULL, NULL, 1, '50', 1, 156),
(312, 1, '2018-12-18 16:43:26', NULL, NULL, 1, '40', 2, 156),
(313, 1, '2018-12-18 17:01:24', NULL, NULL, 1, '50', 1, 157),
(314, 1, '2018-12-18 17:01:24', NULL, NULL, 1, '40', 2, 157),
(315, 1, '2018-12-18 17:01:24', NULL, NULL, 1, '50', 1, 158),
(316, 1, '2018-12-18 17:01:24', NULL, NULL, 1, '40', 2, 158),
(317, 1, '2018-12-18 17:13:04', NULL, NULL, 1, '50', 1, 159),
(318, 1, '2018-12-18 17:13:04', NULL, NULL, 1, '40', 2, 159),
(319, 1, '2018-12-18 16:25:19', NULL, NULL, 1, '50', 1, 160),
(320, 1, '2018-12-18 16:25:19', NULL, NULL, 1, '40', 2, 160),
(321, 1, '2018-12-18 16:36:57', NULL, NULL, 1, '50', 1, 161),
(322, 1, '2018-12-18 16:36:57', NULL, NULL, 1, '40', 2, 161);

-- --------------------------------------------------------

--
-- Table structure for table `room_vs_image`
--

CREATE TABLE `room_vs_image` (
  `room_vs_image_id` bigint(20) NOT NULL,
  `created_by` bigint(20) DEFAULT NULL,
  `created_date` varchar(255) DEFAULT NULL,
  `modified_by` bigint(20) DEFAULT NULL,
  `modified_date` varchar(255) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `image_url` varchar(255) DEFAULT NULL,
  `room_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `room_vs_image`
--

INSERT INTO `room_vs_image` (`room_vs_image_id`, `created_by`, `created_date`, `modified_by`, `modified_date`, `status`, `image_url`, `room_id`) VALUES
(1, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'www.google.com', 1),
(2, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'www.google.com', 1),
(3, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'www.google.com', 1),
(4, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'www.google.com', 2),
(5, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'www.google.com', 2),
(6, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'www.google.com', 2),
(7, 1, '2018-12-18 15:01:12', NULL, NULL, 1, 'www.google.com', 3),
(8, 1, '2018-12-18 15:01:12', NULL, NULL, 1, 'www.google.com', 3),
(9, 1, '2018-12-18 15:01:13', NULL, NULL, 1, 'www.google.com', 3),
(10, 1, '2018-12-18 15:01:14', NULL, NULL, 1, 'www.google.com', 4),
(11, 1, '2018-12-18 15:01:14', NULL, NULL, 1, 'www.google.com', 4),
(12, 1, '2018-12-18 15:01:14', NULL, NULL, 1, 'www.google.com', 4),
(13, 1, '2018-12-18 15:02:06', NULL, NULL, 1, 'www.google.com', 5),
(14, 1, '2018-12-18 15:02:06', NULL, NULL, 1, 'www.google.com', 5),
(15, 1, '2018-12-18 15:02:06', NULL, NULL, 1, 'www.google.com', 5),
(16, 1, '2018-12-18 15:02:06', NULL, NULL, 1, 'www.google.com', 6),
(17, 1, '2018-12-18 15:02:06', NULL, NULL, 1, 'www.google.com', 6),
(18, 1, '2018-12-18 15:02:06', NULL, NULL, 1, 'www.google.com', 6),
(19, 1, '2018-12-18 15:19:02', NULL, NULL, 1, 'www.google.com', 7),
(20, 1, '2018-12-18 15:19:02', NULL, NULL, 1, 'www.google.com', 7),
(21, 1, '2018-12-18 15:19:02', NULL, NULL, 1, 'www.google.com', 7),
(22, 1, '2018-12-18 15:19:02', NULL, NULL, 1, 'www.google.com', 8),
(23, 1, '2018-12-18 15:19:02', NULL, NULL, 1, 'www.google.com', 8),
(24, 1, '2018-12-18 15:19:02', NULL, NULL, 1, 'www.google.com', 8),
(25, 1, '2018-12-18 16:05:15', NULL, NULL, 1, 'www.google.com', 9),
(26, 1, '2018-12-18 16:05:15', NULL, NULL, 1, 'www.google.com', 9),
(27, 1, '2018-12-18 16:05:15', NULL, NULL, 1, 'www.google.com', 9),
(28, 1, '2018-12-18 16:05:16', NULL, NULL, 1, 'www.google.com', 10),
(29, 1, '2018-12-18 16:05:16', NULL, NULL, 1, 'www.google.com', 10),
(30, 1, '2018-12-18 16:05:16', NULL, NULL, 1, 'www.google.com', 10),
(31, 1, '2018-12-18 16:09:48', NULL, NULL, 1, 'www.google.com', 11),
(32, 1, '2018-12-18 16:09:48', NULL, NULL, 1, 'www.google.com', 11),
(33, 1, '2018-12-18 16:09:48', NULL, NULL, 1, 'www.google.com', 11),
(34, 1, '2018-12-18 16:09:49', NULL, NULL, 1, 'www.google.com', 12),
(35, 1, '2018-12-18 16:09:49', NULL, NULL, 1, 'www.google.com', 12),
(36, 1, '2018-12-18 16:09:49', NULL, NULL, 1, 'www.google.com', 12),
(37, 1, '2018-12-18 16:10:02', NULL, NULL, 1, 'www.google.com', 13),
(38, 1, '2018-12-18 16:10:02', NULL, NULL, 1, 'www.google.com', 13),
(39, 1, '2018-12-18 16:10:02', NULL, NULL, 1, 'www.google.com', 13),
(40, 1, '2018-12-18 16:10:02', NULL, NULL, 1, 'www.google.com', 14),
(41, 1, '2018-12-18 16:10:02', NULL, NULL, 1, 'www.google.com', 14),
(42, 1, '2018-12-18 16:10:02', NULL, NULL, 1, 'www.google.com', 14),
(43, 1, '2018-12-18 16:15:08', NULL, NULL, 1, 'www.google.com', 15),
(44, 1, '2018-12-18 16:15:08', NULL, NULL, 1, 'www.google.com', 15),
(45, 1, '2018-12-18 16:15:08', NULL, NULL, 1, 'www.google.com', 15),
(46, 1, '2018-12-18 16:15:08', NULL, NULL, 1, 'www.google.com', 16),
(47, 1, '2018-12-18 16:15:08', NULL, NULL, 1, 'www.google.com', 16),
(48, 1, '2018-12-18 16:15:08', NULL, NULL, 1, 'www.google.com', 16),
(49, 1, '2018-12-18 16:24:19', NULL, NULL, 1, 'www.google.com', 17),
(50, 1, '2018-12-18 16:24:19', NULL, NULL, 1, 'www.google.com', 17),
(51, 1, '2018-12-18 16:24:19', NULL, NULL, 1, 'www.google.com', 17),
(52, 1, '2018-12-18 16:24:20', NULL, NULL, 1, 'www.google.com', 18),
(53, 1, '2018-12-18 16:24:20', NULL, NULL, 1, 'www.google.com', 18),
(54, 1, '2018-12-18 16:24:20', NULL, NULL, 1, 'www.google.com', 18),
(55, 1, '2018-12-18 16:25:19', NULL, NULL, 1, 'www.google.com', 19),
(56, 1, '2018-12-18 16:25:19', NULL, NULL, 1, 'www.google.com', 19),
(57, 1, '2018-12-18 16:25:19', NULL, NULL, 1, 'www.google.com', 19),
(58, 1, '2018-12-18 16:25:19', NULL, NULL, 1, 'www.google.com', 20),
(59, 1, '2018-12-18 16:25:19', NULL, NULL, 1, 'www.google.com', 20),
(60, 1, '2018-12-18 16:25:19', NULL, NULL, 1, 'www.google.com', 20),
(61, 1, '2018-12-18 16:36:57', NULL, NULL, 1, 'www.google.com', 21),
(62, 1, '2018-12-18 16:36:57', NULL, NULL, 1, 'www.google.com', 21),
(63, 1, '2018-12-18 16:36:57', NULL, NULL, 1, 'www.google.com', 21),
(64, 1, '2018-12-18 16:36:57', NULL, NULL, 1, 'www.google.com', 22),
(65, 1, '2018-12-18 16:36:57', NULL, NULL, 1, 'www.google.com', 22),
(66, 1, '2018-12-18 16:36:57', NULL, NULL, 1, 'www.google.com', 22),
(67, 1, '2018-12-18 16:39:05', NULL, NULL, 1, 'www.google.com', 23),
(68, 1, '2018-12-18 16:39:05', NULL, NULL, 1, 'www.google.com', 23),
(69, 1, '2018-12-18 16:39:05', NULL, NULL, 1, 'www.google.com', 23),
(70, 1, '2018-12-18 16:39:05', NULL, NULL, 1, 'www.google.com', 24),
(71, 1, '2018-12-18 16:39:05', NULL, NULL, 1, 'www.google.com', 24),
(72, 1, '2018-12-18 16:39:05', NULL, NULL, 1, 'www.google.com', 24),
(73, 1, '2018-12-18 16:43:25', NULL, NULL, 1, 'www.google.com', 25),
(74, 1, '2018-12-18 16:43:25', NULL, NULL, 1, 'www.google.com', 25),
(75, 1, '2018-12-18 16:43:25', NULL, NULL, 1, 'www.google.com', 25),
(76, 1, '2018-12-18 16:43:26', NULL, NULL, 1, 'www.google.com', 26),
(77, 1, '2018-12-18 16:43:26', NULL, NULL, 1, 'www.google.com', 26),
(78, 1, '2018-12-18 16:43:26', NULL, NULL, 1, 'www.google.com', 26),
(79, 1, '2018-12-18 17:01:24', NULL, NULL, 1, 'www.google.com', 27),
(80, 1, '2018-12-18 17:01:24', NULL, NULL, 1, 'www.google.com', 27),
(81, 1, '2018-12-18 17:01:24', NULL, NULL, 1, 'www.google.com', 27),
(82, 1, '2018-12-18 17:01:24', NULL, NULL, 1, 'www.google.com', 28),
(83, 1, '2018-12-18 17:01:24', NULL, NULL, 1, 'www.google.com', 28),
(84, 1, '2018-12-18 17:01:24', NULL, NULL, 1, 'www.google.com', 28),
(85, 1, '2018-12-18 17:13:04', NULL, NULL, 1, 'www.google.com', 29),
(86, 1, '2018-12-18 17:13:04', NULL, NULL, 1, 'www.google.com', 29),
(87, 1, '2018-12-18 17:13:04', NULL, NULL, 1, 'www.google.com', 29),
(88, 1, '2018-12-18 17:13:04', NULL, NULL, 1, 'www.google.com', 30),
(89, 1, '2018-12-18 17:13:04', NULL, NULL, 1, 'www.google.com', 30),
(90, 1, '2018-12-18 17:13:04', NULL, NULL, 1, 'www.google.com', 30),
(91, 1, '2018-12-18 18:10:07', NULL, NULL, 1, 'www.google.com', 31),
(92, 1, '2018-12-18 18:10:07', NULL, NULL, 1, 'www.google.com', 31),
(93, 1, '2018-12-18 18:10:07', NULL, NULL, 1, 'www.google.com', 31),
(94, 1, '2018-12-18 18:10:07', NULL, NULL, 1, 'www.google.com', 32),
(95, 1, '2018-12-18 18:10:07', NULL, NULL, 1, 'www.google.com', 32),
(96, 1, '2018-12-18 18:10:07', NULL, NULL, 1, 'www.google.com', 32),
(97, 1, '2018-12-18 16:39:05', NULL, NULL, 1, 'www.google.com', 33),
(98, 1, '2018-12-18 16:39:05', NULL, NULL, 1, 'www.google.com', 33),
(99, 1, '2018-12-18 16:39:05', NULL, NULL, 1, 'www.google.com', 33),
(100, 1, '2018-12-18 16:39:05', NULL, NULL, 1, 'www.google.com', 34),
(101, 1, '2018-12-18 16:39:05', NULL, NULL, 1, 'www.google.com', 34),
(102, 1, '2018-12-18 16:39:05', NULL, NULL, 1, 'www.google.com', 34),
(103, 1, '2018-12-18 16:43:25', NULL, NULL, 1, 'www.google.com', 35),
(104, 1, '2018-12-18 16:43:25', NULL, NULL, 1, 'www.google.com', 35),
(105, 1, '2018-12-18 16:43:25', NULL, NULL, 1, 'www.google.com', 35),
(106, 1, '2018-12-18 16:43:26', NULL, NULL, 1, 'www.google.com', 36),
(107, 1, '2018-12-18 16:43:26', NULL, NULL, 1, 'www.google.com', 36),
(108, 1, '2018-12-18 16:43:26', NULL, NULL, 1, 'www.google.com', 36),
(109, 1, '2018-12-18 17:01:24', NULL, NULL, 1, 'www.google.com', 37),
(110, 1, '2018-12-18 17:01:24', NULL, NULL, 1, 'www.google.com', 37),
(111, 1, '2018-12-18 17:01:24', NULL, NULL, 1, 'www.google.com', 37),
(112, 1, '2018-12-18 17:01:24', NULL, NULL, 1, 'www.google.com', 38),
(113, 1, '2018-12-18 17:01:24', NULL, NULL, 1, 'www.google.com', 38),
(114, 1, '2018-12-18 17:01:24', NULL, NULL, 1, 'www.google.com', 38),
(115, 1, '2018-12-18 17:13:04', NULL, NULL, 1, 'www.google.com', 39),
(116, 1, '2018-12-18 17:13:04', NULL, NULL, 1, 'www.google.com', 39),
(117, 1, '2018-12-18 17:13:04', NULL, NULL, 1, 'www.google.com', 39),
(118, 1, '2018-12-18 17:13:04', NULL, NULL, 1, 'www.google.com', 40),
(119, 1, '2018-12-18 17:13:04', NULL, NULL, 1, 'www.google.com', 40),
(120, 1, '2018-12-18 17:13:04', NULL, NULL, 1, 'www.google.com', 40),
(121, 1, '2018-12-18 18:10:07', NULL, NULL, 1, 'www.google.com', 41),
(122, 1, '2018-12-18 18:10:07', NULL, NULL, 1, 'www.google.com', 41),
(123, 1, '2018-12-18 18:10:07', NULL, NULL, 1, 'www.google.com', 41),
(124, 1, '2018-12-18 18:10:07', NULL, NULL, 1, 'www.google.com', 42),
(125, 1, '2018-12-18 18:10:07', NULL, NULL, 1, 'www.google.com', 42),
(126, 1, '2018-12-18 18:10:07', NULL, NULL, 1, 'www.google.com', 42),
(127, 1, '2018-12-18 16:39:05', NULL, NULL, 1, 'www.google.com', 43),
(128, 1, '2018-12-18 16:39:05', NULL, NULL, 1, 'www.google.com', 43),
(129, 1, '2018-12-18 16:39:05', NULL, NULL, 1, 'www.google.com', 43),
(130, 1, '2018-12-18 16:39:05', NULL, NULL, 1, 'www.google.com', 44),
(131, 1, '2018-12-18 16:39:05', NULL, NULL, 1, 'www.google.com', 44),
(132, 1, '2018-12-18 16:39:05', NULL, NULL, 1, 'www.google.com', 44),
(133, 1, '2018-12-18 16:43:25', NULL, NULL, 1, 'www.google.com', 45),
(134, 1, '2018-12-18 16:43:25', NULL, NULL, 1, 'www.google.com', 45),
(135, 1, '2018-12-18 16:43:25', NULL, NULL, 1, 'www.google.com', 45),
(136, 1, '2018-12-18 16:43:26', NULL, NULL, 1, 'www.google.com', 46),
(137, 1, '2018-12-18 16:43:26', NULL, NULL, 1, 'www.google.com', 46),
(138, 1, '2018-12-18 16:43:26', NULL, NULL, 1, 'www.google.com', 46),
(139, 1, '2018-12-18 17:01:24', NULL, NULL, 1, 'www.google.com', 47),
(140, 1, '2018-12-18 17:01:24', NULL, NULL, 1, 'www.google.com', 47),
(141, 1, '2018-12-18 17:01:24', NULL, NULL, 1, 'www.google.com', 47),
(142, 1, '2018-12-18 17:01:24', NULL, NULL, 1, 'www.google.com', 48),
(143, 1, '2018-12-18 17:01:24', NULL, NULL, 1, 'www.google.com', 48),
(144, 1, '2018-12-18 17:01:24', NULL, NULL, 1, 'www.google.com', 48),
(145, 1, '2018-12-18 17:13:04', NULL, NULL, 1, 'www.google.com', 49),
(146, 1, '2018-12-18 17:13:04', NULL, NULL, 1, 'www.google.com', 49),
(147, 1, '2018-12-18 17:13:04', NULL, NULL, 1, 'www.google.com', 49),
(148, 1, '2018-12-18 17:13:04', NULL, NULL, 1, 'www.google.com', 50),
(149, 1, '2018-12-18 17:13:04', NULL, NULL, 1, 'www.google.com', 50),
(150, 1, '2018-12-18 17:13:04', NULL, NULL, 1, 'www.google.com', 50),
(151, 1, '2018-12-18 18:10:07', NULL, NULL, 1, 'www.google.com', 51),
(152, 1, '2018-12-18 18:10:07', NULL, NULL, 1, 'www.google.com', 51),
(153, 1, '2018-12-18 18:10:07', NULL, NULL, 1, 'www.google.com', 51),
(154, 1, '2018-12-18 18:10:07', NULL, NULL, 1, 'www.google.com', 52),
(155, 1, '2018-12-18 18:10:07', NULL, NULL, 1, 'www.google.com', 52),
(156, 1, '2018-12-18 18:10:07', NULL, NULL, 1, 'www.google.com', 52),
(157, 1, '2018-12-18 16:39:05', NULL, NULL, 1, 'www.google.com', 53),
(158, 1, '2018-12-18 16:39:05', NULL, NULL, 1, 'www.google.com', 53),
(159, 1, '2018-12-18 16:39:05', NULL, NULL, 1, 'www.google.com', 53),
(160, 1, '2018-12-18 16:39:05', NULL, NULL, 1, 'www.google.com', 54),
(161, 1, '2018-12-18 16:39:05', NULL, NULL, 1, 'www.google.com', 54),
(162, 1, '2018-12-18 16:39:05', NULL, NULL, 1, 'www.google.com', 54),
(163, 1, '2018-12-18 16:43:25', NULL, NULL, 1, 'www.google.com', 55),
(164, 1, '2018-12-18 16:43:25', NULL, NULL, 1, 'www.google.com', 55),
(165, 1, '2018-12-18 16:43:25', NULL, NULL, 1, 'www.google.com', 55),
(166, 1, '2018-12-18 16:43:26', NULL, NULL, 1, 'www.google.com', 56),
(167, 1, '2018-12-18 16:43:26', NULL, NULL, 1, 'www.google.com', 56),
(168, 1, '2018-12-18 16:43:26', NULL, NULL, 1, 'www.google.com', 56),
(169, 1, '2018-12-18 17:01:24', NULL, NULL, 1, 'www.google.com', 57),
(170, 1, '2018-12-18 17:01:24', NULL, NULL, 1, 'www.google.com', 57),
(171, 1, '2018-12-18 17:01:24', NULL, NULL, 1, 'www.google.com', 57),
(172, 1, '2018-12-18 17:01:24', NULL, NULL, 1, 'www.google.com', 58),
(173, 1, '2018-12-18 17:01:24', NULL, NULL, 1, 'www.google.com', 58),
(174, 1, '2018-12-18 17:01:24', NULL, NULL, 1, 'www.google.com', 58),
(175, 1, '2018-12-18 17:13:04', NULL, NULL, 1, 'www.google.com', 59),
(176, 1, '2018-12-18 17:13:04', NULL, NULL, 1, 'www.google.com', 59),
(177, 1, '2018-12-18 17:13:04', NULL, NULL, 1, 'www.google.com', 59),
(178, 1, '2018-12-18 17:13:04', NULL, NULL, 1, 'www.google.com', 60),
(179, 1, '2018-12-18 17:13:04', NULL, NULL, 1, 'www.google.com', 60),
(180, 1, '2018-12-18 17:13:04', NULL, NULL, 1, 'www.google.com', 60),
(181, 1, '2018-12-18 18:10:07', NULL, NULL, 1, 'www.google.com', 61),
(182, 1, '2018-12-18 18:10:07', NULL, NULL, 1, 'www.google.com', 61),
(183, 1, '2018-12-18 18:10:07', NULL, NULL, 1, 'www.google.com', 61),
(184, 1, '2018-12-18 18:10:07', NULL, NULL, 1, 'www.google.com', 62),
(185, 1, '2018-12-18 18:10:07', NULL, NULL, 1, 'www.google.com', 62),
(186, 1, '2018-12-18 18:10:07', NULL, NULL, 1, 'www.google.com', 62),
(187, 1, '2018-12-18 16:39:05', NULL, NULL, 1, 'www.google.com', 63),
(188, 1, '2018-12-18 16:39:05', NULL, NULL, 1, 'www.google.com', 63),
(189, 1, '2018-12-18 16:39:05', NULL, NULL, 1, 'www.google.com', 63),
(190, 1, '2018-12-18 16:39:05', NULL, NULL, 1, 'www.google.com', 64),
(191, 1, '2018-12-18 16:39:05', NULL, NULL, 1, 'www.google.com', 64),
(192, 1, '2018-12-18 16:39:05', NULL, NULL, 1, 'www.google.com', 64),
(193, 1, '2018-12-18 16:43:25', NULL, NULL, 1, 'www.google.com', 65),
(194, 1, '2018-12-18 16:43:25', NULL, NULL, 1, 'www.google.com', 65),
(195, 1, '2018-12-18 16:43:25', NULL, NULL, 1, 'www.google.com', 65),
(196, 1, '2018-12-18 16:43:26', NULL, NULL, 1, 'www.google.com', 66),
(197, 1, '2018-12-18 16:43:26', NULL, NULL, 1, 'www.google.com', 66),
(198, 1, '2018-12-18 16:43:26', NULL, NULL, 1, 'www.google.com', 66),
(199, 1, '2018-12-18 17:01:24', NULL, NULL, 1, 'www.google.com', 67),
(200, 1, '2018-12-18 17:01:24', NULL, NULL, 1, 'www.google.com', 67),
(201, 1, '2018-12-18 17:01:24', NULL, NULL, 1, 'www.google.com', 67),
(202, 1, '2018-12-18 17:01:24', NULL, NULL, 1, 'www.google.com', 68),
(203, 1, '2018-12-18 17:01:24', NULL, NULL, 1, 'www.google.com', 68),
(204, 1, '2018-12-18 17:01:24', NULL, NULL, 1, 'www.google.com', 68),
(205, 1, '2018-12-18 17:13:04', NULL, NULL, 1, 'www.google.com', 69),
(206, 1, '2018-12-18 17:13:04', NULL, NULL, 1, 'www.google.com', 69),
(207, 1, '2018-12-18 17:13:04', NULL, NULL, 1, 'www.google.com', 69),
(208, 1, '2018-12-18 17:13:04', NULL, NULL, 1, 'www.google.com', 70),
(209, 1, '2018-12-18 17:13:04', NULL, NULL, 1, 'www.google.com', 70),
(210, 1, '2018-12-18 17:13:04', NULL, NULL, 1, 'www.google.com', 70),
(211, 1, '2018-12-18 18:10:07', NULL, NULL, 1, 'www.google.com', 71),
(212, 1, '2018-12-18 18:10:07', NULL, NULL, 1, 'www.google.com', 71),
(213, 1, '2018-12-18 18:10:07', NULL, NULL, 1, 'www.google.com', 71),
(214, 1, '2018-12-18 18:10:07', NULL, NULL, 1, 'www.google.com', 72),
(215, 1, '2018-12-18 18:10:07', NULL, NULL, 1, 'www.google.com', 72),
(216, 1, '2018-12-18 18:10:07', NULL, NULL, 1, 'www.google.com', 72),
(217, 1, '2018-12-18 16:39:05', NULL, NULL, 1, 'www.google.com', 73),
(218, 1, '2018-12-18 16:39:05', NULL, NULL, 1, 'www.google.com', 73),
(219, 1, '2018-12-18 16:39:05', NULL, NULL, 1, 'www.google.com', 73),
(220, 1, '2018-12-18 16:39:05', NULL, NULL, 1, 'www.google.com', 74),
(221, 1, '2018-12-18 16:39:05', NULL, NULL, 1, 'www.google.com', 74),
(222, 1, '2018-12-18 16:39:05', NULL, NULL, 1, 'www.google.com', 74),
(223, 1, '2018-12-18 16:43:25', NULL, NULL, 1, 'www.google.com', 75),
(224, 1, '2018-12-18 16:43:25', NULL, NULL, 1, 'www.google.com', 75),
(225, 1, '2018-12-18 16:43:25', NULL, NULL, 1, 'www.google.com', 75),
(226, 1, '2018-12-18 16:43:26', NULL, NULL, 1, 'www.google.com', 76),
(227, 1, '2018-12-18 16:43:26', NULL, NULL, 1, 'www.google.com', 76),
(228, 1, '2018-12-18 16:43:26', NULL, NULL, 1, 'www.google.com', 76),
(229, 1, '2018-12-18 17:01:24', NULL, NULL, 1, 'www.google.com', 77),
(230, 1, '2018-12-18 17:01:24', NULL, NULL, 1, 'www.google.com', 77),
(231, 1, '2018-12-18 17:01:24', NULL, NULL, 1, 'www.google.com', 77),
(232, 1, '2018-12-18 17:01:24', NULL, NULL, 1, 'www.google.com', 78),
(233, 1, '2018-12-18 17:01:24', NULL, NULL, 1, 'www.google.com', 78),
(234, 1, '2018-12-18 17:01:24', NULL, NULL, 1, 'www.google.com', 78),
(235, 1, '2018-12-18 17:13:04', NULL, NULL, 1, 'www.google.com', 79),
(236, 1, '2018-12-18 17:13:04', NULL, NULL, 1, 'www.google.com', 79),
(237, 1, '2018-12-18 17:13:04', NULL, NULL, 1, 'www.google.com', 79),
(238, 1, '2018-12-18 17:13:04', NULL, NULL, 1, 'www.google.com', 80),
(239, 1, '2018-12-18 17:13:04', NULL, NULL, 1, 'www.google.com', 80),
(240, 1, '2018-12-18 17:13:04', NULL, NULL, 1, 'www.google.com', 80),
(241, 1, '2018-12-18 18:10:07', NULL, NULL, 1, 'www.google.com', 81),
(242, 1, '2018-12-18 18:10:07', NULL, NULL, 1, 'www.google.com', 81),
(243, 1, '2018-12-18 18:10:07', NULL, NULL, 1, 'www.google.com', 81),
(244, 1, '2018-12-18 18:10:07', NULL, NULL, 1, 'www.google.com', 82),
(245, 1, '2018-12-18 18:10:07', NULL, NULL, 1, 'www.google.com', 82),
(246, 1, '2018-12-18 18:10:07', NULL, NULL, 1, 'www.google.com', 82),
(247, 1, '2018-12-18 16:39:05', NULL, NULL, 1, 'www.google.com', 83),
(248, 1, '2018-12-18 16:39:05', NULL, NULL, 1, 'www.google.com', 83),
(249, 1, '2018-12-18 16:39:05', NULL, NULL, 1, 'www.google.com', 83),
(250, 1, '2018-12-18 16:39:05', NULL, NULL, 1, 'www.google.com', 84),
(251, 1, '2018-12-18 16:39:05', NULL, NULL, 1, 'www.google.com', 84),
(252, 1, '2018-12-18 16:39:05', NULL, NULL, 1, 'www.google.com', 84),
(253, 1, '2018-12-18 16:43:25', NULL, NULL, 1, 'www.google.com', 85),
(254, 1, '2018-12-18 16:43:25', NULL, NULL, 1, 'www.google.com', 85),
(255, 1, '2018-12-18 16:43:25', NULL, NULL, 1, 'www.google.com', 85),
(256, 1, '2018-12-18 16:43:26', NULL, NULL, 1, 'www.google.com', 86),
(257, 1, '2018-12-18 16:43:26', NULL, NULL, 1, 'www.google.com', 86),
(258, 1, '2018-12-18 16:43:26', NULL, NULL, 1, 'www.google.com', 86),
(259, 1, '2018-12-18 17:01:24', NULL, NULL, 1, 'www.google.com', 87),
(260, 1, '2018-12-18 17:01:24', NULL, NULL, 1, 'www.google.com', 87),
(261, 1, '2018-12-18 17:01:24', NULL, NULL, 1, 'www.google.com', 87),
(262, 1, '2018-12-18 17:01:24', NULL, NULL, 1, 'www.google.com', 88),
(263, 1, '2018-12-18 17:01:24', NULL, NULL, 1, 'www.google.com', 88),
(264, 1, '2018-12-18 17:01:24', NULL, NULL, 1, 'www.google.com', 88),
(265, 1, '2018-12-18 17:13:04', NULL, NULL, 1, 'www.google.com', 89),
(266, 1, '2018-12-18 17:13:04', NULL, NULL, 1, 'www.google.com', 89),
(267, 1, '2018-12-18 17:13:04', NULL, NULL, 1, 'www.google.com', 89),
(268, 1, '2018-12-18 17:13:04', NULL, NULL, 1, 'www.google.com', 90),
(269, 1, '2018-12-18 17:13:04', NULL, NULL, 1, 'www.google.com', 90),
(270, 1, '2018-12-18 17:13:04', NULL, NULL, 1, 'www.google.com', 90),
(271, 1, '2018-12-18 18:10:07', NULL, NULL, 1, 'www.google.com', 91),
(272, 1, '2018-12-18 18:10:07', NULL, NULL, 1, 'www.google.com', 91),
(273, 1, '2018-12-18 18:10:07', NULL, NULL, 1, 'www.google.com', 91),
(274, 1, '2018-12-18 18:10:07', NULL, NULL, 1, 'www.google.com', 92),
(275, 1, '2018-12-18 18:10:07', NULL, NULL, 1, 'www.google.com', 92),
(276, 1, '2018-12-18 18:10:07', NULL, NULL, 1, 'www.google.com', 92),
(277, 1, '2018-12-18 16:39:05', NULL, NULL, 1, 'www.google.com', 93),
(278, 1, '2018-12-18 16:39:05', NULL, NULL, 1, 'www.google.com', 93),
(279, 1, '2018-12-18 16:39:05', NULL, NULL, 1, 'www.google.com', 93),
(280, 1, '2018-12-18 16:39:05', NULL, NULL, 1, 'www.google.com', 94),
(281, 1, '2018-12-18 16:39:05', NULL, NULL, 1, 'www.google.com', 94),
(282, 1, '2018-12-18 16:39:05', NULL, NULL, 1, 'www.google.com', 94),
(283, 1, '2018-12-18 16:43:25', NULL, NULL, 1, 'www.google.com', 95),
(284, 1, '2018-12-18 16:43:25', NULL, NULL, 1, 'www.google.com', 95),
(285, 1, '2018-12-18 16:43:25', NULL, NULL, 1, 'www.google.com', 95),
(286, 1, '2018-12-18 16:43:26', NULL, NULL, 1, 'www.google.com', 96),
(287, 1, '2018-12-18 16:43:26', NULL, NULL, 1, 'www.google.com', 96),
(288, 1, '2018-12-18 16:43:26', NULL, NULL, 1, 'www.google.com', 96),
(289, 1, '2018-12-18 17:01:24', NULL, NULL, 1, 'www.google.com', 97),
(290, 1, '2018-12-18 17:01:24', NULL, NULL, 1, 'www.google.com', 97),
(291, 1, '2018-12-18 17:01:24', NULL, NULL, 1, 'www.google.com', 97),
(292, 1, '2018-12-18 17:01:24', NULL, NULL, 1, 'www.google.com', 98),
(293, 1, '2018-12-18 17:01:24', NULL, NULL, 1, 'www.google.com', 98),
(294, 1, '2018-12-18 17:01:24', NULL, NULL, 1, 'www.google.com', 98),
(295, 1, '2018-12-18 17:13:04', NULL, NULL, 1, 'www.google.com', 99),
(296, 1, '2018-12-18 17:13:04', NULL, NULL, 1, 'www.google.com', 99),
(297, 1, '2018-12-18 17:13:04', NULL, NULL, 1, 'www.google.com', 99),
(298, 1, '2018-12-18 17:13:04', NULL, NULL, 1, 'www.google.com', 100),
(299, 1, '2018-12-18 17:13:04', NULL, NULL, 1, 'www.google.com', 100),
(300, 1, '2018-12-18 17:13:04', NULL, NULL, 1, 'www.google.com', 100),
(301, 1, '2018-12-18 18:10:07', NULL, NULL, 1, 'www.google.com', 101),
(302, 1, '2018-12-18 18:10:07', NULL, NULL, 1, 'www.google.com', 101),
(303, 1, '2018-12-18 18:10:07', NULL, NULL, 1, 'www.google.com', 101),
(304, 1, '2018-12-18 18:10:07', NULL, NULL, 1, 'www.google.com', 102),
(305, 1, '2018-12-18 18:10:07', NULL, NULL, 1, 'www.google.com', 102),
(306, 1, '2018-12-18 18:10:07', NULL, NULL, 1, 'www.google.com', 102),
(307, 1, '2018-12-18 16:39:05', NULL, NULL, 1, 'www.google.com', 103),
(308, 1, '2018-12-18 16:39:05', NULL, NULL, 1, 'www.google.com', 103),
(309, 1, '2018-12-18 16:39:05', NULL, NULL, 1, 'www.google.com', 103),
(310, 1, '2018-12-18 16:39:05', NULL, NULL, 1, 'www.google.com', 104),
(311, 1, '2018-12-18 16:39:05', NULL, NULL, 1, 'www.google.com', 104),
(312, 1, '2018-12-18 16:39:05', NULL, NULL, 1, 'www.google.com', 104),
(313, 1, '2018-12-18 16:43:25', NULL, NULL, 1, 'www.google.com', 105),
(314, 1, '2018-12-18 16:43:25', NULL, NULL, 1, 'www.google.com', 105),
(315, 1, '2018-12-18 16:43:25', NULL, NULL, 1, 'www.google.com', 105),
(316, 1, '2018-12-18 16:43:26', NULL, NULL, 1, 'www.google.com', 106),
(317, 1, '2018-12-18 16:43:26', NULL, NULL, 1, 'www.google.com', 106),
(318, 1, '2018-12-18 16:43:26', NULL, NULL, 1, 'www.google.com', 106),
(319, 1, '2018-12-18 17:01:24', NULL, NULL, 1, 'www.google.com', 107),
(320, 1, '2018-12-18 17:01:24', NULL, NULL, 1, 'www.google.com', 107),
(321, 1, '2018-12-18 17:01:24', NULL, NULL, 1, 'www.google.com', 107),
(322, 1, '2018-12-18 17:01:24', NULL, NULL, 1, 'www.google.com', 108),
(323, 1, '2018-12-18 17:01:24', NULL, NULL, 1, 'www.google.com', 108),
(324, 1, '2018-12-18 17:01:24', NULL, NULL, 1, 'www.google.com', 108),
(325, 1, '2018-12-18 17:13:04', NULL, NULL, 1, 'www.google.com', 109),
(326, 1, '2018-12-18 17:13:04', NULL, NULL, 1, 'www.google.com', 109),
(327, 1, '2018-12-18 17:13:04', NULL, NULL, 1, 'www.google.com', 109),
(328, 1, '2018-12-18 17:13:04', NULL, NULL, 1, 'www.google.com', 110),
(329, 1, '2018-12-18 17:13:04', NULL, NULL, 1, 'www.google.com', 110),
(330, 1, '2018-12-18 17:13:04', NULL, NULL, 1, 'www.google.com', 110),
(331, 1, '2018-12-18 18:10:07', NULL, NULL, 1, 'www.google.com', 111),
(332, 1, '2018-12-18 18:10:07', NULL, NULL, 1, 'www.google.com', 111),
(333, 1, '2018-12-18 18:10:07', NULL, NULL, 1, 'www.google.com', 111),
(334, 1, '2018-12-18 18:10:07', NULL, NULL, 1, 'www.google.com', 112),
(335, 1, '2018-12-18 18:10:07', NULL, NULL, 1, 'www.google.com', 112),
(336, 1, '2018-12-18 18:10:07', NULL, NULL, 1, 'www.google.com', 112),
(337, 1, '2018-12-18 16:39:05', NULL, NULL, 1, 'www.google.com', 113),
(338, 1, '2018-12-18 16:39:05', NULL, NULL, 1, 'www.google.com', 113),
(339, 1, '2018-12-18 16:39:05', NULL, NULL, 1, 'www.google.com', 113),
(340, 1, '2018-12-18 16:39:05', NULL, NULL, 1, 'www.google.com', 114),
(341, 1, '2018-12-18 16:39:05', NULL, NULL, 1, 'www.google.com', 114),
(342, 1, '2018-12-18 16:39:05', NULL, NULL, 1, 'www.google.com', 114),
(343, 1, '2018-12-18 16:43:25', NULL, NULL, 1, 'www.google.com', 115),
(344, 1, '2018-12-18 16:43:25', NULL, NULL, 1, 'www.google.com', 115),
(345, 1, '2018-12-18 16:43:25', NULL, NULL, 1, 'www.google.com', 115),
(346, 1, '2018-12-18 16:43:26', NULL, NULL, 1, 'www.google.com', 116),
(347, 1, '2018-12-18 16:43:26', NULL, NULL, 1, 'www.google.com', 116),
(348, 1, '2018-12-18 16:43:26', NULL, NULL, 1, 'www.google.com', 116),
(349, 1, '2018-12-18 17:01:24', NULL, NULL, 1, 'www.google.com', 117),
(350, 1, '2018-12-18 17:01:24', NULL, NULL, 1, 'www.google.com', 117),
(351, 1, '2018-12-18 17:01:24', NULL, NULL, 1, 'www.google.com', 117),
(352, 1, '2018-12-18 17:01:24', NULL, NULL, 1, 'www.google.com', 118),
(353, 1, '2018-12-18 17:01:24', NULL, NULL, 1, 'www.google.com', 118),
(354, 1, '2018-12-18 17:01:24', NULL, NULL, 1, 'www.google.com', 118),
(355, 1, '2018-12-18 17:13:04', NULL, NULL, 1, 'www.google.com', 119),
(356, 1, '2018-12-18 17:13:04', NULL, NULL, 1, 'www.google.com', 119),
(357, 1, '2018-12-18 17:13:04', NULL, NULL, 1, 'www.google.com', 119),
(358, 1, '2018-12-18 17:13:04', NULL, NULL, 1, 'www.google.com', 120),
(359, 1, '2018-12-18 17:13:04', NULL, NULL, 1, 'www.google.com', 120),
(360, 1, '2018-12-18 17:13:04', NULL, NULL, 1, 'www.google.com', 120),
(361, 1, '2018-12-18 18:10:07', NULL, NULL, 1, 'www.google.com', 121),
(362, 1, '2018-12-18 18:10:07', NULL, NULL, 1, 'www.google.com', 121),
(363, 1, '2018-12-18 18:10:07', NULL, NULL, 1, 'www.google.com', 121),
(364, 1, '2018-12-18 18:10:07', NULL, NULL, 1, 'www.google.com', 122),
(365, 1, '2018-12-18 18:10:07', NULL, NULL, 1, 'www.google.com', 122),
(366, 1, '2018-12-18 18:10:07', NULL, NULL, 1, 'www.google.com', 122),
(367, 1, '2018-12-18 16:39:05', NULL, NULL, 1, 'www.google.com', 123),
(368, 1, '2018-12-18 16:39:05', NULL, NULL, 1, 'www.google.com', 123),
(369, 1, '2018-12-18 16:39:05', NULL, NULL, 1, 'www.google.com', 123),
(370, 1, '2018-12-18 16:39:05', NULL, NULL, 1, 'www.google.com', 124),
(371, 1, '2018-12-18 16:39:05', NULL, NULL, 1, 'www.google.com', 124),
(372, 1, '2018-12-18 16:39:05', NULL, NULL, 1, 'www.google.com', 124),
(373, 1, '2018-12-18 16:43:25', NULL, NULL, 1, 'www.google.com', 125),
(374, 1, '2018-12-18 16:43:25', NULL, NULL, 1, 'www.google.com', 125),
(375, 1, '2018-12-18 16:43:25', NULL, NULL, 1, 'www.google.com', 125),
(376, 1, '2018-12-18 16:43:26', NULL, NULL, 1, 'www.google.com', 126),
(377, 1, '2018-12-18 16:43:26', NULL, NULL, 1, 'www.google.com', 126),
(378, 1, '2018-12-18 16:43:26', NULL, NULL, 1, 'www.google.com', 126),
(379, 1, '2018-12-18 17:01:24', NULL, NULL, 1, 'www.google.com', 127),
(380, 1, '2018-12-18 17:01:24', NULL, NULL, 1, 'www.google.com', 127),
(381, 1, '2018-12-18 17:01:24', NULL, NULL, 1, 'www.google.com', 127),
(382, 1, '2018-12-18 17:01:24', NULL, NULL, 1, 'www.google.com', 128),
(383, 1, '2018-12-18 17:01:24', NULL, NULL, 1, 'www.google.com', 128),
(384, 1, '2018-12-18 17:01:24', NULL, NULL, 1, 'www.google.com', 128),
(385, 1, '2018-12-18 17:13:04', NULL, NULL, 1, 'www.google.com', 129),
(386, 1, '2018-12-18 17:13:04', NULL, NULL, 1, 'www.google.com', 129),
(387, 1, '2018-12-18 17:13:04', NULL, NULL, 1, 'www.google.com', 129),
(388, 1, '2018-12-18 17:13:04', NULL, NULL, 1, 'www.google.com', 130),
(389, 1, '2018-12-18 17:13:04', NULL, NULL, 1, 'www.google.com', 130),
(390, 1, '2018-12-18 17:13:04', NULL, NULL, 1, 'www.google.com', 130),
(391, 1, '2018-12-18 18:10:07', NULL, NULL, 1, 'www.google.com', 131),
(392, 1, '2018-12-18 18:10:07', NULL, NULL, 1, 'www.google.com', 131),
(393, 1, '2018-12-18 18:10:07', NULL, NULL, 1, 'www.google.com', 131),
(394, 1, '2018-12-18 18:10:07', NULL, NULL, 1, 'www.google.com', 132),
(395, 1, '2018-12-18 18:10:07', NULL, NULL, 1, 'www.google.com', 132),
(396, 1, '2018-12-18 18:10:07', NULL, NULL, 1, 'www.google.com', 132),
(397, 1, '2018-12-18 16:39:05', NULL, NULL, 1, 'www.google.com', 133),
(398, 1, '2018-12-18 16:39:05', NULL, NULL, 1, 'www.google.com', 133),
(399, 1, '2018-12-18 16:39:05', NULL, NULL, 1, 'www.google.com', 133),
(400, 1, '2018-12-18 16:39:05', NULL, NULL, 1, 'www.google.com', 134),
(401, 1, '2018-12-18 16:39:05', NULL, NULL, 1, 'www.google.com', 134),
(402, 1, '2018-12-18 16:39:05', NULL, NULL, 1, 'www.google.com', 134),
(403, 1, '2018-12-18 16:43:25', NULL, NULL, 1, 'www.google.com', 135),
(404, 1, '2018-12-18 16:43:25', NULL, NULL, 1, 'www.google.com', 135),
(405, 1, '2018-12-18 16:43:25', NULL, NULL, 1, 'www.google.com', 135),
(406, 1, '2018-12-18 16:43:26', NULL, NULL, 1, 'www.google.com', 136),
(407, 1, '2018-12-18 16:43:26', NULL, NULL, 1, 'www.google.com', 136),
(408, 1, '2018-12-18 16:43:26', NULL, NULL, 1, 'www.google.com', 136),
(409, 1, '2018-12-18 17:01:24', NULL, NULL, 1, 'www.google.com', 137),
(410, 1, '2018-12-18 17:01:24', NULL, NULL, 1, 'www.google.com', 137),
(411, 1, '2018-12-18 17:01:24', NULL, NULL, 1, 'www.google.com', 137),
(412, 1, '2018-12-18 17:01:24', NULL, NULL, 1, 'www.google.com', 138),
(413, 1, '2018-12-18 17:01:24', NULL, NULL, 1, 'www.google.com', 138),
(414, 1, '2018-12-18 17:01:24', NULL, NULL, 1, 'www.google.com', 138),
(415, 1, '2018-12-18 17:13:04', NULL, NULL, 1, 'www.google.com', 139),
(416, 1, '2018-12-18 17:13:04', NULL, NULL, 1, 'www.google.com', 139),
(417, 1, '2018-12-18 17:13:04', NULL, NULL, 1, 'www.google.com', 139),
(418, 1, '2018-12-18 17:13:04', NULL, NULL, 1, 'www.google.com', 140),
(419, 1, '2018-12-18 17:13:04', NULL, NULL, 1, 'www.google.com', 140),
(420, 1, '2018-12-18 17:13:04', NULL, NULL, 1, 'www.google.com', 140),
(421, 1, '2018-12-18 18:10:07', NULL, NULL, 1, 'www.google.com', 141),
(422, 1, '2018-12-18 18:10:07', NULL, NULL, 1, 'www.google.com', 141),
(423, 1, '2018-12-18 18:10:07', NULL, NULL, 1, 'www.google.com', 141),
(424, 1, '2018-12-18 18:10:07', NULL, NULL, 1, 'www.google.com', 142),
(425, 1, '2018-12-18 18:10:07', NULL, NULL, 1, 'www.google.com', 142),
(426, 1, '2018-12-18 18:10:07', NULL, NULL, 1, 'www.google.com', 142),
(427, 1, '2018-12-18 16:39:05', NULL, NULL, 1, 'www.google.com', 143),
(428, 1, '2018-12-18 16:39:05', NULL, NULL, 1, 'www.google.com', 143),
(429, 1, '2018-12-18 16:39:05', NULL, NULL, 1, 'www.google.com', 143),
(430, 1, '2018-12-18 16:39:05', NULL, NULL, 1, 'www.google.com', 144),
(431, 1, '2018-12-18 16:39:05', NULL, NULL, 1, 'www.google.com', 144),
(432, 1, '2018-12-18 16:39:05', NULL, NULL, 1, 'www.google.com', 144),
(433, 1, '2018-12-18 16:43:25', NULL, NULL, 1, 'www.google.com', 145),
(434, 1, '2018-12-18 16:43:25', NULL, NULL, 1, 'www.google.com', 145),
(435, 1, '2018-12-18 16:43:25', NULL, NULL, 1, 'www.google.com', 145),
(436, 1, '2018-12-18 16:43:26', NULL, NULL, 1, 'www.google.com', 146),
(437, 1, '2018-12-18 16:43:26', NULL, NULL, 1, 'www.google.com', 146),
(438, 1, '2018-12-18 16:43:26', NULL, NULL, 1, 'www.google.com', 146),
(439, 1, '2018-12-18 17:01:24', NULL, NULL, 1, 'www.google.com', 147),
(440, 1, '2018-12-18 17:01:24', NULL, NULL, 1, 'www.google.com', 147),
(441, 1, '2018-12-18 17:01:24', NULL, NULL, 1, 'www.google.com', 147),
(442, 1, '2018-12-18 17:01:24', NULL, NULL, 1, 'www.google.com', 148),
(443, 1, '2018-12-18 17:01:24', NULL, NULL, 1, 'www.google.com', 148),
(444, 1, '2018-12-18 17:01:24', NULL, NULL, 1, 'www.google.com', 148),
(445, 1, '2018-12-18 17:13:04', NULL, NULL, 1, 'www.google.com', 149),
(446, 1, '2018-12-18 17:13:04', NULL, NULL, 1, 'www.google.com', 149),
(447, 1, '2018-12-18 17:13:04', NULL, NULL, 1, 'www.google.com', 149),
(448, 1, '2018-12-18 17:13:04', NULL, NULL, 1, 'www.google.com', 150),
(449, 1, '2018-12-18 17:13:04', NULL, NULL, 1, 'www.google.com', 150),
(450, 1, '2018-12-18 17:13:04', NULL, NULL, 1, 'www.google.com', 150),
(451, 1, '2018-12-18 18:10:07', NULL, NULL, 1, 'www.google.com', 151),
(452, 1, '2018-12-18 18:10:07', NULL, NULL, 1, 'www.google.com', 151),
(453, 1, '2018-12-18 18:10:07', NULL, NULL, 1, 'www.google.com', 151),
(454, 1, '2018-12-18 18:10:07', NULL, NULL, 1, 'www.google.com', 152),
(455, 1, '2018-12-18 18:10:07', NULL, NULL, 1, 'www.google.com', 152),
(456, 1, '2018-12-18 18:10:07', NULL, NULL, 1, 'www.google.com', 152),
(457, 1, '2018-12-18 16:39:05', NULL, NULL, 1, 'www.google.com', 153),
(458, 1, '2018-12-18 16:39:05', NULL, NULL, 1, 'www.google.com', 153),
(459, 1, '2018-12-18 16:39:05', NULL, NULL, 1, 'www.google.com', 153),
(460, 1, '2018-12-18 16:39:05', NULL, NULL, 1, 'www.google.com', 154),
(461, 1, '2018-12-18 16:39:05', NULL, NULL, 1, 'www.google.com', 154),
(462, 1, '2018-12-18 16:39:05', NULL, NULL, 1, 'www.google.com', 154),
(463, 1, '2018-12-18 16:43:25', NULL, NULL, 1, 'www.google.com', 155),
(464, 1, '2018-12-18 16:43:25', NULL, NULL, 1, 'www.google.com', 155),
(465, 1, '2018-12-18 16:43:25', NULL, NULL, 1, 'www.google.com', 155),
(466, 1, '2018-12-18 16:43:26', NULL, NULL, 1, 'www.google.com', 156),
(467, 1, '2018-12-18 16:43:26', NULL, NULL, 1, 'www.google.com', 156),
(468, 1, '2018-12-18 16:43:26', NULL, NULL, 1, 'www.google.com', 156),
(469, 1, '2018-12-18 17:01:24', NULL, NULL, 1, 'www.google.com', 157),
(470, 1, '2018-12-18 17:01:24', NULL, NULL, 1, 'www.google.com', 157),
(471, 1, '2018-12-18 17:01:24', NULL, NULL, 1, 'www.google.com', 157),
(472, 1, '2018-12-18 17:01:24', NULL, NULL, 1, 'www.google.com', 158),
(473, 1, '2018-12-18 17:01:24', NULL, NULL, 1, 'www.google.com', 158),
(474, 1, '2018-12-18 17:01:24', NULL, NULL, 1, 'www.google.com', 158),
(475, 1, '2018-12-18 17:13:04', NULL, NULL, 1, 'www.google.com', 159),
(476, 1, '2018-12-18 17:13:04', NULL, NULL, 1, 'www.google.com', 159),
(477, 1, '2018-12-18 17:13:04', NULL, NULL, 1, 'www.google.com', 159),
(478, 1, '2018-12-18 17:13:04', NULL, NULL, 1, 'www.google.com', 160),
(479, 1, '2018-12-18 17:13:04', NULL, NULL, 1, 'www.google.com', 160),
(480, 1, '2018-12-18 17:13:04', NULL, NULL, 1, 'www.google.com', 160),
(481, 1, '2018-12-18 18:10:07', NULL, NULL, 1, 'www.google.com', 161),
(482, 1, '2018-12-18 18:10:07', NULL, NULL, 1, 'www.google.com', 161),
(483, 1, '2018-12-18 18:10:07', NULL, NULL, 1, 'www.google.com', 161);

-- --------------------------------------------------------

--
-- Table structure for table `room_vs_meal`
--

CREATE TABLE `room_vs_meal` (
  `room_vs_meal_id` bigint(20) NOT NULL,
  `created_by` bigint(20) DEFAULT NULL,
  `created_date` varchar(255) DEFAULT NULL,
  `modified_by` bigint(20) DEFAULT NULL,
  `modified_date` varchar(255) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `meal_days_sunday` varchar(255) DEFAULT NULL,
  `meal_days_monday` varchar(255) DEFAULT NULL,
  `meal_days_tuesday` varchar(255) DEFAULT NULL,
  `meal_days_wednesday` varchar(255) DEFAULT NULL,
  `meal_days_thursday` varchar(255) DEFAULT NULL,
  `meal_days_friday` varchar(255) DEFAULT NULL,
  `meal_days_saturday` varchar(255) DEFAULT NULL,
  `meal_price_category_sunday` varchar(255) DEFAULT NULL,
  `meal_price_category_monday` varchar(255) DEFAULT NULL,
  `meal_price_category_tuesday` varchar(255) DEFAULT NULL,
  `meal_price_category_wednesday` varchar(255) DEFAULT NULL,
  `meal_price_category_thursday` varchar(255) DEFAULT NULL,
  `meal_price_category_friday` varchar(255) DEFAULT NULL,
  `meal_price_category_saturday` varchar(255) DEFAULT NULL,
  `meal_type_sunday` varchar(255) DEFAULT NULL,
  `meal_type_monday` varchar(255) DEFAULT NULL,
  `meal_type_tuesday` varchar(255) DEFAULT NULL,
  `meal_type_wednesday` varchar(255) DEFAULT NULL,
  `meal_type_thursday` varchar(255) DEFAULT NULL,
  `meal_type_friday` varchar(255) DEFAULT NULL,
  `meal_type_saturday` varchar(255) DEFAULT NULL,
  `meal_plan_id` bigint(20) NOT NULL,
  `room_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `room_vs_meal`
--

INSERT INTO `room_vs_meal` (`room_vs_meal_id`, `created_by`, `created_date`, `modified_by`, `modified_date`, `status`, `meal_days_sunday`, `meal_days_monday`, `meal_days_tuesday`, `meal_days_wednesday`, `meal_days_thursday`, `meal_days_friday`, `meal_days_saturday`, `meal_price_category_sunday`, `meal_price_category_monday`, `meal_price_category_tuesday`, `meal_price_category_wednesday`, `meal_price_category_thursday`, `meal_price_category_friday`, `meal_price_category_saturday`, `meal_type_sunday`, `meal_type_monday`, `meal_type_tuesday`, `meal_type_wednesday`, `meal_type_thursday`, `meal_type_friday`, `meal_type_saturday`, `meal_plan_id`, `room_id`) VALUES
(1, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 1, 1),
(2, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 2, 1),
(3, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 3, 1),
(4, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 4, 1),
(5, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 1, 2),
(6, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 2, 2),
(7, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 3, 2),
(8, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 4, 2),
(9, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 1, 3),
(10, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 2, 3),
(11, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 3, 3),
(12, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 4, 3),
(13, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 1, 4),
(14, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 2, 4),
(15, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 3, 4),
(16, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 4, 4),
(17, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 1, 5),
(18, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 2, 5),
(19, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 3, 5),
(20, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 4, 5),
(21, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 1, 6),
(22, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 2, 6),
(23, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 3, 6),
(24, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 4, 6),
(25, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 1, 7),
(26, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 2, 7),
(27, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 3, 7),
(28, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 4, 7),
(29, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 1, 8),
(30, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 2, 8),
(31, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 3, 8),
(32, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 4, 8),
(33, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 1, 9),
(34, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 2, 9),
(35, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 3, 9),
(36, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 4, 9),
(37, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 1, 10),
(38, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 2, 10),
(39, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 3, 10),
(40, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 4, 10),
(41, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 1, 11),
(42, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 2, 11),
(43, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 3, 11),
(44, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 4, 11),
(45, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 1, 12),
(46, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 2, 12),
(47, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 3, 12),
(48, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 4, 12),
(49, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 1, 13),
(50, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 2, 13),
(51, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 3, 13),
(52, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 4, 13),
(53, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 1, 14),
(54, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 2, 14),
(55, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 3, 14),
(56, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 4, 14),
(57, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 1, 15),
(58, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 2, 15),
(59, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 3, 15),
(60, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 4, 15),
(61, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 1, 16),
(62, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 2, 16),
(63, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 3, 16),
(64, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 4, 16),
(65, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 1, 17),
(66, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 2, 17),
(67, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 3, 17),
(68, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 4, 17),
(69, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 1, 18),
(70, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 2, 18),
(71, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 3, 18),
(72, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 4, 18),
(73, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 1, 19),
(74, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 2, 19),
(75, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 3, 19),
(76, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 4, 29),
(77, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 1, 20),
(78, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 2, 20),
(79, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 3, 20),
(80, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 4, 20),
(81, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 1, 21),
(82, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 2, 21),
(83, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 3, 21),
(84, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 4, 21),
(85, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 1, 22),
(86, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 2, 22),
(87, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 3, 22),
(88, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 4, 22),
(89, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 1, 23),
(90, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 2, 23),
(91, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 3, 23),
(92, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 4, 23),
(93, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 1, 24),
(94, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 2, 24),
(95, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 3, 24),
(96, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 4, 24),
(97, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 1, 25),
(98, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 2, 25),
(99, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 3, 25),
(100, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 4, 25),
(101, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 1, 26),
(102, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 2, 26),
(103, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 3, 26),
(104, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 4, 26),
(105, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 1, 27),
(106, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 2, 27),
(107, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 3, 27),
(108, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 4, 27),
(109, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 1, 28),
(110, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 2, 28),
(111, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 3, 28),
(112, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 4, 28),
(113, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 1, 29),
(114, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 2, 29),
(115, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 3, 29),
(116, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 4, 29),
(117, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 1, 30),
(118, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 2, 30),
(119, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 3, 30),
(120, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 4, 30),
(121, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 1, 31),
(122, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 2, 31),
(123, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 3, 31),
(124, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 4, 31),
(125, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 1, 32),
(126, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 2, 32),
(127, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 3, 32),
(128, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 4, 32),
(129, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 1, 33),
(130, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 2, 33),
(131, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 3, 33),
(132, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 4, 33),
(133, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 1, 34),
(134, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 2, 34),
(135, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 3, 34),
(136, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 4, 34),
(137, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 1, 35),
(138, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 2, 35),
(139, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 3, 35),
(140, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 4, 35),
(141, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 1, 36),
(142, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 2, 36),
(143, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 3, 36),
(144, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 4, 36),
(145, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 1, 37),
(146, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 2, 37),
(147, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 3, 37),
(148, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 4, 37),
(149, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 1, 38),
(150, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 2, 38),
(151, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 3, 38),
(152, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 4, 38),
(153, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 1, 39),
(154, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 2, 39),
(155, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 3, 39),
(156, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 4, 39),
(157, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 1, 40),
(158, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 2, 40),
(159, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 3, 40),
(160, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 4, 40),
(161, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 1, 41),
(162, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 2, 41),
(163, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 3, 41),
(164, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 4, 41),
(165, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 1, 42),
(166, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 2, 42),
(167, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 3, 42),
(168, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 4, 42),
(169, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 1, 43),
(170, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 2, 43),
(171, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 3, 43),
(172, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 4, 43),
(173, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 1, 44),
(174, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 2, 44),
(175, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 3, 44),
(176, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 4, 44),
(177, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 1, 45),
(178, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 2, 45),
(179, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 3, 45),
(180, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 4, 45),
(181, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 1, 46),
(182, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 2, 46),
(183, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 3, 46),
(184, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 4, 46),
(185, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 1, 47),
(186, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 2, 47),
(187, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 3, 47),
(188, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 4, 47),
(189, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 1, 48),
(190, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 2, 48),
(191, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 3, 48),
(192, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 4, 48),
(193, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 1, 49),
(194, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 2, 49),
(195, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 3, 49),
(196, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 4, 49),
(197, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 1, 50),
(198, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 2, 50),
(199, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 3, 50),
(200, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 4, 50),
(201, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 1, 51),
(202, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 2, 51),
(203, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 3, 51),
(204, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 4, 51),
(205, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 1, 52),
(206, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 2, 52),
(207, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 3, 52),
(208, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 4, 52),
(209, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 1, 53),
(210, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 2, 53),
(211, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 3, 53),
(212, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 4, 53),
(213, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 1, 54),
(214, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 2, 54),
(215, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 3, 54),
(216, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 4, 54),
(217, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 1, 55),
(218, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 2, 55),
(219, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 3, 55),
(220, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 4, 55),
(221, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 1, 56),
(222, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 2, 56),
(223, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 3, 56),
(224, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 4, 56),
(225, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 1, 57),
(226, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 2, 57),
(227, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 3, 57),
(228, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 4, 57),
(229, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 1, 58),
(230, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 2, 58),
(231, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 3, 58),
(232, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 4, 58),
(233, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 1, 59),
(234, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 2, 59),
(235, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 3, 59),
(236, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 4, 59),
(237, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 1, 60),
(238, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 2, 60),
(239, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 3, 60),
(240, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 4, 60),
(241, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 1, 61);
INSERT INTO `room_vs_meal` (`room_vs_meal_id`, `created_by`, `created_date`, `modified_by`, `modified_date`, `status`, `meal_days_sunday`, `meal_days_monday`, `meal_days_tuesday`, `meal_days_wednesday`, `meal_days_thursday`, `meal_days_friday`, `meal_days_saturday`, `meal_price_category_sunday`, `meal_price_category_monday`, `meal_price_category_tuesday`, `meal_price_category_wednesday`, `meal_price_category_thursday`, `meal_price_category_friday`, `meal_price_category_saturday`, `meal_type_sunday`, `meal_type_monday`, `meal_type_tuesday`, `meal_type_wednesday`, `meal_type_thursday`, `meal_type_friday`, `meal_type_saturday`, `meal_plan_id`, `room_id`) VALUES
(242, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 2, 61),
(243, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 3, 61),
(244, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 4, 61),
(245, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 1, 62),
(246, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 2, 62),
(247, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 3, 62),
(248, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 4, 62),
(249, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 1, 63),
(250, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 2, 63),
(251, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 3, 63),
(252, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 4, 63),
(253, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 1, 64),
(254, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 2, 64),
(255, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 3, 64),
(256, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 4, 64),
(257, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 1, 65),
(258, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 2, 65),
(259, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 3, 65),
(260, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 4, 65),
(261, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 1, 66),
(262, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 2, 66),
(263, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 3, 66),
(264, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 4, 66),
(265, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 1, 67),
(266, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 2, 67),
(267, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 3, 67),
(268, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 4, 67),
(269, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 1, 68),
(270, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 2, 68),
(271, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 3, 68),
(272, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 4, 68),
(273, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 1, 69),
(274, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 2, 69),
(275, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 3, 69),
(276, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 4, 69),
(277, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 1, 70),
(278, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 2, 70),
(279, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 3, 70),
(280, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 4, 70),
(281, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 1, 71),
(282, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 2, 71),
(283, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 3, 71),
(284, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 4, 71),
(285, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 1, 72),
(286, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 2, 72),
(287, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 3, 72),
(288, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 4, 72),
(289, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 1, 73),
(290, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 2, 73),
(291, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 3, 73),
(292, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 4, 73),
(293, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 1, 74),
(294, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 2, 74),
(295, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 3, 74),
(296, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 4, 74),
(297, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 1, 75),
(298, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 2, 75),
(299, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 3, 75),
(300, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 4, 75),
(301, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 1, 76),
(302, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 2, 76),
(303, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 3, 76),
(304, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 4, 76),
(305, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 1, 77),
(306, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 2, 77),
(307, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 3, 77),
(308, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 4, 77),
(309, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 1, 78),
(310, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 2, 78),
(311, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 3, 78),
(312, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 4, 78),
(313, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 1, 79),
(314, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 2, 79),
(315, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 3, 79),
(316, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 4, 79),
(317, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 1, 80),
(318, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 2, 80),
(319, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 3, 80),
(320, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 4, 80),
(321, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 1, 81),
(322, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 2, 81),
(323, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 3, 81),
(324, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 4, 81),
(325, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 1, 82),
(326, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 2, 82),
(327, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 3, 82),
(328, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 4, 82),
(329, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 1, 83),
(330, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 2, 83),
(331, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 3, 83),
(332, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 4, 83),
(333, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 1, 84),
(334, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 2, 84),
(335, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 3, 84),
(336, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 4, 84),
(337, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 1, 85),
(338, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 2, 85),
(339, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 3, 85),
(340, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 4, 85),
(341, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 1, 86),
(342, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 2, 86),
(343, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 3, 86),
(344, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 4, 86),
(345, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 1, 87),
(346, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 2, 87),
(347, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 3, 87),
(348, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 4, 87),
(349, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 1, 88),
(350, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 2, 88),
(351, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 3, 88),
(352, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 4, 88),
(353, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 1, 89),
(354, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 2, 89),
(355, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 3, 89),
(356, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 4, 89),
(357, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 1, 90),
(358, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 2, 90),
(359, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 3, 90),
(360, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 4, 90),
(361, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 1, 91),
(362, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 2, 91),
(363, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 3, 91),
(364, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 4, 91),
(365, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 1, 92),
(366, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 2, 92),
(367, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 3, 92),
(368, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 4, 92),
(369, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 1, 93),
(370, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 2, 93),
(371, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 3, 93),
(372, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 4, 93),
(373, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 1, 94),
(374, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 2, 94),
(375, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 3, 94),
(376, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 4, 94),
(377, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 1, 95),
(378, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 2, 95),
(379, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 3, 95),
(380, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 4, 95),
(381, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 1, 96),
(382, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 2, 96),
(383, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 3, 96),
(384, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 4, 96),
(385, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 1, 97),
(386, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 2, 97),
(387, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 3, 97),
(388, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 4, 97),
(389, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 1, 98),
(390, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 2, 98),
(391, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 3, 98),
(392, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 4, 98),
(393, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 1, 99),
(394, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 2, 99),
(395, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 3, 99),
(396, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 4, 99),
(397, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 1, 100),
(398, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 2, 100),
(399, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 3, 100),
(400, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 4, 100),
(401, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 1, 101),
(402, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 2, 101),
(403, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 3, 101),
(404, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 4, 101),
(405, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 1, 102),
(406, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 2, 102),
(407, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 3, 102),
(408, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 4, 102),
(409, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 1, 103),
(410, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 2, 103),
(411, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 3, 103),
(412, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 4, 103),
(413, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 1, 104),
(414, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 2, 104),
(415, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 3, 104),
(416, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 4, 104),
(417, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 1, 105),
(418, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 2, 105),
(419, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 3, 105),
(420, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 4, 105),
(421, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 1, 106),
(422, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 2, 106),
(423, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 3, 106),
(424, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 4, 106),
(425, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 1, 107),
(426, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 2, 107),
(427, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 3, 107),
(428, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 4, 107),
(429, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 1, 108),
(430, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 2, 108),
(431, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 3, 108),
(432, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 4, 108),
(433, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 1, 109),
(434, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 2, 109),
(435, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 3, 109),
(436, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 4, 109),
(437, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 1, 110),
(438, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 2, 110),
(439, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 3, 110),
(440, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 4, 110),
(441, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 1, 111),
(442, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 2, 111),
(443, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 3, 111),
(444, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 4, 111),
(445, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 1, 112),
(446, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 2, 112),
(447, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 3, 112),
(448, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 4, 112),
(449, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 1, 113),
(450, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 2, 113),
(451, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 3, 113),
(452, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 4, 113),
(453, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 1, 114),
(454, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 2, 114),
(455, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 3, 114),
(456, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 4, 114),
(457, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 1, 115),
(458, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 2, 115),
(459, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 3, 115),
(460, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 4, 115),
(461, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 1, 116),
(462, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 2, 116),
(463, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 3, 116),
(464, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 4, 116),
(465, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 1, 117),
(466, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 2, 117),
(467, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 3, 117),
(468, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 4, 117),
(469, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 1, 118),
(470, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 2, 118),
(471, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 3, 118),
(472, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 4, 118),
(473, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 1, 119),
(474, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 2, 119),
(475, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 3, 119),
(476, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 4, 119),
(477, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 1, 120),
(478, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 2, 120),
(479, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 3, 120),
(480, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 4, 120),
(481, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 1, 121);
INSERT INTO `room_vs_meal` (`room_vs_meal_id`, `created_by`, `created_date`, `modified_by`, `modified_date`, `status`, `meal_days_sunday`, `meal_days_monday`, `meal_days_tuesday`, `meal_days_wednesday`, `meal_days_thursday`, `meal_days_friday`, `meal_days_saturday`, `meal_price_category_sunday`, `meal_price_category_monday`, `meal_price_category_tuesday`, `meal_price_category_wednesday`, `meal_price_category_thursday`, `meal_price_category_friday`, `meal_price_category_saturday`, `meal_type_sunday`, `meal_type_monday`, `meal_type_tuesday`, `meal_type_wednesday`, `meal_type_thursday`, `meal_type_friday`, `meal_type_saturday`, `meal_plan_id`, `room_id`) VALUES
(482, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 2, 121),
(483, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 3, 121),
(484, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 4, 121),
(485, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 1, 122),
(486, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 2, 122),
(487, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 3, 122),
(488, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 4, 122),
(489, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 1, 123),
(490, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 2, 123),
(491, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 3, 123),
(492, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 4, 123),
(493, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 1, 124),
(494, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 2, 124),
(495, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 3, 124),
(496, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 4, 124),
(497, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 1, 125),
(498, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 2, 125),
(499, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 3, 125),
(500, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 4, 125),
(501, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 1, 126),
(502, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 2, 126),
(503, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 3, 126),
(504, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 4, 126),
(505, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 1, 127),
(506, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 2, 127),
(507, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 3, 127),
(508, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 4, 127),
(509, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 1, 128),
(510, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 2, 128),
(511, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 3, 128),
(512, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 4, 128),
(513, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 1, 129),
(514, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 2, 129),
(515, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 3, 129),
(516, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 4, 129),
(517, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 1, 130),
(518, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 2, 130),
(519, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 3, 130),
(520, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 4, 130),
(521, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 1, 131),
(522, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 2, 131),
(523, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 3, 131),
(524, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 4, 131),
(525, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 1, 132),
(526, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 2, 132),
(527, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 3, 132),
(528, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 4, 132),
(529, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 1, 133),
(530, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 2, 133),
(531, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 3, 133),
(532, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 4, 133),
(533, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 1, 134),
(534, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 2, 134),
(535, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 3, 134),
(536, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 4, 134),
(537, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 1, 135),
(538, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 2, 135),
(539, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 3, 135),
(540, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 4, 135),
(541, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 1, 136),
(542, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 2, 136),
(543, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 3, 136),
(544, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 4, 136),
(545, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 1, 137),
(546, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 2, 137),
(547, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 3, 137),
(548, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 4, 137),
(549, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 1, 138),
(550, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 2, 138),
(551, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 3, 138),
(552, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 4, 138),
(553, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 1, 139),
(554, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 2, 139),
(555, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 3, 139),
(556, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 4, 139),
(557, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 1, 140),
(558, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 2, 140),
(559, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 3, 140),
(560, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 4, 140),
(561, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 1, 141),
(562, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 2, 141),
(563, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 3, 141),
(564, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 4, 141),
(565, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 1, 142),
(566, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 2, 142),
(567, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 3, 142),
(568, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 4, 142),
(569, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 1, 143),
(570, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 2, 143),
(571, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 3, 143),
(572, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 4, 143),
(573, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 1, 144),
(574, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 2, 144),
(575, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 3, 144),
(576, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 4, 144),
(577, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 1, 145),
(578, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 2, 145),
(579, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 3, 145),
(580, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 4, 145),
(581, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 1, 146),
(582, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 2, 146),
(583, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 3, 146),
(584, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 4, 146),
(585, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 1, 147),
(586, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 2, 147),
(587, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 3, 147),
(588, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 4, 147),
(589, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 1, 148),
(590, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 2, 148),
(591, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 3, 148),
(592, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 4, 148),
(593, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 1, 149),
(594, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 2, 149),
(595, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 3, 149),
(596, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 4, 149),
(597, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 1, 150),
(598, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 2, 150),
(599, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 3, 150),
(600, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 4, 150),
(601, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 1, 151),
(602, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 2, 151),
(603, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 3, 151),
(604, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 4, 151),
(605, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 1, 152),
(606, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 2, 152),
(607, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 3, 152),
(608, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 4, 152),
(609, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 1, 153),
(610, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 2, 153),
(611, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 3, 153),
(612, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 4, 153),
(613, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 1, 154),
(614, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 2, 154),
(615, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 3, 154),
(616, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 4, 154),
(617, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 1, 155),
(618, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 2, 155),
(619, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 3, 155),
(620, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 4, 155),
(621, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 1, 156),
(622, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 2, 156),
(623, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 3, 156),
(624, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 4, 156),
(625, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 1, 157),
(626, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 2, 157),
(627, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 3, 157),
(628, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 4, 157),
(629, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 1, 158),
(630, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 2, 158),
(631, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 3, 158),
(632, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 4, 158),
(633, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 1, 159),
(634, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 2, 159),
(635, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 3, 159),
(636, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 4, 159),
(637, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 1, 160),
(638, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 2, 160),
(639, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 3, 160),
(640, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 4, 160),
(641, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 1, 161),
(642, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 2, 161),
(643, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 3, 161),
(644, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'FREE', 'BOTH', 'VEG', 'NONVEGBOTH', 'BOTH', 'BOTH', 'BOTH', 4, 161);

-- --------------------------------------------------------

--
-- Table structure for table `room_vs_offer`
--

CREATE TABLE `room_vs_offer` (
  `room_vs_offer_id` bigint(20) NOT NULL,
  `created_by` bigint(20) DEFAULT NULL,
  `created_date` varchar(255) DEFAULT NULL,
  `modified_by` bigint(20) DEFAULT NULL,
  `modified_date` varchar(255) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `offer_id` bigint(20) NOT NULL,
  `room_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `room_vs_offer`
--

INSERT INTO `room_vs_offer` (`room_vs_offer_id`, `created_by`, `created_date`, `modified_by`, `modified_date`, `status`, `offer_id`, `room_id`) VALUES
(1, 1, '2018-12-18 16:39:05', NULL, NULL, 1, 1, 1);

-- --------------------------------------------------------

--
-- Table structure for table `room_vs_specialties`
--

CREATE TABLE `room_vs_specialties` (
  `roomspec_id` bigint(20) NOT NULL,
  `created_by` bigint(20) DEFAULT NULL,
  `created_date` varchar(255) DEFAULT NULL,
  `modified_by` bigint(20) DEFAULT NULL,
  `modified_date` varchar(255) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `room_id` bigint(20) NOT NULL,
  `specialties_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `room_vs_specialties`
--

INSERT INTO `room_vs_specialties` (`roomspec_id`, `created_by`, `created_date`, `modified_by`, `modified_date`, `status`, `room_id`, `specialties_id`) VALUES
(1, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 1, 1),
(2, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 1, 2),
(3, 1, '2018-12-18 14:54:27', NULL, NULL, 1, 2, 2),
(4, 1, '2018-12-18 15:01:13', NULL, NULL, 1, 3, 1),
(5, 1, '2018-12-18 15:01:13', NULL, NULL, 1, 3, 2),
(6, 1, '2018-12-18 15:01:14', NULL, NULL, 1, 4, 2),
(7, 1, '2018-12-18 15:02:06', NULL, NULL, 1, 5, 1),
(8, 1, '2018-12-18 15:02:06', NULL, NULL, 1, 5, 2),
(9, 1, '2018-12-18 15:02:07', NULL, NULL, 1, 6, 2),
(10, 1, '2018-12-18 15:19:02', NULL, NULL, 1, 7, 1),
(11, 1, '2018-12-18 15:19:02', NULL, NULL, 1, 7, 2),
(12, 1, '2018-12-18 15:19:03', NULL, NULL, 1, 8, 2),
(13, 1, '2018-12-18 16:05:15', NULL, NULL, 1, 9, 1),
(14, 1, '2018-12-18 16:05:15', NULL, NULL, 1, 9, 2),
(15, 1, '2018-12-18 16:05:16', NULL, NULL, 1, 10, 2),
(16, 1, '2018-12-18 16:09:49', NULL, NULL, 1, 11, 1),
(17, 1, '2018-12-18 16:09:49', NULL, NULL, 1, 11, 2),
(18, 1, '2018-12-18 16:09:49', NULL, NULL, 1, 12, 2),
(19, 1, '2018-12-18 16:10:02', NULL, NULL, 1, 13, 1),
(20, 1, '2018-12-18 16:10:02', NULL, NULL, 1, 13, 2),
(21, 1, '2018-12-18 16:10:02', NULL, NULL, 1, 14, 2),
(22, 1, '2018-12-18 16:15:08', NULL, NULL, 1, 15, 1),
(23, 1, '2018-12-18 16:15:08', NULL, NULL, 1, 15, 2),
(24, 1, '2018-12-18 16:15:08', NULL, NULL, 1, 16, 2),
(25, 1, '2018-12-18 16:24:19', NULL, NULL, 1, 17, 1),
(26, 1, '2018-12-18 16:24:19', NULL, NULL, 1, 17, 2),
(27, 1, '2018-12-18 16:24:20', NULL, NULL, 1, 18, 2),
(28, 1, '2018-12-18 16:25:19', NULL, NULL, 1, 19, 1),
(29, 1, '2018-12-18 16:25:19', NULL, NULL, 1, 19, 2),
(30, 1, '2018-12-18 16:25:19', NULL, NULL, 1, 20, 2),
(31, 1, '2018-12-18 16:36:57', NULL, NULL, 1, 21, 1),
(32, 1, '2018-12-18 16:36:57', NULL, NULL, 1, 21, 2),
(33, 1, '2018-12-18 16:36:57', NULL, NULL, 1, 22, 2),
(34, 1, '2018-12-18 16:39:05', NULL, NULL, 1, 23, 1),
(35, 1, '2018-12-18 16:39:05', NULL, NULL, 1, 23, 2),
(36, 1, '2018-12-18 16:39:05', NULL, NULL, 1, 24, 2),
(37, 1, '2018-12-18 16:43:25', NULL, NULL, 1, 25, 1),
(38, 1, '2018-12-18 16:43:25', NULL, NULL, 1, 25, 2),
(39, 1, '2018-12-18 16:43:26', NULL, NULL, 1, 26, 2),
(40, 1, '2018-12-18 17:01:24', NULL, NULL, 1, 27, 1),
(41, 1, '2018-12-18 17:01:24', NULL, NULL, 1, 27, 2),
(42, 1, '2018-12-18 17:01:24', NULL, NULL, 1, 28, 2),
(43, 1, '2018-12-18 17:13:04', NULL, NULL, 1, 29, 1),
(44, 1, '2018-12-18 17:13:04', NULL, NULL, 1, 29, 2),
(45, 1, '2018-12-18 16:05:16', NULL, NULL, 1, 30, 2),
(46, 1, '2018-12-18 16:09:49', NULL, NULL, 1, 31, 1),
(47, 1, '2018-12-18 16:09:49', NULL, NULL, 1, 31, 2),
(48, 1, '2018-12-18 16:09:49', NULL, NULL, 1, 32, 2),
(49, 1, '2018-12-18 16:10:02', NULL, NULL, 1, 33, 1),
(50, 1, '2018-12-18 16:10:02', NULL, NULL, 1, 33, 2),
(51, 1, '2018-12-18 16:10:02', NULL, NULL, 1, 34, 2),
(52, 1, '2018-12-18 16:15:08', NULL, NULL, 1, 35, 1),
(53, 1, '2018-12-18 16:15:08', NULL, NULL, 1, 35, 2),
(54, 1, '2018-12-18 16:15:08', NULL, NULL, 1, 36, 2),
(55, 1, '2018-12-18 16:24:19', NULL, NULL, 1, 37, 1),
(56, 1, '2018-12-18 16:24:19', NULL, NULL, 1, 37, 2),
(57, 1, '2018-12-18 16:24:20', NULL, NULL, 1, 38, 2),
(58, 1, '2018-12-18 16:25:19', NULL, NULL, 1, 39, 1),
(59, 1, '2018-12-18 16:25:19', NULL, NULL, 1, 39, 2),
(60, 1, '2018-12-18 16:25:19', NULL, NULL, 1, 40, 2),
(61, 1, '2018-12-18 16:36:57', NULL, NULL, 1, 41, 1),
(62, 1, '2018-12-18 16:36:57', NULL, NULL, 1, 41, 2),
(63, 1, '2018-12-18 16:36:57', NULL, NULL, 1, 42, 2),
(64, 1, '2018-12-18 16:39:05', NULL, NULL, 1, 43, 1),
(65, 1, '2018-12-18 16:39:05', NULL, NULL, 1, 43, 2),
(66, 1, '2018-12-18 16:39:05', NULL, NULL, 1, 44, 2),
(67, 1, '2018-12-18 16:43:25', NULL, NULL, 1, 45, 1),
(68, 1, '2018-12-18 16:43:25', NULL, NULL, 1, 45, 2),
(69, 1, '2018-12-18 16:43:26', NULL, NULL, 1, 46, 2),
(70, 1, '2018-12-18 17:01:24', NULL, NULL, 1, 47, 1),
(71, 1, '2018-12-18 17:01:24', NULL, NULL, 1, 47, 2),
(72, 1, '2018-12-18 17:01:24', NULL, NULL, 1, 48, 2),
(73, 1, '2018-12-18 17:13:04', NULL, NULL, 1, 49, 1),
(74, 1, '2018-12-18 17:13:04', NULL, NULL, 1, 49, 2),
(75, 1, '2018-12-18 16:25:19', NULL, NULL, 1, 50, 2),
(76, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 51, 1),
(77, 1, '2018-12-18 14:54:26', NULL, NULL, 1, 51, 2),
(78, 1, '2018-12-18 14:54:27', NULL, NULL, 1, 52, 2),
(79, 1, '2018-12-18 15:01:13', NULL, NULL, 1, 53, 1),
(80, 1, '2018-12-18 15:01:13', NULL, NULL, 1, 53, 2),
(81, 1, '2018-12-18 15:01:14', NULL, NULL, 1, 54, 2),
(82, 1, '2018-12-18 15:02:06', NULL, NULL, 1, 55, 1),
(83, 1, '2018-12-18 15:02:06', NULL, NULL, 1, 55, 2),
(84, 1, '2018-12-18 15:02:07', NULL, NULL, 1, 56, 2),
(85, 1, '2018-12-18 15:19:02', NULL, NULL, 1, 57, 1),
(86, 1, '2018-12-18 15:19:02', NULL, NULL, 1, 57, 2),
(87, 1, '2018-12-18 15:19:03', NULL, NULL, 1, 58, 2),
(88, 1, '2018-12-18 16:05:15', NULL, NULL, 1, 59, 1),
(89, 1, '2018-12-18 16:05:15', NULL, NULL, 1, 59, 2),
(90, 1, '2018-12-18 16:05:16', NULL, NULL, 1, 60, 2),
(91, 1, '2018-12-18 16:09:49', NULL, NULL, 1, 61, 1),
(92, 1, '2018-12-18 16:09:49', NULL, NULL, 1, 61, 2),
(93, 1, '2018-12-18 16:09:49', NULL, NULL, 1, 62, 2),
(94, 1, '2018-12-18 16:10:02', NULL, NULL, 1, 63, 1),
(95, 1, '2018-12-18 16:10:02', NULL, NULL, 1, 63, 2),
(96, 1, '2018-12-18 16:10:02', NULL, NULL, 1, 64, 2),
(97, 1, '2018-12-18 16:15:08', NULL, NULL, 1, 65, 1),
(98, 1, '2018-12-18 16:15:08', NULL, NULL, 1, 65, 2),
(99, 1, '2018-12-18 16:15:08', NULL, NULL, 1, 66, 2),
(100, 1, '2018-12-18 16:24:19', NULL, NULL, 1, 67, 1),
(101, 1, '2018-12-18 16:24:19', NULL, NULL, 1, 67, 2),
(102, 1, '2018-12-18 16:24:20', NULL, NULL, 1, 68, 2),
(103, 1, '2018-12-18 16:25:19', NULL, NULL, 1, 69, 1),
(104, 1, '2018-12-18 16:25:19', NULL, NULL, 1, 69, 2),
(105, 1, '2018-12-18 16:25:19', NULL, NULL, 1, 70, 2),
(106, 1, '2018-12-18 16:36:57', NULL, NULL, 1, 71, 1),
(107, 1, '2018-12-18 16:36:57', NULL, NULL, 1, 71, 2),
(108, 1, '2018-12-18 16:36:57', NULL, NULL, 1, 72, 2),
(109, 1, '2018-12-18 16:39:05', NULL, NULL, 1, 73, 1),
(110, 1, '2018-12-18 16:39:05', NULL, NULL, 1, 73, 2),
(111, 1, '2018-12-18 16:39:05', NULL, NULL, 1, 74, 2),
(112, 1, '2018-12-18 16:43:25', NULL, NULL, 1, 75, 1),
(113, 1, '2018-12-18 16:43:25', NULL, NULL, 1, 75, 2),
(114, 1, '2018-12-18 16:43:26', NULL, NULL, 1, 76, 2),
(115, 1, '2018-12-18 17:01:24', NULL, NULL, 1, 77, 1),
(116, 1, '2018-12-18 17:01:24', NULL, NULL, 1, 77, 2),
(117, 1, '2018-12-18 17:01:24', NULL, NULL, 1, 78, 2),
(118, 1, '2018-12-18 17:13:04', NULL, NULL, 1, 79, 1),
(119, 1, '2018-12-18 17:13:04', NULL, NULL, 1, 79, 2),
(120, 1, '2018-12-18 16:05:16', NULL, NULL, 1, 80, 2),
(121, 1, '2018-12-18 16:09:49', NULL, NULL, 1, 81, 1),
(122, 1, '2018-12-18 16:09:49', NULL, NULL, 1, 81, 2),
(123, 1, '2018-12-18 16:09:49', NULL, NULL, 1, 82, 2),
(124, 1, '2018-12-18 16:10:02', NULL, NULL, 1, 83, 1),
(125, 1, '2018-12-18 16:10:02', NULL, NULL, 1, 83, 2),
(126, 1, '2018-12-18 16:10:02', NULL, NULL, 1, 84, 2),
(127, 1, '2018-12-18 16:15:08', NULL, NULL, 1, 85, 1),
(128, 1, '2018-12-18 16:15:08', NULL, NULL, 1, 85, 2),
(129, 1, '2018-12-18 16:15:08', NULL, NULL, 1, 86, 2),
(130, 1, '2018-12-18 16:24:19', NULL, NULL, 1, 87, 1),
(131, 1, '2018-12-18 16:24:19', NULL, NULL, 1, 87, 2),
(132, 1, '2018-12-18 16:24:20', NULL, NULL, 1, 88, 2),
(133, 1, '2018-12-18 16:25:19', NULL, NULL, 1, 89, 1),
(134, 1, '2018-12-18 16:25:19', NULL, NULL, 1, 89, 2),
(135, 1, '2018-12-18 16:25:19', NULL, NULL, 1, 90, 2),
(136, 1, '2018-12-18 16:36:57', NULL, NULL, 1, 91, 1),
(137, 1, '2018-12-18 16:36:57', NULL, NULL, 1, 91, 2),
(138, 1, '2018-12-18 16:36:57', NULL, NULL, 1, 92, 2),
(139, 1, '2018-12-18 16:39:05', NULL, NULL, 1, 93, 1),
(140, 1, '2018-12-18 16:39:05', NULL, NULL, 1, 93, 2),
(141, 1, '2018-12-18 16:39:05', NULL, NULL, 1, 94, 2),
(142, 1, '2018-12-18 16:43:25', NULL, NULL, 1, 95, 1),
(143, 1, '2018-12-18 16:43:25', NULL, NULL, 1, 95, 2),
(144, 1, '2018-12-18 16:43:26', NULL, NULL, 1, 96, 2),
(145, 1, '2018-12-18 17:01:24', NULL, NULL, 1, 97, 1),
(146, 1, '2018-12-18 17:01:24', NULL, NULL, 1, 97, 2),
(147, 1, '2018-12-18 17:01:24', NULL, NULL, 1, 98, 2),
(148, 1, '2018-12-18 17:13:04', NULL, NULL, 1, 99, 1),
(149, 1, '2018-12-18 17:13:04', NULL, NULL, 1, 99, 2),
(150, 1, '2018-12-18 16:05:16', NULL, NULL, 1, 100, 2),
(151, 1, '2018-12-18 16:09:49', NULL, NULL, 1, 101, 1),
(152, 1, '2018-12-18 16:09:49', NULL, NULL, 1, 101, 2),
(153, 1, '2018-12-18 16:09:49', NULL, NULL, 1, 102, 2),
(154, 1, '2018-12-18 16:10:02', NULL, NULL, 1, 103, 1),
(155, 1, '2018-12-18 16:10:02', NULL, NULL, 1, 103, 2),
(156, 1, '2018-12-18 16:10:02', NULL, NULL, 1, 104, 2),
(157, 1, '2018-12-18 16:15:08', NULL, NULL, 1, 105, 1),
(158, 1, '2018-12-18 16:15:08', NULL, NULL, 1, 105, 2),
(159, 1, '2018-12-18 16:15:08', NULL, NULL, 1, 106, 2),
(160, 1, '2018-12-18 16:24:19', NULL, NULL, 1, 107, 1),
(161, 1, '2018-12-18 16:24:19', NULL, NULL, 1, 107, 2),
(162, 1, '2018-12-18 16:24:20', NULL, NULL, 1, 108, 2),
(163, 1, '2018-12-18 16:25:19', NULL, NULL, 1, 109, 1),
(164, 1, '2018-12-18 16:25:19', NULL, NULL, 1, 109, 2),
(165, 1, '2018-12-18 16:05:16', NULL, NULL, 1, 110, 2),
(166, 1, '2018-12-18 16:09:49', NULL, NULL, 1, 111, 1),
(167, 1, '2018-12-18 16:09:49', NULL, NULL, 1, 111, 2),
(168, 1, '2018-12-18 16:09:49', NULL, NULL, 1, 112, 2),
(169, 1, '2018-12-18 16:10:02', NULL, NULL, 1, 113, 1),
(170, 1, '2018-12-18 16:10:02', NULL, NULL, 1, 113, 2),
(171, 1, '2018-12-18 16:10:02', NULL, NULL, 1, 114, 2),
(172, 1, '2018-12-18 16:15:08', NULL, NULL, 1, 115, 1),
(173, 1, '2018-12-18 16:15:08', NULL, NULL, 1, 115, 2),
(174, 1, '2018-12-18 16:15:08', NULL, NULL, 1, 116, 2),
(175, 1, '2018-12-18 16:24:19', NULL, NULL, 1, 117, 1),
(176, 1, '2018-12-18 16:24:19', NULL, NULL, 1, 117, 2),
(177, 1, '2018-12-18 16:24:20', NULL, NULL, 1, 118, 2),
(178, 1, '2018-12-18 16:25:19', NULL, NULL, 1, 119, 1),
(179, 1, '2018-12-18 16:25:19', NULL, NULL, 1, 119, 2),
(180, 1, '2018-12-18 16:05:16', NULL, NULL, 1, 120, 2),
(181, 1, '2018-12-18 16:09:49', NULL, NULL, 1, 121, 1),
(182, 1, '2018-12-18 16:09:49', NULL, NULL, 1, 121, 2),
(183, 1, '2018-12-18 16:09:49', NULL, NULL, 1, 122, 2),
(184, 1, '2018-12-18 16:10:02', NULL, NULL, 1, 123, 1),
(185, 1, '2018-12-18 16:10:02', NULL, NULL, 1, 123, 2),
(186, 1, '2018-12-18 16:10:02', NULL, NULL, 1, 124, 2),
(187, 1, '2018-12-18 16:15:08', NULL, NULL, 1, 125, 1),
(188, 1, '2018-12-18 16:15:08', NULL, NULL, 1, 125, 2),
(189, 1, '2018-12-18 16:15:08', NULL, NULL, 1, 126, 2),
(190, 1, '2018-12-18 16:24:19', NULL, NULL, 1, 127, 1),
(191, 1, '2018-12-18 16:24:19', NULL, NULL, 1, 127, 2),
(192, 1, '2018-12-18 16:24:20', NULL, NULL, 1, 128, 2),
(193, 1, '2018-12-18 16:25:19', NULL, NULL, 1, 129, 1),
(194, 1, '2018-12-18 16:25:19', NULL, NULL, 1, 129, 2),
(195, 1, '2018-12-18 16:05:16', NULL, NULL, 1, 130, 2),
(196, 1, '2018-12-18 16:09:49', NULL, NULL, 1, 131, 1),
(197, 1, '2018-12-18 16:09:49', NULL, NULL, 1, 131, 2),
(198, 1, '2018-12-18 16:09:49', NULL, NULL, 1, 132, 2),
(199, 1, '2018-12-18 16:10:02', NULL, NULL, 1, 133, 1),
(200, 1, '2018-12-18 16:10:02', NULL, NULL, 1, 133, 2),
(201, 1, '2018-12-18 16:10:02', NULL, NULL, 1, 134, 2),
(202, 1, '2018-12-18 16:15:08', NULL, NULL, 1, 135, 1),
(203, 1, '2018-12-18 16:15:08', NULL, NULL, 1, 135, 2),
(204, 1, '2018-12-18 16:15:08', NULL, NULL, 1, 136, 2),
(205, 1, '2018-12-18 16:24:19', NULL, NULL, 1, 137, 1),
(206, 1, '2018-12-18 16:24:19', NULL, NULL, 1, 137, 2),
(207, 1, '2018-12-18 16:24:20', NULL, NULL, 1, 138, 2),
(208, 1, '2018-12-18 16:25:19', NULL, NULL, 1, 139, 1),
(209, 1, '2018-12-18 16:25:19', NULL, NULL, 1, 139, 2),
(210, 1, '2018-12-18 16:05:16', NULL, NULL, 1, 140, 2),
(211, 1, '2018-12-18 16:09:49', NULL, NULL, 1, 141, 1),
(212, 1, '2018-12-18 16:09:49', NULL, NULL, 1, 141, 2),
(213, 1, '2018-12-18 16:09:49', NULL, NULL, 1, 142, 2),
(214, 1, '2018-12-18 16:10:02', NULL, NULL, 1, 143, 1),
(215, 1, '2018-12-18 16:10:02', NULL, NULL, 1, 143, 2),
(216, 1, '2018-12-18 16:10:02', NULL, NULL, 1, 144, 2),
(217, 1, '2018-12-18 16:15:08', NULL, NULL, 1, 145, 1),
(218, 1, '2018-12-18 16:15:08', NULL, NULL, 1, 145, 2),
(219, 1, '2018-12-18 16:15:08', NULL, NULL, 1, 146, 2),
(220, 1, '2018-12-18 16:24:19', NULL, NULL, 1, 147, 1),
(221, 1, '2018-12-18 16:24:19', NULL, NULL, 1, 147, 2),
(222, 1, '2018-12-18 16:24:20', NULL, NULL, 1, 148, 2),
(223, 1, '2018-12-18 16:25:19', NULL, NULL, 1, 149, 1),
(224, 1, '2018-12-18 16:25:19', NULL, NULL, 1, 149, 2),
(225, 1, '2018-12-18 16:05:16', NULL, NULL, 1, 150, 2),
(226, 1, '2018-12-18 16:09:49', NULL, NULL, 1, 151, 1),
(227, 1, '2018-12-18 16:09:49', NULL, NULL, 1, 151, 2),
(228, 1, '2018-12-18 16:09:49', NULL, NULL, 1, 152, 2),
(229, 1, '2018-12-18 16:10:02', NULL, NULL, 1, 153, 1),
(230, 1, '2018-12-18 16:10:02', NULL, NULL, 1, 153, 2),
(231, 1, '2018-12-18 16:10:02', NULL, NULL, 1, 154, 2),
(232, 1, '2018-12-18 16:15:08', NULL, NULL, 1, 155, 1),
(233, 1, '2018-12-18 16:15:08', NULL, NULL, 1, 155, 2),
(234, 1, '2018-12-18 16:15:08', NULL, NULL, 1, 156, 2),
(235, 1, '2018-12-18 16:24:19', NULL, NULL, 1, 157, 1),
(236, 1, '2018-12-18 16:24:19', NULL, NULL, 1, 157, 2),
(237, 1, '2018-12-18 16:24:20', NULL, NULL, 1, 158, 2),
(238, 1, '2018-12-18 16:25:19', NULL, NULL, 1, 159, 1),
(239, 1, '2018-12-18 16:25:19', NULL, NULL, 1, 159, 2),
(240, 1, '2018-12-18 16:05:16', NULL, NULL, 1, 160, 2),
(241, 1, '2018-12-18 16:09:49', NULL, NULL, 1, 161, 1);

-- --------------------------------------------------------

--
-- Table structure for table `user_vs_account`
--

CREATE TABLE `user_vs_account` (
  `host_vs_account_id` bigint(20) NOT NULL,
  `created_by` bigint(20) DEFAULT NULL,
  `created_date` varchar(255) DEFAULT NULL,
  `modified_by` bigint(20) DEFAULT NULL,
  `modified_date` varchar(255) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `account_holder_name` varchar(255) DEFAULT NULL,
  `account_number` varchar(255) DEFAULT NULL,
  `account_type` varchar(255) DEFAULT NULL,
  `bank_name` varchar(255) DEFAULT NULL,
  `branch_name` varchar(255) DEFAULT NULL,
  `ifsc_code` varchar(255) DEFAULT NULL,
  `user_id` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user_vs_account`
--

INSERT INTO `user_vs_account` (`host_vs_account_id`, `created_by`, `created_date`, `modified_by`, `modified_date`, `status`, `account_holder_name`, `account_number`, `account_type`, `bank_name`, `branch_name`, `ifsc_code`, `user_id`) VALUES
(1, 1, '2018-12-18 14:54:25', NULL, NULL, 1, 'Sudeep Chhetri1', '159883741610', 'Saving', 'IndusInd Bank', 'Sector V', 'IND0015478', '1'),
(2, 1, '2018-12-18 15:01:11', NULL, NULL, 1, 'Sudeep Chhetri2', '159883741610', 'Saving', 'IndusInd Bank', 'Sector V', 'IND0015478', '1'),
(3, 1, '2018-12-18 15:02:05', NULL, NULL, 1, 'Sudeep Chhetri3', '159883741610', 'Saving', 'IndusInd Bank', 'Sector V', 'IND0015478', '1'),
(4, 1, '2018-12-18 15:19:01', NULL, NULL, 1, 'Sudeep Chhetri4', '159883741610', 'Saving', 'IndusInd Bank', 'Sector V', 'IND0015478', '1'),
(5, 1, '2018-12-18 16:05:15', NULL, NULL, 1, 'Sudeep Chhetri5', '159883741610', 'Saving', 'IndusInd Bank', 'Sector V', 'IND0015478', '1'),
(6, 1, '2018-12-18 16:09:47', NULL, NULL, 1, 'Sudeep Chhetri6', '159883741610', 'Saving', 'IndusInd Bank', 'Sector V', 'IND0015478', '1'),
(7, 1, '2018-12-18 16:10:01', NULL, NULL, 1, 'Sudeep Chhetri7', '159883741610', 'Saving', 'IndusInd Bank', 'Sector V', 'IND0015478', '1'),
(8, 1, '2018-12-18 16:15:08', NULL, NULL, 1, 'Sudeep Chhetri8', '159883741610', 'Saving', 'IndusInd Bank', 'Sector V', 'IND0015478', '1'),
(9, 1, '2018-12-18 16:24:18', NULL, NULL, 1, 'Sudeep Chhetri9', '159883741610', 'Saving', 'IndusInd Bank', 'Sector V', 'IND0015478', '1'),
(10, 1, '2018-12-18 16:25:18', NULL, NULL, 1, 'Sudeep Chhetri10', '159883741610', 'Saving', 'IndusInd Bank', 'Sector V', 'IND0015478', '1'),
(11, 1, '2018-12-18 16:36:56', NULL, NULL, 1, 'Sudeep Chhetri11', '159883741610', 'Saving', 'IndusInd Bank', 'Sector V', 'IND0015478', '1'),
(12, 1, '2018-12-18 16:39:05', NULL, NULL, 1, 'Sudeep Chhetri12', '159883741610', 'Saving', 'IndusInd Bank', 'Sector V', 'IND0015478', '1'),
(13, 1, '2018-12-18 16:43:25', NULL, NULL, 1, 'Sudeep Chhetri13', '159883741610', 'Saving', 'IndusInd Bank', 'Sector V', 'IND0015478', '1'),
(14, 1, '2018-12-18 17:01:24', NULL, NULL, 1, 'Sudeep Chhetri14', '159883741610', 'Saving', 'IndusInd Bank', 'Sector V', 'IND0015478', '1'),
(15, 1, '2018-12-18 17:13:04', NULL, NULL, 1, 'Sudeep Chhetri15', '159883741610', 'Saving', 'IndusInd Bank', 'Sector V', 'IND0015478', '1'),
(16, 1, '2018-12-18 18:10:06', NULL, NULL, 1, 'Sudeep Chhetri16', '159883741610', 'Saving', 'IndusInd Bank', 'Sector V', 'IND0015478', '1'),
(17, 1, '2018-12-18 16:10:01', NULL, NULL, 1, 'Sudeep Chhetri17', '159883741610', 'Saving', 'IndusInd Bank', 'Sector V', 'IND0015478', '1'),
(18, 1, '2018-12-18 16:15:08', NULL, NULL, 1, 'Sudeep Chhetri18', '159883741610', 'Saving', 'IndusInd Bank', 'Sector V', 'IND0015478', '1'),
(19, 1, '2018-12-18 16:24:18', NULL, NULL, 1, 'Sudeep Chhetri19', '159883741610', 'Saving', 'IndusInd Bank', 'Sector V', 'IND0015478', '1'),
(20, 1, '2018-12-18 16:25:18', NULL, NULL, 1, 'Sudeep Chhetri20', '159883741610', 'Saving', 'IndusInd Bank', 'Sector V', 'IND0015478', '1'),
(21, 1, '2018-12-18 14:54:25', NULL, NULL, 1, 'Sudeep Chhetri21', '159883741610', 'Saving', 'IndusInd Bank', 'Sector V', 'IND0015478', '1'),
(22, 1, '2018-12-18 15:01:11', NULL, NULL, 1, 'Sudeep Chhetri22', '159883741610', 'Saving', 'IndusInd Bank', 'Sector V', 'IND0015478', '1'),
(23, 1, '2018-12-18 15:02:05', NULL, NULL, 1, 'Sudeep Chhetri23', '159883741610', 'Saving', 'IndusInd Bank', 'Sector V', 'IND0015478', '1'),
(24, 1, '2018-12-18 15:19:01', NULL, NULL, 1, 'Sudeep Chhetri24', '159883741610', 'Saving', 'IndusInd Bank', 'Sector V', 'IND0015478', '1'),
(25, 1, '2018-12-18 16:05:15', NULL, NULL, 1, 'Sudeep Chhetri25', '159883741610', 'Saving', 'IndusInd Bank', 'Sector V', 'IND0015478', '1'),
(26, 1, '2018-12-18 16:09:47', NULL, NULL, 1, 'Sudeep Chhetri26', '159883741610', 'Saving', 'IndusInd Bank', 'Sector V', 'IND0015478', '1');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `master_amenities`
--
ALTER TABLE `master_amenities`
  ADD PRIMARY KEY (`aminities_id`);

--
-- Indexes for table `master_cancellation_slab`
--
ALTER TABLE `master_cancellation_slab`
  ADD PRIMARY KEY (`cancellation_slab_id`);

--
-- Indexes for table `master_document`
--
ALTER TABLE `master_document`
  ADD PRIMARY KEY (`document_id`);

--
-- Indexes for table `master_meal_plan`
--
ALTER TABLE `master_meal_plan`
  ADD PRIMARY KEY (`meal_plan_id`);

--
-- Indexes for table `master_meal_plan_category`
--
ALTER TABLE `master_meal_plan_category`
  ADD PRIMARY KEY (`mpc_id`);

--
-- Indexes for table `master_offer`
--
ALTER TABLE `master_offer`
  ADD PRIMARY KEY (`offer_id`);

--
-- Indexes for table `master_price_drop`
--
ALTER TABLE `master_price_drop`
  ADD PRIMARY KEY (`price_drop_id`);

--
-- Indexes for table `master_property`
--
ALTER TABLE `master_property`
  ADD PRIMARY KEY (`property_id`),
  ADD KEY `FKtb8mxoehi4doi7200iynq5k3i` (`host_vs_account_id`),
  ADD KEY `FK5a00uodiowpit4s2fbuqgbm09` (`property_type_id`),
  ADD KEY `FK156vy9s4sl5mh6nxjo74bg2rv` (`stay_type_id`);

--
-- Indexes for table `master_property_type`
--
ALTER TABLE `master_property_type`
  ADD PRIMARY KEY (`property_type_id`);

--
-- Indexes for table `master_room`
--
ALTER TABLE `master_room`
  ADD PRIMARY KEY (`room_id`),
  ADD KEY `FK44tv0dyh1xvs2elrr7yr3tr1x` (`property_id`),
  ADD KEY `FKjw1vho56i8n32d1tyt64yh8ey` (`room_cat_id`);

--
-- Indexes for table `master_room_category`
--
ALTER TABLE `master_room_category`
  ADD PRIMARY KEY (`room_cat_id`),
  ADD KEY `FKljipnikicv5k5pfpao2dflhpj` (`property_type_id`);

--
-- Indexes for table `master_space_rule`
--
ALTER TABLE `master_space_rule`
  ADD PRIMARY KEY (`sprule_id`);

--
-- Indexes for table `master_specialties`
--
ALTER TABLE `master_specialties`
  ADD PRIMARY KEY (`specialties_id`);

--
-- Indexes for table `master_special_experience`
--
ALTER TABLE `master_special_experience`
  ADD PRIMARY KEY (`experience_id`);

--
-- Indexes for table `master_stay_type`
--
ALTER TABLE `master_stay_type`
  ADD PRIMARY KEY (`stay_type_id`);

--
-- Indexes for table `master_wishlist`
--
ALTER TABLE `master_wishlist`
  ADD PRIMARY KEY (`wishlist_id`),
  ADD KEY `FKqp3nmgc19tiysytctn29jkypy` (`property_id`);

--
-- Indexes for table `meal_plan_cat_vs_meal_plan`
--
ALTER TABLE `meal_plan_cat_vs_meal_plan`
  ADD PRIMARY KEY (`mpcmp_id`),
  ADD KEY `FKiqhjoqkinxg3b872k7m68xq13` (`mpc_id`),
  ADD KEY `FKeuyapssqoidbnljl9l9lbq78u` (`meal_plan_id`);

--
-- Indexes for table `property_vs_description`
--
ALTER TABLE `property_vs_description`
  ADD PRIMARY KEY (`property_desc_id`),
  ADD KEY `FK53h3qarlglrohvb624pf128m2` (`property_id`);

--
-- Indexes for table `property_vs_document`
--
ALTER TABLE `property_vs_document`
  ADD PRIMARY KEY (`property_vs_document_id`),
  ADD KEY `FKfgbbjwhbs884wescouui8b3gk` (`document_id`),
  ADD KEY `FKep8ggv1h9e7p36dim56nm6e2a` (`property_id`);

--
-- Indexes for table `property_vs_experience`
--
ALTER TABLE `property_vs_experience`
  ADD PRIMARY KEY (`property_exp_id`),
  ADD KEY `FK92o376xk6r7gls0he1aaugt7x` (`property_id`),
  ADD KEY `FKn1s82f6oy0l1qh4mtmrdvjpx4` (`experience_id`);

--
-- Indexes for table `property_vs_guest_access`
--
ALTER TABLE `property_vs_guest_access`
  ADD PRIMARY KEY (`property_gaccess_id`),
  ADD KEY `FKg443u2hdb4sbrrnjwsrsxh7rk` (`property_id`);

--
-- Indexes for table `property_vs_image`
--
ALTER TABLE `property_vs_image`
  ADD PRIMARY KEY (`property_image_id`),
  ADD KEY `FKdrv8bc11h2o2m8uumykk4cu57` (`property_id`);

--
-- Indexes for table `property_vs_nearby`
--
ALTER TABLE `property_vs_nearby`
  ADD PRIMARY KEY (`property_nearby_id`),
  ADD KEY `FKru2h6pp77q418s5973c7125de` (`property_id`);

--
-- Indexes for table `property_vs_pricedrop`
--
ALTER TABLE `property_vs_pricedrop`
  ADD PRIMARY KEY (`property_pricedrop_id`),
  ADD KEY `FKnna1ewhlvt6hf3dmqx3rwd91k` (`price_drop_id`),
  ADD KEY `FKgwycvdturw8svnhj0pveb83bg` (`property_id`);

--
-- Indexes for table `property_vs_space`
--
ALTER TABLE `property_vs_space`
  ADD PRIMARY KEY (`property_space_id`),
  ADD KEY `FKklkdybjqkwqcsydd52tcjt4g0` (`property_id`),
  ADD KEY `FKhd1vunghcip4rtk0511i53tf7` (`sprule_id`);

--
-- Indexes for table `room_vs_amenities`
--
ALTER TABLE `room_vs_amenities`
  ADD PRIMARY KEY (`room_vs_aminities_id`),
  ADD KEY `FKm50c7up4jp1m0vl36325pktvw` (`aminities_id`),
  ADD KEY `FKblve2wd06ghlbt72q1onnu1ib` (`room_id`);

--
-- Indexes for table `room_vs_cancellation`
--
ALTER TABLE `room_vs_cancellation`
  ADD PRIMARY KEY (`rc_id`),
  ADD KEY `FKr3pyo2gqwl71s8k5sm32rbjha` (`cancellation_slab_id`),
  ADD KEY `FKemhbtji1nvg41xa261axnd7vr` (`room_id`);

--
-- Indexes for table `room_vs_image`
--
ALTER TABLE `room_vs_image`
  ADD PRIMARY KEY (`room_vs_image_id`),
  ADD KEY `FKpamxay6j07bxeh97i0753dh6t` (`room_id`);

--
-- Indexes for table `room_vs_meal`
--
ALTER TABLE `room_vs_meal`
  ADD PRIMARY KEY (`room_vs_meal_id`),
  ADD KEY `FKfxh94m8ds7jaej9udbouh2alf` (`meal_plan_id`),
  ADD KEY `FKbv9gqnudk5swt4bpm37f5p28b` (`room_id`);

--
-- Indexes for table `room_vs_offer`
--
ALTER TABLE `room_vs_offer`
  ADD PRIMARY KEY (`room_vs_offer_id`),
  ADD KEY `FKfqux8yyo3blnp4xga6oa9ur78` (`offer_id`),
  ADD KEY `FKeyvqqee0hpcmg61dl00kbqvt5` (`room_id`);

--
-- Indexes for table `room_vs_specialties`
--
ALTER TABLE `room_vs_specialties`
  ADD PRIMARY KEY (`roomspec_id`),
  ADD KEY `FKmjiqftc5rdrthmteghtchnkav` (`room_id`),
  ADD KEY `FKoe11vqm2reg89jso2t6d4mm7d` (`specialties_id`);

--
-- Indexes for table `user_vs_account`
--
ALTER TABLE `user_vs_account`
  ADD PRIMARY KEY (`host_vs_account_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `master_amenities`
--
ALTER TABLE `master_amenities`
  MODIFY `aminities_id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `master_cancellation_slab`
--
ALTER TABLE `master_cancellation_slab`
  MODIFY `cancellation_slab_id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `master_document`
--
ALTER TABLE `master_document`
  MODIFY `document_id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `master_meal_plan`
--
ALTER TABLE `master_meal_plan`
  MODIFY `meal_plan_id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `master_meal_plan_category`
--
ALTER TABLE `master_meal_plan_category`
  MODIFY `mpc_id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `master_offer`
--
ALTER TABLE `master_offer`
  MODIFY `offer_id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `master_price_drop`
--
ALTER TABLE `master_price_drop`
  MODIFY `price_drop_id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `master_property`
--
ALTER TABLE `master_property`
  MODIFY `property_id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=28;

--
-- AUTO_INCREMENT for table `master_property_type`
--
ALTER TABLE `master_property_type`
  MODIFY `property_type_id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `master_room`
--
ALTER TABLE `master_room`
  MODIFY `room_id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=162;

--
-- AUTO_INCREMENT for table `master_room_category`
--
ALTER TABLE `master_room_category`
  MODIFY `room_cat_id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `master_space_rule`
--
ALTER TABLE `master_space_rule`
  MODIFY `sprule_id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `master_specialties`
--
ALTER TABLE `master_specialties`
  MODIFY `specialties_id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `master_special_experience`
--
ALTER TABLE `master_special_experience`
  MODIFY `experience_id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `master_stay_type`
--
ALTER TABLE `master_stay_type`
  MODIFY `stay_type_id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `master_wishlist`
--
ALTER TABLE `master_wishlist`
  MODIFY `wishlist_id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `meal_plan_cat_vs_meal_plan`
--
ALTER TABLE `meal_plan_cat_vs_meal_plan`
  MODIFY `mpcmp_id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `property_vs_description`
--
ALTER TABLE `property_vs_description`
  MODIFY `property_desc_id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=27;

--
-- AUTO_INCREMENT for table `property_vs_document`
--
ALTER TABLE `property_vs_document`
  MODIFY `property_vs_document_id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=53;

--
-- AUTO_INCREMENT for table `property_vs_experience`
--
ALTER TABLE `property_vs_experience`
  MODIFY `property_exp_id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=53;

--
-- AUTO_INCREMENT for table `property_vs_guest_access`
--
ALTER TABLE `property_vs_guest_access`
  MODIFY `property_gaccess_id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=27;

--
-- AUTO_INCREMENT for table `property_vs_image`
--
ALTER TABLE `property_vs_image`
  MODIFY `property_image_id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=79;

--
-- AUTO_INCREMENT for table `property_vs_nearby`
--
ALTER TABLE `property_vs_nearby`
  MODIFY `property_nearby_id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=79;

--
-- AUTO_INCREMENT for table `property_vs_pricedrop`
--
ALTER TABLE `property_vs_pricedrop`
  MODIFY `property_pricedrop_id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=53;

--
-- AUTO_INCREMENT for table `property_vs_space`
--
ALTER TABLE `property_vs_space`
  MODIFY `property_space_id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=82;

--
-- AUTO_INCREMENT for table `room_vs_amenities`
--
ALTER TABLE `room_vs_amenities`
  MODIFY `room_vs_aminities_id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=386;

--
-- AUTO_INCREMENT for table `room_vs_cancellation`
--
ALTER TABLE `room_vs_cancellation`
  MODIFY `rc_id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=323;

--
-- AUTO_INCREMENT for table `room_vs_image`
--
ALTER TABLE `room_vs_image`
  MODIFY `room_vs_image_id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=484;

--
-- AUTO_INCREMENT for table `room_vs_meal`
--
ALTER TABLE `room_vs_meal`
  MODIFY `room_vs_meal_id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=645;

--
-- AUTO_INCREMENT for table `room_vs_offer`
--
ALTER TABLE `room_vs_offer`
  MODIFY `room_vs_offer_id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `room_vs_specialties`
--
ALTER TABLE `room_vs_specialties`
  MODIFY `roomspec_id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=242;

--
-- AUTO_INCREMENT for table `user_vs_account`
--
ALTER TABLE `user_vs_account`
  MODIFY `host_vs_account_id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=27;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `master_property`
--
ALTER TABLE `master_property`
  ADD CONSTRAINT `FK156vy9s4sl5mh6nxjo74bg2rv` FOREIGN KEY (`stay_type_id`) REFERENCES `master_stay_type` (`stay_type_id`),
  ADD CONSTRAINT `FK5a00uodiowpit4s2fbuqgbm09` FOREIGN KEY (`property_type_id`) REFERENCES `master_property_type` (`property_type_id`),
  ADD CONSTRAINT `FKtb8mxoehi4doi7200iynq5k3i` FOREIGN KEY (`host_vs_account_id`) REFERENCES `user_vs_account` (`host_vs_account_id`);

--
-- Constraints for table `master_room`
--
ALTER TABLE `master_room`
  ADD CONSTRAINT `FK44tv0dyh1xvs2elrr7yr3tr1x` FOREIGN KEY (`property_id`) REFERENCES `master_property` (`property_id`),
  ADD CONSTRAINT `FKjw1vho56i8n32d1tyt64yh8ey` FOREIGN KEY (`room_cat_id`) REFERENCES `master_room_category` (`room_cat_id`);

--
-- Constraints for table `master_room_category`
--
ALTER TABLE `master_room_category`
  ADD CONSTRAINT `FKljipnikicv5k5pfpao2dflhpj` FOREIGN KEY (`property_type_id`) REFERENCES `master_property_type` (`property_type_id`);

--
-- Constraints for table `master_wishlist`
--
ALTER TABLE `master_wishlist`
  ADD CONSTRAINT `FKqp3nmgc19tiysytctn29jkypy` FOREIGN KEY (`property_id`) REFERENCES `master_property` (`property_id`);

--
-- Constraints for table `meal_plan_cat_vs_meal_plan`
--
ALTER TABLE `meal_plan_cat_vs_meal_plan`
  ADD CONSTRAINT `FKeuyapssqoidbnljl9l9lbq78u` FOREIGN KEY (`meal_plan_id`) REFERENCES `master_meal_plan` (`meal_plan_id`),
  ADD CONSTRAINT `FKiqhjoqkinxg3b872k7m68xq13` FOREIGN KEY (`mpc_id`) REFERENCES `master_meal_plan_category` (`mpc_id`);

--
-- Constraints for table `property_vs_description`
--
ALTER TABLE `property_vs_description`
  ADD CONSTRAINT `FK53h3qarlglrohvb624pf128m2` FOREIGN KEY (`property_id`) REFERENCES `master_property` (`property_id`);

--
-- Constraints for table `property_vs_document`
--
ALTER TABLE `property_vs_document`
  ADD CONSTRAINT `FKep8ggv1h9e7p36dim56nm6e2a` FOREIGN KEY (`property_id`) REFERENCES `master_property` (`property_id`),
  ADD CONSTRAINT `FKfgbbjwhbs884wescouui8b3gk` FOREIGN KEY (`document_id`) REFERENCES `master_document` (`document_id`);

--
-- Constraints for table `property_vs_experience`
--
ALTER TABLE `property_vs_experience`
  ADD CONSTRAINT `FK92o376xk6r7gls0he1aaugt7x` FOREIGN KEY (`property_id`) REFERENCES `master_property` (`property_id`),
  ADD CONSTRAINT `FKn1s82f6oy0l1qh4mtmrdvjpx4` FOREIGN KEY (`experience_id`) REFERENCES `master_special_experience` (`experience_id`);

--
-- Constraints for table `property_vs_guest_access`
--
ALTER TABLE `property_vs_guest_access`
  ADD CONSTRAINT `FKg443u2hdb4sbrrnjwsrsxh7rk` FOREIGN KEY (`property_id`) REFERENCES `master_property` (`property_id`);

--
-- Constraints for table `property_vs_image`
--
ALTER TABLE `property_vs_image`
  ADD CONSTRAINT `FKdrv8bc11h2o2m8uumykk4cu57` FOREIGN KEY (`property_id`) REFERENCES `master_property` (`property_id`);

--
-- Constraints for table `property_vs_nearby`
--
ALTER TABLE `property_vs_nearby`
  ADD CONSTRAINT `FKru2h6pp77q418s5973c7125de` FOREIGN KEY (`property_id`) REFERENCES `master_property` (`property_id`);

--
-- Constraints for table `property_vs_pricedrop`
--
ALTER TABLE `property_vs_pricedrop`
  ADD CONSTRAINT `FKgwycvdturw8svnhj0pveb83bg` FOREIGN KEY (`property_id`) REFERENCES `master_property` (`property_id`),
  ADD CONSTRAINT `FKnna1ewhlvt6hf3dmqx3rwd91k` FOREIGN KEY (`price_drop_id`) REFERENCES `master_price_drop` (`price_drop_id`);

--
-- Constraints for table `property_vs_space`
--
ALTER TABLE `property_vs_space`
  ADD CONSTRAINT `FKhd1vunghcip4rtk0511i53tf7` FOREIGN KEY (`sprule_id`) REFERENCES `master_space_rule` (`sprule_id`),
  ADD CONSTRAINT `FKklkdybjqkwqcsydd52tcjt4g0` FOREIGN KEY (`property_id`) REFERENCES `master_property` (`property_id`);

--
-- Constraints for table `room_vs_amenities`
--
ALTER TABLE `room_vs_amenities`
  ADD CONSTRAINT `FKblve2wd06ghlbt72q1onnu1ib` FOREIGN KEY (`room_id`) REFERENCES `master_room` (`room_id`),
  ADD CONSTRAINT `FKm50c7up4jp1m0vl36325pktvw` FOREIGN KEY (`aminities_id`) REFERENCES `master_amenities` (`aminities_id`);

--
-- Constraints for table `room_vs_cancellation`
--
ALTER TABLE `room_vs_cancellation`
  ADD CONSTRAINT `FKemhbtji1nvg41xa261axnd7vr` FOREIGN KEY (`room_id`) REFERENCES `master_room` (`room_id`),
  ADD CONSTRAINT `FKr3pyo2gqwl71s8k5sm32rbjha` FOREIGN KEY (`cancellation_slab_id`) REFERENCES `master_cancellation_slab` (`cancellation_slab_id`);

--
-- Constraints for table `room_vs_image`
--
ALTER TABLE `room_vs_image`
  ADD CONSTRAINT `FKpamxay6j07bxeh97i0753dh6t` FOREIGN KEY (`room_id`) REFERENCES `master_room` (`room_id`);

--
-- Constraints for table `room_vs_meal`
--
ALTER TABLE `room_vs_meal`
  ADD CONSTRAINT `FKbv9gqnudk5swt4bpm37f5p28b` FOREIGN KEY (`room_id`) REFERENCES `master_room` (`room_id`),
  ADD CONSTRAINT `FKfxh94m8ds7jaej9udbouh2alf` FOREIGN KEY (`meal_plan_id`) REFERENCES `master_meal_plan` (`meal_plan_id`);

--
-- Constraints for table `room_vs_offer`
--
ALTER TABLE `room_vs_offer`
  ADD CONSTRAINT `FKeyvqqee0hpcmg61dl00kbqvt5` FOREIGN KEY (`room_id`) REFERENCES `master_room` (`room_id`),
  ADD CONSTRAINT `FKfqux8yyo3blnp4xga6oa9ur78` FOREIGN KEY (`offer_id`) REFERENCES `master_offer` (`offer_id`);

--
-- Constraints for table `room_vs_specialties`
--
ALTER TABLE `room_vs_specialties`
  ADD CONSTRAINT `FKmjiqftc5rdrthmteghtchnkav` FOREIGN KEY (`room_id`) REFERENCES `master_room` (`room_id`),
  ADD CONSTRAINT `FKoe11vqm2reg89jso2t6d4mm7d` FOREIGN KEY (`specialties_id`) REFERENCES `master_specialties` (`specialties_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;