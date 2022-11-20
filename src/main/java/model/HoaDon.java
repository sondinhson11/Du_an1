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
@Table(name = "HoaDon")
public class HoaDon implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MaHD")
    private Integer MaHD;

    @ManyToOne
    @JoinColumn(name = "MaKH", nullable = false)
    private KhachHang khachHang;

    @ManyToOne
    @JoinColumn(name = "MaNV", nullable = false)
    private NhanVien nhanVien;

    @ManyToOne
    @JoinColumn(name = "MaHTTT", nullable = false)
    private HINHTHUCTHANHTOAN HTTToan;

    @ManyToOne
    @JoinColumn(name = "MaKM", nullable = false)
    private KhuyenMai khuyenMai;

    @Column(name = "GhiChu")
    private String GhiChu;

    @Column(name = "ThanhTien")
    private Float ThanhTien;

    @Column(name = "NgayTao")
    private Date NgayTao;

    @Column(name = "NgaySua")
    private Date NgaySua;

    @Column(name = "TrangThai")
    private Integer TrangThai;
    
    @OneToMany(mappedBy = "hoaDon", fetch = FetchType.LAZY)
    private List<HoaDonChiTiet> listChiTiet;

    public HoaDon() {
    }

    public HoaDon(Integer MaHD, Date NgayTao, NhanVien nhanVien,KhachHang khachHang) {
        this.MaHD = MaHD;
        this.khachHang = khachHang;
        this.nhanVien = nhanVien;
        this.NgayTao = NgayTao;
    }

    public HoaDon(Integer MaHD, KhachHang khachHang, NhanVien nhanVien, HINHTHUCTHANHTOAN hinhthucthanhtoan, KhuyenMai khuyenMai, String GhiChu, Float ThanhTien, Date NgayTao, Date NgaySua, Integer TrangThai) {
        this.MaHD = MaHD;
        this.khachHang = khachHang;
        this.nhanVien = nhanVien;
        this.HTTToan = hinhthucthanhtoan;
        this.khuyenMai = khuyenMai;
        this.GhiChu = GhiChu;
        this.ThanhTien = ThanhTien;
        this.NgayTao = NgayTao;
        this.NgaySua = NgaySua;
        this.TrangThai = TrangThai;
    }

    public Integer getMaHD() {
        return MaHD;
    }

    public void setMaHD(Integer MaHD) {
        this.MaHD = MaHD;
    }

    public KhachHang getKhachHang() {
        return khachHang;
    }

    public void setKhachHang(KhachHang khachHang) {
        this.khachHang = khachHang;
    }

    public NhanVien getNhanVien() {
        return nhanVien;
    }

    public void setNhanVien(NhanVien nhanVien) {
        this.nhanVien = nhanVien;
    }

    public HINHTHUCTHANHTOAN getHinhthucthanhtoan() {
        return HTTToan;
    }

    public void setHinhthucthanhtoan(HINHTHUCTHANHTOAN hinhthucthanhtoan) {
        this.HTTToan = hinhthucthanhtoan;
    }

    public KhuyenMai getKhuyenMai() {
        return khuyenMai;
    }

    public void setKhuyenMai(KhuyenMai khuyenMai) {
        this.khuyenMai = khuyenMai;
    }

    public String getGhiChu() {
        return GhiChu;
    }

    public void setGhiChu(String GhiChu) {
        this.GhiChu = GhiChu;
    }

    public Float getThanhTien() {
        return ThanhTien;
    }

    public void setThanhTien(Float ThanhTien) {
        this.ThanhTien = ThanhTien;
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

    @Override
    public String toString() {
        return MaHD.toString();
    }
    
}
