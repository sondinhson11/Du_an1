package model;

import java.io.Serializable;
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
 * @author vuong
 */
@Entity
@Table(name = "CHITIETSANPHAM")
public class CHITIETSANPHAM implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MaCTSP")
    private Integer maCTSP;
    
    @Column(name = "SoLuong")
    private Integer soLuong;

    @Column(name = "Gia")
    private Integer gia;

    @Column(name = "NgayTao")
    private Date ngayTao;

    @Column(name = "NgaySua")
    private Date ngaySua;

    @Column(name = "TrangThai")
    private Integer trangThai;

    @ManyToOne
    @JoinColumn(name = "MaSP", nullable = false)
    private SanPham sanPham;

    @ManyToOne
    @JoinColumn(name = "MaLoai", nullable = false)
    private LoaiSP loaiSP;

    @ManyToOne
    @JoinColumn(name = "MaMauSac", nullable = false)
    private MauSac mauSac;

    @ManyToOne
    @JoinColumn(name = "MaKichThuoc", nullable = false)
    private KICHTHUOC kichThuoc;

    @ManyToOne
    @JoinColumn(name = "MaChatLieu", nullable = false)
    private CHATLIEU chatLieu;

    @ManyToOne
    @JoinColumn(name = "MaMTT", nullable = false)
    private MONTHETHAO monTT;

    public CHITIETSANPHAM() {
    }

    public CHITIETSANPHAM(Integer maCTSP, Integer soLuong, Integer gia, Date ngayTao, Date ngaySua, Integer trangThai, SanPham sanPham, LoaiSP loaiSP, MauSac mauSac, KICHTHUOC kichThuoc, CHATLIEU chatLieu, MONTHETHAO monTT) {
        this.maCTSP = maCTSP;
        this.soLuong = soLuong;
        this.gia = gia;
        this.ngayTao = ngayTao;
        this.ngaySua = ngaySua;
        this.trangThai = trangThai;
        this.sanPham = sanPham;
        this.loaiSP = loaiSP;
        this.mauSac = mauSac;
        this.kichThuoc = kichThuoc;
        this.chatLieu = chatLieu;
        this.monTT = monTT;
    }
    
    
    public Integer getMaCTSP() {
        return maCTSP;
    }

    public void setMaCTSP(Integer maCTSP) {
        this.maCTSP = maCTSP;
    }

    public Integer getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(Integer soLuong) {
        this.soLuong = soLuong;
    }

    public Integer getGia() {
        return gia;
    }

    public void setGia(Integer gia) {
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

    public SanPham getSanPham() {
        return sanPham;
    }

    public void setSanPham(SanPham sanPham) {
        this.sanPham = sanPham;
    }

    public LoaiSP getLoaiSP() {
        return loaiSP;
    }

    public void setLoaiSP(LoaiSP loaiSP) {
        this.loaiSP = loaiSP;
    }

    public MauSac getMauSac() {
        return mauSac;
    }

    public void setMauSac(MauSac mauSac) {
        this.mauSac = mauSac;
    }

    public KICHTHUOC getKichThuoc() {
        return kichThuoc;
    }

    public void setKichThuoc(KICHTHUOC kichThuoc) {
        this.kichThuoc = kichThuoc;
    }

    public CHATLIEU getChatLieu() {
        return chatLieu;
    }

    public void setChatLieu(CHATLIEU chatLieu) {
        this.chatLieu = chatLieu;
    }

    public MONTHETHAO getMonTT() {
        return monTT;
    }

    public void setMonTT(MONTHETHAO monTT) {
        this.monTT = monTT;
    }

    @Override
    public String toString() {
        return maCTSP.toString();
    }


}
