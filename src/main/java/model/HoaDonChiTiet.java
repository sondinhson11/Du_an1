/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author thean
 */
@Entity
@Table(name = "HoaDonChiTiet")
public class HoaDonChiTiet implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MaHDCT")
    private String MaHDCT;
    @ManyToOne
    @JoinColumn(name = "MaHD", nullable = false)
    private HoaDon hoaDon;

    @ManyToOne
    @JoinColumn(name = "MaCTSP", nullable = false)
    private CHITIETSANPHAM chitietsanpham;
    @Column(name = "SoLuong")
    private int soluong;

    @Column(name = "Gia")
    private Float gia;

    @Column(name = "GiamGia")
    private Float giamgia;

    @Column(name = "ThanhTien")
    private Float ThanhTien;

    @Column(name = "GhiChu")
    private String GhiChu;

    @Column(name = "NgayTao")
    private Date NgayTao;

    @Column(name = "NgaySua")
    private Date NgaySua;

    @Column(name = "TrangThai")
    private Integer TrangThai;

    public HoaDonChiTiet() {
    }

    public HoaDonChiTiet(String MaHDCT, HoaDon hoaDon, CHITIETSANPHAM chitietsanpham, int soluong, Float gia, Float giamgia, Float ThanhTien, String GhiChu, Date NgayTao, Date NgaySua, Integer TrangThai) {
        this.MaHDCT = MaHDCT;
        this.hoaDon = hoaDon;
        this.chitietsanpham = chitietsanpham;
        this.soluong = soluong;
        this.gia = gia;
        this.giamgia = giamgia;
        this.ThanhTien = ThanhTien;
        this.GhiChu = GhiChu;
        this.NgayTao = NgayTao;
        this.NgaySua = NgaySua;
        this.TrangThai = TrangThai;
    }

    public String getMaHDCT() {
        return MaHDCT;
    }

    public void setMaHDCT(String MaHDCT) {
        this.MaHDCT = MaHDCT;
    }

    public HoaDon getHoaDon() {
        return hoaDon;
    }

    public void setHoaDon(HoaDon hoaDon) {
        this.hoaDon = hoaDon;
    }

    public CHITIETSANPHAM getChitietsanpham() {
        return chitietsanpham;
    }

    public void setChitietsanpham(CHITIETSANPHAM chitietsanpham) {
        this.chitietsanpham = chitietsanpham;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    public Float getGia() {
        return gia;
    }

    public void setGia(Float gia) {
        this.gia = gia;
    }

    public Float getGiamgia() {
        return giamgia;
    }

    public void setGiamgia(Float giamgia) {
        this.giamgia = giamgia;
    }

    public Float getThanhTien() {
        return ThanhTien;
    }

    public void setThanhTien(Float ThanhTien) {
        this.ThanhTien = ThanhTien;
    }

    public String getGhiChu() {
        return GhiChu;
    }

    public void setGhiChu(String GhiChu) {
        this.GhiChu = GhiChu;
    }

    public Date getNgayTao() {
        return NgayTao;
    }

    public void setNgayTao(Date NgayTao) {
        this.NgayTao = NgayTao;
    }

    public Date getNgaySua() {
        return NgaySua;
    }

    public void setNgaySua(Date NgaySua) {
        this.NgaySua = NgaySua;
    }

    public Integer getTrangThai() {
        return TrangThai;
    }

    public void setTrangThai(Integer TrangThai) {
        this.TrangThai = TrangThai;
    }
    
}
