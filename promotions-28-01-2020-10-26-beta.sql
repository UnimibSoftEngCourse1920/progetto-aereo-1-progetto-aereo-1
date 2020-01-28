-- Generation time: Tue, 28 Jan 2020 10:26:57 +0000
-- Host: mysql.hostinger.ro
-- DB name: u574849695_23
/*!40030 SET NAMES UTF8 */;
/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

DROP TABLE IF EXISTS `promotions`;
CREATE TABLE `promotions` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `discount_percentage` int(11) DEFAULT NULL,
  `end` date DEFAULT NULL,
  `flight` tinyblob DEFAULT NULL,
  `start` date DEFAULT NULL,
  `premium` bit(1) DEFAULT 0,
  
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

INSERT INTO `promotions` VALUES ('1','10',NULL,2109,NULL),
('2','25',NULL,4144,NULL,0),
('3','25',NULL,3748,NULL,0),
('4','25',NULL,3747,NULL,0),
('5','20',NULL,2505,NULL,1),
('6','15',NULL,8804,NULL,0),
('7','15',NULL,8808,NULL,0),
('8','20',NULL,0506,NULL,0),
('9','10',NULL,3110,NULL,1),
('10','20',NULL,7750,NULL,1),
('11','15',NULL,5649,NULL,0),
('12','15',NULL,5650,NULL,0),
('13','25',NULL,4311,NULL,0),
('14','20',NULL,1751,NULL,1),
('15','10',NULL,13105,NULL,0),
('16','15',NULL,17743,NULL,0),
('17','15',NULL,17748,NULL,1),
('18','20',NULL,15649,NULL,0),
('19','10',NULL,11152,NULL,0),
('20','10',NULL,14308,NULL,0),
('21','15',NULL,11745,NULL,1),
('22','25',NULL,23104,NULL,0),
('23','25',NULL,25647,NULL,0),
('24','10',NULL,24304,NULL,0),
('25','20',NULL,24313,NULL,1),
('26','25',NULL,33103,NULL,1),
('27','25',NULL,37750,NULL,0),
('28','20',NULL,35651,NULL,0),
('29','10',NULL,34304,NULL,0),
('30','20',NULL,34305,NULL,0),
('31','20',NULL,31746,NULL,0),
('32','10',NULL,47745,NULL,1),
('33','20',NULL,41153,NULL,0),
('34','25',NULL,44305,NULL,1),
('35','20',2020-02-14,NULL,2020-02-14,1),
('36','10',2020-02-08,NULL,2020-02-08,0),
('37','15',2020-02-11,NULL,2020-03-12,0),
('38','15',2020-02-16,NULL,2020-03-17,1),
('39','20',2020-02-25,NULL,2020-02-27,1),
('40','20',2020-02-29,NULL,2020-02-29,0),
('41','25',NULL,73108,NULL,0),
('42','15',NULL,137748,NULL,1),
('43','15',NULL,135644,NULL,0),
('44','15',NULL,164312,NULL,1),
('45','15',NULL,177744,NULL,0),
('46','25',NULL,171155,NULL,1),
('47','20',NULL,171745,NULL,0),
('48','15',NULL,187745,NULL,1),
('49','10',NULL,181744,NULL,0),
('50','15',NULL,191152,NULL,0), 
('51','15',NULL,194307,NULL,0),
('52','10',NULL,194312,NULL,0),
('53','15',NULL,207749,NULL,0),
('54','15',NULL,201161,NULL,1),
('55','10',NULL,213109,NULL,0),
('56','15',NULL,217747,NULL,0); 



/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
