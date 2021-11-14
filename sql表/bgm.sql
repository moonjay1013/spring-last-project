/*
SQLyog Ultimate v12.09 (64 bit)
MySQL - 8.0.22 
*********************************************************************
*/
/*!40101 SET NAMES utf8 */;

create table `bgm` (
	`id` int (11),
	`author` varchar (765),
	`music_name` varchar (765),
	`path` varchar (765)
); 
insert into `bgm` (`id`, `author`, `music_name`, `path`) values('1','薛之谦','我好想在哪里见过你','/bgm/薛之谦 - 我好像在哪见过你.mp3');
insert into `bgm` (`id`, `author`, `music_name`, `path`) values('2','GALA','追梦赤子心','/bgm/GALA - 追梦赤子心.mp3');
insert into `bgm` (`id`, `author`, `music_name`, `path`) values('3','许嵩','庐州月','/bgm/许嵩 - 庐州月.mp3');
insert into `bgm` (`id`, `author`, `music_name`, `path`) values('4','许嵩','最佳歌手','/bgm/许嵩 - 最佳歌手.mp3');
insert into `bgm` (`id`, `author`, `music_name`, `path`) values('5','陈奕迅','遥远的她','/bgm/陈奕迅 - 遥远的她 (Live).mp3');
