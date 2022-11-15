package service;

import java.util.ArrayList;
import model.DangNhap;

public interface DangNhapService {
    public DangNhap dangNhap(DangNhap dn);
    public ArrayList<DangNhap> check(String maNv);
    public void insert(DangNhap dn);
    public void update(DangNhap dn);
}
