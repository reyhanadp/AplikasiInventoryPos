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

insert  into `tb_jenis_produk`(`id_jenis_produk`,`nama_jenis_produk`) values ('DF','Dokumen Filateli'),('KM','Kemasan'),('MC','Merchandise'),('MS','MS & SS'),('PR','Prangko'),('PS','Prisma'),('SH','SHP & SHPSS');

/*Table structure for table `tb_produk` */

DROP TABLE IF EXISTS `tb_produk`;

CREATE TABLE `tb_produk` (
  `id_produk` varchar(7) NOT NULL,
  `nama_produk` varchar(100) DEFAULT NULL,
  `nominal` int(11) DEFAULT NULL,
  `biaya_cetak` float DEFAULT NULL,
  `stok` int(11) DEFAULT NULL,
  `tahun` year(4) DEFAULT NULL,
  `id_jenis_produk` varchar(5) DEFAULT NULL,
  PRIMARY KEY (`id_produk`),
  KEY `fk_id_jenis_produk` (`id_jenis_produk`),
  CONSTRAINT `fk_id_jenis_produk` FOREIGN KEY (`id_jenis_produk`) REFERENCES `tb_jenis_produk` (`id_jenis_produk`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `tb_produk` */

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
  `id_penerimaan` varchar(10) NOT NULL,
  `tgl_penerimaan` date DEFAULT NULL,
  `jml_terima` int(11) DEFAULT NULL,
  `id_produk` varchar(7) DEFAULT NULL,
  `id_suplier` varchar(5) DEFAULT NULL,
  `dus` smallint(6) DEFAULT NULL,
  PRIMARY KEY (`id_penerimaan`),
  KEY `fk_id_produk_penerimaan` (`id_produk`),
  KEY `fk_id_suplier_penerimaan` (`id_suplier`),
  CONSTRAINT `fk_id_produk_penerimaan` FOREIGN KEY (`id_produk`) REFERENCES `tb_produk` (`id_produk`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_id_suplier_penerimaan` FOREIGN KEY (`id_suplier`) REFERENCES `tb_suplier` (`id_suplier`) ON DELETE CASCADE ON UPDATE CASCADE
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
  PRIMARY KEY (`id_pengembalian`),
  KEY `fk_id_produk_pengembalian` (`id_produk`),
  KEY `fk_id_reg_pengembalian` (`id_regional`),
  CONSTRAINT `fk_id_produk_pengembalian` FOREIGN KEY (`id_produk`) REFERENCES `tb_produk` (`id_produk`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_id_reg_pengembalian` FOREIGN KEY (`id_regional`) REFERENCES `tb_regional` (`id_regional`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `tb_trans_pengembalian` */

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

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
