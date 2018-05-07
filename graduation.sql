/*
 Navicat MySQL Data Transfer

 Source Server         : mysql
 Source Server Type    : MySQL
 Source Server Version : 50718
 Source Host           : localhost
 Source Database       : graduation

 Target Server Type    : MySQL
 Target Server Version : 50718
 File Encoding         : utf-8

 Date: 05/06/2018 15:31:36 PM
*/

SET NAMES utf8;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `article`
-- ----------------------------
DROP TABLE IF EXISTS `article`;
CREATE TABLE `article` (
  `art_id` int(11) NOT NULL AUTO_INCREMENT,
  `art_title` varchar(100) NOT NULL,
  `art_content` text,
  `art_time` varchar(100) DEFAULT NULL,
  `person_id` int(11) DEFAULT NULL,
  `art_img` varchar(100) DEFAULT NULL,
  `art_person_name` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`art_id`),
  KEY `article_person_id_fk` (`person_id`),
  CONSTRAINT `article_person_id_fk` FOREIGN KEY (`person_id`) REFERENCES `person` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `article`
-- ----------------------------
BEGIN;
INSERT INTO `article` VALUES ('18', '时代的篇章', '“历史和人民选择马克思主义是完全正确的，中国共产党把马克思主义写在自己的旗帜上是完全正确的，坚持马克思主义基本原理同中国具体实际相结合、不断推进马克思主义中国化时代化是完全正确的！”', '2018/05/06 11:40', '7', '1525578021162.jpg', 'Nagisa'), ('26', '百年大潮，风起云涌', '历史长河奔流不息，真理之光穿越时空。1818年5月5日，德国小城特里尔，一代伟人马克思诞生。200年后，世界东方。高擎马克思主义的精神火炬，在习近平新时代中国特色社会主义思想指引下，中国共产党正领导亿万人民书写人类发展史上新的奇迹。这是2018年5月3日在德国特里尔市立西麦翁博物馆拍摄的马克思主题展入口', '2018/05/06 14:31', '1', '1525588307359.jpg', 'james'), ('28', '马藏》编纂工程', '批判地继承德国古典哲学、英国古典政治经济学、法国空想社会主义，汲取细胞学说、能量守恒和转化定律、进化论等最新科学成果……马克思主义不仅是千百年来人类优秀思想文化智慧结晶，更是时代发展到一定阶段的必然产物。', '2018/05/06 14:33', '1', '1525588386750.jpg', 'james'), ('29', '第三届全国基础教育信息', '光明网北京5月5日电（傅大利 记者赵清建）3D打印、物联网、虚拟现实、人工智能……5月5日，在第三届全国基础教育信息化应用展示交流活动的开幕现场，各种“黑科技”在教育领域的应用成果组团现身，让参加展览的老师、家长、学生大开眼界、获益匪浅。', '2018/05/06 15:27', '8', '1525591630332.jpg', 'God');
COMMIT;

-- ----------------------------
--  Table structure for `comment`
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment` (
  `comm_id` int(11) NOT NULL AUTO_INCREMENT,
  `article_id` int(11) DEFAULT NULL,
  `person_id` int(11) DEFAULT NULL,
  `date` varchar(100) DEFAULT NULL,
  `comm_name` varchar(100) DEFAULT NULL,
  `person_name` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`comm_id`),
  KEY `comment_person` (`person_id`),
  KEY `comment_article` (`article_id`),
  CONSTRAINT `comment_article` FOREIGN KEY (`article_id`) REFERENCES `article` (`art_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `comment_person` FOREIGN KEY (`person_id`) REFERENCES `person` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=42 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `comment`
-- ----------------------------
BEGIN;
INSERT INTO `comment` VALUES ('35', '18', '1', '05/06 12:05', '太厉害了!', 'james'), ('36', '18', '1', '05/06 12:05', '真棒!', 'james'), ('39', '28', '1', '05/06 14:33', '可以!', 'james'), ('40', '28', '7', '05/06 14:42', '厉害了!', 'Nagisa'), ('41', '18', '8', '05/06 15:26', '可以!', 'God');
COMMIT;

-- ----------------------------
--  Table structure for `likes`
-- ----------------------------
DROP TABLE IF EXISTS `likes`;
CREATE TABLE `likes` (
  `likes_id` int(11) NOT NULL AUTO_INCREMENT,
  `li_per_id` int(11) DEFAULT NULL,
  `li_art_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`likes_id`),
  KEY `likes_article_art_id_fk` (`li_art_id`),
  KEY `likes_person_id_fk` (`li_per_id`),
  CONSTRAINT `likes_article_art_id_fk` FOREIGN KEY (`li_art_id`) REFERENCES `article` (`art_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `likes_person_id_fk` FOREIGN KEY (`li_per_id`) REFERENCES `person` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `likes`
-- ----------------------------
BEGIN;
INSERT INTO `likes` VALUES ('5', '1', '26'), ('6', '1', '18'), ('7', '7', '18');
COMMIT;

-- ----------------------------
--  Table structure for `person`
-- ----------------------------
DROP TABLE IF EXISTS `person`;
CREATE TABLE `person` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `sex` varchar(10) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `headimg` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `person`
-- ----------------------------
BEGIN;
INSERT INTO `person` VALUES ('1', 'james', '123', '男', 'james@qq.com', '1525576300263.jpg'), ('5', 'Timi', '123', '男', 'Tom@qq.com', null), ('6', 'miku', '12345', '男', 'miku@qq.com', null), ('7', 'Nagisa', '123', '女', 'Nagisa@qq.com', ''), ('8', 'God', '123', '女', 'god@qq.com', null);
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
