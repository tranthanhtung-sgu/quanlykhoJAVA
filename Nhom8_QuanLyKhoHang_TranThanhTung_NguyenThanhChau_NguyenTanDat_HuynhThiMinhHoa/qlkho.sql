-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Jun 28, 2020 at 03:47 PM
-- Server version: 10.4.11-MariaDB
-- PHP Version: 7.4.5

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `qlkho`
--

-- --------------------------------------------------------

--
-- Table structure for table `chitietphieuxuat`
--

CREATE TABLE `chitietphieuxuat` (
  `MaPhieuXuat` char(10) NOT NULL,
  `MaHH` char(10) NOT NULL,
  `MaKho` char(10) NOT NULL,
  `Soluong` int(11) NOT NULL,
  `Dongia` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `chitietphieuxuat`
--

INSERT INTO `chitietphieuxuat` (`MaPhieuXuat`, `MaHH`, `MaKho`, `Soluong`, `Dongia`) VALUES
('PX006', 'HH02', 'KHO1', 1, 1);

-- --------------------------------------------------------

--
-- Table structure for table `ctpn`
--

CREATE TABLE `ctpn` (
  `MaPhieuNhap` char(10) NOT NULL,
  `MaHH` char(10) NOT NULL,
  `MaKho` char(10) NOT NULL,
  `Soluong` int(11) NOT NULL,
  `Dongia` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `ctpn`
--

INSERT INTO `ctpn` (`MaPhieuNhap`, `MaHH`, `MaKho`, `Soluong`, `Dongia`) VALUES
('PN006', 'HH02', 'KHO1', 90, 30000),
('PN007', 'HH02', 'KHO1', 20, 30000),
('PN008', 'HH02', 'KHO1', 90, 30000);

-- --------------------------------------------------------

--
-- Table structure for table `dangnhap`
--

CREATE TABLE `dangnhap` (
  `taikhoan` char(255) NOT NULL,
  `matkhau` char(255) NOT NULL,
  `phanquyen` char(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `dangnhap`
--

INSERT INTO `dangnhap` (`taikhoan`, `matkhau`, `phanquyen`) VALUES
('', '', 'admin'),
('admin', 'admin', 'admin'),
('tuandat', 'tuandat', 'nhanvien'),
('tuandat1', 'nguyendat', 'admin'),
('tung', 'tung', 'manager');

-- --------------------------------------------------------

--
-- Table structure for table `danhmuchanghoa`
--

CREATE TABLE `danhmuchanghoa` (
  `MaHH` char(10) NOT NULL COMMENT 'Mã hàng hoá',
  `TenHH` varchar(255) NOT NULL COMMENT 'Tên hàng hoá',
  `MaNhom` char(10) NOT NULL COMMENT 'Mã nhóm',
  `Donvitinh` int(10) NOT NULL COMMENT 'Đơn vị tính',
  `TongSoluong` int(11) NOT NULL COMMENT 'Tổng số lượng',
  `HinhAnh` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `danhmuchanghoa`
--

INSERT INTO `danhmuchanghoa` (`MaHH`, `TenHH`, `MaNhom`, `Donvitinh`, `TongSoluong`, `HinhAnh`) VALUES
('HH01', 'Túi sách ', 'N04', 1, 100, 'bdc8620709a1cd8eedf99392b2251f2a'),
('HH02', 'Găng tay ', 'N01', 1, 249, '52f261794421142a3e6c2021e588da42'),
('HH03', 'Bột giặt', 'N04', 4, 200, '3eeced3794d86be569f152aa4331e1ad'),
('HH04', 'Nước rửa chén', 'N04', 2, 200, '3eeced3794d86be569f152aa4331e1ad'),
('HH05', 'Quần tây', 'N07', 0, 1000, '3c88ebde4720f81cf6b1b55fe7f85435'),
('HH06', 'Áo thun ', 'N07', 0, 1000, '9e1e0e6c05dd64e73841cb41d2acb3b2'),
('HH07', 'Sửa rửa mặt', 'N04', 4, 1000, 'a2a1f03a19c382ec6e1526a238179938'),
('HH08', 'Kem đánh răng', 'N04', 4, 1000, '9a0e999665fe76cb54c74c9c1034fe8d'),
('HH09', 'bàn chải', 'N04', 0, 2000, '5e28a6ed4c3666657bb037c6fc0210bc');

-- --------------------------------------------------------

--
-- Table structure for table `danhmucnhom`
--

CREATE TABLE `danhmucnhom` (
  `MaNhom` char(10) NOT NULL COMMENT 'Mã nhóm',
  `TenNhom` varchar(255) NOT NULL COMMENT 'Tên nhóm'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `danhmucnhom`
--

INSERT INTO `danhmucnhom` (`MaNhom`, `TenNhom`) VALUES
('N01', 'Thuc an'),
('N02', 'Thuc an dong hop'),
('N03', 'Đồ Điện Tử'),
('N04', 'Đồ GiaDụng '),
('N05', 'Test'),
('N06', 'Thức uống'),
('N07', 'Thời trang');

-- --------------------------------------------------------

--
-- Table structure for table `kho`
--

CREATE TABLE `kho` (
  `MaKho` char(10) NOT NULL COMMENT 'Mã kho',
  `TenKho` varchar(255) NOT NULL COMMENT 'Tên Kho',
  `Diachi` varchar(255) NOT NULL COMMENT 'Địa chỉ',
  `Sodt` char(11) NOT NULL COMMENT 'Số điện thoại',
  `Noidung` varchar(255) DEFAULT NULL COMMENT 'Nội dung'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `kho`
--

INSERT INTO `kho` (`MaKho`, `TenKho`, `Diachi`, `Sodt`, `Noidung`) VALUES
('KHO1', 'Kho số 1', 'Tân Bình TP HCM', '0123456789', 'Kho hiện đang có các mặt hàng về quần áo '),
('KHO10', 'Kho số 10', 'Q1 TP HCM', '0123456789', 'Kho hiện đang có mặt hàng thức ăn đóng hộp'),
('KHO12', 'Kho so 12', ' Ba Đình Hà Nội', '0123456789', 'Kho hiện đang có mặt hàng thức ăn đóng hộp'),
('KHO13', 'Kho so 13', 'Cẩm Lệ Đà Nẵng', '0123456789', 'null'),
('KHO2', 'Kho so 2', 'Liên Chiểu Đà Nẵng', '0123456789', 'Kho hiện đang có mặt hàng thức ăn đóng hộp'),
('KHO23', 'Kho so 23', 'Từ Liêm Hà Nội', '0123456789', 'null'),
('KHO24', 'Kho so 24', 'Cầu Giấy Hà Nội', '0123456789', 'nulls'),
('KHO26', 'Kho so 26', 'Sơn Trà Đà Nẵng', '0123456789', 'null'),
('KHO29', 'Kho so 29', 'Bình Thanh TPHCM', '0123456789', 'nulls'),
('KHO5', 'Kho so 5', 'Thủ ĐỨc TP HCM', '0123456789', 'null'),
('KHO7', 'Kho so 7', 'Gò Vấp Tp HCM', '0123456789', 'null'),
('KHO8', 'Kho so 8', 'Bình Tân Tp HCM', '0123456789', 'null'),
('KHO845', 'Kho so 845', 'Từ Liêm Hà Nội', '0123456789', 'null');

-- --------------------------------------------------------

--
-- Table structure for table `khohanghoa`
--

CREATE TABLE `khohanghoa` (
  `MaHH` char(10) CHARACTER SET utf8 NOT NULL,
  `MaKho` char(10) CHARACTER SET utf8 NOT NULL,
  `Soluong` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `khohanghoa`
--

INSERT INTO `khohanghoa` (`MaHH`, `MaKho`, `Soluong`) VALUES
('HH02', 'KHO2', 50),
('HH02', 'KHO7', 50);

-- --------------------------------------------------------

--
-- Table structure for table `nhacungcap`
--

CREATE TABLE `nhacungcap` (
  `MaNCC` char(10) NOT NULL COMMENT 'Mã nhà cung cấp',
  `TenNCC` varchar(255) NOT NULL COMMENT 'Tên nhà cung cấp',
  `Diachi` varchar(255) NOT NULL COMMENT 'Địa chỉ',
  `Sodt` char(11) NOT NULL COMMENT 'Số điện thoại',
  `Email` char(255) NOT NULL COMMENT 'Email',
  `Ghichu` varchar(255) NOT NULL COMMENT 'Ghi chú'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `nhacungcap`
--

INSERT INTO `nhacungcap` (`MaNCC`, `TenNCC`, `Diachi`, `Sodt`, `Email`, `Ghichu`) VALUES
('NCC001', 'Nhà Cung Cấp Thực Phẩm', '1/2/3/4/5', '123456789', 'ncctp@gmail.com', 'null'),
('NCC002', 'Nhà Cung Cấp Giày Dép', 'qweqwe1/2/3/4/5', '123456789', 'ncctp@gmail.com', 'nullqweqweqw'),
('NCC003', 'Đại lý Long Hải.', ' 26 lk 1 - tiểu khu đô thị vạn phúc hà đông - hà nội.', '0977547120', 'dailyhailong2gmail.com', 'phân phối xúc xích, lạp sườn , chả viên cá basa. ..... các lọa rau củ quả. thế mạnh của đại lý long hải chuyên phân phối các loại xúc xích...\r\n '),
('NCC004', 'Thương hiệu mỹ phẩm LamCosMe', '102-B3 Trung tự (Ngõ 46C Phạm Ngọc Thạch), HN', '0979328823', ' myphamLamCosMe@gmail.com', 'phân phối dòng mỹ phẩm Nước Hoa Bút và Nước Rửa Tay Khô trên toàn quốc'),
('NCC005', 'công ty TNHH V.N.I.M ', 'Tầng 1, tòa nhà 41 - A1, ngõ 106/39 Hoàng Quốc Việt, Cầu Giấy, Hà Nội.', '0903 481 3', ' congtyTNHHVNIM @gmail.com', 'nhà nhập khẩu các sản phẩm hàng tiêu dùng CHẤT LƯỢNG CAO của các nước có công nghệ sản xuất tiên tiến nhất.\r\n ');

-- --------------------------------------------------------

--
-- Table structure for table `nhanvien`
--

CREATE TABLE `nhanvien` (
  `MaNV` char(10) NOT NULL COMMENT 'Mã nhân viên',
  `TenNV` varchar(255) NOT NULL COMMENT 'Tên nhân viên',
  `Diachi` varchar(255) NOT NULL COMMENT 'Địa chỉ',
  `Sodt` char(11) NOT NULL COMMENT 'Số điện thoại',
  `Email` char(255) NOT NULL COMMENT 'Email'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `nhanvien`
--

INSERT INTO `nhanvien` (`MaNV`, `TenNV`, `Diachi`, `Sodt`, `Email`) VALUES
('NV001', 'Hoàng Cẩm Hoàng', '123 Hai Bà Trưng Bến Nghé Q1 HCM', '123456789', 'nvn001@gmail.com'),
('NV002', 'Trần Hoàng Hùng', '23 Lê Trọng Tấn Tây Thanh Tân Bình HCM', '123456789', 'nvn001@gmail.com'),
('NV003', 'Nguyễn Thị Kim Liên', '65 CMT8 P10 Tân Bình HCM', '123456789', 'nvn001@gmail.com'),
('NV004', 'TRần Quốc Anh', '233 Hồ Bá Kiện P3 Q10 HCM', '123456789', 'nvn001@gmail.com'),
('NV005', 'Hoàng Thùy Linh', '88 Trường Sơn P5 Q10 HCM', '123456789', 'nvn001@gmail.com');

-- --------------------------------------------------------

--
-- Table structure for table `phieunhap`
--

CREATE TABLE `phieunhap` (
  `MaPhieuNhap` char(10) NOT NULL COMMENT 'Mã phiếu nhập',
  `MaNCC` char(10) NOT NULL COMMENT 'Mã nhà cung cấp',
  `MaNV` char(10) NOT NULL COMMENT 'Mã nhân viên',
  `NgayNhap` date NOT NULL COMMENT 'Ngày nhập',
  `Nguoigiao` varchar(255) NOT NULL COMMENT 'Người giao',
  `Noidung` varchar(255) NOT NULL COMMENT 'Nội dung'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `phieunhap`
--

INSERT INTO `phieunhap` (`MaPhieuNhap`, `MaNCC`, `MaNV`, `NgayNhap`, `Nguoigiao`, `Noidung`) VALUES
('PN0010', 'NCC002', 'NV001', '2020-06-02', 'Người giao 1asasdas', 'nullasdasdaqwe'),
('PN003', 'NCC001', 'NV005', '2020-06-12', 'Người giao 1asasdas', 'nullasdasdaqwe'),
('PN004', 'NCC002', 'NV001', '2020-06-02', 'Người giao 1asasdas', 'nullasdasdaqwe'),
('PN006', 'NCC001', 'NV002', '2020-06-02', 'Người giao 1asasdas', 'asdasasd'),
('PN007', 'NCC001', 'NV002', '2020-06-02', 'Người giao 1asasdas', 'asdasasd'),
('PN008', 'NCC002', 'NV003', '2020-06-24', 'Tung', 'khong co');

-- --------------------------------------------------------

--
-- Table structure for table `phieuxuat`
--

CREATE TABLE `phieuxuat` (
  `MaPhieuXuat` char(10) NOT NULL COMMENT 'Mã phiếu xuất',
  `MaNV` char(10) NOT NULL COMMENT 'Mã nhân viên',
  `Ngayxuat` date NOT NULL,
  `Nguoinhan` varchar(255) NOT NULL COMMENT 'Người nhận',
  `Noidung` varchar(255) NOT NULL COMMENT 'Nội dung'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `phieuxuat`
--

INSERT INTO `phieuxuat` (`MaPhieuXuat`, `MaNV`, `Ngayxuat`, `Nguoinhan`, `Noidung`) VALUES
('PX001', 'NV001', '2020-06-09', 'Người thứ 1', 'qeqweqnull'),
('PX002', 'NV002', '2020-06-09', 'Người thứ 1', 'test'),
('PX003', 'NV002', '2020-06-09', 'Người thứ 1', 'test'),
('PX004', 'NV002', '2020-06-09', 'Người thứ 1', 'test'),
('PX005', 'NV001', '2020-06-09', 'Người thứ 1', 'qeqweqnull'),
('PX006', 'NV001', '2020-06-09', 'Người thứ 1', 'qeqweqnull');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `chitietphieuxuat`
--
ALTER TABLE `chitietphieuxuat`
  ADD UNIQUE KEY `MaPhieuXuat` (`MaPhieuXuat`,`MaHH`,`MaKho`),
  ADD KEY `MaHH` (`MaHH`),
  ADD KEY `MaKho` (`MaKho`);

--
-- Indexes for table `ctpn`
--
ALTER TABLE `ctpn`
  ADD UNIQUE KEY `MaPhieuNhap` (`MaPhieuNhap`,`MaHH`,`MaKho`),
  ADD KEY `MaHH` (`MaHH`),
  ADD KEY `ctpn_ibfk_3` (`MaKho`);

--
-- Indexes for table `dangnhap`
--
ALTER TABLE `dangnhap`
  ADD PRIMARY KEY (`taikhoan`);

--
-- Indexes for table `danhmuchanghoa`
--
ALTER TABLE `danhmuchanghoa`
  ADD PRIMARY KEY (`MaHH`),
  ADD KEY `MaNhom` (`MaNhom`);

--
-- Indexes for table `danhmucnhom`
--
ALTER TABLE `danhmucnhom`
  ADD PRIMARY KEY (`MaNhom`);

--
-- Indexes for table `kho`
--
ALTER TABLE `kho`
  ADD PRIMARY KEY (`MaKho`);

--
-- Indexes for table `khohanghoa`
--
ALTER TABLE `khohanghoa`
  ADD KEY `MaHH_2` (`MaHH`,`MaKho`) USING BTREE,
  ADD KEY `khohanghoa_ibfk_1` (`MaKho`);

--
-- Indexes for table `nhacungcap`
--
ALTER TABLE `nhacungcap`
  ADD PRIMARY KEY (`MaNCC`);

--
-- Indexes for table `nhanvien`
--
ALTER TABLE `nhanvien`
  ADD PRIMARY KEY (`MaNV`);

--
-- Indexes for table `phieunhap`
--
ALTER TABLE `phieunhap`
  ADD PRIMARY KEY (`MaPhieuNhap`),
  ADD KEY `PhieuNhap_ibfk_1` (`MaNCC`),
  ADD KEY `PhieuNhap_ibfk_2` (`MaNV`);

--
-- Indexes for table `phieuxuat`
--
ALTER TABLE `phieuxuat`
  ADD PRIMARY KEY (`MaPhieuXuat`),
  ADD KEY `PhieuXuat_ibfk_2` (`MaNV`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `chitietphieuxuat`
--
ALTER TABLE `chitietphieuxuat`
  ADD CONSTRAINT `chitietphieuxuat_ibfk_1` FOREIGN KEY (`MaPhieuXuat`) REFERENCES `phieuxuat` (`MaPhieuXuat`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `chitietphieuxuat_ibfk_2` FOREIGN KEY (`MaHH`) REFERENCES `danhmuchanghoa` (`MaHH`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `chitietphieuxuat_ibfk_3` FOREIGN KEY (`MaKho`) REFERENCES `kho` (`MaKho`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `ctpn`
--
ALTER TABLE `ctpn`
  ADD CONSTRAINT `ctpn_ibfk_1` FOREIGN KEY (`MaPhieuNhap`) REFERENCES `phieunhap` (`MaPhieuNhap`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `ctpn_ibfk_2` FOREIGN KEY (`MaHH`) REFERENCES `danhmuchanghoa` (`MaHH`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `ctpn_ibfk_3` FOREIGN KEY (`MaKho`) REFERENCES `kho` (`MaKho`);

--
-- Constraints for table `danhmuchanghoa`
--
ALTER TABLE `danhmuchanghoa`
  ADD CONSTRAINT `danhmuchanghoa_ibfk_1` FOREIGN KEY (`MaNhom`) REFERENCES `danhmucnhom` (`MaNhom`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `khohanghoa`
--
ALTER TABLE `khohanghoa`
  ADD CONSTRAINT `khohanghoa_ibfk_1` FOREIGN KEY (`MaKho`) REFERENCES `kho` (`MaKho`) ON DELETE CASCADE,
  ADD CONSTRAINT `khohanghoa_ibfk_2` FOREIGN KEY (`MaHH`) REFERENCES `danhmuchanghoa` (`MaHH`) ON DELETE CASCADE;

--
-- Constraints for table `phieunhap`
--
ALTER TABLE `phieunhap`
  ADD CONSTRAINT `phieunhap_ibfk_1` FOREIGN KEY (`MaNCC`) REFERENCES `nhacungcap` (`MaNCC`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `phieunhap_ibfk_2` FOREIGN KEY (`MaNV`) REFERENCES `nhanvien` (`MaNV`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `phieuxuat`
--
ALTER TABLE `phieuxuat`
  ADD CONSTRAINT `PhieuXuat_ibfk_2` FOREIGN KEY (`MaNV`) REFERENCES `nhanvien` (`MaNV`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
