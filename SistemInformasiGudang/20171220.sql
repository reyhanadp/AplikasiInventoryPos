-- MySQL dump 10.16  Distrib 10.1.22-MariaDB, for Win32 (AMD64)
--
-- Host: localhost    Database: db_inventory_pos
-- ------------------------------------------------------
-- Server version	10.1.22-MariaDB

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `tb_hapus_produk`
--

DROP TABLE IF EXISTS `tb_hapus_produk`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_hapus_produk` (
  `id_produk` varchar(8) NOT NULL,
  `nama_produk` varchar(100) DEFAULT NULL,
  `nominal` int(11) DEFAULT NULL,
  `biaya_cetak` float DEFAULT NULL,
  `stok` int(11) DEFAULT NULL,
  `tahun` year(4) DEFAULT NULL,
  `id_jenis_produk` varchar(5) DEFAULT NULL,
  `tgl_penghapusan` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id_produk`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_hapus_produk`
--

LOCK TABLES `tb_hapus_produk` WRITE;
/*!40000 ALTER TABLE `tb_hapus_produk` DISABLE KEYS */;
INSERT INTO `tb_hapus_produk` VALUES ('',NULL,NULL,NULL,NULL,NULL,NULL,'2017-08-28 23:55:21'),('PR005','pangko 5',2000,1500,0,2011,'PR','2017-08-28 19:22:47'),('PR006','prangko6',0,0,0,2010,'PR','2017-08-27 23:32:23'),('PR007','prangko 7',1000,700,0,2009,'PR','2017-08-27 23:44:47'),('PR008','prengk',0,0,0,2000,'PR','2017-08-28 00:47:50'),('PR013','prangko 13',3000,2500,0,2017,'PR','2017-12-18 09:03:50'),('PR014','hjgjhg',123123,0,0,2017,'PR','2017-12-18 08:55:16'),('PR015','34245',2353250,657569000,0,2017,'PR','2017-12-18 09:03:33');
/*!40000 ALTER TABLE `tb_hapus_produk` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_history_pengembalian`
--

DROP TABLE IF EXISTS `tb_history_pengembalian`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_history_pengembalian` (
  `id_pengembalian` varchar(7) NOT NULL,
  `tgl_pengembalian` date DEFAULT NULL,
  `stok_awal` int(11) DEFAULT NULL,
  `jml_pengembalian` int(11) DEFAULT NULL,
  `dus` smallint(6) DEFAULT NULL,
  `id_regional` varchar(5) DEFAULT NULL,
  `id_produk` varchar(8) DEFAULT NULL,
  `stok_akhir` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_history_pengembalian`
--

