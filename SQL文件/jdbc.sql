/*
Navicat MySQL Data Transfer

Source Server         : zzpigt
Source Server Version : 50632
Source Host           : localhost:3306
Source Database       : jdbc

Target Server Type    : MYSQL
Target Server Version : 50632
File Encoding         : 65001

Date: 2018-09-13 18:01:38
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for record
-- ----------------------------
DROP TABLE IF EXISTS `record`;
CREATE TABLE `record` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `connect` varchar(255) NOT NULL,
  `date` datetime NOT NULL,
  `uid` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_uid` (`uid`),
  CONSTRAINT `fk_uid` FOREIGN KEY (`uid`) REFERENCES `users` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of record
-- ----------------------------
INSERT INTO `record` VALUES ('19', 'aa登入系统 ', '2018-09-10 16:38:30', '10');
INSERT INTO `record` VALUES ('20', 'aa存了500.0元', '2018-09-10 16:38:36', '10');
INSERT INTO `record` VALUES ('21', 'aa取了200.0元', '2018-09-10 16:38:39', '10');
INSERT INTO `record` VALUES ('22', 'aa取了300.0元', '2018-09-10 16:38:42', '10');
INSERT INTO `record` VALUES ('23', 'aa登入系统 ', '2018-09-10 16:44:51', '10');
INSERT INTO `record` VALUES ('24', 'aa存了500.0元', '2018-09-10 16:44:53', '10');
INSERT INTO `record` VALUES ('25', 'aa取了200.0元', '2018-09-10 16:44:56', '10');
INSERT INTO `record` VALUES ('26', 'aa取了300.0元', '2018-09-10 16:44:58', '10');
INSERT INTO `record` VALUES ('27', 'aa登入系统 ', '2018-09-10 16:56:55', '10');
INSERT INTO `record` VALUES ('28', 'aa存了300.0元', '2018-09-10 16:57:03', '10');
INSERT INTO `record` VALUES ('29', 'aa取了100.0元', '2018-09-10 16:57:17', '10');
INSERT INTO `record` VALUES ('30', 'aa给bb转账了400.0元', '2018-09-10 16:57:25', '10');
INSERT INTO `record` VALUES ('31', 'bb登入系统 ', '2018-09-10 17:04:27', '11');
INSERT INTO `record` VALUES ('32', 'bb登入系统 ', '2018-09-10 17:06:40', '11');
INSERT INTO `record` VALUES ('33', 'bb存了200.0元', '2018-09-10 17:06:49', '11');
INSERT INTO `record` VALUES ('34', 'bb登入系统 ', '2018-09-10 17:42:24', '11');
INSERT INTO `record` VALUES ('35', 'bb给aa转账了100.0元', '2018-09-10 17:42:29', '11');
INSERT INTO `record` VALUES ('36', 'cc登入系统 ', '2018-09-12 15:31:13', '13');

-- ----------------------------
-- Table structure for users
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `pwd` varchar(255) NOT NULL,
  `money` double DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of users
-- ----------------------------
INSERT INTO `users` VALUES ('10', 'aa', '123', '100');
INSERT INTO `users` VALUES ('11', 'tong', 'fuckyou444', '555');
INSERT INTO `users` VALUES ('13', 'cc', '123', null);
