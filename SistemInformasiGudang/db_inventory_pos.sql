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

/*Table structure for table `tb_jenis_produk` */

DROP TABLE IF EXISTS `tb_jenis_produk`;

CREATE TABLE `tb_jenis_produk` (
  `id_jenis_produk` varchar(5) NOT NULL,
  `nama_jenis_produk` varchar(100) NOT NULL,
  PRIMARY KEY (`id_jenis_produk`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `tb_jenis_produk` */

insert  into `tb_jenis_produk`(`id_jenis_produk`,`nama_jenis_produk`) values ('DF','Dokumen Filateli'),('KM','Kemasan'),('MC','Merchandise'),('MS','MS'),('PR','Prangko'),('PS','Prisma'),('SHP','SHP'),('SHPSS','SHPSS'),('SS','SS');

/*Table structure for table `tb_mitra` */

DROP TABLE IF EXISTS `tb_mitra`;

CREATE TABLE `tb_mitra` (
  `id_mitra` varchar(5) NOT NULL,
  `nama_mitra` varchar(50) NOT NULL,
  `alamat` varchar(100) DEFAULT NULL,
  `no_telp` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`id_mitra`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 ROW_FORMAT=COMPACT;

/*Data for the table `tb_mitra` */

insert  into `tb_mitra`(`id_mitra`,`nama_mitra`,`alamat`,`no_telp`) values ('gg21','gudang jabar','jl. sekeloa','0223981974'),('pr092','Peruri','','');

/*Table structure for table `tb_produk` */

DROP TABLE IF EXISTS `tb_produk`;

CREATE TABLE `tb_produk` (
  `id_produk` varchar(11) NOT NULL,
  `nama_produk` varchar(100) NOT NULL,
  `nominal` int(11) NOT NULL,
  `biaya_cetak` float NOT NULL,
  `stok` int(11) NOT NULL,
  `tahun` varchar(4) NOT NULL,
  `id_jenis_produk` varchar(5) NOT NULL,
  `nik` varchar(12) NOT NULL,
  `status` varchar(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id_produk`),
  KEY `fk_id_jenis_produk` (`id_jenis_produk`),
  KEY `idx_nama` (`nama_produk`),
  KEY `idx_nominal` (`nominal`),
  KEY `idx_tahun` (`tahun`),
  KEY `fk_nik` (`nik`),
  CONSTRAINT `fk_id_jenis_produk` FOREIGN KEY (`id_jenis_produk`) REFERENCES `tb_jenis_produk` (`id_jenis_produk`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_nik` FOREIGN KEY (`nik`) REFERENCES `tb_user` (`nik`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `tb_produk` */

insert  into `tb_produk`(`id_produk`,`nama_produk`,`nominal`,`biaya_cetak`,`stok`,`tahun`,`id_jenis_produk`,`nik`,`status`) values ('DF000000001','dokumen filateli 1',12000,10000,0,'2017','DF','10114279','0'),('DF000000002','df 2',1200,1000,0,'2017','DF','10114279','0'),('KM000000001','kemasan 1',1500,1200,0,'2017','KM','10114279','0'),('KM000000002','kemasan 2',1000,800,0,'2017','KM','10114279','0'),('MC000000001','merchndise 1',5000,4600,0,'2017','MC','10114279','0'),('MC000000002','mc 2',10000,1000,0,'2017','MC','10114279','0'),('MS000000001','ms 1',5000,4500,0,'2017','MS','10114279','0'),('MS000000002','ms 1',5000,4500,0,'2018','MS','10114279','0'),('PR000000001','prangko 11',1500,1200,220,'2017','PR','10114279','0'),('PR000000002','prangko 23',1500,800,0,'2017','PR','10114279','0'),('PR000000003','prangko 2',1000,800,0,'2018','PR','10114279','1'),('PR000000004','prangko 1',2000,1700,1300,'2017','PR','10114279','0'),('PR000000005','prangko 1',2500,2200,0,'2019','PR','10114279','0'),('PR000000006','prangko 6',1200,700.34,7,'2018','PR','10114279','0'),('PS000000001','prisma 1',4000,3600,0,'2017','PS','10114279','0'),('PS000000002','pr 2',5000,4500,0,'2017','PS','10114279','0'),('SHP00000001','shp 1',1500,1200,0,'2017','SHP','10114279','0'),('SHPSS000001','shpss 1',5000,4500,0,'2017','SHPSS','10114279','0'),('SS000000001','ss 1',4500,4300,0,'2017','SS','10114279','0');

/*Table structure for table `tb_regional` */

DROP TABLE IF EXISTS `tb_regional`;

CREATE TABLE `tb_regional` (
  `id_regional` varchar(3) NOT NULL,
  `regional` varchar(100) NOT NULL,
  `kode_pos` varchar(5) NOT NULL,
  `no_telp` varchar(9) DEFAULT NULL,
  `alamat` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id_regional`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `tb_regional` */

insert  into `tb_regional`(`id_regional`,`regional`,`kode_pos`,`no_telp`,`alamat`) values ('AMT','AMUNTAI','71400',NULL,NULL);

/*Table structure for table `tb_trans_pemesanan` */

DROP TABLE IF EXISTS `tb_trans_pemesanan`;

CREATE TABLE `tb_trans_pemesanan` (
  `id_pemesanan` varchar(10) NOT NULL,
  `no_pemesanan` varchar(10) NOT NULL,
  `id_produk` varchar(11) NOT NULL,
  `jumlah_pesan` int(11) NOT NULL,
  `tgl_pesan` date NOT NULL,
  `id_mitra` varchar(5) NOT NULL,
  `status` varchar(15) NOT NULL,
  PRIMARY KEY (`id_pemesanan`),
  KEY `fk_id_produk_pemesanan` (`id_produk`),
  KEY `fk_id_mitra_pemesanan` (`id_mitra`),
  CONSTRAINT `fk_id_mitra_pemesanan` FOREIGN KEY (`id_mitra`) REFERENCES `tb_mitra` (`id_mitra`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_id_produk_pemesanan` FOREIGN KEY (`id_produk`) REFERENCES `tb_produk` (`id_produk`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `tb_trans_pemesanan` */

insert  into `tb_trans_pemesanan`(`id_pemesanan`,`no_pemesanan`,`id_produk`,`jumlah_pesan`,`tgl_pesan`,`id_mitra`,`status`) values ('0000000001','0000000001','PR000000001',10000,'2018-01-06','gg21','belum selesai'),('0000000002','0000000002','SS000000001',10000,'2018-01-06','gg21','belum selesai'),('0000000003','0000000002','PR000000003',20000,'2018-01-06','gg21','belum selesai'),('0000000004','0000000002','PR000000002',20000,'2018-01-06','gg21','belum selesai'),('0000000005','0000000002','MS000000001',1000,'2018-01-06','gg21','belum selesai'),('0000000006','0000000002','PR000000005',10000,'2018-01-06','gg21','belum selesai'),('0000000007','0000000003','PR000000003',2000,'2018-01-06','gg21','belum selesai'),('0000000008','0000000003','PR000000001',1000,'2018-01-06','gg21','belum selesai'),('0000000009','0000000004','PR000000002',5000,'2018-01-06','gg21','belum selesai'),('0000000010','0000000004','PR000000004',2000,'2018-01-06','gg21','belum selesai'),('0000000011','0000000005','PR000000004',1000,'2018-01-06','gg21','belum selesai'),('0000000012','0000000006','PR000000005',4000,'2018-01-06','pr092','belum selesai'),('0000000013','0000000007','MS000000001',1000,'2018-01-12','gg21','belum selesai'),('0000000014','0000000008','SHP00000001',7000,'2018-01-06','gg21','belum selesai'),('0000000015','0000000009','SS000000001',7000,'2018-01-06','gg21','belum selesai'),('0000000016','0000000010','PR000000004',10000,'2018-01-22','gg21','belum selesai'),('0000000017','0000000011','PR000000006',20000,'2018-01-22','pr092','belum selesai');

/*Table structure for table `tb_trans_penerimaan` */

DROP TABLE IF EXISTS `tb_trans_penerimaan`;

CREATE TABLE `tb_trans_penerimaan` (
  `id_penerimaan` varchar(10) NOT NULL,
  `no_order_penerimaan` varchar(14) NOT NULL,
  `tgl_penerimaan` date NOT NULL,
  `jml_terima` int(11) NOT NULL,
  `id_pemesanan` varchar(10) NOT NULL,
  `id_produk` varchar(11) NOT NULL,
  `id_mitra` varchar(8) NOT NULL,
  `stok_awal` int(11) NOT NULL,
  `stok_akhir` int(11) NOT NULL,
  `subtotal_terima` int(11) NOT NULL,
  `sisa_belum_dikirim` int(11) NOT NULL,
  `keterangan` text,
  PRIMARY KEY (`id_penerimaan`),
  KEY `fk_id_produk_penerimaan` (`id_pemesanan`),
  KEY `fk_id_suplier_penerimaan` (`id_mitra`),
  KEY `fk_id_produk_terima` (`id_produk`),
  CONSTRAINT `fk_id_mitra` FOREIGN KEY (`id_mitra`) REFERENCES `tb_mitra` (`id_mitra`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_id_pemesanan` FOREIGN KEY (`id_pemesanan`) REFERENCES `tb_trans_pemesanan` (`id_pemesanan`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_id_produk_terima` FOREIGN KEY (`id_produk`) REFERENCES `tb_produk` (`id_produk`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `tb_trans_penerimaan` */

insert  into `tb_trans_penerimaan`(`id_penerimaan`,`no_order_penerimaan`,`tgl_penerimaan`,`jml_terima`,`id_pemesanan`,`id_produk`,`id_mitra`,`stok_awal`,`stok_akhir`,`subtotal_terima`,`sisa_belum_dikirim`,`keterangan`) values ('0000000001','a-aaaa-aa-aaaa','2018-01-22',1000,'0000000010','PR000000004','gg21',2000,3000,1000,1000,'');

/*Table structure for table `tb_trans_pengembalian` */

DROP TABLE IF EXISTS `tb_trans_pengembalian`;

CREATE TABLE `tb_trans_pengembalian` (
  `id_pengembalian` varchar(10) NOT NULL,
  `tgl_pengembalian` date NOT NULL,
  `jml_pengembalian` int(11) NOT NULL,
  `dus` smallint(6) DEFAULT NULL,
  `id_regional` varchar(5) NOT NULL,
  `id_produk` varchar(11) NOT NULL,
  `stok_awal` int(11) NOT NULL,
  `stok_akhir` int(11) NOT NULL,
  `keterangan` text,
  PRIMARY KEY (`id_pengembalian`),
  KEY `fk_id_reg_pengembalian` (`id_regional`),
  KEY `fk_id_produk` (`id_produk`),
  CONSTRAINT `fk_id_produk` FOREIGN KEY (`id_produk`) REFERENCES `tb_produk` (`id_produk`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_id_regional` FOREIGN KEY (`id_regional`) REFERENCES `tb_regional` (`id_regional`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `tb_trans_pengembalian` */

insert  into `tb_trans_pengembalian`(`id_pengembalian`,`tgl_pengembalian`,`jml_pengembalian`,`dus`,`id_regional`,`id_produk`,`stok_awal`,`stok_akhir`,`keterangan`) values ('0000000001','2018-01-06',250,21,'AMT','PR000000001',750,1000,NULL),('0000000002','2018-01-22',300,10,'AMT','PR000000004',3000,3300,''),('0000000003','2018-02-05',7,NULL,'AMT','PR000000006',0,7,NULL);

/*Table structure for table `tb_trans_pengiriman` */

DROP TABLE IF EXISTS `tb_trans_pengiriman`;

CREATE TABLE `tb_trans_pengiriman` (
  `id_pengiriman` varchar(10) NOT NULL,
  `no_order_pengiriman` varchar(12) NOT NULL,
  `tgl_pengiriman` date NOT NULL,
  `jml_pengiriman` int(11) NOT NULL,
  `bsu` double NOT NULL,
  `id_regional` varchar(5) NOT NULL,
  `id_produk` varchar(11) NOT NULL,
  `stok_awal` int(11) NOT NULL,
  `stok_akhir` int(11) NOT NULL,
  PRIMARY KEY (`id_pengiriman`),
  KEY `fk_id_produk_pengeluaran` (`id_produk`),
  KEY `fk_id_reg_pengeluaran` (`id_regional`),
  CONSTRAINT `fk_id_produk_pengiriman` FOREIGN KEY (`id_produk`) REFERENCES `tb_produk` (`id_produk`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_id_regional_pengiriman` FOREIGN KEY (`id_regional`) REFERENCES `tb_regional` (`id_regional`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1 ROW_FORMAT=COMPACT;

/*Data for the table `tb_trans_pengiriman` */

insert  into `tb_trans_pengiriman`(`id_pengiriman`,`no_order_pengiriman`,`tgl_pengiriman`,`jml_pengiriman`,`bsu`,`id_regional`,`id_produk`,`stok_awal`,`stok_akhir`) values ('0000000001','5','2018-01-20',10,15000,'AMT','PR000000001',1000,990),('0000000002','12','2018-01-20',20,30000,'AMT','PR000000001',990,970);

/*Table structure for table `tb_user` */

DROP TABLE IF EXISTS `tb_user`;

CREATE TABLE `tb_user` (
  `nik` varchar(12) NOT NULL,
  `password` varchar(30) NOT NULL,
  `nama_user` varchar(50) NOT NULL,
  `hak_akses` varchar(2) NOT NULL,
  `status` varchar(1) NOT NULL DEFAULT '0',
  `penyimpanan` varchar(150) DEFAULT NULL,
  PRIMARY KEY (`nik`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `tb_user` */

insert  into `tb_user`(`nik`,`password`,`nama_user`,`hak_akses`,`status`,`penyimpanan`) values ('10114279','10114279','Muhamad Solahudin','FL','0','D:\\'),('10114280','10114280','Reyhan Audian D.P.','AD','0',NULL);

/* Trigger structure for table `tb_trans_penerimaan` */

DELIMITER $$

/*!50003 DROP TRIGGER*//*!50032 IF EXISTS */ /*!50003 `update_stok_penerimaan` */$$

/*!50003 CREATE */ /*!50017 DEFINER = 'root'@'localhost' */ /*!50003 TRIGGER `update_stok_penerimaan` AFTER INSERT ON `tb_trans_penerimaan` FOR EACH ROW BEGIN
	UPDATE tb_produk SET tb_produk.stok=NEW.stok_akhir WHERE tb_produk.id_produk = NEW.id_produk;
    IF(NEW.sisa_belum_dikirim=0) THEN
    UPDATE tb_trans_pemesanan 
    SET tb_trans_pemesanan.status='selesai' WHERE id_pemesanan=NEW.id_pemesanan;
    END IF;
END */$$


DELIMITER ;

/* Trigger structure for table `tb_trans_pengembalian` */

DELIMITER $$

/*!50003 DROP TRIGGER*//*!50032 IF EXISTS */ /*!50003 `update_stok_pengembalian` */$$

/*!50003 CREATE */ /*!50017 DEFINER = 'root'@'localhost' */ /*!50003 TRIGGER `update_stok_pengembalian` AFTER INSERT ON `tb_trans_pengembalian` FOR EACH ROW BEGIN
	UPDATE tb_produk SET tb_produk.stok=NEW.stok_akhir WHERE tb_produk.id_produk=NEW.id_produk;
END */$$


DELIMITER ;

/* Trigger structure for table `tb_trans_pengiriman` */

DELIMITER $$

/*!50003 DROP TRIGGER*//*!50032 IF EXISTS */ /*!50003 `update_stok_pengiriman` */$$

/*!50003 CREATE */ /*!50017 DEFINER = 'root'@'localhost' */ /*!50003 TRIGGER `update_stok_pengiriman` AFTER INSERT ON `tb_trans_pengiriman` FOR EACH ROW BEGIN
	UPDATE tb_produk SET tb_produk.stok=NEW.stok_akhir WHERE
    tb_produk.id_produk=NEW.id_produk;
END */$$


DELIMITER ;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
