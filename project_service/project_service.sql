CREATE DATABASE IF NOT EXISTS `project_service` default charset utf8 COLLATE utf8_general_ci;

USE `project_service`;
drop TABLE if EXISTS `admin`;
CREATE TABLE IF NOT EXISTS `admin` (
 `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
 `login_name` varchar(255) DEFAULT NULL COMMENT '登录名',
 `password` varchar(255) DEFAULT NULL COMMENT '密码',
  PRIMARY KEY (`id`)
 ) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='管理员';


drop TABLE if EXISTS `user`;
CREATE TABLE IF NOT EXISTS `user` (
 `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
 `login_name` varchar(255) DEFAULT NULL COMMENT '登录名',
 `password` varchar(255) DEFAULT NULL COMMENT '密码',
 `real_name` varchar(255) DEFAULT NULL COMMENT '姓名',
 `cel_phone` varchar(255) DEFAULT NULL COMMENT '联系电话',
 `head_img` varchar(200) DEFAULT NULL COMMENT '头像',
 `sex` int(11) DEFAULT NULL COMMENT '性别',
 `create_time` varchar(30) DEFAULT NULL COMMENT '注册时间',
  PRIMARY KEY (`id`)
 ) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='用户';


drop TABLE if EXISTS `nba_compete`;
CREATE TABLE IF NOT EXISTS `nba_compete` (
 `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
 `bs_name` varchar(255) DEFAULT NULL COMMENT '比赛名',
 `fm_img` varchar(200) DEFAULT NULL COMMENT '封面图',
 `score_intro` varchar(255) DEFAULT NULL COMMENT '比分',
 `bs_intro` text  COLLATE utf8_bin DEFAULT NULL COMMENT '比赛情况',
 `qy_data` text  COLLATE utf8_bin DEFAULT NULL COMMENT '球员数据',
 `create_time` varchar(30) DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
 ) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='NBA比赛';


drop TABLE if EXISTS `nbasc`;
CREATE TABLE IF NOT EXISTS `nbasc` (
 `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
 `dzsf` varchar(255) DEFAULT NULL COMMENT '对阵双方',
 `fm_img` varchar(200) DEFAULT NULL COMMENT '封面图',
 `bsdd` varchar(255) DEFAULT NULL COMMENT '比赛地点',
 `bs_time` varchar(255) DEFAULT NULL COMMENT '比赛时间',
 `fb_time` varchar(30) DEFAULT NULL COMMENT '发布时间',
  PRIMARY KEY (`id`)
 ) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='NBA赛程';


drop TABLE if EXISTS `qysj`;
CREATE TABLE IF NOT EXISTS `qysj` (
 `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
 `qy_name` varchar(255) DEFAULT NULL COMMENT '球员名',
 `qy_intro` varchar(1000) DEFAULT NULL COMMENT '球员介绍',
 `qy_img` varchar(200) DEFAULT NULL COMMENT '照片',
 `qy_score` text  COLLATE utf8_bin DEFAULT NULL COMMENT '球员成绩',
  PRIMARY KEY (`id`)
 ) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='NBA球员';


drop TABLE if EXISTS `grs`;
CREATE TABLE IF NOT EXISTS `grs` (
 `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
 `bs_name` varchar(255) DEFAULT NULL COMMENT '比赛名称',
 `fm_img` varchar(200) DEFAULT NULL COMMENT '封面图',
 `bs_time` varchar(255) DEFAULT NULL COMMENT '比赛时间',
 `address` varchar(255) DEFAULT NULL COMMENT '比赛地点',
 `csdw` text  COLLATE utf8_bin DEFAULT NULL COMMENT '参赛队伍',
 `create_date` varchar(30) DEFAULT NULL COMMENT '创建日期',
  PRIMARY KEY (`id`)
 ) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='个人赛';


drop TABLE if EXISTS `bsjg`;
CREATE TABLE IF NOT EXISTS `bsjg` (
 `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
 `team_name` varchar(255) DEFAULT NULL COMMENT '得分队伍',
 `df_score` int(11) DEFAULT NULL COMMENT '得分分数',
 `dfqy` varchar(255) DEFAULT NULL COMMENT '得分球员',
 `zgqy` varchar(255) DEFAULT NULL COMMENT '助攻球员',
 `grsid` int(11) DEFAULT NULL COMMENT '个人赛ID',
  PRIMARY KEY (`id`)
 ) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='比赛结果';


drop TABLE if EXISTS `team_msg`;
CREATE TABLE IF NOT EXISTS `team_msg` (
 `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
 `dw_name` varchar(255) DEFAULT NULL COMMENT '队伍名',
 `dw_logo` varchar(200) DEFAULT NULL COMMENT '队徽',
 `dw_intro` varchar(1000) DEFAULT NULL COMMENT '队伍介绍',
 `user_id` int(11) DEFAULT NULL COMMENT '用户ID',
  PRIMARY KEY (`id`)
 ) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='参赛队伍';


