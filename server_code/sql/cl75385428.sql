-- MySQL dump 10.13  Distrib 5.7.44, for Linux (x86_64)
--
-- Host: localhost    Database: cl75385428
-- ------------------------------------------------------
-- Server version	5.7.44

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Current Database: `cl75385428`
--

/*!40000 DROP DATABASE IF EXISTS `cl75385428`*/;

CREATE DATABASE /*!32312 IF NOT EXISTS*/ `cl75385428` /*!40100 DEFAULT CHARACTER SET utf8mb4 */;

USE `cl75385428`;

--
-- Table structure for table `config`
--

DROP TABLE IF EXISTS `config`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `config` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `name` varchar(200) NOT NULL COMMENT '名称',
  `value` longtext COMMENT '值',
  `url` longtext COMMENT '链接',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COMMENT='轮播图';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `config`
--

LOCK TABLES `config` WRITE;
/*!40000 ALTER TABLE `config` DISABLE KEYS */;
INSERT INTO `config` VALUES (1,'2024-11-12 12:04:22','swiper1','file/swiperPicture1.jpg',NULL),(2,'2024-11-12 12:04:22','swiper2','file/swiperPicture2.jpg',NULL),(3,'2024-11-12 12:04:22','swiper3','file/swiperPicture3.jpg',NULL),(7,'2024-11-12 12:04:22','APIKey','ihML0NfEM0jokUAuBD9tbYtW',NULL),(8,'2024-11-12 12:04:22','SecretKey','WK2bRUFf2uNe3oEoQXULpi8Y37aCvFdD',NULL);
/*!40000 ALTER TABLE `config` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `discussqingnianyizhan`
--

DROP TABLE IF EXISTS `discussqingnianyizhan`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `discussqingnianyizhan` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `refid` bigint(20) NOT NULL COMMENT '关联表id',
  `userid` bigint(20) NOT NULL COMMENT '用户id',
  `avatarurl` longtext COMMENT '头像',
  `nickname` varchar(200) DEFAULT NULL COMMENT '用户名',
  `content` longtext NOT NULL COMMENT '评论内容',
  `reply` longtext COMMENT '回复内容',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='青年驿站评论表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `discussqingnianyizhan`
--

LOCK TABLES `discussqingnianyizhan` WRITE;
/*!40000 ALTER TABLE `discussqingnianyizhan` DISABLE KEYS */;
/*!40000 ALTER TABLE `discussqingnianyizhan` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `forum`
--

DROP TABLE IF EXISTS `forum`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `forum` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `title` varchar(200) DEFAULT NULL COMMENT '帖子标题',
  `content` longtext NOT NULL COMMENT '帖子内容',
  `parentid` bigint(20) DEFAULT NULL COMMENT '父节点id',
  `username` varchar(200) DEFAULT NULL COMMENT '用户名',
  `avatarurl` longtext COMMENT '头像',
  `isdone` varchar(200) DEFAULT NULL COMMENT '状态',
  `is_top` int(11) DEFAULT '0' COMMENT '是否置顶',
  `top_time` datetime DEFAULT NULL COMMENT '置顶时间',
  `userid` bigint(20) NOT NULL COMMENT '用户id',
  `thumbsup_number` int(11) DEFAULT '0' COMMENT '赞',
  `crazily_number` int(11) DEFAULT '0' COMMENT '踩',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8 COMMENT='论坛交流';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `forum`
--

LOCK TABLES `forum` WRITE;
/*!40000 ALTER TABLE `forum` DISABLE KEYS */;
INSERT INTO `forum` VALUES (1,'2024-11-12 12:04:21','帖子标题1','帖子内容1',0,'用户名1','file/forumAvatarurl1.jpg,file/forumAvatarurl2.jpg,file/forumAvatarurl3.jpg','开放',1,'2024-11-12 20:04:21',1,1,1),(2,'2024-11-12 12:04:21','帖子标题2','帖子内容2',0,'用户名2','file/forumAvatarurl2.jpg,file/forumAvatarurl3.jpg,file/forumAvatarurl4.jpg','开放',2,'2024-11-12 20:04:21',2,2,2),(3,'2024-11-12 12:04:21','帖子标题3','帖子内容3',0,'用户名3','file/forumAvatarurl3.jpg,file/forumAvatarurl4.jpg,file/forumAvatarurl5.jpg','开放',3,'2024-11-12 20:04:21',3,3,3),(4,'2024-11-12 12:04:21','帖子标题4','帖子内容4',0,'用户名4','file/forumAvatarurl4.jpg,file/forumAvatarurl5.jpg,file/forumAvatarurl6.jpg','开放',4,'2024-11-12 20:04:21',4,4,4),(5,'2024-11-12 12:04:21','帖子标题5','帖子内容5',0,'用户名5','file/forumAvatarurl5.jpg,file/forumAvatarurl6.jpg,file/forumAvatarurl7.jpg','开放',5,'2024-11-12 20:04:21',5,5,5),(6,'2024-11-12 12:04:21','帖子标题6','帖子内容6',0,'用户名6','file/forumAvatarurl6.jpg,file/forumAvatarurl7.jpg,file/forumAvatarurl8.jpg','开放',6,'2024-11-12 20:04:21',6,6,6),(7,'2024-11-12 12:04:21','帖子标题7','帖子内容7',0,'用户名7','file/forumAvatarurl7.jpg,file/forumAvatarurl8.jpg,file/forumAvatarurl9.jpg','开放',7,'2024-11-12 20:04:21',7,7,7),(8,'2024-11-12 12:04:21','帖子标题8','帖子内容8',0,'用户名8','file/forumAvatarurl8.jpg,file/forumAvatarurl9.jpg,file/forumAvatarurl10.jpg','开放',8,'2024-11-12 20:04:21',8,8,8),(9,'2024-11-12 12:04:21','帖子标题9','帖子内容9',0,'用户名9','file/forumAvatarurl9.jpg,file/forumAvatarurl10.jpg,file/forumAvatarurl11.jpg','开放',9,'2024-11-12 20:04:21',9,9,9),(10,'2024-11-12 12:04:21','帖子标题10','帖子内容10',0,'用户名10','file/forumAvatarurl10.jpg,file/forumAvatarurl11.jpg,file/forumAvatarurl12.jpg','开放',10,'2024-11-12 20:04:21',10,10,10);
/*!40000 ALTER TABLE `forum` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `huodongbaoming`
--

DROP TABLE IF EXISTS `huodongbaoming`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `huodongbaoming` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `huodongmingcheng` varchar(200) NOT NULL COMMENT '活动名称',
  `huodongtupian` longtext NOT NULL COMMENT '活动图片',
  `huodongdidian` varchar(200) NOT NULL COMMENT '活动地点',
  `huodongshijian` datetime NOT NULL COMMENT '活动时间',
  `huodongxiangqing` longtext COMMENT '活动详情',
  `shenqingshijian` datetime DEFAULT NULL COMMENT '申请时间',
  `zhanghao` varchar(200) DEFAULT NULL COMMENT '账号',
  `xingming` varchar(200) DEFAULT NULL COMMENT '姓名',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8 COMMENT='活动报名';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `huodongbaoming`
--

LOCK TABLES `huodongbaoming` WRITE;
/*!40000 ALTER TABLE `huodongbaoming` DISABLE KEYS */;
INSERT INTO `huodongbaoming` VALUES (1,'2024-11-12 12:04:22','活动名称1','file/huodongbaomingHuodongtupian1.jpg,file/huodongbaomingHuodongtupian2.jpg,file/huodongbaomingHuodongtupian3.jpg','活动地点1','2024-11-12 20:04:22','活动详情1','2024-11-12 20:04:22','账号1','姓名1'),(2,'2024-11-12 12:04:22','活动名称2','file/huodongbaomingHuodongtupian2.jpg,file/huodongbaomingHuodongtupian3.jpg,file/huodongbaomingHuodongtupian4.jpg','活动地点2','2024-11-12 20:04:22','活动详情2','2024-11-12 20:04:22','账号2','姓名2'),(3,'2024-11-12 12:04:22','活动名称3','file/huodongbaomingHuodongtupian3.jpg,file/huodongbaomingHuodongtupian4.jpg,file/huodongbaomingHuodongtupian5.jpg','活动地点3','2024-11-12 20:04:22','活动详情3','2024-11-12 20:04:22','账号3','姓名3'),(4,'2024-11-12 12:04:22','活动名称4','file/huodongbaomingHuodongtupian4.jpg,file/huodongbaomingHuodongtupian5.jpg,file/huodongbaomingHuodongtupian6.jpg','活动地点4','2024-11-12 20:04:22','活动详情4','2024-11-12 20:04:22','账号4','姓名4'),(5,'2024-11-12 12:04:22','活动名称5','file/huodongbaomingHuodongtupian5.jpg,file/huodongbaomingHuodongtupian6.jpg,file/huodongbaomingHuodongtupian7.jpg','活动地点5','2024-11-12 20:04:22','活动详情5','2024-11-12 20:04:22','账号5','姓名5'),(6,'2024-11-12 12:04:22','活动名称6','file/huodongbaomingHuodongtupian6.jpg,file/huodongbaomingHuodongtupian7.jpg,file/huodongbaomingHuodongtupian8.jpg','活动地点6','2024-11-12 20:04:22','活动详情6','2024-11-12 20:04:22','账号6','姓名6'),(7,'2024-11-12 12:04:22','活动名称7','file/huodongbaomingHuodongtupian7.jpg,file/huodongbaomingHuodongtupian8.jpg,file/huodongbaomingHuodongtupian9.jpg','活动地点7','2024-11-12 20:04:22','活动详情7','2024-11-12 20:04:22','账号7','姓名7'),(8,'2024-11-12 12:04:22','活动名称8','file/huodongbaomingHuodongtupian8.jpg,file/huodongbaomingHuodongtupian9.jpg,file/huodongbaomingHuodongtupian10.jpg','活动地点8','2024-11-12 20:04:22','活动详情8','2024-11-12 20:04:22','账号8','姓名8'),(9,'2024-11-12 12:04:22','活动名称9','file/huodongbaomingHuodongtupian9.jpg,file/huodongbaomingHuodongtupian10.jpg,file/huodongbaomingHuodongtupian11.jpg','活动地点9','2024-11-12 20:04:22','活动详情9','2024-11-12 20:04:22','账号9','姓名9'),(10,'2024-11-12 12:04:22','活动名称10','file/huodongbaomingHuodongtupian10.jpg,file/huodongbaomingHuodongtupian11.jpg,file/huodongbaomingHuodongtupian12.jpg','活动地点10','2024-11-12 20:04:22','活动详情10','2024-11-12 20:04:22','账号10','姓名10');
/*!40000 ALTER TABLE `huodongbaoming` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `huodongxinxi`
--

DROP TABLE IF EXISTS `huodongxinxi`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `huodongxinxi` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `huodongmingcheng` varchar(200) NOT NULL COMMENT '活动名称',
  `huodongtupian` longtext NOT NULL COMMENT '活动图片',
  `huodongdidian` varchar(200) NOT NULL COMMENT '活动地点',
  `huodongshijian` datetime NOT NULL COMMENT '活动时间',
  `huodongxiangqing` longtext COMMENT '活动详情',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8 COMMENT='活动信息';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `huodongxinxi`
--

LOCK TABLES `huodongxinxi` WRITE;
/*!40000 ALTER TABLE `huodongxinxi` DISABLE KEYS */;
INSERT INTO `huodongxinxi` VALUES (1,'2024-11-12 12:04:22','活动名称1','file/huodongxinxiHuodongtupian1.jpg,file/huodongxinxiHuodongtupian2.jpg,file/huodongxinxiHuodongtupian3.jpg','活动地点1','2024-11-12 20:04:22','活动详情1'),(2,'2024-11-12 12:04:22','活动名称2','file/huodongxinxiHuodongtupian2.jpg,file/huodongxinxiHuodongtupian3.jpg,file/huodongxinxiHuodongtupian4.jpg','活动地点2','2024-11-12 20:04:22','活动详情2'),(3,'2024-11-12 12:04:22','活动名称3','file/huodongxinxiHuodongtupian3.jpg,file/huodongxinxiHuodongtupian4.jpg,file/huodongxinxiHuodongtupian5.jpg','活动地点3','2024-11-12 20:04:22','活动详情3'),(4,'2024-11-12 12:04:22','活动名称4','file/huodongxinxiHuodongtupian4.jpg,file/huodongxinxiHuodongtupian5.jpg,file/huodongxinxiHuodongtupian6.jpg','活动地点4','2024-11-12 20:04:22','活动详情4'),(5,'2024-11-12 12:04:22','活动名称5','file/huodongxinxiHuodongtupian5.jpg,file/huodongxinxiHuodongtupian6.jpg,file/huodongxinxiHuodongtupian7.jpg','活动地点5','2024-11-12 20:04:22','活动详情5'),(6,'2024-11-12 12:04:22','活动名称6','file/huodongxinxiHuodongtupian6.jpg,file/huodongxinxiHuodongtupian7.jpg,file/huodongxinxiHuodongtupian8.jpg','活动地点6','2024-11-12 20:04:22','活动详情6'),(7,'2024-11-12 12:04:22','活动名称7','file/huodongxinxiHuodongtupian7.jpg,file/huodongxinxiHuodongtupian8.jpg,file/huodongxinxiHuodongtupian9.jpg','活动地点7','2024-11-12 20:04:22','活动详情7'),(8,'2024-11-12 12:04:22','活动名称8','file/huodongxinxiHuodongtupian8.jpg,file/huodongxinxiHuodongtupian9.jpg,file/huodongxinxiHuodongtupian10.jpg','活动地点8','2024-11-12 20:04:22','活动详情8'),(9,'2024-11-12 12:04:22','活动名称9','file/huodongxinxiHuodongtupian9.jpg,file/huodongxinxiHuodongtupian10.jpg,file/huodongxinxiHuodongtupian11.jpg','活动地点9','2024-11-12 20:04:22','活动详情9'),(10,'2024-11-12 12:04:22','活动名称10','file/huodongxinxiHuodongtupian10.jpg,file/huodongxinxiHuodongtupian11.jpg,file/huodongxinxiHuodongtupian12.jpg','活动地点10','2024-11-12 20:04:22','活动详情10');
/*!40000 ALTER TABLE `huodongxinxi` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `jianlitoudi`
--

DROP TABLE IF EXISTS `jianlitoudi`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `jianlitoudi` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `gangweimingcheng` varchar(200) NOT NULL COMMENT '岗位名称',
  `bangonghuanjing` longtext COMMENT '办公环境',
  `zhaopinrenshu` varchar(200) DEFAULT NULL COMMENT '招聘人数',
  `xueliyaoqiu` varchar(200) DEFAULT NULL COMMENT '学历要求',
  `xinzidaiyu` varchar(200) DEFAULT NULL COMMENT '薪资待遇',
  `gongzuoshijian` varchar(200) DEFAULT NULL COMMENT '工作时间',
  `qiyezhanghao` varchar(200) DEFAULT NULL COMMENT '企业账号',
  `qiyemingcheng` varchar(200) DEFAULT NULL COMMENT '企业名称',
  `lianxidianhua` varchar(200) DEFAULT NULL COMMENT '联系电话',
  `qiyedizhi` varchar(200) DEFAULT NULL COMMENT '企业地址',
  `zhanghao` varchar(200) DEFAULT NULL COMMENT '账号',
  `xingming` varchar(200) DEFAULT NULL COMMENT '姓名',
  `jianli` longtext COMMENT '简历',
  `sfsh` varchar(200) DEFAULT '待审核' COMMENT '是否审核',
  `shhf` longtext COMMENT '回复内容',
  `crossuserid` bigint(20) DEFAULT NULL COMMENT '跨表用户id',
  `crossrefid` bigint(20) DEFAULT NULL COMMENT '跨表主键id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8 COMMENT='简历投递';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `jianlitoudi`
--

LOCK TABLES `jianlitoudi` WRITE;
/*!40000 ALTER TABLE `jianlitoudi` DISABLE KEYS */;
INSERT INTO `jianlitoudi` VALUES (1,'2024-11-12 12:04:22','岗位名称1','file/jianlitoudiBangonghuanjing1.jpg,file/jianlitoudiBangonghuanjing2.jpg,file/jianlitoudiBangonghuanjing3.jpg','招聘人数1','学历要求1','薪资待遇1','工作时间1','企业账号1','企业名称1','联系电话1','企业地址1','账号1','姓名1','','是','',1,1),(2,'2024-11-12 12:04:22','岗位名称2','file/jianlitoudiBangonghuanjing2.jpg,file/jianlitoudiBangonghuanjing3.jpg,file/jianlitoudiBangonghuanjing4.jpg','招聘人数2','学历要求2','薪资待遇2','工作时间2','企业账号2','企业名称2','联系电话2','企业地址2','账号2','姓名2','','是','',2,2),(3,'2024-11-12 12:04:22','岗位名称3','file/jianlitoudiBangonghuanjing3.jpg,file/jianlitoudiBangonghuanjing4.jpg,file/jianlitoudiBangonghuanjing5.jpg','招聘人数3','学历要求3','薪资待遇3','工作时间3','企业账号3','企业名称3','联系电话3','企业地址3','账号3','姓名3','','是','',3,3),(4,'2024-11-12 12:04:22','岗位名称4','file/jianlitoudiBangonghuanjing4.jpg,file/jianlitoudiBangonghuanjing5.jpg,file/jianlitoudiBangonghuanjing6.jpg','招聘人数4','学历要求4','薪资待遇4','工作时间4','企业账号4','企业名称4','联系电话4','企业地址4','账号4','姓名4','','是','',4,4),(5,'2024-11-12 12:04:22','岗位名称5','file/jianlitoudiBangonghuanjing5.jpg,file/jianlitoudiBangonghuanjing6.jpg,file/jianlitoudiBangonghuanjing7.jpg','招聘人数5','学历要求5','薪资待遇5','工作时间5','企业账号5','企业名称5','联系电话5','企业地址5','账号5','姓名5','','是','',5,5),(6,'2024-11-12 12:04:22','岗位名称6','file/jianlitoudiBangonghuanjing6.jpg,file/jianlitoudiBangonghuanjing7.jpg,file/jianlitoudiBangonghuanjing8.jpg','招聘人数6','学历要求6','薪资待遇6','工作时间6','企业账号6','企业名称6','联系电话6','企业地址6','账号6','姓名6','','是','',6,6),(7,'2024-11-12 12:04:22','岗位名称7','file/jianlitoudiBangonghuanjing7.jpg,file/jianlitoudiBangonghuanjing8.jpg,file/jianlitoudiBangonghuanjing9.jpg','招聘人数7','学历要求7','薪资待遇7','工作时间7','企业账号7','企业名称7','联系电话7','企业地址7','账号7','姓名7','','是','',7,7),(8,'2024-11-12 12:04:22','岗位名称8','file/jianlitoudiBangonghuanjing8.jpg,file/jianlitoudiBangonghuanjing9.jpg,file/jianlitoudiBangonghuanjing10.jpg','招聘人数8','学历要求8','薪资待遇8','工作时间8','企业账号8','企业名称8','联系电话8','企业地址8','账号8','姓名8','','是','',8,8),(9,'2024-11-12 12:04:22','岗位名称9','file/jianlitoudiBangonghuanjing9.jpg,file/jianlitoudiBangonghuanjing10.jpg,file/jianlitoudiBangonghuanjing11.jpg','招聘人数9','学历要求9','薪资待遇9','工作时间9','企业账号9','企业名称9','联系电话9','企业地址9','账号9','姓名9','','是','',9,9),(10,'2024-11-12 12:04:22','岗位名称10','file/jianlitoudiBangonghuanjing10.jpg,file/jianlitoudiBangonghuanjing11.jpg,file/jianlitoudiBangonghuanjing12.jpg','招聘人数10','学历要求10','薪资待遇10','工作时间10','企业账号10','企业名称10','联系电话10','企业地址10','账号10','姓名10','','是','',10,10);
/*!40000 ALTER TABLE `jianlitoudi` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `likaishangbao`
--

DROP TABLE IF EXISTS `likaishangbao`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `likaishangbao` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `yizhanmingcheng` varchar(200) NOT NULL COMMENT '驿站名称',
  `mendiantu` longtext COMMENT '门店图',
  `ruzhuxiangqing` varchar(200) DEFAULT NULL COMMENT '入住详情',
  `ruzhushijian` varchar(200) DEFAULT NULL COMMENT '入住时间',
  `shijian` datetime DEFAULT NULL COMMENT '确认离开时间',
  `zhanghao` varchar(200) DEFAULT NULL COMMENT '账号',
  `xingming` varchar(200) DEFAULT NULL COMMENT '姓名',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8 COMMENT='离开上报';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `likaishangbao`
--

LOCK TABLES `likaishangbao` WRITE;
/*!40000 ALTER TABLE `likaishangbao` DISABLE KEYS */;
INSERT INTO `likaishangbao` VALUES (1,'2024-11-12 12:04:22','驿站名称1','file/likaishangbaoMendiantu1.jpg,file/likaishangbaoMendiantu2.jpg,file/likaishangbaoMendiantu3.jpg','入住详情1','入住时间1','2024-11-12 20:04:22','账号1','姓名1'),(2,'2024-11-12 12:04:22','驿站名称2','file/likaishangbaoMendiantu2.jpg,file/likaishangbaoMendiantu3.jpg,file/likaishangbaoMendiantu4.jpg','入住详情2','入住时间2','2024-11-12 20:04:22','账号2','姓名2'),(3,'2024-11-12 12:04:22','驿站名称3','file/likaishangbaoMendiantu3.jpg,file/likaishangbaoMendiantu4.jpg,file/likaishangbaoMendiantu5.jpg','入住详情3','入住时间3','2024-11-12 20:04:22','账号3','姓名3'),(4,'2024-11-12 12:04:22','驿站名称4','file/likaishangbaoMendiantu4.jpg,file/likaishangbaoMendiantu5.jpg,file/likaishangbaoMendiantu6.jpg','入住详情4','入住时间4','2024-11-12 20:04:22','账号4','姓名4'),(5,'2024-11-12 12:04:22','驿站名称5','file/likaishangbaoMendiantu5.jpg,file/likaishangbaoMendiantu6.jpg,file/likaishangbaoMendiantu7.jpg','入住详情5','入住时间5','2024-11-12 20:04:22','账号5','姓名5'),(6,'2024-11-12 12:04:22','驿站名称6','file/likaishangbaoMendiantu6.jpg,file/likaishangbaoMendiantu7.jpg,file/likaishangbaoMendiantu8.jpg','入住详情6','入住时间6','2024-11-12 20:04:22','账号6','姓名6'),(7,'2024-11-12 12:04:22','驿站名称7','file/likaishangbaoMendiantu7.jpg,file/likaishangbaoMendiantu8.jpg,file/likaishangbaoMendiantu9.jpg','入住详情7','入住时间7','2024-11-12 20:04:22','账号7','姓名7'),(8,'2024-11-12 12:04:22','驿站名称8','file/likaishangbaoMendiantu8.jpg,file/likaishangbaoMendiantu9.jpg,file/likaishangbaoMendiantu10.jpg','入住详情8','入住时间8','2024-11-12 20:04:22','账号8','姓名8'),(9,'2024-11-12 12:04:22','驿站名称9','file/likaishangbaoMendiantu9.jpg,file/likaishangbaoMendiantu10.jpg,file/likaishangbaoMendiantu11.jpg','入住详情9','入住时间9','2024-11-12 20:04:22','账号9','姓名9'),(10,'2024-11-12 12:04:22','驿站名称10','file/likaishangbaoMendiantu10.jpg,file/likaishangbaoMendiantu11.jpg,file/likaishangbaoMendiantu12.jpg','入住详情10','入住时间10','2024-11-12 20:04:22','账号10','姓名10'),(11,'2024-11-12 12:11:19','驿站名称1','file/qingnianyizhanMendiantu1.jpg,file/qingnianyizhanMendiantu2.jpg,file/qingnianyizhanMendiantu3.jpg','入住详情1','2024-11-13 00:00:00','2024-11-14 00:00:00','账号1','姓名1');
/*!40000 ALTER TABLE `likaishangbao` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `menu`
--

DROP TABLE IF EXISTS `menu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `menu` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `menujson` longtext NOT NULL COMMENT '菜单',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='菜单';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `menu`
--

LOCK TABLES `menu` WRITE;
/*!40000 ALTER TABLE `menu` DISABLE KEYS */;
INSERT INTO `menu` VALUES (1,'2024-11-12 12:04:22','[{\"backMenu\":[{\"child\":[{\"allButtons\":[\"新增\",\"查看\",\"修改\",\"删除\"],\"appFrontIcon\":\"cuIcon-vip\",\"buttons\":[\"新增\",\"查看\",\"修改\",\"删除\",\"查看评论\"],\"classname\":\"forum\",\"menu\":\"论坛交流\",\"tableName\":\"forum\"}],\"menu\":\"论坛管理\"},{\"child\":[{\"allButtons\":[\"新增\",\"查看\",\"修改\",\"删除\"],\"appFrontIcon\":\"cuIcon-flashlightopen\",\"buttons\":[\"新增\",\"查看\",\"修改\",\"删除\"],\"classname\":\"config\",\"menu\":\"轮播图\",\"menuJump\":\"列表\",\"tableName\":\"config\"}],\"fontClass\":\"icon-common36\",\"menu\":\"轮播图管理\",\"unicode\":\"&#xee9f;\"},{\"child\":[{\"allButtons\":[\"新增\",\"查看\",\"修改\",\"删除\",\"收藏统计\",\"首页总数\",\"首页统计\",\"投递\"],\"appFrontIcon\":\"cuIcon-attentionfavor\",\"buttons\":[\"新增\",\"查看\",\"修改\",\"删除\",\"收藏统计\",\"首页总数\",\"首页统计\"],\"classname\":\"zhaopinhuodong\",\"menu\":\"招聘活动\",\"menuJump\":\"列表\",\"tableName\":\"zhaopinhuodong\"},{\"allButtons\":[\"新增\",\"查看\",\"修改\",\"删除\",\"审核\",\"首页总数\",\"首页统计\"],\"appFrontIcon\":\"cuIcon-pic\",\"buttons\":[\"新增\",\"查看\",\"修改\",\"删除\",\"首页总数\",\"首页统计\",\"审核\"],\"classname\":\"jianlitoudi\",\"menu\":\"简历投递\",\"menuJump\":\"列表\",\"tableName\":\"jianlitoudi\"}],\"fontClass\":\"icon-common17\",\"menu\":\"招聘信息管理\",\"unicode\":\"&#xedfe;\"},{\"child\":[{\"allButtons\":[\"新增\",\"查看\",\"修改\",\"删除\",\"报名\"],\"appFrontIcon\":\"cuIcon-pay\",\"buttons\":[\"新增\",\"查看\",\"修改\",\"删除\"],\"classname\":\"huodongxinxi\",\"menu\":\"活动信息\",\"menuJump\":\"列表\",\"tableName\":\"huodongxinxi\"},{\"allButtons\":[\"新增\",\"查看\",\"修改\",\"删除\"],\"appFrontIcon\":\"cuIcon-time\",\"buttons\":[\"新增\",\"查看\",\"修改\",\"删除\"],\"classname\":\"huodongbaoming\",\"menu\":\"活动报名\",\"menuJump\":\"列表\",\"tableName\":\"huodongbaoming\"}],\"fontClass\":\"icon-common9\",\"menu\":\"活动信息管理\",\"unicode\":\"&#xedc9;\"},{\"child\":[{\"allButtons\":[\"新增\",\"查看\",\"修改\",\"删除\",\"查看评论\",\"申请入住\"],\"appFrontIcon\":\"cuIcon-pic\",\"buttons\":[\"新增\",\"查看\",\"修改\",\"删除\",\"审核\",\"查看评论\"],\"classname\":\"qingnianyizhan\",\"menu\":\"青年驿站\",\"menuJump\":\"列表\",\"tableName\":\"qingnianyizhan\"},{\"allButtons\":[\"新增\",\"查看\",\"修改\",\"删除\",\"审核\",\"离开上报\"],\"appFrontIcon\":\"cuIcon-present\",\"buttons\":[\"新增\",\"查看\",\"修改\",\"删除\",\"审核\"],\"classname\":\"shenqingruzhu\",\"menu\":\"申请入住\",\"menuJump\":\"列表\",\"tableName\":\"shenqingruzhu\"},{\"allButtons\":[\"新增\",\"查看\",\"修改\",\"删除\"],\"appFrontIcon\":\"cuIcon-keyboard\",\"buttons\":[\"新增\",\"查看\",\"修改\",\"删除\"],\"classname\":\"likaishangbao\",\"menu\":\"离开上报\",\"menuJump\":\"列表\",\"tableName\":\"likaishangbao\"}],\"fontClass\":\"icon-common37\",\"menu\":\"青年驿站管理\",\"unicode\":\"&#xeea4;\"},{\"child\":[{\"allButtons\":[\"新增\",\"查看\",\"修改\",\"删除\"],\"appFrontIcon\":\"cuIcon-present\",\"buttons\":[\"新增\",\"查看\",\"修改\",\"删除\"],\"classname\":\"users\",\"menu\":\"管理员\",\"menuJump\":\"列表\",\"tableName\":\"users\"},{\"allButtons\":[\"新增\",\"查看\",\"修改\",\"删除\"],\"appFrontIcon\":\"cuIcon-copy\",\"buttons\":[\"新增\",\"查看\",\"修改\",\"删除\",\"审核\"],\"classname\":\"qiye\",\"menu\":\"企业\",\"menuJump\":\"列表\",\"tableName\":\"qiye\"},{\"allButtons\":[\"新增\",\"查看\",\"修改\",\"删除\"],\"appFrontIcon\":\"cuIcon-goods\",\"buttons\":[\"新增\",\"查看\",\"修改\",\"删除\"],\"classname\":\"yonghu\",\"menu\":\"用户\",\"menuJump\":\"列表\",\"tableName\":\"yonghu\"}],\"fontClass\":\"icon-user8\",\"menu\":\"用户管理\",\"unicode\":\"&#xef9e;\"}],\"frontMenu\":[{\"child\":[{\"appFrontIcon\":\"cuIcon-camera\",\"buttons\":[\"查看\",\"报名\"],\"classname\":\"huodongxinxi\",\"fontClass\":\"icon-common13\",\"menu\":\"活动信息\",\"menuJump\":\"列表\",\"tableName\":\"huodongxinxi\",\"unicode\":\"&#xedf7;\"}],\"fontClass\":\"icon-common13\",\"menu\":\"活动管理\",\"unicode\":\"&#xedf7;\"},{\"child\":[{\"appFrontIcon\":\"cuIcon-rank\",\"buttons\":[\"查看\",\"投递\"],\"classname\":\"zhaopinhuodong\",\"fontClass\":\"icon-common15\",\"menu\":\"招聘活动\",\"menuJump\":\"列表\",\"tableName\":\"zhaopinhuodong\",\"unicode\":\"&#xedfc;\"}],\"fontClass\":\"icon-common15\",\"menu\":\"招聘管理\",\"unicode\":\"&#xedfc;\"},{\"child\":[{\"appFrontIcon\":\"cuIcon-cardboard\",\"buttons\":[\"查看\",\"新增\"],\"classname\":\"forum\",\"menu\":\"论坛交流\",\"menuJump\":\"列表\",\"tableName\":\"forum\"}],\"menu\":\"论坛交流\"},{\"child\":[{\"appFrontIcon\":\"cuIcon-camera\",\"buttons\":[\"查看\",\"申请入住\",\"查看评论\"],\"classname\":\"qingnianyizhan\",\"fontClass\":\"icon-common14\",\"menu\":\"青年驿站\",\"menuJump\":\"列表\",\"tableName\":\"qingnianyizhan\",\"unicode\":\"&#xedfb;\"}],\"fontClass\":\"icon-common14\",\"menu\":\"青年驿站管理\",\"unicode\":\"&#xedfb;\"}],\"hasBackLogin\":\"是\",\"hasBackRegister\":\"否\",\"hasFrontLogin\":\"否\",\"hasFrontRegister\":\"否\",\"roleName\":\"管理员\",\"tableName\":\"users\"},{\"backMenu\":[{\"child\":[{\"allButtons\":[\"新增\",\"查看\",\"修改\",\"删除\"],\"appFrontIcon\":\"cuIcon-vip\",\"buttons\":[\"查看\",\"查看评论\"],\"classname\":\"forum\",\"menu\":\"论坛交流\",\"tableName\":\"forum\"}],\"menu\":\"论坛管理\"},{\"child\":[{\"allButtons\":[\"新增\",\"查看\",\"修改\",\"删除\",\"收藏统计\",\"首页总数\",\"首页统计\",\"投递\"],\"appFrontIcon\":\"cuIcon-attentionfavor\",\"buttons\":[\"查看\",\"新增\",\"删除\",\"收藏统计\",\"首页总数\",\"首页统计\"],\"classname\":\"zhaopinhuodong\",\"menu\":\"招聘活动\",\"menuJump\":\"列表\",\"tableName\":\"zhaopinhuodong\"},{\"allButtons\":[\"新增\",\"查看\",\"修改\",\"删除\",\"审核\",\"首页总数\",\"首页统计\"],\"appFrontIcon\":\"cuIcon-pic\",\"buttons\":[\"查看\",\"首页总数\",\"首页统计\"],\"classname\":\"jianlitoudi\",\"menu\":\"简历投递\",\"menuJump\":\"列表\",\"tableName\":\"jianlitoudi\"}],\"fontClass\":\"icon-common17\",\"menu\":\"招聘信息管理\",\"unicode\":\"&#xedfe;\"}],\"frontMenu\":[{\"child\":[{\"appFrontIcon\":\"cuIcon-camera\",\"buttons\":[\"查看\",\"报名\"],\"classname\":\"huodongxinxi\",\"fontClass\":\"icon-common13\",\"menu\":\"活动信息\",\"menuJump\":\"列表\",\"tableName\":\"huodongxinxi\",\"unicode\":\"&#xedf7;\"}],\"fontClass\":\"icon-common13\",\"menu\":\"活动管理\",\"unicode\":\"&#xedf7;\"},{\"child\":[{\"appFrontIcon\":\"cuIcon-rank\",\"buttons\":[\"查看\",\"投递\"],\"classname\":\"zhaopinhuodong\",\"fontClass\":\"icon-common15\",\"menu\":\"招聘活动\",\"menuJump\":\"列表\",\"tableName\":\"zhaopinhuodong\",\"unicode\":\"&#xedfc;\"}],\"fontClass\":\"icon-common15\",\"menu\":\"招聘管理\",\"unicode\":\"&#xedfc;\"},{\"child\":[{\"appFrontIcon\":\"cuIcon-cardboard\",\"buttons\":[\"查看\",\"新增\"],\"classname\":\"forum\",\"menu\":\"论坛交流\",\"menuJump\":\"列表\",\"tableName\":\"forum\"}],\"menu\":\"论坛交流\"},{\"child\":[{\"appFrontIcon\":\"cuIcon-camera\",\"buttons\":[\"查看\",\"申请入住\",\"查看评论\"],\"classname\":\"qingnianyizhan\",\"fontClass\":\"icon-common14\",\"menu\":\"青年驿站\",\"menuJump\":\"列表\",\"tableName\":\"qingnianyizhan\",\"unicode\":\"&#xedfb;\"}],\"fontClass\":\"icon-common14\",\"menu\":\"青年驿站管理\",\"unicode\":\"&#xedfb;\"}],\"hasBackLogin\":\"是\",\"hasBackRegister\":\"是\",\"hasFrontLogin\":\"否\",\"hasFrontRegister\":\"否\",\"roleName\":\"企业\",\"tableName\":\"qiye\"},{\"backMenu\":[{\"child\":[{\"allButtons\":[\"新增\",\"查看\",\"修改\",\"删除\"],\"appFrontIcon\":\"cuIcon-pic\",\"buttons\":[\"新增\",\"查看\",\"删除\"],\"classname\":\"storeup\",\"menu\":\"我的收藏\",\"menuJump\":\"1\",\"tableName\":\"storeup\"}],\"fontClass\":\"icon-common40\",\"menu\":\"我的收藏管理\",\"unicode\":\"&#xeebb;\"},{\"child\":[{\"allButtons\":[\"新增\",\"查看\",\"修改\",\"删除\"],\"appFrontIcon\":\"cuIcon-vip\",\"buttons\":[\"查看\",\"删除\"],\"classname\":\"forum\",\"menu\":\"我的发布\",\"menuJump\":\"14\",\"tableName\":\"forum\"}],\"menu\":\"论坛管理\"},{\"child\":[{\"allButtons\":[\"新增\",\"查看\",\"修改\",\"删除\",\"审核\",\"首页总数\",\"首页统计\"],\"appFrontIcon\":\"cuIcon-pic\",\"buttons\":[\"查看\"],\"classname\":\"jianlitoudi\",\"menu\":\"简历投递\",\"menuJump\":\"列表\",\"tableName\":\"jianlitoudi\"}],\"fontClass\":\"icon-common17\",\"menu\":\"招聘信息管理\",\"unicode\":\"&#xedfe;\"},{\"child\":[{\"allButtons\":[\"新增\",\"查看\",\"修改\",\"删除\"],\"appFrontIcon\":\"cuIcon-time\",\"buttons\":[\"查看\"],\"classname\":\"huodongbaoming\",\"menu\":\"活动报名\",\"menuJump\":\"列表\",\"tableName\":\"huodongbaoming\"}],\"fontClass\":\"icon-common9\",\"menu\":\"活动信息管理\",\"unicode\":\"&#xedc9;\"},{\"child\":[{\"allButtons\":[\"新增\",\"查看\",\"修改\",\"删除\",\"审核\",\"离开上报\"],\"appFrontIcon\":\"cuIcon-present\",\"buttons\":[\"查看\",\"离开上报\"],\"classname\":\"shenqingruzhu\",\"menu\":\"申请入住\",\"menuJump\":\"列表\",\"tableName\":\"shenqingruzhu\"},{\"allButtons\":[\"新增\",\"查看\",\"修改\",\"删除\"],\"appFrontIcon\":\"cuIcon-keyboard\",\"buttons\":[\"查看\"],\"classname\":\"likaishangbao\",\"menu\":\"离开上报\",\"menuJump\":\"列表\",\"tableName\":\"likaishangbao\"}],\"fontClass\":\"icon-common37\",\"menu\":\"青年驿站管理\",\"unicode\":\"&#xeea4;\"}],\"frontMenu\":[{\"child\":[{\"appFrontIcon\":\"cuIcon-camera\",\"buttons\":[\"查看\",\"报名\"],\"classname\":\"huodongxinxi\",\"fontClass\":\"icon-common13\",\"menu\":\"活动信息\",\"menuJump\":\"列表\",\"tableName\":\"huodongxinxi\",\"unicode\":\"&#xedf7;\"}],\"fontClass\":\"icon-common13\",\"menu\":\"活动管理\",\"unicode\":\"&#xedf7;\"},{\"child\":[{\"appFrontIcon\":\"cuIcon-rank\",\"buttons\":[\"查看\",\"投递\"],\"classname\":\"zhaopinhuodong\",\"fontClass\":\"icon-common15\",\"menu\":\"招聘活动\",\"menuJump\":\"列表\",\"tableName\":\"zhaopinhuodong\",\"unicode\":\"&#xedfc;\"}],\"fontClass\":\"icon-common15\",\"menu\":\"招聘管理\",\"unicode\":\"&#xedfc;\"},{\"child\":[{\"appFrontIcon\":\"cuIcon-cardboard\",\"buttons\":[\"查看\",\"新增\"],\"classname\":\"forum\",\"menu\":\"论坛交流\",\"menuJump\":\"列表\",\"tableName\":\"forum\"}],\"menu\":\"论坛交流\"},{\"child\":[{\"appFrontIcon\":\"cuIcon-camera\",\"buttons\":[\"查看\",\"申请入住\",\"查看评论\"],\"classname\":\"qingnianyizhan\",\"fontClass\":\"icon-common14\",\"menu\":\"青年驿站\",\"menuJump\":\"列表\",\"tableName\":\"qingnianyizhan\",\"unicode\":\"&#xedfb;\"}],\"fontClass\":\"icon-common14\",\"menu\":\"青年驿站管理\",\"unicode\":\"&#xedfb;\"}],\"hasBackLogin\":\"否\",\"hasBackRegister\":\"否\",\"hasFrontLogin\":\"是\",\"hasFrontRegister\":\"是\",\"roleName\":\"用户\",\"tableName\":\"yonghu\"}]');
/*!40000 ALTER TABLE `menu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `qingnianyizhan`
--

DROP TABLE IF EXISTS `qingnianyizhan`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `qingnianyizhan` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `yizhanmingcheng` varchar(200) NOT NULL COMMENT '驿站名称',
  `mendiantu` longtext COMMENT '门店图',
  `ruzhuxiangqing` longtext COMMENT '入住详情',
  `storeup_number` int(11) DEFAULT '0' COMMENT '收藏数',
  `discuss_number` int(11) DEFAULT '0' COMMENT '评论数',
  `clicktime` datetime DEFAULT NULL COMMENT '最近点击时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8 COMMENT='青年驿站';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `qingnianyizhan`
--

LOCK TABLES `qingnianyizhan` WRITE;
/*!40000 ALTER TABLE `qingnianyizhan` DISABLE KEYS */;
INSERT INTO `qingnianyizhan` VALUES (1,'2024-11-12 12:04:22','驿站名称1','file/qingnianyizhanMendiantu1.jpg,file/qingnianyizhanMendiantu2.jpg,file/qingnianyizhanMendiantu3.jpg','入住详情1',1,1,'2024-11-12 20:04:22'),(2,'2024-11-12 12:04:22','驿站名称2','file/qingnianyizhanMendiantu2.jpg,file/qingnianyizhanMendiantu3.jpg,file/qingnianyizhanMendiantu4.jpg','入住详情2',2,2,'2024-11-12 20:04:22'),(3,'2024-11-12 12:04:22','驿站名称3','file/qingnianyizhanMendiantu3.jpg,file/qingnianyizhanMendiantu4.jpg,file/qingnianyizhanMendiantu5.jpg','入住详情3',3,3,'2024-11-12 20:04:22'),(4,'2024-11-12 12:04:22','驿站名称4','file/qingnianyizhanMendiantu4.jpg,file/qingnianyizhanMendiantu5.jpg,file/qingnianyizhanMendiantu6.jpg','入住详情4',4,4,'2024-11-12 20:04:22'),(5,'2024-11-12 12:04:22','驿站名称5','file/qingnianyizhanMendiantu5.jpg,file/qingnianyizhanMendiantu6.jpg,file/qingnianyizhanMendiantu7.jpg','入住详情5',5,5,'2024-11-12 20:04:22'),(6,'2024-11-12 12:04:22','驿站名称6','file/qingnianyizhanMendiantu6.jpg,file/qingnianyizhanMendiantu7.jpg,file/qingnianyizhanMendiantu8.jpg','入住详情6',6,6,'2024-11-12 20:04:22'),(7,'2024-11-12 12:04:22','驿站名称7','file/qingnianyizhanMendiantu7.jpg,file/qingnianyizhanMendiantu8.jpg,file/qingnianyizhanMendiantu9.jpg','入住详情7',7,7,'2024-11-12 20:04:22'),(8,'2024-11-12 12:04:22','驿站名称8','file/qingnianyizhanMendiantu8.jpg,file/qingnianyizhanMendiantu9.jpg,file/qingnianyizhanMendiantu10.jpg','入住详情8',8,8,'2024-11-12 20:04:22'),(9,'2024-11-12 12:04:22','驿站名称9','file/qingnianyizhanMendiantu9.jpg,file/qingnianyizhanMendiantu10.jpg,file/qingnianyizhanMendiantu11.jpg','入住详情9',9,9,'2024-11-12 20:04:22'),(10,'2024-11-12 12:04:22','驿站名称10','file/qingnianyizhanMendiantu10.jpg,file/qingnianyizhanMendiantu11.jpg,file/qingnianyizhanMendiantu12.jpg','入住详情10',10,10,'2024-11-12 20:04:22');
/*!40000 ALTER TABLE `qingnianyizhan` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `qiye`
--

DROP TABLE IF EXISTS `qiye`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `qiye` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `qiyezhanghao` varchar(200) NOT NULL COMMENT '企业账号',
  `mima` varchar(200) NOT NULL COMMENT '密码',
  `qiyemingcheng` varchar(200) NOT NULL COMMENT '企业名称',
  `fengmian` longtext COMMENT '封面',
  `lianxiren` varchar(200) DEFAULT NULL COMMENT '联系人',
  `lianxidianhua` varchar(200) DEFAULT NULL COMMENT '联系电话',
  `qiyedizhi` varchar(200) DEFAULT NULL COMMENT '企业地址',
  PRIMARY KEY (`id`),
  UNIQUE KEY `qiyezhanghao` (`qiyezhanghao`)
) ENGINE=InnoDB AUTO_INCREMENT=61 DEFAULT CHARSET=utf8 COMMENT='企业';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `qiye`
--

LOCK TABLES `qiye` WRITE;
/*!40000 ALTER TABLE `qiye` DISABLE KEYS */;
INSERT INTO `qiye` VALUES (51,'2024-11-12 12:04:21','企业账号1','123456','企业名称1','file/qiyeFengmian1.jpg','联系人1','19819881111','企业地址1'),(52,'2024-11-12 12:04:21','企业账号2','123456','企业名称2','file/qiyeFengmian2.jpg','联系人2','19819881112','企业地址2'),(53,'2024-11-12 12:04:21','企业账号3','123456','企业名称3','file/qiyeFengmian3.jpg','联系人3','19819881113','企业地址3'),(54,'2024-11-12 12:04:21','企业账号4','123456','企业名称4','file/qiyeFengmian4.jpg','联系人4','19819881114','企业地址4'),(55,'2024-11-12 12:04:21','企业账号5','123456','企业名称5','file/qiyeFengmian5.jpg','联系人5','19819881115','企业地址5'),(56,'2024-11-12 12:04:21','企业账号6','123456','企业名称6','file/qiyeFengmian6.jpg','联系人6','19819881116','企业地址6'),(57,'2024-11-12 12:04:21','企业账号7','123456','企业名称7','file/qiyeFengmian7.jpg','联系人7','19819881117','企业地址7'),(58,'2024-11-12 12:04:21','企业账号8','123456','企业名称8','file/qiyeFengmian8.jpg','联系人8','19819881118','企业地址8'),(59,'2024-11-12 12:04:21','企业账号9','123456','企业名称9','file/qiyeFengmian9.jpg','联系人9','19819881119','企业地址9'),(60,'2024-11-12 12:04:22','企业账号10','123456','企业名称10','file/qiyeFengmian10.jpg','联系人10','198198811110','企业地址10');
/*!40000 ALTER TABLE `qiye` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shenqingruzhu`
--

DROP TABLE IF EXISTS `shenqingruzhu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `shenqingruzhu` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `yizhanmingcheng` varchar(200) NOT NULL COMMENT '驿站名称',
  `mendiantu` longtext COMMENT '门店图',
  `ruzhuxiangqing` varchar(200) DEFAULT NULL COMMENT '入住详情',
  `ruzhushijian` datetime DEFAULT NULL COMMENT '入住时间',
  `likaishijian` datetime DEFAULT NULL COMMENT '预计离开时间',
  `zhengjian` longtext COMMENT '证件',
  `gerenjianjie` longtext COMMENT '个人简介',
  `zhanghao` varchar(200) DEFAULT NULL COMMENT '账号',
  `sfsh` varchar(200) DEFAULT '待审核' COMMENT '是否审核',
  `shhf` longtext COMMENT '回复内容',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8 COMMENT='申请入住';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shenqingruzhu`
--

LOCK TABLES `shenqingruzhu` WRITE;
/*!40000 ALTER TABLE `shenqingruzhu` DISABLE KEYS */;
INSERT INTO `shenqingruzhu` VALUES (1,'2024-11-12 12:04:22','驿站名称1','file/shenqingruzhuMendiantu1.jpg,file/shenqingruzhuMendiantu2.jpg,file/shenqingruzhuMendiantu3.jpg','入住详情1','2024-11-12 20:04:22','2024-11-12 20:04:22','file/shenqingruzhuZhengjian1.jpg,file/shenqingruzhuZhengjian2.jpg,file/shenqingruzhuZhengjian3.jpg','个人简介1','账号1','是',''),(2,'2024-11-12 12:04:22','驿站名称2','file/shenqingruzhuMendiantu2.jpg,file/shenqingruzhuMendiantu3.jpg,file/shenqingruzhuMendiantu4.jpg','入住详情2','2024-11-12 20:04:22','2024-11-12 20:04:22','file/shenqingruzhuZhengjian2.jpg,file/shenqingruzhuZhengjian3.jpg,file/shenqingruzhuZhengjian4.jpg','个人简介2','账号2','是',''),(3,'2024-11-12 12:04:22','驿站名称3','file/shenqingruzhuMendiantu3.jpg,file/shenqingruzhuMendiantu4.jpg,file/shenqingruzhuMendiantu5.jpg','入住详情3','2024-11-12 20:04:22','2024-11-12 20:04:22','file/shenqingruzhuZhengjian3.jpg,file/shenqingruzhuZhengjian4.jpg,file/shenqingruzhuZhengjian5.jpg','个人简介3','账号3','是',''),(4,'2024-11-12 12:04:22','驿站名称4','file/shenqingruzhuMendiantu4.jpg,file/shenqingruzhuMendiantu5.jpg,file/shenqingruzhuMendiantu6.jpg','入住详情4','2024-11-12 20:04:22','2024-11-12 20:04:22','file/shenqingruzhuZhengjian4.jpg,file/shenqingruzhuZhengjian5.jpg,file/shenqingruzhuZhengjian6.jpg','个人简介4','账号4','是',''),(5,'2024-11-12 12:04:22','驿站名称5','file/shenqingruzhuMendiantu5.jpg,file/shenqingruzhuMendiantu6.jpg,file/shenqingruzhuMendiantu7.jpg','入住详情5','2024-11-12 20:04:22','2024-11-12 20:04:22','file/shenqingruzhuZhengjian5.jpg,file/shenqingruzhuZhengjian6.jpg,file/shenqingruzhuZhengjian7.jpg','个人简介5','账号5','是',''),(6,'2024-11-12 12:04:22','驿站名称6','file/shenqingruzhuMendiantu6.jpg,file/shenqingruzhuMendiantu7.jpg,file/shenqingruzhuMendiantu8.jpg','入住详情6','2024-11-12 20:04:22','2024-11-12 20:04:22','file/shenqingruzhuZhengjian6.jpg,file/shenqingruzhuZhengjian7.jpg,file/shenqingruzhuZhengjian8.jpg','个人简介6','账号6','是',''),(7,'2024-11-12 12:04:22','驿站名称7','file/shenqingruzhuMendiantu7.jpg,file/shenqingruzhuMendiantu8.jpg,file/shenqingruzhuMendiantu9.jpg','入住详情7','2024-11-12 20:04:22','2024-11-12 20:04:22','file/shenqingruzhuZhengjian7.jpg,file/shenqingruzhuZhengjian8.jpg,file/shenqingruzhuZhengjian9.jpg','个人简介7','账号7','是',''),(8,'2024-11-12 12:04:22','驿站名称8','file/shenqingruzhuMendiantu8.jpg,file/shenqingruzhuMendiantu9.jpg,file/shenqingruzhuMendiantu10.jpg','入住详情8','2024-11-12 20:04:22','2024-11-12 20:04:22','file/shenqingruzhuZhengjian8.jpg,file/shenqingruzhuZhengjian9.jpg,file/shenqingruzhuZhengjian10.jpg','个人简介8','账号8','是',''),(9,'2024-11-12 12:04:22','驿站名称9','file/shenqingruzhuMendiantu9.jpg,file/shenqingruzhuMendiantu10.jpg,file/shenqingruzhuMendiantu11.jpg','入住详情9','2024-11-12 20:04:22','2024-11-12 20:04:22','file/shenqingruzhuZhengjian9.jpg,file/shenqingruzhuZhengjian10.jpg,file/shenqingruzhuZhengjian11.jpg','个人简介9','账号9','是',''),(10,'2024-11-12 12:04:22','驿站名称10','file/shenqingruzhuMendiantu10.jpg,file/shenqingruzhuMendiantu11.jpg,file/shenqingruzhuMendiantu12.jpg','入住详情10','2024-11-12 20:04:22','2024-11-12 20:04:22','file/shenqingruzhuZhengjian10.jpg,file/shenqingruzhuZhengjian11.jpg,file/shenqingruzhuZhengjian12.jpg','个人简介10','账号10','是',''),(11,'2024-11-12 12:10:34','驿站名称1','file/qingnianyizhanMendiantu1.jpg,file/qingnianyizhanMendiantu2.jpg,file/qingnianyizhanMendiantu3.jpg','入住详情1','2024-11-13 00:00:00','2024-11-14 00:00:00','file/1731413422926.jpg','<p><img src=\"http://localhost:8080/cl75385428/file/1731413432581.jpg\" alt=\"\" data-href=\"\" style=\"\"/></p>','账号1','是','1');
/*!40000 ALTER TABLE `shenqingruzhu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `storeup`
--

DROP TABLE IF EXISTS `storeup`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `storeup` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `refid` bigint(20) DEFAULT NULL COMMENT 'refid',
  `tablename` varchar(200) DEFAULT NULL COMMENT '表名',
  `name` varchar(200) NOT NULL COMMENT '名称',
  `picture` longtext NOT NULL COMMENT '图片',
  `type` varchar(200) DEFAULT '1' COMMENT '类型(1:收藏,21:赞,22:踩,31:竞拍参与,41:关注)',
  `inteltype` varchar(200) DEFAULT NULL COMMENT '推荐类型',
  `remark` varchar(200) DEFAULT NULL COMMENT '备注',
  `userid` bigint(20) NOT NULL COMMENT '用户id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='我的收藏';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `storeup`
--

LOCK TABLES `storeup` WRITE;
/*!40000 ALTER TABLE `storeup` DISABLE KEYS */;
/*!40000 ALTER TABLE `storeup` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `token`
--

DROP TABLE IF EXISTS `token`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `token` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `userid` bigint(20) NOT NULL COMMENT '用户id',
  `username` varchar(100) NOT NULL COMMENT '用户名',
  `tablename` varchar(100) DEFAULT NULL COMMENT '表名',
  `role` varchar(100) DEFAULT NULL COMMENT '角色',
  `token` varchar(200) NOT NULL COMMENT '密码',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '新增时间',
  `expiratedtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '过期时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='token表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `token`
--

LOCK TABLES `token` WRITE;
/*!40000 ALTER TABLE `token` DISABLE KEYS */;
INSERT INTO `token` VALUES (1,141,'账号1','yonghu','用户','chubq5gtk81eak1pjygewwk7exj59f49','2024-11-12 12:06:49','2024-11-12 13:06:50'),(2,1,'admin','users','管理员','q5vafhxt4dt7gnkb9zmxnhbjlr0w0s1r','2024-11-12 12:06:56','2024-11-12 13:06:56'),(3,51,'企业账号1','qiye','企业','zx4kvg9uyf5z7vdptskinmpn8h5u4i2h','2024-11-12 12:12:46','2024-11-12 13:12:46');
/*!40000 ALTER TABLE `token` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `users` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `username` varchar(200) NOT NULL COMMENT '用户名',
  `password` varchar(200) NOT NULL COMMENT '密码',
  `role` varchar(200) DEFAULT '管理员' COMMENT '角色',
  `tupian` longtext COMMENT '图片',
  PRIMARY KEY (`id`),
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='管理员';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'2024-11-12 12:04:22','admin','admin','管理员','file/1731413510447.jpeg');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `yonghu`
--

DROP TABLE IF EXISTS `yonghu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `yonghu` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `zhanghao` varchar(200) NOT NULL COMMENT '账号',
  `touxiang` longtext COMMENT '头像',
  `mima` varchar(200) NOT NULL COMMENT '密码',
  `xingming` varchar(200) DEFAULT NULL COMMENT '姓名',
  `xingbie` varchar(200) DEFAULT NULL COMMENT '性别',
  `shenfenzhenghaoma` varchar(200) DEFAULT NULL COMMENT '身份证号码',
  `shoujihaoma` varchar(200) DEFAULT NULL COMMENT '手机号码',
  `nianling` varchar(200) DEFAULT NULL COMMENT '年龄',
  `pquestion` varchar(200) DEFAULT NULL COMMENT '密保问题',
  `panswer` varchar(200) DEFAULT NULL COMMENT '密保答案',
  PRIMARY KEY (`id`),
  UNIQUE KEY `zhanghao` (`zhanghao`)
) ENGINE=InnoDB AUTO_INCREMENT=151 DEFAULT CHARSET=utf8 COMMENT='用户';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `yonghu`
--

LOCK TABLES `yonghu` WRITE;
/*!40000 ALTER TABLE `yonghu` DISABLE KEYS */;
INSERT INTO `yonghu` VALUES (141,'2024-11-12 12:04:22','账号1','file/1731413389252.jpg','123456','姓名1','男','441622200101010001','19819881111','年龄1','密保问题1','密保答案1'),(142,'2024-11-12 12:04:22','账号2','file/yonghuTouxiang2.jpg','123456','姓名2','男','441622200202020002','19819881112','年龄2','密保问题2','密保答案2'),(143,'2024-11-12 12:04:22','账号3','file/yonghuTouxiang3.jpg','123456','姓名3','男','441622200303030003','19819881113','年龄3','密保问题3','密保答案3'),(144,'2024-11-12 12:04:22','账号4','file/yonghuTouxiang4.jpg','123456','姓名4','男','441622200404040004','19819881114','年龄4','密保问题4','密保答案4'),(145,'2024-11-12 12:04:22','账号5','file/yonghuTouxiang5.jpg','123456','姓名5','男','441622200505050005','19819881115','年龄5','密保问题5','密保答案5'),(146,'2024-11-12 12:04:22','账号6','file/yonghuTouxiang6.jpg','123456','姓名6','男','441622200606060006','19819881116','年龄6','密保问题6','密保答案6'),(147,'2024-11-12 12:04:22','账号7','file/yonghuTouxiang7.jpg','123456','姓名7','男','441622200707070007','19819881117','年龄7','密保问题7','密保答案7'),(148,'2024-11-12 12:04:22','账号8','file/yonghuTouxiang8.jpg','123456','姓名8','男','441622200808080008','19819881118','年龄8','密保问题8','密保答案8'),(149,'2024-11-12 12:04:22','账号9','file/yonghuTouxiang9.jpg','123456','姓名9','男','441622200909090009','19819881119','年龄9','密保问题9','密保答案9'),(150,'2024-11-12 12:04:22','账号10','file/yonghuTouxiang10.jpg','123456','姓名10','女','441622200100100100','19819881111','年龄10','密保问题10','密保答案10');
/*!40000 ALTER TABLE `yonghu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `zhaopinhuodong`
--

DROP TABLE IF EXISTS `zhaopinhuodong`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `zhaopinhuodong` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `gangweimingcheng` varchar(200) NOT NULL COMMENT '岗位名称',
  `bangonghuanjing` longtext COMMENT '办公环境',
  `zhaopinrenshu` int(11) DEFAULT NULL COMMENT '招聘人数',
  `xueliyaoqiu` varchar(200) DEFAULT NULL COMMENT '学历要求',
  `xinzidaiyu` varchar(200) DEFAULT NULL COMMENT '薪资待遇',
  `gongzuoshijian` varchar(200) DEFAULT NULL COMMENT '工作时间',
  `gangweixiangqing` longtext COMMENT '岗位详情',
  `huodongdidian` varchar(200) DEFAULT NULL COMMENT '活动地点',
  `huodongshijian` datetime DEFAULT NULL COMMENT '活动时间',
  `huodongxiangqing` longtext COMMENT '活动详情',
  `qiyezhanghao` varchar(200) DEFAULT NULL COMMENT '企业账号',
  `qiyemingcheng` varchar(200) DEFAULT NULL COMMENT '企业名称',
  `lianxidianhua` varchar(200) DEFAULT NULL COMMENT '联系电话',
  `qiyedizhi` varchar(200) DEFAULT NULL COMMENT '企业地址',
  `clicktime` datetime DEFAULT NULL COMMENT '最近点击时间',
  `storeup_number` int(11) DEFAULT NULL COMMENT '收藏数',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8 COMMENT='招聘活动';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `zhaopinhuodong`
--

LOCK TABLES `zhaopinhuodong` WRITE;
/*!40000 ALTER TABLE `zhaopinhuodong` DISABLE KEYS */;
INSERT INTO `zhaopinhuodong` VALUES (1,'2024-11-12 12:04:22','岗位名称1','file/zhaopinhuodongBangonghuanjing1.jpg,file/zhaopinhuodongBangonghuanjing2.jpg,file/zhaopinhuodongBangonghuanjing3.jpg',1,'学历要求1','薪资待遇1','工作时间1','岗位详情1','活动地点1','2024-11-12 20:04:22','活动详情1','企业账号1','企业名称1','联系电话1','企业地址1','2024-11-12 20:04:22',1),(2,'2024-11-12 12:04:22','岗位名称2','file/zhaopinhuodongBangonghuanjing2.jpg,file/zhaopinhuodongBangonghuanjing3.jpg,file/zhaopinhuodongBangonghuanjing4.jpg',2,'学历要求2','薪资待遇2','工作时间2','岗位详情2','活动地点2','2024-11-12 20:04:22','活动详情2','企业账号2','企业名称2','联系电话2','企业地址2','2024-11-12 20:04:22',2),(3,'2024-11-12 12:04:22','岗位名称3','file/zhaopinhuodongBangonghuanjing3.jpg,file/zhaopinhuodongBangonghuanjing4.jpg,file/zhaopinhuodongBangonghuanjing5.jpg',3,'学历要求3','薪资待遇3','工作时间3','岗位详情3','活动地点3','2024-11-12 20:04:22','活动详情3','企业账号3','企业名称3','联系电话3','企业地址3','2024-11-12 20:04:22',3),(4,'2024-11-12 12:04:22','岗位名称4','file/zhaopinhuodongBangonghuanjing4.jpg,file/zhaopinhuodongBangonghuanjing5.jpg,file/zhaopinhuodongBangonghuanjing6.jpg',4,'学历要求4','薪资待遇4','工作时间4','岗位详情4','活动地点4','2024-11-12 20:04:22','活动详情4','企业账号4','企业名称4','联系电话4','企业地址4','2024-11-12 20:04:22',4),(5,'2024-11-12 12:04:22','岗位名称5','file/zhaopinhuodongBangonghuanjing5.jpg,file/zhaopinhuodongBangonghuanjing6.jpg,file/zhaopinhuodongBangonghuanjing7.jpg',5,'学历要求5','薪资待遇5','工作时间5','岗位详情5','活动地点5','2024-11-12 20:04:22','活动详情5','企业账号5','企业名称5','联系电话5','企业地址5','2024-11-12 20:04:22',5),(6,'2024-11-12 12:04:22','岗位名称6','file/zhaopinhuodongBangonghuanjing6.jpg,file/zhaopinhuodongBangonghuanjing7.jpg,file/zhaopinhuodongBangonghuanjing8.jpg',6,'学历要求6','薪资待遇6','工作时间6','岗位详情6','活动地点6','2024-11-12 20:04:22','活动详情6','企业账号6','企业名称6','联系电话6','企业地址6','2024-11-12 20:04:22',6),(7,'2024-11-12 12:04:22','岗位名称7','file/zhaopinhuodongBangonghuanjing7.jpg,file/zhaopinhuodongBangonghuanjing8.jpg,file/zhaopinhuodongBangonghuanjing9.jpg',7,'学历要求7','薪资待遇7','工作时间7','岗位详情7','活动地点7','2024-11-12 20:04:22','活动详情7','企业账号7','企业名称7','联系电话7','企业地址7','2024-11-12 20:04:22',7),(8,'2024-11-12 12:04:22','岗位名称8','file/zhaopinhuodongBangonghuanjing8.jpg,file/zhaopinhuodongBangonghuanjing9.jpg,file/zhaopinhuodongBangonghuanjing10.jpg',8,'学历要求8','薪资待遇8','工作时间8','岗位详情8','活动地点8','2024-11-12 20:04:22','活动详情8','企业账号8','企业名称8','联系电话8','企业地址8','2024-11-12 20:04:22',8),(9,'2024-11-12 12:04:22','岗位名称9','file/zhaopinhuodongBangonghuanjing9.jpg,file/zhaopinhuodongBangonghuanjing10.jpg,file/zhaopinhuodongBangonghuanjing11.jpg',9,'学历要求9','薪资待遇9','工作时间9','岗位详情9','活动地点9','2024-11-12 20:04:22','活动详情9','企业账号9','企业名称9','联系电话9','企业地址9','2024-11-12 20:04:22',9),(10,'2024-11-12 12:04:22','岗位名称10','file/zhaopinhuodongBangonghuanjing10.jpg,file/zhaopinhuodongBangonghuanjing11.jpg,file/zhaopinhuodongBangonghuanjing12.jpg',10,'学历要求10','薪资待遇10','工作时间10','岗位详情10','活动地点10','2024-11-12 20:04:22','活动详情10','企业账号10','企业名称10','联系电话10','企业地址10','2024-11-12 20:04:22',10),(11,'2024-11-12 12:13:20','12','',50,'1','1','1','<p>123</p>','1','2024-11-13 00:00:00','<p>123</p>','企业账号1','企业名称1','19819881111','企业地址1','2024-11-12 20:13:33',NULL);
/*!40000 ALTER TABLE `zhaopinhuodong` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-11-13 14:20:16
