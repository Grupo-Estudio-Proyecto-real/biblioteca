CREATE TABLE `issues`(
 `cgender` bigint(4) NOT NULL AUTO_INCREMENT,
 `issue` varchar(20) NOT NULL,
 `subtopic` varchar(20) DEFAULT NULL,
PRIMARY KEY(`cgender`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;