DROP DATABASE  IF EXISTS `spring-security-test`;

CREATE DATABASE  IF NOT EXISTS `spring-security-test`;
USE `spring-security-test`;

DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
	`user_id` INT NOT NULL auto_increment,
    `email` VARCHAR(30)  unique,
    `mobile` VARCHAR(15) NOT NULL,
    `password` VARCHAR(255) NOT NULL,
    `username` VARCHAR(50) NOT NULL,
    PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
`id` INT NOT NULL auto_increment,
`name` VARCHAR(55) NOT NULL,
PRIMARY KEY(`id`)
)ENGINE=InnoDB DEFAULT CHARSET=latin1;

drop table if exists `user_roles`;
CREATE TABLE `user_roles` (
  `users_user_id` int(11) NOT NULL,
  `roles_id` int(11) NOT NULL,
  
  PRIMARY KEY (`users_user_id`,`roles_id`),
  
  CONSTRAINT `FK_USER` FOREIGN KEY (`users_user_id`) 
  REFERENCES `user` (`user_id`) ,
  
  CONSTRAINT `FK_ROLE` FOREIGN KEY (`roles_id`) 
  REFERENCES `role` (`id`) 
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS `item`;
CREATE TABLE `item` (
	`item_id` INT NOT NULL AUTO_INCREMENT,
    `item_name` VARCHAR(200) NOT NULL,
    `users_user_id` INT, 
    PRIMARY KEY(`item_id`),
    CONSTRAINT FK_UserID FOREIGN KEY (`users_user_id`)
  REFERENCES `user` (`user_id`)
  )ENGINE=InnoDB DEFAULT CHARSET=latin1;
    
