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
@Table(name = "KHUYENMAI")
public class KhuyenMai implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MaKM")
    private Integer maKM;

    @Column(name="TenKM")
    private String TenKM;
    
    @Column(name="NgayBatDau")
    private Date NgayBD;
    
    @Column (name="NgayKetThuc")
    private Date NgayKT;
    
    @Column(name="GiamGia")
    private Float GiamGia;
    
    @Column (name="NgayTao")
    private Date NgayTao;
    
    @Column(name="NgaySua")
    private Date NgaySua;
    
    @Column(name="TrangThai")
    private Integer TrangThai;

    
    public KhuyenMai() {
    }

    public KhuyenMai(Integer maKM, String TenKM, Date NgayBD, Date NgayKT, Float GiamGia, Date NgayTao, Date NgaySua, Integer TrangThai) {
        this.maKM = maKM;
        this.TenKM = TenKM;
        this.NgayBD = NgayBD;
        this.NgayKT = NgayKT;
        this.GiamGia = GiamGia;
        this.NgayTao = NgayTao;
        this.NgaySua = NgaySua;
        this.TrangThai = TrangThai;
    }

    public Integer getMaKM() {
        return maKM;
    }

    public void setMaKM(Integer maKM) {
        this.maKM = maKM;
    }

    public String getTenKM() {
        return TenKM;
    }

    public void setTenKM(String TenKM) {
        this.TenKM = TenKM;
    }

    public Date getNgayBD() {
        return NgayBD;
    }

    public void setNgayBD(Date NgayBD) {
        this.NgayBD = NgayBD;
    }

    public Date getNgayKT() {
        return NgayKT;
    }

    public void setNgayKT(Date NgayKT) {
        this.NgayKT = NgayKT;
    }

    public Float getGiamGia() {
        return GiamGia;
    }

    public void setGiamGia(Float GiamGia) {
        this.GiamGia = GiamGia;
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
        return TenKM;
    }
}
