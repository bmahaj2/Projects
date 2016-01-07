-- MySQL dump 10.13  Distrib 5.5.9, for Win32 (x86)
--
-- Host: localhost    Database: gps
-- ------------------------------------------------------
-- Server version	5.5.13

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Current Database: `gps`
--

CREATE DATABASE /*!32312 IF NOT EXISTS*/ `gps` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `gps`;

--
-- Table structure for table `admin`
--

DROP TABLE IF EXISTS `admin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
USE `gps`;

CREATE TABLE gps.`admin` (
  `username` varchar(20) NOT NULL,
  `password` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `admin`
--

LOCK TABLES `admin` WRITE;
/*!40000 ALTER TABLE `admin` DISABLE KEYS */;
INSERT INTO `admin` VALUES ('abc','123');
/*!40000 ALTER TABLE `admin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `complaints`
--

DROP TABLE IF EXISTS `complaints`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `complaints` (
  `complaintid` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(45) DEFAULT NULL,
  `emailid` varchar(45) DEFAULT NULL,
  `phone` bigint(20) DEFAULT NULL,
  `department` varchar(45) DEFAULT NULL,
  `complaint` varchar(500) DEFAULT NULL,
  `complaintsubject` varchar(100) DEFAULT NULL,
  `time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `status` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`complaintid`),
  KEY `fk11` (`username`),
  CONSTRAINT `fk11` FOREIGN KEY (`username`) REFERENCES `signup` (`username`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `complaints`
--

LOCK TABLES `complaints` WRITE;
/*!40000 ALTER TABLE `complaints` DISABLE KEYS */;
INSERT INTO `complaints` VALUES (1,'bhavyam','hjghjxgc',980656322,'Marketing','The condition of the vehicle in which I travel is very bad. Please replace it','vehicle condition','2014-05-17 06:48:27','pending'),(2,'bhavyam','jjjkk',980656322,'Marketing','The tracking app is crashing frequently','crashing app','2014-05-17 06:48:27','pending');
/*!40000 ALTER TABLE `complaints` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `courier_assignment`
--

DROP TABLE IF EXISTS `courier_assignment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `courier_assignment` (
  `courier_id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(100) DEFAULT NULL,
  `description` varchar(100) DEFAULT NULL,
  `employee` varchar(45) DEFAULT NULL,
  `IMEI` varchar(45) DEFAULT NULL,
  `source_location` varchar(100) DEFAULT NULL,
  `source_latitude` varchar(45) DEFAULT NULL,
  `source_longitude` varchar(45) DEFAULT NULL,
  `destination_location` varchar(100) DEFAULT NULL,
  `destination_latitude` varchar(45) DEFAULT NULL,
  `destination_longitude` varchar(45) DEFAULT NULL,
  `status` varchar(45) DEFAULT NULL,
  `date_of_dispatch` varchar(100) DEFAULT NULL,
  `date_of_delivery` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`courier_id`),
  KEY `fk3` (`employee`),
  CONSTRAINT `fk3` FOREIGN KEY (`employee`) REFERENCES `signup` (`username`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `courier_assignment`
--

LOCK TABLES `courier_assignment` WRITE;
/*!40000 ALTER TABLE `courier_assignment` DISABLE KEYS */;
INSERT INTO `courier_assignment` VALUES (3,'trousers','2 black trousers\r\n1 grey trousers','mohit32','911343500400108','VMM Education, INA Colony, Amritsar, Punjab','31.635908','74.87328500000001','Guru Nanak Dev University, Amritsar, Punjab','31.636087','74.82439399999998','pending',NULL,NULL),(5,'books','2 states,alchemist','mohit32','911343500400108','Golden temple in Amritsar, New Rajesh Nagar, Amritsar, Punjab','31.643543','74.90918499999998','Model Town, Nikku park road, Jalandhar, Punjab','31.30743','75.57930099999999','pending',NULL,NULL),(6,'shoes','1 pair black colored puma sports shoes','bhavyam',NULL,'Celebration Mall, Gagan Colony, Amritsar, Punjab','31.639142','74.89071999999999','Holiday Inn Amritsar Ranjit Avenue, Ranjit Avenue, Amritsar, Punjab','31.653508','74.86324200000001','pending',NULL,NULL),(7,'pendrives','2 sandisk cruzer blade pen drives','bhavyam','bh89h88945','AlphaOne Amritsar Shopping Mall, Amritsar, Punjab','31.619599','74.90793899999994','Amritsar Public School, Court Road, Guru Arjun Nagar, Amritsar, Punjab','31.633979','74.87226399999997','pending',NULL,NULL),(8,'memory card','1 sandisk 16gb memory card','akshat89','985','Kapsons, Chheharta, Amritsar, Punjab','31.628646','74.80238899999995','Ebony Mall, Mall Road, White Avenue, Amritsar, Punjab','31.642185','74.86943100000008','pending',NULL,NULL),(9,'phone','1 black coloured nexus 5','sunmeetd','89iuy789','Guru Nanak Dev Hospital, Medical Enclave, Amritsar, Punjab','31.654345','74.88616400000001','Holiday Inn Amritsar Ranjit Avenue, Ranjit Avenue, Amritsar, Punjab','31.653508','74.86324200000001','pending',NULL,NULL),(10,'phone','1 black coloured nexus 5','sunmeetd',NULL,'Guru Nanak Dev Hospital, Medical Enclave, Amritsar, Punjab','31.654345','74.88616400000001','Holiday Inn Amritsar Ranjit Avenue, Ranjit Avenue, Amritsar, Punjab','31.653508','74.86324200000001','pending',NULL,NULL);
/*!40000 ALTER TABLE `courier_assignment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `department`
--

DROP TABLE IF EXISTS `department`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `department` (
  `dept_id` int(11) NOT NULL,
  `dept_name` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`dept_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `department`
--

LOCK TABLES `department` WRITE;
/*!40000 ALTER TABLE `department` DISABLE KEYS */;
INSERT INTO `department` VALUES (1,'Marketing'),(2,'Sales'),(3,'Production'),(4,'Purchase');
/*!40000 ALTER TABLE `department` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `device_allotment`
--

DROP TABLE IF EXISTS `device_allotment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `device_allotment` (
  `Ser_no` int(11) NOT NULL AUTO_INCREMENT,
  `imei` varchar(45) DEFAULT NULL,
  `date_of_allotment` varchar(45) DEFAULT NULL,
  `releasedate` varchar(45) DEFAULT NULL,
  `username` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`Ser_no`),
  KEY `fk1` (`username`),
  KEY `fk2` (`imei`),
  CONSTRAINT `fk1` FOREIGN KEY (`username`) REFERENCES `signup` (`username`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk2` FOREIGN KEY (`imei`) REFERENCES `devices` (`IMEI`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `device_allotment`
--

LOCK TABLES `device_allotment` WRITE;
/*!40000 ALTER TABLE `device_allotment` DISABLE KEYS */;
INSERT INTO `device_allotment` VALUES (1,'911343500400108','2014/05/15 11:18:55',NULL,'mohit32'),(2,'5609876232','2014/05/15 12:08:40',NULL,'mohit32'),(3,'7654326','2014/05/15 12:10:15',NULL,'mohit32'),(4,'985','2014/05/15 12:13:06',NULL,'akshat89'),(5,'988','2014/05/15 12:13:17','2014/05/18 21:45:14','bharat3'),(6,'98e45yu','2014/05/15 12:13:28',NULL,'honey84'),(7,'abc','2014/05/15 12:13:38',NULL,'neha01'),(8,'1767hju87jhh8','2014/05/15 12:23:28',NULL,'rohan055'),(10,'34hjnnj344h4h','2014/05/15 12:24:30',NULL,'shreya09'),(11,'ko9098y7','2014/05/15 12:24:40',NULL,'shweta76'),(12,'u787kki88','2014/05/15 12:24:49','2014/05/15 12:26:41','sohan9'),(13,'bh89h88945','2014/05/15 22:34:03',NULL,'bhavyam'),(14,'mh49088723','2014/05/15 22:36:51',NULL,'bhavyam'),(15,'89iuy789','2014/05/18 17:15:58',NULL,'sunmeetd'),(16,'vvf334j889','2014/05/18 21:44:55',NULL,'sohan9');
/*!40000 ALTER TABLE `device_allotment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `devices`
--

DROP TABLE IF EXISTS `devices`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `devices` (
  `IMEI` varchar(45) NOT NULL,
  `phone_model` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`IMEI`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `devices`
--

LOCK TABLES `devices` WRITE;
/*!40000 ALTER TABLE `devices` DISABLE KEYS */;
INSERT INTO `devices` VALUES ('1767hju87jhh8','nexus 2'),('223qa','iphone4s'),('34hjnnj344h4h','lg optimus prime'),('5609876232','moto g'),('7654326','samsung galaxy y'),('76yu88jy77','moto x2'),('89iuy789','moto x'),('911343500400108','sony xperia x2'),('985','samsung galaxy s2'),('988','samsung galaxy s'),('98e45yu','nexus 5'),('abc','sony xperia z'),('bh89h88945','samsung galaxy s5'),('fd6768iuh','sony xperia x2'),('hhy6778','sony xperia p'),('jjki990077','sony xperia x'),('ko9098y7','samsung note 3'),('lki90876g','moto g'),('mh49088723','nexus 5'),('u787kki88','samsung note 2'),('vvf334j889','galaxy s2');
/*!40000 ALTER TABLE `devices` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `location`
--

DROP TABLE IF EXISTS `location`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `location` (
  `serial_no` int(11) NOT NULL AUTO_INCREMENT,
  `IMEI` bigint(20) DEFAULT NULL,
  `latitude` varchar(45) DEFAULT NULL,
  `longitude` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`serial_no`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `location`
--

LOCK TABLES `location` WRITE;
/*!40000 ALTER TABLE `location` DISABLE KEYS */;
INSERT INTO `location` VALUES (1,NULL,NULL,NULL),(2,NULL,NULL,NULL),(3,985,'45.68','56.45');
/*!40000 ALTER TABLE `location` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `messages`
--

DROP TABLE IF EXISTS `messages`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `messages` (
  `message_id` int(11) NOT NULL AUTO_INCREMENT,
  `message` varchar(500) DEFAULT NULL,
  `message_to` varchar(45) DEFAULT NULL,
  `date_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`message_id`)
) ENGINE=InnoDB AUTO_INCREMENT=40 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `messages`
--

LOCK TABLES `messages` WRITE;
/*!40000 ALTER TABLE `messages` DISABLE KEYS */;
INSERT INTO `messages` VALUES (1,' hello','bhavyam','2014-05-14 12:56:19'),(2,' hello','honey84','2014-05-14 12:56:52'),(3,' hi','mohit32','2014-05-15 14:41:52'),(4,'meeting at 3','mohit32','2014-05-15 14:41:52'),(5,'tomorrow is off','mohit32','2014-05-14 11:02:36'),(6,'cgjcjgcc','akshat89','2014-05-15 10:48:54'),(7,'important meeting','bhavyam','2014-05-16 12:16:01'),(8,'cgjcjgcc','mohit32','2014-05-15 10:48:54'),(9,'dggrf','akshat89','2014-05-15 12:35:14'),(10,'tomorrow is holiday','bhavyam','2014-05-16 12:16:01'),(11,'dggrf','mohit32','2014-05-15 12:35:14'),(12,'dtchfufjf','akshat89','2014-05-15 12:40:45'),(13,'happy diwali','bhavyam','2014-05-16 12:16:01'),(14,'dtchfufjf','mohit32','2014-05-15 12:40:46'),(15,'hkfkhfkh','akshat89','2014-05-15 12:43:19'),(16,'hkfkhfkh','bhavyam','2014-05-15 12:43:19'),(17,'hkfkhfkh','mohit32','2014-05-15 12:43:19'),(18,'theggrcbvf','shweta76','2014-05-15 13:11:34'),(19,'theggrcbvf','sunmeetd','2014-05-15 13:11:34'),(20,'theggrcbvf','varun8','2014-05-15 13:11:34'),(21,'hello','honey84','2014-05-15 14:17:11'),(22,'hello','neha01','2014-05-15 14:17:12'),(23,'hello','shreya09','2014-05-15 14:17:12'),(24,'youhey','akshat89','2014-05-15 14:27:49'),(25,'youhey','bhavyam','2014-05-15 14:27:49'),(26,'youhey','mohit32','2014-05-15 14:27:49'),(27,'happyholi','shweta76','2014-05-17 06:27:52'),(28,'happyholi','sunmeetd','2014-05-17 06:27:52'),(29,'happyholi','varun8','2014-05-17 06:27:52'),(33,'           \r\n        Increase in marketing is required to increase sales','akshat89','2014-05-18 11:52:48'),(34,'           \r\n        Increase in marketing is required to increase sales','bhavyam','2014-05-18 11:52:48'),(35,'           \r\n        Increase in marketing is required to increase sales','mohit32','2014-05-18 11:52:48'),(36,'more_raw_products_required_for_this_month','honey84','2014-05-18 15:16:36'),(37,'more_raw_products_required_for_this_month','neha01','2014-05-18 15:16:36'),(38,'more_raw_products_required_for_this_month','Raghav94','2014-05-18 15:16:36'),(39,'more_raw_products_required_for_this_month','shreya09','2014-05-18 15:16:36');
/*!40000 ALTER TABLE `messages` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `signup`
--

DROP TABLE IF EXISTS `signup`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `signup` (
  `username` varchar(45) NOT NULL,
  `firstname` varchar(45) DEFAULT NULL,
  `lastname` varchar(20) DEFAULT NULL,
  `email_id` varchar(45) DEFAULT NULL,
  `address` varchar(45) DEFAULT NULL,
  `mobile_no` bigint(20) DEFAULT NULL,
  `department_name` varchar(45) DEFAULT NULL,
  `date_of_birth` varchar(45) DEFAULT NULL,
  `date_of_joining` varchar(45) DEFAULT NULL,
  `photo` varchar(45) DEFAULT NULL,
  `password` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `signup`
--

LOCK TABLES `signup` WRITE;
/*!40000 ALTER TABLE `signup` DISABLE KEYS */;
INSERT INTO `signup` VALUES ('akshat89','akshat ','aggarwal','akshat8@gmail.com','98, mall road,shimla',8898998767,'Marketing','2014-05-13','2014-05-16','./uploads/images (1).jpg','66uqhv'),('bharat3','bharat','bhandari','bharatb@rediffmail.com','87, vasant vihar,jalandhar',9908767789,'Sales','2014-05-02','2014-05-29','./uploads/download (1).jpg','123'),('bhavyam','bhavya','mahajan','bhavyamahajan92@yahoo.com','980,sector-3,ranjit avenue,amritsar',7814992999,'Marketing','1992-11-01','2014-03-10','./uploads/pic1.jpg','123'),('honey84','honey','singh','honey8@gmail.com','99,hira avenue, lucknow',8878909878,'Purchase','2014-04-02','2014-04-18','./uploads/images (3).jpg','54pli'),('mohit32','mohit','verma','mohit34@gmail.com','mohit',980656322,'Marketing','1986-08-02','2008-08-08','./uploads/images (2).jpg','123'),('neha01','neha','mehra','neha.mehrap0@gmail.com','neha',9087684489,'Purchase','1991-12-09','2014-03-04','./uploads/images(7).jpg','30gnvj'),('Raghav94','Raghav','Aneja','rajanj88@gmail.com','Raghav',9087483761,'Purchase','1987-08-23','2014-03-12','./uploads/pas.jpg','13qfik'),('rohan055','rohan','sharma','rohan8@gmail.com','rohan',9875456524,'Sales','1987-09-03','2013-08-02','./uploads/images (5).jpg','09iou'),('shreya09','shreya','bhalla','shreyabhalla0987@yahoo.com','shreya',7896547865,'Purchase','1993-11-01','2013-09-08','./uploads/images (9).jpg','90blgu'),('shweta76','shweta','mahajan','shma76@hotmail.com','shweta',8907687907,'Production','1992-06-08','2012-09-06','./uploads/images (12).jpg','81oltp'),('sohan9','sohan','sharma','sohan98@gmail.com','9, basant avenue,amritar',9988009987,'Sales','2014-05-07','2014-05-15','./uploads/images.jpg','71egyv'),('sunmeetd','sunmeet','dhanju','sunmeetsinghdhanju@yahoo.com','sunmeet',987545232,'Production','1991-09-18','2014-05-01','./uploads/images (10).jpg','76ivlf'),('varun8','varun','jain','varun9@yahoo.com','6,pawan nagar, amritsar',8898009987,'Marketing','2014-05-01','2014-05-06','./uploads/22.jpg','79gpfr');
/*!40000 ALTER TABLE `signup` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `track_emphistory`
--

DROP TABLE IF EXISTS `track_emphistory`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `track_emphistory` (
  `serial_no` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(45) DEFAULT NULL,
  `IMEI` varchar(45) DEFAULT NULL,
  `latitude` varchar(45) DEFAULT NULL,
  `longitude` varchar(45) DEFAULT NULL,
  `date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`serial_no`),
  KEY `fk_4` (`username`),
  CONSTRAINT `fk_4` FOREIGN KEY (`username`) REFERENCES `signup` (`username`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=397 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `track_emphistory`
--

LOCK TABLES `track_emphistory` WRITE;
/*!40000 ALTER TABLE `track_emphistory` DISABLE KEYS */;
INSERT INTO `track_emphistory` VALUES (13,'mohit32','7654326','31.6366923','74.8741471','2014-05-15 14:40:45'),(14,'mohit32','7654326','31.6367021','74.8741642','2014-05-15 14:40:45'),(15,'mohit32','7654326','31.6367021','74.8741642','2014-05-15 14:40:45'),(16,'mohit32','7654326','31.6367021','74.8741642','2014-05-15 14:40:45'),(17,'mohit32','7654326','31.6367021','74.8741642','2014-05-15 14:40:45'),(18,'mohit32','7654326','31.6366432','74.874038','2014-05-15 14:40:45'),(19,'mohit32','7654326','31.6366432','74.874038','2014-05-15 14:40:45'),(20,'mohit32','7654326','0.0','0.0','2014-05-15 14:40:45'),(21,'mohit32','7654326','31.6366867','74.874106','2014-05-15 14:40:45'),(22,'mohit32','7654326','31.6366867','74.874106','2014-05-15 14:40:45'),(23,'mohit32','7654326','31.6366867','74.874106','2014-05-15 14:40:45'),(24,'mohit32','7654326','31.6366867','74.874106','2014-05-15 14:40:45'),(25,'mohit32','7654326','31.63667','74.8740814','2014-05-15 14:40:45'),(26,'mohit32','7654326','31.63667','74.8740814','2014-05-15 14:40:45'),(27,'mohit32','7654326','31.63667','74.8740814','2014-05-15 14:40:45'),(28,'mohit32','7654326','31.63667','74.8740814','2014-05-15 14:40:45'),(29,'mohit32','7654326','31.6366928','74.8741297','2014-05-15 14:40:45'),(30,'mohit32','7654326','31.6366928','74.8741297','2014-05-15 14:40:45'),(31,'mohit32','7654326','31.6366928','74.8741297','2014-05-15 14:40:45'),(32,'mohit32','7654326','31.6366928','74.8741297','2014-05-15 14:40:45'),(33,'mohit32','7654326','31.6366806','74.8741181','2014-05-15 14:40:45'),(34,'mohit32','7654326','31.6366806','74.8741181','2014-05-15 14:40:45'),(35,'mohit32','7654326','31.6366806','74.8741181','2014-05-15 14:40:45'),(36,'mohit32','7654326','31.6366806','74.8741181','2014-05-15 14:40:45'),(37,'mohit32','7654326','31.6366436','74.874038','2014-05-15 14:40:45'),(38,'mohit32','7654326','31.6366763','74.874094','2014-05-15 14:40:45'),(39,'mohit32','7654326','31.6366763','74.874094','2014-05-15 14:40:45'),(40,'mohit32','7654326','31.6366849','74.8741075','2014-05-15 14:40:45'),(41,'mohit32','7654326','31.6366849','74.8741075','2014-05-15 14:40:45'),(42,'mohit32','7654326','31.6366432','74.874038','2014-05-15 14:40:45'),(43,'mohit32','7654326','31.6366956','74.874134','2014-05-15 14:40:45'),(46,'mohit32','7654326','0.0','0.0','2014-05-15 14:40:45'),(47,'mohit32','7654326','0.0','0.0','2014-05-15 14:40:45'),(48,'mohit32','7654326','0.0','0.0','2014-05-15 14:40:45'),(49,'mohit32','7654326','0.0','0.0','2014-05-15 14:40:45'),(50,'mohit32','7654326','0.0','0.0','2014-05-15 14:40:45'),(51,'mohit32','7654326','0.0','0.0','2014-05-15 14:40:45'),(52,'mohit32','7654326','0.0','0.0','2014-05-15 14:40:45'),(53,'mohit32','7654326','0.0','0.0','2014-05-15 14:40:45'),(54,'mohit32','7654326','0.0','0.0','2014-05-15 14:40:45'),(55,'mohit32','7654326','0.0','0.0','2014-05-15 14:40:45'),(56,'mohit32','7654326','0.0','0.0','2014-05-15 14:40:45'),(57,'mohit32','7654326','0.0','0.0','2014-05-15 14:40:45'),(58,'mohit32','7654326','0.0','0.0','2014-05-15 14:40:45'),(59,'mohit32','7654326','0.0','0.0','2014-05-15 14:40:45'),(60,'mohit32','7654326','0.0','0.0','2014-05-15 14:40:45'),(61,'mohit32','7654326','0.0','0.0','2014-05-15 14:40:45'),(62,'mohit32','7654326','0.0','0.0','2014-05-15 14:40:45'),(63,'mohit32','7654326','0.0','0.0','2014-05-15 14:40:45'),(64,'mohit32','7654326','0.0','0.0','2014-05-15 14:40:45'),(65,'mohit32','7654326','0.0','0.0','2014-05-15 14:40:45'),(66,'mohit32','7654326','0.0','0.0','2014-05-15 14:40:45'),(67,'mohit32','7654326','0.0','0.0','2014-05-15 14:40:45'),(68,'mohit32','7654326','0.0','0.0','2014-05-15 14:40:45'),(69,'mohit32','7654326','0.0','0.0','2014-05-15 14:40:45'),(70,'mohit32','7654326','0.0','0.0','2014-05-15 14:40:45'),(71,'mohit32','7654326','0.0','0.0','2014-05-15 14:40:45'),(72,'mohit32','7654326','0.0','0.0','2014-05-15 14:40:45'),(73,'mohit32','7654326','0.0','0.0','2014-05-15 14:40:45'),(74,'mohit32','7654326','0.0','0.0','2014-05-15 14:40:45'),(75,'mohit32','7654326','0.0','0.0','2014-05-15 14:40:45'),(76,'mohit32','7654326','0.0','0.0','2014-05-15 14:40:45'),(77,'mohit32','7654326','0.0','0.0','2014-05-15 14:40:45'),(78,'mohit32','7654326','0.0','0.0','2014-05-15 14:40:45'),(79,'mohit32','7654326','0.0','0.0','2014-05-15 14:40:45'),(80,'mohit32','7654326','0.0','0.0','2014-05-15 14:40:45'),(81,'mohit32','7654326','0.0','0.0','2014-05-15 14:40:45'),(82,'mohit32','7654326','0.0','0.0','2014-05-15 14:40:45'),(83,'mohit32','7654326','0.0','0.0','2014-05-15 14:40:45'),(84,'mohit32','7654326','0.0','0.0','2014-05-15 14:40:45'),(85,'mohit32','7654326','0.0','0.0','2014-05-15 14:40:45'),(86,'mohit32','7654326','0.0','0.0','2014-05-15 14:40:45'),(87,'mohit32','7654326','0.0','0.0','2014-05-15 14:40:45'),(88,'mohit32','7654326','0.0','0.0','2014-05-15 14:40:45'),(89,'mohit32','7654326','0.0','0.0','2014-05-15 14:40:45'),(90,'mohit32','7654326','0.0','0.0','2014-05-15 14:40:45'),(91,'mohit32','7654326','0.0','0.0','2014-05-15 14:40:45'),(92,'mohit32','7654326','0.0','0.0','2014-05-15 14:40:45'),(93,'mohit32','7654326','0.0','0.0','2014-05-15 14:40:45'),(94,'mohit32','7654326','0.0','0.0','2014-05-15 14:40:45'),(95,'mohit32','7654326','0.0','0.0','2014-05-15 14:40:45'),(196,'mohit32','7654326','0.0','0.0','2014-05-15 14:40:45'),(197,'mohit32','7654326','31.6366923','74.8741471','2014-05-15 14:40:45'),(198,'mohit32','7654326','28.6100','77.2300','2014-05-15 14:40:45'),(199,'mohit32','7654326','18.9750','72.8258','2014-05-15 14:40:45'),(200,'mohit32','7654326','31.6366923','74.8741471','2014-05-15 14:40:45'),(201,'mohit32','7654326','31.6365332','74.8742773','2014-05-15 14:40:45'),(202,'mohit32','7654326','31.6365332','74.8742773','2014-05-15 14:40:45'),(203,'mohit32','7654326','31.6365332','74.8742773','2014-05-15 14:40:45'),(204,'mohit32','7654326','31.6365332','74.8742773','2014-05-15 14:40:45'),(205,'mohit32','7654326','18.9750','72.8258','2014-05-15 14:40:45'),(206,'mohit32','7654326','28.6100','77.2300','2014-05-15 14:40:45'),(207,'mohit32','7654326','31.6365398','74.8742786','2014-05-15 14:40:45'),(208,'mohit32','7654326','31.6365398','74.8742786','2014-05-15 14:40:45'),(209,'mohit32','7654326','31.6365359','74.8742872','2014-05-15 14:40:45'),(210,'mohit32','7654326','31.6365359','74.8742872','2014-05-15 14:40:45'),(211,'mohit32','7654326','31.6365359','74.8742872','2014-05-15 14:40:45'),(212,'mohit32','7654326','31.6365359','74.8742872','2014-05-15 14:40:45'),(213,'mohit32','7654326','31.6366932','74.8741454','2014-05-15 14:40:45'),(214,'mohit32','7654326','31.6366932','74.8741454','2014-05-15 14:40:45'),(215,'mohit32','7654326','31.6366932','74.8741454','2014-05-15 14:40:45'),(216,'mohit32','7654326','31.6366932','74.8741454','2014-05-15 14:40:45'),(217,'mohit32','7654326','31.6366853','74.8741429','2014-05-15 14:40:45'),(218,'mohit32','7654326','31.6366853','74.8741429','2014-05-15 14:40:45'),(219,'mohit32','7654326','31.6366853','74.8741429','2014-05-15 14:40:45'),(220,'mohit32','7654326','31.6366853','74.8741429','2014-05-15 14:40:45'),(221,'mohit32','7654326','31.6367023','74.8741727','2014-05-15 14:40:45'),(222,'mohit32','7654326','31.6367023','74.8741727','2014-05-15 14:40:45'),(223,'mohit32','7654326','31.6367023','74.8741727','2014-05-15 14:40:45'),(224,'mohit32','7654326','31.6367023','74.8741727','2014-05-15 14:40:45'),(225,'mohit32','7654326','31.6366834','74.8741285','2014-05-15 14:40:45'),(226,'mohit32','7654326','31.6366834','74.8741285','2014-05-15 14:40:45'),(227,'mohit32','7654326','31.6366834','74.8741285','2014-05-15 14:40:45'),(228,'mohit32','7654326','31.6366834','74.8741285','2014-05-15 14:40:45'),(229,'mohit32','7654326','31.6366802','74.8741296','2014-05-15 14:40:45'),(230,'mohit32','7654326','31.6366802','74.8741296','2014-05-15 14:40:45'),(231,'mohit32','7654326','31.6366802','74.8741296','2014-05-15 14:40:45'),(232,'mohit32','7654326','31.6366802','74.8741296','2014-05-15 14:40:45'),(233,'mohit32','7654326','31.6366888','74.8741504','2014-05-15 14:40:45'),(234,'mohit32','7654326','31.6366888','74.8741504','2014-05-15 14:40:45'),(235,'mohit32','7654326','31.6366888','74.8741504','2014-05-15 14:40:45'),(236,'mohit32','7654326','31.6366888','74.8741504','2014-05-15 14:40:45'),(237,'mohit32','7654326','31.6366756','74.8741032','2014-05-15 14:40:45'),(238,'mohit32','7654326','31.6366756','74.8741032','2014-05-15 14:40:45'),(239,'mohit32','7654326','31.6366756','74.8741032','2014-05-15 14:40:45'),(240,'mohit32','7654326','31.6366756','74.8741032','2014-05-15 14:40:45'),(241,'mohit32','7654326','31.6365374','74.8714909','2014-05-15 14:40:45'),(242,'mohit32','7654326','31.6365374','74.8714909','2014-05-15 14:40:45'),(243,'mohit32','7654326','31.6365374','74.8714909','2014-05-15 14:40:45'),(244,'mohit32','7654326','31.6365374','74.8714909','2014-05-15 14:40:45'),(245,'mohit32','7654326','31.6366834','74.8741232','2014-05-15 14:40:45'),(246,'mohit32','7654326','31.6366834','74.8741232','2014-05-15 14:40:45'),(247,'mohit32','7654326','31.6366834','74.8741232','2014-05-15 14:40:45'),(248,'mohit32','7654326','31.6366834','74.8741232','2014-05-15 14:40:45'),(249,'mohit32','7654326','31.6366858','74.8741261','2014-05-15 14:40:45'),(250,'mohit32','7654326','31.6366858','74.8741261','2014-05-15 14:40:45'),(251,'mohit32','7654326','31.6366858','74.8741261','2014-05-15 14:40:45'),(252,'mohit32','7654326','31.6366858','74.8741261','2014-05-15 14:40:45'),(253,'mohit32','7654326','31.6365495','74.8742357','2014-05-15 14:40:45'),(254,'mohit32','7654326','31.6365495','74.8742357','2014-05-15 14:40:45'),(255,'mohit32','7654326','31.6365495','74.8742357','2014-05-15 14:40:45'),(256,'mohit32','7654326','31.6365495','74.8742357','2014-05-15 14:40:45'),(257,'mohit32','7654326','31.6365897','74.8742037','2014-05-15 14:40:45'),(258,'mohit32','7654326','31.6365897','74.8742037','2014-05-15 14:40:45'),(259,'mohit32','7654326','31.6365897','74.8742037','2014-05-15 14:40:45'),(260,'mohit32','7654326','31.6365897','74.8742037','2014-05-15 14:40:45'),(261,'mohit32','7654326','31.6366983','74.8741445','2014-05-15 14:40:45'),(262,'mohit32','7654326','31.6366983','74.8741445','2014-05-15 14:40:45'),(263,'mohit32','7654326','31.6366983','74.8741445','2014-05-15 14:40:45'),(264,'mohit32','7654326','31.6366983','74.8741445','2014-05-15 14:40:45'),(265,'mohit32','7654326','31.6366863','74.8741196','2014-05-15 14:40:45'),(266,'mohit32','7654326','31.6366863','74.8741196','2014-05-15 14:40:45'),(267,'mohit32','7654326','31.6366863','74.8741196','2014-05-15 14:40:45'),(268,'mohit32','7654326','31.6366863','74.8741196','2014-05-15 14:40:45'),(269,'mohit32','7654326','31.6366863','74.8741196','2014-05-15 14:40:45'),(270,'mohit32','7654326','31.6366863','74.8741196','2014-05-15 14:40:45'),(271,'mohit32','7654326','31.6366863','74.8741196','2014-05-15 14:40:45'),(272,'mohit32','7654326','31.6366863','74.8741196','2014-05-15 14:40:45'),(273,'mohit32','7654326','31.6366833','74.874119','2014-05-15 14:40:45'),(274,'mohit32','7654326','31.6366833','74.874119','2014-05-15 14:40:45'),(275,'mohit32','7654326','31.6366833','74.874119','2014-05-15 14:40:45'),(276,'mohit32','7654326','31.6366833','74.874119','2014-05-15 14:40:45'),(277,'mohit32','7654326','31.6366904','74.8741447','2014-05-15 14:40:45'),(278,'mohit32','7654326','31.6366904','74.8741447','2014-05-15 14:40:45'),(279,'mohit32','7654326','31.6366924','74.8741406','2014-05-15 14:40:45'),(280,'mohit32','7654326','31.6366924','74.8741406','2014-05-15 14:40:45'),(281,'mohit32','7654326','18.9750','72.8258','2014-05-15 14:40:45'),(282,'mohit32','7654326','26.4607','80.3334','2014-05-15 14:40:45'),(283,'mohit32','7654326','31.3260','75.5760','2014-05-15 14:40:45'),(284,'mohit32','7654326','26.8470','80.9470','2014-05-15 14:40:45'),(285,'mohit32','7654326','13.0839','80.2700','2014-05-15 14:40:45'),(286,'mohit32','7654326','0.0','0.0','2014-05-15 14:40:45'),(287,'mohit32','7654326','31.6363882','74.8743083','2014-05-15 14:40:45'),(288,'mohit32','7654326','31.6363882','74.8743083','2014-05-15 14:40:45'),(289,'mohit32','7654326','31.6363882','74.8743083','2014-05-15 14:40:45'),(290,'mohit32','7654326','31.6363882','74.8743083','2014-05-15 14:40:45'),(291,'mohit32','7654326','31.63629','74.8744648','2014-05-15 14:40:45'),(292,'mohit32','7654326','31.63629','74.8744648','2014-05-15 14:40:45'),(293,'mohit32','7654326','31.63629','74.8744648','2014-05-15 14:40:45'),(294,'mohit32','7654326','31.63629','74.8744648','2014-05-15 14:40:45'),(295,'mohit32','7654326','31.636122','74.8746208','2014-05-15 14:40:45'),(296,'mohit32','7654326','31.636122','74.8746208','2014-05-15 14:40:45'),(297,'mohit32','7654326','31.636122','74.8746208','2014-05-15 14:40:45'),(298,'mohit32','7654326','31.6362262','74.8745004','2014-05-15 14:40:45'),(299,'mohit32','7654326','31.6362262','74.8745004','2014-05-15 14:40:45'),(300,'mohit32','7654326','31.6362262','74.8745004','2014-05-15 14:40:45'),(301,'mohit32','7654326','31.6363995','74.8745107','2014-05-15 14:40:45'),(302,'mohit32','7654326','31.6363995','74.8745107','2014-05-15 14:40:45'),(303,'mohit32','7654326','31.6361817','74.8746111','2014-05-15 14:40:45'),(304,'mohit32','7654326','31.6363179','74.8744715','2014-05-15 14:40:45'),(305,'mohit32','7654326','31.6363179','74.8744715','2014-05-15 14:40:45'),(306,'mohit32','7654326','31.6363179','74.8744715','2014-05-15 14:40:45'),(307,'mohit32','7654326','31.6362755','74.874528','2014-05-15 14:40:45'),(308,'mohit32','7654326','31.6362755','74.874528','2014-05-15 14:40:45'),(309,'mohit32','7654326','31.6362755','74.874528','2014-05-15 14:40:45'),(310,'mohit32','7654326','31.6365199','74.874219','2014-05-15 14:40:45'),(311,'mohit32','7654326','31.6365199','74.874219','2014-05-15 14:40:45'),(312,'mohit32','7654326','31.6365199','74.874219','2014-05-15 14:40:45'),(313,'mohit32','7654326','31.6361246','74.8746181','2014-05-15 14:40:45'),(314,'mohit32','7654326','31.6361246','74.8746181','2014-05-15 14:40:45'),(315,'mohit32','7654326','31.6361246','74.8746181','2014-05-15 14:40:45'),(316,'mohit32','7654326','31.6361974','74.874593','2014-05-15 14:40:45'),(317,'mohit32','7654326','31.6361974','74.874593','2014-05-15 14:40:45'),(318,'mohit32','7654326','31.6361974','74.874593','2014-05-15 14:40:45'),(319,'mohit32','7654326','31.6361175','74.8746261','2014-05-15 14:40:45'),(320,'mohit32','7654326','31.6361175','74.8746261','2014-05-15 14:40:45'),(321,'mohit32','7654326','31.636121','74.8746234','2014-05-15 14:40:45'),(322,'mohit32','7654326','31.636121','74.8746234','2014-05-15 14:40:45'),(323,'mohit32','7654326','31.6362964','74.8744618','2014-05-15 14:40:45'),(324,'mohit32','7654326','31.6362964','74.8744618','2014-05-15 14:40:45'),(325,'mohit32','7654326','31.6362964','74.8744618','2014-05-15 14:40:45'),(326,'mohit32','7654326','31.6362859','74.8745267','2014-05-15 14:40:45'),(327,'mohit32','7654326','31.6362859','74.8745267','2014-05-15 14:40:45'),(328,'mohit32','7654326','31.6361657','74.8746261','2014-05-15 14:40:45'),(329,'mohit32','7654326','31.6361657','74.8746261','2014-05-15 14:40:45'),(330,'mohit32','7654326','31.6365322','74.8741713','2014-05-15 14:40:45'),(331,'mohit32','7654326','31.6365322','74.8741713','2014-05-15 14:40:45'),(332,'mohit32','7654326','31.6365322','74.8741713','2014-05-15 14:40:45'),(333,'mohit32','7654326','31.6361131','74.87463','2014-05-15 14:40:45'),(334,'mohit32','7654326','31.6361131','74.87463','2014-05-15 14:40:45'),(335,'mohit32','7654326','31.6361131','74.87463','2014-05-15 14:40:45'),(336,'mohit32','7654326','31.6361761','74.8746147','2014-05-15 14:40:45'),(337,'mohit32','7654326','31.6361761','74.8746147','2014-05-15 14:40:45'),(338,'mohit32','7654326','31.6361761','74.8746147','2014-05-15 14:40:45'),(339,'mohit32','7654326','31.6361761','74.8746147','2014-05-15 14:40:45'),(340,'mohit32','7654326','31.6361463','74.8746368','2014-05-15 14:40:45'),(341,'mohit32','7654326','31.6361463','74.8746368','2014-05-15 14:40:45'),(342,'mohit32','7654326','31.6361463','74.8746368','2014-05-15 14:40:45'),(343,'mohit32','7654326','31.6361463','74.8746368','2014-05-15 14:40:45'),(344,'mohit32','7654326','31.6361146','74.8746312','2014-05-15 14:40:45'),(345,'mohit32','7654326','31.6361146','74.8746312','2014-05-15 14:40:45'),(346,'mohit32','7654326','31.6361146','74.8746312','2014-05-15 14:40:45'),(347,'mohit32','7654326','31.6361146','74.8746312','2014-05-15 14:40:45'),(348,'mohit32','7654326','31.6361242','74.8746185','2014-05-15 14:40:45'),(349,'mohit32','7654326','31.6361242','74.8746185','2014-05-15 14:40:45'),(350,'mohit32','7654326','31.6361242','74.8746185','2014-05-15 14:40:45'),(351,'mohit32','7654326','31.6361242','74.8746185','2014-05-15 14:40:45'),(352,'mohit32','7654326','31.6361128','74.874633','2014-05-15 14:40:45'),(353,'mohit32','7654326','31.6361128','74.874633','2014-05-15 14:40:45'),(354,'mohit32','7654326','31.6361128','74.874633','2014-05-15 14:40:45'),(355,'mohit32','7654326','31.6361128','74.874633','2014-05-15 14:40:45'),(356,'mohit32','7654326','31.6361907','74.8746042','2014-05-15 14:40:45'),(357,'mohit32','7654326','31.6361907','74.8746042','2014-05-15 14:40:45'),(358,'mohit32','7654326','31.6361907','74.8746042','2014-05-15 14:40:45'),(359,'mohit32','7654326','31.6361907','74.8746042','2014-05-15 14:40:45'),(360,'mohit32','7654326','31.6362366','74.8745716','2014-05-15 14:40:45'),(361,'mohit32','7654326','31.6362366','74.8745716','2014-05-15 14:40:45'),(362,'mohit32','7654326','31.6362366','74.8745716','2014-05-15 14:40:45'),(363,'mohit32','7654326','31.6362561','74.8745586','2014-05-15 14:40:45'),(364,'mohit32','7654326','31.6362561','74.8745586','2014-05-15 14:40:45'),(365,'mohit32','7654326','31.6362561','74.8745586','2014-05-15 14:40:45'),(366,'mohit32','7654326','31.6362561','74.8745586','2014-05-15 14:40:45'),(367,'mohit32','7654326','31.6362115','74.8745595','2014-05-15 14:40:45'),(368,'mohit32','7654326','31.6362115','74.8745595','2014-05-15 14:40:45'),(369,'mohit32','7654326','31.6362115','74.8745595','2014-05-15 14:40:45'),(370,'mohit32','7654326','31.6362115','74.8745595','2014-05-15 14:40:45'),(371,'mohit32','7654326','31.6361888','74.8746007','2014-05-15 14:40:45'),(372,'mohit32','7654326','31.6361888','74.8746007','2014-05-15 14:40:45'),(373,'mohit32','7654326','31.6361888','74.8746007','2014-05-15 14:40:45'),(374,'mohit32','7654326','31.6361888','74.8746007','2014-05-15 14:40:45'),(375,'mohit32','7654326','31.6361092','74.8746353','2014-05-15 14:40:45'),(376,'mohit32','7654326','31.6361092','74.8746353','2014-05-15 14:40:45'),(377,'mohit32','7654326','31.6361092','74.8746353','2014-05-15 14:40:45'),(378,'mohit32','7654326','31.6361092','74.8746353','2014-05-15 14:40:45'),(379,'mohit32','7654326','31.6362363','74.8745584','2014-05-15 14:40:45'),(380,'mohit32','7654326','31.6362363','74.8745584','2014-05-15 14:40:45'),(381,'mohit32','7654326','31.6362363','74.8745584','2014-05-15 14:40:45'),(382,'mohit32','7654326','31.6362363','74.8745584','2014-05-15 14:40:45'),(383,'mohit32','7654326','31.6361264','74.8746176','2014-05-15 14:40:45'),(384,'mohit32','7654326','31.6361319','74.874608','2014-05-15 14:40:45'),(385,'mohit32','7654326','31.6361319','74.874608','2014-05-15 14:40:45'),(386,'mohit32','7654326','31.6361319','74.874608','2014-05-15 14:40:45'),(387,'mohit32','7654326','31.6361319','74.874608','2014-05-15 14:40:45'),(388,'mohit32','7654326','31.6361093','74.8746349','2014-05-15 14:40:45'),(389,'mohit32','7654326','31.6361093','74.8746349','2014-05-15 14:40:45'),(390,'mohit32','7654326','31.3260','75.5760','2014-05-15 14:41:13'),(391,'mohit32','7654326','31.6361093','74.8746349','2014-05-15 14:42:45'),(392,'mohit32','7654326','31.9167','75.2500','2014-05-15 14:43:29'),(393,'bhavyam','bh89h88945','31.6361319','74.874608','2014-05-15 14:44:45'),(394,'bhavyam','bh89h88945','31.3260','75.5760','2014-05-16 15:20:45'),(395,'bhavyam','bh89h88945','30.8833','75.8500','2014-05-17 09:00:45'),(396,'bhavyam','bh89h88945','26.8470','80.9470','2014-05-17 10:00:45');
/*!40000 ALTER TABLE `track_emphistory` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2014-05-19  1:02:33
