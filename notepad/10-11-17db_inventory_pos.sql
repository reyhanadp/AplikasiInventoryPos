-- phpMyAdmin SQL Dump
-- version 4.6.5.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Nov 10, 2017 at 03:34 PM
-- Server version: 10.1.21-MariaDB
-- PHP Version: 7.1.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `db_inventory_pos`
--

-- --------------------------------------------------------

--
-- Table structure for table `tb_hapus_produk`
--

CREATE TABLE `tb_hapus_produk` (
  `id_produk` varchar(7) NOT NULL,
  `nama_produk` varchar(100) DEFAULT NULL,
  `nominal` int(11) DEFAULT NULL,
  `biaya_cetak` float DEFAULT NULL,
  `stok` int(11) DEFAULT NULL,
  `tahun` year(4) DEFAULT NULL,
  `id_jenis_produk` varchar(5) DEFAULT NULL,
  `tgl_penghapusan` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tb_hapus_produk`
--

INSERT INTO `tb_hapus_produk` (`id_produk`, `nama_produk`, `nominal`, `biaya_cetak`, `stok`, `tahun`, `id_jenis_produk`, `tgl_penghapusan`) VALUES
('', NULL, NULL, NULL, NULL, NULL, NULL, '2017-08-29 06:55:21'),
('KM001', 'kemasan 1', 10, 20, 10, 2000, 'KM', '2017-08-21 07:11:21'),
('PR001', 'prangko 1', 10, 20, 10, 2010, 'PR', '2017-08-21 07:11:21'),
('PR002', 'prangko 2', 100, 20, 10, 2010, 'PR', '2017-08-21 07:19:05'),
('PR005', 'pangko 5', 2000, 1500, 0, 2011, 'PR', '2017-08-29 02:22:47'),
('PR006', 'prangko6', 0, 0, 0, 2010, 'PR', '2017-08-28 06:32:23'),
('PR007', 'prangko 7', 1000, 700, 0, 2009, 'PR', '2017-08-28 06:44:47'),
('PR008', 'prengk', 0, 0, 0, 2000, 'PR', '2017-08-28 07:47:50'),
('SHP001', NULL, NULL, NULL, NULL, NULL, NULL, '2017-08-25 04:06:17');

-- --------------------------------------------------------

--
-- Table structure for table `tb_history_pengembalian`
--

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

-- --------------------------------------------------------

--
-- Table structure for table `tb_jenis_produk`
--

CREATE TABLE `tb_jenis_produk` (
  `id_jenis_produk` varchar(5) NOT NULL,
  `nama_jenis_produk` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tb_jenis_produk`
--

INSERT INTO `tb_jenis_produk` (`id_jenis_produk`, `nama_jenis_produk`) VALUES
('DF', 'Dokumen Filateli'),
('KM', 'Kemasan'),
('MC', 'Merchandise'),
('MS', 'MS'),
('PR', 'Prangko'),
('PS', 'Prisma'),
('SHP', 'SHP'),
('SHPSS', 'SHPSS'),
('SS', 'SS');

-- --------------------------------------------------------

--
-- Table structure for table `tb_pemesanan`
--

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
  `id_suplier` varchar(5) NOT NULL,
  `status` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tb_pemesanan`
--

INSERT INTO `tb_pemesanan` (`no_pemesanan`, `id_produk`, `nama_produk`, `jumlah_pesan`, `tgl_pesan`, `tahun`, `nominal`, `biaya_cetak`, `id_jenis_produk`, `id_suplier`, `status`) VALUES
('00001', 'PR011', 'prangko 11', 2000, '2017-10-14', '2010', 1500, 1000, 'PR', 'gg21', 'selesai'),
('00002', 'MC003', 'merchandise 3', 3000, '2017-10-14', '2010', 3000, 2000, 'MC', 'gg21', 'selesai'),
('00003', 'MS002', 'MS 2', 10000, '2017-10-18', '2010', 1500, 1000, 'MS', 'gg21', 'selesai');

--
-- Triggers `tb_pemesanan`
--
DELIMITER $$
CREATE TRIGGER `trig_insert_to_produk` AFTER INSERT ON `tb_pemesanan` FOR EACH ROW BEGIN
	
    IF (jenis_prangko="Filateli")
    THEN
    
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
    
    END IF;

    END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `tb_produk`
--

CREATE TABLE `tb_produk` (
  `id_produk` varchar(10) NOT NULL,
  `nama_produk` varchar(100) DEFAULT NULL,
  `nominal` int(11) DEFAULT NULL,
  `biaya_cetak` float DEFAULT NULL,
  `stok` int(11) DEFAULT NULL,
  `tahun` varchar(4) DEFAULT NULL,
  `id_jenis_produk` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tb_produk`
--

INSERT INTO `tb_produk` (`id_produk`, `nama_produk`, `nominal`, `biaya_cetak`, `stok`, `tahun`, `id_jenis_produk`) VALUES
('DF001', 'df 1', 1000, 500, 11000, '2010', 'DF'),
('KM001', 'prakem 1', 3000, 2500, 11000, '2010', 'KM'),
('KM002', 'kemasan 2', 2000, 1200, 11000, '2011', 'KM'),
('MC001', 'mc 1', 100, 10, 11000, '2001', 'MC'),
('MC002', 'nc 2', 2000, 1200, 11000, '2002', 'MC'),
('MC003', 'merchandise 3', 3000, 2000, 11000, '2010', 'MC'),
('MS001', 'ms 1', 1000, 500, 11000, '2010', 'MS'),
('MS002', 'MS 2', 1500, 1000, 11000, '2010', 'MS'),
('PR001', 'prangko 1', 0, 1000, 11000, '2000', 'PR'),
('PR002', 'prangko 2', 1000, 500, 11000, '2010', 'PR'),
('PR003', 'prangko 3', 1000, 200, 11000, '2010', 'PR'),
('PR004', 'Prangko 4', 5000, 1000, 11000, '2010', 'PR'),
('PR009', 'prangko 98', 2000, 1000, 11000, '2009', 'PR'),
('PR010', 'prangko 10', 2000, 1500, 11000, '2010', 'PR'),
('PR011', 'prangko 11', 1500, 1000, 11000, '2010', 'PR'),
('PS001', 'pr 1', 1000, 200, 11000, '2010', 'PS'),
('SHP001', 'shp01', 2000, 1000, 11000, '2010', 'SHP'),
('SHPSS001', 'shpss017', 1000, 500, 11000, '2011', 'SHPSS'),
('SS001', 'ss 1', 2000, 1200, 11000, '2011', 'SS'),
('SS002', 'sci 2', 1000, 800, 11000, '2000', 'SS');

--
-- Triggers `tb_produk`
--
DELIMITER $$
CREATE TRIGGER `history_hapus_produk` AFTER DELETE ON `tb_produk` FOR EACH ROW BEGIN

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

    END
$$
DELIMITER ;
DELIMITER $$
CREATE TRIGGER `history_update_produk` AFTER UPDATE ON `tb_produk` FOR EACH ROW BEGIN

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

    END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `tb_regional`
--

CREATE TABLE `tb_regional` (
  `id_regional` varchar(3) NOT NULL,
  `regional` varchar(100) DEFAULT NULL,
  `kode_pos` varchar(5) DEFAULT NULL,
  `no_telp` varchar(9) DEFAULT NULL,
  `alamat` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `tb_suplier`
--

CREATE TABLE `tb_suplier` (
  `id_suplier` varchar(5) NOT NULL,
  `nama_suplier` varchar(50) DEFAULT NULL,
  `alamat` varchar(100) DEFAULT NULL,
  `no_telp` varchar(15) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tb_suplier`
--

INSERT INTO `tb_suplier` (`id_suplier`, `nama_suplier`, `alamat`, `no_telp`) VALUES
('gg21', 'gudang jabar', 'jl. sekeloa', '0223981974');

-- --------------------------------------------------------

--
-- Table structure for table `tb_trans_penerimaan`
--

CREATE TABLE `tb_trans_penerimaan` (
  `no_order` varchar(4) NOT NULL,
  `tgl_penerimaan` date DEFAULT NULL,
  `jml_terima` int(11) DEFAULT NULL,
  `no_pemesanan` varchar(5) DEFAULT NULL,
  `id_produk` varchar(5) NOT NULL,
  `id_suplier` varchar(5) DEFAULT NULL,
  `stok_awal` int(11) DEFAULT NULL,
  `stok_akhir` int(11) DEFAULT NULL,
  `subtotal_terima` int(11) DEFAULT NULL,
  `sisa_belum_dikirim` int(11) DEFAULT NULL,
  `keterangan` varchar(12) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tb_trans_penerimaan`
--

INSERT INTO `tb_trans_penerimaan` (`no_order`, `tgl_penerimaan`, `jml_terima`, `no_pemesanan`, `id_produk`, `id_suplier`, `stok_awal`, `stok_akhir`, `subtotal_terima`, `sisa_belum_dikirim`, `keterangan`) VALUES
('1', '2017-11-01', 3000, '00002', 'MC003', 'gg21', 0, 3000, 3000, 0, ''),
('111', '2017-10-27', 1000, '00001', 'PR011', 'gg21', 0, 1000, 1000, 1000, ''),
('112', '2017-10-28', 500, '00001', 'PR011', 'gg21', 1000, 1500, 1500, 500, 'ya\ngitu'),
('113', '2017-11-01', 1000, '00001', 'PR011', 'gg21', 10000, 11000, 2000, 0, ''),
('12', '2017-11-01', 10000, '00003', 'MS002', 'gg21', 0, 10000, 10000, 0, '');

--
-- Triggers `tb_trans_penerimaan`
--
DELIMITER $$
CREATE TRIGGER `update_stok_penerimaan` AFTER INSERT ON `tb_trans_penerimaan` FOR EACH ROW BEGIN
	UPDATE tb_produk SET tb_produk.stok=NEW.stok_akhir;
    IF(NEW.sisa_belum_dikirim=0) THEN
    UPDATE tb_pemesanan 
    SET tb_pemesanan.status='selesai' WHERE no_pemesanan=NEW.no_pemesanan;
    END IF;
END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `tb_trans_pengeluaran`
--

CREATE TABLE `tb_trans_pengeluaran` (
  `id_pengeluaran` varchar(7) NOT NULL,
  `tgl_pengeluaran` date DEFAULT NULL,
  `jml_pengeluaran` int(11) DEFAULT NULL,
  `dus` smallint(6) DEFAULT NULL,
  `id_regional` varchar(5) DEFAULT NULL,
  `id_produk` varchar(7) DEFAULT NULL,
  `stok_awal` int(11) DEFAULT NULL,
  `stok_akhir` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `tb_trans_pengembalian`
--

CREATE TABLE `tb_trans_pengembalian` (
  `id_pengembalian` varchar(7) NOT NULL,
  `tgl_pengembalian` date DEFAULT NULL,
  `jml_pengembalian` int(11) DEFAULT NULL,
  `dus` smallint(6) DEFAULT NULL,
  `id_regional` varchar(5) DEFAULT NULL,
  `id_produk` varchar(7) DEFAULT NULL,
  `stok_awal` int(11) DEFAULT NULL,
  `stok_akhir` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Triggers `tb_trans_pengembalian`
--
DELIMITER $$
CREATE TRIGGER `update_stok_pengembalian` AFTER INSERT ON `tb_trans_pengembalian` FOR EACH ROW BEGIN
	UPDATE tb_produk SET tb_produk.stok=NEW.stok_akhir;
END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `tb_update_produk`
--

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

--
-- Dumping data for table `tb_update_produk`
--

INSERT INTO `tb_update_produk` (`id_produk`, `nama_produk`, `nominal`, `biaya_cetak`, `stok`, `tahun`, `id_jenis_produk`, `tgl_update`) VALUES
('PR003', 'prangko 3', 1000, 200, 10, 2011, 'PR', '2017-08-21 07:23:37'),
('PR003', 'prangko 3', 1500, 200, 10, 2011, 'PR', '2017-08-23 06:34:57'),
('PR003', 'prangko 3', 1000, 200, 10, 2010, 'PR', '2017-08-23 06:38:40'),
('PR009', 'prangko 9', 2000, 1000, 0, 2009, 'PR', '2017-08-29 02:22:30'),
('DF001', 'df 1', 1000, 500, 0, 2010, 'DF', '2017-10-28 15:08:24'),
('KM001', 'prakem 1', 3000, 2500, 0, 2010, 'KM', '2017-10-28 15:08:24'),
('KM002', 'kemasan 2', 2000, 1200, 0, 2011, 'KM', '2017-10-28 15:08:24'),
('MC001', 'mc 1', 100, 10, 0, 2001, 'MC', '2017-10-28 15:08:24'),
('MC002', 'nc 2', 2000, 1200, 0, 2002, 'MC', '2017-10-28 15:08:24'),
('MC003', 'merchandise 3', 3000, 2000, 0, 2010, 'MC', '2017-10-28 15:08:24'),
('MS001', 'ms 1', 1000, 500, 0, 2010, 'MS', '2017-10-28 15:08:24'),
('MS002', 'MS 2', 1500, 1000, 0, 2010, 'MS', '2017-10-28 15:08:24'),
('PR001', 'prangko 1', 0, 1000, 0, 2000, 'PR', '2017-10-28 15:08:24'),
('PR002', 'prangko 2', 1000, 500, 0, 2010, 'PR', '2017-10-28 15:08:24'),
('PR003', 'prangko 3', 1000, 200, 10, 2010, 'PR', '2017-10-28 15:08:24'),
('PR004', 'Prangko 4', 5000, 1000, 0, 2010, 'PR', '2017-10-28 15:08:24'),
('PR009', 'prangko 98', 2000, 1000, 0, 2009, 'PR', '2017-10-28 15:08:24'),
('PR010', 'prangko 10', 2000, 1500, 0, 2010, 'PR', '2017-10-28 15:08:24'),
('PR011', 'prangko 11', 1500, 1000, 0, 2010, 'PR', '2017-10-28 15:08:24'),
('PS001', 'pr 1', 1000, 200, 0, 2010, 'PS', '2017-10-28 15:08:24'),
('SHP001', 'shp01', 2000, 1000, 0, 2010, 'SHP', '2017-10-28 15:08:24'),
('SHPSS00', 'shpss017', 1000, 500, 0, 2011, 'SHPSS', '2017-10-28 15:08:24'),
('SS001', 'ss 1', 2000, 1200, 0, 2011, 'SS', '2017-10-28 15:08:24'),
('SS002', 'sci 2', 1000, 800, 0, 2000, 'SS', '2017-10-28 15:08:24'),
('DF001', 'df 1', 1000, 500, 1000, 2010, 'DF', '2017-10-28 15:11:42'),
('KM001', 'prakem 1', 3000, 2500, 1000, 2010, 'KM', '2017-10-28 15:11:42'),
('KM002', 'kemasan 2', 2000, 1200, 1000, 2011, 'KM', '2017-10-28 15:11:42'),
('MC001', 'mc 1', 100, 10, 1000, 2001, 'MC', '2017-10-28 15:11:42'),
('MC002', 'nc 2', 2000, 1200, 1000, 2002, 'MC', '2017-10-28 15:11:42'),
('MC003', 'merchandise 3', 3000, 2000, 1000, 2010, 'MC', '2017-10-28 15:11:42'),
('MS001', 'ms 1', 1000, 500, 1000, 2010, 'MS', '2017-10-28 15:11:42'),
('MS002', 'MS 2', 1500, 1000, 1000, 2010, 'MS', '2017-10-28 15:11:42'),
('PR001', 'prangko 1', 0, 1000, 1000, 2000, 'PR', '2017-10-28 15:11:42'),
('PR002', 'prangko 2', 1000, 500, 1000, 2010, 'PR', '2017-10-28 15:11:42'),
('PR003', 'prangko 3', 1000, 200, 1000, 2010, 'PR', '2017-10-28 15:11:42'),
('PR004', 'Prangko 4', 5000, 1000, 1000, 2010, 'PR', '2017-10-28 15:11:42'),
('PR009', 'prangko 98', 2000, 1000, 1000, 2009, 'PR', '2017-10-28 15:11:42'),
('PR010', 'prangko 10', 2000, 1500, 1000, 2010, 'PR', '2017-10-28 15:11:42'),
('PR011', 'prangko 11', 1500, 1000, 1000, 2010, 'PR', '2017-10-28 15:11:42'),
('PS001', 'pr 1', 1000, 200, 1000, 2010, 'PS', '2017-10-28 15:11:42'),
('SHP001', 'shp01', 2000, 1000, 1000, 2010, 'SHP', '2017-10-28 15:11:42'),
('SHPSS00', 'shpss017', 1000, 500, 1000, 2011, 'SHPSS', '2017-10-28 15:11:42'),
('SS001', 'ss 1', 2000, 1200, 1000, 2011, 'SS', '2017-10-28 15:11:42'),
('SS002', 'sci 2', 1000, 800, 1000, 2000, 'SS', '2017-10-28 15:11:42'),
('DF001', 'df 1', 1000, 500, 1500, 2010, 'DF', '2017-11-01 12:42:42'),
('KM001', 'prakem 1', 3000, 2500, 1500, 2010, 'KM', '2017-11-01 12:42:42'),
('KM002', 'kemasan 2', 2000, 1200, 1500, 2011, 'KM', '2017-11-01 12:42:42'),
('MC001', 'mc 1', 100, 10, 1500, 2001, 'MC', '2017-11-01 12:42:42'),
('MC002', 'nc 2', 2000, 1200, 1500, 2002, 'MC', '2017-11-01 12:42:42'),
('MC003', 'merchandise 3', 3000, 2000, 1500, 2010, 'MC', '2017-11-01 12:42:42'),
('MS001', 'ms 1', 1000, 500, 1500, 2010, 'MS', '2017-11-01 12:42:42'),
('MS002', 'MS 2', 1500, 1000, 1500, 2010, 'MS', '2017-11-01 12:42:42'),
('PR001', 'prangko 1', 0, 1000, 1500, 2000, 'PR', '2017-11-01 12:42:42'),
('PR002', 'prangko 2', 1000, 500, 1500, 2010, 'PR', '2017-11-01 12:42:42'),
('PR003', 'prangko 3', 1000, 200, 1500, 2010, 'PR', '2017-11-01 12:42:42'),
('PR004', 'Prangko 4', 5000, 1000, 1500, 2010, 'PR', '2017-11-01 12:42:42'),
('PR009', 'prangko 98', 2000, 1000, 1500, 2009, 'PR', '2017-11-01 12:42:42'),
('PR010', 'prangko 10', 2000, 1500, 1500, 2010, 'PR', '2017-11-01 12:42:42'),
('PR011', 'prangko 11', 1500, 1000, 1500, 2010, 'PR', '2017-11-01 12:42:42'),
('PS001', 'pr 1', 1000, 200, 1500, 2010, 'PS', '2017-11-01 12:42:42'),
('SHP001', 'shp01', 2000, 1000, 1500, 2010, 'SHP', '2017-11-01 12:42:42'),
('SHPSS00', 'shpss017', 1000, 500, 1500, 2011, 'SHPSS', '2017-11-01 12:42:42'),
('SS001', 'ss 1', 2000, 1200, 1500, 2011, 'SS', '2017-11-01 12:42:42'),
('SS002', 'sci 2', 1000, 800, 1500, 2000, 'SS', '2017-11-01 12:42:42'),
('DF001', 'df 1', 1000, 500, 3000, 2010, 'DF', '2017-11-01 12:45:50'),
('KM001', 'prakem 1', 3000, 2500, 3000, 2010, 'KM', '2017-11-01 12:45:50'),
('KM002', 'kemasan 2', 2000, 1200, 3000, 2011, 'KM', '2017-11-01 12:45:50'),
('MC001', 'mc 1', 100, 10, 3000, 2001, 'MC', '2017-11-01 12:45:50'),
('MC002', 'nc 2', 2000, 1200, 3000, 2002, 'MC', '2017-11-01 12:45:50'),
('MC003', 'merchandise 3', 3000, 2000, 3000, 2010, 'MC', '2017-11-01 12:45:50'),
('MS001', 'ms 1', 1000, 500, 3000, 2010, 'MS', '2017-11-01 12:45:50'),
('MS002', 'MS 2', 1500, 1000, 3000, 2010, 'MS', '2017-11-01 12:45:50'),
('PR001', 'prangko 1', 0, 1000, 3000, 2000, 'PR', '2017-11-01 12:45:50'),
('PR002', 'prangko 2', 1000, 500, 3000, 2010, 'PR', '2017-11-01 12:45:50'),
('PR003', 'prangko 3', 1000, 200, 3000, 2010, 'PR', '2017-11-01 12:45:50'),
('PR004', 'Prangko 4', 5000, 1000, 3000, 2010, 'PR', '2017-11-01 12:45:50'),
('PR009', 'prangko 98', 2000, 1000, 3000, 2009, 'PR', '2017-11-01 12:45:50'),
('PR010', 'prangko 10', 2000, 1500, 3000, 2010, 'PR', '2017-11-01 12:45:50'),
('PR011', 'prangko 11', 1500, 1000, 3000, 2010, 'PR', '2017-11-01 12:45:50'),
('PS001', 'pr 1', 1000, 200, 3000, 2010, 'PS', '2017-11-01 12:45:50'),
('SHP001', 'shp01', 2000, 1000, 3000, 2010, 'SHP', '2017-11-01 12:45:50'),
('SHPSS00', 'shpss017', 1000, 500, 3000, 2011, 'SHPSS', '2017-11-01 12:45:50'),
('SS001', 'ss 1', 2000, 1200, 3000, 2011, 'SS', '2017-11-01 12:45:50'),
('SS002', 'sci 2', 1000, 800, 3000, 2000, 'SS', '2017-11-01 12:45:50'),
('DF001', 'df 1', 1000, 500, 10000, 2010, 'DF', '2017-11-01 12:46:37'),
('KM001', 'prakem 1', 3000, 2500, 10000, 2010, 'KM', '2017-11-01 12:46:37'),
('KM002', 'kemasan 2', 2000, 1200, 10000, 2011, 'KM', '2017-11-01 12:46:37'),
('MC001', 'mc 1', 100, 10, 10000, 2001, 'MC', '2017-11-01 12:46:37'),
('MC002', 'nc 2', 2000, 1200, 10000, 2002, 'MC', '2017-11-01 12:46:37'),
('MC003', 'merchandise 3', 3000, 2000, 10000, 2010, 'MC', '2017-11-01 12:46:37'),
('MS001', 'ms 1', 1000, 500, 10000, 2010, 'MS', '2017-11-01 12:46:37'),
('MS002', 'MS 2', 1500, 1000, 10000, 2010, 'MS', '2017-11-01 12:46:37'),
('PR001', 'prangko 1', 0, 1000, 10000, 2000, 'PR', '2017-11-01 12:46:37'),
('PR002', 'prangko 2', 1000, 500, 10000, 2010, 'PR', '2017-11-01 12:46:37'),
('PR003', 'prangko 3', 1000, 200, 10000, 2010, 'PR', '2017-11-01 12:46:37'),
('PR004', 'Prangko 4', 5000, 1000, 10000, 2010, 'PR', '2017-11-01 12:46:37'),
('PR009', 'prangko 98', 2000, 1000, 10000, 2009, 'PR', '2017-11-01 12:46:37'),
('PR010', 'prangko 10', 2000, 1500, 10000, 2010, 'PR', '2017-11-01 12:46:37'),
('PR011', 'prangko 11', 1500, 1000, 10000, 2010, 'PR', '2017-11-01 12:46:37'),
('PS001', 'pr 1', 1000, 200, 10000, 2010, 'PS', '2017-11-01 12:46:37'),
('SHP001', 'shp01', 2000, 1000, 10000, 2010, 'SHP', '2017-11-01 12:46:37'),
('SHPSS00', 'shpss017', 1000, 500, 10000, 2011, 'SHPSS', '2017-11-01 12:46:37'),
('SS001', 'ss 1', 2000, 1200, 10000, 2011, 'SS', '2017-11-01 12:46:37'),
('SS002', 'sci 2', 1000, 800, 10000, 2000, 'SS', '2017-11-01 12:46:37');

-- --------------------------------------------------------

--
-- Table structure for table `tb_user`
--

CREATE TABLE `tb_user` (
  `username` varchar(20) NOT NULL,
  `password` varchar(30) DEFAULT NULL,
  `nama_user` varchar(50) DEFAULT NULL,
  `nik` varchar(12) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tb_user`
--

INSERT INTO `tb_user` (`username`, `password`, `nama_user`, `nik`) VALUES
('amad', 'amad', 'amad', '111');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `tb_hapus_produk`
--
ALTER TABLE `tb_hapus_produk`
  ADD PRIMARY KEY (`id_produk`);

--
-- Indexes for table `tb_jenis_produk`
--
ALTER TABLE `tb_jenis_produk`
  ADD PRIMARY KEY (`id_jenis_produk`);

--
-- Indexes for table `tb_pemesanan`
--
ALTER TABLE `tb_pemesanan`
  ADD PRIMARY KEY (`no_pemesanan`),
  ADD KEY `fk_id_jenis_produk_pemesanan` (`id_jenis_produk`);

--
-- Indexes for table `tb_produk`
--
ALTER TABLE `tb_produk`
  ADD PRIMARY KEY (`id_produk`),
  ADD KEY `fk_id_jenis_produk` (`id_jenis_produk`);

--
-- Indexes for table `tb_regional`
--
ALTER TABLE `tb_regional`
  ADD PRIMARY KEY (`id_regional`);

--
-- Indexes for table `tb_suplier`
--
ALTER TABLE `tb_suplier`
  ADD PRIMARY KEY (`id_suplier`);

--
-- Indexes for table `tb_trans_penerimaan`
--
ALTER TABLE `tb_trans_penerimaan`
  ADD PRIMARY KEY (`no_order`),
  ADD KEY `fk_id_produk_penerimaan` (`no_pemesanan`),
  ADD KEY `fk_id_suplier_penerimaan` (`id_suplier`);

--
-- Indexes for table `tb_trans_pengeluaran`
--
ALTER TABLE `tb_trans_pengeluaran`
  ADD PRIMARY KEY (`id_pengeluaran`),
  ADD KEY `fk_id_produk_pengeluaran` (`id_produk`),
  ADD KEY `fk_id_reg_pengeluaran` (`id_regional`);

--
-- Indexes for table `tb_trans_pengembalian`
--
ALTER TABLE `tb_trans_pengembalian`
  ADD PRIMARY KEY (`id_pengembalian`),
  ADD KEY `fk_id_produk_pengembalian` (`id_produk`),
  ADD KEY `fk_id_reg_pengembalian` (`id_regional`);

--
-- Indexes for table `tb_user`
--
ALTER TABLE `tb_user`
  ADD PRIMARY KEY (`username`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `tb_pemesanan`
--
ALTER TABLE `tb_pemesanan`
  ADD CONSTRAINT `fk_id_jenis_produk_pemesanan` FOREIGN KEY (`id_jenis_produk`) REFERENCES `tb_jenis_produk` (`id_jenis_produk`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `tb_produk`
--
ALTER TABLE `tb_produk`
  ADD CONSTRAINT `fk_id_jenis_produk` FOREIGN KEY (`id_jenis_produk`) REFERENCES `tb_jenis_produk` (`id_jenis_produk`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `tb_trans_penerimaan`
--
ALTER TABLE `tb_trans_penerimaan`
  ADD CONSTRAINT `fk_id_suplier` FOREIGN KEY (`id_suplier`) REFERENCES `tb_suplier` (`id_suplier`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_no_pemesanan` FOREIGN KEY (`no_pemesanan`) REFERENCES `tb_pemesanan` (`no_pemesanan`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `tb_trans_pengeluaran`
--
ALTER TABLE `tb_trans_pengeluaran`
  ADD CONSTRAINT `fk_id_produk_pengeluaran` FOREIGN KEY (`id_produk`) REFERENCES `tb_produk` (`id_produk`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_id_reg_pengeluaran` FOREIGN KEY (`id_regional`) REFERENCES `tb_regional` (`id_regional`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `tb_trans_pengembalian`
--
ALTER TABLE `tb_trans_pengembalian`
  ADD CONSTRAINT `fk_id_produk_pengembalian` FOREIGN KEY (`id_produk`) REFERENCES `tb_produk` (`id_produk`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_id_reg_pengembalian` FOREIGN KEY (`id_regional`) REFERENCES `tb_regional` (`id_regional`) ON DELETE CASCADE ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
