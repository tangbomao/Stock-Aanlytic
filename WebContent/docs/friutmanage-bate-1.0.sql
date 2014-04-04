/*
SQLyog Ultimate v9.62 
MySQL - 5.1.59-log : Database - loong_manage
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`loong_manage` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `loong_manage`;

/*Table structure for table `game_server` */

DROP TABLE IF EXISTS `game_server`;

CREATE TABLE `game_server` (
  `serverId` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '记录ID',
  `name` varchar(100) NOT NULL DEFAULT '' COMMENT '服务器名称',
  `ipAddress` varchar(100) NOT NULL DEFAULT '' COMMENT '服务器IP',
  `port` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '服务器端口',
  `apiKey` varchar(100) NOT NULL DEFAULT '' COMMENT 'ApiKey',
  PRIMARY KEY (`serverId`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

/*Data for the table `game_server` */

insert  into `game_server`(`serverId`,`name`,`ipAddress`,`port`,`apiKey`) values (1,'测试服【外网】','http://122.225.219.68',808,'Vcs7FFCxA3jgzRQL'),(2,'测试服【唐赢】','http://192.168.1.107',808,'Vcs7FFCxA3jgzRQL');

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
) ENGINE=InnoDB AUTO_INCREMENT=38 DEFAULT CHARSET=utf8;

/*Data for the table `sys_menu` */

insert  into `sys_menu`(`id`,`menuId`,`text`,`parentId`,`iconCls`,`qtip`) values (1,'usermanage','用户管理','top','icon-user','用户管理'),(3,'gametool','游戏工具','top','icon-game','游戏工具'),(4,'dataanalytic','数据统计','top','icon-data','数据统计'),(5,'setting','系统设置','top','icon-setting','系统设置'),(8,'menumanage','菜单管理','setting','icon-menu','菜单管理'),(23,'identity','权限管理','usermanage','icon-identity','权限管理'),(31,'userlist','用户管理','usermanage','','用户管理'),(33,'cssmanage','样式管理','setting','icon-lock','样式管理'),(34,'account','权限审批','usermanage','icon-lock-open','权限审批'),(35,'rewardmanage','活动奖励','gametool','icon-lock','活动奖励'),(36,'activitymanage','活动管理','gametool','icon-lock','活动管理'),(37,'servermanage','服务器管理','setting','icon-lock-open','服务器管理');

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

insert  into `user`(`userId`,`password`,`identity`,`account`,`serverId`) values (1,'admin',1,'admin',1),(2,'tang',1,'tang',1);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
