/*
SQLyog Ultimate v12.09 (64 bit)
MySQL - 5.5.56-MariaDB : Database - blog
*********************************************************************
*/


/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`blog` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `blog`;

/*Table structure for table `blog` */

CREATE TABLE `blog` (
  `blog_id` INT(11) NOT NULL AUTO_INCREMENT COMMENT '博客ID',
  `blog_title` VARCHAR(64) NOT NULL COMMENT '博客标题',
  `blog_content` TEXT NOT NULL COMMENT '博客内容',
  `content_type` TINYINT(1) DEFAULT '0' COMMENT '内容格式，0是markdown还是html格式',
  `blog_status` CHAR(1) NOT NULL DEFAULT '0' COMMENT '博客状态(0:新建,1:发表,2:个人)',
  `is_reproduced` TINYINT(1) NOT NULL DEFAULT '0' COMMENT '是否是转载内容',
  `modify_time` DATETIME NOT NULL COMMENT '修改时间',
  `create_time` DATETIME NOT NULL COMMENT '创建时间',
  `is_deleted` TINYINT(1) NOT NULL DEFAULT '0' COMMENT '删除状态(0:未删除,1:已删除)',
  PRIMARY KEY (`blog_id`)
) ENGINE=INNODB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8 COMMENT='博客主体表'


/*Table structure for table `check` */

CREATE TABLE `check` (
  `check_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '复核ID',
  `check_type` varchar(32) NOT NULL COMMENT '复核类型',
  `target_id` int(11) NOT NULL COMMENT '复核目标ID',
  `target_content` text NOT NULL COMMENT '复核目标内容',
  `check_status` char(1) NOT NULL DEFAULT '0' COMMENT '复核状态(0为待复核，-1为复核不通过，1为复核通过)',
  `modify_time` datetime NOT NULL COMMENT '修改时间',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`check_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='复核表(用于复核一些操作是否被允许)';

/*Table structure for table `comment` */

CREATE TABLE `comment` (
  `comment_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '评论ID',
  `blog_id` int(11) NOT NULL COMMENT '评论对应的博客ID',
  `target_id` int(11) DEFAULT NULL COMMENT '评论目标评论的ID，如为null则只针对博客进行评论',
  `comment_content` tinytext COMMENT '评论长度(最长为255)',
  `check_status` char(1) DEFAULT '0' COMMENT '复核状态(0为待复核，-1为复核不通过，1为复核通过)',
  `is_display` tinyint(1) DEFAULT '1' COMMENT '是否显示(默认为显示)',
  `is_deleted` tinyint(1) DEFAULT '0' COMMENT '是否删除',
  PRIMARY KEY (`comment_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='博客评论表';

/*Table structure for table `event` */

CREATE TABLE `event` (
  `event_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '事件ID',
  `event_name` varchar(48) NOT NULL COMMENT '事件名称',
  `event_desc` varchar(128) DEFAULT NULL COMMENT '事件描述',
  `is_finished` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否完成(1为完成，默认值0为未完成)',
  `modify_time` datetime NOT NULL COMMENT '修改时间',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `is_deleted` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否删除(1为删除，默认值0为未删除))',
  PRIMARY KEY (`event_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='事件表';

/*Table structure for table `image` */

CREATE TABLE `image` (
  `image_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '图片ID',
  `image_type` varchar(32) NOT NULL COMMENT '图片上传类别(blog、life、temp)',
  `relative_path` varchar(128) NOT NULL COMMENT '图片的相对路径',
  `upload_time` datetime NOT NULL COMMENT '上传时间',
  `modify_time` datetime NOT NULL COMMENT '修改时间',
  `is_deleted` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否删除',
  PRIMARY KEY (`image_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='图片表';

/*Table structure for table `todolist` */

CREATE TABLE `todolist` (
  `todolist_id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'TodoList ID',
  `user_id` int(11) NOT NULL COMMENT '用户ID',
  `content` varchar(255) NOT NULL COMMENT 'TodoList内容',
  `status` char(1) NOT NULL DEFAULT '0' COMMENT 'TodoList状态,默认值0为未删除，1为删除',
  `modify_time` datetime NOT NULL COMMENT '修改时间',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `is_deleted` tinyint(1) DEFAULT '0' COMMENT '是否删除',
  PRIMARY KEY (`todolist_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COMMENT='Todolist表';

/*Table structure for table `user` */

CREATE TABLE `user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户ID',
  `user_name` varchar(64) NOT NULL COMMENT '用户名(唯一)',
  `password` varchar(128) NOT NULL COMMENT '密码(密文存储)',
  `modify_time` datetime NOT NULL COMMENT '修改时间',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `is_deleted` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否被删除(1为已删除，0为未删除)',
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `user_name` (`user_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
