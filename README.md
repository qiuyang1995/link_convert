CREATE TABLE `link` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `short_url` varchar(255) DEFAULT NULL,
  `long_url` varchar(10000) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;
