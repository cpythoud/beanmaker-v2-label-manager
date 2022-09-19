/*
 Navicat MySQL Data Transfer

 Source Server         : LapDell
 Source Server Type    : MariaDB
 Source Server Version : 100607
 Source Host           : localhost:3306
 Source Schema         : label-manager-test

 Target Server Type    : MariaDB
 Target Server Version : 100607
 File Encoding         : 65001

 Date: 19/09/2022 13:24:34
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for label_data
-- ----------------------------
DROP TABLE IF EXISTS `label_data`;
CREATE TABLE `label_data`  (
  `id_label` int(10) UNSIGNED NOT NULL,
  `id_language` tinyint(3) UNSIGNED NOT NULL,
  `data` varchar(2000) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_520_ci NOT NULL,
  PRIMARY KEY (`id_label`) USING BTREE,
  INDEX `id_language`(`id_language`) USING BTREE,
  CONSTRAINT `label_data_ibfk_1` FOREIGN KEY (`id_label`) REFERENCES `labels` (`id`) ON DELETE CASCADE ON UPDATE RESTRICT,
  CONSTRAINT `label_data_ibfk_2` FOREIGN KEY (`id_language`) REFERENCES `languages` (`id`) ON DELETE CASCADE ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_520_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of label_data
-- ----------------------------

-- ----------------------------
-- Table structure for labels
-- ----------------------------
DROP TABLE IF EXISTS `labels`;
CREATE TABLE `labels`  (
  `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `name` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_520_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_520_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of labels
-- ----------------------------

-- ----------------------------
-- Table structure for languages
-- ----------------------------
DROP TABLE IF EXISTS `languages`;
CREATE TABLE `languages`  (
  `id` tinyint(3) UNSIGNED NOT NULL AUTO_INCREMENT,
  `name` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_520_ci NOT NULL,
  `iso` varchar(6) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_520_ci NOT NULL,
  `item_order` tinyint(3) UNSIGNED NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_520_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of languages
-- ----------------------------
INSERT INTO `languages` VALUES (1, 'English', 'en', 1);
INSERT INTO `languages` VALUES (2, 'Français', 'fr', 2);
INSERT INTO `languages` VALUES (3, 'Deutsch', 'de', 3);
INSERT INTO `languages` VALUES (4, 'Italiano', 'it', 4);
INSERT INTO `languages` VALUES (5, 'Español', 'es', 5);

SET FOREIGN_KEY_CHECKS = 1;
