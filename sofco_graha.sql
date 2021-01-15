-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Waktu pembuatan: 15 Jan 2021 pada 04.04
-- Versi server: 10.1.39-MariaDB
-- Versi PHP: 7.1.29

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `sofco_graha`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `barang`
--

CREATE TABLE `barang` (
  `Id` int(11) NOT NULL,
  `Nama` varchar(50) NOT NULL,
  `Harga` int(11) NOT NULL,
  `Is_Delete` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `barang`
--

INSERT INTO `barang` (`Id`, `Nama`, `Harga`, `Is_Delete`) VALUES
(1, 'iPhone X', 14000000, 0),
(2, 'iPhone S', 14000000, 0);

-- --------------------------------------------------------

--
-- Struktur dari tabel `order`
--

CREATE TABLE `order` (
  `ID` varchar(100) NOT NULL,
  `NAMA_BARANG` varchar(100) NOT NULL,
  `KET` varchar(200) NOT NULL,
  `JUMLAH` int(11) NOT NULL,
  `NAMA_PEMESAN` varchar(100) NOT NULL,
  `ALAMAT_PEMESAN` varchar(100) NOT NULL,
  `TANGGAL_PESAN` date NOT NULL,
  `NO_REGISTRASI` varchar(100) NOT NULL,
  `IS_DELETE` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Struktur dari tabel `orderku`
--

CREATE TABLE `orderku` (
  `ID` varchar(50) NOT NULL,
  `NAMA_BARANG` varchar(100) NOT NULL,
  `KET` varchar(100) NOT NULL,
  `JUMLAH` int(11) NOT NULL,
  `NAMA_PEMESAN` varchar(50) NOT NULL,
  `ALAMAT_PEMESAN` varchar(100) NOT NULL,
  `TANGGAL_PESAN` date NOT NULL,
  `NO_REGISTRASI` varchar(50) NOT NULL,
  `IS_DELETE` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `orderku`
--

INSERT INTO `orderku` (`ID`, `NAMA_BARANG`, `KET`, `JUMLAH`, `NAMA_PEMESAN`, `ALAMAT_PEMESAN`, `TANGGAL_PESAN`, `NO_REGISTRASI`, `IS_DELETE`) VALUES
('03515ce2-4b9c-4949-9b68-cfe69f64e276', 'Macbook Pro 2019', 'Silver 512 GB', 4, 'Joko Kuncoro', 'Dukuh', '2021-01-15', '8606e46d-9bda-4b09-be5a-6fcb3df1a2d5', 0),
('79dffff0-bda4-4ec7-a81d-a175306e732d', 'Macbook Pro 2018', 'Silver 512 GB', 1, 'Joko Kuncoro', 'Dukuh', '2021-01-15', '80201995-8372-442b-904b-3aa953b7f1e7', 0);

-- --------------------------------------------------------

--
-- Struktur dari tabel `pembeli`
--

CREATE TABLE `pembeli` (
  `Id` int(11) NOT NULL,
  `Nama` varchar(50) NOT NULL,
  `Alamat` text NOT NULL,
  `Kota` varchar(30) NOT NULL,
  `Kode_Pos` varchar(11) NOT NULL,
  `Is_Delete` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Struktur dari tabel `pesanan`
--

CREATE TABLE `pesanan` (
  `Id` int(11) NOT NULL,
  `Id_Pembeli` int(11) NOT NULL,
  `Id_Barang` int(11) NOT NULL,
  `Total` int(20) NOT NULL,
  `Keterangan` varchar(200) NOT NULL,
  `Nomor_Registrasi` varchar(50) NOT NULL,
  `Is_Delete` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Indexes for dumped tables
--

--
-- Indeks untuk tabel `barang`
--
ALTER TABLE `barang`
  ADD PRIMARY KEY (`Id`);

--
-- Indeks untuk tabel `order`
--
ALTER TABLE `order`
  ADD PRIMARY KEY (`ID`);

--
-- Indeks untuk tabel `orderku`
--
ALTER TABLE `orderku`
  ADD PRIMARY KEY (`ID`);

--
-- Indeks untuk tabel `pembeli`
--
ALTER TABLE `pembeli`
  ADD PRIMARY KEY (`Id`);

--
-- Indeks untuk tabel `pesanan`
--
ALTER TABLE `pesanan`
  ADD PRIMARY KEY (`Id`),
  ADD KEY `fk_barang` (`Id_Barang`),
  ADD KEY `fk_pembeli` (`Id_Pembeli`);

--
-- AUTO_INCREMENT untuk tabel yang dibuang
--

--
-- AUTO_INCREMENT untuk tabel `barang`
--
ALTER TABLE `barang`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT untuk tabel `pembeli`
--
ALTER TABLE `pembeli`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT untuk tabel `pesanan`
--
ALTER TABLE `pesanan`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT;

--
-- Ketidakleluasaan untuk tabel pelimpahan (Dumped Tables)
--

--
-- Ketidakleluasaan untuk tabel `pesanan`
--
ALTER TABLE `pesanan`
  ADD CONSTRAINT `fk_barang` FOREIGN KEY (`Id_Barang`) REFERENCES `barang` (`Id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_pembeli` FOREIGN KEY (`Id_Pembeli`) REFERENCES `pembeli` (`Id`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
