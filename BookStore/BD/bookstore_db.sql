# MySQL-Front 3.2  (Build 6.11)

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES 'latin1' */;

# Host: localhost    Database: bookstore_db
# ------------------------------------------------------
# Server version 5.5.29

CREATE DATABASE `bookstore_db` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `bookstore_db`;

#
# Table structure for table administrator
#

CREATE TABLE `administrator` (
  `id_admin` varchar(50) NOT NULL DEFAULT '',
  `name_admin` varchar(50) DEFAULT NULL,
  `firstname_admin` varchar(50) DEFAULT NULL,
  `password_admin` varchar(50) DEFAULT NULL,
  `address_admin` varchar(50) DEFAULT NULL,
  `phonenumber_admin` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id_admin`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

#
# Dumping data for table administrator
#

INSERT INTO `administrator` (`id_admin`,`name_admin`,`firstname_admin`,`password_admin`,`address_admin`,`phonenumber_admin`) VALUES ('1','admin','admin','0000','ruexx','1458');

#
# Table structure for table book
#

CREATE TABLE `book` (
  `ref_Book` varchar(50) NOT NULL,
  `titel_book` varchar(50) NOT NULL,
  `author_book` varchar(50) DEFAULT NULL,
  `price_book` double(10,5) NOT NULL DEFAULT '0.00000',
  `stock_quantity` int(11) DEFAULT '0',
  `relaseDate` date DEFAULT NULL,
  `admin_book` varchar(50) DEFAULT '1',
  PRIMARY KEY (`ref_Book`),
  KEY `fk_adminbook` (`admin_book`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

#
# Dumping data for table book
#

INSERT INTO `book` (`ref_Book`,`titel_book`,`author_book`,`price_book`,`stock_quantity`,`relaseDate`,`admin_book`) VALUES ('01','book1','author1',14,5,'2010-01-07','1');
INSERT INTO `book` (`ref_Book`,`titel_book`,`author_book`,`price_book`,`stock_quantity`,`relaseDate`,`admin_book`) VALUES ('02','book2','author2',12,10,'2020-10-02','1');
INSERT INTO `book` (`ref_Book`,`titel_book`,`author_book`,`price_book`,`stock_quantity`,`relaseDate`,`admin_book`) VALUES ('03','book3','author3',20,10,'2020-10-02','1');
INSERT INTO `book` (`ref_Book`,`titel_book`,`author_book`,`price_book`,`stock_quantity`,`relaseDate`,`admin_book`) VALUES ('04','book4','author1',40,10,'2020-10-02','1');

#
# Table structure for table command_ligne
#

CREATE TABLE `command_ligne` (
  `Id_commandligne` varchar(50) NOT NULL,
  `purchase_quantity` int(50) DEFAULT NULL,
  `reforder_CL` varchar(50) NOT NULL,
  `book_cl` varchar(50) NOT NULL,
  PRIMARY KEY (`Id_commandligne`(4),`reforder_CL`,`book_cl`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

#
# Dumping data for table command_ligne
#

INSERT INTO `command_ligne` (`Id_commandligne`,`purchase_quantity`,`reforder_CL`,`book_cl`) VALUES ('lc01',2,'c01','01');
INSERT INTO `command_ligne` (`Id_commandligne`,`purchase_quantity`,`reforder_CL`,`book_cl`) VALUES ('lc02',5,'c01','02');
INSERT INTO `command_ligne` (`Id_commandligne`,`purchase_quantity`,`reforder_CL`,`book_cl`) VALUES ('lc03',10,'c02','03');

#
# Table structure for table order
#

CREATE TABLE `order` (
  `ref_Order` varchar(30) NOT NULL,
  `prix_ttc` double(10,5) NOT NULL DEFAULT '0.00000',
  `date_order` date DEFAULT '2020-11-12',
  `user_c` varchar(50) NOT NULL DEFAULT 'u02',
  PRIMARY KEY (`ref_Order`),
  KEY `fk_user` (`user_c`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

#
# Dumping data for table order
#

INSERT INTO `order` (`ref_Order`,`prix_ttc`,`date_order`,`user_c`) VALUES ('c01',52,'2014-07-04','u01');
INSERT INTO `order` (`ref_Order`,`prix_ttc`,`date_order`,`user_c`) VALUES ('c02',45,'2013-08-07','u02');
INSERT INTO `order` (`ref_Order`,`prix_ttc`,`date_order`,`user_c`) VALUES ('c03',15,'2002-03-04','u02');
INSERT INTO `order` (`ref_Order`,`prix_ttc`,`date_order`,`user_c`) VALUES ('c08',159,'3913-06-05','u02');

#
# Table structure for table user
#

CREATE TABLE `user` (
  `Id_user` varchar(50) NOT NULL,
  `password_user` varchar(50) NOT NULL,
  `user_name` varchar(50) NOT NULL,
  `firstname_user` varchar(50) NOT NULL,
  `adress_user` varchar(50) DEFAULT NULL,
  `numberphone_user` varchar(50) DEFAULT NULL,
  `add_byadmin` varchar(50) DEFAULT '1',
  PRIMARY KEY (`Id_user`),
  KEY `fk_admin` (`add_byadmin`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

#
# Dumping data for table user
#

INSERT INTO `user` (`Id_user`,`password_user`,`user_name`,`firstname_user`,`adress_user`,`numberphone_user`,`add_byadmin`) VALUES ('u01','0000','user1','prenom1','ruexxx','1235','1');
INSERT INTO `user` (`Id_user`,`password_user`,`user_name`,`firstname_user`,`adress_user`,`numberphone_user`,`add_byadmin`) VALUES ('u02','0001','user2','prenom2','ruexx1','567','1');
INSERT INTO `user` (`Id_user`,`password_user`,`user_name`,`firstname_user`,`adress_user`,`numberphone_user`,`add_byadmin`) VALUES ('u03','0000',' user3',' prenom3',' ruexyz',' 231','1');

#
#  Foreign keys for table book
#

ALTER TABLE `book`
  ADD FOREIGN KEY (`admin_book`) REFERENCES `administrator` (`id_admin`);

#
#  Foreign keys for table order
#

ALTER TABLE `order`
  ADD FOREIGN KEY (`user_c`) REFERENCES `user` (`Id_user`);

#
#  Foreign keys for table user
#

ALTER TABLE `user`
  ADD FOREIGN KEY (`add_byadmin`) REFERENCES `administrator` (`id_admin`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
