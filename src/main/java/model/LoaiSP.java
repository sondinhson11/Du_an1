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
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author vuong
 */
@Entity
@Table(name = "LOAISP")
public class LoaiSP implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MaLoai")
    private Integer maLoai;
    
    @Column(name = "TenLoai")
    private String tenLoai;
    
    @Column(name = "NgayTao")
    private Date ngayTao;
    
    @Column(name = "NgaySua")
    private Date ngaySua;
    
    @Column(name = "TrangThai")
    private Integer TrangThai;

    @OneToMany(mappedBy = "loaiSP", fetch = FetchType.LAZY)
    private List<CHITIETSANPHAM> listChiTiet;

    public LoaiSP() {
    }

    public LoaiSP(Integer maLoai, String tenLoai, Date ngayTao, Date ngaySua, Integer TrangThai, List<CHITIETSANPHAM> listChiTiet) {
        this.maLoai = maLoai;
        this.tenLoai = tenLoai;
        this.ngayTao = ngayTao;
        this.ngaySua = ngaySua;
        this.TrangThai = TrangThai;
        this.listChiTiet = listChiTiet;
    }

    public Integer getMaLoai() {
        return maLoai;
    }

    public void setMaLoai(Integer maLoai) {
        this.maLoai = maLoai;
    }

    public String getTenLoai() {
        return tenLoai;
    }

    public void setTenLoai(String tenLoai) {
        this.tenLoai = tenLoai;
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
        return TrangThai;
    }

    public void setTrangThai(Integer TrangThai) {
        this.TrangThai = TrangThai;
    }

    public List<CHITIETSANPHAM> getListChiTiet() {
        return listChiTiet;
    }

    public void setListChiTiet(List<CHITIETSANPHAM> listChiTiet) {
        this.listChiTiet = listChiTiet;
    }

    @Override
    public String toString() {
        return tenLoai;
    }

    
}
