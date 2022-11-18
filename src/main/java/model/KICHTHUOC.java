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
@Table(name = "KICHTHUOC")
public class KICHTHUOC implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MaKichThuoc")
    private Integer maKichThuoc;

    @Column(name = "KichThuoc")
    private String kichThuoc;

    @Column(name = "NgayTao")
    private Date ngayTao;

    @Column(name = "NgaySua")
    private Date ngaySua;

    @Column(name = "TrangThai")
    private Integer trangThai;

    @OneToMany(mappedBy = "kichThuoc", fetch = FetchType.LAZY)
    private List<CHITIETSANPHAM> listChiTiet;

    public KICHTHUOC() {
    }

    public KICHTHUOC(Integer maKichThuoc, String kichThuoc, Date ngayTao, Date ngaySua, Integer trangThai, List<CHITIETSANPHAM> listChiTiet) {
        this.maKichThuoc = maKichThuoc;
        this.kichThuoc = kichThuoc;
        this.ngayTao = ngayTao;
        this.ngaySua = ngaySua;
        this.trangThai = trangThai;
        this.listChiTiet = listChiTiet;
    }

    public Integer getMaKichThuoc() {
        return maKichThuoc;
    }

    public void setMaKichThuoc(Integer maKichThuoc) {
        this.maKichThuoc = maKichThuoc;
    }

    public String getKichThuoc() {
        return kichThuoc;
    }

    public void setKichThuoc(String kichThuoc) {
        this.kichThuoc = kichThuoc;
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

    public List<CHITIETSANPHAM> getListChiTiet() {
        return listChiTiet;
    }

    public void setListChiTiet(List<CHITIETSANPHAM> listChiTiet) {
        this.listChiTiet = listChiTiet;
    }

    @Override
    public String toString() {
        return kichThuoc ;
    }

    
}
