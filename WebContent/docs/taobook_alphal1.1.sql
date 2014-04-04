/*
SQLyog Ultimate v9.62 
MySQL - 5.5.20 : Database - taobook
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`taobook` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `taobook`;

/*Table structure for table `hs_book` */

DROP TABLE IF EXISTS `hs_book`;

CREATE TABLE `hs_book` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `isbn` varchar(50) NOT NULL DEFAULT '' COMMENT 'isbn',
  `title` varchar(120) NOT NULL DEFAULT '' COMMENT '书名',
  `author` varchar(100) NOT NULL DEFAULT '' COMMENT '作者',
  `press` int(11) unsigned DEFAULT NULL COMMENT '出版社',
  `type` int(11) unsigned DEFAULT NULL COMMENT '类型',
  `his_release` int(11) unsigned DEFAULT NULL COMMENT '历史发布数量',
  `his_reserve` int(11) unsigned DEFAULT NULL COMMENT '历史预定数量',
  `his_bargain` int(11) unsigned DEFAULT NULL COMMENT '历史成交数量',
  `input_date` date DEFAULT NULL COMMENT '录入时间',
  `input_user` int(11) unsigned DEFAULT NULL COMMENT '原始编辑人',
  `correct_user` int(11) unsigned DEFAULT NULL COMMENT '最后纠错用户',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='图书信息';

/*Data for the table `hs_book` */

/*Table structure for table `hs_site` */

DROP TABLE IF EXISTS `hs_site`;

CREATE TABLE `hs_site` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `addressId` int(11) unsigned DEFAULT NULL COMMENT '地址标识Id',
  `level` int(2) unsigned DEFAULT NULL COMMENT '所属级别',
  `name` varchar(50) DEFAULT NULL COMMENT '名称',
  `parentId` int(11) unsigned DEFAULT NULL COMMENT '父地址',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=20069 DEFAULT CHARSET=utf8 COMMENT='地址';

/*Data for the table `hs_site` */

insert  into `hs_site`(`id`,`addressId`,`level`,`name`,`parentId`) values (10001,10001,1,'北京市',0),(10002,10002,1,'天津市',0),(10003,10003,1,'上海市',0),(10004,10004,1,'重庆市',0),(10005,10005,1,'河北省',0),(10006,10006,1,'河南省',0),(10007,10007,1,'云南省',0),(10008,10008,1,'辽宁省',0),(10009,10009,1,'黑龙江省',0),(10010,10010,1,'湖南省',0),(10011,10011,1,'湖北省',0),(10012,10012,1,'安徽省',0),(10013,10013,1,'山东省',0),(10014,10014,1,'新疆维吾尔',0),(10015,10015,1,'江苏省',0),(10016,10016,1,'浙江省',0),(10017,10017,1,'江西省',0),(10018,10018,1,'广西',0),(10019,10019,1,'甘肃省',0),(10020,10020,1,'山西省',0),(10021,10021,1,'内蒙古',0),(10022,10022,1,'陕西省',0),(10023,10023,1,'吉林省',0),(10024,10024,1,'福建省',0),(10025,10025,1,'贵州省',0),(10026,10026,1,'广东省',0),(10027,10027,1,' 青海省',0),(10028,10028,1,'西藏',0),(10029,10029,1,'四川省',0),(10030,10030,1,'宁夏省',0),(10031,10031,1,'海南省',0),(10032,10032,1,'台湾省',0),(20001,20001,2,'杭州市',10016),(20002,20002,2,'宁波市',10016),(20003,20003,2,'温州市',10016),(20004,20004,2,'嘉兴市',10016),(20005,20005,2,'湖州市',10016),(20006,20006,2,'绍兴市',10016),(20007,20007,2,'金华市',10016),(20008,20008,2,'衢州市',10016),(20009,20009,2,'舟山市',10016),(20010,20010,2,'台州市',10016),(20011,20011,2,'丽水市',10016),(20012,20012,2,'建德市',10016),(20013,20013,2,'余姚市',10016),(20014,20014,2,'瑞安市',10016),(20015,20015,2,'海宁市',10016),(20016,20016,2,'诸暨市',10016),(20017,20017,2,'兰溪市',10016),(20018,20018,2,'江山市',10016),(20019,20019,2,'温岭市',10016),(20020,20020,2,'龙泉市',10016),(20021,20021,2,'富阳市',10016),(20022,20022,2,'慈溪市',10016),(20023,20023,2,'乐清市',10016),(20024,20024,2,'平湖市',10016),(20025,20025,2,'上虞市',10016),(20026,20026,2,'义乌市',10016),(20027,20027,2,'临海市',10016),(20028,20028,2,'临安市',10016),(20029,20029,2,'奉化市',10016),(20030,20030,2,'桐乡市',10016),(20031,20031,2,'嵊州市',10016),(20032,20032,2,'东阳市',10016),(20033,20033,2,'永康市',10016),(20034,20034,2,'新昌县',10016),(20035,20035,2,'桐庐县',10016),(20036,20036,2,'淳安县',10016),(20037,20037,2,'宁海县',10016),(20038,20038,2,'象山县',10016),(20039,20039,2,'永嘉县',10016),(20040,20040,2,'洞头县',10016),(20041,20041,2,'平阳县',10016),(20042,20042,2,'苍南县',10016),(20043,20043,2,'文成县',10016),(20044,20044,2,'泰顺县',10016),(20045,20045,2,'嘉善县',10016),(20046,20046,2,'海盐县',10016),(20047,20047,2,'长兴县',10016),(20048,20048,2,'安吉县',10016),(20049,20049,2,'新昌县',10016),(20050,20050,2,'武义县',10016),(20051,20051,2,'浦江县',10016),(20052,20052,2,'磐安县',10016),(20053,20053,2,'龙游县',10016),(20054,20054,2,'常山县',10016),(20055,20055,2,'开化县',10016),(20056,20056,2,'岱山县',10016),(20057,20057,2,'嵊泗县',10016),(20058,20058,2,'玉环县',10016),(20059,20059,2,'仙居县',10016),(20060,20060,2,'三门县',10016),(20061,20061,2,'天台县',10016),(20062,20062,2,'缙云县',10016),(20063,20063,2,'青田县',10016),(20064,20064,2,'云和县',10016),(20065,20065,2,'遂昌县',10016),(20066,20066,2,'松阳县',10016),(20067,20067,2,'庆元县',10016),(20068,20068,2,'景宁畲族自治县',10016);

