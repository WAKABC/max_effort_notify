CREATE DATABASE `jd_receive` /*!40100 DEFAULT CHARACTER SET utf8mb4 */;

use jd_receive;
-- jd_receive.account_charge definition

CREATE TABLE `account_charge`
(
    `id`              varchar(50) NOT NULL COMMENT '事务流水',
    `account_no`      varchar(50)   DEFAULT '' COMMENT '充值帐户',
    `recharge_amount` double(16, 4) DEFAULT '-1.0000' COMMENT '充值金额',
    `state`           varchar(50)   DEFAULT '' COMMENT '充值状态',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4 COMMENT ='account_charge';


-- jd_receive.account_info definition

CREATE TABLE `account_info`
(
    `id`              int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
    `account_name`    varchar(50)   DEFAULT '' COMMENT '帐户名称',
    `account_no`      varchar(50)   DEFAULT '' COMMENT '帐户号码',
    `account_balance` double(16, 4) DEFAULT '0.0000' COMMENT '帐户余额',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 2
  DEFAULT CHARSET = utf8mb4 COMMENT ='account_info';


-- jd_receive.de_duplicate definition

CREATE TABLE `de_duplicate`
(
    `txno`       varchar(100) NOT NULL,
    `createtime` datetime DEFAULT NULL,
    PRIMARY KEY (`txno`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;