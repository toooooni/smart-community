-- CREATE DATABASE librarydb;
use
repairdb;
SET
FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for 人员
-- ----------------------------
DROP TABLE IF EXISTS `person`;
DROP TABLE IF EXISTS `person`;
CREATE TABLE `person`
(
-- Id、用户名、密码、电话、邮箱、用户身份
    `person_id`  integer     NOT NULL auto_increment,
    `name`       varchar(30) NOT NULL,
    `password`   varchar(30) NOT NULL,
    `tel`        varchar(30) NOT NULL,
    `email`      varchar(30) NOT NULL,
    `user_types` integer     NOT NULL,
    PRIMARY KEY (`person_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for 报修单
-- ----------------------------
DROP TABLE IF EXISTS `repair_form`;
CREATE TABLE `repair_form`
(
-- 报修单号、报修人Id、是否公用、物品属性、维修备注、地址、电话、付费情况、维修状态、日期、评价星级、评价内容
    `form_id`        integer      NOT NULL auto_increment,
    `person_id`      integer      NOT NULL,
    `whether_public`  bool         NOT NULL,
    `item_type`       varchar(30)  NOT NULL,
    `message`        varchar(100),
    `address`        varchar(100) NOT NULL,
    `tel`            varchar(20)  NOT NULL,
    `whether_pay`     bool         NOT NULL,
    `state_repair`    integer      NOT NULL,
    `repair_date`     date         NOT NULL,
    `evaluation_star` integer,
    `evaluation_note` varchar(100),
    PRIMARY KEY (`form_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

SET
FOREIGN_KEY_CHECKS = 1;

