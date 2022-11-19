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

@Entity
@Table(name = "KhachHang")
public class KhachHang implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MaKH")
    private int ma;
    
    @Column(name = "TenKH")
    private String ten;
    
    @Column(name = "ngaySinh")
    private Date ngaySinh;
    
    @Column(name = "gioiTinh")
    private int gioiTinh;
    
    @Column(name = "soDienThoai")
    private String soDienThoai;
    
    @Column(name = "diaChi")
    private String diaChi;
    
    @Column(name = "ngayTao")
    private Date ngayTao;
    
    @Column(name = "ngaySua")
    private Date ngaySua;
    
    @Column(name = "trangThai")
    private int trangThai;
    
//    @OneToMany(mappedBy = "khachHang", fetch = FetchType.LAZY)
//    private List<HoaDon> listHoaDon;
    
    public KhachHang() {
    }

    public KhachHang(int ma, String ten, Date ngaySinh, int gioiTinh, String soDienThoai, String diaChi, Date ngayTao, Date ngaySua, int trangThai) {
        this.ma = ma;
        this.ten = ten;
        this.ngaySinh = ngaySinh;
        this.gioiTinh = gioiTinh;
        this.soDienThoai = soDienThoai;
        this.diaChi = diaChi;
        this.ngayTao = ngayTao;
        this.ngaySua = ngaySua;
        this.trangThai = trangThai;
    }

    public int getMa() {
        return ma;
    }

    public void setMa(int ma) {
        this.ma = ma;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public int getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(int gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
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

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }

    public String toString() {
        return ten;
    }

}
