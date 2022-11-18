/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
import java.sql.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
/**
 *
 * @author thean
 */
@Entity
@Table(name ="THONGKE")
public class ThongKe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="MaTK")
    private Integer maTK;
    
    @Column(name="MaHDCT")
    private Integer maHDCT;
    
    @Column(name="MaDT")
    private Integer maDT;
    
    @Column(name="TongTien")
    private Float monney;
    
    @Column(name="NgayBan")
    private Date ngayban;
    
    @Column (name="TrangThai")
    private int TrangThai;

    public ThongKe() {
    }

    public ThongKe(Integer maTK, Integer maHDCT, Integer maDT, Float monney, Date ngayban, int TrangThai) {
        this.maTK = maTK;
        this.maHDCT = maHDCT;
        this.maDT = maDT;
        this.monney = monney;
        this.ngayban = ngayban;
        this.TrangThai = TrangThai;
    }

    public Integer getMaTK() {
        return maTK;
    }

    public void setMaTK(Integer maTK) {
        this.maTK = maTK;
    }

    public Integer getMaHDCT() {
        return maHDCT;
    }

    public void setMaHDCT(Integer maHDCT) {
        this.maHDCT = maHDCT;
    }

    public Integer getMaDT() {
        return maDT;
    }

    public void setMaDT(Integer maDT) {
        this.maDT = maDT;
    }

    public Float getMonney() {
        return monney;
    }

    public void setMonney(Float monney) {
        this.monney = monney;
    }

    public Date getNgayban() {
        return ngayban;
    }

    public void setNgayban(Date ngayban) {
        this.ngayban = ngayban;
    }

    public int getTrangThai() {
        return TrangThai;
    }

    public void setTrangThai(int TrangThai) {
        this.TrangThai = TrangThai;
    }
    
}
