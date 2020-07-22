DROP DATABASE  IF EXISTS `spring-security-test`;

CREATE DATABASE  IF NOT EXISTS `spring-security-test`;
USE `spring-security-test`;

DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
	`id` INT NOT NULL auto_increment,
    `email` VARCHAR(30)  unique,
    `mobile` VARCHAR(15) NOT NULL,
    `password` VARCHAR(255) NOT NULL,
    `username` VARCHAR(50) NOT NULL,
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
`id` INT NOT NULL auto_increment,
`name` VARCHAR(55) NOT NULL,
PRIMARY KEY(`id`)
)ENGINE=InnoDB DEFAULT CHARSET=latin1;

drop table if exists `user_roles`;
CREATE TABLE `user_roles` (
  `users_id` int(11) NOT NULL,
  `roles_id` int(11) NOT NULL,
  
  PRIMARY KEY (`users_id`,`roles_id`),
  
  CONSTRAINT `FK_USER` FOREIGN KEY (`users_id`) 
  REFERENCES `user` (`id`) ,
  
  CONSTRAINT `FK_ROLE` FOREIGN KEY (`roles_id`) 
  REFERENCES `role` (`id`) 
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS `item_store`;
  CREATE TABLE `item_store` (
	`id` INT NOT NULL AUTO_INCREMENT,
    `item_name` VARCHAR(200) NOT NULL,
    `price` DECIMAL(8,2) NOT NULL,
    `company` VARCHAR(200) NOT NULL,
    `rating` INT,
    PRIMARY KEY(`id`)
    )ENGINE=InnoDB DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS `item`;
CREATE TABLE `item` (
	`id` INT NOT NULL AUTO_INCREMENT,
    `itemstore_id` INT,
    `quantity` INT NOT NULL,
    `total` DECIMAL(8,2) NOT NULL,
    `user_id` INT, 
    PRIMARY KEY(`id`),
    CONSTRAINT `FK_ItemStoreID` FOREIGN KEY (`itemstore_id`)
  REFERENCES `item_store` (`id`),
    CONSTRAINT `FK_UserID` FOREIGN KEY (`user_id`)
  REFERENCES `user` (`id`)
  )ENGINE=InnoDB DEFAULT CHARSET=latin1;
  
DROP TABLE IF EXISTS `rating`;
  create table `rating` (
`id` int not null auto_increment,
`itemstore_id` int,
`rating` int,
primary key(`id`),
constraint `Fk_itemstore_id` FOREIGN KEY(`itemstore_id`) REFERENCES `item_store`(`id`)
)ENGINE=InnoDB DEFAULT CHARSET=latin1;
  

    