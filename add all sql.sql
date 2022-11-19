select * from CHATLIEU
delete CHITIETSANPHAM
delete ChucVu
delete CLB
delete DoiTra
delete HINHTHUCTHANHTOAN
delete HOADON
delete KHACHHANG
delete MAUSAC
delete NHANVIEN
delete SANPHAM
delete USERR
delete LOAISP
delete KICHTHUOC
delete MONTHETHAO
delete KHUYENMAI



insert into CHATLIEU values (N'CL1','2003-03-03','2009-09-09',0)
insert into CHATLIEU values (N'CL2','2003-03-03','2009-09-09',1)
insert into CHATLIEU values (N'CL3','2003-03-03','2009-09-09',0)
insert into CHATLIEU values (N'CL4','2003-03-03','2009-09-09',1)
insert into CHATLIEU values (N'CL5','2003-03-03','2009-09-09',0)

insert into MAUSAC values (N'MS1','2003-01-01','2002-02-02',0)
insert into MAUSAC values (N'MS2','2003-01-01','2002-02-02',1)
insert into MAUSAC values (N'MS3','2003-01-01','2002-02-02',1)
insert into MAUSAC values (N'MS4','2003-01-01','2002-02-02',1)
insert into MAUSAC values (N'MS4','2003-01-01','2002-02-02',0)

insert into ChucVu values (N'CV1','2003-01-01','2002-02-02',0)
insert into ChucVu values (N'CV2','2003-01-01','2002-02-02',1)
insert into ChucVu values (N'CV3','2003-01-01','2002-02-02',0)
insert into ChucVu values (N'CV4','2003-01-01','2002-02-02',1)
insert into ChucVu values (N'CV5','2003-01-01','2002-02-02',0)

insert into SANPHAM values (N'SP1','2003-01-01','2002-02-02',0)
insert into SANPHAM values (N'SP2','2003-01-01','2002-02-02',1)
insert into SANPHAM values (N'SP3','2003-01-01','2002-02-02',0)
insert into SANPHAM values (N'SP4','2003-01-01','2002-02-02',1)
insert into SANPHAM values (N'SP5','2003-01-01','2002-02-02',0)

insert into LOAISP values (N'LSP1','2003-01-01','2002-02-02',0)
insert into LOAISP values (N'LSP2','2003-01-01','2002-02-02',1)
insert into LOAISP values (N'LSP3','2003-01-01','2002-02-02',0)
insert into LOAISP values (N'LSP4','2003-01-01','2002-02-02',1)
insert into LOAISP values (N'LSP5','2003-01-01','2002-02-02',0)

insert into MONTHETHAO values (N'MTT1','2003-01-01','2002-02-02',0)
insert into MONTHETHAO values (N'MTT2','2003-01-01','2002-02-02',1)
insert into MONTHETHAO values (N'MTT3','2003-01-01','2002-02-02',0)
insert into MONTHETHAO values (N'MTT4','2003-01-01','2002-02-02',1)
insert into MONTHETHAO values (N'MTT5','2003-01-01','2002-02-02',0)


insert into KICHTHUOC values (N'KT1','2003-01-01','2002-02-02',0)
insert into KICHTHUOC values (N'KT2','2003-01-01','2002-02-02',0)
insert into KICHTHUOC values (N'KT3','2003-01-01','2002-02-02',1)
insert into KICHTHUOC values (N'KT4','2003-01-01','2002-02-02',1)
insert into KICHTHUOC values (N'KT5','2003-01-01','2002-02-02',0)

insert into CLB values ('1002',N'CLB1','2003-01-01','2002-02-02',0)
insert into CLB values ('1003',N'CLB2','2003-01-01','2002-02-02',1)
insert into CLB values ('1004',N'CLB3','2003-01-01','2002-02-02',1)
insert into CLB values ('1005',N'CLB4','2003-01-01','2002-02-02',0)
insert into CLB values ('1006',N'CLB5','2003-01-01','2002-02-02',0)

insert into HINHTHUCTHANHTOAN values (N'HTTT1','2003-01-01','2002-02-02',0)
insert into HINHTHUCTHANHTOAN values (N'HTTT2','2003-01-01','2002-02-02',1)
insert into HINHTHUCTHANHTOAN values (N'HTTT3','2003-01-01','2002-02-02',0)
insert into HINHTHUCTHANHTOAN values (N'HTTT4','2003-01-01','2002-02-02',1)
insert into HINHTHUCTHANHTOAN values (N'HTTT5','2003-01-01','2002-02-02',0)




select * from SANPHAM
select * from LOAISP
select * from MAUSAC
select * from KICHTHUOC
select * from CHATLIEU
select * from MONTHETHAO

insert into CHITIETSANPHAM values ('1002','1002','1002','1002','1002','1002','10','10000','2003-01-01','2002-02-02',0)
insert into CHITIETSANPHAM values ('1003','1003','1003','1003','1003','1003','11','10001','2003-01-01','2002-02-02',1)
insert into CHITIETSANPHAM values ('1004','1004','1004','1004','1004','1004','12','10002','2003-01-01','2002-02-02',1)
insert into CHITIETSANPHAM values ('1005','1005','1005','1005','1005','1005','13','10003','2003-01-01','2002-02-02',0)
insert into CHITIETSANPHAM values ('1006','1006','1006','1006','1006','1006','14','10004','2003-01-01','2002-02-02',0)

