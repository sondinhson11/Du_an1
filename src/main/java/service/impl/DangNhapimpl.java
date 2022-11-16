package service.impl;

import java.util.ArrayList;
import model.DangNhap;
import model.NhanVien;
import repository.DangNhapRepository;
import service.DangNhapService;

public class DangNhapimpl implements DangNhapService{
    private DangNhapRepository dnrp;
    
    public DangNhapimpl(){
        this.dnrp = new DangNhapRepository();
    }
    @Override
    public DangNhap dangNhap(DangNhap dn){
        return this.dnrp.dangNhap(dn);
    }
    @Override
    public ArrayList<DangNhap> check(String maNV){
        return this.dnrp.check(maNV);
    }
    @Override
    public void insert(DangNhap dn){
        this.dnrp.insert(dn);
    }

    @Override
    public void update(DangNhap dn) {
        this.dnrp.update(dn);
    }
    public NhanVien checkMa(String manv){
        return this.dnrp.checkMa(manv);
    }
    public NhanVien checkChucVu(String Sdt){
        return this.dnrp.checkChucVu(Sdt);
    }
}
