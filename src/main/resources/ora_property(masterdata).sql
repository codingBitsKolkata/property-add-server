-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: Dec 27, 2018 at 08:51 PM
-- Server version: 5.7.23
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

DROP TABLE IF EXISTS `master_amenities`;
CREATE TABLE IF NOT EXISTS `master_amenities` (
  `aminities_id` bigint(20) NOT NULL AUTO_INCREMENT,
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
  `priority` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`aminities_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

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

DROP TABLE IF EXISTS `master_cancellation_slab`;
CREATE TABLE IF NOT EXISTS `master_cancellation_slab` (
  `cancellation_slab_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `created_by` bigint(20) DEFAULT NULL,
  `created_date` varchar(255) DEFAULT NULL,
  `modified_by` bigint(20) DEFAULT NULL,
  `modified_date` varchar(255) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `end_time` varchar(255) DEFAULT NULL,
  `start_time` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`cancellation_slab_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

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

DROP TABLE IF EXISTS `master_document`;
CREATE TABLE IF NOT EXISTS `master_document` (
  `document_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `created_by` bigint(20) DEFAULT NULL,
  `created_date` varchar(255) DEFAULT NULL,
  `modified_by` bigint(20) DEFAULT NULL,
  `modified_date` varchar(255) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `document_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`document_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `master_document`
--

INSERT INTO `master_document` (`document_id`, `created_by`, `created_date`, `modified_by`, `modified_date`, `status`, `document_name`) VALUES
(1, 1, '2018-09-06 01:27:34', NULL, NULL, 1, 'PANCARD'),
(2, 1, '2018-09-06 01:27:34', NULL, NULL, 1, 'CANCELLED CHEQUE');

-- --------------------------------------------------------

--
-- Table structure for table `master_meal_plan`
--

DROP TABLE IF EXISTS `master_meal_plan`;
CREATE TABLE IF NOT EXISTS `master_meal_plan` (
  `meal_plan_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `created_by` bigint(20) DEFAULT NULL,
  `created_date` varchar(255) DEFAULT NULL,
  `modified_by` bigint(20) DEFAULT NULL,
  `modified_date` varchar(255) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `language_id` bigint(20) DEFAULT NULL,
  `meal_plan_name` varchar(255) DEFAULT NULL,
  `parent_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`meal_plan_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

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

DROP TABLE IF EXISTS `master_meal_plan_category`;
CREATE TABLE IF NOT EXISTS `master_meal_plan_category` (
  `mpc_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `created_by` bigint(20) DEFAULT NULL,
  `created_date` varchar(255) DEFAULT NULL,
  `modified_by` bigint(20) DEFAULT NULL,
  `modified_date` varchar(255) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `language_id` bigint(20) DEFAULT NULL,
  `mpc_name` varchar(255) DEFAULT NULL,
  `parent_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`mpc_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

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

DROP TABLE IF EXISTS `master_offer`;
CREATE TABLE IF NOT EXISTS `master_offer` (
  `offer_id` bigint(20) NOT NULL AUTO_INCREMENT,
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
  `start_date_range` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`offer_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `master_offer`
--

INSERT INTO `master_offer` (`offer_id`, `created_by`, `created_date`, `modified_by`, `modified_date`, `status`, `amount`, `end_date_range`, `max_amount`, `offer_name`, `online`, `percentage`, `start_date_range`) VALUES
(1, 1, '2018-09-06 01:27:34', NULL, NULL, 1, '500', NULL, '4000', '500 off above 4000 ', NULL, NULL, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `master_price_drop`
--

DROP TABLE IF EXISTS `master_price_drop`;
CREATE TABLE IF NOT EXISTS `master_price_drop` (
  `price_drop_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `created_by` bigint(20) DEFAULT NULL,
  `created_date` varchar(255) DEFAULT NULL,
  `modified_by` bigint(20) DEFAULT NULL,
  `modified_date` varchar(255) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `after_time` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`price_drop_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

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

DROP TABLE IF EXISTS `master_property`;
CREATE TABLE IF NOT EXISTS `master_property` (
  `property_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `created_by` bigint(20) DEFAULT NULL,
  `created_date` varchar(255) DEFAULT NULL,
  `modified_by` bigint(20) DEFAULT NULL,
  `modified_date` varchar(255) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `address` text,
  `advance_percentage` varchar(255) DEFAULT NULL,
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
  `sex_category` varchar(255) DEFAULT NULL,
  `start_date` varchar(255) DEFAULT NULL,
  `strict_checkin` varchar(255) DEFAULT NULL,
  `host_vs_account_id` bigint(20) NOT NULL,
  `property_type_id` bigint(20) NOT NULL,
  `stay_type_id` bigint(20) NOT NULL,
  PRIMARY KEY (`property_id`),
  KEY `FKtb8mxoehi4doi7200iynq5k3i` (`host_vs_account_id`),
  KEY `FK5a00uodiowpit4s2fbuqgbm09` (`property_type_id`),
  KEY `FK156vy9s4sl5mh6nxjo74bg2rv` (`stay_type_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `master_property_type`
--

DROP TABLE IF EXISTS `master_property_type`;
CREATE TABLE IF NOT EXISTS `master_property_type` (
  `property_type_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `created_by` bigint(20) DEFAULT NULL,
  `created_date` varchar(255) DEFAULT NULL,
  `modified_by` bigint(20) DEFAULT NULL,
  `modified_date` varchar(255) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `language_id` bigint(20) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `parent_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`property_type_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

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

DROP TABLE IF EXISTS `master_room`;
CREATE TABLE IF NOT EXISTS `master_room` (
  `room_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `created_by` bigint(20) DEFAULT NULL,
  `created_date` varchar(255) DEFAULT NULL,
  `modified_by` bigint(20) DEFAULT NULL,
  `modified_date` varchar(255) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `accomodation_name` varchar(255) DEFAULT NULL,
  `commission` varchar(255) DEFAULT NULL,
  `cot_available` varchar(255) DEFAULT NULL,
  `cot_price` varchar(255) DEFAULT NULL,
  `host_discount_monthly` varchar(255) DEFAULT NULL,
  `host_discount_weekly` varchar(255) DEFAULT NULL,
  `no_of_child` varchar(255) DEFAULT NULL,
  `no_of_guest` varchar(255) DEFAULT NULL,
  `num_of_bed` varchar(255) DEFAULT NULL,
  `num_of_cot` varchar(255) DEFAULT NULL,
  `ora_discount_percentage` varchar(255) DEFAULT NULL,
  `ora_percentage` varchar(255) DEFAULT NULL,
  `room_current_status` varchar(255) DEFAULT NULL,
  `room_price_per_month` varchar(255) DEFAULT NULL,
  `room_price_per_night` varchar(255) DEFAULT NULL,
  `room_standard` varchar(255) DEFAULT NULL,
  `shared_bed_price` varchar(255) DEFAULT NULL,
  `shared_bed_price_per_month` varchar(255) DEFAULT NULL,
  `shared_bed_price_per_night` varchar(255) DEFAULT NULL,
  `shared_space` varchar(255) DEFAULT NULL,
  `property_id` bigint(20) NOT NULL,
  `room_cat_id` bigint(20) NOT NULL,
  PRIMARY KEY (`room_id`),
  KEY `FK44tv0dyh1xvs2elrr7yr3tr1x` (`property_id`),
  KEY `FKjw1vho56i8n32d1tyt64yh8ey` (`room_cat_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `master_room_category`
--

DROP TABLE IF EXISTS `master_room_category`;
CREATE TABLE IF NOT EXISTS `master_room_category` (
  `room_cat_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `created_by` bigint(20) DEFAULT NULL,
  `created_date` varchar(255) DEFAULT NULL,
  `modified_by` bigint(20) DEFAULT NULL,
  `modified_date` varchar(255) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `language_id` bigint(20) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `parent_id` bigint(20) DEFAULT NULL,
  `property_type_id` bigint(20) NOT NULL,
  PRIMARY KEY (`room_cat_id`),
  KEY `FKljipnikicv5k5pfpao2dflhpj` (`property_type_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

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

DROP TABLE IF EXISTS `master_space_rule`;
CREATE TABLE IF NOT EXISTS `master_space_rule` (
  `sprule_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `created_by` bigint(20) DEFAULT NULL,
  `created_date` varchar(255) DEFAULT NULL,
  `modified_by` bigint(20) DEFAULT NULL,
  `modified_date` varchar(255) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `language_id` bigint(20) DEFAULT NULL,
  `parent_id` bigint(20) DEFAULT NULL,
  `rule_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`sprule_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

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

DROP TABLE IF EXISTS `master_specialties`;
CREATE TABLE IF NOT EXISTS `master_specialties` (
  `specialties_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `created_by` bigint(20) DEFAULT NULL,
  `created_date` varchar(255) DEFAULT NULL,
  `modified_by` bigint(20) DEFAULT NULL,
  `modified_date` varchar(255) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `language_id` bigint(20) DEFAULT NULL,
  `parent_id` bigint(20) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`specialties_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

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

DROP TABLE IF EXISTS `master_special_experience`;
CREATE TABLE IF NOT EXISTS `master_special_experience` (
  `experience_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `created_by` bigint(20) DEFAULT NULL,
  `created_date` varchar(255) DEFAULT NULL,
  `modified_by` bigint(20) DEFAULT NULL,
  `modified_date` varchar(255) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `experience_name` varchar(255) DEFAULT NULL,
  `language_id` bigint(20) DEFAULT NULL,
  `parent_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`experience_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

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

DROP TABLE IF EXISTS `master_stay_type`;
CREATE TABLE IF NOT EXISTS `master_stay_type` (
  `stay_type_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `created_by` bigint(20) DEFAULT NULL,
  `created_date` varchar(255) DEFAULT NULL,
  `modified_by` bigint(20) DEFAULT NULL,
  `modified_date` varchar(255) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `language_id` bigint(20) DEFAULT NULL,
  `parent_id` bigint(20) DEFAULT NULL,
  `stay_type_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`stay_type_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

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

DROP TABLE IF EXISTS `master_wishlist`;
CREATE TABLE IF NOT EXISTS `master_wishlist` (
  `wishlist_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `created_by` bigint(20) DEFAULT NULL,
  `created_date` varchar(255) DEFAULT NULL,
  `modified_by` bigint(20) DEFAULT NULL,
  `modified_date` varchar(255) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  `property_id` bigint(20) NOT NULL,
  PRIMARY KEY (`wishlist_id`),
  KEY `FKqp3nmgc19tiysytctn29jkypy` (`property_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `meal_plan_cat_vs_meal_plan`
--

DROP TABLE IF EXISTS `meal_plan_cat_vs_meal_plan`;
CREATE TABLE IF NOT EXISTS `meal_plan_cat_vs_meal_plan` (
  `mpcmp_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `created_by` bigint(20) DEFAULT NULL,
  `created_date` varchar(255) DEFAULT NULL,
  `modified_by` bigint(20) DEFAULT NULL,
  `modified_date` varchar(255) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `mpc_id` bigint(20) NOT NULL,
  `meal_plan_id` bigint(20) NOT NULL,
  PRIMARY KEY (`mpcmp_id`),
  KEY `FKiqhjoqkinxg3b872k7m68xq13` (`mpc_id`),
  KEY `FKeuyapssqoidbnljl9l9lbq78u` (`meal_plan_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

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

DROP TABLE IF EXISTS `property_vs_description`;
CREATE TABLE IF NOT EXISTS `property_vs_description` (
  `property_desc_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `created_by` bigint(20) DEFAULT NULL,
  `created_date` varchar(255) DEFAULT NULL,
  `modified_by` bigint(20) DEFAULT NULL,
  `modified_date` varchar(255) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `description` text,
  `language_id` bigint(20) DEFAULT NULL,
  `property_id` bigint(20) NOT NULL,
  PRIMARY KEY (`property_desc_id`),
  KEY `FK53h3qarlglrohvb624pf128m2` (`property_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `property_vs_document`
--

DROP TABLE IF EXISTS `property_vs_document`;
CREATE TABLE IF NOT EXISTS `property_vs_document` (
  `property_vs_document_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `created_by` bigint(20) DEFAULT NULL,
  `created_date` varchar(255) DEFAULT NULL,
  `modified_by` bigint(20) DEFAULT NULL,
  `modified_date` varchar(255) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `document_number` varchar(255) DEFAULT NULL,
  `file_url` varchar(255) DEFAULT NULL,
  `document_id` bigint(20) NOT NULL,
  `property_id` bigint(20) NOT NULL,
  PRIMARY KEY (`property_vs_document_id`),
  KEY `FKfgbbjwhbs884wescouui8b3gk` (`document_id`),
  KEY `FKep8ggv1h9e7p36dim56nm6e2a` (`property_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `property_vs_experience`
--

DROP TABLE IF EXISTS `property_vs_experience`;
CREATE TABLE IF NOT EXISTS `property_vs_experience` (
  `property_exp_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `created_by` bigint(20) DEFAULT NULL,
  `created_date` varchar(255) DEFAULT NULL,
  `modified_by` bigint(20) DEFAULT NULL,
  `modified_date` varchar(255) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `property_id` bigint(20) NOT NULL,
  `experience_id` bigint(20) NOT NULL,
  PRIMARY KEY (`property_exp_id`),
  KEY `FK92o376xk6r7gls0he1aaugt7x` (`property_id`),
  KEY `FKn1s82f6oy0l1qh4mtmrdvjpx4` (`experience_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `property_vs_guest_access`
--

DROP TABLE IF EXISTS `property_vs_guest_access`;
CREATE TABLE IF NOT EXISTS `property_vs_guest_access` (
  `property_gaccess_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `created_by` bigint(20) DEFAULT NULL,
  `created_date` varchar(255) DEFAULT NULL,
  `modified_by` bigint(20) DEFAULT NULL,
  `modified_date` varchar(255) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `guest_access` varchar(255) DEFAULT NULL,
  `language_id` bigint(20) DEFAULT NULL,
  `property_id` bigint(20) NOT NULL,
  PRIMARY KEY (`property_gaccess_id`),
  KEY `FKg443u2hdb4sbrrnjwsrsxh7rk` (`property_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `property_vs_image`
--

DROP TABLE IF EXISTS `property_vs_image`;
CREATE TABLE IF NOT EXISTS `property_vs_image` (
  `property_image_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `created_by` bigint(20) DEFAULT NULL,
  `created_date` varchar(255) DEFAULT NULL,
  `modified_by` bigint(20) DEFAULT NULL,
  `modified_date` varchar(255) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `image_url` varchar(255) DEFAULT NULL,
  `property_id` bigint(20) NOT NULL,
  PRIMARY KEY (`property_image_id`),
  KEY `FKdrv8bc11h2o2m8uumykk4cu57` (`property_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `property_vs_nearby`
--

DROP TABLE IF EXISTS `property_vs_nearby`;
CREATE TABLE IF NOT EXISTS `property_vs_nearby` (
  `property_nearby_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `created_by` bigint(20) DEFAULT NULL,
  `created_date` varchar(255) DEFAULT NULL,
  `modified_by` bigint(20) DEFAULT NULL,
  `modified_date` varchar(255) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `latitude` varchar(255) DEFAULT NULL,
  `longitude` varchar(255) DEFAULT NULL,
  `places` varchar(255) DEFAULT NULL,
  `property_id` bigint(20) NOT NULL,
  PRIMARY KEY (`property_nearby_id`),
  KEY `FKru2h6pp77q418s5973c7125de` (`property_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `property_vs_pricedrop`
--

DROP TABLE IF EXISTS `property_vs_pricedrop`;
CREATE TABLE IF NOT EXISTS `property_vs_pricedrop` (
  `property_pricedrop_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `created_by` bigint(20) DEFAULT NULL,
  `created_date` varchar(255) DEFAULT NULL,
  `modified_by` bigint(20) DEFAULT NULL,
  `modified_date` varchar(255) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `percentage` varchar(255) DEFAULT NULL,
  `price_drop_id` bigint(20) NOT NULL,
  `property_id` bigint(20) NOT NULL,
  PRIMARY KEY (`property_pricedrop_id`),
  KEY `FKnna1ewhlvt6hf3dmqx3rwd91k` (`price_drop_id`),
  KEY `FKgwycvdturw8svnhj0pveb83bg` (`property_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `property_vs_space`
--

DROP TABLE IF EXISTS `property_vs_space`;
CREATE TABLE IF NOT EXISTS `property_vs_space` (
  `property_space_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `created_by` bigint(20) DEFAULT NULL,
  `created_date` varchar(255) DEFAULT NULL,
  `modified_by` bigint(20) DEFAULT NULL,
  `modified_date` varchar(255) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `answer` varchar(255) DEFAULT NULL,
  `property_id` bigint(20) NOT NULL,
  `sprule_id` bigint(20) NOT NULL,
  PRIMARY KEY (`property_space_id`),
  KEY `FKklkdybjqkwqcsydd52tcjt4g0` (`property_id`),
  KEY `FKhd1vunghcip4rtk0511i53tf7` (`sprule_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `room_vs_amenities`
--

DROP TABLE IF EXISTS `room_vs_amenities`;
CREATE TABLE IF NOT EXISTS `room_vs_amenities` (
  `room_vs_aminities_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `created_by` bigint(20) DEFAULT NULL,
  `created_date` varchar(255) DEFAULT NULL,
  `modified_by` bigint(20) DEFAULT NULL,
  `modified_date` varchar(255) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `aminities_id` bigint(20) NOT NULL,
  `room_id` bigint(20) NOT NULL,
  PRIMARY KEY (`room_vs_aminities_id`),
  KEY `FKm50c7up4jp1m0vl36325pktvw` (`aminities_id`),
  KEY `FKblve2wd06ghlbt72q1onnu1ib` (`room_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `room_vs_cancellation`
--

DROP TABLE IF EXISTS `room_vs_cancellation`;
CREATE TABLE IF NOT EXISTS `room_vs_cancellation` (
  `rc_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `created_by` bigint(20) DEFAULT NULL,
  `created_date` varchar(255) DEFAULT NULL,
  `modified_by` bigint(20) DEFAULT NULL,
  `modified_date` varchar(255) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `percentage` varchar(255) DEFAULT NULL,
  `cancellation_slab_id` bigint(20) NOT NULL,
  `room_id` bigint(20) NOT NULL,
  PRIMARY KEY (`rc_id`),
  KEY `FKr3pyo2gqwl71s8k5sm32rbjha` (`cancellation_slab_id`),
  KEY `FKemhbtji1nvg41xa261axnd7vr` (`room_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `room_vs_image`
--

DROP TABLE IF EXISTS `room_vs_image`;
CREATE TABLE IF NOT EXISTS `room_vs_image` (
  `room_vs_image_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `created_by` bigint(20) DEFAULT NULL,
  `created_date` varchar(255) DEFAULT NULL,
  `modified_by` bigint(20) DEFAULT NULL,
  `modified_date` varchar(255) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `image_url` varchar(255) DEFAULT NULL,
  `room_id` bigint(20) NOT NULL,
  PRIMARY KEY (`room_vs_image_id`),
  KEY `FKpamxay6j07bxeh97i0753dh6t` (`room_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `room_vs_meal`
--

DROP TABLE IF EXISTS `room_vs_meal`;
CREATE TABLE IF NOT EXISTS `room_vs_meal` (
  `room_vs_meal_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `created_by` bigint(20) DEFAULT NULL,
  `created_date` varchar(255) DEFAULT NULL,
  `modified_by` bigint(20) DEFAULT NULL,
  `modified_date` varchar(255) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `meal_days_friday` varchar(255) DEFAULT NULL,
  `meal_days_monday` varchar(255) DEFAULT NULL,
  `meal_days_saturday` varchar(255) DEFAULT NULL,
  `meal_days_sunday` varchar(255) DEFAULT NULL,
  `meal_days_thursday` varchar(255) DEFAULT NULL,
  `meal_days_tuesday` varchar(255) DEFAULT NULL,
  `meal_days_wednesday` varchar(255) DEFAULT NULL,
  `meal_price_category` varchar(255) DEFAULT NULL,
  `meal_type` varchar(255) DEFAULT NULL,
  `meal_plan_id` bigint(20) NOT NULL,
  `room_id` bigint(20) NOT NULL,
  PRIMARY KEY (`room_vs_meal_id`),
  KEY `FKfxh94m8ds7jaej9udbouh2alf` (`meal_plan_id`),
  KEY `FKbv9gqnudk5swt4bpm37f5p28b` (`room_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `room_vs_offer`
--

DROP TABLE IF EXISTS `room_vs_offer`;
CREATE TABLE IF NOT EXISTS `room_vs_offer` (
  `room_vs_offer_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `created_by` bigint(20) DEFAULT NULL,
  `created_date` varchar(255) DEFAULT NULL,
  `modified_by` bigint(20) DEFAULT NULL,
  `modified_date` varchar(255) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `offer_id` bigint(20) NOT NULL,
  `room_id` bigint(20) NOT NULL,
  PRIMARY KEY (`room_vs_offer_id`),
  KEY `FKfqux8yyo3blnp4xga6oa9ur78` (`offer_id`),
  KEY `FKeyvqqee0hpcmg61dl00kbqvt5` (`room_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `room_vs_specialties`
--

DROP TABLE IF EXISTS `room_vs_specialties`;
CREATE TABLE IF NOT EXISTS `room_vs_specialties` (
  `roomspec_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `created_by` bigint(20) DEFAULT NULL,
  `created_date` varchar(255) DEFAULT NULL,
  `modified_by` bigint(20) DEFAULT NULL,
  `modified_date` varchar(255) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `room_id` bigint(20) NOT NULL,
  `specialties_id` bigint(20) NOT NULL,
  PRIMARY KEY (`roomspec_id`),
  KEY `FKmjiqftc5rdrthmteghtchnkav` (`room_id`),
  KEY `FKoe11vqm2reg89jso2t6d4mm7d` (`specialties_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `user_vs_account`
--

DROP TABLE IF EXISTS `user_vs_account`;
CREATE TABLE IF NOT EXISTS `user_vs_account` (
  `host_vs_account_id` bigint(20) NOT NULL AUTO_INCREMENT,
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
  `user_id` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`host_vs_account_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

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