drop TABLE if EXISTS `bsdt`;
CREATE TABLE IF NOT EXISTS `bsdt` (
 `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
 `title` varchar(255) DEFAULT NULL COMMENT '标题',
 `fm_img` varchar(200) DEFAULT NULL COMMENT '封面图',
 `bs_time` varchar(255) DEFAULT NULL COMMENT '比赛时间',
 `bsdd` varchar(255) DEFAULT NULL COMMENT '比赛地点',
 `bsdw` text  COLLATE utf8_bin DEFAULT NULL COMMENT '比赛队伍',
 `create_date` varchar(30) DEFAULT NULL COMMENT '创建日期',
  PRIMARY KEY (`id`)
 ) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='比赛动态';


drop TABLE if EXISTS `grs_app`;
CREATE TABLE IF NOT EXISTS `grs_app` (
 `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
 `bs_name` varchar(255) DEFAULT NULL COMMENT '比赛名',
 `fm_img` varchar(200) DEFAULT NULL COMMENT '封面图',
 `bs_time` varchar(255) DEFAULT NULL COMMENT '比赛时间',
 `bsdd` varchar(255) DEFAULT NULL COMMENT '比赛地点',
 `bs_intro` text  COLLATE utf8_bin DEFAULT NULL COMMENT '比赛介绍',
 `check_status` int(11) DEFAULT NULL COMMENT '审核状态',
 `check_remark` varchar(255) DEFAULT NULL COMMENT '审核备注',
 `user_id` int(11) DEFAULT NULL COMMENT '用户ID',
 `create_date` varchar(30) DEFAULT NULL COMMENT '创建日期',
  PRIMARY KEY (`id`)
 ) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='个人赛申请';


drop TABLE if EXISTS `grs_dis`;
CREATE TABLE IF NOT EXISTS `grs_dis` (
 `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
 `content` varchar(255) DEFAULT NULL COMMENT '评论内容',
 `uid` int(11) DEFAULT NULL COMMENT '用户ID',
 `grsid` int(11) DEFAULT NULL COMMENT '个人赛ID',
 `create_time` varchar(30) DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
 ) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='个人赛评论';


drop TABLE if EXISTS `mrt`;
CREATE TABLE IF NOT EXISTS `mrt` (
 `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
 `title` varchar(255) DEFAULT NULL COMMENT '标题',
 `fm_img` varchar(200) DEFAULT NULL COMMENT '封面图',
 `detail` text  COLLATE utf8_bin DEFAULT NULL COMMENT '详情',
 `video_url` varchar(200) DEFAULT NULL COMMENT '名人堂视频',
 `create_date` varchar(30) DEFAULT NULL COMMENT '创建日期',
  PRIMARY KEY (`id`)
 ) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='NBA名人堂';


drop TABLE if EXISTS `jd_video`;
CREATE TABLE IF NOT EXISTS `jd_video` (
 `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
 `title` varchar(255) DEFAULT NULL COMMENT '标题',
 `fm_img` varchar(200) DEFAULT NULL COMMENT '封面图',
 `veo_url` varchar(200) DEFAULT NULL COMMENT '视频链接',
 `veo_intro` varchar(1000) DEFAULT NULL COMMENT '视频介绍',
 `user_id` int(11) DEFAULT NULL COMMENT '用户ID',
 `create_date` varchar(30) DEFAULT NULL COMMENT '创建日期',
 `praise_num` int(11) DEFAULT NULL COMMENT '点赞数',
  PRIMARY KEY (`id`)
 ) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='经典视频';


drop TABLE if EXISTS `veo_dis`;
CREATE TABLE IF NOT EXISTS `veo_dis` (
 `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
 `content` varchar(255) DEFAULT NULL COMMENT '评论内容',
 `jid` int(11) DEFAULT NULL COMMENT '视频ID',
 `uid` int(11) DEFAULT NULL COMMENT '用户ID',
 `create_time` varchar(30) DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
 ) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='视频评论';


drop TABLE if EXISTS `praise_log`;
CREATE TABLE IF NOT EXISTS `praise_log` (
 `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
 `uid` int(11) DEFAULT NULL COMMENT '用户ID',
 `jid` int(11) DEFAULT NULL COMMENT '视频ID',
 `create_time` varchar(30) DEFAULT NULL COMMENT '点赞时间',
  PRIMARY KEY (`id`)
 ) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='视频点赞';


drop TABLE if EXISTS `post`;
CREATE TABLE IF NOT EXISTS `post` (
 `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
 `title` varchar(255) DEFAULT NULL COMMENT '标题',
 `post_content` text  COLLATE utf8_bin DEFAULT NULL COMMENT '帖子内容',
 `user_id` int(11) DEFAULT NULL COMMENT '用户ID',
 `create_date` varchar(30) DEFAULT NULL COMMENT '创建日期',
  PRIMARY KEY (`id`)
 ) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='帖子';


