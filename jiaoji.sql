-- MySQL dump 10.13  Distrib 8.0.32, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: jiaoji
-- ------------------------------------------------------
-- Server version	8.0.32

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `activity_details`
--

DROP TABLE IF EXISTS `activity_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `activity_details` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `content` varchar(255) DEFAULT NULL,
  `location` varchar(255) DEFAULT NULL,
  `signupTime` varchar(255) DEFAULT NULL,
  `activityTime` varchar(255) DEFAULT NULL,
  `departments` varchar(255) DEFAULT NULL,
  `signupRestriction` varchar(255) DEFAULT NULL,
  `college` varchar(255) DEFAULT NULL,
  `grade` int DEFAULT NULL,
  `club` varchar(255) DEFAULT NULL,
  `recruitmentNumber` int DEFAULT NULL,
  `remainingNumber` int DEFAULT NULL,
  `organizer` varchar(255) DEFAULT NULL,
  `suScore` int DEFAULT NULL,
  `laborHour` int DEFAULT NULL,
  `status` int DEFAULT NULL,
  `comments` varchar(255) DEFAULT NULL,
  `photo` varchar(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `activity_details`
--

LOCK TABLES `activity_details` WRITE;
/*!40000 ALTER TABLE `activity_details` DISABLE KEYS */;
INSERT INTO `activity_details` VALUES (1,'迎新晚会','欢迎新生入学的庆祝活动，有丰富的文艺表演和抽奖环节。','学校体育馆','2023年8月1日 - 2023年8月20日','2023-05-01','软件学院','{\"College\": [\"软件学院\"], \"Grade\": [], \"Club\": []}','软件学院',-1,NULL,100,100,'学生会',3,0,3,'无','https://images.osogoo.com/article/a7f541f6d15f90ca40/201905181359199419.jpg?x-oss-process=style/wate_design','1,5,9'),(2,'社团招新','学校社团招新活动，欢迎新生加入各种社团组织。','学校各社团活动场地','2023年8月30日 - 2023年9月10日','2023-05-08','社联','{\"College\": [], \"Grade\": [], \"Club\": []}',NULL,-1,NULL,1000,1000,'学生会',2,0,3,'无',NULL,'1,8,5'),(3,'国庆主题活动','庆祝国庆节的主题活动，有表演、比赛、摊位等多种形式。','学校操场','2023年9月30日 - 2023年10月1日','2023-09-28','校级','{\"College\": [], \"Grade\": [], \"Club\": []}',NULL,-1,NULL,500,500,'学生会',2,0,3,'无',NULL,'3,5'),(4,'英语角','提供英语学习和交流平台，有外教参与。','学校英语角','每周五下午3:00 - 5:00','2023-05-27','外国语学院','{\"College\": [\"外国语学院\"], \"Grade\": [], \"Club\": []}','外国语学院',-1,NULL,50,50,'外国语学院',3,0,3,'无',NULL,'4,1'),(5,'拔河比赛','学院之间的拔河比赛，展现学院实力。','学校操场','2023年10月15日','2023-10-10','校级','{\"College\": [], \"Grade\": [\"大二\"], \"Club\": []}',NULL,2,NULL,10,10,'体育学院',10,1,3,'无','https://img.pconline.com.cn/images/upload/upc/tx/photoblog/1811/25/c2/120888130_1543109554970_mthumb.jpg','2,9'),(6,'志愿者招募','招募各类志愿者参与学校各项活动。','胡法光体育场','2023年9月30日 - 2023年10月1日','2023-10-03','校级','{\"College\": [], \"Grade\": [], \"Club\": []}',NULL,-1,NULL,100,100,'学生会',8,3,3,'无',NULL,'7,6'),(7,'运动会','全校师生参与的体育比赛，包括各项田径、球类比赛。','学校体育场','2023年11月1日 - 2023年11月5日','2023-10-25','体育学院','{\"College\": [], \"Grade\": [], \"Club\": []}',NULL,-1,NULL,200,200,'体育学院学生会',4,2,3,'无',NULL,'5,4,9'),(8,'春游活动','学校举办的春季郊游活动，与同学们一起享受春天的美好。','郊外风景区','2023年3月15日 - 2023年3月25日','2023-04-01','校级','{\"College\": [], \"Grade\": [], \"Club\": []}',NULL,-1,NULL,200,200,'学生会',3,0,0,'123',NULL,'4,6,7'),(9,'辩论赛','各个学院之间的辩论比赛，展示辩论技巧和知识水平。','学校演讲厅','2023年5月1日 - 2023年5月5日','2023-04-28','校级','{\"College\": [], \"Grade\": [], \"Club\": []}',NULL,-1,NULL,50,50,'学生会',5,2,2,'无',NULL,'2,7,8'),(10,'艺术展览','学校举办的艺术作品展览，展示学生的艺术才华。','学校艺术展览馆','2023年6月1日 - 2023年6月10日','2023-05-30','校级','{\"College\": [\"电子信息与电气工程学院\"], \"Grade\": [], \"Club\": []}','电子信息与电气工程学院',-1,NULL,100,100,'学生会',2,0,3,'无','https://img.zcool.cn/community/010ead5d2d9509a80120b5ab96ce78.jpg@3000w_1l_2o_100sh.jpg','6,9,4'),(11,'救命','救命','救命','救命','救命','上海交通大学','救命','救命',4,'救命',5,5,'救命',1,1,3,'123456','https://th.bing.com/th/id/R.785580b0aa9cce1c7e016db5ee2e078e?rik=ebpuQj03uKxGQg&riu=http%3a%2f%2fphotos.tuchong.com%2f255820%2ff%2f2852945.jpg&ehk=8sZ0LLnnaIXhdwT1M5Zk2xrfIMFcE%2bV45Nc1839Gj7Y%3d&risl=&pid=ImgRaw&r=0',NULL),(12,'123','123','123','123','123','123','123','123',1,'123',5,5,'123',4,1,3,'123','https://th.bing.com/th/id/R.785580b0aa9cce1c7e016db5ee2e078e?rik=ebpuQj03uKxGQg&riu=http%3a%2f%2fphotos.tuchong.com%2f255820%2ff%2f2852945.jpg&ehk=8sZ0LLnnaIXhdwT1M5Zk2xrfIMFcE%2bV45Nc1839Gj7Y%3d&risl=&pid=ImgRaw&r=0',NULL),(13,'毕业典礼','一起毕业','菁菁堂','2025','2025','上海交通大学',NULL,'软件工程',2,NULL,5,5,'qyl',1,1,3,NULL,'https://th.bing.com/th/id/R.785580b0aa9cce1c7e016db5ee2e078e?rik=ebpuQj03uKxGQg&riu=http%3a%2f%2fphotos.tuchong.com%2f255820%2ff%2f2852945.jpg&ehk=8sZ0LLnnaIXhdwT1M5Zk2xrfIMFcE%2bV45Nc1839Gj7Y%3d&risl=&pid=ImgRaw&r=0',NULL);
/*!40000 ALTER TABLE `activity_details` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `activity_release`
--

DROP TABLE IF EXISTS `activity_release`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `activity_release` (
  `user_id` int DEFAULT NULL,
  `act_id` int DEFAULT NULL,
  `serial` int NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`serial`),
  KEY `fk_release1` (`user_id`),
  KEY `fk_release2` (`act_id`),
  CONSTRAINT `fk_release1` FOREIGN KEY (`user_id`) REFERENCES `userauth` (`user_id`),
  CONSTRAINT `fk_release2` FOREIGN KEY (`act_id`) REFERENCES `activity_details` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `activity_release`
--

LOCK TABLES `activity_release` WRITE;
/*!40000 ALTER TABLE `activity_release` DISABLE KEYS */;
INSERT INTO `activity_release` VALUES (0,7,1),(0,11,4),(0,12,5),(0,13,6);
/*!40000 ALTER TABLE `activity_release` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `activity_signup`
--

DROP TABLE IF EXISTS `activity_signup`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `activity_signup` (
  `user_id` int DEFAULT NULL,
  `act_id` int DEFAULT NULL,
  `state` int DEFAULT NULL,
  `comment` int DEFAULT NULL,
  `comment_detail` text,
  `comment_photo` text,
  `posted` int DEFAULT NULL,
  `post_time` text,
  `serial` int NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`serial`),
  KEY `fk_signup1` (`user_id`),
  KEY `fk_signup2` (`act_id`),
  CONSTRAINT `fk_signup1` FOREIGN KEY (`user_id`) REFERENCES `userauth` (`user_id`),
  CONSTRAINT `fk_signup2` FOREIGN KEY (`act_id`) REFERENCES `activity_details` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `activity_signup`
--

LOCK TABLES `activity_signup` WRITE;
/*!40000 ALTER TABLE `activity_signup` DISABLE KEYS */;
INSERT INTO `activity_signup` VALUES (0,2,1,2,'还可以吧','https://s1.ax1x.com/2023/05/01/p9GKNuj.jpg',1,'2023-5-17 20:16:45',1),(0,1,2,2,NULL,'https://s1.ax1x.com/2023/05/01/p9Gu41g.jpg',1,'2023-5-20 20:16:45',2),(0,4,3,-1,NULL,NULL,0,NULL,3),(0,5,5,2,'Not Bad',NULL,0,NULL,4),(0,11,4,3,'耶',NULL,1,'2023-5-18 20:16:45',7),(0,3,0,-1,NULL,NULL,0,NULL,8),(2,4,4,2,'听不懂一点儿',NULL,1,'2023-5-18 20:34:11',9),(2,7,0,-1,NULL,NULL,0,NULL,10),(2,2,0,5,'哈哈哈哈哈哈哈哈哈',NULL,1,NULL,11),(3,2,0,-1,NULL,NULL,0,NULL,13),(3,3,0,-1,NULL,NULL,0,NULL,14);
/*!40000 ALTER TABLE `activity_signup` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `friendship`
--

DROP TABLE IF EXISTS `friendship`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `friendship` (
  `user_a` int NOT NULL,
  `user_b` int NOT NULL,
  `relation` enum('WaitForA','WaitForB','Friend','Delete') DEFAULT NULL,
  PRIMARY KEY (`user_a`,`user_b`),
  KEY `fk2_friendship` (`user_b`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `friendship`
--

LOCK TABLES `friendship` WRITE;
/*!40000 ALTER TABLE `friendship` DISABLE KEYS */;
INSERT INTO `friendship` VALUES (1,2,'Friend');
/*!40000 ALTER TABLE `friendship` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `userId` int NOT NULL AUTO_INCREMENT,
  `nickname` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  `gender` int DEFAULT NULL,
  `tel` varchar(255) DEFAULT NULL,
  `avatar` varchar(255) DEFAULT NULL,
  `college` varchar(255) DEFAULT NULL,
  `studentId` varchar(255) DEFAULT NULL,
  `club` varchar(255) DEFAULT NULL,
  `mail` varchar(255) DEFAULT NULL,
  `grade` int DEFAULT NULL,
  PRIMARY KEY (`userId`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (0,'哈士奇','segui',0,'11111111111','https://img1.baidu.com/it/u=42109136,3593469304&fm=253&fmt=auto&app=138&f=PNG?w=500&h=500','电子信息与电气工程学院','521021000000','电院青志队','hashiqi@sjtu.edu.cn',0),(1,'秋田','root',0,'13178914567','https://www.lizhi.io/wp-content/uploads/2020/03/datagrip.png','电子信息与电气工程学院','521021910787','电院团委','qiutian@sjtu.edu.cn',2),(2,'杜心敏','dxm',1,'13213213213','https://c-ssl.duitang.com/uploads/item/201908/11/20190811201522_HxiQ8.thumb.1000_0.jpeg','软件学院','521021910952',NULL,'dxm@sjtu.edu.cn',3),(3,'全雨乐','qyl',0,NULL,NULL,'5','52115884848','','qyl@sjtu.edu.cn',NULL);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `userauth`
--

DROP TABLE IF EXISTS `userauth`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `userauth` (
  `user_id` int NOT NULL,
  `username` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `user_type` int DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `userauth`
--

LOCK TABLES `userauth` WRITE;
/*!40000 ALTER TABLE `userauth` DISABLE KEYS */;
INSERT INTO `userauth` VALUES (0,'segui','bigsegui',0),(1,'root','root',1),(2,'dxm','dxm',0),(3,'qyl','qyl',0);
/*!40000 ALTER TABLE `userauth` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-06-18  1:26:03
