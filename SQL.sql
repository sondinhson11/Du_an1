﻿use master
go
drop DATABASE DuAn1_QuanLyBanQuanAo
go
CREATE DATABASE DuAn1_QuanLyBanQuanAo
GO
USE DuAn1_QuanLyBanQuanAo
GO


CREATE TABLE ChucVu(
	MaCV INT IDENTITY(1, 1)NOT NULL,
	TenCV NVARCHAR(50) not null,
	NgayTao date not null,
	NgaySua date not null,
	TrangThai BIT DEFAULT 1 NOT NULL,
	PRIMARY KEY(MaCV)
)


insert into ChucVu values
(N'Quản Lý','2002-12-12','2002-12-12',DEFAULT),
(N'Nhân Viên','2002-12-12','2002-12-12',DEFAULT)

CREATE TABLE NHANVIEN(
	MaNV  INT IDENTITY(1, 1),
	MaCV int not null,
	TenNV NVARCHAR(30) NOT NULL,
	DiaChi NVARCHAR(50) NOT NULL,
	GioiTinh BIT DEFAULT 1 NOT NULL,
	Email VARCHAR(30) NOT NULL,
	SoDienThoai VARCHAR(12) NOT NULL,
	NgaySinh DATE NOT NULL,
	NgayTao date not null,
	NgaySua date not null,
	TrangThai BIT DEFAULT 1 NOT NULL
	PRIMARY KEY(MaNV),
	FOREIGN KEY(MaCV) REFERENCES dbo.ChucVu(MaCV),
)

CREATE TABLE KHACHHANG(
	MaKH INT IDENTITY(1, 1),
	TenKH NVARCHAR(30) NOT NULL,
	NgaySinh DATE,
	GioiTinh BIT DEFAULT 1 NULL,
	SoDienThoai VARCHAR(12) NOT NULL,
	DiaChi NVARCHAR(50),
	NgayTao date not null,
	NgaySua date not null,
	TrangThai BIT DEFAULT 1 NOT NULL

	PRIMARY KEY(MaKH)
)

ALTER TABLE KHACHHANG
ALTER COLUMN SoDienThoai varchar(12) null 

ALTER TABLE KHACHHANG
ALTER COLUMN TenKH nvarchar(30) null 

CREATE TABLE HINHTHUCTHANHTOAN(
	MaHTTT INT IDENTITY(1, 1)NOT NULL,
	TenHTTT NVARCHAR(30) NOT NULL,
	NgayTao date not null,
	NgaySua date not null,
	TrangThai BIT DEFAULT 1 NOT NULL

	PRIMARY KEY(MaHTTT)
)


INSERT INTO dbo.HINHTHUCTHANHTOAN
(
    TenHTTT,
    TrangThai,
	NgayTao,
	NgaySua
)
VALUES
(   N'Tiền mặt',DEFAULT ,'2021-01-01','2021-01-01'),
(   N'Quẹt thẻ',DEFAULT ,'2021-01-01','2021-01-01'),
(   N'Chuyển khoản',DEFAULT  ,'2021-01-01','2021-01-01')

CREATE TABLE SANPHAM(
	MaSP INT IDENTITY(1, 1) NOT NULL,
	TenSp nvarchar(50) NOT NULL,
	NgayTao date not null,
	NgaySua date not null,
	TrangThai BIT DEFAULT 1 NOT NULL
	PRIMARY KEY(MaSP)
)



CREATE TABLE LOAISP(
	MaLoai INT IDENTITY(1, 1)NOT NULL,
	TenLoai NVARCHAR(30) NOT NULL,
	NgayTao date not null,
	NgaySua date not null,
	TrangThai BIT DEFAULT 1 NOT NULL
	PRIMARY KEY(MaLoai)
   
)


CREATE TABLE MAUSAC(
	MaMauSac int IDENTITY(1, 1) NOT NULL,
	TenMauSac NVARCHAR(15) NOT NULL,
	NgayTao date not null,
	NgaySua date not null,
	TrangThai BIT DEFAULT 1 NOT NULL
	PRIMARY KEY(MaMauSac)
)

CREATE TABLE CHATLIEU(
	MaChatLieu INT IDENTITY(1, 1) NOT NULL,
	TenChatLieu NVARCHAR(15) NOT NULL,
	NgayTao date not null,
	NgaySua date not null,
	TrangThai BIT DEFAULT 1 NOT NULL
	PRIMARY KEY(MaChatLieu)
)


CREATE TABLE KICHTHUOC(
	MaKichThuoc INT IDENTITY(1, 1) NOT NULL,
	KichThuoc VARCHAR(15) NOT NULL,
	NgayTao date not null,
	NgaySua date not null,
	TrangThai BIT DEFAULT 1 NOT NULL
	PRIMARY KEY(MaKichThuoc)
)