/*Table structure for table `hs_user` */

DROP TABLE IF EXISTS `hs_user`;

CREATE TABLE `hs_user` (
  `id` int(11) NOT NULL,
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  `qq` bigint(20) DEFAULT NULL,
  `telephone` bigint(20) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `contact` varchar(255) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `province` varchar(255) DEFAULT NULL,
  `city` varchar(255) DEFAULT NULL,
  `district` varchar(255) DEFAULT NULL,
  `school` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `hs_user` */

/*Table structure for table `sys_icon` */

DROP TABLE IF EXISTS `sys_icon`;

CREATE TABLE `sys_icon` (
  `iconId` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `iconCls` varchar(20) NOT NULL DEFAULT '' COMMENT '样式',
  `desc` varchar(20) NOT NULL DEFAULT '' COMMENT '描述',
  PRIMARY KEY (`iconId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `sys_icon` */

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
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8;

/*Data for the table `sys_menu` */

insert  into `sys_menu`(`id`,`menuId`,`text`,`parentId`,`iconCls`,`qtip`) values (1,'usermanage','用户管理','top','icon-user','用户管理'),(3,'gametool','游戏工具','top','icon-game','游戏工具'),(4,'dataanalytic','数据统计','top','icon-data','数据统计'),(5,'setting','系统设置','top','icon-setting','系统设置'),(6,'itemsend','道具发送','gametool','icon-item-send','道具发送'),(7,'activity','活动开启','gametool','icon-lock-open','活动开启'),(8,'menumanage','菜单管理','setting','icon-menu','菜单管理'),(9,'账号审批','account','usermanage','icon-user-approve','account'),(10,'test','测试菜单','top','','测试菜单'),(11,'test1','测试1','test','','测试1'),(13,'test3','测试3','test','','测试3'),(17,'test7','测试7','test','','测试7'),(18,'test8','测试8','test','','测试8'),(19,'test9','测试9','test','','测试9'),(20,'test10','测试10','test','','测试10'),(22,'iconmanage','样式管理','setting','icon-icon','样式管理'),(23,'identity','权限管理','usermanage','icon-identity','权限管理'),(24,'test12','测试12','test','','测试12'),(25,'test13','测试13','test','','测试13'),(26,'test14','测试14','test','','测试14'),(27,'test15','测试15','test','icon-test','测试15'),(28,'test17','测试17','test','','测试17'),(29,'test16','测试16','test','','测试16'),(30,'test18','测试18','test','','测试18'),(31,'userlist','用户管理','usermanage','','用户管理');

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `userId` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '用户ID',
  `username` varchar(100) NOT NULL DEFAULT '' COMMENT '用户名',
  `password` varchar(100) NOT NULL DEFAULT '' COMMENT '密码',
  `identity` smallint(3) unsigned NOT NULL DEFAULT '0' COMMENT '用户权限（0普通，1高级，9超级）',
  `account` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`userId`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='用户';

/*Data for the table `user` */

insert  into `user`(`userId`,`username`,`password`,`identity`,`account`) values (1,'唐伯猫','hhtt113620',0,NULL),(2,'q','q',0,NULL);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
