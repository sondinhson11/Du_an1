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
@Table(name = "HINHTHUCTHANHTOAN")
public class HINHTHUCTHANHTOAN implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MaHTTT")
    private Integer maHTTT;
    
    @Column(name = "TenHTTT")
    private String tenHTTT;
    
    @Column(name = "NgayTao")
    private Date ngayTao;
    
    @Column(name = "NgaySua")
    private Date ngaySua;
    
    @Column(name = "TrangThai")
    private Integer TrangThai;
    
    @OneToMany(mappedBy = "HTTToan", fetch = FetchType.LAZY)
    private List<HoaDon> listHoaDon;

    public HINHTHUCTHANHTOAN(Integer maHTTT, String tenHTTT, Date ngayTao, Date ngaySua, Integer TrangThai, List<HoaDon> listHoaDon) {
        this.maHTTT = maHTTT;
        this.tenHTTT = tenHTTT;
        this.ngayTao = ngayTao;
        this.ngaySua = ngaySua;
        this.TrangThai = TrangThai;
        this.listHoaDon = listHoaDon;
    }

    public HINHTHUCTHANHTOAN() {
    }

    public List<HoaDon> getListHoaDon() {
        return listHoaDon;
    }

    public void setListHoaDon(List<HoaDon> listHoaDon) {
        this.listHoaDon = listHoaDon;
    }

    

    public Integer getMaHTTT() {
        return maHTTT;
    }

    public void setMaHTTT(Integer maHTTT) {
        this.maHTTT = maHTTT;
    }

    public String getTenHTTT() {
        return tenHTTT;
    }

    public void setTenHTTT(String tenHTTT) {
        this.tenHTTT = tenHTTT;
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

    @Override
    public String toString() {
        return tenHTTT;
    }
}
