/*
 Navicat Premium Data Transfer

 Source Server         : dly
 Source Server Type    : MySQL
 Source Server Version : 50711
 Source Host           : localhost:3306
 Source Schema         : usercampus

 Target Server Type    : MySQL
 Target Server Version : 50711
 File Encoding         : 65001

 Date: 21/12/2020 22:29:59
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for course
-- ----------------------------
DROP TABLE IF EXISTS `course`;
CREATE TABLE `course`  (
  `courseid` int(11) NOT NULL,
  `coursename` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `coursecredit` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `courseteachr` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `courseclass` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`courseid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for goods
-- ----------------------------
DROP TABLE IF EXISTS `goods`;
CREATE TABLE `goods`  (
  `goodsid` mediumint(8) NOT NULL AUTO_INCREMENT,
  `goodsname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '商品名',
  `goodsnum` int(11) NULL DEFAULT NULL COMMENT '商品数量',
  `goodsprice` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '商品价格',
  `goodsstatus` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '商品状态',
  `createtime` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建时间',
  `updatedtime` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '更新时间',
  `goodscode` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '商品码',
  `goodsimg` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '商品图片',
  PRIMARY KEY (`goodsid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 36 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of goods
-- ----------------------------
INSERT INTO `goods` VALUES (1, '泡芙', 100, '3.5', '100', '2020/12/12', '2020/12/20', '2', '');
INSERT INTO `goods` VALUES (2, '香辣鸡腿汉堡', 100, '10', '100', '2020/12/12', '2020/12/20', '1', NULL);
INSERT INTO `goods` VALUES (3, '炸鸡', 100, '30', '100', '2020/12/12', '2020/12/12', '1', NULL);
INSERT INTO `goods` VALUES (4, '卫龙辣条', 100, '2.5', '100', '2020/12/12', '2020/12/12', '2', NULL);
INSERT INTO `goods` VALUES (5, '小当家', 100, '1.0', '100', '2020/12/12', '2020/12/12', '2', NULL);
INSERT INTO `goods` VALUES (6, '脆司令', 100, '1.8', '100', '2020/12/12', '2020/12/12', '2', NULL);
INSERT INTO `goods` VALUES (7, '奥利奥', 100, '7.5', '100', '2020/12/12', '2020/12/12', '2', NULL);
INSERT INTO `goods` VALUES (8, '口水鱼', 100, '1', '100', '2020/12/12', '2020/12/12', '2', NULL);
INSERT INTO `goods` VALUES (9, '老酒花生', 100, '5.5', '100', '2020/12/12', '2020/12/12', '2', NULL);
INSERT INTO `goods` VALUES (10, '南京板鸭', 100, '2.8', '100', '2020/12/12', '2020/12/12', '2', NULL);
INSERT INTO `goods` VALUES (11, '鱼豆腐', 100, '2', '100', '2020/12/12', '2020/12/12', '2', NULL);
INSERT INTO `goods` VALUES (12, '老坛酸菜牛肉面', 100, '5', '100', '2020/12/12', '2020/12/12', '2', NULL);
INSERT INTO `goods` VALUES (13, '金八吧卤蛋', 100, '1.8', '100', '2020/12/12', '2020/12/12', '2', NULL);
INSERT INTO `goods` VALUES (14, '香辣香脆肠', 100, '1.5', '100', '2020/12/12', '2020/12/12', '2', NULL);
INSERT INTO `goods` VALUES (15, '老坛酸菜肉丝炒饭', 100, '20', '100', '2020/12/12', '2020/12/12', '1', NULL);
INSERT INTO `goods` VALUES (16, '酸菜鱼', 100, '30', '100', '2020/12/12', '2020/12/12', '1', NULL);
INSERT INTO `goods` VALUES (17, '麻辣香锅', 100, '28', '100', '2020/12/12', '2020/12/12', '1', NULL);
INSERT INTO `goods` VALUES (18, '麻辣烫', 100, '25', '100', '2020/12/12', '2020/12/12', '1', NULL);
INSERT INTO `goods` VALUES (19, '黑椒牛柳炒面', 100, '25', '100', '2020/12/12', '2020/12/12', '1', NULL);
INSERT INTO `goods` VALUES (20, '皮蛋瘦肉粥', 100, '18', '100', '2020/12/12', '2020/12/12', '1', NULL);
INSERT INTO `goods` VALUES (21, '孜然味大鸡排', 100, '15', '100', '2020/12/12', '2020/12/12', '1', NULL);
INSERT INTO `goods` VALUES (22, '杂酱面', 100, '12', '100', '2020/12/12', '2020/12/12', '1', NULL);
INSERT INTO `goods` VALUES (23, '黄焖鸡', 100, '19', '100', '2020/12/12', '2020/12/12', '1', NULL);
INSERT INTO `goods` VALUES (24, ' 可口可乐', 100, '3.1', '100', '2020/12/12', '2020/12/12', '3', NULL);
INSERT INTO `goods` VALUES (25, '百事可乐', 100, '3.2', '100', '2020/12/12', '2020/12/12', '3', NULL);
INSERT INTO `goods` VALUES (26, '水果绿茶', 100, '5', '100', '2020/12/12', '2020/12/12', '3', NULL);
INSERT INTO `goods` VALUES (27, 'AD钙奶', 100, '2.5', '100', '2020/12/12', '2020/12/12', '3', NULL);
INSERT INTO `goods` VALUES (28, '旺仔牛奶', 100, '5.5', '100', '2020/12/12', '2020/12/12', '3', NULL);
INSERT INTO `goods` VALUES (29, '阿萨姆奶茶', 100, '5', '100', '2020/12/12', '2020/12/12', '3', NULL);
INSERT INTO `goods` VALUES (30, '果粒橙', 100, '4.5', '100', '2020/12/12', '2020/12/12', '3', NULL);
INSERT INTO `goods` VALUES (31, '冰红茶', 100, '3.5', '100', '2020/12/12', '2020/12/12', '3', NULL);
INSERT INTO `goods` VALUES (32, '冰红茶', 100, '3.5', '100', '2020/12/12', '2020/12/12', '3', NULL);
INSERT INTO `goods` VALUES (33, '李子园', 100, '5', '100', '2020/12/12', '2020/12/12', '3', NULL);
INSERT INTO `goods` VALUES (34, '红牛', 100, '6', '100', '2020/12/12', '2020/12/12', '3', NULL);
INSERT INTO `goods` VALUES (35, '雪碧', 100, '3', '100', '2020/12/12', '2020/12/12', '3', NULL);

-- ----------------------------
-- Table structure for grade
-- ----------------------------
DROP TABLE IF EXISTS `grade`;
CREATE TABLE `grade`  (
  `sno` int(11) NOT NULL,
  `courseid` int(11) NOT NULL,
  `score` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `credit` int(255) NULL DEFAULT NULL,
  PRIMARY KEY (`sno`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for healthcode
-- ----------------------------
DROP TABLE IF EXISTS `healthcode`;
CREATE TABLE `healthcode`  (
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `healthstatus` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `healthcode` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `userid` int(11) NOT NULL,
  PRIMARY KEY (`userid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for message
-- ----------------------------
DROP TABLE IF EXISTS `message`;
CREATE TABLE `message`  (
  `sender` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `sendcontent` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `sendtime` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for tiezi
-- ----------------------------
DROP TABLE IF EXISTS `tiezi`;
CREATE TABLE `tiezi`  (
  `tid` int(11) NOT NULL,
  `ttime` varchar(0) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `tauthor` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `tcreatedtime` varchar(0) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `tupatedtime` varchar(0) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `tcontent` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `tcomment` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `tlike` int(10) NULL DEFAULT NULL,
  PRIMARY KEY (`tid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `sex` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `age` int(11) NULL DEFAULT NULL,
  `phonenumber` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `userimg` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `email` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `college` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `major` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 47 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'Clay_Guo', 'gyz', '男', 22, '15061131871', 'aaa.jpg', 'guoyinzhi@foxmail.com', '计算机信息工程学院', '软件工程');
INSERT INTO `user` VALUES (2, 'Guo', 'gyz', '男', 22, '15061131871', 'aaa.jpg', 'guoyinzhi@foxmail.com', '计算机信息工程学院', '软件工程');
INSERT INTO `user` VALUES (3, 'gyz', 'gyz', '男', NULL, NULL, NULL, 'guoyinzhi@foxmail.com', '计算机信息工程学院', NULL);
INSERT INTO `user` VALUES (4, 'test', 'test ', NULL, NULL, NULL, NULL, 'test@163.com', '计算机信息工程学院', NULL);
INSERT INTO `user` VALUES (5, 'test', 'aaa', NULL, NULL, NULL, NULL, NULL, '计算机信息工程学院', NULL);
INSERT INTO `user` VALUES (6, 'aaa', 'aaa', 'aaa', 21, '13218662240', 'aaa', 'aaa', '计算机信息工程学院', '软件工程');
INSERT INTO `user` VALUES (7, 'bbb', 'bbb', NULL, 0, NULL, NULL, NULL, '计算机信息工程学院', NULL);
INSERT INTO `user` VALUES (8, 'ccc', 'ccc', NULL, 0, NULL, NULL, NULL, '计算机信息工程学院', NULL);
INSERT INTO `user` VALUES (9, '555', '555', NULL, 0, NULL, NULL, NULL, '计算机信息工程学院', NULL);
INSERT INTO `user` VALUES (10, '555', '555', NULL, 0, NULL, NULL, NULL, '计算机信息工程学院', NULL);
INSERT INTO `user` VALUES (11, '丁路遥', '555', NULL, 0, NULL, NULL, NULL, '计算机信息工程学院', NULL);
INSERT INTO `user` VALUES (12, '111', '111', NULL, 0, NULL, NULL, NULL, '计算机信息工程学院', NULL);
INSERT INTO `user` VALUES (13, 'mawei', 'mw', NULL, 0, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `user` VALUES (14, 'mawei', 'mw1', NULL, 0, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `user` VALUES (15, 'mawei', 'mw1', NULL, 0, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `user` VALUES (16, 'mawei', 'mw1', NULL, 0, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `user` VALUES (17, 'admin', 'admin', '男', 22, '15061131871', NULL, 'admin@foxmail.com', '计算机信息工程学院', ' ');
INSERT INTO `user` VALUES (18, 'mawei1', 'mw', NULL, 0, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `user` VALUES (19, '小罗', '1', NULL, 0, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `user` VALUES (20, '小丁', '11', NULL, 0, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `user` VALUES (39, 'dly', 'dly', NULL, 0, NULL, NULL, '766414909@qq.com', NULL, NULL);
INSERT INTO `user` VALUES (40, 'dly1', 'dly', NULL, 0, NULL, NULL, '766414909@qq.com', NULL, NULL);
INSERT INTO `user` VALUES (41, '鼎炉要1', 'q', NULL, 0, NULL, NULL, '766414909@qq.com', NULL, NULL);
INSERT INTO `user` VALUES (42, 'dly', '11', NULL, 0, NULL, NULL, '', NULL, NULL);
INSERT INTO `user` VALUES (43, 'dly111', 'dcsdfsdv', NULL, 0, NULL, NULL, ' ', NULL, NULL);
INSERT INTO `user` VALUES (44, 'dly1112525', 'dcsdfsdv', NULL, 0, NULL, NULL, '', NULL, NULL);
INSERT INTO `user` VALUES (45, 'dingsdlngsd', 'sfnjkso', NULL, 0, NULL, NULL, '', NULL, NULL);
INSERT INTO `user` VALUES (46, 'dingsgnosgnsdvdsvz', 'vgsvgsd', NULL, 0, NULL, NULL, 'sdbb', NULL, NULL);

SET FOREIGN_KEY_CHECKS = 1;
