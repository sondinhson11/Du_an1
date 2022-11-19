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
@Table(name = "ChucVu")
public class ChucVu implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MaCV")
    private Integer MaCV;
    @Column(name = "TenCV")
    private String TenCV;
    @Column(name = "NgayTao")
    private Date NgayTao;
    @Column(name = "NgaySua")
    private Date NgaySua;
    @Column(name = "TrangThai")
    private Integer TrangThai;

    @OneToMany(mappedBy = "chucvu", fetch = FetchType.LAZY)
    private List<NhanVien> listNhanVien;

    public ChucVu() {
    }

    public ChucVu(Integer MaCV, String TenCV, Date NgayTao, Date NgaySua, Integer TrangThai, List<NhanVien> listNhanVien) {
        this.MaCV = MaCV;
        this.TenCV = TenCV;
        this.NgayTao = NgayTao;
        this.NgaySua = NgaySua;
        this.TrangThai = TrangThai;
        this.listNhanVien = listNhanVien;
    }

    public Integer getMaCV() {
        return MaCV;
    }

    public void setMaCV(Integer MaCV) {
        this.MaCV = MaCV;
    }

    public String getTenCV() {
        return TenCV;
    }

    public void setTenCV(String TenCV) {
        this.TenCV = TenCV;
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

    public List<NhanVien> getListNhanVien() {
        return listNhanVien;
    }

    public void setListNhanVien(List<NhanVien> listNhanVien) {
        this.listNhanVien = listNhanVien;
    }
    
    @Override
    public String toString() {
        return TenCV;
    }

}
