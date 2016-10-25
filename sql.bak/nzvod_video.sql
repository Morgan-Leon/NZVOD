

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
-- Table structure for table `video`
--

DROP TABLE IF EXISTS `video`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `video` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `creation_time` datetime NOT NULL,
  `description` varchar(200) COLLATE utf8_bin DEFAULT NULL,
  `author` varchar(100) COLLATE utf8_bin DEFAULT NULL,
  `deleted` tinyint(1) NOT NULL,
  `grade_id` bigint(20) NOT NULL,
  `modification_time` datetime NOT NULL,
  `name` varchar(100) COLLATE utf8_bin NOT NULL,
  `subject_id` bigint(20) NOT NULL,
  `thumbnail` longtext COLLATE utf8_bin,
  `thumbnail_url` longtext COLLATE utf8_bin,
  `upload_user` varchar(100) COLLATE utf8_bin DEFAULT NULL,
  `url` varchar(100) COLLATE utf8_bin NOT NULL,
  `views` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `video`
--

LOCK TABLES `video` WRITE;
/*!40000 ALTER TABLE `video` DISABLE KEYS */;
INSERT INTO `video` VALUES (1,'2016-10-16 06:32:48','微课点播平台','南庄小学',0,1,'2016-10-16 06:32:48','视频一',1,NULL,'../images/thumbnails/1.jpg',NULL,'../videos/1.mp4',0),(2,'2016-10-16 06:33:00','微课点播平台','南庄小学',0,1,'2016-10-16 06:33:00','视频二',1,NULL,'../images/thumbnails/2.jpg',NULL,'../videos/2.mp4',0),(3,'2016-10-16 06:33:03','微课点播平台','南庄小学',0,1,'2016-10-16 06:33:03','视频三',1,NULL,'../images/thumbnails/3.jpg',NULL,'../videos/3.mp4',0),(4,'2016-10-16 06:33:13','微课点播平台','南庄小学',0,1,'2016-10-16 06:33:13','视频四',2,NULL,'../images/thumbnails/4.jpg',NULL,'../videos/4.mp4',0),(5,'2016-10-16 06:33:19','微课点播平台','南庄小学',0,2,'2016-10-16 06:33:19','视频五',2,NULL,'../images/thumbnails/5.jpg',NULL,'../videos/5.mp4',0);
/*!40000 ALTER TABLE `video` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-10-17  0:02:34
