/*
Navicat MySQL Data Transfer

Source Server         : zzpigt
Source Server Version : 50632
Source Host           : localhost:3306
Source Database       : scott

Target Server Type    : MYSQL
Target Server Version : 50632
File Encoding         : 65001

Date: 2018-09-13 18:01:59
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for dept
-- ----------------------------
DROP TABLE IF EXISTS `dept`;
CREATE TABLE `dept` (
  `DEPTNO` int(11) NOT NULL DEFAULT '0',
  `DNAME` varchar(20) DEFAULT NULL,
  `LOC` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`DEPTNO`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of dept
-- ----------------------------
INSERT INTO `dept` VALUES ('10', 'ACCOUNTING', 'NEW YORK');
INSERT INTO `dept` VALUES ('20', 'RESEARCH', 'DALLAS');
INSERT INTO `dept` VALUES ('30', 'SALES', 'CHICAGO');
INSERT INTO `dept` VALUES ('40', 'OPERATIONS', 'BOSTON');
INSERT INTO `dept` VALUES ('50', '许帮', '北京');
INSERT INTO `dept` VALUES ('60', 'fuck', '北京');

-- ----------------------------
-- Table structure for emp
-- ----------------------------
DROP TABLE IF EXISTS `emp`;
CREATE TABLE `emp` (
  `EMPNO` int(11) NOT NULL DEFAULT '0',
  `ENAME` varchar(20) DEFAULT NULL,
  `JOB` varchar(20) DEFAULT NULL,
  `MGR` int(11) DEFAULT NULL,
  `HIREDATE` date DEFAULT NULL,
  `SAL` int(11) DEFAULT NULL,
  `COMM` int(11) DEFAULT NULL,
  `DEPTNO` int(11) DEFAULT NULL,
  PRIMARY KEY (`EMPNO`),
  KEY `FK_DEPTNO` (`DEPTNO`),
  CONSTRAINT `FK_DEPTNO` FOREIGN KEY (`DEPTNO`) REFERENCES `dept` (`DEPTNO`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of emp
-- ----------------------------
INSERT INTO `emp` VALUES ('7369', 'SMITH', 'CLERK', '7902', '1980-12-17', '800', null, '20');
INSERT INTO `emp` VALUES ('7499', 'ALLEN', 'SALESMAN', '7698', '1981-02-20', '1600', '300', '30');
INSERT INTO `emp` VALUES ('7521', 'WARD', 'SALESMAN', '7698', '1981-02-22', '1250', '500', '30');
INSERT INTO `emp` VALUES ('7566', 'JONES', 'MANAGER', '7839', '1981-04-02', '2975', null, '20');
INSERT INTO `emp` VALUES ('7654', 'MARTIN', 'SALESMAN', '7698', '1981-09-28', '1250', '1400', '30');
INSERT INTO `emp` VALUES ('7698', 'BLAKE', 'MANAGER', '7839', '1981-05-01', '2850', null, '30');
INSERT INTO `emp` VALUES ('7782', 'CLARK', 'MANAGER', '7839', '1981-06-09', '2450', null, '10');
INSERT INTO `emp` VALUES ('7788', 'SCOTT', 'ANALYST', '7566', '1987-04-19', '3000', null, '20');
INSERT INTO `emp` VALUES ('7839', 'KING', 'PRESIDENT', null, '1981-11-17', '5000', null, '10');
INSERT INTO `emp` VALUES ('7844', 'TURNER', 'SALESMAN', '7698', '1981-09-08', '1500', '0', '30');
INSERT INTO `emp` VALUES ('7876', 'ADAMS', 'CLERK', '7788', '1987-05-23', '1100', null, '20');
INSERT INTO `emp` VALUES ('7900', 'JAMES', 'CLERK', '7698', '1981-12-03', '950', null, '30');
INSERT INTO `emp` VALUES ('7902', 'FORD', 'ANALYST', '7566', '1981-12-03', '3000', null, '20');
INSERT INTO `emp` VALUES ('7934', 'MILLER', 'CLERK', '7782', '1982-01-23', '3000', null, '10');

-- ----------------------------
-- View structure for v_dep_deptno
-- ----------------------------
DROP VIEW IF EXISTS `v_dep_deptno`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `v_dep_deptno` AS select `dept`.`DEPTNO` AS `id`,`dept`.`DNAME` AS `name`,`dept`.`LOC` AS `loc` from `dept` ;

-- ----------------------------
-- View structure for v_emp_avgsal
-- ----------------------------
DROP VIEW IF EXISTS `v_emp_avgsal`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `v_emp_avgsal` AS select `dept`.`DNAME` AS `dname`,avg(`emp`.`SAL`) AS `avg(sal)` from (`dept` left join `emp` on((`emp`.`DEPTNO` = `dept`.`DEPTNO`))) group by `dept`.`DNAME` ;

-- ----------------------------
-- Procedure structure for proc1
-- ----------------------------
DROP PROCEDURE IF EXISTS `proc1`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `proc1`()
BEGIN
SELECT 1+1;

SELECT NOW();

SELECT LEFT('HHHHHH',2);

END
;;
DELIMITER ;

-- ----------------------------
-- Procedure structure for proce2
-- ----------------------------
DROP PROCEDURE IF EXISTS `proce2`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `proce2`(IN p INT)
BEGIN
SELECT p;
SET p = 2;
SELECT p;
END
;;
DELIMITER ;

-- ----------------------------
-- Function structure for func1
-- ----------------------------
DROP FUNCTION IF EXISTS `func1`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` FUNCTION `func1`(y INT) RETURNS int(11)
BEGIN
SET y = y +1;
RETURN y;
END
;;
DELIMITER ;
