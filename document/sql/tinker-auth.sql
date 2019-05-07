/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50722
 Source Host           : localhost:3306
 Source Schema         : tinker-auth

 Target Server Type    : MySQL
 Target Server Version : 50722
 File Encoding         : 65001

 Date: 07/05/2019 15:59:06
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for auth_permission
-- ----------------------------
DROP TABLE IF EXISTS `auth_permission`;
CREATE TABLE `auth_permission`  (
  `id` char(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '主键 (可选UUID)',
  `permission_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '菜单名称',
  `catalog` tinyint(1) NULL DEFAULT NULL COMMENT '是否是目录菜单',
  `permission` varchar(1200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '菜单链接',
  `authorities` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '后台权限',
  `sequence` int(11) NULL DEFAULT NULL COMMENT '序号',
  `parent_id` char(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '父菜单id',
  `icon` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '图标',
  `note` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of auth_permission
-- ----------------------------
INSERT INTO `auth_permission` VALUES ('09e14eb1df18340591f513a7b85263e2', '订单管理', 1, NULL, NULL, 3, 'root', 'fa fa-trophy text-default fa-lg', '');
INSERT INTO `auth_permission` VALUES ('31f9d1ecd8e91192b723b7ec840fca9d', '用户管理', 0, 'system/user-list', 'users', 0, '61460799c48a2b5f41537cb197ffa035', 'fa fa-th-list text-default fa-lg', NULL);
INSERT INTO `auth_permission` VALUES ('443643763955ddddfe67b3dab0070d7a', 'plugins', 1, NULL, NULL, 1, 'root', 'fa fa-tree text-default fa-lg', NULL);
INSERT INTO `auth_permission` VALUES ('457c33fb9ca5e52cc2326848704b8140', 'dropzone', 0, 'plugins/dropzone-demo', 'dropzone', 1, '443643763955ddddfe67b3dab0070d7a', 'fa fa-th-list text-default fa-lg', '');
INSERT INTO `auth_permission` VALUES ('5804730b45bc69cd50d86eb29cdedb34', '菜单管理', 0, 'system/permission-list', 'permissions', 2, '61460799c48a2b5f41537cb197ffa035', 'fa fa-th-list text-default fa-lg', '');
INSERT INTO `auth_permission` VALUES ('61460799c48a2b5f41537cb197ffa035', '系统设置', 1, '', '', 0, 'root', 'fa fa-user text-default fa-lg', '');
INSERT INTO `auth_permission` VALUES ('7b1a09bd0b60560d205f5eae0fea7961', 'daterangpicker', 0, 'plugins/daterangpicker-demo', '', 2, '443643763955ddddfe67b3dab0070d7a', 'fa fa-th-list text-default fa-lg', '');
INSERT INTO `auth_permission` VALUES ('7befde81016845fa0e1d26cf7a222a0b', '商品清单', 1, NULL, NULL, 2, 'root', 'fa fa-tasks text-default fa-lg', '');
INSERT INTO `auth_permission` VALUES ('81e017e0ea7322894a1cac05796fe4f3', '角色管理', 0, 'system/role-list', 'roles', 1, '61460799c48a2b5f41537cb197ffa035', 'fa fa-th-list text-default fa-lg', '');
INSERT INTO `auth_permission` VALUES ('966d0eb556a7bcc3a4f27725feb60412', '支付中心', 1, NULL, NULL, 4, 'root', 'fa fa-money text-default fa-lg', '');
INSERT INTO `auth_permission` VALUES ('9a352a8ce7412715257857703bf13d43', '未完成订单', 0, 'cms/uncompleted-order-list', 'uncompletedOrders', 1, '09e14eb1df18340591f513a7b85263e2', 'fa fa-th-list text-default fa-lg', '');
INSERT INTO `auth_permission` VALUES ('b5165a2f635576b55a0dedab95c04227', '支付记录', 0, 'cms/pay-record-list', 'payRecords', 1, '966d0eb556a7bcc3a4f27725feb60412', 'fa fa-th-list text-default fa-lg', '');
INSERT INTO `auth_permission` VALUES ('b9420c0f028200fdce86a9ed3ec9f971', 'select2', 0, 'plugins/select2-demo', 'select2', 0, '443643763955ddddfe67b3dab0070d7a', 'fa fa-th-list text-default fa-lg', '');
INSERT INTO `auth_permission` VALUES ('c06e73f42d8ba16b948f2726b34ee8db', '手表展示', 0, 'cms/watch-list,cms/watch-create,cms/watch-edit', 'watches', 1, '7befde81016845fa0e1d26cf7a222a0b', 'fa fa-th-list text-default fa-lg', '');

-- ----------------------------
-- Table structure for auth_role
-- ----------------------------
DROP TABLE IF EXISTS `auth_role`;
CREATE TABLE `auth_role`  (
  `id` char(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `role_name` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `description` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of auth_role
-- ----------------------------
INSERT INTO `auth_role` VALUES ('8ebeb30f4e2a4de8b11812d930624288', 'cms manager', NULL);

-- ----------------------------
-- Table structure for auth_role_permission_relation
-- ----------------------------
DROP TABLE IF EXISTS `auth_role_permission_relation`;
CREATE TABLE `auth_role_permission_relation`  (
  `id` char(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `role_id` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `permission_id` char(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of auth_role_permission_relation
-- ----------------------------
INSERT INTO `auth_role_permission_relation` VALUES ('66afabc38f3446a5a6f28fffa5edc7ae', '8ebeb30f4e2a4de8b11812d930624288', '7b1a09bd0b60560d205f5eae0fea7961');
INSERT INTO `auth_role_permission_relation` VALUES ('6ce24e3ef6934dcf9496b7fa04f0b377', '8ebeb30f4e2a4de8b11812d930624288', '457c33fb9ca5e52cc2326848704b8140');
INSERT INTO `auth_role_permission_relation` VALUES ('83ec0367dcc6456f8b20654504e10b43', '8ebeb30f4e2a4de8b11812d930624288', 'c06e73f42d8ba16b948f2726b34ee8db');
INSERT INTO `auth_role_permission_relation` VALUES ('9e6555ef82b64eea9f78acf02e2b6fd4', '8ebeb30f4e2a4de8b11812d930624288', '7befde81016845fa0e1d26cf7a222a0b');

-- ----------------------------
-- Table structure for auth_user
-- ----------------------------
DROP TABLE IF EXISTS `auth_user`;
CREATE TABLE `auth_user`  (
  `id` char(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `name` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `account` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `password` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `salt` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of auth_user
-- ----------------------------
INSERT INTO `auth_user` VALUES ('00380e2472cf46a5b6c733d379072f59', '系统管理员', 'admin', '572335de206457a8c34169137f73e70b', '93aef04b4634ae77bb40d45baf316e62');
INSERT INTO `auth_user` VALUES ('6e8af291ff684cae8a7805c70305cb5f', 'cmsmananger', '1010107089', '02fae57177aee858e995c893f2cb2291', '1e30fc871feebeba21a3248d8bb46e84');

-- ----------------------------
-- Table structure for auth_user_role_relation
-- ----------------------------
DROP TABLE IF EXISTS `auth_user_role_relation`;
CREATE TABLE `auth_user_role_relation`  (
  `id` char(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `account` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `role_id` char(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `role_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of auth_user_role_relation
-- ----------------------------
INSERT INTO `auth_user_role_relation` VALUES ('fdc963043fc740df9ea1769895971520', '1010107089', '8ebeb30f4e2a4de8b11812d930624288', NULL);

SET FOREIGN_KEY_CHECKS = 1;
