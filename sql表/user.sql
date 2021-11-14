/*
SQLyog 企业版 - MySQL GUI v8.14 
MySQL - 5.5.25 : Database - spring_last_project
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`spring_last_project` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `spring_last_project`;

/*Table structure for table `users` */

DROP TABLE IF EXISTS `users`;

CREATE TABLE `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `face_image` varchar(255) DEFAULT NULL,
  `fans_counts` int(11) DEFAULT NULL,
  `follow_counts` int(11) DEFAULT NULL,
  `username` varchar(20) NOT NULL,
  `nickname` varchar(20) NOT NULL,
  `password` varchar(64) NOT NULL,
  `receive_like_counts` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

/*Data for the table `users` */

insert  into `users`(`id`,`face_image`,`fans_counts`,`follow_counts`,`username`,`nickname`,`password`,`receive_like_counts`) values (1,'/images/moonjay.jpg',1213,12,'MaoWJ','moonjay','123456',88),(2,'/images/xxy.jpg',4555,6,'XieXY','中指','123456',99),(3,'/images/wfq.jpg',5666,7,'WangFQ','RICK','123456',77),(4,'/images/lt.jpg',6555,23,'LuoT','Kiss','123456',111),(5,'/images/zxj.jpg',7565,14,'ZhaoXJ','太阳当空赵','123456',222);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
