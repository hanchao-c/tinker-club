/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50722
 Source Host           : localhost:3306
 Source Schema         : tinker-cms

 Target Server Type    : MySQL
 Target Server Version : 50722
 File Encoding         : 65001

 Date: 07/05/2019 15:59:11
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for cms_watch
-- ----------------------------
DROP TABLE IF EXISTS `cms_watch`;
CREATE TABLE `cms_watch`  (
  `id` char(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '主键 uuid ',
  `subject` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '主题',
  `price` decimal(10, 2) NULL DEFAULT NULL COMMENT '价格',
  `brand` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '品牌',
  `type` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '类型 ',
  `description` varchar(300) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '描述',
  `main_picture_url` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '图片链接',
  `sub_picture_urls` varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '子图片链接',
  `tags` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '标签',
  `state` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '状态',
  `last_modifed_time` datetime(0) NULL DEFAULT NULL COMMENT '记录最后更新时间',
  `opertor` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '操作人账号',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '栗子1 : 手表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of cms_watch
-- ----------------------------
INSERT INTO `cms_watch` VALUES ('4ec4395ebe294d83ac2a53db5597862a', '＜＞', 3.00, 'Audemars Piguet', '2', '2', 'http://139.199.107.128:8081/pictures/20190402/600ef714-b1ed-4437-95d7-3ffc962706e2.jpg', 'http://139.199.107.128:8081/pictures/20190402/791be222-b2f4-46ba-ae8c-960b27a6773f.jpg', '', '1', '2019-04-02 15:01:01', 'admin');
INSERT INTO `cms_watch` VALUES ('528978843c4840ec8b0b7491b69d07a1', '2', 2.00, 'Patek Philippe', '2', '3', 'http://139.199.107.128:8081/pictures/20190328/7c87cd59-2a26-4a92-9b9e-eb8ac2e57545.jpg', 'http://139.199.107.128:8081/pictures/20190328/87912c42-88ac-4d01-836d-2e96702c1057.jpg', NULL, '1', '2019-03-28 12:00:24', NULL);
INSERT INTO `cms_watch` VALUES ('be54925b149c4ec1906152077e77913d', '1', 1.00, 'Patek Philippe', '1', '2', 'http://139.199.107.128:8081/pictures/20190410/03976588-3bdf-4801-b710-6403d10bb78a.jpg', 'http://139.199.107.128:8081/pictures/20190410/8a2c5108-63f3-4485-a7eb-df051b2ae603.jpg', '', '1', '2019-04-10 12:02:27', 'admin');

SET FOREIGN_KEY_CHECKS = 1;
