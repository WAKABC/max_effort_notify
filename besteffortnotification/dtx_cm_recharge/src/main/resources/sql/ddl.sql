CREATE DATABASE `cm_recharge` /*!40100 DEFAULT CHARACTER SET utf8mb4 */;

use cm_recharge;
-- cm_recharge.account_recharge definition

CREATE TABLE `account_recharge`
(
    `id`              varchar(50) NOT NULL COMMENT '京东充值流水号',
    `account_no`      varchar(50)   DEFAULT '' COMMENT '帐户号码',
    `recharge_amount` double(16, 4) DEFAULT '0.0000' COMMENT '充值金额',
    `state`           varchar(10)   DEFAULT '' COMMENT '充值状态',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4 COMMENT ='account_recharge';