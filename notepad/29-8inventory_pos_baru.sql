/*
SQLyog Community v9.63 
MySQL - 5.5.5-10.1.21-MariaDB : Database - db_inventory_pos
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`db_inventory_pos` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `db_inventory_pos`;

/*Table structure for table `tb_hapus_produk` */

DROP TABLE IF EXISTS `tb_hapus_produk`;

CREATE TABLE `tb_hapus_produk` (
  `id_produk` varchar(7) NOT NULL,
  `nama_produk` varchar(100) DEFAULT NULL,
  `nominal` int(11) DEFAULT NULL,
  `biaya_cetak` float DEFAULT NULL,
  `stok` int(11) DEFAULT NULL,
  `tahun` year(4) DEFAULT NULL,
  `id_jenis_produk` varchar(5) DEFAULT NULL,
  `tgl_penghapusan` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id_produk`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `tb_hapus_produk` */

insert  into `tb_hapus_produk`(`id_produk`,`nama_produk`,`nominal`,`biaya_cetak`,`stok`,`tahun`,`id_jenis_produk`,`tgl_penghapusan`) values ('',NULL,NULL,NULL,NULL,NULL,NULL,'2017-08-29 13:55:21'),('KM001','kemasan 1',10,20,10,2000,'KM','2017-08-21 14:11:21'),('PR001','prangko 1',10,20,10,2010,'PR','2017-08-21 14:11:21'),('PR002','prangko 2',100,20,10,2010,'PR','2017-08-21 14:19:05'),('PR005','pangko 5',2000,1500,0,2011,'PR','2017-08-29 09:22:47'),('PR006','prangko6',0,0,0,2010,'PR','2017-08-28 13:32:23'),('PR007','prangko 7',1000,700,0,2009,'PR','2017-08-28 13:44:47'),('PR008','prengk',0,0,0,2000,'PR','2017-08-28 14:47:50'),('SHP001',NULL,NULL,NULL,NULL,NULL,NULL,'2017-08-25 11:06:17');

/*Table structure for table `tb_history_pengembalian` */

DROP TABLE IF EXISTS `tb_history_pengembalian`;

CREATE TABLE `tb_history_pengembalian` (
  `id_pengembalian` varchar(7) NOT NULL,
  `tgl_pengembalian` date DEFAULT NULL,
  `stok_awal` int(11) DEFAULT NULL,
  `jml_pengembalian` int(11) DEFAULT NULL,
  `dus` smallint(6) DEFAULT NULL,
  `id_regional` varchar(5) DEFAULT NULL,
  `id_produk` varchar(7) DEFAULT NULL,
  `stok_akhir` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `tb_history_pengembalian` */

/*Table structure for table `tb_jenis_produk` */

DROP TABLE IF EXISTS `tb_jenis_produk`;

CREATE TABLE `tb_jenis_produk` (
  `id_jenis_produk` varchar(5) NOT NULL,
  `nama_jenis_produk` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id_jenis_produk`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `tb_jenis_produk` */

insert  into `tb_jenis_produk`(`id_jenis_produk`,`nama_jenis_produk`) values ('DF','Dokumen Filateli'),('KM','Kemasan'),('MC','Merchandise'),('MS','MS'),('PR','Prangko'),('PS','Prisma'),('SHP','SHP'),('SHPSS','SHPSS'),('SS','SS');

/*Table structure for table `tb_pemesanan` */

DROP TABLE IF EXISTS `tb_pemesanan`;

CREATE TABLE `tb_pemesanan` (
  `no_pemesanan` varchar(5) NOT NULL,
  `id_produk` varchar(10) DEFAULT NULL,
  `nama_produk` varchar(100) DEFAULT NULL,
  `jumlah_pesan` int(11) DEFAULT NULL,
  `tgl_pesan` date DEFAULT NULL,
  `tahun` varchar(4) DEFAULT NULL,
  `nominal` int(11) DEFAULT NULL,
  `biaya_cetak` float DEFAULT NULL,
  `id_jenis_produk` varchar(5) DEFAULT NULL,
  PRIMARY KEY (`no_pemesanan`),
  KEY `fk_id_jenis_produk_pemesanan` (`id_jenis_produk`),
  CONSTRAINT `fk_id_jenis_produk_pemesanan` FOREIGN KEY (`id_jenis_produk`) REFERENCES `tb_jenis_produk` (`id_jenis_produk`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `tb_pemesanan` */

/*Table structure for table `tb_produk` */

DROP TABLE IF EXISTS `tb_produk`;

CREATE TABLE `tb_produk` (
  `id_produk` varchar(10) NOT NULL,
  `nama_produk` varchar(100) DEFAULT NULL,
  `nominal` int(11) DEFAULT NULL,
  `biaya_cetak` float DEFAULT NULL,
  `stok` int(11) DEFAULT NULL,
  `tahun` varchar(4) DEFAULT NULL,
  `id_jenis_produk` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`id_produk`),
  KEY `fk_id_jenis_produk` (`id_jenis_produk`),
  CONSTRAINT `fk_id_jenis_produk` FOREIGN KEY (`id_jenis_produk`) REFERENCES `tb_jenis_produk` (`id_jenis_produk`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `tb_produk` */

insert  into `tb_produk`(`id_produk`,`nama_produk`,`nominal`,`biaya_cetak`,`stok`,`tahun`,`id_jenis_produk`) values ('DF001','df 1',1000,500,0,'2010','DF'),('KM001','prakem 1',3000,2500,0,'2010','KM'),('KM002','kemasan 2',2000,1200,0,'2011','KM'),('MC001','mc 1',100,10,0,'2001','MC'),('MC002','nc 2',2000,1200,0,'2002','MC'),('MS001','ms 1',1000,500,0,'2010','MS'),('PR001','prangko 1',0,1000,0,'2000','PR'),('PR002','prangko 2',1000,500,0,'2010','PR'),('PR003','prangko 3',1000,200,10,'2010','PR'),('PR004','Prangko 4',5000,1000,0,'2010','PR'),('PR009','prangko 98',2000,1000,0,'2009','PR'),('PR010','prangko 10',2000,1500,0,'2010','PR'),('PS001','pr 1',1000,200,0,'2010','PS'),('SHP001','shp01',2000,1000,0,'2010','SHP'),('SHPSS001','shpss017',1000,500,0,'2011','SHPSS'),('SS001','ss 1',2000,1200,0,'2011','SS'),('SS002','sci 2',1000,800,0,'2000','SS');

/*Table structure for table `tb_regional` */

DROP TABLE IF EXISTS `tb_regional`;

CREATE TABLE `tb_regional` (
  `id_regional` varchar(3) NOT NULL,
  `regional` varchar(100) DEFAULT NULL,
  `kode_pos` varchar(5) DEFAULT NULL,
  `no_telp` varchar(9) DEFAULT NULL,
  `alamat` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id_regional`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `tb_regional` */

/*Table structure for table `tb_suplier` */

DROP TABLE IF EXISTS `tb_suplier`;

CREATE TABLE `tb_suplier` (
  `id_suplier` varchar(5) NOT NULL,
  `nama_suplier` varchar(50) DEFAULT NULL,
  `alamat` varchar(100) DEFAULT NULL,
  `no_telp` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`id_suplier`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `tb_suplier` */

/*Table structure for table `tb_trans_penerimaan` */

DROP TABLE IF EXISTS `tb_trans_penerimaan`;

CREATE TABLE `tb_trans_penerimaan` (
  `no_order` varchar(4) NOT NULL,
  `tgl_penerimaan` date DEFAULT NULL,
  `jml_terima` int(11) DEFAULT NULL,
  `no_pemesanan` varchar(5) DEFAULT NULL,
  `id_suplier` varchar(5) DEFAULT NULL,
  `stok_awal` int(11) DEFAULT NULL,
  `stok_akhir` int(11) DEFAULT NULL,
  `subtotal_terima` int(11) DEFAULT NULL,
  `sisa_belum_dikirim` int(11) DEFAULT NULL,
  PRIMARY KEY (`no_order`),
  KEY `fk_id_produk_penerimaan` (`no_pemesanan`),
  KEY `fk_id_suplier_penerimaan` (`id_suplier`),
  CONSTRAINT `fk_id_suplier` FOREIGN KEY (`id_suplier`) REFERENCES `tb_suplier` (`id_suplier`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_no_pemesanan` FOREIGN KEY (`no_pemesanan`) REFERENCES `tb_pemesanan` (`no_pemesanan`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `tb_trans_penerimaan` */

/*Table structure for table `tb_trans_pengeluaran` */

DROP TABLE IF EXISTS `tb_trans_pengeluaran`;

CREATE TABLE `tb_trans_pengeluaran` (
  `id_pengeluaran` varchar(7) NOT NULL,
  `tgl_pengeluaran` date DEFAULT NULL,
  `jml_pengeluaran` int(11) DEFAULT NULL,
  `dus` smallint(6) DEFAULT NULL,
  `id_regional` varchar(5) DEFAULT NULL,
  `id_produk` varchar(7) DEFAULT NULL,
  `stok_awal` int(11) DEFAULT NULL,
  `stok_akhir` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_pengeluaran`),
  KEY `fk_id_produk_pengeluaran` (`id_produk`),
  KEY `fk_id_reg_pengeluaran` (`id_regional`),
  CONSTRAINT `fk_id_produk_pengeluaran` FOREIGN KEY (`id_produk`) REFERENCES `tb_produk` (`id_produk`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_id_reg_pengeluaran` FOREIGN KEY (`id_regional`) REFERENCES `tb_regional` (`id_regional`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `tb_trans_pengeluaran` */

/*Table structure for table `tb_trans_pengembalian` */

DROP TABLE IF EXISTS `tb_trans_pengembalian`;

CREATE TABLE `tb_trans_pengembalian` (
  `id_pengembalian` varchar(7) NOT NULL,
  `tgl_pengembalian` date DEFAULT NULL,
  `jml_pengembalian` int(11) DEFAULT NULL,
  `dus` smallint(6) DEFAULT NULL,
  `id_regional` varchar(5) DEFAULT NULL,
  `id_produk` varchar(7) DEFAULT NULL,
  `stok_awal` int(11) DEFAULT NULL,
  `stok_akhir` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_pengembalian`),
  KEY `fk_id_produk_pengembalian` (`id_produk`),
  KEY `fk_id_reg_pengembalian` (`id_regional`),
  CONSTRAINT `fk_id_produk_pengembalian` FOREIGN KEY (`id_produk`) REFERENCES `tb_produk` (`id_produk`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_id_reg_pengembalian` FOREIGN KEY (`id_regional`) REFERENCES `tb_regional` (`id_regional`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `tb_trans_pengembalian` */

/*Table structure for table `tb_update_produk` */

DROP TABLE IF EXISTS `tb_update_produk`;

CREATE TABLE `tb_update_produk` (
  `id_produk` varchar(7) NOT NULL,
  `nama_produk` varchar(100) DEFAULT NULL,
  `nominal` int(11) DEFAULT NULL,
  `biaya_cetak` float DEFAULT NULL,
  `stok` int(11) DEFAULT NULL,
  `tahun` year(4) DEFAULT NULL,
  `id_jenis_produk` varchar(5) DEFAULT NULL,
  `tgl_update` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `tb_update_produk` */

insert  into `tb_update_produk`(`id_produk`,`nama_produk`,`nominal`,`biaya_cetak`,`stok`,`tahun`,`id_jenis_produk`,`tgl_update`) values ('PR003','prangko 3',1000,200,10,2011,'PR','2017-08-21 14:23:37'),('PR003','prangko 3',1500,200,10,2011,'PR','2017-08-23 13:34:57'),('PR003','prangko 3',1000,200,10,2010,'PR','2017-08-23 13:38:40'),('PR009','prangko 9',2000,1000,0,2009,'PR','2017-08-29 09:22:30');

/*Table structure for table `tb_user` */

DROP TABLE IF EXISTS `tb_user`;

CREATE TABLE `tb_user` (
  `username` varchar(20) NOT NULL,
  `password` varchar(30) DEFAULT NULL,
  `nama_user` varchar(50) DEFAULT NULL,
  `nik` varchar(12) DEFAULT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `tb_user` */

insert  into `tb_user`(`username`,`password`,`nama_user`,`nik`) values ('amad','amad','amad','111');

/* Trigger structure for table `tb_pemesanan` */

DELIMITER $$

/*!50003 DROP TRIGGER*//*!50032 IF EXISTS */ /*!50003 `trig_insert_to_produk` */$$

/*!50003 CREATE */ /*!50017 DEFINER = 'root'@'localhost' */ /*!50003 TRIGGER `trig_insert_to_produk` AFTER INSERT ON `tb_pemesanan` FOR EACH ROW BEGIN
	INSERT INTO
	`db_inventory_pos`.`tb_produk`
	(`id_produk`, 
	`nama_produk`, 
	`nominal`, 
	`biaya_cetak`, 
	`stok`, 
	`tahun`, 
	`id_jenis_produk`
	)
	VALUES 
	(NEW.id_produk,
	NEW.nama_produk,
	NEW.nominal,
	NEW.biaya_cetak,
	0,
	NEW.tahun,
	NEW.id_jenis_produk);
    END */$$


DELIMITER ;

/* Trigger structure for table `tb_produk` */

DELIMITER $$

/*!50003 DROP TRIGGER*//*!50032 IF EXISTS */ /*!50003 `history_update_produk` */$$

/*!50003 CREATE */ /*!50017 DEFINER = 'root'@'localhost' */ /*!50003 TRIGGER `history_update_produk` AFTER UPDATE ON `tb_produk` FOR EACH ROW BEGIN
	INSERT INTO
	`db_inventory_pos`.`tb_update_produk`
	(`id_produk`, 
	`nama_produk`, 
	`nominal`, 
	`biaya_cetak`, 
	`stok`, 
	`tahun`, 
	`id_jenis_produk`
	)
	VALUES 
	(OLD.id_produk, 
	OLD.nama_produk, 
	OLD.nominal, 
	OLD.biaya_cetak, 
	OLD.stok, 
	OLD.tahun, 
	OLD.id_jenis_produk
	) ;
    END */$$


DELIMITER ;

/* Trigger structure for table `tb_produk` */

DELIMITER $$

/*!50003 DROP TRIGGER*//*!50032 IF EXISTS */ /*!50003 `history_hapus_produk` */$$

/*!50003 CREATE */ /*!50017 DEFINER = 'root'@'localhost' */ /*!50003 TRIGGER `history_hapus_produk` AFTER DELETE ON `tb_produk` FOR EACH ROW BEGIN
	INSERT INTO
	`db_inventory_pos`.`tb_hapus_produk`
	(`id_produk`, 
	`nama_produk`, 
	`nominal`, 
	`biaya_cetak`, 
	`stok`, 
	`tahun`, 
	`id_jenis_produk`
	)
	VALUES 
	(OLD.id_produk, 
	OLD.nama_produk, 
	OLD.nominal, 
	OLD.biaya_cetak, 
	OLD.stok, 
	OLD.tahun, 
	OLD.id_jenis_produk
	) ;
    END */$$


DELIMITER ;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
