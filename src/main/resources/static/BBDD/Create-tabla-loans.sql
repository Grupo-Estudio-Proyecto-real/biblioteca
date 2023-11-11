CREATE TABLE `loans`(
 `cloan` bigint(8) NOT NULL AUTO_INCREMENT,
 `cuser` bigint(6),
 `cbook` bigint(6),
 `floan` varchar(10) DEFAULT NULL,
 `daysloan` int,
 PRIMARY KEY(`cloan`),
 CONSTRAINT FK_UsersLoans FOREIGN KEY(`cuser`) REFERENCES `users`(`cuser`),
 CONSTRAINT FK_BooksLoans FOREIGN KEY(`cbook`) REFERENCES `books`(`cbook`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;