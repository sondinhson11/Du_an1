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
@Table(name = "MauSac")
public class MauSac implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MaMauSac")
    private int MaMauSac;
    
    @Column(name = "TenMauSac")
    private String TenMauSac;
    
    @Column(name = "NgayTao")
    private Date NgayTao;
    
    @Column(name = "NgaySua")
    private Date NgaySua;
    
    @Column(name = "TrangThai")
    private Integer TrangThai;

    @OneToMany(mappedBy = "mauSac", fetch = FetchType.LAZY)
    private List<CHITIETSANPHAM> listChiTiet;

    public MauSac() {
    }

    public MauSac(int MaMauSac, String TenMauSac, Date NgayTao, Date NgaySua, Integer TrangThai, List<CHITIETSANPHAM> listChiTiet) {
        this.MaMauSac = MaMauSac;
        this.TenMauSac = TenMauSac;
        this.NgayTao = NgayTao;
        this.NgaySua = NgaySua;
        this.TrangThai = TrangThai;
        this.listChiTiet = listChiTiet;
    }

    public int getMaMauSac() {
        return MaMauSac;
    }

    public void setMaMauSac(int MaMauSac) {
        this.MaMauSac = MaMauSac;
    }

    public String getTenMauSac() {
        return TenMauSac;
    }

    public void setTenMauSac(String TenMauSac) {
        this.TenMauSac = TenMauSac;
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

    public List<CHITIETSANPHAM> getListChiTiet() {
        return listChiTiet;
    }

    public void setListChiTiet(List<CHITIETSANPHAM> listChiTiet) {
        this.listChiTiet = listChiTiet;
    }

    @Override
    public String toString() {
        return  TenMauSac ;
    }


}