CREATE TABLE KHUYENMAI(
	MaKM INT IDENTITY(1, 1) NOT NULL,
	TenKM NVARCHAR(50) NOT NULL,
	NgayBatDau DATE,
	NgayKetThuc DATE,
	GiamGia FLOAT NOT NULL,
	NgayTao date not null,
	NgaySua date not null,
	TrangThai BIT DEFAULT 1 NOT NULL
	PRIMARY KEY(MaKM)
)

CREATE TABLE HOADON(
	MaHD INT IDENTITY(1375328, 1) NOT NULL,
	MaKH INT NOT NULL,
	MaNV INT NOT NULL,	
	MaHTTT INT NOT NULL,
	MaKM int NOT NULL,	
	NgayKhoiTao DATE DEFAULT(GETDATE()) NOT NULL,
	GhiChu NVARCHAR(100) NULL,
	TienShip MONEY NULL,
	NgayTao date not null,
	NgaySua date not null,
	TrangThai BIT DEFAULT 1 NOT NULL
	PRIMARY KEY(MaHD)
	FOREIGN KEY(MaKH) REFERENCES dbo.KHACHHANG(MaKH),
	FOREIGN KEY(MaNV) REFERENCES dbo.NHANVIEN(MaNV),
	FOREIGN KEY(MaKM) REFERENCES dbo.KHUYENMAI(MaKM),
	FOREIGN KEY(MaHTTT) REFERENCES dbo.HINHTHUCTHANHTOAN(MaHTTT)
)

CREATE TABLE MONTHETHAO(
	MAMTT INT IDENTITY(1, 1),
	TENMTT NVARCHAR(10) NOT NULL,
	NGAYTAO DATE NOT NULL,
	NGAYSUA DATE NOT NULL,
	TRANGTHAI BIT DEFAULT 1 NOT NULL,
	PRIMARY KEY(MAMTT),
)

CREATE TABLE CLB(
	MACLB INT IDENTITY(1, 1),
	MAMTT INT,
	TENCLB NVARCHAR(100) NULL,
	NGAYTAO DATE NOT NULL,
	NGAYSUA DATE NOT NULL,
	TRANGTHAI BIT DEFAULT 1 NOT NULL,
	PRIMARY KEY(MACLB),
	FOREIGN KEY(MAMTT) REFERENCES dbo.MONTHETHAO(MAMTT),

)

CREATE TABLE CHITIETSANPHAM(
	MaCTSP INT IDENTITY(1,1),
	MaSP INT NOT NULL,
	MaLoai INT NOT NULL,
	MaMauSac int NOT NULL,
	MaKichThuoc INT NOT NULL,
	MaChatLieu INT NOT NULL,
	MaMTT INT NOT NULL,
	SoLuong INT NOT NULL,
	Gia FLOAT NOT NULL,
	NgayTao date not null,
	NgaySua date not null,
	TrangThai BIT DEFAULT 1 NOT NULL
	
	PRIMARY KEY(MaCTSP)
	FOREIGN KEY(MaSP) REFERENCES SanPham(MaSP),
	FOREIGN KEY(MaMauSac) REFERENCES dbo.MAUSAC(MaMauSac),
	FOREIGN KEY(MaChatLieu) REFERENCES dbo.CHATLIEU(MaChatLieu),
	FOREIGN KEY(MaKichThuoc) REFERENCES dbo.KICHTHUOC(MaKichThuoc),
	FOREIGN KEY(MaLoai) REFERENCES dbo.LOAISP(MaLoai),
	FOREIGN KEY(MaMTT) REFERENCES dbo.MONTHETHAO(MAMTT),

)


ALTER TABLE HOADON
ALTER COLUMN MaKH int null 

ALTER TABLE HOADON
ALTER COLUMN MaHTTT int null 

CREATE TABLE HOADONCHITIET(
	MaHDCT INT IDENTITY(1, 1),
	MaHD INT NOT NULL,
	MaCTSP INT NOT NULL,
	SoLuong INT NOT NULL,
	Gia FLOAT NOT NULL,
	GiamGia FLOAT NULL,
	ThanhTien FLOAT NOT NULL,
	GhiChu NVARCHAR(100) NULL,
	NgayTao date not null,
	NgaySua date not null,
	TrangThai BIT DEFAULT 1 NOT NULL

	PRIMARY KEY(MaHDCT)
	FOREIGN KEY(MaHD) REFERENCES dbo.HOADON(MaHD),
	FOREIGN KEY(MaCTSP) REFERENCES dbo.CHITIETSANPHAM(MaCTSP)
)
CREATE TABLE USERR(
	MaNV INT,
	MaCV int,
	Mk nvarchar(max)
	FOREIGN KEY(MaNV) REFERENCES dbo.NHANVIEN(MaNV),
	FOREIGN KEY(MaCV) REFERENCES dbo.CHUCVU(MaCV)
)


CREATE TABLE THONGKE(
	MaTK INT IDENTITY(1, 1),
	MaHDCT INT NOT NULL,
	TongTien MONEY not null,
	NgayBan date not null,
	TrangThai BIT DEFAULT 1 NOT NULL,
	FOREIGN KEY(MaHDCT) REFERENCES dbo.HOADONCHITIET(MaHDCT),

)
