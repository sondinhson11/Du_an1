package model;

import java.sql.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "DoiTra")
public class DoiTra {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "maDT")
    private int maDT;
    
    @Column(name = "maCTSP")
    private int maCTSP;
    
    @Column(name = "maHDCT")
    private int maHDCT;
    
    @Column(name = "lyDo")
    private String lydo;
    
    @Column(name = "ngayDoi")
    private Date ngayDoi;
    
    @Column(name = "ngayBan")
    private Date ngayBan;
    
    @Column(name = "trangThai")
    private int trangThai;

    public DoiTra() {
    }

    public DoiTra(int maDT, int maCTSP, int maHDCT, String lydo, Date ngayDoi, Date ngayBan, int trangThai) {
        this.maDT = maDT;
        this.maCTSP = maCTSP;
        this.maHDCT = maHDCT;
        this.lydo = lydo;
        this.ngayDoi = ngayDoi;
        this.ngayBan = ngayBan;
        this.trangThai = trangThai;
    }

    public int getMaDT() {
        return maDT;
    }

    public void setMaDT(int maDT) {
        this.maDT = maDT;
    }

    public int getMaCTSP() {
        return maCTSP;
    }

    public void setMaCTSP(int maCTSP) {
        this.maCTSP = maCTSP;
    }

    public int getMaHDCT() {
        return maHDCT;
    }

    public void setMaHDCT(int maHDCT) {
        this.maHDCT = maHDCT;
    }

    public String getLydo() {
        return lydo;
    }

    public void setLydo(String lydo) {
        this.lydo = lydo;
    }

    public Date getNgayDoi() {
        return ngayDoi;
    }

    public void setNgayDoi(Date ngayDoi) {
        this.ngayDoi = ngayDoi;
    }

    public Date getNgayBan() {
        return ngayBan;
    }

    public void setNgayBan(Date ngayBan) {
        this.ngayBan = ngayBan;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }
    
    
}
