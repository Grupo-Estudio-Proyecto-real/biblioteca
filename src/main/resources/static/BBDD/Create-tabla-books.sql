CREATE TABLE `books`(
 `cbook` bigint(6) NOT NULL AUTO_INCREMENT,
 `title` varchar(50) UNIQUE NOT NULL,
 `isbn` varchar(17) UNIQUE NOT NULL,
 `authors` varchar(80) NOT NULL,
 `dedition` varchar(10) NOT NULL,
 `cgender` bigint(4) NOT NULL,
 `summary` varchar(255) DEFAULT NULL,
 `frontpage` varchar(60) DEFAULT NULL,
 `pathbook` varchar(200) DEFAULT NULL,
 `availability` varchar(1) DEFAULT 'D',
 PRIMARY KEY(`cbook`),
 CONSTRAINT FK_IssuesBooks FOREIGN KEY(`cgender`) REFERENCES `issues`(`cgender`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;