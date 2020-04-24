/*
 Navicat Premium Data Transfer

 Source Server         : dd
 Source Server Type    : MySQL
 Source Server Version : 80016
 Source Host           : localhost:3306
 Source Schema         : scholarship

 Target Server Type    : MySQL
 Target Server Version : 80016
 File Encoding         : 65001

 Date: 22/04/2020 21:29:28
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for comment
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userName` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  `comment` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `createTime` timestamp NULL DEFAULT NULL,
  `flag` int(10) DEFAULT NULL,
  `reply` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `replyUserName` varchar(11) COLLATE utf8_bin DEFAULT NULL,
  `replyTime` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Table structure for notice
-- ----------------------------
DROP TABLE IF EXISTS `notice`;
CREATE TABLE `notice` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `createUserId` int(20) DEFAULT NULL,
  `content` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `flag` int(255) DEFAULT NULL,
  `createTime` timestamp NULL DEFAULT NULL,
  `updateTime` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Table structure for scholarship
-- ----------------------------
DROP TABLE IF EXISTS `scholarship`;
CREATE TABLE `scholarship` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `money` int(20) DEFAULT NULL,
  `count` int(10) DEFAULT NULL,
  `classCount` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `description` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `flag` int(10) DEFAULT NULL COMMENT '1-有效 0无效',
  `createTime` timestamp NULL DEFAULT NULL,
  `updateTime` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Table structure for scholarshipApply
-- ----------------------------
DROP TABLE IF EXISTS `scholarshipApply`;
CREATE TABLE `scholarshipApply` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `studentId` varchar(30) COLLATE utf8_bin DEFAULT NULL,
  `grade` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  `major` varchar(30) COLLATE utf8_bin DEFAULT NULL,
  `gradeClass` varchar(10) COLLATE utf8_bin DEFAULT NULL COMMENT '班级',
  `userName` varchar(30) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `type` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  `flag` int(10) DEFAULT NULL,
  `jiaQuan` double(20,0) DEFAULT NULL COMMENT '加权',
  `zongHe` double(20,0) DEFAULT NULL COMMENT '综合',
  `caoXing` varchar(10) COLLATE utf8_bin DEFAULT NULL COMMENT '操行',
  `jiaQuanClassRank` varchar(30) COLLATE utf8_bin DEFAULT NULL COMMENT '加权班级排名',
  `jiaquanMajorRank` varchar(30) COLLATE utf8_bin DEFAULT NULL COMMENT '加权年级排名',
  `zongHeClassRank` varchar(30) COLLATE utf8_bin DEFAULT NULL COMMENT '综合班级排名',
  `description` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '描述',
  `createTime` timestamp NULL DEFAULT NULL,
  `updateTime` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Table structure for scholarshiped
-- ----------------------------
DROP TABLE IF EXISTS `scholarshiped`;
CREATE TABLE `scholarshiped` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `applyId` int(20) DEFAULT NULL,
  `studentId` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  `userName` varchar(40) COLLATE utf8_bin DEFAULT NULL,
  `year` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `grade` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `major` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `gradeClass` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `type` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `jiaQuan` double(20,0) DEFAULT NULL,
  `zongHe` double(20,0) DEFAULT NULL,
  `caoXing` varchar(10) COLLATE utf8_bin DEFAULT NULL,
  `flag` int(10) DEFAULT NULL,
  `createTime` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(50) NOT NULL AUTO_INCREMENT,
  `studentId` varchar(30) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '学号',
  `userName` varchar(30) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `sex` int(10) NOT NULL COMMENT '1-男 2-女',
  `role` int(10) NOT NULL COMMENT '1-管理员2-学生3-老师',
  `mobile` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `grade` varchar(10) COLLATE utf8_bin DEFAULT NULL COMMENT '年级',
  `major` varchar(30) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '专业',
  `gradeClass` varchar(10) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '班级',
  `password` varchar(50) COLLATE utf8_bin NOT NULL,
  `question` varchar(60) COLLATE utf8_bin DEFAULT NULL,
  `answer` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `createTime` timestamp NULL DEFAULT NULL,
  `updateTime` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

SET FOREIGN_KEY_CHECKS = 1;