LOCK TABLES `tb_history_pengembalian` WRITE;
/*!40000 ALTER TABLE `tb_history_pengembalian` DISABLE KEYS */;
/*!40000 ALTER TABLE `tb_history_pengembalian` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_jenis_produk`
--

DROP TABLE IF EXISTS `tb_jenis_produk`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_jenis_produk` (
  `id_jenis_produk` varchar(5) NOT NULL,
  `nama_jenis_produk` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id_jenis_produk`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_jenis_produk`
--

LOCK TABLES `tb_jenis_produk` WRITE;
/*!40000 ALTER TABLE `tb_jenis_produk` DISABLE KEYS */;
INSERT INTO `tb_jenis_produk` VALUES ('DF','Dokumen Filateli'),('KM','Kemasan'),('MC','Merchandise'),('MS','MS'),('PR','Prangko'),('PS','Prisma'),('SHP','SHP'),('SHPSS','SHPSS'),('SS','SS');
/*!40000 ALTER TABLE `tb_jenis_produk` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_pemesanan`
--

DROP TABLE IF EXISTS `tb_pemesanan`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_pemesanan` (
  `no_pemesanan` varchar(5) NOT NULL,
  `id_produk` varchar(8) DEFAULT NULL,
  `jumlah_pesan` int(11) DEFAULT NULL,
  `tgl_pesan` date DEFAULT NULL,
  `id_suplier` varchar(5) NOT NULL,
  `status` varchar(15) NOT NULL,
  PRIMARY KEY (`no_pemesanan`),
  KEY `fk_id_produk_pemesanan` (`id_produk`),
  CONSTRAINT `fk_id_produk_pemesanan` FOREIGN KEY (`id_produk`) REFERENCES `tb_produk` (`id_produk`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_pemesanan`
--

LOCK TABLES `tb_pemesanan` WRITE;
/*!40000 ALTER TABLE `tb_pemesanan` DISABLE KEYS */;
INSERT INTO `tb_pemesanan` VALUES ('00001','PR011',2000,'2017-10-14','gg21','selesai'),('00002','MC003',3000,'2017-10-14','gg21','selesai'),('00003','MS002',10000,'2017-10-18','gg21','selesai'),('00004','PR004',500,'2017-11-16','gg21','belum selesai'),('00005','KM001',1000,'2017-11-18','gg21','belum selesai'),('00006','PS001',2000,'2017-11-17','gg21','belum selesai'),('00007','DF001',500,'2017-11-18','gg21','belum selesai'),('00008','SHP001',10000,'2017-11-18','gg21','belum selesai'),('00009','SHPSS001',5000,'2017-11-18','gg21','belum selesai'),('00010','MC002',10000,'2017-11-18','gg21','belum selesai'),('00011','SHP001',1000,'2017-12-07','gg21','belum selesai'),('00012','MS001',1000,'2017-12-07','gg21','belum selesai'),('00013','PR010',1000,'2017-12-09','gg21','belum selesai');
/*!40000 ALTER TABLE `tb_pemesanan` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_produk`
--

DROP TABLE IF EXISTS `tb_produk`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_produk` (
  `id_produk` varchar(8) NOT NULL,
  `nama_produk` varchar(100) DEFAULT NULL,
  `nominal` int(11) DEFAULT NULL,
  `biaya_cetak` float DEFAULT NULL,
  `stok` int(11) DEFAULT NULL,
  `tahun` varchar(4) DEFAULT NULL,
  `id_jenis_produk` varchar(5) DEFAULT NULL,
  PRIMARY KEY (`id_produk`),
  KEY `fk_id_jenis_produk` (`id_jenis_produk`),
  CONSTRAINT `fk_id_jenis_produk` FOREIGN KEY (`id_jenis_produk`) REFERENCES `tb_jenis_produk` (`id_jenis_produk`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_produk`
--

LOCK TABLES `tb_produk` WRITE;
/*!40000 ALTER TABLE `tb_produk` DISABLE KEYS */;
INSERT INTO `tb_produk` VALUES ('DF001','df 1',1000,500,1500,'2010','DF'),('KM001','prakem 1',3000,2500,1500,'2010','KM'),('KM002','kemasan 2',2000,1200,1500,'2011','KM'),('MC001','mc 1',100,10,1500,'2001','MC'),('MC002','nc 2',2000,1200,1500,'2002','MC'),('MC003','merchandise 3',3000,2000,1500,'2010','MC'),('MS001','ms 1',1000,500,1500,'2010','MS'),('MS002','MS 2',1500,1000,1000,'2010','MS'),('PR001','prangko 1',0,1000,1100,'2000','PR'),('PR002','prangko 2',1000,500,1500,'2010','PR'),('PR003','prangko 3',1000,200,1500,'2010','PR'),('PR004','Prangko 4',5000,1000,1500,'2010','PR'),('PR009','prangko 98',2000,1000,1500,'2009','PR'),('PR010','prangko 10',2000,1500,1000,'2010','PR'),('PR011','prangko 11',1500,1000,1000,'2010','PR'),('PR012','prangko 10',2500,2100,0,'2010','PR'),('PS001','pr 1',1000,200,1500,'2010','PS'),('SHP001','shp01',2000,1000,1500,'2010','SHP'),('SHPSS001','shpss017',1000,500,1500,'2011','SHPSS'),('SS001','ss 1',2000,1200,1500,'2011','SS'),('SS002','sci 2',1000,800,1500,'2000','SS');
/*!40000 ALTER TABLE `tb_produk` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_AUTO_VALUE_ON_ZERO' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `history_update_produk` AFTER UPDATE ON `tb_produk` FOR EACH ROW BEGIN

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

    END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_AUTO_VALUE_ON_ZERO' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `history_hapus_produk` AFTER DELETE ON `tb_produk` FOR EACH ROW BEGIN

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

    END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `tb_regional`
--

DROP TABLE IF EXISTS `tb_regional`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_regional` (
  `id_regional` varchar(3) NOT NULL,
  `regional` varchar(100) DEFAULT NULL,
  `kode_pos` varchar(5) DEFAULT NULL,
  `no_telp` varchar(9) DEFAULT NULL,
  `alamat` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id_regional`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_regional`
--

LOCK TABLES `tb_regional` WRITE;
/*!40000 ALTER TABLE `tb_regional` DISABLE KEYS */;
INSERT INTO `tb_regional` VALUES ('AMT','AMUNTAI','71400',NULL,NULL);
/*!40000 ALTER TABLE `tb_regional` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_suplier`
--

DROP TABLE IF EXISTS `tb_suplier`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_suplier` (
  `id_suplier` varchar(5) NOT NULL,
  `nama_suplier` varchar(50) DEFAULT NULL,
  `alamat` varchar(100) DEFAULT NULL,
  `no_telp` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`id_suplier`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_suplier`
--

LOCK TABLES `tb_suplier` WRITE;
/*!40000 ALTER TABLE `tb_suplier` DISABLE KEYS */;
INSERT INTO `tb_suplier` VALUES ('gg21','gudang jabar','jl. sekeloa','0223981974');
/*!40000 ALTER TABLE `tb_suplier` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_trans_penerimaan`
--

DROP TABLE IF EXISTS `tb_trans_penerimaan`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_trans_penerimaan` (
  `no_order_penerimaan` varchar(4) NOT NULL,
  `tgl_penerimaan` date DEFAULT NULL,
  `jml_terima` int(11) DEFAULT NULL,
  `no_pemesanan` varchar(5) DEFAULT NULL,
  `id_produk` varchar(8) NOT NULL,
  `id_suplier` varchar(5) DEFAULT NULL,
  `stok_awal` int(11) DEFAULT NULL,
  `stok_akhir` int(11) DEFAULT NULL,
  `subtotal_terima` int(11) DEFAULT NULL,
  `sisa_belum_dikirim` int(11) DEFAULT NULL,
  `keterangan` text NOT NULL,
  PRIMARY KEY (`no_order_penerimaan`),
  KEY `fk_id_produk_penerimaan` (`no_pemesanan`),
  KEY `fk_id_suplier_penerimaan` (`id_suplier`),
  KEY `fk_id_produk_terima` (`id_produk`),
  CONSTRAINT `fk_id_produk_terima` FOREIGN KEY (`id_produk`) REFERENCES `tb_produk` (`id_produk`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_id_suplier` FOREIGN KEY (`id_suplier`) REFERENCES `tb_suplier` (`id_suplier`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_no_pemesanan` FOREIGN KEY (`no_pemesanan`) REFERENCES `tb_pemesanan` (`no_pemesanan`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_trans_penerimaan`
--

LOCK TABLES `tb_trans_penerimaan` WRITE;
/*!40000 ALTER TABLE `tb_trans_penerimaan` DISABLE KEYS */;
INSERT INTO `tb_trans_penerimaan` VALUES ('1','2017-11-01',3000,'00002','MC003','gg21',0,3000,3000,0,''),('111','2017-10-27',1000,'00001','PR011','gg21',0,1000,1000,1000,''),('112','2017-10-28',500,'00001','PR011','gg21',1000,1500,1500,500,'ya\ngitu'),('113','2017-11-01',1000,'00001','PR011','gg21',10000,11000,2000,0,''),('115','2017-12-10',500,'00013','PR010','gg21',1000,1500,500,500,''),('12','2017-11-01',10000,'00003','MS002','gg21',0,10000,10000,0,''),('13','2017-11-19',250,'00004','PR004','gg21',0,250,250,250,''),('14','2017-11-19',500,'00008','SHP001','gg21',0,500,500,9500,''),('15','2017-11-19',200,'00005','KM001','gg21',0,200,200,800,''),('16','2017-11-19',1000,'00010','MC002','gg21',0,1000,1000,9000,''),('2','2017-11-20',1000,'00010','MC002','gg21',1000,2000,2000,8000,''),('3','2017-11-20',200,'00007','DF001','gg21',0,200,200,300,''),('4','2017-11-20',250,'00005','KM001','gg21',200,450,450,550,''),('6','2017-11-20',1000,'00006','PS001','gg21',0,1000,1000,1000,''),('asd','2017-12-11',0,'00013','PR010','gg21',1000,1000,0,1000,'');
/*!40000 ALTER TABLE `tb_trans_penerimaan` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_AUTO_VALUE_ON_ZERO' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `update_stok_penerimaan` AFTER INSERT ON `tb_trans_penerimaan` FOR EACH ROW BEGIN
	UPDATE tb_produk SET tb_produk.stok=NEW.stok_akhir;
    IF(NEW.sisa_belum_dikirim=0) THEN
    UPDATE tb_pemesanan 
    SET tb_pemesanan.status='selesai' WHERE no_pemesanan=NEW.no_pemesanan;
    END IF;
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `tb_trans_pengembalian`
--

DROP TABLE IF EXISTS `tb_trans_pengembalian`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_trans_pengembalian` (
  `id_pengembalian` varchar(7) NOT NULL,
  `tgl_pengembalian` date DEFAULT NULL,
  `jml_pengembalian` int(11) DEFAULT NULL,
  `dus` smallint(6) DEFAULT NULL,
  `id_regional` varchar(5) DEFAULT NULL,
  `id_produk` varchar(8) DEFAULT NULL,
  `stok_awal` int(11) DEFAULT NULL,
  `stok_akhir` int(11) DEFAULT NULL,
  `keterangan` text,
  PRIMARY KEY (`id_pengembalian`),
  KEY `fk_id_reg_pengembalian` (`id_regional`),
  KEY `fk_id_produk_pengembalian` (`id_produk`),
  CONSTRAINT `fk_id_produk_pengembalian` FOREIGN KEY (`id_produk`) REFERENCES `tb_produk` (`id_produk`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_id_reg_pengembalian` FOREIGN KEY (`id_regional`) REFERENCES `tb_regional` (`id_regional`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_trans_pengembalian`
--

LOCK TABLES `tb_trans_pengembalian` WRITE;
/*!40000 ALTER TABLE `tb_trans_pengembalian` DISABLE KEYS */;
INSERT INTO `tb_trans_pengembalian` VALUES ('00001','2017-11-18',500,90,'AMT','PR003',1000,1500,'banyak banget dah'),('00002','2017-11-04',146,90,'AMT','PR003',1500,1646,'aihoioiewrfwepomwoergmnorgoerjgoermngoiremngoieirmgoiermngoimeroigeorimgoeirmgoiermgoiermgoiremgoiemroigmeroigmeroimgoewfwefwefwefwef');
/*!40000 ALTER TABLE `tb_trans_pengembalian` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_AUTO_VALUE_ON_ZERO' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `update_stok_pengembalian` AFTER INSERT ON `tb_trans_pengembalian` FOR EACH ROW BEGIN
	UPDATE tb_produk SET tb_produk.stok=NEW.stok_akhir WHERE tb_produk.id_produk=NEW.id_produk;
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `tb_trans_pengiriman`
--

DROP TABLE IF EXISTS `tb_trans_pengiriman`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_trans_pengiriman` (
  `id_pengiriman` varchar(5) NOT NULL,
  `no_order_pengiriman` varchar(7) NOT NULL,
  `tgl_pengiriman` date DEFAULT NULL,
  `jml_pengiriman` int(11) DEFAULT NULL,
  `bsu` varchar(12) DEFAULT NULL,
  `id_regional` varchar(5) DEFAULT NULL,
  `id_produk` varchar(8) DEFAULT NULL,
  `stok_awal` int(11) DEFAULT NULL,
  `stok_akhir` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_pengiriman`),
  KEY `fk_id_produk_pengeluaran` (`id_produk`),
  KEY `fk_id_reg_pengeluaran` (`id_regional`),
  CONSTRAINT `fi_id_produk_pengiriman` FOREIGN KEY (`id_produk`) REFERENCES `tb_produk` (`id_produk`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_id_reg_pengeluaran` FOREIGN KEY (`id_regional`) REFERENCES `tb_regional` (`id_regional`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1 ROW_FORMAT=COMPACT;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_trans_pengiriman`
--

LOCK TABLES `tb_trans_pengiriman` WRITE;
/*!40000 ALTER TABLE `tb_trans_pengiriman` DISABLE KEYS */;
INSERT INTO `tb_trans_pengiriman` VALUES ('00001','12314','2017-12-10',500,'750000','AMT','MS002',1500,1000),('00002','34235','2017-12-09',400,'0','AMT','PR001',1500,1100),('00003','3312','2017-12-14',500,'1000000','AMT','PR010',1500,1000),('00004','3312','2017-12-14',500,'750000','AMT','PR011',1500,1000);
/*!40000 ALTER TABLE `tb_trans_pengiriman` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_AUTO_VALUE_ON_ZERO' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `update_stok_pengiriman` AFTER INSERT ON `tb_trans_pengiriman` FOR EACH ROW BEGIN
	UPDATE tb_produk SET tb_produk.stok=NEW.stok_akhir WHERE
    tb_produk.id_produk=NEW.id_produk;
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `tb_update_produk`
--

DROP TABLE IF EXISTS `tb_update_produk`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_update_produk` (
  `id_produk` varchar(8) NOT NULL,
  `nama_produk` varchar(100) DEFAULT NULL,
  `nominal` int(11) DEFAULT NULL,
  `biaya_cetak` float DEFAULT NULL,
  `stok` int(11) DEFAULT NULL,
  `tahun` year(4) DEFAULT NULL,
  `id_jenis_produk` varchar(5) DEFAULT NULL,
  `tgl_update` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_update_produk`
--

LOCK TABLES `tb_update_produk` WRITE;
/*!40000 ALTER TABLE `tb_update_produk` DISABLE KEYS */;
INSERT INTO `tb_update_produk` VALUES ('PR003','prangko 3',1000,200,10,2011,'PR','2017-08-21 00:23:37'),('PR003','prangko 3',1500,200,10,2011,'PR','2017-08-22 23:34:57'),('PR003','prangko 3',1000,200,10,2010,'PR','2017-08-22 23:38:40'),('PR009','prangko 9',2000,1000,0,2009,'PR','2017-08-28 19:22:30'),('DF001','df 1',1000,500,0,2010,'DF','2017-10-28 08:08:24'),('KM001','prakem 1',3000,2500,0,2010,'KM','2017-10-28 08:08:24'),('KM002','kemasan 2',2000,1200,0,2011,'KM','2017-10-28 08:08:24'),('MC001','mc 1',100,10,0,2001,'MC','2017-10-28 08:08:24'),('MC002','nc 2',2000,1200,0,2002,'MC','2017-10-28 08:08:24'),('MC003','merchandise 3',3000,2000,0,2010,'MC','2017-10-28 08:08:24'),('MS001','ms 1',1000,500,0,2010,'MS','2017-10-28 08:08:24'),('MS002','MS 2',1500,1000,0,2010,'MS','2017-10-28 08:08:24'),('PR001','prangko 1',0,1000,0,2000,'PR','2017-10-28 08:08:24'),('PR002','prangko 2',1000,500,0,2010,'PR','2017-10-28 08:08:24'),('PR003','prangko 3',1000,200,10,2010,'PR','2017-10-28 08:08:24'),('PR004','Prangko 4',5000,1000,0,2010,'PR','2017-10-28 08:08:24'),('PR009','prangko 98',2000,1000,0,2009,'PR','2017-10-28 08:08:24'),('PR010','prangko 10',2000,1500,0,2010,'PR','2017-10-28 08:08:24'),('PR011','prangko 11',1500,1000,0,2010,'PR','2017-10-28 08:08:24'),('PS001','pr 1',1000,200,0,2010,'PS','2017-10-28 08:08:24'),('SHP001','shp01',2000,1000,0,2010,'SHP','2017-10-28 08:08:24'),('SHPSS00','shpss017',1000,500,0,2011,'SHPSS','2017-10-28 08:08:24'),('SS001','ss 1',2000,1200,0,2011,'SS','2017-10-28 08:08:24'),('SS002','sci 2',1000,800,0,2000,'SS','2017-10-28 08:08:24'),('DF001','df 1',1000,500,1000,2010,'DF','2017-10-28 08:11:42'),('KM001','prakem 1',3000,2500,1000,2010,'KM','2017-10-28 08:11:42'),('KM002','kemasan 2',2000,1200,1000,2011,'KM','2017-10-28 08:11:42'),('MC001','mc 1',100,10,1000,2001,'MC','2017-10-28 08:11:42'),('MC002','nc 2',2000,1200,1000,2002,'MC','2017-10-28 08:11:42'),('MC003','merchandise 3',3000,2000,1000,2010,'MC','2017-10-28 08:11:42'),('MS001','ms 1',1000,500,1000,2010,'MS','2017-10-28 08:11:42'),('MS002','MS 2',1500,1000,1000,2010,'MS','2017-10-28 08:11:42'),('PR001','prangko 1',0,1000,1000,2000,'PR','2017-10-28 08:11:42'),('PR002','prangko 2',1000,500,1000,2010,'PR','2017-10-28 08:11:42'),('PR003','prangko 3',1000,200,1000,2010,'PR','2017-10-28 08:11:42'),('PR004','Prangko 4',5000,1000,1000,2010,'PR','2017-10-28 08:11:42'),('PR009','prangko 98',2000,1000,1000,2009,'PR','2017-10-28 08:11:42'),('PR010','prangko 10',2000,1500,1000,2010,'PR','2017-10-28 08:11:42'),('PR011','prangko 11',1500,1000,1000,2010,'PR','2017-10-28 08:11:42'),('PS001','pr 1',1000,200,1000,2010,'PS','2017-10-28 08:11:42'),('SHP001','shp01',2000,1000,1000,2010,'SHP','2017-10-28 08:11:42'),('SHPSS00','shpss017',1000,500,1000,2011,'SHPSS','2017-10-28 08:11:42'),('SS001','ss 1',2000,1200,1000,2011,'SS','2017-10-28 08:11:42'),('SS002','sci 2',1000,800,1000,2000,'SS','2017-10-28 08:11:42'),('DF001','df 1',1000,500,1500,2010,'DF','2017-11-01 05:42:42'),('KM001','prakem 1',3000,2500,1500,2010,'KM','2017-11-01 05:42:42'),('KM002','kemasan 2',2000,1200,1500,2011,'KM','2017-11-01 05:42:42'),('MC001','mc 1',100,10,1500,2001,'MC','2017-11-01 05:42:42'),('MC002','nc 2',2000,1200,1500,2002,'MC','2017-11-01 05:42:42'),('MC003','merchandise 3',3000,2000,1500,2010,'MC','2017-11-01 05:42:42'),('MS001','ms 1',1000,500,1500,2010,'MS','2017-11-01 05:42:42'),('MS002','MS 2',1500,1000,1500,2010,'MS','2017-11-01 05:42:42'),('PR001','prangko 1',0,1000,1500,2000,'PR','2017-11-01 05:42:42'),('PR002','prangko 2',1000,500,1500,2010,'PR','2017-11-01 05:42:42'),('PR003','prangko 3',1000,200,1500,2010,'PR','2017-11-01 05:42:42'),('PR004','Prangko 4',5000,1000,1500,2010,'PR','2017-11-01 05:42:42'),('PR009','prangko 98',2000,1000,1500,2009,'PR','2017-11-01 05:42:42'),('PR010','prangko 10',2000,1500,1500,2010,'PR','2017-11-01 05:42:42'),('PR011','prangko 11',1500,1000,1500,2010,'PR','2017-11-01 05:42:42'),('PS001','pr 1',1000,200,1500,2010,'PS','2017-11-01 05:42:42'),('SHP001','shp01',2000,1000,1500,2010,'SHP','2017-11-01 05:42:42'),('SHPSS00','shpss017',1000,500,1500,2011,'SHPSS','2017-11-01 05:42:42'),('SS001','ss 1',2000,1200,1500,2011,'SS','2017-11-01 05:42:42'),('SS002','sci 2',1000,800,1500,2000,'SS','2017-11-01 05:42:42'),('DF001','df 1',1000,500,3000,2010,'DF','2017-11-01 05:45:50'),('KM001','prakem 1',3000,2500,3000,2010,'KM','2017-11-01 05:45:50'),('KM002','kemasan 2',2000,1200,3000,2011,'KM','2017-11-01 05:45:50'),('MC001','mc 1',100,10,3000,2001,'MC','2017-11-01 05:45:50'),('MC002','nc 2',2000,1200,3000,2002,'MC','2017-11-01 05:45:50'),('MC003','merchandise 3',3000,2000,3000,2010,'MC','2017-11-01 05:45:50'),('MS001','ms 1',1000,500,3000,2010,'MS','2017-11-01 05:45:50'),('MS002','MS 2',1500,1000,3000,2010,'MS','2017-11-01 05:45:50'),('PR001','prangko 1',0,1000,3000,2000,'PR','2017-11-01 05:45:50'),('PR002','prangko 2',1000,500,3000,2010,'PR','2017-11-01 05:45:50'),('PR003','prangko 3',1000,200,3000,2010,'PR','2017-11-01 05:45:50'),('PR004','Prangko 4',5000,1000,3000,2010,'PR','2017-11-01 05:45:50'),('PR009','prangko 98',2000,1000,3000,2009,'PR','2017-11-01 05:45:50'),('PR010','prangko 10',2000,1500,3000,2010,'PR','2017-11-01 05:45:50'),('PR011','prangko 11',1500,1000,3000,2010,'PR','2017-11-01 05:45:50'),('PS001','pr 1',1000,200,3000,2010,'PS','2017-11-01 05:45:50'),('SHP001','shp01',2000,1000,3000,2010,'SHP','2017-11-01 05:45:50'),('SHPSS00','shpss017',1000,500,3000,2011,'SHPSS','2017-11-01 05:45:50'),('SS001','ss 1',2000,1200,3000,2011,'SS','2017-11-01 05:45:50'),('SS002','sci 2',1000,800,3000,2000,'SS','2017-11-01 05:45:50'),('DF001','df 1',1000,500,10000,2010,'DF','2017-11-01 05:46:37'),('KM001','prakem 1',3000,2500,10000,2010,'KM','2017-11-01 05:46:37'),('KM002','kemasan 2',2000,1200,10000,2011,'KM','2017-11-01 05:46:37'),('MC001','mc 1',100,10,10000,2001,'MC','2017-11-01 05:46:37'),('MC002','nc 2',2000,1200,10000,2002,'MC','2017-11-01 05:46:37'),('MC003','merchandise 3',3000,2000,10000,2010,'MC','2017-11-01 05:46:37'),('MS001','ms 1',1000,500,10000,2010,'MS','2017-11-01 05:46:37'),('MS002','MS 2',1500,1000,10000,2010,'MS','2017-11-01 05:46:37'),('PR001','prangko 1',0,1000,10000,2000,'PR','2017-11-01 05:46:37'),('PR002','prangko 2',1000,500,10000,2010,'PR','2017-11-01 05:46:37'),('PR003','prangko 3',1000,200,10000,2010,'PR','2017-11-01 05:46:37'),('PR004','Prangko 4',5000,1000,10000,2010,'PR','2017-11-01 05:46:37'),('PR009','prangko 98',2000,1000,10000,2009,'PR','2017-11-01 05:46:37'),('PR010','prangko 10',2000,1500,10000,2010,'PR','2017-11-01 05:46:37'),('PR011','prangko 11',1500,1000,10000,2010,'PR','2017-11-01 05:46:37'),('PS001','pr 1',1000,200,10000,2010,'PS','2017-11-01 05:46:37'),('SHP001','shp01',2000,1000,10000,2010,'SHP','2017-11-01 05:46:37'),('SHPSS00','shpss017',1000,500,10000,2011,'SHPSS','2017-11-01 05:46:37'),('SS001','ss 1',2000,1200,10000,2011,'SS','2017-11-01 05:46:37'),('SS002','sci 2',1000,800,10000,2000,'SS','2017-11-01 05:46:37'),('DF001','df 1',1000,500,11000,2010,'DF','2017-11-10 07:38:49'),('KM001','prakem 1',3000,2500,11000,2010,'KM','2017-11-10 07:38:49'),('KM002','kemasan 2',2000,1200,11000,2011,'KM','2017-11-10 07:38:49'),('MC001','mc 1',100,10,11000,2001,'MC','2017-11-10 07:38:49'),('MC002','nc 2',2000,1200,11000,2002,'MC','2017-11-10 07:38:49'),('MC003','merchandise 3',3000,2000,11000,2010,'MC','2017-11-10 07:38:49'),('MS001','ms 1',1000,500,11000,2010,'MS','2017-11-10 07:38:49'),('MS002','MS 2',1500,1000,11000,2010,'MS','2017-11-10 07:38:49'),('PR001','prangko 1',0,1000,11000,2000,'PR','2017-11-10 07:38:49'),('PR002','prangko 2',1000,500,11000,2010,'PR','2017-11-10 07:38:49'),('PR003','prangko 3',1000,200,11000,2010,'PR','2017-11-10 07:38:49'),('PR004','Prangko 4',5000,1000,11000,2010,'PR','2017-11-10 07:38:49'),('PR009','prangko 98',2000,1000,11000,2009,'PR','2017-11-10 07:38:49'),('PR010','prangko 10',2000,1500,11000,2010,'PR','2017-11-10 07:38:49'),('PR011','prangko 11',1500,1000,11000,2010,'PR','2017-11-10 07:38:49'),('PS001','pr 1',1000,200,11000,2010,'PS','2017-11-10 07:38:49'),('SHP001','shp01',2000,1000,11000,2010,'SHP','2017-11-10 07:38:49'),('SHPSS00','shpss017',1000,500,11000,2011,'SHPSS','2017-11-10 07:38:49'),('SS001','ss 1',2000,1200,11000,2011,'SS','2017-11-10 07:38:49'),('SS002','sci 2',1000,800,11000,2000,'SS','2017-11-10 07:38:49'),('DF001','df 1',1000,500,12000,2010,'DF','2017-11-18 07:05:30'),('KM001','prakem 1',3000,2500,12000,2010,'KM','2017-11-18 07:05:30'),('KM002','kemasan 2',2000,1200,12000,2011,'KM','2017-11-18 07:05:30'),('MC001','mc 1',100,10,12000,2001,'MC','2017-11-18 07:05:30'),('MC002','nc 2',2000,1200,12000,2002,'MC','2017-11-18 07:05:30'),('MC003','merchandise 3',3000,2000,12000,2010,'MC','2017-11-18 07:05:30'),('MS001','ms 1',1000,500,12000,2010,'MS','2017-11-18 07:05:30'),('MS002','MS 2',1500,1000,12000,2010,'MS','2017-11-18 07:05:30'),('PR001','prangko 1',0,1000,12000,2000,'PR','2017-11-18 07:05:30'),('PR002','prangko 2',1000,500,12000,2010,'PR','2017-11-18 07:05:30'),('PR003','prangko 3',1000,200,12000,2010,'PR','2017-11-18 07:05:30'),('PR004','Prangko 4',5000,1000,12000,2010,'PR','2017-11-18 07:05:30'),('PR009','prangko 98',2000,1000,12000,2009,'PR','2017-11-18 07:05:30'),('PR010','prangko 10',2000,1500,12000,2010,'PR','2017-11-18 07:05:30'),('PR011','prangko 11',1500,1000,12000,2010,'PR','2017-11-18 07:05:30'),('PS001','pr 1',1000,200,12000,2010,'PS','2017-11-18 07:05:30'),('SHP001','shp01',2000,1000,12000,2010,'SHP','2017-11-18 07:05:30'),('SHPSS00','shpss017',1000,500,12000,2011,'SHPSS','2017-11-18 07:05:30'),('SS001','ss 1',2000,1200,12000,2011,'SS','2017-11-18 07:05:30'),('SS002','sci 2',1000,800,12000,2000,'SS','2017-11-18 07:05:30'),('DF001','df 1',1000,500,250,2010,'DF','2017-11-18 07:29:28'),('KM001','prakem 1',3000,2500,250,2010,'KM','2017-11-18 07:29:28'),('KM002','kemasan 2',2000,1200,250,2011,'KM','2017-11-18 07:29:28'),('MC001','mc 1',100,10,250,2001,'MC','2017-11-18 07:29:28'),('MC002','nc 2',2000,1200,250,2002,'MC','2017-11-18 07:29:28'),('MC003','merchandise 3',3000,2000,250,2010,'MC','2017-11-18 07:29:28'),('MS001','ms 1',1000,500,250,2010,'MS','2017-11-18 07:29:28'),('MS002','MS 2',1500,1000,250,2010,'MS','2017-11-18 07:29:28'),('PR001','prangko 1',0,1000,250,2000,'PR','2017-11-18 07:29:28'),('PR002','prangko 2',1000,500,250,2010,'PR','2017-11-18 07:29:28'),('PR003','prangko 3',1000,200,250,2010,'PR','2017-11-18 07:29:28'),('PR004','Prangko 4',5000,1000,250,2010,'PR','2017-11-18 07:29:28'),('PR009','prangko 98',2000,1000,250,2009,'PR','2017-11-18 07:29:28'),('PR010','prangko 10',2000,1500,250,2010,'PR','2017-11-18 07:29:28'),('PR011','prangko 11',1500,1000,250,2010,'PR','2017-11-18 07:29:28'),('PS001','pr 1',1000,200,250,2010,'PS','2017-11-18 07:29:28'),('SHP001','shp01',2000,1000,250,2010,'SHP','2017-11-18 07:29:28'),('SHPSS00','shpss017',1000,500,250,2011,'SHPSS','2017-11-18 07:29:28'),('SS001','ss 1',2000,1200,250,2011,'SS','2017-11-18 07:29:28'),('SS002','sci 2',1000,800,250,2000,'SS','2017-11-18 07:29:28'),('DF001','df 1',1000,500,500,2010,'DF','2017-11-18 07:32:56'),('KM001','prakem 1',3000,2500,500,2010,'KM','2017-11-18 07:32:56'),('KM002','kemasan 2',2000,1200,500,2011,'KM','2017-11-18 07:32:56'),('MC001','mc 1',100,10,500,2001,'MC','2017-11-18 07:32:56'),('MC002','nc 2',2000,1200,500,2002,'MC','2017-11-18 07:32:56'),('MC003','merchandise 3',3000,2000,500,2010,'MC','2017-11-18 07:32:56'),('MS001','ms 1',1000,500,500,2010,'MS','2017-11-18 07:32:56'),('MS002','MS 2',1500,1000,500,2010,'MS','2017-11-18 07:32:56'),('PR001','prangko 1',0,1000,500,2000,'PR','2017-11-18 07:32:56'),('PR002','prangko 2',1000,500,500,2010,'PR','2017-11-18 07:32:56'),('PR003','prangko 3',1000,200,500,2010,'PR','2017-11-18 07:32:56'),('PR004','Prangko 4',5000,1000,500,2010,'PR','2017-11-18 07:32:56'),('PR009','prangko 98',2000,1000,500,2009,'PR','2017-11-18 07:32:56'),('PR010','prangko 10',2000,1500,500,2010,'PR','2017-11-18 07:32:56'),('PR011','prangko 11',1500,1000,500,2010,'PR','2017-11-18 07:32:56'),('PS001','pr 1',1000,200,500,2010,'PS','2017-11-18 07:32:56'),('SHP001','shp01',2000,1000,500,2010,'SHP','2017-11-18 07:32:56'),('SHPSS00','shpss017',1000,500,500,2011,'SHPSS','2017-11-18 07:32:56'),('SS001','ss 1',2000,1200,500,2011,'SS','2017-11-18 07:32:56'),('SS002','sci 2',1000,800,500,2000,'SS','2017-11-18 07:32:56'),('DF001','df 1',1000,500,200,2010,'DF','2017-11-18 08:09:49'),('KM001','prakem 1',3000,2500,200,2010,'KM','2017-11-18 08:09:49'),('KM002','kemasan 2',2000,1200,200,2011,'KM','2017-11-18 08:09:49'),('MC001','mc 1',100,10,200,2001,'MC','2017-11-18 08:09:49'),('MC002','nc 2',2000,1200,200,2002,'MC','2017-11-18 08:09:49'),('MC003','merchandise 3',3000,2000,200,2010,'MC','2017-11-18 08:09:49'),('MS001','ms 1',1000,500,200,2010,'MS','2017-11-18 08:09:49'),('MS002','MS 2',1500,1000,200,2010,'MS','2017-11-18 08:09:49'),('PR001','prangko 1',0,1000,200,2000,'PR','2017-11-18 08:09:49'),('PR002','prangko 2',1000,500,200,2010,'PR','2017-11-18 08:09:49'),('PR003','prangko 3',1000,200,200,2010,'PR','2017-11-18 08:09:49'),('PR004','Prangko 4',5000,1000,200,2010,'PR','2017-11-18 08:09:49'),('PR009','prangko 98',2000,1000,200,2009,'PR','2017-11-18 08:09:49'),('PR010','prangko 10',2000,1500,200,2010,'PR','2017-11-18 08:09:49'),('PR011','prangko 11',1500,1000,200,2010,'PR','2017-11-18 08:09:49'),('PS001','pr 1',1000,200,200,2010,'PS','2017-11-18 08:09:49'),('SHP001','shp01',2000,1000,200,2010,'SHP','2017-11-18 08:09:49'),('SHPSS00','shpss017',1000,500,200,2011,'SHPSS','2017-11-18 08:09:49'),('SS001','ss 1',2000,1200,200,2011,'SS','2017-11-18 08:09:49'),('SS002','sci 2',1000,800,200,2000,'SS','2017-11-18 08:09:49'),('DF001','df 1',1000,500,1000,2010,'DF','2017-11-19 06:17:23'),('KM001','prakem 1',3000,2500,1000,2010,'KM','2017-11-19 06:17:23'),('KM002','kemasan 2',2000,1200,1000,2011,'KM','2017-11-19 06:17:23'),('MC001','mc 1',100,10,1000,2001,'MC','2017-11-19 06:17:23'),('MC002','nc 2',2000,1200,1000,2002,'MC','2017-11-19 06:17:23'),('MC003','merchandise 3',3000,2000,1000,2010,'MC','2017-11-19 06:17:23'),('MS001','ms 1',1000,500,1000,2010,'MS','2017-11-19 06:17:23'),('MS002','MS 2',1500,1000,1000,2010,'MS','2017-11-19 06:17:23'),('PR001','prangko 1',0,1000,1000,2000,'PR','2017-11-19 06:17:23'),('PR002','prangko 2',1000,500,1000,2010,'PR','2017-11-19 06:17:23'),('PR003','prangko 3',1000,200,1000,2010,'PR','2017-11-19 06:17:23'),('PR004','Prangko 4',5000,1000,1000,2010,'PR','2017-11-19 06:17:23'),('PR009','prangko 98',2000,1000,1000,2009,'PR','2017-11-19 06:17:23'),('PR010','prangko 10',2000,1500,1000,2010,'PR','2017-11-19 06:17:23'),('PR011','prangko 11',1500,1000,1000,2010,'PR','2017-11-19 06:17:23'),('PS001','pr 1',1000,200,1000,2010,'PS','2017-11-19 06:17:23'),('SHP001','shp01',2000,1000,1000,2010,'SHP','2017-11-19 06:17:23'),('SHPSS00','shpss017',1000,500,1000,2011,'SHPSS','2017-11-19 06:17:23'),('SS001','ss 1',2000,1200,1000,2011,'SS','2017-11-19 06:17:23'),('SS002','sci 2',1000,800,1000,2000,'SS','2017-11-19 06:17:23'),('DF001','df 1',1000,500,2000,2010,'DF','2017-11-19 07:04:23'),('KM001','prakem 1',3000,2500,2000,2010,'KM','2017-11-19 07:04:23'),('KM002','kemasan 2',2000,1200,2000,2011,'KM','2017-11-19 07:04:23'),('MC001','mc 1',100,10,2000,2001,'MC','2017-11-19 07:04:23'),('MC002','nc 2',2000,1200,2000,2002,'MC','2017-11-19 07:04:23'),('MC003','merchandise 3',3000,2000,2000,2010,'MC','2017-11-19 07:04:23'),('MS001','ms 1',1000,500,2000,2010,'MS','2017-11-19 07:04:23'),('MS002','MS 2',1500,1000,2000,2010,'MS','2017-11-19 07:04:23'),('PR001','prangko 1',0,1000,2000,2000,'PR','2017-11-19 07:04:23'),('PR002','prangko 2',1000,500,2000,2010,'PR','2017-11-19 07:04:23'),('PR003','prangko 3',1000,200,2000,2010,'PR','2017-11-19 07:04:23'),('PR004','Prangko 4',5000,1000,2000,2010,'PR','2017-11-19 07:04:23'),('PR009','prangko 98',2000,1000,2000,2009,'PR','2017-11-19 07:04:23'),('PR010','prangko 10',2000,1500,2000,2010,'PR','2017-11-19 07:04:23'),('PR011','prangko 11',1500,1000,2000,2010,'PR','2017-11-19 07:04:23'),('PS001','pr 1',1000,200,2000,2010,'PS','2017-11-19 07:04:23'),('SHP001','shp01',2000,1000,2000,2010,'SHP','2017-11-19 07:04:23'),('SHPSS00','shpss017',1000,500,2000,2011,'SHPSS','2017-11-19 07:04:23'),('SS001','ss 1',2000,1200,2000,2011,'SS','2017-11-19 07:04:23'),('SS002','sci 2',1000,800,2000,2000,'SS','2017-11-19 07:04:23'),('DF001','df 1',1000,500,200,2010,'DF','2017-11-19 07:33:42'),('KM001','prakem 1',3000,2500,200,2010,'KM','2017-11-19 07:33:42'),('KM002','kemasan 2',2000,1200,200,2011,'KM','2017-11-19 07:33:42'),('MC001','mc 1',100,10,200,2001,'MC','2017-11-19 07:33:42'),('MC002','nc 2',2000,1200,200,2002,'MC','2017-11-19 07:33:42'),('MC003','merchandise 3',3000,2000,200,2010,'MC','2017-11-19 07:33:42'),('MS001','ms 1',1000,500,200,2010,'MS','2017-11-19 07:33:42'),('MS002','MS 2',1500,1000,200,2010,'MS','2017-11-19 07:33:42'),('PR001','prangko 1',0,1000,200,2000,'PR','2017-11-19 07:33:42'),('PR002','prangko 2',1000,500,200,2010,'PR','2017-11-19 07:33:42'),('PR003','prangko 3',1000,200,200,2010,'PR','2017-11-19 07:33:42'),('PR004','Prangko 4',5000,1000,200,2010,'PR','2017-11-19 07:33:42'),('PR009','prangko 98',2000,1000,200,2009,'PR','2017-11-19 07:33:42'),('PR010','prangko 10',2000,1500,200,2010,'PR','2017-11-19 07:33:42'),('PR011','prangko 11',1500,1000,200,2010,'PR','2017-11-19 07:33:42'),('PS001','pr 1',1000,200,200,2010,'PS','2017-11-19 07:33:42'),('SHP001','shp01',2000,1000,200,2010,'SHP','2017-11-19 07:33:42'),('SHPSS00','shpss017',1000,500,200,2011,'SHPSS','2017-11-19 07:33:42'),('SS001','ss 1',2000,1200,200,2011,'SS','2017-11-19 07:33:42'),('SS002','sci 2',1000,800,200,2000,'SS','2017-11-19 07:33:42'),('DF001','df 1',1000,500,450,2010,'DF','2017-11-19 08:07:29'),('KM001','prakem 1',3000,2500,450,2010,'KM','2017-11-19 08:07:29'),('KM002','kemasan 2',2000,1200,450,2011,'KM','2017-11-19 08:07:29'),('MC001','mc 1',100,10,450,2001,'MC','2017-11-19 08:07:29'),('MC002','nc 2',2000,1200,450,2002,'MC','2017-11-19 08:07:29'),('MC003','merchandise 3',3000,2000,450,2010,'MC','2017-11-19 08:07:29'),('MS001','ms 1',1000,500,450,2010,'MS','2017-11-19 08:07:29'),('MS002','MS 2',1500,1000,450,2010,'MS','2017-11-19 08:07:29'),('PR001','prangko 1',0,1000,450,2000,'PR','2017-11-19 08:07:29'),('PR002','prangko 2',1000,500,450,2010,'PR','2017-11-19 08:07:29'),('PR003','prangko 3',1000,200,450,2010,'PR','2017-11-19 08:07:29'),('PR004','Prangko 4',5000,1000,450,2010,'PR','2017-11-19 08:07:29'),('PR009','prangko 98',2000,1000,450,2009,'PR','2017-11-19 08:07:29'),('PR010','prangko 10',2000,1500,450,2010,'PR','2017-11-19 08:07:29'),('PR011','prangko 11',1500,1000,450,2010,'PR','2017-11-19 08:07:29'),('PS001','pr 1',1000,200,450,2010,'PS','2017-11-19 08:07:29'),('SHP001','shp01',2000,1000,450,2010,'SHP','2017-11-19 08:07:29'),('SHPSS00','shpss017',1000,500,450,2011,'SHPSS','2017-11-19 08:07:29'),('SS001','ss 1',2000,1200,450,2011,'SS','2017-11-19 08:07:29'),('SS002','sci 2',1000,800,450,2000,'SS','2017-11-19 08:07:29'),('PR003','prangko 3',1000,200,1000,2010,'PR','2017-11-21 19:40:43'),('PR003','prangko 3',1000,200,1500,2010,'PR','2017-11-21 19:41:31'),('DF001','df 1',1000,500,1000,2010,'DF','2017-12-10 14:21:20'),('KM001','prakem 1',3000,2500,1000,2010,'KM','2017-12-10 14:21:20'),('KM002','kemasan 2',2000,1200,1000,2011,'KM','2017-12-10 14:21:20'),('MC001','mc 1',100,10,1000,2001,'MC','2017-12-10 14:21:20'),('MC002','nc 2',2000,1200,1000,2002,'MC','2017-12-10 14:21:20'),('MC003','merchandise 3',3000,2000,1000,2010,'MC','2017-12-10 14:21:20'),('MS001','ms 1',1000,500,1000,2010,'MS','2017-12-10 14:21:20'),('MS002','MS 2',1500,1000,1000,2010,'MS','2017-12-10 14:21:20'),('PR001','prangko 1',0,1000,1000,2000,'PR','2017-12-10 14:21:20'),('PR002','prangko 2',1000,500,1000,2010,'PR','2017-12-10 14:21:20'),('PR003','prangko 3',1000,200,1646,2010,'PR','2017-12-10 14:21:20'),('PR004','Prangko 4',5000,1000,1000,2010,'PR','2017-12-10 14:21:20'),('PR009','prangko 98',2000,1000,1000,2009,'PR','2017-12-10 14:21:20'),('PR010','prangko 10',2000,1500,1000,2010,'PR','2017-12-10 14:21:20'),('PR011','prangko 11',1500,1000,1000,2010,'PR','2017-12-10 14:21:20'),('PS001','pr 1',1000,200,1000,2010,'PS','2017-12-10 14:21:20'),('SHP001','shp01',2000,1000,1000,2010,'SHP','2017-12-10 14:21:20'),('SHPSS00','shpss017',1000,500,1000,2011,'SHPSS','2017-12-10 14:21:20'),('SS001','ss 1',2000,1200,1000,2011,'SS','2017-12-10 14:21:20'),('SS002','sci 2',1000,800,1000,2000,'SS','2017-12-10 14:21:20'),('DF001','df 1',1000,500,1000,2010,'DF','2017-12-10 14:22:07'),('KM001','prakem 1',3000,2500,1000,2010,'KM','2017-12-10 14:22:07'),('KM002','kemasan 2',2000,1200,1000,2011,'KM','2017-12-10 14:22:07'),('MC001','mc 1',100,10,1000,2001,'MC','2017-12-10 14:22:07'),('MC002','nc 2',2000,1200,1000,2002,'MC','2017-12-10 14:22:07'),('MC003','merchandise 3',3000,2000,1000,2010,'MC','2017-12-10 14:22:07'),('MS001','ms 1',1000,500,1000,2010,'MS','2017-12-10 14:22:07'),('MS002','MS 2',1500,1000,1000,2010,'MS','2017-12-10 14:22:07'),('PR001','prangko 1',0,1000,1000,2000,'PR','2017-12-10 14:22:07'),('PR002','prangko 2',1000,500,1000,2010,'PR','2017-12-10 14:22:07'),('PR003','prangko 3',1000,200,1000,2010,'PR','2017-12-10 14:22:07'),('PR004','Prangko 4',5000,1000,1000,2010,'PR','2017-12-10 14:22:07'),('PR009','prangko 98',2000,1000,1000,2009,'PR','2017-12-10 14:22:07'),('PR010','prangko 10',2000,1500,1000,2010,'PR','2017-12-10 14:22:07'),('PR011','prangko 11',1500,1000,1000,2010,'PR','2017-12-10 14:22:07'),('PS001','pr 1',1000,200,1000,2010,'PS','2017-12-10 14:22:07'),('SHP001','shp01',2000,1000,1000,2010,'SHP','2017-12-10 14:22:07'),('SHPSS00','shpss017',1000,500,1000,2011,'SHPSS','2017-12-10 14:22:07'),('SS001','ss 1',2000,1200,1000,2011,'SS','2017-12-10 14:22:07'),('SS002','sci 2',1000,800,1000,2000,'SS','2017-12-10 14:22:07'),('MS002','MS 2',1500,1000,1500,2010,'MS','2017-12-13 08:43:44'),('PR001','prangko 1',0,1000,1500,2000,'PR','2017-12-13 08:44:09'),('PR010','prangko 10',2000,1500,1500,2010,'PR','2017-12-14 02:00:00'),('PR011','prangko 11',1500,1000,1500,2010,'PR','2017-12-14 02:00:01'),('PR014','hjgjhg',123123,0,0,2017,'PR','2017-12-18 08:55:02'),('PR015','34245',2353250,325235,0,2017,'PR','2017-12-18 09:03:26');
/*!40000 ALTER TABLE `tb_update_produk` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_user`
--

DROP TABLE IF EXISTS `tb_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_user` (
  `nik` varchar(12) NOT NULL,
  `password` varchar(30) NOT NULL,
  `nama_user` varchar(50) NOT NULL,
  `hak_akses` varchar(2) NOT NULL,
  PRIMARY KEY (`nik`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_user`
--

LOCK TABLES `tb_user` WRITE;
/*!40000 ALTER TABLE `tb_user` DISABLE KEYS */;
INSERT INTO `tb_user` VALUES ('111','amad','amad','fl'),('112','diar','diar','ad'),('113','reyhanadp','reyhan audian','fl');
/*!40000 ALTER TABLE `tb_user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-12-20 13:06:44
