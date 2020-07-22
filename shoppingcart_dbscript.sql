DROP DATABASE  IF EXISTS `spring-application`;

CREATE DATABASE  IF NOT EXISTS `spring-application`;
USE `spring-application`;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
	`user_id` INT NOT NULL auto_increment,
    `user_name` VARCHAR(50) NOT NULL,
    `user_email` VARCHAR(30) NOT NULL unique,
    `user_mobile` VARCHAR(15) NOT NULL,user
    PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS `item`;
CREATE TABLE `item` (
	`item_id` INT NOT NULL AUTO_INCREMENT,
    `item_name` VARCHAR(200) NOT NULL,
    `usr_id` INT, 
    PRIMARY KEY(`item_id`),
    CONSTRAINT FK_UserID FOREIGN KEY (`usr_id`)
  REFERENCES `user` (`user_id`)
  )ENGINE=InnoDB DEFAULT CHARSET=latin1;
    
    