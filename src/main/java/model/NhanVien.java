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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
@Table(name = "NhanVien")
public class NhanVien  implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MaNv")
    private String maNv;
    
   @Column(name = "TenNV")
    private String tenNv;
   @Column(name = "DiaChi")
    private String diaChi;
   @Column(name = "GioiTinh")
    private int gioiTinh;
   @Column(name = "Email")
    private String email;
   @Column(name = "SoDienThoai")
    private String sdt;
   @Column(name = "NgaySinh")
    private Date ngaySinh;
   @Column(name = "NgayTao")
    private Date ngayTao;
   @Column(name = "NgaySua")
    private Date ngaySua;
   @Column(name = "TrangThai")
    private int trangThai;
   @ManyToOne
    @JoinColumn(name = "MaCV", nullable = false)
    private ChucVu chucvu;
    @OneToMany(mappedBy = "nhanVien", fetch = FetchType.LAZY)
    private List<HoaDon> listHoaDon;
    public NhanVien() {
    }

    public NhanVien(String maNv, String tenNv, String diaChi, int gioiTinh, String email, String sdt, Date ngaySinh, Date ngayTao, Date ngaySua, int trangThai, ChucVu chucvu) {
        this.maNv = maNv;
        this.tenNv = tenNv;
        this.diaChi = diaChi;
        this.gioiTinh = gioiTinh;
        this.email = email;
        this.sdt = sdt;
        this.ngaySinh = ngaySinh;
        this.ngayTao = ngayTao;
        this.ngaySua = ngaySua;
        this.trangThai = trangThai;
        this.chucvu = chucvu;
    }

    public String getMaNv() {
        return maNv;
    }

    public void setMaNv(String maNv) {
        this.maNv = maNv;
    }

    public String getTenNv() {
        return tenNv;
    }

    public void setTenNv(String tenNv) {
        this.tenNv = tenNv;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public int getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(int gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
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

    public ChucVu getChucvu() {
        return chucvu;
    }

    public void setChucvu(ChucVu chucvu) {
        this.chucvu = chucvu;
    }
    
   @Override
    public String toString() {
        return tenNv;
    }

    
    
    
    
}
