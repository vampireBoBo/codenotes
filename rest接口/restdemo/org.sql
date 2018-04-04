/*
Navicat MySQL Data Transfer

Source Server         : 192.168.9.19
Source Server Version : 50714
Source Host           : 192.168.9.19:3306
Source Database       : demo

Target Server Type    : MYSQL
Target Server Version : 50714
File Encoding         : 65001

Date: 2018-03-21 18:35:55
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `org`
-- ----------------------------
DROP TABLE IF EXISTS `org`;
CREATE TABLE `org` (
  `ono` varchar(200) NOT NULL COMMENT '组织编号',
  `oname` varchar(100) DEFAULT NULL COMMENT '组织名称',
  PRIMARY KEY (`ono`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of org
-- ----------------------------
INSERT INTO `org` VALUES ('1', '测试put');
INSERT INTO `org` VALUES ('2', '技术部');
