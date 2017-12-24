-- phpMyAdmin SQL Dump
-- version 4.6.5.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 24, 2017 at 01:56 AM
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
-- Table structure for table `tb_produk`
--

CREATE TABLE `tb_produk` (
  `id_produk` varchar(11) NOT NULL,
  `nama_produk` varchar(100) NOT NULL,
  `nominal` int(11) NOT NULL,
  `biaya_cetak` float NOT NULL,
  `stok` int(11) NOT NULL,
  `tahun` varchar(4) NOT NULL,
  `id_jenis_produk` varchar(5) DEFAULT NULL,
  `nik` varchar(12) DEFAULT NULL,
  `status` varchar(1) NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tb_produk`
--

INSERT INTO `tb_produk` (`id_produk`, `nama_produk`, `nominal`, `biaya_cetak`, `stok`, `tahun`, `id_jenis_produk`, `nik`, `status`) VALUES
('DF000000001', 'dokumen filateli 1', 12000, 10000, 0, '2017', 'DF', '111', '0'),
('KM000000001', 'kemasan 1', 1500, 1200, 0, '2017', 'KM', '111', '0'),
('MC000000001', 'merchndise 1', 5000, 4600, 0, '2017', 'MC', '111', '0'),
('MS000000001', 'ms 1', 5000, 4500, 0, '2017', 'MS', '111', '0'),
('PR000000001', 'prangko 1', 1500, 1200, 0, '2017', 'PR', '111', '0'),
('PS000000001', 'prisma 1', 4000, 3600, 0, '2017', 'PS', '111', '0'),
('SHPSS000001', 'shpss 1', 5000, 4500, 0, '2017', 'SHPSS', '111', '0'),
('SS000000001', 'ss 1', 4500, 4300, 0, '2017', 'SS', '111', '0');

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

--
-- Dumping data for table `tb_regional`
--

INSERT INTO `tb_regional` (`id_regional`, `regional`, `kode_pos`, `no_telp`, `alamat`) VALUES
('AMT', 'AMUNTAI', '71400', NULL, NULL);

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
-- Table structure for table `tb_trans_pemesanan`
--

CREATE TABLE `tb_trans_pemesanan` (
  `id_pemesanan` varchar(5) NOT NULL,
  `no_pemesanan` varchar(5) NOT NULL,
  `id_produk` varchar(11) NOT NULL,
  `jumlah_pesan` int(11) NOT NULL,
  `tgl_pesan` date NOT NULL,
  `id_suplier` varchar(5) NOT NULL,
  `status` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `tb_trans_penerimaan`
--

CREATE TABLE `tb_trans_penerimaan` (
  `id_penerimaan` varchar(5) NOT NULL,
  `no_order_penerimaan` varchar(14) NOT NULL,
  `tgl_penerimaan` date NOT NULL,
  `jml_terima` int(11) NOT NULL,
  `id_pemesanan` varchar(5) NOT NULL,
  `id_produk` varchar(11) NOT NULL,
  `id_suplier` varchar(5) NOT NULL,
  `stok_awal` int(11) NOT NULL,
  `stok_akhir` int(11) NOT NULL,
  `subtotal_terima` int(11) NOT NULL,
  `sisa_belum_dikirim` int(11) NOT NULL,
  `keterangan` text
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Triggers `tb_trans_penerimaan`
--
DELIMITER $$
CREATE TRIGGER `update_stok_penerimaan` AFTER INSERT ON `tb_trans_penerimaan` FOR EACH ROW BEGIN
	UPDATE tb_produk SET tb_produk.stok=NEW.stok_akhir WHERE tb_produk.id_produk = NEW.id_produk;
    IF(NEW.sisa_belum_dikirim=0) THEN
    UPDATE tb_trans_pemesanan 
    SET tb_trans_pemesanan.status='selesai' WHERE id_pemesanan=NEW.id_pemesanan;
    END IF;
END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `tb_trans_pengembalian`
--

CREATE TABLE `tb_trans_pengembalian` (
  `id_pengembalian` varchar(7) NOT NULL,
  `tgl_pengembalian` date NOT NULL,
  `jml_pengembalian` int(11) NOT NULL,
  `dus` smallint(6) DEFAULT NULL,
  `id_regional` varchar(5) NOT NULL,
  `id_produk` varchar(11) NOT NULL,
  `stok_awal` int(11) NOT NULL,
  `stok_akhir` int(11) NOT NULL,
  `keterangan` text
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Triggers `tb_trans_pengembalian`
--
DELIMITER $$
CREATE TRIGGER `update_stok_pengembalian` AFTER INSERT ON `tb_trans_pengembalian` FOR EACH ROW BEGIN
	UPDATE tb_produk SET tb_produk.stok=NEW.stok_akhir WHERE tb_produk.id_produk=NEW.id_produk;
END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `tb_trans_pengiriman`
--

CREATE TABLE `tb_trans_pengiriman` (
  `id_pengiriman` varchar(5) NOT NULL,
  `no_order_pengiriman` varchar(7) NOT NULL,
  `tgl_pengiriman` date NOT NULL,
  `jml_pengiriman` int(11) NOT NULL,
  `bsu` varchar(12) NOT NULL,
  `id_regional` varchar(5) NOT NULL,
  `id_produk` varchar(11) NOT NULL,
  `stok_awal` int(11) NOT NULL,
  `stok_akhir` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 ROW_FORMAT=COMPACT;

--
-- Triggers `tb_trans_pengiriman`
--
DELIMITER $$
CREATE TRIGGER `update_stok_pengiriman` AFTER INSERT ON `tb_trans_pengiriman` FOR EACH ROW BEGIN
	UPDATE tb_produk SET tb_produk.stok=NEW.stok_akhir WHERE
    tb_produk.id_produk=NEW.id_produk;
END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `tb_user`
--

CREATE TABLE `tb_user` (
  `nik` varchar(12) NOT NULL,
  `password` varchar(30) NOT NULL,
  `nama_user` varchar(50) NOT NULL,
  `hak_akses` varchar(2) NOT NULL,
  `status` varchar(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tb_user`
--

INSERT INTO `tb_user` (`nik`, `password`, `nama_user`, `hak_akses`, `status`) VALUES
('111', 'amad', 'amad', 'FL', ''),
('112', 'diar', 'diar', 'AD', '');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `tb_jenis_produk`
--
ALTER TABLE `tb_jenis_produk`
  ADD PRIMARY KEY (`id_jenis_produk`);

--
-- Indexes for table `tb_produk`
--
ALTER TABLE `tb_produk`
  ADD PRIMARY KEY (`id_produk`),
  ADD KEY `fk_id_jenis_produk` (`id_jenis_produk`),
  ADD KEY `fk_nik` (`nik`);

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
-- Indexes for table `tb_trans_pemesanan`
--
ALTER TABLE `tb_trans_pemesanan`
  ADD PRIMARY KEY (`id_pemesanan`),
  ADD KEY `fk_id_suplier_pemesanan` (`id_suplier`),
  ADD KEY `fk_id_produk_pemesanan` (`id_produk`);

--
-- Indexes for table `tb_trans_penerimaan`
--
ALTER TABLE `tb_trans_penerimaan`
  ADD PRIMARY KEY (`id_penerimaan`),
  ADD KEY `fk_id_produk_penerimaan` (`id_pemesanan`),
  ADD KEY `fk_id_suplier_penerimaan` (`id_suplier`),
  ADD KEY `fk_id_produk_terima` (`id_produk`);

--
-- Indexes for table `tb_trans_pengembalian`
--
ALTER TABLE `tb_trans_pengembalian`
  ADD PRIMARY KEY (`id_pengembalian`),
  ADD KEY `fk_id_reg_pengembalian` (`id_regional`),
  ADD KEY `fk_id_produk` (`id_produk`);

--
-- Indexes for table `tb_trans_pengiriman`
--
ALTER TABLE `tb_trans_pengiriman`
  ADD PRIMARY KEY (`id_pengiriman`),
  ADD KEY `fk_id_produk_pengeluaran` (`id_produk`),
  ADD KEY `fk_id_reg_pengeluaran` (`id_regional`);

--
-- Indexes for table `tb_user`
--
ALTER TABLE `tb_user`
  ADD PRIMARY KEY (`nik`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `tb_produk`
--
ALTER TABLE `tb_produk`
  ADD CONSTRAINT `fk_id_jenis_produk` FOREIGN KEY (`id_jenis_produk`) REFERENCES `tb_jenis_produk` (`id_jenis_produk`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_nik` FOREIGN KEY (`nik`) REFERENCES `tb_user` (`nik`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `tb_trans_pemesanan`
--
ALTER TABLE `tb_trans_pemesanan`
  ADD CONSTRAINT `fk_id_produk_pemesanan` FOREIGN KEY (`id_produk`) REFERENCES `tb_produk` (`id_produk`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_id_suplier_pemesanan` FOREIGN KEY (`id_suplier`) REFERENCES `tb_suplier` (`id_suplier`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `tb_trans_penerimaan`
--
ALTER TABLE `tb_trans_penerimaan`
  ADD CONSTRAINT `fk_id_pemesanan` FOREIGN KEY (`id_pemesanan`) REFERENCES `tb_trans_pemesanan` (`id_pemesanan`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_id_produk_terima` FOREIGN KEY (`id_produk`) REFERENCES `tb_produk` (`id_produk`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_id_suplier` FOREIGN KEY (`id_suplier`) REFERENCES `tb_suplier` (`id_suplier`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `tb_trans_pengembalian`
--
ALTER TABLE `tb_trans_pengembalian`
  ADD CONSTRAINT `fk_id_produk` FOREIGN KEY (`id_produk`) REFERENCES `tb_produk` (`id_produk`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_id_regional` FOREIGN KEY (`id_regional`) REFERENCES `tb_regional` (`id_regional`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `tb_trans_pengiriman`
--
ALTER TABLE `tb_trans_pengiriman`
  ADD CONSTRAINT `fk_id_produk_pengiriman` FOREIGN KEY (`id_produk`) REFERENCES `tb_produk` (`id_produk`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_id_regional_pengiriman` FOREIGN KEY (`id_regional`) REFERENCES `tb_regional` (`id_regional`) ON DELETE CASCADE ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
