/*
SQLyog Community v13.1.1 (64 bit)
MySQL - 10.1.28-MariaDB : Database - seminarski_rad_sc
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`seminarski_rad_sc` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `seminarski_rad_sc`;

/*Table structure for table `administrator` */

DROP TABLE IF EXISTS `administrator`;

CREATE TABLE `administrator` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `ime` varchar(100) DEFAULT NULL,
  `prezime` varchar(100) DEFAULT NULL,
  `username` varchar(100) DEFAULT NULL,
  `password` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

/*Data for the table `administrator` */

insert  into `administrator`(`id`,`ime`,`prezime`,`username`,`password`) values 
(1,'Aleksandar','Djurdjevic','admin','admin');

/*Table structure for table `clan` */

DROP TABLE IF EXISTS `clan`;

CREATE TABLE `clan` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `ime` varchar(150) DEFAULT NULL,
  `prezime` varchar(150) DEFAULT NULL,
  `jmbg` varchar(13) DEFAULT NULL,
  `pol` varchar(1) DEFAULT NULL,
  `adresa` varchar(250) DEFAULT NULL,
  `datum_rodjenja` date DEFAULT NULL,
  `username` varchar(100) DEFAULT NULL,
  `password` varchar(100) DEFAULT NULL,
  `mesto_id` int(10) unsigned DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_mesto` (`mesto_id`),
  CONSTRAINT `fk_mesto` FOREIGN KEY (`mesto_id`) REFERENCES `mesto` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=latin1;

/*Data for the table `clan` */

insert  into `clan`(`id`,`ime`,`prezime`,`jmbg`,`pol`,`adresa`,`datum_rodjenja`,`username`,`password`,`mesto_id`) values 
(1,'Pera','Peric','1305996238432','M','Djakovacka 2a','1996-05-13','pera','pera',1),
(3,'Mila','Milic','1205998846732','Z','Molerova 4','1998-05-12','mila','mila',1),
(7,'Milan','Djurdjevic','1411958203840','M','Mihajla Pupina 4/20','1958-11-14','nalim','nalim',2),
(11,'djura','djura','1305996890787','M','djakovacka','1996-05-13','djura','djura',3),
(28,'Alex','English','1306995890786','M','5th Avenue','1995-06-13','alex','alex',4),
(29,'Stojko','Stojkovic','1203992807654','M','Makenzijeva','1992-03-12','st','st',1),
(30,'Milan','Mikic','0101994867543','M','Darvinova 3','1994-01-01','miki','miki',1),
(32,'Danijela','Djurdjevic','1506967980987','Z','Kralja Aleksandra 23','1967-06-15','dr','dr',1),
(33,'Jeja','Dj','3011989123123','Z','Djakovacka 2a','1989-11-30','jeja','jeja',1);

/*Table structure for table `mesto` */

DROP TABLE IF EXISTS `mesto`;

CREATE TABLE `mesto` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `naziv` varchar(250) DEFAULT NULL,
  `postanski_broj` varchar(250) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

/*Data for the table `mesto` */

insert  into `mesto`(`id`,`naziv`,`postanski_broj`) values 
(1,'Beograd','11000'),
(2,'Novi Sad','21000'),
(3,'Cacak','32000'),
(4,'Nis','18000'),
(5,'Smederevo','11300');

/*Table structure for table `usluga` */

DROP TABLE IF EXISTS `usluga`;

CREATE TABLE `usluga` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `naziv` varchar(250) DEFAULT NULL,
  `opis` varchar(250) DEFAULT NULL,
  `status` varchar(50) DEFAULT NULL,
  `vrsta_usluge_id` int(10) unsigned DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_vrsta_usluge` (`vrsta_usluge_id`),
  CONSTRAINT `fk_vrsta_usluge` FOREIGN KEY (`vrsta_usluge_id`) REFERENCES `vrsta_usluge` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

/*Data for the table `usluga` */

insert  into `usluga`(`id`,`naziv`,`opis`,`status`,`vrsta_usluge_id`) values 
(1,'u1','o1','AKTIVNA',1),
(2,'u2','o2','AKTIVNA',2),
(3,'Kosarkaski teren','Koriscenje kosarkaskog terena','AKTIVNA',2),
(4,'Nova usluga 5','Opis neke nove usluge','AKTIVNA',1),
(5,'Nasa nova usluga 12','Opis nase najnovije usluge','AKTIVNA',2);

/*Table structure for table `vrsta_usluge` */

DROP TABLE IF EXISTS `vrsta_usluge`;

CREATE TABLE `vrsta_usluge` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `naziv_vrste` varchar(250) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

/*Data for the table `vrsta_usluge` */

insert  into `vrsta_usluge`(`id`,`naziv_vrste`) values 
(1,'VrstaUsluge1'),
(2,'VrstaUsluge2');

/*Table structure for table `zahtev` */

DROP TABLE IF EXISTS `zahtev`;

CREATE TABLE `zahtev` (
  `sifra` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `datum_odgovora` date DEFAULT NULL,
  `status_zahteva` varchar(100) DEFAULT NULL,
  `clan_id` int(10) unsigned NOT NULL,
  `usluga_id` int(10) unsigned NOT NULL,
  `admin_id` int(10) unsigned DEFAULT NULL,
  PRIMARY KEY (`sifra`,`clan_id`,`usluga_id`),
  KEY `fk_clan_id` (`clan_id`),
  KEY `fk_usluga_id` (`usluga_id`),
  KEY `fk_admin_id` (`admin_id`),
  CONSTRAINT `fk_admin_id` FOREIGN KEY (`admin_id`) REFERENCES `administrator` (`id`),
  CONSTRAINT `fk_clan_id` FOREIGN KEY (`clan_id`) REFERENCES `clan` (`id`),
  CONSTRAINT `fk_usluga_id` FOREIGN KEY (`usluga_id`) REFERENCES `usluga` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;

/*Data for the table `zahtev` */

insert  into `zahtev`(`sifra`,`datum_odgovora`,`status_zahteva`,`clan_id`,`usluga_id`,`admin_id`) values 
(1,'2020-06-18','PRIHVACEN',1,1,1),
(2,'2020-06-25','PRIHVACEN',1,3,1),
(3,'2020-06-29','ODBIJEN',1,1,1),
(4,'2020-06-29','PRIHVACEN',1,3,1),
(5,'2020-06-25','ODBIJEN',1,2,1),
(6,'2020-07-04','PRIHVACEN',1,4,1),
(7,'2020-06-25','PRIHVACEN',1,5,1),
(8,'2020-06-25','PRIHVACEN',1,5,1),
(9,'2020-07-04','PRIHVACEN',1,5,1);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
