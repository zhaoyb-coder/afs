/*
SQLyog Ultimate v13.1.1 (64 bit)
MySQL - 5.7.32 : Database - afs
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`afs` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `afs`;

/*Table structure for table `afs_house` */

DROP TABLE IF EXISTS `afs_house`;

CREATE TABLE `afs_house` (
  `uid` varchar(40) NOT NULL COMMENT '主键',
  `house_name` varchar(50) DEFAULT NULL COMMENT '房屋编号',
  `house_num` int(2) DEFAULT NULL COMMENT '入住人数',
  `house_stat` varchar(4) DEFAULT NULL COMMENT '入住情况（0：空置  1：入住）',
  `create_time` date DEFAULT NULL COMMENT '创建时间',
  `update_time` date DEFAULT NULL COMMENT '修改时间',
  `data_state` varchar(2) DEFAULT NULL COMMENT '数据状态 1有效 0无效',
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='房屋信息表';

/*Data for the table `afs_house` */

insert  into `afs_house`(`uid`,`house_name`,`house_num`,`house_stat`,`create_time`,`update_time`,`data_state`) values 
('0edbcec63ccc468d9be7e9695dbab947','西22',0,'空置','2021-02-26',NULL,'1'),
('1','东122',3,'入住',NULL,'2021-02-26','1'),
('1bca80e1d79046f08651bc9ea130db54','22',0,'空置','2021-02-26',NULL,'0'),
('233354f9b217405dbfbb3e09d2c84029','44',0,'空置','2021-02-26',NULL,'0'),
('3','东2',2,'空置',NULL,NULL,'1'),
('69e7a2927209456689f535056b220547','12353',0,'空置','2021-02-26',NULL,'0'),
('92522553a69147acbdcf2a23271f788a','22222',0,'空置','2021-02-26',NULL,'0'),
('9a13b7778b6940888ec9f0e526e2d8e7','111',0,'空置','2021-02-26',NULL,'11'),
('9d1125ece56a4d97870ffc09d3f636e3','11',0,'空置','2021-02-26',NULL,'0'),
('b907bef952174fb084e9bc39a766ade4','33',0,'空置','2021-02-26',NULL,'0'),
('d08f29a8e9cc4d73952566d77470b2d2','112233',0,'空置','2021-02-26',NULL,'0');

/*Table structure for table `afs_month_rent` */

DROP TABLE IF EXISTS `afs_month_rent`;

CREATE TABLE `afs_month_rent` (
  `uid` varchar(40) NOT NULL COMMENT '主键',
  `house_id` varchar(40) DEFAULT NULL COMMENT '房屋主键',
  `month` varchar(10) DEFAULT NULL COMMENT '月份',
  `is_pay` varchar(5) DEFAULT NULL COMMENT '是否交租',
  `house_rent` int(6) DEFAULT NULL COMMENT '房租费用',
  `water_rent` int(6) DEFAULT NULL COMMENT '水费',
  `electricity` int(6) DEFAULT NULL COMMENT '电费',
  `network` int(6) DEFAULT NULL COMMENT '网费',
  `garbage` int(6) DEFAULT NULL COMMENT '垃圾费',
  `other` int(6) DEFAULT NULL COMMENT '其他费用',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='月租表';

/*Data for the table `afs_month_rent` */

insert  into `afs_month_rent`(`uid`,`house_id`,`month`,`is_pay`,`house_rent`,`water_rent`,`electricity`,`network`,`garbage`,`other`,`create_time`,`update_time`) values 
('111','1','202101','是',1400,30,300,100,20,NULL,'2021-01-02 13:16:26',NULL),
('2','1','202008','是',1400,20,300,100,20,NULL,'2020-08-02 13:16:26',NULL),
('22','1','202102','是',1400,40,300,100,20,NULL,'2020-09-02 13:16:26',NULL),
('33','1','202012','是',1400,30,100,100,20,NULL,'2020-12-02 13:16:26',NULL),
('44','1','202011','是',1400,30,100,100,20,NULL,'2021-01-02 13:16:26',NULL),
('55','1','202010','是',1400,30,400,100,20,NULL,'2021-01-02 13:16:26',NULL),
('66','1','202009','是',1400,50,230,100,20,NULL,'2021-01-02 13:16:26',NULL);

/*Table structure for table `afs_tenant` */

DROP TABLE IF EXISTS `afs_tenant`;

CREATE TABLE `afs_tenant` (
  `uid` varchar(40) NOT NULL COMMENT '主键',
  `tenant_name` varchar(50) DEFAULT NULL COMMENT '房屋编号',
  `tenant_num` int(2) DEFAULT NULL COMMENT '入住人数',
  `tenant_stat` int(2) DEFAULT NULL COMMENT '入住情况（0：空置  1：入住）',
  `create_time` date DEFAULT NULL COMMENT '创建时间',
  `update_time` date DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='房屋信息表';

/*Data for the table `afs_tenant` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
