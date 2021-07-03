/*
 Navicat Premium Data Transfer

 Source Server         : dev
 Source Server Type    : MySQL
 Source Server Version : 80025
 Source Host           : localhost:3306
 Source Schema         : keg

 Target Server Type    : MySQL
 Target Server Version : 80025
 File Encoding         : 65001

 Date: 03/07/2021 10:50:49
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for device
-- ----------------------------
DROP TABLE IF EXISTS `device`;
CREATE TABLE `device`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '维修记录id',
  `d_id` bigint NULL DEFAULT NULL COMMENT '设备编号',
  `p_name` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '设备名称',
  `d_class` bigint NOT NULL COMMENT '设备类别',
  `d_btime` datetime NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '购买日期',
  `d_number` int NULL DEFAULT NULL COMMENT '数量',
  `p_price` decimal(10, 2) NULL DEFAULT NULL COMMENT '单价',
  `user_id` bigint NOT NULL COMMENT '购买人负责人',
  `p_manufacturer` bigint NULL DEFAULT NULL COMMENT '生产厂家',
  `d_status` int NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `deviceClass`(`d_class`) USING BTREE,
  INDEX `deviceManufacturer`(`p_manufacturer`) USING BTREE,
  CONSTRAINT `device_ibfk_1` FOREIGN KEY (`d_class`) REFERENCES `device_class` (`c_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `device_ibfk_2` FOREIGN KEY (`p_manufacturer`) REFERENCES `device_manufacturer` (`m_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 29 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of device
-- ----------------------------
INSERT INTO `device` VALUES (1, 20210524001, '联想显卡T300', 1, '2021-07-02 16:57:54', 2, 688.00, 2, 1, 1);
INSERT INTO `device` VALUES (2, 20210523001, '联想笔记本T3000', 2, '2021-07-02 16:57:57', 1, 6588.00, 3, 2, 1);
INSERT INTO `device` VALUES (3, 20210525001, '联想C200', 1, '2021-07-02 16:57:59', 2, 7599.00, 4, 1, 1);
INSERT INTO `device` VALUES (4, 20210521023, '戴尔2300', 1, '2021-07-02 16:58:01', 4, 5499.00, 2, 3, 1);
INSERT INTO `device` VALUES (5, 20210423015, '服务器INTEL至强四核', 2, '2021-07-02 16:58:04', 2, 6988.00, 3, 3, 1);
INSERT INTO `device` VALUES (6, 20210521004, '启天M6345', 1, '2021-07-02 16:58:13', 3, 4389.00, 32, 2, 0);
INSERT INTO `device` VALUES (30, 20210304001, '显卡', 1, '2021-07-03 08:54:41', 1, 111.00, 4, 2, 1);
INSERT INTO `device` VALUES (31, 20210304001, '联想小新电脑', 2, '2021-07-03 09:30:58', 1, 2222.00, 41, 1, 1);

-- ----------------------------
-- Table structure for device_class
-- ----------------------------
DROP TABLE IF EXISTS `device_class`;
CREATE TABLE `device_class`  (
  `c_id` bigint NOT NULL AUTO_INCREMENT,
  `c_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`c_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of device_class
-- ----------------------------
INSERT INTO `device_class` VALUES (1, '显卡');
INSERT INTO `device_class` VALUES (2, '服务器');
INSERT INTO `device_class` VALUES (3, '全部');

-- ----------------------------
-- Table structure for device_maintain
-- ----------------------------
DROP TABLE IF EXISTS `device_maintain`;
CREATE TABLE `device_maintain`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '设备id',
  `d_id` bigint NULL DEFAULT NULL COMMENT '维修编号',
  `m_btime` datetime NULL DEFAULT NULL COMMENT '故障日期',
  `m_time` datetime NULL DEFAULT NULL COMMENT '维修日期',
  `m_manufacturer` bigint NULL DEFAULT NULL COMMENT '维修商家',
  `m_price` decimal(10, 2) NULL DEFAULT NULL COMMENT '维修费用',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of device_maintain
-- ----------------------------
INSERT INTO `device_maintain` VALUES (20210524001, 20210521, '2021-05-19 21:20:45', '2021-05-21 21:20:52', 1, 300.00);

-- ----------------------------
-- Table structure for device_manufacturer
-- ----------------------------
DROP TABLE IF EXISTS `device_manufacturer`;
CREATE TABLE `device_manufacturer`  (
  `m_id` bigint NOT NULL AUTO_INCREMENT,
  `m_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`m_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of device_manufacturer
-- ----------------------------
INSERT INTO `device_manufacturer` VALUES (1, '联想秦皇岛');
INSERT INTO `device_manufacturer` VALUES (2, '北京京东');
INSERT INTO `device_manufacturer` VALUES (3, '戴尔秦皇岛');
INSERT INTO `device_manufacturer` VALUES (4, '全部');

-- ----------------------------
-- Table structure for device_purchases
-- ----------------------------
DROP TABLE IF EXISTS `device_purchases`;
CREATE TABLE `device_purchases`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '设备购买id',
  `p_name` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '设备名称',
  `p_time` datetime NULL DEFAULT NULL COMMENT '申请购买日期',
  `p_number` int NULL DEFAULT NULL COMMENT '数量',
  `p_price` decimal(10, 2) NULL DEFAULT NULL COMMENT '单价',
  `user_id` bigint NOT NULL COMMENT '购买申请人',
  `p_manufacturer` bigint NULL DEFAULT NULL COMMENT '生产厂家',
  PRIMARY KEY (`id`, `user_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of device_purchases
-- ----------------------------
INSERT INTO `device_purchases` VALUES (1, '联想Tinkpaid', '2021-05-24 21:27:36', 1, 5679.00, 202021040159, 1);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `u_id` bigint NULL DEFAULT NULL,
  `u_name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `u_sex` tinyint(1) NULL DEFAULT NULL,
  `u_username` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `u_password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `u_phone` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `u_email` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `u_grade` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `u_trait` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `u_status` int NULL DEFAULT 0,
  `group_id` bigint NULL DEFAULT NULL,
  `research_id` bigint NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `group`(`group_id`) USING BTREE,
  INDEX `research`(`research_id`) USING BTREE,
  CONSTRAINT `user_ibfk_1` FOREIGN KEY (`group_id`) REFERENCES `user_group` (`g_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `user_ibfk_2` FOREIGN KEY (`research_id`) REFERENCES `user_research` (`r_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 41 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (2, 202021040143, '李学文', 1, 'lixuewen', '1234', '15226039562', 'li@qq.com', '研一', '擅长推荐', 1, 1, 1);
INSERT INTO `user` VALUES (3, 202021040148, '房小涵', 1, 'fangxiaohan', '1234', '15226039562', 'li@qq.com', '研一', '擅长NLP', 1, 2, 3);
INSERT INTO `user` VALUES (4, 202021040159, '寇肖萌', 0, 'kouxiaomeng', '1234', '15226039562', 'li@qq.com', '研一', '擅长推荐', 1, 1, 2);
INSERT INTO `user` VALUES (32, 202021040186, '刘志红', 1, 'liuzhihong', '1321324', '13176533421', 'gong@qq.com', '研一', '解析', 0, 1, 2);
INSERT INTO `user` VALUES (41, 12242412214214, '彭吉全', 1, 'pengjiquan', 'sdsa', '13133412342', '2131242@QQ.COM', '研一', '爬虫', 1, 1, 1);

-- ----------------------------
-- Table structure for user_group
-- ----------------------------
DROP TABLE IF EXISTS `user_group`;
CREATE TABLE `user_group`  (
  `g_id` bigint NOT NULL AUTO_INCREMENT,
  `g_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`g_id`) USING BTREE,
  INDEX `group_name`(`g_name`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of user_group
-- ----------------------------
INSERT INTO `user_group` VALUES (1, '万瑶论文组');
INSERT INTO `user_group` VALUES (3, '全部');
INSERT INTO `user_group` VALUES (2, '王珅论文组');

-- ----------------------------
-- Table structure for user_research
-- ----------------------------
DROP TABLE IF EXISTS `user_research`;
CREATE TABLE `user_research`  (
  `r_id` bigint NOT NULL AUTO_INCREMENT,
  `r_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`r_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of user_research
-- ----------------------------
INSERT INTO `user_research` VALUES (1, 'NLP');
INSERT INTO `user_research` VALUES (2, '推荐系统');
INSERT INTO `user_research` VALUES (3, '分布式');
INSERT INTO `user_research` VALUES (4, '全部');

SET FOREIGN_KEY_CHECKS = 1;
