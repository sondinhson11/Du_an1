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
@Table(name = "CHATLIEU")
public class CHATLIEU implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MaChatLieu")
    private Integer maChatLieu;

    @Column(name = "TenChatLieu")
    private String tenChatLieu;

    @Column(name = "ngayTao")
    private Date ngayTao;

    @Column(name = "ngaySua")
    private Date ngaySua;

    @Column(name = "TrangThai")
    private int trangThai;

    @OneToMany(mappedBy = "chatLieu", fetch = FetchType.LAZY)
    private List<CHITIETSANPHAM> listChiTiet;

    public CHATLIEU(Integer maChatLieu, String tenChatLieu, Date ngayTao, Date ngaySua, int trangThai, List<CHITIETSANPHAM> listChiTiet) {
        this.maChatLieu = maChatLieu;
        this.tenChatLieu = tenChatLieu;
        this.ngayTao = ngayTao;
        this.ngaySua = ngaySua;
        this.trangThai = trangThai;
        this.listChiTiet = listChiTiet;
    }

    public CHATLIEU() {
    }

    public Integer getMaChatLieu() {
        return maChatLieu;
    }

    public void setMaChatLieu(Integer maChatLieu) {
        this.maChatLieu = maChatLieu;
    }

    public String getTenChatLieu() {
        return tenChatLieu;
    }

    public void setTenChatLieu(String tenChatLieu) {
        this.tenChatLieu = tenChatLieu;
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

    public List<CHITIETSANPHAM> getListChiTiet() {
        return listChiTiet;
    }

    public void setListChiTiet(List<CHITIETSANPHAM> listChiTiet) {
        this.listChiTiet = listChiTiet;
    }

    @Override
    public String toString() {
        return tenChatLieu;
    }
    

}
