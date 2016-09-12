DROP TABLE IF EXISTS `demo_users`;

CREATE TABLE `demo_users` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `user_login` varchar(60) NOT NULL,
  `user_pass` varchar(255) NOT NULL,
  `user_nicename` varchar(50) DEFAULT NULL,
  `user_email` varchar(100) NOT NULL,
  `user_url` varchar(100) DEFAULT NULL,
  `user_status` int(11) NOT NULL,
  `dispaly_name` varchar(250) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;