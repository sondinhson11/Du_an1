/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.Serializable;
import java.sql.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author vuong
 */
@Entity
@Table(name = "CHITIETSANPHAM")
public class ChiTietSanPham implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MaCTSP")
    private Integer maCTSP;
    
    @Column(name = "MaSP")
    private Integer maSanPham;
   
    @Column(name = "MaLoai")
    private Integer maLoaiSanPham;
   
    @Column(name = "MaMauSac")
    private Integer maMauSac;
   
    @Column(name = "MaKichThuoc")
    private Integer maKichThuoc;
   
    @Column(name = "MaChatLieu")
    private Integer maChatLieu;
    
    @Column(name = "MaMTT")
    private Integer maMonTheThao;
    
    @Column(name = "SoLuong")
    private Integer soLuong;
    
    @Column(name = "Gia")
    private Double gia;
    
    @Column(name = "NgayTao")
    private Date ngayTao;
    
    @Column(name = "NgaySua")
    private Date ngaySua;
    
    @Column(name = "TrangThai")
    private Integer trangThai;

    public ChiTietSanPham() {
    }

    public ChiTietSanPham(Integer maCTSP, Integer maSanPham, Integer maLoaiSanPham, Integer maMauSac, Integer maKichThuoc, Integer maChatLieu, Integer maMonTheThao, Integer soLuong, Double gia, Date ngayTao, Date ngaySua, Integer trangThai) {
        this.maCTSP = maCTSP;
        this.maSanPham = maSanPham;
        this.maLoaiSanPham = maLoaiSanPham;
        this.maMauSac = maMauSac;
        this.maKichThuoc = maKichThuoc;
        this.maChatLieu = maChatLieu;
        this.maMonTheThao = maMonTheThao;
        this.soLuong = soLuong;
        this.gia = gia;
        this.ngayTao = ngayTao;
        this.ngaySua = ngaySua;
        this.trangThai = trangThai;
    }

    public Integer getMaCTSP() {
        return maCTSP;
    }

    public void setMaCTSP(Integer maCTSP) {
        this.maCTSP = maCTSP;
    }

    public Integer getMaSanPham() {
        return maSanPham;
    }

    public void setMaSanPham(Integer maSanPham) {
        this.maSanPham = maSanPham;
    }

    public Integer getMaLoaiSanPham() {
        return maLoaiSanPham;
    }

    public void setMaLoaiSanPham(Integer maLoaiSanPham) {
        this.maLoaiSanPham = maLoaiSanPham;
    }

    public Integer getMaMauSac() {
        return maMauSac;
    }

    public void setMaMauSac(Integer maMauSac) {
        this.maMauSac = maMauSac;
    }

    public Integer getMaKichThuoc() {
        return maKichThuoc;
    }

    public void setMaKichThuoc(Integer maKichThuoc) {
        this.maKichThuoc = maKichThuoc;
    }

    public Integer getMaChatLieu() {
        return maChatLieu;
    }

    public void setMaChatLieu(Integer maChatLieu) {
        this.maChatLieu = maChatLieu;
    }

    public Integer getMaMonTheThao() {
        return maMonTheThao;
    }

    public void setMaMonTheThao(Integer maMonTheThao) {
        this.maMonTheThao = maMonTheThao;
    }

    public Integer getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(Integer soLuong) {
        this.soLuong = soLuong;
    }

    public Double getGia() {
        return gia;
    }

    public void setGia(Double gia) {
        this.gia = gia;
    }

    public Date getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(Date ngayTao) {
        this.ngayTao = ngayTao;
    }

    public Date getNgaySua() {
        return ngaySua;
    }

    public void setNgaySua(Date ngaySua) {
        this.ngaySua = ngaySua;
    }

    public Integer getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(Integer trangThai) {
        this.trangThai = trangThai;
    }

   

}
