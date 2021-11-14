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

/*Table structure for table `videos` */

DROP TABLE IF EXISTS `videos`;

CREATE TABLE `videos` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `audio_id` int(11) DEFAULT NULL,
  `cover_path` varchar(255) NOT NULL,
  `create_time` datetime NOT NULL,
  `like_counts` bigint(20) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `user_id` int(11) NOT NULL,
  `video_desc` varchar(128) DEFAULT NULL,
  `video_height` int(11) DEFAULT NULL,
  `video_path` varchar(255) NOT NULL,
  `user_seconds` float DEFAULT NULL,
  `video_width` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `videos` */

insert  into `videos`(`id`,`audio_id`,`cover_path`,`create_time`,`like_counts`,`status`,`user_id`,`video_desc`,`video_height`,`video_path`,`user_seconds`,`video_width`) values (1,110701,'/videos/funny1.jpg','2021-11-07 20:34:19',888,1,1,'#只能说一模一样',100,'/videos/funny01.mp4',12,100),(2,110702,'/videos/funny2.jpg','2021-11-07 20:39:25',423,1,2,'#EDG牛皮！！！',100,'/videos/funny02.mp4',8,100);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