drop TABLE if EXISTS `post_dis`;
CREATE TABLE IF NOT EXISTS `post_dis` (
 `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
 `content` varchar(255) DEFAULT NULL COMMENT '评论内容',
 `poid` int(11) DEFAULT NULL COMMENT '帖子ID',
 `uid` int(11) DEFAULT NULL COMMENT '用户ID',
 `create_time` varchar(30) DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
 ) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='帖子评论';


drop TABLE if EXISTS `sx_log`;
CREATE TABLE IF NOT EXISTS `sx_log` (
 `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
 `content` varchar(255) DEFAULT NULL COMMENT '聊天内容',
 `is_read` int(11) DEFAULT NULL COMMENT '是否已读',
 `type` int(11) DEFAULT NULL COMMENT '类型',
 `uid` int(11) DEFAULT NULL COMMENT '用户ID',
 `uid1` int(11) DEFAULT NULL COMMENT '用户ID',
 `create_time` varchar(30) DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
 ) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='私信记录';


drop TABLE if EXISTS `banner`;
CREATE TABLE IF NOT EXISTS `banner` (
 `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
 `banner` varchar(200) DEFAULT NULL COMMENT '轮播图',
  PRIMARY KEY (`id`)
 ) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='轮播图';



INSERT INTO `project_service`.`admin` (`id`,`login_name`,`password`)  VALUES('1','admin','123');
INSERT INTO `project_service`.`admin` (`id`,`login_name`,`password`)  VALUES('2','admin1','123');
INSERT INTO `project_service`.`admin` (`id`,`login_name`,`password`)  VALUES('3','admin2','123');
INSERT INTO `project_service`.`admin` (`id`,`login_name`,`password`)  VALUES('4','admin3','123');
INSERT INTO `project_service`.`admin` (`id`,`login_name`,`password`)  VALUES('5','admin4','123');
INSERT INTO `project_service`.`user` (`id`,`login_name`,`password`,`real_name`,`cel_phone`,`head_img`,`sex`,`create_time`)  VALUES('1','user','123','姓名0','13052653265','http://localhost:8080/project_service/static/images/2/1.jpg','2','2024-04-09 11:11:08');
INSERT INTO `project_service`.`user` (`id`,`login_name`,`password`,`real_name`,`cel_phone`,`head_img`,`sex`,`create_time`)  VALUES('2','user1','123','姓名1','13553613261','http://localhost:8080/project_service/static/images/2/2.jpg','2','2024-04-08 11:11:08');
INSERT INTO `project_service`.`user` (`id`,`login_name`,`password`,`real_name`,`cel_phone`,`head_img`,`sex`,`create_time`)  VALUES('3','user2','123','姓名2','13552623265','http://localhost:8080/project_service/static/images/2/3.jpg','1','2024-04-09 11:11:08');
INSERT INTO `project_service`.`user` (`id`,`login_name`,`password`,`real_name`,`cel_phone`,`head_img`,`sex`,`create_time`)  VALUES('4','user3','123','姓名3','13052623165','http://localhost:8080/project_service/static/images/2/4.jpg','2','2024-04-09 11:11:08');
INSERT INTO `project_service`.`user` (`id`,`login_name`,`password`,`real_name`,`cel_phone`,`head_img`,`sex`,`create_time`)  VALUES('5','user4','123','姓名4','13052633163','http://localhost:8080/project_service/static/images/2/5.jpg','2','2024-04-08 11:11:08');
INSERT INTO `project_service`.`nba_compete` (`id`,`bs_name`,`fm_img`,`score_intro`,`bs_intro`,`qy_data`,`create_time`)  VALUES('1','比赛名0','http://localhost:8080/project_service/static/images/1/1.jpg','比分0','测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试试测试测试测试测试测试测试测试测试测试测试','测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试试测试测试测试测试测试测试测试测试测试测试','2024-04-09 11:11:08');
INSERT INTO `project_service`.`nba_compete` (`id`,`bs_name`,`fm_img`,`score_intro`,`bs_intro`,`qy_data`,`create_time`)  VALUES('2','比赛名1','http://localhost:8080/project_service/static/images/1/2.jpg','比分1','测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试试测试测试测试测试测试测试测试测试测试测试','测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试试测试测试测试测试测试测试测试测试测试测试','2024-04-08 11:11:08');
INSERT INTO `project_service`.`nba_compete` (`id`,`bs_name`,`fm_img`,`score_intro`,`bs_intro`,`qy_data`,`create_time`)  VALUES('3','比赛名2','http://localhost:8080/project_service/static/images/1/3.jpg','比分2','测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试试测试测试测试测试测试测试测试测试测试测试','测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试试测试测试测试测试测试测试测试测试测试测试','2024-04-08 11:11:08');
INSERT INTO `project_service`.`nba_compete` (`id`,`bs_name`,`fm_img`,`score_intro`,`bs_intro`,`qy_data`,`create_time`)  VALUES('4','比赛名3','http://localhost:8080/project_service/static/images/1/4.jpg','比分3','测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试试测试测试测试测试测试测试测试测试测试测试','测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试试测试测试测试测试测试测试测试测试测试测试','2024-04-08 11:11:08');
INSERT INTO `project_service`.`nba_compete` (`id`,`bs_name`,`fm_img`,`score_intro`,`bs_intro`,`qy_data`,`create_time`)  VALUES('5','比赛名4','http://localhost:8080/project_service/static/images/1/5.jpg','比分4','测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试试测试测试测试测试测试测试测试测试测试测试','测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试试测试测试测试测试测试测试测试测试测试测试','2024-04-08 11:11:08');
INSERT INTO `project_service`.`nbasc` (`id`,`dzsf`,`fm_img`,`bsdd`,`bs_time`,`fb_time`)  VALUES('1','对阵双方0','http://localhost:8080/project_service/static/images/1/1.jpg','比赛地点0','比赛时间0','2024-04-08 11:11:08');
INSERT INTO `project_service`.`nbasc` (`id`,`dzsf`,`fm_img`,`bsdd`,`bs_time`,`fb_time`)  VALUES('2','对阵双方1','http://localhost:8080/project_service/static/images/1/2.jpg','比赛地点1','比赛时间1','2024-04-09 11:11:08');
INSERT INTO `project_service`.`nbasc` (`id`,`dzsf`,`fm_img`,`bsdd`,`bs_time`,`fb_time`)  VALUES('3','对阵双方2','http://localhost:8080/project_service/static/images/1/3.jpg','比赛地点2','比赛时间2','2024-04-08 11:11:08');
INSERT INTO `project_service`.`nbasc` (`id`,`dzsf`,`fm_img`,`bsdd`,`bs_time`,`fb_time`)  VALUES('4','对阵双方3','http://localhost:8080/project_service/static/images/1/4.jpg','比赛地点3','比赛时间3','2024-04-09 11:11:08');
INSERT INTO `project_service`.`nbasc` (`id`,`dzsf`,`fm_img`,`bsdd`,`bs_time`,`fb_time`)  VALUES('5','对阵双方4','http://localhost:8080/project_service/static/images/1/5.jpg','比赛地点4','比赛时间4','2024-04-09 11:11:08');
INSERT INTO `project_service`.`qysj` (`id`,`qy_name`,`qy_intro`,`qy_img`,`qy_score`)  VALUES('1','球员名0','球员介绍0','http://localhost:8080/project_service/static/images/1/1.jpg','测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试试测试测试测试测试测试测试测试测试测试测试');
INSERT INTO `project_service`.`qysj` (`id`,`qy_name`,`qy_intro`,`qy_img`,`qy_score`)  VALUES('2','球员名1','球员介绍1','http://localhost:8080/project_service/static/images/1/2.jpg','测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试试测试测试测试测试测试测试测试测试测试测试');
INSERT INTO `project_service`.`qysj` (`id`,`qy_name`,`qy_intro`,`qy_img`,`qy_score`)  VALUES('3','球员名2','球员介绍2','http://localhost:8080/project_service/static/images/1/3.jpg','测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试试测试测试测试测试测试测试测试测试测试测试');
INSERT INTO `project_service`.`qysj` (`id`,`qy_name`,`qy_intro`,`qy_img`,`qy_score`)  VALUES('4','球员名3','球员介绍3','http://localhost:8080/project_service/static/images/1/4.jpg','测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试试测试测试测试测试测试测试测试测试测试测试');
INSERT INTO `project_service`.`qysj` (`id`,`qy_name`,`qy_intro`,`qy_img`,`qy_score`)  VALUES('5','球员名4','球员介绍4','http://localhost:8080/project_service/static/images/1/5.jpg','测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试试测试测试测试测试测试测试测试测试测试测试');
INSERT INTO `project_service`.`grs` (`id`,`bs_name`,`fm_img`,`bs_time`,`address`,`csdw`,`create_date`)  VALUES('1','比赛名称0','http://localhost:8080/project_service/static/images/2/1.jpg','比赛时间0','比赛地点0','测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试试测试测试测试测试测试测试测试测试测试测试','2024-04-08');
INSERT INTO `project_service`.`grs` (`id`,`bs_name`,`fm_img`,`bs_time`,`address`,`csdw`,`create_date`)  VALUES('2','比赛名称1','http://localhost:8080/project_service/static/images/2/2.jpg','比赛时间1','比赛地点1','测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试试测试测试测试测试测试测试测试测试测试测试','2024-04-09');
INSERT INTO `project_service`.`grs` (`id`,`bs_name`,`fm_img`,`bs_time`,`address`,`csdw`,`create_date`)  VALUES('3','比赛名称2','http://localhost:8080/project_service/static/images/2/3.jpg','比赛时间2','比赛地点2','测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试试测试测试测试测试测试测试测试测试测试测试','2024-04-08');
INSERT INTO `project_service`.`grs` (`id`,`bs_name`,`fm_img`,`bs_time`,`address`,`csdw`,`create_date`)  VALUES('4','比赛名称3','http://localhost:8080/project_service/static/images/2/4.jpg','比赛时间3','比赛地点3','测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试试测试测试测试测试测试测试测试测试测试测试','2024-04-08');
INSERT INTO `project_service`.`grs` (`id`,`bs_name`,`fm_img`,`bs_time`,`address`,`csdw`,`create_date`)  VALUES('5','比赛名称4','http://localhost:8080/project_service/static/images/2/5.jpg','比赛时间4','比赛地点4','测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试试测试测试测试测试测试测试测试测试测试测试','2024-04-09');
INSERT INTO `project_service`.`bsjg` (`id`,`team_name`,`df_score`,`dfqy`,`zgqy`,`grsid`)  VALUES('1','得分队伍0','67','得分球员0','助攻球员0','2');
INSERT INTO `project_service`.`bsjg` (`id`,`team_name`,`df_score`,`dfqy`,`zgqy`,`grsid`)  VALUES('2','得分队伍1','94','得分球员1','助攻球员1','2');
INSERT INTO `project_service`.`bsjg` (`id`,`team_name`,`df_score`,`dfqy`,`zgqy`,`grsid`)  VALUES('3','得分队伍2','62','得分球员2','助攻球员2','2');
INSERT INTO `project_service`.`bsjg` (`id`,`team_name`,`df_score`,`dfqy`,`zgqy`,`grsid`)  VALUES('4','得分队伍3','59','得分球员3','助攻球员3','3');
INSERT INTO `project_service`.`bsjg` (`id`,`team_name`,`df_score`,`dfqy`,`zgqy`,`grsid`)  VALUES('5','得分队伍4','59','得分球员4','助攻球员4','3');
INSERT INTO `project_service`.`team_msg` (`id`,`dw_name`,`dw_logo`,`dw_intro`,`user_id`)  VALUES('1','队伍名0','http://localhost:8080/project_service/static/images/1/1.jpg','队伍介绍0','5');
INSERT INTO `project_service`.`team_msg` (`id`,`dw_name`,`dw_logo`,`dw_intro`,`user_id`)  VALUES('2','队伍名1','http://localhost:8080/project_service/static/images/1/2.jpg','队伍介绍1','5');
INSERT INTO `project_service`.`team_msg` (`id`,`dw_name`,`dw_logo`,`dw_intro`,`user_id`)  VALUES('3','队伍名2','http://localhost:8080/project_service/static/images/1/3.jpg','队伍介绍2','5');
INSERT INTO `project_service`.`team_msg` (`id`,`dw_name`,`dw_logo`,`dw_intro`,`user_id`)  VALUES('4','队伍名3','http://localhost:8080/project_service/static/images/1/4.jpg','队伍介绍3','5');
INSERT INTO `project_service`.`team_msg` (`id`,`dw_name`,`dw_logo`,`dw_intro`,`user_id`)  VALUES('5','队伍名4','http://localhost:8080/project_service/static/images/1/5.jpg','队伍介绍4','2');
INSERT INTO `project_service`.`bsdt` (`id`,`title`,`fm_img`,`bs_time`,`bsdd`,`bsdw`,`create_date`)  VALUES('1','标题0','http://localhost:8080/project_service/static/images/1/1.jpg','比赛时间0','比赛地点0','测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试试测试测试测试测试测试测试测试测试测试测试','2024-04-08');
INSERT INTO `project_service`.`bsdt` (`id`,`title`,`fm_img`,`bs_time`,`bsdd`,`bsdw`,`create_date`)  VALUES('2','标题1','http://localhost:8080/project_service/static/images/1/2.jpg','比赛时间1','比赛地点1','测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试试测试测试测试测试测试测试测试测试测试测试','2024-04-09');
INSERT INTO `project_service`.`bsdt` (`id`,`title`,`fm_img`,`bs_time`,`bsdd`,`bsdw`,`create_date`)  VALUES('3','标题2','http://localhost:8080/project_service/static/images/1/3.jpg','比赛时间2','比赛地点2','测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试试测试测试测试测试测试测试测试测试测试测试','2024-04-08');
INSERT INTO `project_service`.`bsdt` (`id`,`title`,`fm_img`,`bs_time`,`bsdd`,`bsdw`,`create_date`)  VALUES('4','标题3','http://localhost:8080/project_service/static/images/1/4.jpg','比赛时间3','比赛地点3','测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试试测试测试测试测试测试测试测试测试测试测试','2024-04-08');
INSERT INTO `project_service`.`bsdt` (`id`,`title`,`fm_img`,`bs_time`,`bsdd`,`bsdw`,`create_date`)  VALUES('5','标题4','http://localhost:8080/project_service/static/images/1/5.jpg','比赛时间4','比赛地点4','测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试试测试测试测试测试测试测试测试测试测试测试','2024-04-08');
INSERT INTO `project_service`.`grs_app` (`id`,`bs_name`,`fm_img`,`bs_time`,`bsdd`,`bs_intro`,`check_status`,`check_remark`,`user_id`,`create_date`)  VALUES('1','比赛名0','http://localhost:8080/project_service/static/images/2/1.jpg','比赛时间0','比赛地点0','测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试试测试测试测试测试测试测试测试测试测试测试','3','审核备注0','4','2024-04-09');
INSERT INTO `project_service`.`grs_app` (`id`,`bs_name`,`fm_img`,`bs_time`,`bsdd`,`bs_intro`,`check_status`,`check_remark`,`user_id`,`create_date`)  VALUES('2','比赛名1','http://localhost:8080/project_service/static/images/2/2.jpg','比赛时间1','比赛地点1','测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试试测试测试测试测试测试测试测试测试测试测试','2','审核备注1','1','2024-04-08');
INSERT INTO `project_service`.`grs_app` (`id`,`bs_name`,`fm_img`,`bs_time`,`bsdd`,`bs_intro`,`check_status`,`check_remark`,`user_id`,`create_date`)  VALUES('3','比赛名2','http://localhost:8080/project_service/static/images/2/3.jpg','比赛时间2','比赛地点2','测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试试测试测试测试测试测试测试测试测试测试测试','3','审核备注2','5','2024-04-09');
INSERT INTO `project_service`.`grs_app` (`id`,`bs_name`,`fm_img`,`bs_time`,`bsdd`,`bs_intro`,`check_status`,`check_remark`,`user_id`,`create_date`)  VALUES('4','比赛名3','http://localhost:8080/project_service/static/images/2/4.jpg','比赛时间3','比赛地点3','测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试试测试测试测试测试测试测试测试测试测试测试','3','审核备注3','5','2024-04-08');
INSERT INTO `project_service`.`grs_app` (`id`,`bs_name`,`fm_img`,`bs_time`,`bsdd`,`bs_intro`,`check_status`,`check_remark`,`user_id`,`create_date`)  VALUES('5','比赛名4','http://localhost:8080/project_service/static/images/2/5.jpg','比赛时间4','比赛地点4','测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试试测试测试测试测试测试测试测试测试测试测试','3','审核备注4','1','2024-04-09');
INSERT INTO `project_service`.`grs_dis` (`id`,`content`,`uid`,`grsid`,`create_time`)  VALUES('1','评论内容0','4','5','2024-04-08 11:11:08');
INSERT INTO `project_service`.`grs_dis` (`id`,`content`,`uid`,`grsid`,`create_time`)  VALUES('2','评论内容1','2','1','2024-04-08 11:11:08');
INSERT INTO `project_service`.`grs_dis` (`id`,`content`,`uid`,`grsid`,`create_time`)  VALUES('3','评论内容2','2','4','2024-04-08 11:11:08');
INSERT INTO `project_service`.`grs_dis` (`id`,`content`,`uid`,`grsid`,`create_time`)  VALUES('4','评论内容3','5','1','2024-04-08 11:11:08');
INSERT INTO `project_service`.`grs_dis` (`id`,`content`,`uid`,`grsid`,`create_time`)  VALUES('5','评论内容4','3','3','2024-04-09 11:11:08');
INSERT INTO `project_service`.`mrt` (`id`,`title`,`fm_img`,`detail`,`video_url`,`create_date`)  VALUES('1','标题0','http://localhost:8080/project_service/static/images/2/1.jpg','测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试试测试测试测试测试测试测试测试测试测试测试','http://localhost:8080/project_service/static/sources/2-1.mp4','2024-04-08');
INSERT INTO `project_service`.`mrt` (`id`,`title`,`fm_img`,`detail`,`video_url`,`create_date`)  VALUES('2','标题1','http://localhost:8080/project_service/static/images/2/2.jpg','测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试试测试测试测试测试测试测试测试测试测试测试','http://localhost:8080/project_service/static/sources/2-1.mp4','2024-04-08');
INSERT INTO `project_service`.`mrt` (`id`,`title`,`fm_img`,`detail`,`video_url`,`create_date`)  VALUES('3','标题2','http://localhost:8080/project_service/static/images/2/3.jpg','测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试试测试测试测试测试测试测试测试测试测试测试','http://localhost:8080/project_service/static/sources/2-1.mp4','2024-04-08');
INSERT INTO `project_service`.`mrt` (`id`,`title`,`fm_img`,`detail`,`video_url`,`create_date`)  VALUES('4','标题3','http://localhost:8080/project_service/static/images/2/4.jpg','测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试试测试测试测试测试测试测试测试测试测试测试','http://localhost:8080/project_service/static/sources/2-1.mp4','2024-04-09');
INSERT INTO `project_service`.`mrt` (`id`,`title`,`fm_img`,`detail`,`video_url`,`create_date`)  VALUES('5','标题4','http://localhost:8080/project_service/static/images/2/5.jpg','测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试试测试测试测试测试测试测试测试测试测试测试','http://localhost:8080/project_service/static/sources/2-1.mp4','2024-04-08');
INSERT INTO `project_service`.`jd_video` (`id`,`title`,`fm_img`,`veo_url`,`veo_intro`,`user_id`,`create_date`,`praise_num`)  VALUES('1','标题0','http://localhost:8080/project_service/static/images/1/1.jpg','http://localhost:8080/project_service/static/sources/2-1.mp4','视频介绍0','3','2024-04-09','0');
INSERT INTO `project_service`.`jd_video` (`id`,`title`,`fm_img`,`veo_url`,`veo_intro`,`user_id`,`create_date`,`praise_num`)  VALUES('2','标题1','http://localhost:8080/project_service/static/images/1/2.jpg','http://localhost:8080/project_service/static/sources/2-1.mp4','视频介绍1','3','2024-04-09','0');
INSERT INTO `project_service`.`jd_video` (`id`,`title`,`fm_img`,`veo_url`,`veo_intro`,`user_id`,`create_date`,`praise_num`)  VALUES('3','标题2','http://localhost:8080/project_service/static/images/1/3.jpg','http://localhost:8080/project_service/static/sources/2-1.mp4','视频介绍2','1','2024-04-09','0');
INSERT INTO `project_service`.`jd_video` (`id`,`title`,`fm_img`,`veo_url`,`veo_intro`,`user_id`,`create_date`,`praise_num`)  VALUES('4','标题3','http://localhost:8080/project_service/static/images/1/4.jpg','http://localhost:8080/project_service/static/sources/2-1.mp4','视频介绍3','3','2024-04-08','0');
INSERT INTO `project_service`.`jd_video` (`id`,`title`,`fm_img`,`veo_url`,`veo_intro`,`user_id`,`create_date`,`praise_num`)  VALUES('5','标题4','http://localhost:8080/project_service/static/images/1/5.jpg','http://localhost:8080/project_service/static/sources/2-1.mp4','视频介绍4','5','2024-04-08','0');
INSERT INTO `project_service`.`veo_dis` (`id`,`content`,`jid`,`uid`,`create_time`)  VALUES('1','评论内容0','2','4','2024-04-08 11:11:08');
INSERT INTO `project_service`.`veo_dis` (`id`,`content`,`jid`,`uid`,`create_time`)  VALUES('2','评论内容1','4','2','2024-04-09 11:11:08');
INSERT INTO `project_service`.`veo_dis` (`id`,`content`,`jid`,`uid`,`create_time`)  VALUES('3','评论内容2','5','1','2024-04-09 11:11:08');
INSERT INTO `project_service`.`veo_dis` (`id`,`content`,`jid`,`uid`,`create_time`)  VALUES('4','评论内容3','1','5','2024-04-09 11:11:08');
INSERT INTO `project_service`.`veo_dis` (`id`,`content`,`jid`,`uid`,`create_time`)  VALUES('5','评论内容4','5','1','2024-04-09 11:11:08');
INSERT INTO `project_service`.`praise_log` (`id`,`uid`,`jid`,`create_time`)  VALUES('1','4','5','2024-04-09 11:11:08');
INSERT INTO `project_service`.`praise_log` (`id`,`uid`,`jid`,`create_time`)  VALUES('2','2','4','2024-04-09 11:11:08');
INSERT INTO `project_service`.`praise_log` (`id`,`uid`,`jid`,`create_time`)  VALUES('3','4','4','2024-04-09 11:11:08');
INSERT INTO `project_service`.`praise_log` (`id`,`uid`,`jid`,`create_time`)  VALUES('4','2','4','2024-04-08 11:11:08');
INSERT INTO `project_service`.`praise_log` (`id`,`uid`,`jid`,`create_time`)  VALUES('5','1','5','2024-04-08 11:11:08');
INSERT INTO `project_service`.`post` (`id`,`title`,`post_content`,`user_id`,`create_date`)  VALUES('1','标题0','测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试试测试测试测试测试测试测试测试测试测试测试','1','2024-04-08');
INSERT INTO `project_service`.`post` (`id`,`title`,`post_content`,`user_id`,`create_date`)  VALUES('2','标题1','测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试试测试测试测试测试测试测试测试测试测试测试','5','2024-04-09');
INSERT INTO `project_service`.`post` (`id`,`title`,`post_content`,`user_id`,`create_date`)  VALUES('3','标题2','测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试试测试测试测试测试测试测试测试测试测试测试','3','2024-04-08');
INSERT INTO `project_service`.`post` (`id`,`title`,`post_content`,`user_id`,`create_date`)  VALUES('4','标题3','测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试试测试测试测试测试测试测试测试测试测试测试','4','2024-04-09');
INSERT INTO `project_service`.`post` (`id`,`title`,`post_content`,`user_id`,`create_date`)  VALUES('5','标题4','测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试试测试测试测试测试测试测试测试测试测试测试','2','2024-04-08');
INSERT INTO `project_service`.`post_dis` (`id`,`content`,`poid`,`uid`,`create_time`)  VALUES('1','评论内容0','4','3','2024-04-09 11:11:08');
INSERT INTO `project_service`.`post_dis` (`id`,`content`,`poid`,`uid`,`create_time`)  VALUES('2','评论内容1','5','3','2024-04-08 11:11:08');
INSERT INTO `project_service`.`post_dis` (`id`,`content`,`poid`,`uid`,`create_time`)  VALUES('3','评论内容2','4','5','2024-04-08 11:11:08');
INSERT INTO `project_service`.`post_dis` (`id`,`content`,`poid`,`uid`,`create_time`)  VALUES('4','评论内容3','4','1','2024-04-08 11:11:08');
INSERT INTO `project_service`.`post_dis` (`id`,`content`,`poid`,`uid`,`create_time`)  VALUES('5','评论内容4','3','2','2024-04-09 11:11:08');
INSERT INTO `project_service`.`sx_log` (`id`,`content`,`is_read`,`type`,`uid`,`uid1`,`create_time`)  VALUES('1','聊天内容0','2','2','2','1','2024-04-08 11:11:08');
INSERT INTO `project_service`.`sx_log` (`id`,`content`,`is_read`,`type`,`uid`,`uid1`,`create_time`)  VALUES('2','聊天内容1','2','2','1','5','2024-04-08 11:11:08');
INSERT INTO `project_service`.`sx_log` (`id`,`content`,`is_read`,`type`,`uid`,`uid1`,`create_time`)  VALUES('3','聊天内容2','1','1','5','5','2024-04-08 11:11:08');
INSERT INTO `project_service`.`sx_log` (`id`,`content`,`is_read`,`type`,`uid`,`uid1`,`create_time`)  VALUES('4','聊天内容3','1','1','5','3','2024-04-09 11:11:08');
INSERT INTO `project_service`.`sx_log` (`id`,`content`,`is_read`,`type`,`uid`,`uid1`,`create_time`)  VALUES('5','聊天内容4','2','1','5','5','2024-04-08 11:11:08');
INSERT INTO `project_service`.`banner` (`id`,`banner`)  VALUES('1','http://localhost:8080/project_service/static/images/3/2.jpg');
INSERT INTO `project_service`.`banner` (`id`,`banner`)  VALUES('2','http://localhost:8080/project_service/static/images/3/3.jpg');
INSERT INTO `project_service`.`banner` (`id`,`banner`)  VALUES('3','http://localhost:8080/project_service/static/images/3/4.jpg');
INSERT INTO `project_service`.`banner` (`id`,`banner`)  VALUES('4','http://localhost:8080/project_service/static/images/3/5.jpg');
INSERT INTO `project_service`.`banner` (`id`,`banner`)  VALUES('5','http://localhost:8080/project_service/static/images/3/6.jpg');