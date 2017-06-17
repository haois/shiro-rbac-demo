/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 50624
Source Host           : localhost:3306
Source Database       : gcushiro

Target Server Type    : MYSQL
Target Server Version : 50624
File Encoding         : 65001

Date: 2017-06-17 20:35:15
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for img_res
-- ----------------------------
DROP TABLE IF EXISTS `img_res`;
CREATE TABLE `img_res` (
  `id` int(11) NOT NULL,
  `img_name` varchar(255) DEFAULT NULL,
  `create_time` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of img_res
-- ----------------------------

-- ----------------------------
-- Table structure for t_resource
-- ----------------------------
DROP TABLE IF EXISTS `t_resource`;
CREATE TABLE `t_resource` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `url` varchar(255) DEFAULT NULL,
  `permission` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_resource
-- ----------------------------
INSERT INTO `t_resource` VALUES ('1', '全部权限', '/**', '');
INSERT INTO `t_resource` VALUES ('2', '用户列表', '/user/list', 'user:list');
INSERT INTO `t_resource` VALUES ('3', '用户增加', '/user/add', 'user:add');
INSERT INTO `t_resource` VALUES ('4', '更新用户', '/user/update', 'user:update');
INSERT INTO `t_resource` VALUES ('5', '查看更新', '/user/update/*', 'user:update:*');
INSERT INTO `t_resource` VALUES ('6', '增加资源', '/res/add', '');

-- ----------------------------
-- Table structure for t_role
-- ----------------------------
DROP TABLE IF EXISTS `t_role`;
CREATE TABLE `t_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `sn` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_role
-- ----------------------------
INSERT INTO `t_role` VALUES ('1', '超级管理员', 'SUPER');
INSERT INTO `t_role` VALUES ('2', '普通管理员', 'ADMIN');
INSERT INTO `t_role` VALUES ('3', '测试人员', 'TEST');
INSERT INTO `t_role` VALUES ('4', '普通人员', 'SIMPLE');

-- ----------------------------
-- Table structure for t_role_res
-- ----------------------------
DROP TABLE IF EXISTS `t_role_res`;
CREATE TABLE `t_role_res` (
  `roleId` int(11) DEFAULT NULL,
  `resId` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_role_res
-- ----------------------------
INSERT INTO `t_role_res` VALUES ('1', '1');
INSERT INTO `t_role_res` VALUES ('2', '2');
INSERT INTO `t_role_res` VALUES ('3', '3');
INSERT INTO `t_role_res` VALUES ('3', '4');
INSERT INTO `t_role_res` VALUES ('3', '2');
INSERT INTO `t_role_res` VALUES ('4', '6');

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `nickname` varchar(255) DEFAULT NULL,
  `status` int(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES ('1', 'gcu', 'd127f4bc39f0f1fe3ded2ba7ef9b9282', '张瑞昊', '1');
INSERT INTO `t_user` VALUES ('2', 'hgits', '12cef2430fcae67844d398c8e8f6d01e', '张', '0');
INSERT INTO `t_user` VALUES ('5', 'haois', '4e130dd6eeabeadfc02bbf19da3556f7', '张', '1');
INSERT INTO `t_user` VALUES ('7', '啊', '47c6b15aca93873f58522f26300d181d', '张', '1');
INSERT INTO `t_user` VALUES ('9', 'zhang', '78d7c325e6ea326d9c1a5c5b1172a59d', 'zhang', '1');

-- ----------------------------
-- Table structure for t_user_role
-- ----------------------------
DROP TABLE IF EXISTS `t_user_role`;
CREATE TABLE `t_user_role` (
  `userId` int(11) DEFAULT NULL,
  `roleId` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user_role
-- ----------------------------
INSERT INTO `t_user_role` VALUES ('1', '1');
INSERT INTO `t_user_role` VALUES ('5', '3');
INSERT INTO `t_user_role` VALUES ('7', '3');
INSERT INTO `t_user_role` VALUES ('9', '1');
