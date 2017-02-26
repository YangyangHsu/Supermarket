/*
 Navicat MySQL Data Transfer

 Source Server         : Mac
 Source Server Version : 50714
 Source Host           : localhost
 Source Database       : Supermarket

 Target Server Version : 50714
 File Encoding         : utf-8

 Date: 01/18/2017 11:47:41 AM
*/

SET NAMES utf8;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `Cashier`
-- ----------------------------
DROP TABLE IF EXISTS `Cashier`;
CREATE TABLE `Cashier` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `cashierName` varchar(50) COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
--  Records of `Cashier`
-- ----------------------------
BEGIN;
INSERT INTO `Cashier` VALUES ('1', 'CashierA'), ('2', 'CashierB');
COMMIT;

-- ----------------------------
--  Table structure for `Customer`
-- ----------------------------
DROP TABLE IF EXISTS `Customer`;
CREATE TABLE `Customer` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `customerName` varchar(50) COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
--  Records of `Customer`
-- ----------------------------
BEGIN;
INSERT INTO `Customer` VALUES ('1', 'CustomerA'), ('2', 'CustomerB'), ('3', 'CustomerC'), ('4', 'CustomerD'), ('5', 'CustomerE');
COMMIT;

-- ----------------------------
--  Table structure for `Item`
-- ----------------------------
DROP TABLE IF EXISTS `Item`;
CREATE TABLE `Item` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `itemName` varchar(50) COLLATE utf8_bin NOT NULL,
  `itemCount` int(11) DEFAULT NULL,
  `itemPrice` double DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
--  Records of `Item`
-- ----------------------------
BEGIN;
INSERT INTO `Item` VALUES ('1', 'Apple', '2', '3'), ('2', 'Pear', '3', '3.5'), ('3', 'Peach', '1', '5'), ('4', 'Pineapple', '1', '12.5'), ('5', 'Coconut', '4', '17.8'), ('6', 'Banana', '2', '6'), ('7', 'Orange', '3', '3.5');
COMMIT;

-- ----------------------------
--  Table structure for `Payment`
-- ----------------------------
DROP TABLE IF EXISTS `Payment`;
CREATE TABLE `Payment` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `paymentStatus` int(11) NOT NULL DEFAULT '0',
  `customerId` int(11) DEFAULT NULL,
  `cashierId` int(11) DEFAULT NULL,
  `itemId` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `customerId` (`customerId`),
  KEY `cashierId` (`cashierId`),
  KEY `itemId` (`itemId`),
  CONSTRAINT `payment_ibfk_1` FOREIGN KEY (`customerId`) REFERENCES `Customer` (`id`),
  CONSTRAINT `payment_ibfk_2` FOREIGN KEY (`cashierId`) REFERENCES `Cashier` (`id`),
  CONSTRAINT `payment_ibfk_3` FOREIGN KEY (`itemId`) REFERENCES `Item` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
--  Records of `Payment`
-- ----------------------------
BEGIN;
INSERT INTO `Payment` VALUES ('1', '0', '1', '1', '2'), ('2', '1', '2', '1', '1'), ('3', '0', '4', '1', '7'), ('4', '0', '4', '1', '5'), ('5', '0', '3', '2', '4');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
