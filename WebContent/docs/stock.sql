/*
SQLyog Ultimate v9.20 
MySQL - 5.5.27 : Database - stock
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`stock` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `stock`;

/*Table structure for table `stock` */

DROP TABLE IF EXISTS `stock`;

CREATE TABLE `stock` (
  `recordId` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '记录ID',
  `stockNumber` smallint(5) unsigned NOT NULL DEFAULT '0' COMMENT '股票代号',
  `amount` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '股票持有数量',
  `totalBuy` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '购买总价',
  `totalSell` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '卖出总价',
  `totalPoundage` decimal(10,4) unsigned NOT NULL DEFAULT '0.0000' COMMENT '总手续费',
  `totalEarnings` decimal(10,4) unsigned NOT NULL DEFAULT '0.0000' COMMENT '总收益',
  `buyCount` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '操作购买次数',
  `sellCount` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '操作卖出次数',
  PRIMARY KEY (`recordId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `stock` */

/*Table structure for table `stock_buy` */

DROP TABLE IF EXISTS `stock_buy`;

CREATE TABLE `stock_buy` (
  `recordId` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '记录ID',
  `stockNumber` smallint(5) unsigned NOT NULL DEFAULT '0' COMMENT '股票代号',
  `amount` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '股票数量',
  `buyPrice` decimal(10,4) unsigned NOT NULL DEFAULT '0.0000' COMMENT '购买价格',
  `totalPrice` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '购买总价',
  `poundage` decimal(10,4) unsigned NOT NULL DEFAULT '0.0000' COMMENT '手续费',
  `operTime` bigint(20) unsigned NOT NULL DEFAULT '0' COMMENT '购买时间',
  `target` decimal(10,4) unsigned NOT NULL DEFAULT '0.0000' COMMENT '目标价位',
  `stop` decimal(10,4) unsigned NOT NULL DEFAULT '0.0000' COMMENT '止损价位',
  PRIMARY KEY (`recordId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `stock_buy` */

/*Table structure for table `stock_data` */

DROP TABLE IF EXISTS `stock_data`;

CREATE TABLE `stock_data` (
  `recordId` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `code` int(10) unsigned NOT NULL DEFAULT '0',
  `name` varchar(20) NOT NULL DEFAULT '',
  `datetime` bigint(20) unsigned NOT NULL DEFAULT '0',
  `open` decimal(10,4) unsigned NOT NULL DEFAULT '0.0000',
  `close` decimal(10,4) unsigned NOT NULL DEFAULT '0.0000',
  `high` decimal(10,4) unsigned NOT NULL DEFAULT '0.0000',
  `low` decimal(10,4) unsigned NOT NULL DEFAULT '0.0000',
  `volume` int(10) unsigned NOT NULL DEFAULT '0',
  `adj` decimal(10,4) unsigned NOT NULL DEFAULT '0.0000',
  PRIMARY KEY (`recordId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `stock_data` */

/*Table structure for table `stock_sell` */

DROP TABLE IF EXISTS `stock_sell`;

CREATE TABLE `stock_sell` (
  `recordId` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '记录ID',
  `stockNumber` smallint(5) unsigned NOT NULL DEFAULT '0' COMMENT '股票代号',
  `amount` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '股票数量',
  `sellPrice` decimal(10,4) unsigned NOT NULL DEFAULT '0.0000' COMMENT '售出价格',
  `totalPrice` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '售出总价',
  `poundage` decimal(10,4) unsigned NOT NULL DEFAULT '0.0000' COMMENT '手续费',
  `operTime` bigint(20) unsigned NOT NULL DEFAULT '0' COMMENT '售出时间',
  PRIMARY KEY (`recordId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `stock_sell` */

/*Table structure for table `sys_css` */

DROP TABLE IF EXISTS `sys_css`;

CREATE TABLE `sys_css` (
  `cssId` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `css` varchar(20) NOT NULL DEFAULT '' COMMENT '样式',
  `text` varchar(20) NOT NULL DEFAULT '' COMMENT '描述',
  `type` smallint(3) unsigned NOT NULL DEFAULT '0' COMMENT '类型',
  PRIMARY KEY (`cssId`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

/*Data for the table `sys_css` */

insert  into `sys_css`(`cssId`,`css`,`text`,`type`) values (2,'icon-user','用户管理',1),(3,'icon-game','游戏工具',1),(4,'icon-setting','系统设置',1),(5,'icon-data','数据统计',1),(6,'icon-key','钥匙形状',2),(7,'icon-lock','锁形状',2),(8,'icon-lock-open','解锁形状',2);

/*Table structure for table `sys_menu` */

DROP TABLE IF EXISTS `sys_menu`;

CREATE TABLE `sys_menu` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `menuId` varchar(60) NOT NULL DEFAULT '' COMMENT '菜单ID',
  `text` varchar(60) NOT NULL DEFAULT '' COMMENT '菜单名称',
  `parentId` varchar(60) NOT NULL DEFAULT '' COMMENT '父菜单ID',
  `iconCls` varchar(20) NOT NULL DEFAULT '' COMMENT '菜单图标样式',
  `qtip` varchar(60) NOT NULL DEFAULT '' COMMENT '菜单TIPS',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=45 DEFAULT CHARSET=utf8;

/*Data for the table `sys_menu` */

insert  into `sys_menu`(`id`,`menuId`,`text`,`parentId`,`iconCls`,`qtip`) values (1,'usermanage','用户管理','top','icon-user','用户管理'),(3,'gametool','游戏工具','top','icon-game','游戏工具'),(4,'dataanalytic','数据统计','top','icon-data','数据统计'),(5,'setting','系统设置','top','icon-setting','系统设置'),(8,'menumanage','菜单管理','setting','icon-menu','菜单管理'),(31,'userlist','用户管理','usermanage','','用户管理'),(33,'cssmanage','样式管理','setting','icon-lock','样式管理'),(35,'rewardmanage','活动奖励','gametool','icon-lock','活动奖励'),(36,'activitymanage','活动管理','gametool','icon-lock','活动管理'),(37,'operateanalytic','运营数据','dataanalytic','icon-data','运营数据'),(38,'distribution','数据分布','dataanalytic','icon-data','数据分布'),(39,'distributionlevel','等级分布','distribution','icon-data','等级分布'),(40,'distributionviplevel','VIP等级分布','distribution','icon-data','VIP等级分布'),(41,'manage','系统管理','top','icon-setting','系统管理'),(42,'servermanage','服务器管理','manage','icon-lock','服务器管理'),(43,'monthanalytic','充值统计','manage','icon-lock-open','充值统计'),(44,'map','百度地图','gametool','icon-lock-open','百度地图');

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `userId` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '用户ID',
  `password` varchar(100) NOT NULL DEFAULT '' COMMENT '密码',
  `identity` smallint(3) unsigned NOT NULL DEFAULT '0' COMMENT '用户权限（0普通，1高级，9超级）',
  `account` varchar(100) NOT NULL DEFAULT '' COMMENT '账号',
  `serverId` int(11) NOT NULL DEFAULT '0' COMMENT '服务器ID',
  PRIMARY KEY (`userId`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='用户';

/*Data for the table `user` */

insert  into `user`(`userId`,`password`,`identity`,`account`,`serverId`) values (1,'admin',1,'admin',12),(2,'tang',1,'tang',2);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
