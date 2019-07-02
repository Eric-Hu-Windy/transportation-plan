CREATE DATABASE `transportation-plan` /*!40100 DEFAULT CHARACTER SET utf8 */;
CREATE TABLE `transportation-plan`.`plan` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `time` varchar(45) DEFAULT NULL,
  `from_province` varchar(45) DEFAULT NULL,
  `from_city` varchar(45) DEFAULT NULL,
  `from_address` varchar(45) DEFAULT NULL,
  `contact` varchar(45) DEFAULT NULL,
  `to_address` varchar(45) DEFAULT NULL,
  `goods` varchar(45) DEFAULT NULL,
  `motorcade` varchar(45) DEFAULT NULL,
  `cost` varchar(45) DEFAULT NULL,
  `salesman` varchar(45) DEFAULT NULL,
  `serial_no` varchar(45) DEFAULT NULL,
  `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `is_deleted` bit(1) NOT NULL DEFAULT b'0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;