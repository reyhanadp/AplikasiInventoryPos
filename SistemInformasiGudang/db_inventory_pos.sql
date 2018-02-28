-- MySQL dump 10.16  Distrib 10.1.29-MariaDB, for Win32 (AMD64)
--
-- Host: localhost    Database: db_inventory_pos
-- ------------------------------------------------------
-- Server version	10.1.29-MariaDB

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
-- Table structure for table `tb_jenis_produk`
--

DROP TABLE IF EXISTS `tb_jenis_produk`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_jenis_produk` (
  `id_jenis_produk` varchar(5) NOT NULL,
  `nama_jenis_produk` varchar(100) NOT NULL,
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
-- Table structure for table `tb_mitra`
--

DROP TABLE IF EXISTS `tb_mitra`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_mitra` (
  `id_mitra` varchar(5) NOT NULL,
  `nama_mitra` varchar(50) NOT NULL,
  `alamat` varchar(100) DEFAULT NULL,
  `no_telp` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`id_mitra`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 ROW_FORMAT=COMPACT;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_mitra`
--

LOCK TABLES `tb_mitra` WRITE;
/*!40000 ALTER TABLE `tb_mitra` DISABLE KEYS */;
INSERT INTO `tb_mitra` VALUES ('gg21','gudang jabar','jl. sekeloa','0223981974'),('pr092','Peruri','','');
/*!40000 ALTER TABLE `tb_mitra` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_produk`
--

DROP TABLE IF EXISTS `tb_produk`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
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
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_produk`
--

LOCK TABLES `tb_produk` WRITE;
/*!40000 ALTER TABLE `tb_produk` DISABLE KEYS */;
INSERT INTO `tb_produk` VALUES ('DF000000001','dokumen filateli 1',12000,10000,0,'2017','DF','10114279','0'),('DF000000002','df 2',1200,1000,0,'2017','DF','10114279','0'),('KM000000001','kemasan 1',1500,1200,0,'2017','KM','10114279','0'),('KM000000002','kemasan 2',1000,800,0,'2017','KM','10114279','0'),('MC000000001','merchndise 1',5000,4600,0,'2017','MC','10114279','0'),('MC000000002','mc 2',10000,1000,0,'2017','MC','10114279','0'),('MS000000001','ms 1',5000,4500,0,'2017','MS','10114279','0'),('MS000000002','ms 1',5000,4500,0,'2018','MS','10114279','0'),('PR000000001','prangko 11',1500,1200,2220,'2017','PR','10114279','0'),('PR000000002','prangko 23',1500,800,0,'2017','PR','10114279','0'),('PR000000003','prangko 2',1000,800,0,'2018','PR','10114279','1'),('PR000000004','prangko 1',2000,1700,1300,'2017','PR','10114279','0'),('PR000000005','prangko 1',2500,2200,3000,'2019','PR','10114279','0'),('PR000000006','prangko 6',1200,700.34,7,'2018','PR','10114279','0'),('PR000000007','1e12',2000,1500,300,'2018','PR','10114279','0'),('PS000000001','prisma 1',4000,3600,0,'2017','PS','10114279','0'),('PS000000002','pr 2',5000,4500,0,'2017','PS','10114279','0'),('SHP00000001','shp 1',1500,1200,0,'2017','SHP','10114279','0'),('SHPSS000001','shpss 1',5000,4500,0,'2017','SHPSS','10114279','0'),('SS000000001','ss 1',4500,4300,0,'2017','SS','10114279','0');
/*!40000 ALTER TABLE `tb_produk` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_regional`
--

DROP TABLE IF EXISTS `tb_regional`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_regional` (
  `id_regional` varchar(3) NOT NULL,
  `regional` varchar(100) NOT NULL,
  `kode_pos` varchar(5) NOT NULL,
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
-- Table structure for table `tb_trans_pemesanan`
--

DROP TABLE IF EXISTS `tb_trans_pemesanan`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
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
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_trans_pemesanan`
--

LOCK TABLES `tb_trans_pemesanan` WRITE;
/*!40000 ALTER TABLE `tb_trans_pemesanan` DISABLE KEYS */;
INSERT INTO `tb_trans_pemesanan` VALUES ('0000000001','0000000001','PR000000001',10000,'2018-01-06','gg21','belum selesai'),('0000000002','0000000002','SS000000001',10000,'2018-01-06','gg21','belum selesai'),('0000000003','0000000002','PR000000003',20000,'2018-01-06','gg21','belum selesai'),('0000000004','0000000002','PR000000002',20000,'2018-01-06','gg21','belum selesai'),('0000000005','0000000002','MS000000001',1000,'2018-01-06','gg21','belum selesai'),('0000000006','0000000002','PR000000005',10000,'2018-01-06','gg21','belum selesai'),('0000000007','0000000003','PR000000003',2000,'2018-01-06','gg21','belum selesai'),('0000000008','0000000003','PR000000001',1000,'2018-01-06','gg21','belum selesai'),('0000000009','0000000004','PR000000002',5000,'2018-01-06','gg21','belum selesai'),('0000000010','0000000004','PR000000004',2000,'2018-01-06','gg21','belum selesai'),('0000000011','0000000005','PR000000004',1000,'2018-01-06','gg21','belum selesai'),('0000000012','0000000006','PR000000005',4000,'2018-01-06','pr092','belum selesai'),('0000000013','0000000007','MS000000001',1000,'2018-01-12','gg21','belum selesai'),('0000000014','0000000008','SHP00000001',7000,'2018-01-06','gg21','belum selesai'),('0000000015','0000000009','SS000000001',7000,'2018-01-06','gg21','belum selesai'),('0000000016','0000000010','PR000000004',10000,'2018-01-22','gg21','belum selesai'),('0000000017','0000000011','PR000000006',20000,'2018-01-22','pr092','belum selesai');
/*!40000 ALTER TABLE `tb_trans_pemesanan` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_trans_penerimaan`
--

DROP TABLE IF EXISTS `tb_trans_penerimaan`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
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
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_trans_penerimaan`
--

LOCK TABLES `tb_trans_penerimaan` WRITE;
/*!40000 ALTER TABLE `tb_trans_penerimaan` DISABLE KEYS */;
INSERT INTO `tb_trans_penerimaan` VALUES ('0000000001','a-aaaa-aa-aaaa','2018-01-22',1000,'0000000010','PR000000004','gg21',2000,3000,1000,1000,''),('0000000002','b-bbbb-bb-bbbb','2018-02-16',2000,'0000000001','PR000000001','gg21',220,2220,2000,8000,''),('0000000003','a-aaaa-aa-aaaa','2018-02-16',3000,'0000000006','PR000000005','gg21',0,3000,3000,7000,'');
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
	UPDATE tb_produk SET tb_produk.stok=NEW.stok_akhir WHERE tb_produk.id_produk = NEW.id_produk;
    IF(NEW.sisa_belum_dikirim=0) THEN
    UPDATE tb_trans_pemesanan 
    SET tb_trans_pemesanan.status='selesai' WHERE id_pemesanan=NEW.id_pemesanan;
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
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_trans_pengembalian`
--

LOCK TABLES `tb_trans_pengembalian` WRITE;
/*!40000 ALTER TABLE `tb_trans_pengembalian` DISABLE KEYS */;
INSERT INTO `tb_trans_pengembalian` VALUES ('0000000001','2018-01-06',250,21,'AMT','PR000000001',750,1000,NULL),('0000000002','2018-01-22',300,10,'AMT','PR000000004',3000,3300,''),('0000000003','2018-02-05',7,NULL,'AMT','PR000000006',0,7,NULL);
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
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_trans_pengiriman`
--

LOCK TABLES `tb_trans_pengiriman` WRITE;
/*!40000 ALTER TABLE `tb_trans_pengiriman` DISABLE KEYS */;
INSERT INTO `tb_trans_pengiriman` VALUES ('0000000001','5','2018-01-20',10,15000,'AMT','PR000000001',1000,990),('0000000002','12','2018-01-20',20,30000,'AMT','PR000000001',990,970);
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
  `status` varchar(1) NOT NULL DEFAULT '0',
  `penyimpanan` varchar(150) DEFAULT NULL,
  PRIMARY KEY (`nik`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_user`
--

LOCK TABLES `tb_user` WRITE;
/*!40000 ALTER TABLE `tb_user` DISABLE KEYS */;
INSERT INTO `tb_user` VALUES ('10114279','10114279','Muhamad Solahudin','FL','0','D:\\'),('10114280','10114280','Reyhan Audian D.P.','AD','0',NULL);
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

-- Dump completed on 2018-02-28 20:26:30
