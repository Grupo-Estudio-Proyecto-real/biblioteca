CREATE TABLE `users`(
 `cuser` bigint(6) NOT NULL AUTO_INCREMENT,
 `name` varchar(30) NOT NULL,
 `surnames` varchar(40) NOT NULL,
 `dni` varchar(10) UNIQUE NOT NULL,
 `address` varchar(80) NOT NULL,
 `phone` varchar(17) DEFAULT NULL,
 `email` varchar(30) NOT NULL,
 `password` varchar(20) NOT NULL,
 `low`varchar(5) DEFAULT NULL,
 `dpenalty` int(3) NOT NULL DEFAULT 0,
PRIMARY KEY(`cuser`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;