select * from ChucVu

insert into NHANVIEN values ('3',N'NV01',N'Ha Noi',0,N'nv1@gmail.com','0123456789','2022-02-02','2003-01-01','2002-02-02',0)
insert into NHANVIEN values ('4',N'NV02',N'Ha Tinh',0,N'nv2@gmail.com','0123456788','2021-02-02','2003-01-01','2002-02-02',1)
insert into NHANVIEN values ('5',N'NV03',N'Ha Nam',0,N'nv3@gmail.com','0123456787','2020-02-02','2003-01-01','2002-02-02',0)
insert into NHANVIEN values ('6',N'NV04',N'Soc Son',1,N'nv4@gmail.com','0123456786','2019-02-02','2003-01-01','2002-02-02',1)
insert into NHANVIEN values ('7',N'NV05',N'Nam Tu Liem',1,N'nv5@gmail.com','0123456785','2018-02-02','2003-01-01','2002-02-02',0)



insert into KHACHHANG values (N'KH01','2022-02-02',1,'0123456789',N'Ha Noi','2003-01-01','2002-02-02',0)
insert into KHACHHANG values (N'KH02','2021-02-02',0,'0123456788',N'Ha Nam','2003-01-01','2002-02-02',1)
insert into KHACHHANG values (N'KH03','2020-02-02',0,'0123456787',N'Ha tinh','2003-01-01','2002-02-02',1)
insert into KHACHHANG values (N'KH04','2019-02-02',0,'0123456786',N'Soc Son','2003-01-01','2002-02-02',0)
insert into KHACHHANG values (N'KH05','2018-02-02',1,'0123456785',N'Ham Tu liem','2003-01-01','2002-02-02',0)

insert into KHUYENMAI values (N'KM1','2018-02-02','2019-01-01',20000,'2003-01-01','2002-02-02',0)
insert into KHUYENMAI values (N'KM2','2018-02-02','2019-01-01',20001,'2003-01-01','2002-02-02',1)
insert into KHUYENMAI values (N'KM3','2018-02-02','2019-01-01',20002,'2003-01-01','2002-02-02',1)
insert into KHUYENMAI values (N'KM4','2018-02-02','2019-01-01',20003,'2003-01-01','2002-02-02',0)
insert into KHUYENMAI values (N'KM5','2018-02-02','2019-01-01',20004,'2003-01-01','2002-02-02',0)


select * from KHACHHANG
select * from NHANVIEN
select * from HINHTHUCTHANHTOAN
select * from KHUYENMAI

insert into HOADON values ('1','4','4','9',N'Hang Fake','1000000','2003-01-01','2002-02-02',0)
insert into HOADON values ('2','5','5','10',N'Hang Fake','1000001','2003-01-01','2002-02-02',0)
insert into HOADON values ('3','6','6','11',N'Hang ok','1000002','2003-01-01','2002-02-02',1)
insert into HOADON values ('4','7','7','12',N'deu lam dung mua','1000003','2003-01-01','2002-02-02',1)
insert into HOADON values ('5','8','8','13',N'Hang danh cho nguoi co ny','1000005','2003-01-01','2002-02-02',0)

select * from HOADON
select * from CHITIETSANPHAM

insert into HOADONCHITIET values ('1375328','5',100,'10000','2000','8000',N'ô s? kê','2003-01-01','2002-02-02',0)
insert into HOADONCHITIET values ('1375329','6',101,'10000','2000','8000',N'ô s? kê','2003-01-01','2002-02-02',0)
insert into HOADONCHITIET values ('1375330','7',102,'10000','2000','8000',N'ô s? kê','2003-01-01','2002-02-02',1)
insert into HOADONCHITIET values ('1375331','8',103,'10000','2000','8000',N'ô s? kê','2003-01-01','2002-02-02',1)
insert into HOADONCHITIET values ('1375332','9',104,'10000','2000','8000',N'ô s? kê','2003-01-01','2002-02-02',0)

select * from CHITIETSANPHAM
select * from HOADONCHITIET

insert into DoiTra values ('5','1',N'Không ?ng n?a','2002-02-02',0)
insert into DoiTra values ('6','2',N'L?i Nhà s?n xu?t','2002-02-02',0)
insert into DoiTra values ('7','3',N'Ch?a dùng ?ã h?ng','2002-02-02',1)
insert into DoiTra values ('8','4',N'Thích thì ??i','2002-02-02',1)
insert into DoiTra values ('9','5',N'Không ?ng n?a','2002-02-02',0)


select * from DoiTra
insert into THONGKE values ('1','1','1000000000','2002-02-02',0)
insert into THONGKE values ('2','2','1000000009','2002-02-03',1)
insert into THONGKE values ('3','3','1000000009','2002-02-04',1)
insert into THONGKE values ('4','4','1000999999','2002-02-05',1)
insert into THONGKE values ('5','5','1999999999','2002-02-06',0)


select * from ChucVu
insert into USERR values('0123456789','3',123)
insert into USERR values('0123456788','4',123)
insert into USERR values('0123456787','5',123)
insert into USERR values('0123456786','6',123)
insert into USERR values('0123456785','7',123)









































